package com.arin.thestudent.model;

public class Mahasiswa {
    private String username;
    private String fullname;
    private String nim;
    private String date;
    private String gender;
    private String address;
    private String email;
    private String phone;
    private String password;


    public Mahasiswa(String username, String fullname, String nim, String date, String gender, String address, String email, String phone, String password) {
        this.username = username;
        this.fullname = fullname;
        this.nim = nim;
        this.date = date;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Mahasiswa() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
