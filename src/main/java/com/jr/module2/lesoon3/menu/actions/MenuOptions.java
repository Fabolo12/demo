package com.jr.module2.lesoon3.menu.actions;

public enum MenuOptions {
    SHOW_DATETIME("Show current date and time", new ShowTime()),
    SHOW_DATE("Show current date", new ShowDate()),
    EXIT("End program", new Exit())
    ;

    private final Action action;
    private final String name;

    MenuOptions(final String name, final Action action) {
        this.name = name;
        this.action = action;
    }

    public void exec() {
        action.exec();
    }

    @Override
    public String toString() {
        return name;
    }
}
