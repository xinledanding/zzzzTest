package com.example.myapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("淡定 --  " + i);
        }

        List<String> list2 = list.subList(0 , 5);
        list.remove(2);

        for (String content : list2) {
            System.out.println("nimei == " + content);
        }
    }
}
