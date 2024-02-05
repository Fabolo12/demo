package com.jr.module3.lesson11.command.commands;

import com.jr.module3.lesson11.command.systems.FileSystemReceiver;

public class OpenFileCommand implements Command {

    private final FileSystemReceiver fileSystem;

    public OpenFileCommand(FileSystemReceiver fs) {
        fileSystem = fs;
    }

    @Override
    public void execute() {
        fileSystem.openFile();
    }
}


