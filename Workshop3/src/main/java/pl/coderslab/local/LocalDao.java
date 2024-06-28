package pl.coderslab.local;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.utils.User;

import java.sql.*;
import java.util.Arrays;

public class LocalDao {
    private static final String CREATE_USER_QUERY = "INSERT INTO users(username, email, password) values (?, ?, ?)";
    private static final String READ_USER_BY_ID_QUERY = "SELECT * FROM users where id = ?";
    private static final String READ_USER_BY_EMAIL_QUERY = "SELECT * FROM users where email = ?";
    private static final String READ_USER_BY_NAME_QUERY = "SELECT * FROM users where username = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET email = ?, username=?, password = ? where id = ?;";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * from users";
    private static final String DELETE_USER_QUERY = "DELETE FROM users where id = ?";

    public User create(User user) {
        try (Connection connection = LocalDbUtil.connect()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_USER_QUERY,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User read(int userId){
        return getUser(String.valueOf(userId), READ_USER_BY_ID_QUERY);
    }

    public User readByEmail(String userEmail){
        return getUser(userEmail, READ_USER_BY_EMAIL_QUERY);
    }

    public User readByName(String userName){
        return getUser(userName, READ_USER_BY_NAME_QUERY);
    }

    private User getUser(String userParam, String QUERY) {
        try (Connection connection = LocalDbUtil.connect();
             PreparedStatement statement = connection.prepareStatement(QUERY)) {
            statement.setString(1, userParam);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setEmail(resultSet.getString("email"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            } else {
                System.out.println("No user with this id.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user) {
        try (Connection connection = LocalDbUtil.connect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_QUERY)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public User[] findAll() {
        try (Connection connection = LocalDbUtil.connect();
             PreparedStatement statementFind = connection.prepareStatement(FIND_ALL_USERS_QUERY);) {
            int userIdx = 0;
            User[] allUsers = new User[0];
            ResultSet resultSetFind = statementFind.executeQuery();
            while (resultSetFind.next()) {
                User user = new User();
                allUsers = Arrays.copyOf(allUsers, allUsers.length + 1);
                allUsers[userIdx] = user;
                user.setId(resultSetFind.getInt("id"));
                user.setEmail(resultSetFind.getString("email"));
                user.setUserName(resultSetFind.getString("username"));
                user.setPassword(resultSetFind.getString("password"));
                userIdx++;
            }
            return allUsers;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User[0];
    }

    public void delete(int userId) {
        try (Connection connection = LocalDbUtil.connect();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER_QUERY)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
