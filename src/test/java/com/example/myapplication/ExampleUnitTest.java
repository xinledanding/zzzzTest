package com.example.myapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleUnitTest {

    @Gender
    private String danding;

    @Test
    public void addition_isCorrect() throws Exception {

        List<String> names = new ArrayList<>();
        names.add("阿萨德撒");
        names.add("阿萨德撒");
        names.add("阿萨德撒");
        names.add("阿萨德撒");
        names.addAll(Collections.EMPTY_LIST);
    }

}
