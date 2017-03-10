package com.example.myapplication;

import org.junit.Test;

public class ExampleUnitTest {

    @Gender
    private String danding;

    @Test
    public void addition_isCorrect() throws Exception {

        try {
            System.out.println("333");
            return;
        }catch (Exception e) {
            System.out.println("22");

        } finally {
            System.out.println("1111");
            return;
        }

    }

}
