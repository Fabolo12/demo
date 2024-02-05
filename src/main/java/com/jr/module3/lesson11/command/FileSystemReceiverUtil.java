package com.jr.module3.lesson11.command;

import com.jr.module3.lesson11.command.systems.FileSystemReceiver;
import com.jr.module3.lesson11.command.systems.UnixFileSystemReceiver;
import com.jr.module3.lesson11.command.systems.WindowsFileSystemReceiver;

public class FileSystemReceiverUtil {
    public static FileSystemReceiver getUnderlyingFileSystem() {
        String osName = System.getProperty("os.name");
        System.out.println("Underlying OS is:" + osName);
        if (osName.contains("Windows")) {
            return new WindowsFileSystemReceiver();
        } else {
            return new UnixFileSystemReceiver();
        }
    }
}
