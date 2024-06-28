package pl.coderslab.local;

import pl.coderslab.utils.User;

public class MainLocalDao {
    public static void main(String[] args) {
        LocalDao localDao = new LocalDao();
        User createUser = new User("newUser2", "skrzynkapoczt2@gmail1.com", "okon");
//        localDao.create(createUser);

//        User readUser = localDao.read(16);
//        System.out.println(readUser);
//        readUser.setEmail("email@gmail.com");
//        readUser.setUserName("USER");
//        readUser.setPassword("haslo");
//        localDao.update(readUser);
//        User updateUser = localDao.read(16);
//        System.out.println(updateUser);
//
        User [] allUsers = localDao.findAll();
        System.out.println(String.format("Number of users = %d", allUsers.length));
        for (User user : allUsers){
            System.out.println(user);
        }
//
//        localDao.delete(13);
//        User[] usersAfterDelete = localDao.findAll();
//        System.out.println(String.format("Number of users after delete = %d", usersAfterDelete.length));
//        for (User user : allUsers){
//            System.out.println(user);
//        }


    }

}
