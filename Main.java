package MAIN;

import java.util.ArrayList;

import DAO.TaskDAO;
import DAO.UserDAO;
import MODEL.Task;
import MODEL.User;
import VIEW.Menu;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        UserDAO userDAO = new UserDAO();
        TaskDAO taskDAO = new TaskDAO();

        User currentUser = null;

        int userId = 1;
        int taskId = 1;

        while (true) {

            if (currentUser == null) {

                int choice = menu.mainMenu();

                switch (choice) {

                case 1:

                    String username = menu.inputString("Nhap username: ");
                    String email = menu.inputString("Nhap email: ");
                    String password = menu.inputString("Nhap password: ");

                    User user = new User(userId++, username, email, password);

                    if (userDAO.register(user)) {

                        menu.showMessage("Dang ky thanh cong.");

                    } else {

                        menu.showMessage("Email da ton tai.");

                    }

                    break;

                case 2:

                    email = menu.inputString("Nhap email: ");
                    password = menu.inputString("Nhap password: ");

                    currentUser = userDAO.login(email, password);

                    if (currentUser != null) {

                        menu.showMessage("Dang nhap thanh cong.");

                    } else {

                        menu.showMessage("Sai email hoac password.");

                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("===== GIOI THIEU =====");
                    System.out.println("He thong quan ly cong viec.");
                    System.out.println("Xay dung bang Java Console.");
                    break;

                case 4:

                    System.out.println();
                    System.out.println("===== HUONG DAN =====");
                    System.out.println("1. Dang ky tai khoan.");
                    System.out.println("2. Dang nhap.");
                    System.out.println("3. Quan ly cong viec.");
                    System.out.println("4. Dang xuat.");
                    break;

                case 5:

                    System.out.println();
                    System.out.println("===== THONG TIN HE THONG =====");
                    System.out.println("Version: 1.0");
                    System.out.println("Mo hinh MVC");
                    System.out.println("Ngon ngu: Java");
                    break;

                case 6:

                    System.out.println("Tam biet.");
                    System.exit(0);

                default:

                    System.out.println("Lua chon khong hop le.");

                }

            } else {

                int choice = menu.taskMenu();

                switch (choice) {

                case 1:

                    String title = menu.inputString("Nhap ten cong viec: ");
                    String description = menu.inputString("Nhap mo ta: ");

                    Task task = new Task(taskId++, title, description, "Chua hoan thanh", currentUser.getId());

                    taskDAO.addTask(task);

                    menu.showMessage("Them thanh cong.");

                    break;
                case 2:

                    ArrayList<Task> list = taskDAO.getAllTask(currentUser.getId());

                    if (list.isEmpty()) {

                        System.out.println("Khong co cong viec.");

                    } else {

                        System.out.println();
                        System.out.println("===== DANH SACH CONG VIEC =====");

                        for (Task t : list) {

                            System.out.println("----------------------------");
                            System.out.println("ID: " + t.getId());
                            System.out.println("Ten: " + t.getTitle());
                            System.out.println("Mo ta: " + t.getDescription());
                            System.out.println("Trang thai: " + t.getStatus());

                        }

                    }

                    break;

                case 3:

                    String keyword = menu.inputString("Nhap tu khoa: ");

                    ArrayList<Task> result = taskDAO.searchTask(keyword, currentUser.getId());

                    if (result.isEmpty()) {

                        System.out.println("Khong tim thay.");

                    } else {

                        System.out.println();
                        System.out.println("===== KET QUA TIM KIEM =====");

                        for (Task t : result) {

                            System.out.println("----------------------------");
                            System.out.println("ID: " + t.getId());
                            System.out.println("Ten: " + t.getTitle());
                            System.out.println("Mo ta: " + t.getDescription());
                            System.out.println("Trang thai: " + t.getStatus());

                        }

                    }

                    break;

                case 4:

                    int id = menu.inputInt("Nhap ID: ");

                    Task update = taskDAO.getTaskById(id);

                    if (update != null) {

                        update.setTitle(menu.inputString("Ten moi: "));
                        update.setDescription(menu.inputString("Mo ta moi: "));

                        taskDAO.updateTask(update);

                        menu.showMessage("Cap nhat thanh cong.");

                    } else {

                        menu.showMessage("Khong tim thay.");

                    }

                    break;

                case 5:

                    id = menu.inputInt("Nhap ID: ");

                    Task done = taskDAO.getTaskById(id);

                    if (done != null) {

                        done.setStatus("Da hoan thanh");

                        taskDAO.updateTask(done);

                        menu.showMessage("Cong viec da hoan thanh.");

                    } else {

                        menu.showMessage("Khong tim thay.");

                    }

                    break;

                case 6:

                    id = menu.inputInt("Nhap ID can xoa: ");

                    if (taskDAO.deleteTask(id)) {

                        menu.showMessage("Xoa thanh cong.");

                    } else {

                        menu.showMessage("Khong tim thay.");

                    }

                    break;
                case 7:

                    System.out.println();
                    System.out.println("===== THONG KE =====");

                    ArrayList<Task> tasks = taskDAO.getAllTask(currentUser.getId());

                    int total = tasks.size();
                    int completed = 0;
                    int unfinished = 0;

                    for (Task t : tasks) {

                        if (t.getStatus().equalsIgnoreCase("Da hoan thanh")) {

                            completed++;

                        } else {

                            unfinished++;

                        }

                    }

                    System.out.println("Tong cong viec: " + total);
                    System.out.println("Da hoan thanh: " + completed);
                    System.out.println("Chua hoan thanh: " + unfinished);

                    break;

                case 8:

                    System.out.println();
                    System.out.println("===== THONG TIN TAI KHOAN =====");
                    System.out.println("ID: " + currentUser.getId());
                    System.out.println("Username: " + currentUser.getUsername());
                    System.out.println("Email: " + currentUser.getEmail());

                    break;

                case 9:

                    currentUser = null;

                    menu.showMessage("Dang xuat thanh cong.");

                    break;

                default:

                    System.out.println("Lua chon khong hop le.");

                }

            }

        }

    }

}