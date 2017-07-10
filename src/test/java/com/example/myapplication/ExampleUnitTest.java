package com.example.myapplication;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExampleUnitTest {

    @Gender
    private String danding;

    @Test
    public void addition_isCorrect() throws Exception {
        Map<String ,List<String>> maps = new HashMap<>();
        Set<Map.Entry<String, List<String>>> entries = maps.entrySet();
        System.out.println("" + entries);
    }



}
