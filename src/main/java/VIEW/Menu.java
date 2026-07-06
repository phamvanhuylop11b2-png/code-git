package VIEW;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);

    public int mainMenu() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("      HE THONG QUAN LY CONG VIEC");
        System.out.println("======================================");
        System.out.println("1. Dang ky");
        System.out.println("2. Dang nhap");
        System.out.println("3. Gioi thieu");
        System.out.println("4. Huong dan su dung");
        System.out.println("5. Thong tin he thong");
        System.out.println("6. Thoat");
        System.out.print("Chon chuc nang: ");

        return Integer.parseInt(sc.nextLine());
    }

    public int taskMenu() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("         QUAN LY CONG VIEC");
        System.out.println("======================================");
        System.out.println("1. Them cong viec");
        System.out.println("2. Xem danh sach cong viec");
        System.out.println("3. Sua cong viec");
        System.out.println("4. Danh dau hoan thanh");
        System.out.println("5. Tim kiem cong viec");
        System.out.println("6. Xoa cong viec");
        System.out.println("7. Dang xuat");
        System.out.print("Chon chuc nang: ");

        return Integer.parseInt(sc.nextLine());
    }

    public String inputString(String message) {

        System.out.print(message);
        return sc.nextLine();

    }

    public int inputInt(String message) {

        System.out.print(message);
        return Integer.parseInt(sc.nextLine());

    }

    public void showMessage(String message) {

        System.out.println(message);

    }

}