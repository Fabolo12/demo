package com.jr.module2.lesson13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        final Class<?> aClass = Class.forName("com.jr.module2.lesson13.Cat");

        final Cat cat = new Cat();
        final Class<? extends Cat> aClass1 = cat.getClass();
        final Cat redCat = new RedCat();
        final Class<? extends Cat> aClass2 = redCat.getClass();

        final Class<Cat> catClass = Cat.class;
        final Class<RedCat> redCatClass = RedCat.class;

        System.out.println("getFields");
        final Field[] fields1 = redCatClass.getFields();
        Arrays.stream(fields1)
                .map(Field::getName)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("getDeclaredFields");
        final Field[] fields2 = redCatClass.getDeclaredFields();
        Arrays.stream(fields2)
                .map(Field::getName)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("getModifiers");
        final Field field = fields2[3];
        field.setAccessible(true);
        System.out.println(field.getModifiers());
        System.out.println("Is private " + Modifier.isPrivate(field.getModifiers()));
        System.out.println("Value " + field.get(redCat));
        field.set(redCat, "NotRedCatPrivate");
        System.out.println("Value " + field.get(redCat));
        System.out.println("Type " + field.getType().getSimpleName());
        System.out.println();

        System.out.println("getDeclaredMethods");
        final Method[] declaredMethods = redCatClass.getDeclaredMethods();
        Arrays.stream(redCatClass.getDeclaredMethods())
                .map(Method::getName)
                .forEach(System.out::println);
        final Method declaredMethod0 = declaredMethods[0];
        System.out.println("Invoke method");
        declaredMethod0.invoke(redCat);
        final Method declaredMethod1 = declaredMethods[1];
        declaredMethod1.invoke(redCat, 2);
        Arrays.stream(declaredMethod1.getParameters())
                .map(Parameter::getType)
                .map(Class::getSimpleName)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Create object");
        System.out.println(redCatClass.newInstance());
        final Constructor<?>[] constructors = redCatClass.getDeclaredConstructors();
        System.out.println("Constructors length " + constructors.length);
        final RedCat newRedCat = (RedCat) constructors[0].newInstance();
        System.out.println(newRedCat.redCatPublic);

        final Constructor<RedCat> constructor = redCatClass.getConstructor();
        final RedCat redCat1 = constructor.newInstance();

    }
}
