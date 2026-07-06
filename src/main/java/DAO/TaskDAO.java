package DAO;

import java.util.ArrayList;
import MODEL.Task;

public class TaskDAO {

    private ArrayList<Task> tasks = new ArrayList<>();

    public boolean addTask(Task task) {

        tasks.add(task);

        return true;

    }

    public ArrayList<Task> getAllTask(int userId) {

        ArrayList<Task> list = new ArrayList<>();

        for (Task t : tasks) {

            if (t.getUserId() == userId) {

                list.add(t);

            }

        }

        return list;

    }

    public Task getTaskById(int id) {

        for (Task t : tasks) {

            if (t.getId() == id) {

                return t;

            }

        }

        return null;

    }

    public boolean updateTask(Task task) {

        for (int i = 0; i < tasks.size(); i++) {

            if (tasks.get(i).getId() == task.getId()) {

                tasks.set(i, task);

                return true;

            }

        }

        return false;

    }

    public boolean deleteTask(int id) {

        for (Task t : tasks) {

            if (t.getId() == id) {

                tasks.remove(t);

                return true;

            }

        }

        return false;

    }

    public ArrayList<Task> searchTask(String keyword, int userId) {

        ArrayList<Task> result = new ArrayList<>();

        for (Task t : tasks) {

            if (t.getUserId() == userId &&
                t.getTitle().toLowerCase().contains(keyword.toLowerCase())) {

                result.add(t);

            }

        }

        return result;

    }

}