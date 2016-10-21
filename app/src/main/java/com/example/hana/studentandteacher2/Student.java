package com.example.hana.studentandteacher2;

import java.util.ArrayList;

/**
 * Created by user pc on 20/10/2016.
 */
public class Student {
    private int No;
    private String Noreg;
    private String Name;
    private String Mail;
    private String Phone;

    public Student(int No, String Noreg, String Name, String Mail, String Phone){
        this.setNo(No);
        this.setNoreg(Noreg);
        this.setName(Name);
        this.setMail(Mail);
        this.setPhone(Phone);
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getNoreg() {
        return Noreg;
    }

    public void setNoreg(String noreg) {
        Noreg = noreg;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    /**public static ArrayList<Student> getStudent() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(2, "Hana Maulinda", "3145136193", "hanamaulinda@gmail.com", "081318400299"));
        studentList.add(new Student(3, "Dian Rakasiwi", "3145136194", "dianrakasiwi@gmail.com", "082233344555"));
        return studentList;
    }**/
}
