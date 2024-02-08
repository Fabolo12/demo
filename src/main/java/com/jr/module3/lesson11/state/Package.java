package com.jr.module3.lesson11.state;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Package {
    private PackageState state;

    Package(final PackageState state) {
        this.state = state;
    }

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}
