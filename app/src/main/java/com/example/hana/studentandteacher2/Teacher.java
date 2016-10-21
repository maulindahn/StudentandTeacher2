package com.example.hana.studentandteacher2;

import java.util.ArrayList;

/**
 * Created by user pc on 20/10/2016.
 */
public class Teacher {
    private int No;
    private String Nip;
    private String Name;
    private String Phone;
    private String Mail;

    public Teacher(int No, String Nip, String Name, String Phone, String Mail) {
        this.setNo(No);
        this.setNip(Nip);
        this.setName(Name);
        this.setPhone(Phone);
        this.setMail(Mail);
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getNip() {
        return Nip;
    }

    public void setNip(String nip) {
        Nip = nip;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    /**public static ArrayList<Teacher> getTeacher() {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(new Teacher(2, "Drs. Mulyono", "1234 5678 1234 567 890", "mulyono@gmail.com", "081388888888"));
        teacherList.add(new Teacher(3, "M. Eka Suryana", "1985 1223 2012 121 002", "mekas@gmail.com", "082299999999"));
        return teacherList;
    }**/
}
