package com.jr.module3.lesson11.command;

import com.jr.module3.lesson11.command.commands.Command;

public class FileInvoker {
    private Command command;

    public FileInvoker(Command c) {
        command = c;
    }

    public void execute() {
        command.execute();
    }
}
