package com.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created by Fant.J.
 */
public class Third_1 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Fant.J",20));
        int result = 0;
        for (Student student:list){
            if (student.getAge()>18){
                result++;
            }
        }
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            if (student.getAge()>18){
                result++;
            }
        }

        long count = list.stream().filter(student -> student.getAge() > 18).count();

        List<String> collect = Stream.of("a", "b", "c").collect(Collectors.toList());
        List<String> streamMap = Stream.of("a", "b", "c").map(String -> String.toUpperCase()).collect(Collectors.toList());
        List<String> collect1 = Stream.of("a", "ab", "abc")
                .filter(value -> value.contains("b"))
                .collect(Collectors.toList());

        List<Integer> collect2 = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Student student1 = list.stream()
                .min(Comparator.comparing(Student::getAge))
                .get();

        Student student = list.stream().max(Comparator.comparing(Student::getAge)).get();


        Integer reduce = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        System.out.println(reduce);
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
}
