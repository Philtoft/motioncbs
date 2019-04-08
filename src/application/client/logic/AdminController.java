package application.client.logic;

import application.client.rpc.RPCServiceAsync;
import application.client.ui.ContentPanel;
import application.client.ui.admin.adminMainView.AdminMainView;
import application.shared.User;
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

        listProviderUsers = new ListDataProvider<>();

        adminMainView.getAdminMembersView().initUsersTable(listProviderUsers);

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

}
