package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Views view = new Views();
        do {

            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
            System.out.println("Chọn chức năng theo số(để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Tìm kiếm ");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi từ file ");
            System.out.println("8. Thoát ");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(scanner.next());
                if (choice > 0 && choice < 9) {
                    switch (choice) {
                        case 1:
                            view.showPhoneBookList();
                            break;
                        case 2:
                            view.addIntoPhoneBook();
                            break;
                        case 3:
                            view.update();
                            break;
                        case 4:
                            view.checkRemove();
                            break;
                        case 5:
                            view.checkPhoneBook();
                            break;
                        case 6:
                            view.readPhoneBookFromFile();
                            break;
                        case 7:
                            view.printPhoneBook();
                            break;
                    }
                } else if (choice == 8) {
                    System.out.println("Goodbye!");
                    break;
                } else
                    System.out.println("Nhập từ 0 đến 8");

            } catch (Exception e) {
                System.err.println("yêu cầu nhập số");
            }
        }
        while (true);

    }
    }

