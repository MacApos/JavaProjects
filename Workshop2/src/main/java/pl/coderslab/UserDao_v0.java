package pl.coderslab;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.entity.DbUtil;
import pl.coderslab.entity.User;

import java.sql.*;

public class UserDao_v0 {
    private static final String CREATE_USER_QUERY = "INSERT INTO users(username, email, password) values (?, ?, ?)";
    private static final String READ_USER_QUERY = "SELECT * FROM users where userParam = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET email = ?, username=?, password = ? where id = ?;";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * from users";
    private static final String COUNT_ALL_USERS_QUERY = "SELECT count(*) as count from users";
    private static final String DELETE_USER_QUERY = "DELETE FROM users where id = ?";

    public User create(User user) {
        try (Connection connection = DbUtil.connect()) {
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

//    NIE TAK
    public User read(String userParam, String condition) {
        try (Connection connection = DbUtil.connect()) {
            PreparedStatement statement = connection.prepareStatement(
                    READ_USER_QUERY.replace("userParam", selectParam(userParam)),
                    Statement.RETURN_GENERATED_KEYS);
            if (userParam.equals("id")) {
                try {
                    int userId = Integer.parseInt(condition);
                    statement.setInt(1, userId);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException();
                }
            } else {
                statement.setString(1, condition);
            }

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setEmail(resultSet.getString("email"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String selectParam(String userParam) {
        switch (userParam) {
            case "id":
                return "id";
            case "email":
                return "email";
            case "username":
                return "username";
            case "password":
                return "password";
            default:
                throw new IllegalArgumentException("Illegal parameter");
        }
    }

    public void update(User user) {
        try (Connection connection = DbUtil.connect()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_QUERY);
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
        try (Connection connection = DbUtil.connect()) {
            PreparedStatement statementCount = connection.prepareStatement(COUNT_ALL_USERS_QUERY);
            PreparedStatement statementFind = connection.prepareStatement(FIND_ALL_USERS_QUERY);


//            NIE TAK - rozszerzanie tablicy o 1, inaczej można też lokować pamięć w tablicy w sposób logarytmiczny
//            przy wywoływaniu count w międzyczasie mogą być wstawiane dane do bazy, jak już robić w ten sposób to transkacja
//            begin, rollback
            ResultSet resultSetCount = statementCount.executeQuery();
            int count = 0;
            while (resultSetCount.next()) {
                count = resultSetCount.getInt("count");
            }

            User[] allUsers = new User[count];
            ResultSet resultSetFind = statementFind.executeQuery();

            int userIdx = 0;
            while (resultSetFind.next()) {
                User user = new User();
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
//        W ten sposób nie trzeba obsługiwać błędów z nullem
        return new User[0];
    }

    public void delete(int userId) {
        try (Connection connection = DbUtil.connect()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private boolean checkPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}
