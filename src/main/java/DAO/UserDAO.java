package DAO;

import java.util.ArrayList;
import MODEL.User;

public class UserDAO {

    private ArrayList<User> users = new ArrayList<>();

    public boolean register(User user) {

        for (User u : users) {

            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                return false;
            }

        }

        users.add(user);
        return true;

    }

    public User login(String email, String password) {

        for (User u : users) {

            if (u.getEmail().equalsIgnoreCase(email)
                    && u.getPassword().equals(password)) {

                return u;

            }

        }

        return null;

    }

    public ArrayList<User> getAllUsers() {

        return users;

    }

    public User getUserById(int id) {

        for (User u : users) {

            if (u.getId() == id) {

                return u;

            }

        }

        return null;

    }

    public boolean updateUser(User user) {

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == user.getId()) {

                users.set(i, user);

                return true;

            }

        }

        return false;

    }

    public boolean deleteUser(int id) {

        for (User u : users) {

            if (u.getId() == id) {

                users.remove(u);

                return true;

            }

        }

        return false;

    }

}