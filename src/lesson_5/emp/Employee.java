package lesson_5;

import java.text.MessageFormat;

public class Employee {
    private String fio;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;

    public int getAge() {
        return age;
    }

    private int age;

    public Employee(String fio, String position, String email, String phoneNumber, double salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void printEmployee(){
        System.out.println(MessageFormat.format("{0} {1} {2} {3} {4} {5}", fio, position, email, phoneNumber, salary, age));
    }
}
