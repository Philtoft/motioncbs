package application.client.logic;

import application.client.rpc.RPCService;
import application.client.rpc.RPCServiceAsync;
import application.client.ui.ContentPanel;
import application.client.ui.admin.adminMainView.AdminMainView;
import application.shared.User;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    private User currentUser;
    // If already logged in as admin, the users won't be loaded again
    private boolean loggedIn;

    private ContentPanel contentPanel;
    private RPCServiceAsync rpcService;
    private AdminController adminController;

    // En list data provider, der indeholder en ArrayList med Users som skal bruges til DataGrid
    private ListDataProvider<User> ListProviderUsers;

    public MainController(ContentPanel contentPanel, RPCServiceAsync rpcService) {

        this.contentPanel = contentPanel;
        this.rpcService = rpcService;
        this.loggedIn = false;

        this.adminController = new AdminController(contentPanel, rpcService);

        ListProviderUsers = new ListDataProvider<>();

        bindHandlers();

    }

    public void bindHandlers()  {
        contentPanel.getGuestView().addClickHandlers(new GuestLoginClickHandler());
        contentPanel.getLoginView().getLoginBtn().addClickHandler(new LoginClickHandler());
        contentPanel.getLoginView().getForgotPassword().addClickHandler(new ForgotPasswordClickHandler());
        contentPanel.getGuestView().getSignUp1().addClickHandler(new SignUpPage());
        contentPanel.getGuestView().getSignUp2().addClickHandler(new SignUpPage());
        contentPanel.getCreateView().addClickHandler(new CreateAccount());
    }

    /**
     * Skifter til login-siden
     */
    class GuestLoginClickHandler implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            contentPanel.changeView(contentPanel.getLoginView());
        }
    }

    /**
     * Logger ind
     */
    class LoginClickHandler implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {

            String email = contentPanel.getLoginView().getEmailTxtBox().getText();
            String password = contentPanel.getLoginView().getPasswordTxtBox().getText();

            rpcService.authorizeUser(email, password, new AsyncCallback<User>() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert(caught.getMessage());
                }

                @Override
                public void onSuccess(User user) {
                    if (user == null) {
                        Window.alert("Forkert email eller password");
                    } else {
                        contentPanel.getLoginView().clearTextBoxFields();

                        // If the users aren't admin
                        if (user.getMembertypeId() != 4) {
                            contentPanel.changeView(contentPanel.getUserMainView());
                        } // Else if the users are admin
                        else if (user.getMembertypeId() == 4) {
                            // If first time logged ind. Load users
                            if (!loggedIn) {
                                adminController.loadUser(user);
                                loggedIn = true;
                            }
                            contentPanel.changeView(contentPanel.getAdminMainView());
                        }
                    }
                }
            });

        }
    }

    /**
     * Sender en mail med password
     */
    class ForgotPasswordClickHandler implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            String mail = Window.prompt("Indtast din mail", "");
            if (!mail.isEmpty()) {
                Window.alert("Vi har sendt en mail til " + mail + " med din adgangskode");
            }
        }
    }

    /**
     * Skifter til tilmeldingssiden fra forsiden
     */
    class SignUpPage implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            contentPanel.changeView(contentPanel.getCreateView());
        }
    }

    /**
     * Den nye bruger laves her
     */
    class CreateAccount implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {

            String fname = contentPanel.getCreateView().getFname().getText();
            String lname = contentPanel.getCreateView().getLname().getText();
            String email = contentPanel.getCreateView().getEmail().getText();
            String password = contentPanel.getCreateView().getPassword().getText();
            String zipCode = contentPanel.getCreateView().getAddress().getText();
            String phoneNumber = contentPanel.getCreateView().getPhoneNumber().getText();
            String ageString = contentPanel.getCreateView().getAge().getText();
            String gender = "";
            int memberId = 0;

            if(contentPanel.getCreateView().getGenderMaleBtn().getValue() == true) {
                gender = "m";
            } else if (contentPanel.getCreateView().getGenderFemaleBtn().getValue() == true) {
                gender = "f";
            }

            if (contentPanel.getCreateView().getMemberGold().getValue() == true) {
                memberId = 1;
            } else if (contentPanel.getCreateView().getMemberSilver().getValue() == true) {
                memberId = 2;
            } else if (contentPanel.getCreateView().getMemberBronze().getValue() == true) {
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

                rpcService.createUser(user, new AsyncCallback<Boolean>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Noget gik galt");
                    }

                    @Override
                    public void onSuccess(Boolean created) {
                        if (!created) {
                            Window.alert("Brugeren kunne ikke oprettes");
                        } else {

                            ListProviderUsers.getList().add(user);
                            Window.alert("Tillykke - du er nu blevet oprettet som medlem hos MotionCBS");
                            contentPanel.changeView(contentPanel.getLoginView());

                        }
                    }
                });

            }

        }
    }

}
