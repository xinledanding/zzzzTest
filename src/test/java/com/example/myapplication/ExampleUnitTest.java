package com.example.myapplication;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;
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
        String json = "{\"name\":\"怪盗kidou\",\"age\":\"24\"}";
        User user = new User();
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginObject(); // throws IOException
        while (reader.hasNext()) {
            String s = reader.nextName();
            switch (s) {
                case "name":
                    user.name = reader.nextString();
                    break;
                case "age":
                    user.age = reader.nextInt(); //自动转换
                    break;
                case "email":
                    user.email = reader.nextString();
                    break;
            }
        }
        reader.endObject(); // throws IOException
        System.out.println(user.name);  // 怪盗kidou
        System.out.println(user.age);   // 24
        System.out.println(user.email); // ikidou@example.com

        StringWriter out = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(out);
        jsonWriter.beginObject()
                .name("淡定").value("爱是肯德基")
                .name("淡定1").value("爱是肯德基1")
                .endObject()
                .flush();

        System.out.println("打定  === " + out.toString());
    }

}
