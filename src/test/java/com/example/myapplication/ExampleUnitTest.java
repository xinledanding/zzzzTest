package com.example.myapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExampleUnitTest {

    @Gender
    private String danding;

    @Test
    public void addition_isCorrect() throws Exception {
        List<String> names = new ArrayList<>();
        names.add("淡定1");
        names.add("淡定2");
        names.add("淡定3");

        System.out.println(names.subList(0 ,3)); ;
    }



}
