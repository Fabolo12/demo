package com.jr.module3.lesson11.command;

import com.jr.module3.lesson11.command.commands.CloseFileCommand;
import com.jr.module3.lesson11.command.commands.OpenFileCommand;
import com.jr.module3.lesson11.command.commands.WriteFileCommand;
import com.jr.module3.lesson11.command.systems.FileSystemReceiver;

public class Main {
    public static void main(String[] args) {
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();
        OpenFileCommand openFileCommand = new OpenFileCommand(fs);

        FileInvoker file = new FileInvoker(openFileCommand);
        file.execute();

        WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
        file = new FileInvoker(writeFileCommand);
        file.execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        file = new FileInvoker(closeFileCommand);
        file.execute();
    }
}
