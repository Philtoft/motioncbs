package application.client.rpc;

import application.shared.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

public interface RPCServiceAsync {

    void authorizeUser(String email, String password, AsyncCallback<User> asyncCallback)
            throws IllegalArgumentException;

    void createUser(User user, AsyncCallback<Boolean> asyncCallback) throws IllegalArgumentException;

    void getUsers(int userId, AsyncCallback<ArrayList<User>> asyncCallback) throws IllegalArgumentException;

}
