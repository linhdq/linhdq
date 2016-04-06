package com.example.linhdq.homework2;

import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by LinhDQ on 4/5/2016.
 */
public class Student_Management {
    private Student student;
    private ArrayList<Student> arrayList;

    public Student_Management() {
        arrayList = new ArrayList<>();
    }

    public Student_Management(Student student) {
        this.student = student;
    }

    public void addStudent(Student student) {
        arrayList.add(student);
    }

    public void removeStudent(Student student) {
        arrayList.remove(student);
    }

    public ArrayList<Student> getStudentList() {
        return arrayList;
    }

    public boolean writeToFile(Student student) {
        try {
            File f = new File(Environment.getExternalStorageDirectory(), "Student.txt");
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintWriter pw = new PrintWriter(fos);
            pw.print(student.getName() + " | " + student.getClasses() + " | " + student.getBirthday() + " | "
                   + student.getBirth_place() + " | " + student.getHobby() + " | " + student.getGender());
            pw.println();
            pw.close();
            return true;
        } catch (Exception ex) {
        }
        return false;
    }

    public String readFromFile(){
        String data="";
        try {
            File file=new File(Environment.getExternalStorageDirectory(),"Student.txt");
            RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");
            String line;
            while((line= randomAccessFile.readLine())!=null){
                data=data+line+" \n ";
            }
            randomAccessFile.close();
        }catch (Exception ex){
            ex.getMessage();
        }

        return data;
    }

    public boolean checkStudentInfor(String name, String classes, String birth_place) {
        if (name == null || name.trim().equals("")) {
            return false;
        }

        if (classes == null || classes.trim().equals("")) {
            return false;
        }

        if (birth_place == null || birth_place.trim().equals("")) {
            return false;
        }
        return true;
    }

    private static Student_Management inst;

    public static Student_Management getInstance() {
        if (inst == null) {
            inst = new Student_Management();
            return inst;
        }
        return inst;
    }
}
