package com.jr.module2.lesson13;

public class Cat {
    public String catPublic;

    protected String catProtected;

    String catDefault;

    private String catPrivate;
}


class RedCat extends Cat {
    public String redCatPublic = "redCatPublic";

    protected String redCatProtected = "redCatProtected";

    String redCatDefault = "redCatDefault";

    private String redCatPrivate = "redCatPrivate";

    public void printInfo() {
        System.out.println("Cat info");
    }

    public void printInfo(final int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Cat info");
        }
    }

}