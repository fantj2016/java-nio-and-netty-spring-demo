package com.lambda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by Fant.J.
 */
public class Third_3_8 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Fant.J",18));
        students.add(new Student("小明",19));
        students.add(new Student("小王",20));
        students.add(new Student("小李",22));
        List<Class> classList = new ArrayList<>();
        classList.add(new Class(students,"1601"));
        classList.add(new Class(students,"1602"));

        List<String> list= students.stream()
                                    .filter(student -> student.getAge() > 18)
                                    .map(Student::getName)
                                    .collect(Collectors.toList());


        List<String> nameList = new ArrayList<>();
        for (Class c:classList){
            for (Student student:c.getStudents()){
                if (student.getAge()>18){
                    String name = student.getName();
                    nameList.add(name);
                }
            }
        }

        List<String> collect = classList.stream()
                .flatMap(aclass -> aclass.getStudents().stream())
                .filter(student -> student.getAge() > 18)
                .map(Student::getName)
                .collect(toList());

        System.out.println(collect);


        classList.stream().forEach(aClass -> aClass.getStudents().stream());

        //报错
//        ActionEvent localEvent = null;
//        Button button = new Button();
//        button.addActionListener(e->{
//            localEvent = e;
//        });
    }

    static class Student{
        private String name;
        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    static class Class{
        private List<Student> students;
        private String className;

        public Class(List<Student> students, String className) {
            this.students = students;
            this.className = className;
        }

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }
    }
}
