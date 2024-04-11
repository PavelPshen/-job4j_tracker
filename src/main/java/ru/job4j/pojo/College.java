package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student pavel = new Student();
        pavel.setFullName("Pavel Vladimirovich Pshenitsyn");
        pavel.setGroupNumber(9495);
        pavel.setEnteredDate("01.09.2009");
        System.out.println("Student: " + pavel.getFullName() + System.lineSeparator() + "group: " + pavel.getGroupNumber() + System.lineSeparator() + "date: " + pavel.getEnteredDate());
    }
}
