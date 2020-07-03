package com.company;

import java.util.ArrayList;


public class Student {

    private int matrixNo,age;
    private String name;
    private double weight;
    private static ArrayList<Student> studentList= new ArrayList<>();

    public Student(int matrixNo, int age, String name, double weight) {
        this.matrixNo = matrixNo;
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    public String toString(){
        return matrixNo+" "+name+" "+age+" "+weight;
    }

    public static void main(String[] args) {

//        Student student1 = new Student(1,15,"Ali",55);
//        Student student2 = new Student(3,15,"Abu",60);
//        Student student3 = new Student(4,15,"AhChong",50);
//        Student student4 = new Student(2,15,"Alan",45);
//
//        studentList.add(student1);
//        studentList.add(student2);
//        studentList.add(student3);
//        studentList.add(student4);
//
//        for (int i=0;i<studentList.size();i++){
//
//            Student temp = studentList.get(i);
//            for (int j=1;j>0 && temp<=studentList.indexOf();j--){
//
//
//                if (first.getMatrixNo()>second.getMatrixNo()){
//                    Student temp= studentList.get(i);
//                    studentList.set(i,studentList.get(j));
//                    studentList.set(j,temp);
//                }
//
//                Student first = studentList.get(j);
//                Student second = studentList.get(j);
//            }
//        }
//
//        for (Student student:studentList){
//            System.out.println(student);
//        }
//
    }
//
//    public int getMatrixNo() {
//        return matrixNo;
//    }
}
