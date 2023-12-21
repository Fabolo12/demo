package com.jr.module2.lesson17;

import com.jr.module2.lesson17.creators.HorseCreator;
import com.jr.module2.lesson17.creators.OrganismCreator;
import com.jr.module2.lesson17.service.Lifecycle;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new Lifecycle().life();
    }
}
