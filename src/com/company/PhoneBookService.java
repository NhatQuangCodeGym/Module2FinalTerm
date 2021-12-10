package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookService {
    List<PhoneBook> phoneBookList = new ArrayList<>();

    //    1. Xem danh sách
    public List<PhoneBook> getPhoneList(){
    return phoneBookList;
    }
//    2. Them 1 mục danh bạ mới
    public void addPhoneBook(PhoneBook danhba){
        phoneBookList.add(danhba);
    }
//    3. Cập nhật thông tin danh bạ
public PhoneBook getPhone(String phone) {
    for (PhoneBook phoneBook : phoneBookList) {
        if (phoneBook.getPhonenumber().equals(phone))
            return phoneBook;
    }
    return null;
}
public void update(String phone, String group, String name, String gender, String address, String dob, String email) {
    PhoneBook phoneBook = getPhone(phone);
    phoneBook.setGroup(group);
    phoneBook.setFullName(name);
    phoneBook.setGender(gender);
    phoneBook.setAddress(address);
    phoneBook.setBirthday(dob);
    phoneBook.setEmail(email);
    System.out.println("Updated");
}
//    4. Xoá danh bạ theo số điện thoại
    public boolean removePhoneBook(String number){
        ArrayList<PhoneBook> listremove = new ArrayList<>();
        for (PhoneBook danhba: phoneBookList) {
            if(danhba.getPhonenumber()== number)
                listremove.add(danhba);
        }
        boolean check = phoneBookList.removeAll(listremove);
        return check;
    }
//    5. Tim danh ba theo sđt hoặc họ tên
public boolean isExistPhone(String Phone) {
    return findUserName(Phone) != null;
}
    public PhoneBook findUserPhone(String number){
        for( PhoneBook danhba : phoneBookList){
            if(danhba.getPhonenumber().equals(number)){
                return danhba;
            }
        }return null;
    }
    public boolean isExistName(String name) {
        return findUserName(name) != null;
    }
    public PhoneBook findUserName(String name){
        for (PhoneBook ten :phoneBookList){
            if(ten.getFullName().equals(name)){
                return ten;
            }
        }return null;
    }
//    6. Đọc danh bạ từ file CSV
public  List<PhoneBook> readPhoneBook(File file) {
    List<PhoneBook> phoneList = new ArrayList<>();
    try {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/contacts.csv"));
        while ((line = bufferedReader.readLine()) != null) {
            String data[] = line.split(",");
            String phoneNumber = data[0];
            String group = data[1];
            String name = data[2];
            String gender = data[3];
            String address = data[4];
            String birthday = data[5];
            String email = data[6];
            phoneList.add(new  PhoneBook(phoneNumber,group,name,gender,address,birthday,email));
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return phoneList;
}
//    7. Lưu danh bạ file csv
public static void WritePhoneBook(String path, List<PhoneBook> list) {
    String a = null;
    try {
        FileWriter writer = new FileWriter(path, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (PhoneBook danhba : list) {
            a = String.format("%s,%s,%s,%s,%s,%s,%s,%s", danhba.getPhonenumber(), danhba.getGroup(), danhba.getFullName(), danhba.getGender(), danhba.getAddress(),danhba.getBirthday(),danhba.getEmail());
            bufferedWriter.write(a);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    }

