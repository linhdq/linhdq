package com.example.linhdq.homework;

import java.util.ArrayList;

/**
 * Created by LinhDQ on 4/7/2016.
 */
public class EmployeeManager {
    private ArrayList<Employee> arrayList;

    public EmployeeManager() {
        arrayList = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        arrayList.add(e);
    }

    public void removeEmployee(Employee e) {
        arrayList.remove(e);
    }

    public ArrayList<Employee> getEmployees() {
        return this.arrayList;
    }

    private static EmployeeManager inst;

    public static EmployeeManager getInst() {
        if (inst == null) {
            inst = new EmployeeManager();
            return inst;
        }
        return inst;
    }
}
