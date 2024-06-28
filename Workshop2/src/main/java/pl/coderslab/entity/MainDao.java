package pl.coderslab.entity;

public class MainDao {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User createUser = new User("newUser2", "skrzynkapoczt2@gmail1.com", "okon");
        userDao.create(createUser);

        User readUser = userDao.read(16);
        System.out.println(readUser);
        readUser.setEmail("email@gmail.com");
        readUser.setUserName("USER");
        readUser.setPassword("haslo");
        userDao.update(readUser);
        User updateUser = userDao.read(16);
        System.out.println(updateUser);

        User [] allUsers = userDao.findAll();
        System.out.println(String.format("Number of users = %d", allUsers.length));
        for (User user : allUsers){
            System.out.println(user);
        }

        userDao.delete(13);
        User[] usersAfterDelete = userDao.findAll();
        System.out.println(String.format("Number of users after delete = %d", usersAfterDelete.length));
        for (User user : allUsers){
            System.out.println(user);
        }


    }

}
