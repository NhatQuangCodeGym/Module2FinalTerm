package com.company;

import java.util.ArrayList;
import java.util.List;

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
    public void updatePhoneList(String number){


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
    public PhoneBook findUserPhone(String number){
        for( PhoneBook danhba : phoneBookList){
            if(danhba.getPhonenumber().equals(number)){
                return danhba;
            }
        }return null;
    }
    public PhoneBook findUserName(String name){
        for (PhoneBook ten :phoneBookList){
            if(ten.getFullName().equals(name)){
                return ten;
            }
        }return null;
    }
//    6. Đọc danh bạ từ file CSV
    }

