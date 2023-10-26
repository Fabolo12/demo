package com.jr.module2.lesson4;

import com.jr.module2.lesson5.Cat;

public class Test extends Cat {
    private void testMethod() {
        method1();
//        method2();
        method3();
    }
}

class Test1 {
    private void testMethod() {
        final Cat cat = new Cat();
        cat.method1();
//        cat.method2();
//        cat.method3();
    }
}



