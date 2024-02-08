package com.jr.module3.lesson11.state;

public interface PackageState {
    void next(Package pkg);
    void prev(Package pkg);
    void printStatus();
}
