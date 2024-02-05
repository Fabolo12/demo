package com.jr.module3.lesson11.decorator.version1;

import com.jr.module3.lesson11.decorator.version1.decorators.BubbleLights;
import com.jr.module3.lesson11.decorator.version1.decorators.Snow;

public class Main { // TODO 05/02/24 find other version of pattern
    public static void main(String[] args) {
        ChristmasTree tree1 = new ChristmasTreeImpl();
        System.out.println(tree1.decorate());

        ChristmasTree tree2 = new BubbleLights(tree1);
        System.out.println(tree2.decorate());

        ChristmasTree tree3 = new Snow(tree2);
        System.out.println(tree3.decorate());

        ChristmasTree tree4 = new BubbleLights(tree3);
        System.out.println(tree4.decorate());
    }
}
