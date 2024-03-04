package object;

public class ObjectAddress {

    public static void main(String[] args) {
        User user = new User("Suresh");
        System.out.println(user + " - " + user.name);

        updateUser(user);
        System.out.println(user + " - " + user.name);
    }

    private static void updateUser(User user) {
        User newUser = new User("Rakesh");
        user = newUser;
    }

    private static class User {
        String name;

        User(String name) {
            this.name = name;
        }
    }

}


