package com.jr.module3.lesson11.command.commands;

import com.jr.module3.lesson11.command.systems.FileSystemReceiver;

public class WriteFileCommand implements Command {

    private final FileSystemReceiver fileSystem;

    public WriteFileCommand(FileSystemReceiver fs) {
        fileSystem = fs;
    }

    @Override
    public void execute() {
        fileSystem.writeFile();
    }

}
