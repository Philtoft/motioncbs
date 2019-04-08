package application.server;

import application.shared.User;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import application.client.rpc.RPCService;

import java.sql.*;
import java.util.ArrayList;

public class RPCServiceImpl extends RemoteServiceServlet implements RPCService {

    /*
     * The url, username and password for the database. The password is not necessarily
     * the same pass as your computer password
     */
    private static final String URL = "jdbc:mysql://localhost:3306/motioncbs?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    /**
     * The constructor which is creating the connection the the database
     */
    public RPCServiceImpl() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * A method which is used for closing the connection
     */
    private static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method is used for the login by authorizing the email and password in the database
     */
    @Override
    public User authorizeUser(String email, String password) throws IllegalArgumentException {
        ResultSet resultSet = null;
        User user = null;

        try {
            PreparedStatement authorizeUser = connection
                    .prepareStatement("SELECT * FROM members where email = ? AND password = ?");

            authorizeUser.setString(1, email);
            authorizeUser.setString(2, password);

            resultSet = authorizeUser.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setMembertypeId(resultSet.getInt("membertype_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                close();
            }
        }
        return user;
    }

    /**
     * Method used when creating a new member
     */
    @Override
    public boolean createUser(User user) throws IllegalArgumentException {
        try {
            PreparedStatement createUser = connection.prepareStatement("INSERT INTO `members` (`id`, `fname`, `lname`, `email`, `password`, `zipCode`, `phoneNumer`, `gender`, `age`, `membertype_id`, `signup_date`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)");

            createUser.setString(1, user.getFname());
            createUser.setString(2, user.getLname());
            createUser.setString(3, user.getEmail());
            createUser.setString(4, user.getPassword());
            createUser.setString(5, user.getZipCode());
            createUser.setString(6, user.getPhoneNumber());
            createUser.setString(7, user.getGender());
            createUser.setString(8, user.getAge());
            createUser.setInt(9, user.getMembertypeId());

            int rowsAffected = createUser.executeUpdate();

            if (rowsAffected == 1) return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method that gets all the users
     */
    @Override
    public ArrayList<User> getUsers(int id) throws IllegalArgumentException {
        ResultSet resultSet = null;
        ArrayList<User> users = new ArrayList<>();

        try {

            PreparedStatement getUsers = connection.prepareStatement("SELECT * FROM members WHERE membertype_id != 4");

            resultSet = getUsers.executeQuery();

            while(resultSet.next()) {

                User user = new User();
                user.setFname(resultSet.getString("fname"));
                user.setLname(resultSet.getString("lname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setZipCode(resultSet.getString("zipCode"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setGender(resultSet.getString("gender"));
                user.setAge(resultSet.getString("age"));
                user.setMembertypeId(resultSet.getInt("membertype_id"));

                users.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                close();
            }
        }

        return users;
    }

}