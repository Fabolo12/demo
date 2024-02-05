package com.jr.module3.lesson11.decorator.version1.decorators;

import com.jr.module3.lesson11.decorator.version1.ChristmasTree;

public class TreeDecorator implements ChristmasTree {

    private final ChristmasTree tree;

    public TreeDecorator(final ChristmasTree tree) {
        this.tree = tree;
    }

    @Override
    public String decorate() {
        return tree.decorate();
    }
}
