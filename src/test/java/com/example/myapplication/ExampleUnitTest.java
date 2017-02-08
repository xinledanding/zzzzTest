package com.example.myapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExampleUnitTest {

    @Gender
    private String danding;

    @Test
    public void addition_isCorrect() throws Exception {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("淡定 --  " + i);
        }
        System.out.println("哈哈 == " + danding);
    }

}
