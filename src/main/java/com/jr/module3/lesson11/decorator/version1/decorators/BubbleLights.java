package com.jr.module3.lesson11.decorator.version1.decorators;

import com.jr.module3.lesson11.decorator.version1.ChristmasTree;

public class BubbleLights extends TreeDecorator {
    public BubbleLights(final ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateSpecific();
    }

    private String decorateSpecific() {
        return " with Bubble Lights";
    }
}
