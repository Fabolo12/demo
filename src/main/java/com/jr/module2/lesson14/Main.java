package com.jr.module2.lesson14;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

interface Markered {

}

@Deprecated
public class Main implements Cloneable, Markered {

    @Deprecated
    private String name;

    @Deprecated
    @SuppressWarnings(value = "")
    public static void main(@Deprecated String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        final List<Object> objects1 = List.of();
        final List<Object> objects2 = Collections.emptyList();
        final List<Object> objects3 = new ArrayList<>();

        final List<Object> collect1 = objects3.stream().collect(Collectors.toList());
        final List<Object> collect2 = objects3.stream().toList();
        collect1.add(new Object());

        final List<Student> students = List.of(
                new Student(),
                new Student(),
                new Student(),
                new Student(),
                new Student(),
                new Student()
        );

//        imperativeStyle(students);
//        declarativeStyle(students);
        processAnnotation();
    }

    private static void processAnnotation() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Class<Calc> calcClass = Calc.class;
        final Set<Field> collect = Arrays.stream(calcClass.getFields())
                .filter(field -> field.getAnnotation(MyAnnotation.class) != null)
                .collect(Collectors.toSet());
        if (collect.isEmpty()) {
            return;
        }
        final Calc calc = calcClass.getDeclaredConstructor().newInstance();
        for (Field field : collect) {
            final boolean isInt = field.getType().getSimpleName().equals("int");
            final boolean isInteger = field.getType().getSimpleName().equals("Integer");
            if (isInt || isInteger) {
                final MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
                final int i = annotation.defaultNumber();
                field.setAccessible(true);
                field.set(calc, i);
            }
        }
        System.out.println(calc);
    }

    private static void declarativeStyle(final List<Student> students) {
        final List<Student> newStudents = students.stream()
                .filter(student -> student.mark > 5)
                .toList();
        System.out.println(newStudents);
    }

    private static void imperativeStyle(final List<Student> students) {
        final List<Student> newStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.mark > 5) {
                newStudents.add(student);
            }
        }
        System.out.println(newStudents);
    }
}

class Student {
    int mark = new Random().nextInt(10);

    @Override
    public String toString() {
        return "Student{" +
                "mark=" + mark +
                '}';
    }
}

class ClassToJson {
    public void send(Object object, String to) {

    }

    @SuppressWarnings("unchecked")
    public void send(Markered object, String to) {
        List<String> list = (List<String>) new ArrayList();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@interface MyAnnotation {
    int defaultNumber() default 10;
}

class Calc {
    @MyAnnotation
    public String field1;

    @MyAnnotation(defaultNumber = 150)
    public int field2;

    @MyAnnotation
    public Integer field3;
    public int field4;

    @Override
    public String toString() {
        return "Calc{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3=" + field3 +
                ", field4=" + field4 +
                '}';
    }
}

//@Data
class StudentToShow {
    String field1;
    String field2;
    String field3;
    String field4;
    String field5;

   /* StudentToShow() {
    }

    StudentToShow(final String field1, final String field2, final String field3, final String field4, final String field5) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
    }

    String getField1() {
        return field1;
    }

    void setField1(final String field1) {
        this.field1 = field1;
    }

    String getField2() {
        return field2;
    }

    void setField2(final String field2) {
        this.field2 = field2;
    }

    String getField3() {
        return field3;
    }

    void setField3(final String field3) {
        this.field3 = field3;
    }

    String getField4() {
        return field4;
    }

    void setField4(final String field4) {
        this.field4 = field4;
    }

    String getField5() {
        return field5;
    }

    void setField5(final String field5) {
        this.field5 = field5;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final StudentToShow that = (StudentToShow) object;

        if (!Objects.equals(field1, that.field1)) return false;
        if (!Objects.equals(field2, that.field2)) return false;
        if (!Objects.equals(field3, that.field3)) return false;
        if (!Objects.equals(field4, that.field4)) return false;
        return Objects.equals(field5, that.field5);
    }

    @Override
    public int hashCode() {
        int result = field1 != null ? field1.hashCode() : 0;
        result = 31 * result + (field2 != null ? field2.hashCode() : 0);
        result = 31 * result + (field3 != null ? field3.hashCode() : 0);
        result = 31 * result + (field4 != null ? field4.hashCode() : 0);
        result = 31 * result + (field5 != null ? field5.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentToShow{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }*/
}