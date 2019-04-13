package application.client.rpc;

import application.shared.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

@RemoteServiceRelativePath("MySampleApplicationService")
public interface RPCService extends RemoteService {

    User authorizeUser(String username, String password) throws IllegalArgumentException;

    boolean createUser (User user) throws IllegalArgumentException;

    ArrayList<User> getUsers (int userId) throws IllegalArgumentException;

    boolean deleteUser(User user) throws IllegalArgumentException;

}
