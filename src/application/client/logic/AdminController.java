package application.client.logic;

import application.client.rpc.RPCServiceAsync;
import application.client.ui.ContentPanel;
import application.client.ui.admin.adminCreateMembersView.AdminCreateMembersView;
import application.client.ui.admin.adminMainView.AdminMainView;
import application.shared.User;
import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;

import java.util.ArrayList;

public class AdminController {

    private ContentPanel content;
    private RPCServiceAsync rpcServiceAsync;
    private AdminMainView adminMainView;

    private User currentUser;

    // A List Data Provider which contains an ArrayList with users is used for the DataGrid
    private ListDataProvider<User> listProviderUsers;

    public AdminController(ContentPanel content, RPCServiceAsync rpcServiceAsync) {
        this.content = content;
        this.adminMainView = content.getAdminMainView();
        this.rpcServiceAsync = rpcServiceAsync;

        bindHandlers();

        listProviderUsers = new ListDataProvider<>();

        adminMainView.getAdminMembersView().initUsersTable(listProviderUsers);



    }

    public void bindHandlers() {
        adminMainView.addClickHandler(new MenuClickHandler());
        adminMainView.getAdminMembersView().addClickHandler(new DeleteUserHandler());
        adminMainView.getAdminCreateMembersView().addClickHandler(new CreateUser());
        adminMainView.getAdminMembersView().addClickHandler(new DeleteUserHandler());
    }

    public void loadUser(User currentUser) {
        this.currentUser = currentUser;
        loadTables();
    }

    public void loadTables() {
        rpcServiceAsync.getUsers(1, new AsyncCallback<ArrayList<User>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Kunne ikke loade brugerne");
            }

            @Override
            public void onSuccess(ArrayList<User> users) {
                listProviderUsers.getList().addAll(users);
            }
        });
    }

    class MenuClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == adminMainView.getLogOutBtn()) {
                content.changeView(content.getGuestView());
            } else if (event.getSource() == adminMainView.getMembersBtn()) {
                adminMainView.changeView(adminMainView.getAdminMembersView());
            } else if (event.getSource() == adminMainView.getNewUserBtn()) {
                adminMainView.changeView(adminMainView.getAdminCreateMembersView());
            } else if (event.getSource() == adminMainView.getStatsBtn()) {
                adminMainView.changeView(adminMainView.getAdminStatisticsView());
            }
        }

    }

    class CreateUser implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {

            String fname = adminMainView.getAdminCreateMembersView().getFname().getText();
            String lname = adminMainView.getAdminCreateMembersView().getLname().getText();
            String email = adminMainView.getAdminCreateMembersView().getEmail().getText();
            String password = adminMainView.getAdminCreateMembersView().getPassword().getText();
            String zipCode = adminMainView.getAdminCreateMembersView().getAddress().getText();
            String phoneNumber = adminMainView.getAdminCreateMembersView().getPhoneNumber().getText();
            String ageString = adminMainView.getAdminCreateMembersView().getAge().getText();
            String gender = "";
            int memberId = 0;

            if(adminMainView.getAdminCreateMembersView().getGenderMaleBtn().getValue() == true) {
                gender = "m";
            } else if (adminMainView.getAdminCreateMembersView().getGenderFemaleBtn().getValue() == true) {
                gender = "f";
            }

            if (adminMainView.getAdminCreateMembersView().getMemberGold().getValue() == true) {
                memberId = 1;
            } else if (adminMainView.getAdminCreateMembersView().getMemberSilver().getValue() == true) {
                memberId = 2;
            } else if (adminMainView.getAdminCreateMembersView().getMemberBronze().getValue() == true) {
                memberId = 3;
            }

            if (password.length() > 4) {

                // User skal være FINAL, da den bliver tilføjet til listen af brugere i RPC callback
                final User user = new User();
                user.setFname(fname);
                user.setLname(lname);
                user.setEmail(email);
                user.setPassword(password);
                user.setZipCode(zipCode);
                user.setPhoneNumber(phoneNumber);
                user.setGender(gender);
                user.setMembertypeId(memberId);
                user.setAge(ageString);

                rpcServiceAsync.createUser(user, new AsyncCallback<Boolean>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Noget gik galt");
                    }

                    @Override
                    public void onSuccess(Boolean created) {
                        if (!created) {
                            Window.alert("Brugeren kunne ikke oprettes");
                        } else {
                            Window.alert("Brugeren blev oprettet");
                            listProviderUsers.getList().add(user);
                            adminMainView.getAdminCreateMembersView().clearTextboxFields();
                        }
                    }
                });

            }

        }
    }

    class DeleteUserHandler implements ActionCell.Delegate<User> {
        @Override
        public void execute(User user) {
            Window.alert("test");

/*
            //Admin bliver spurgt om han er sikker på at han vil slette brugeren
            boolean deleteUser = Window.confirm("Er du sikker på at du vil slette " + user.getName() + " som bruger?");

            //Hvis ja, laves der et RPC kald som gennem serveren sletter brugeren i databasen
            if(deleteUser){
                rpcServiceAsync.deleteUser(user, new AsyncCallback<Boolean>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Kunne ikke slette deltageren");
                    }

                    @Override
                    public void onSuccess(Boolean deleted) {
                        if(deleted){
                            Window.alert("Følgende deltager er slettet fra holdet og systemet: \n" + user.getName());
                            listProviderUsers.getList().remove(user);
                            listProviderUsers.refresh();
                        } else {
                            Window.alert("Brugeren blev ikke slettet");
                        }
                    }
                });

            } else {
                Window.alert("Brugeren blev ikke slettet");
            }
            */
        }
    }

//    class DeleteUserHandler implements ActionCell.Delegate<User> {
//
//        @Override
//        public void execute(final User user) {
//
//            //First that is executed is a confirmation window to delete the user
//            boolean deleteUserConfirmed = Window.confirm("Er du sikker på, at du vil slette: " + user.getName());
//            Window.alert(user.getId() + "");
//            //If its confirmed a RPC call will be made so the user is deleted in the database
//            if (deleteUserConfirmed) {
//                rpcServiceAsync.deleteUser(user.getId(), new AsyncCallback<Boolean>() {
//
//                    /*
//                     * Handles error from callback function
//                     */
//                    @Override
//                    public void onFailure(Throwable caught) {
//                        Window.alert("Noget gik galt");
//                    }
//
//                    /*
//                     * Handles success response from callback
//                     * The callback returns either true or false depending if the user
//                     * were deleted or not
//                     */
//                    @Override
//                    public void onSuccess(Boolean isDeleted) {
//                        if (!isDeleted) {
//                            Window.alert("Could not delete user");
//                        } else {
//                            // If the user is deleted the user will be removed from the list of users
//                            listProviderUsers.getList().remove(user);
//                        }
//
//                    }
//                });
//            }
//        }
//    }

}
