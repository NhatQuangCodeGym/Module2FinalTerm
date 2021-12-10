package com.company;

public class PhoneBook {
    private String Phonenumber;
    private String Group;
    private String FullName;
    private String Gender;
    private String Address;
    private String Birthday;
    private String Email;

    public PhoneBook(String phonenumber, String group, String fullName, String gender, String address, String birthday, String email) {
        Phonenumber = phonenumber;
        Group = group;
        FullName = fullName;
        Gender = gender;
        Address = address;
        Birthday = birthday;
        Email = email;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "Phonenumber='" + Phonenumber + '\'' +
                ", Group='" + Group + '\'' +
                ", FullName='" + FullName + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Address='" + Address + '\'' +
                ", Birthday='" + Birthday + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}


