import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public String addUser(String name, String email, String role) {
        User user = new User(name, email, role);
        users.add(user);
        return "Пользователь " + name + " успешно добавлен.";
    }

    public String removeUser(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                users.remove(user);
                return "Пользователь с email " + email + " успешно удалён.";
            }
        }
        return "Пользователь с email " + email + " не найден.";
    }

    public String updateUser(String email, String name, String role) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                if (name != null) {
                    user.setName(name);
                }
                if (role != null) {
                    user.setRole(role);
                }
                return "Пользователь с email " + email + " успешно обновлён.";
            }
        }
        return "Пользователь с email " + email + " не найден.";
    }

    public String listUsers() {
        if (users.isEmpty()) {
            return "Пользователи не найдены.";
        }
        StringBuilder userList = new StringBuilder();
        for (User user : users) {
            userList.append(user).append("\n");
        }
        return userList.toString();
    }

    public static void main(String[] args) {
        UserManager manager = new UserManager();
        System.out.println(manager.addUser("Куаныш", "kuanysh@example.com", "Admin"));
        System.out.println(manager.addUser("Нурхан", "nurhan@example.com", "User"));
        System.out.println(manager.listUsers());
        System.out.println(manager.updateUser("nurhan@example.com", null, "Admin"));
        System.out.println(manager.removeUser("kuanysh@example.com"));
        System.out.println(manager.listUsers());
    }
}
