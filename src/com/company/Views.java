package com.company;

import Regex.RegexEmail;
import Regex.RegexPhone;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Views {
    private final PhoneBookService phoneBookService = new PhoneBookService();
    private RegexPhone regexPhone;
    private RegexEmail regexEmail;
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
        System.out.println(" Nhập vào ngày sinh: ");
        String birthday = scanner.nextLine();
        System.out.println(" Nhập vào Email: ");
        String email = scanner.nextLine();
        phoneBookService.addPhoneBook(new PhoneBook(number,group,fullName,gender,address,birthday,email));
    }
//    3. Sửa thông tin danh bạ
public void update() {
        Scanner scanner = new Scanner(System.in);
        regexEmail = new RegexEmail();
        regexPhone = new RegexPhone();
        try {
            do {
                System.out.println("Enter phone number to update: ");
                String phone = scanner.nextLine();
                if (regexPhone.validate(phone)) {
                    if (!phoneBookService.isExistPhone(phone))
                        System.out.println("Phone number not found");
                    else {
                        System.out.println("Enter group: ");
                        String group = scanner.nextLine();
                        System.out.println("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter gender: ");
                        String gender = scanner.nextLine();
                        System.out.println("Enter address: ");
                        String address = scanner.nextLine();
                        System.out.println("Enter day of birthday: ");
                        String dob = scanner.nextLine();
                        System.out.println("Enter email: ");
                        String email = scanner.nextLine();
                        if (regexEmail.validate(email)) {
                            phoneBookService.update(phone, group, name, gender, address, dob, email);
                            break;
                        } else
                            System.out.println("Email invalid");
                    }
                } else
                    System.out.println("Phone invalid");
            } while (true);
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
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
//    6. Đọc danh bạ từ file
        public  void readPhoneBookFromFile(){
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
            File file = new File(path);
            List<PhoneBook> student = phoneBookService.readPhoneBook(file);
            System.out.println(student);
        }
//    7. Lưu danh bạ vào file CSV
    public void printPhoneBook(){
        List<PhoneBook> lists = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String path = "data/contacts.csv";
        phoneBookService.WritePhoneBook(path,lists);
    }

}
