package com.example.myapplication;

import org.junit.Test;

public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        if(Danding.isOK) {
            System.out.println("danding");
        }
    }

}


class Danding {
    public static boolean isOK = true;
    static {
        isOK = false;
    }
}