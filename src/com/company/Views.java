package com.company;

import java.util.List;
import java.util.Scanner;

public class Views {
    private final PhoneBookService phoneBookService = new PhoneBookService();
//1. Hiển thị danh bạ
    public void showPhoneBookList(){
        List<PhoneBook> list = phoneBookService.getPhoneList();
        for ( PhoneBook danhba : list ){
            System.out.println(danhba.toString());
        }
    }
//2. Thêm một mục danh bạ
    public void addIntoPhoneBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại:");
        String number = scanner.nextLine();
        System.out.println("Nhập nhóm của người dùng:");
        String group = scanner.nextLine();
        System.out.println("Nhập Họ tên:");
        String fullName = scanner.nextLine();
        System.out.println("Nhập giới tính:");
        String gender = scanner.nextLine();
        System.out.println(" Nhập địa chỉ:");
        String address = scanner.nextLine();
        phoneBookService.addPhoneBook(new PhoneBook(number,group,fullName,gender,address));
    }
//    3. Sửa thông tin danh bạ
//    4. Xoá danh bạ
    public void checkRemove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nhập vào sđt bạn muốn xoá: ");
        String number = scanner.nextLine();
        phoneBookService.removePhoneBook(number);
        if(phoneBookService.removePhoneBook(number)){
            System.out.println("Danh bạ có sđt " + number + " đã bị xoá khỏi danh sách");
        } else
            System.out.println(" không tìm được danh bạ với số điện thoại trên");
    }
//    5.  Tìm kiếm danh bạ theo sđt hoặc họ tên
    public void checkPhoneBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Chọn nhập vào sđt hoặc tên  ");
        System.out.println(" 1. Nhập sđt");
        System.out.println("2. Nhập tên");
        String choice = scanner.nextLine();
        if(choice == "1"){
            System.out.println("Nhập vào sđt bạn muốn tìm");
            String number = scanner.nextLine();
            PhoneBook phoneBook = phoneBookService.findUserPhone(number);
            if( phoneBook != null){
                System.out.println("Có sđt: " + phoneBook );
            }else
                System.out.println(" Không có sđt như trên trong danh bạ");
        }else {
            System.out.println(" Nhập vào tên người dùng ");
            String name = scanner.nextLine();
            PhoneBook phoneBook = phoneBookService.findUserName(name);
            if( phoneBook != null){
                System.out.println("Có sđt: " + phoneBook );
            }else
                System.out.println(" Không có sđt như trên trong danh bạ");

        }
    }
}
