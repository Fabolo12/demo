package com.jr.module3.lesson1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        final Student student = new Student("no test");
        student.setName("test");
        System.out.println(student.getName());
        System.out.println(student);
        System.out.println(new Student());
        try {
            TimeUnit.MILLISECONDS.sleep(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private String name;
}


@Data
class Student1 {

}

@Value
class Student2 {

}