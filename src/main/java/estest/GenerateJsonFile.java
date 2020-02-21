package estest;

import com.alibaba.fastjson.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class GenerateJsonFile {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("data.json", true);
        for (int i = 1; i <= 100; i++) {
            JSONObject jsonObject = new JSONObject();
            JSONObject subJson = new JSONObject();
            subJson.put("_index", "test");
            subJson.put("_type", "test");
            subJson.put("_id", i + "");
            jsonObject.put("index", subJson);
            //System.out.println(jsonObject.toJSONString());
            String doc = "{ \"field1\" : \"value1\",\"field2\" : \"value2\",\"field3\" : \"value3\",\"field4\" : \"value4\",\"field5\" : \"value5\",\"field6\" : \"value6\" }";
            //System.out.println(doc);
            fileWriter.write(jsonObject.toJSONString() + "\n");
            fileWriter.write(doc + "\n");
        }
        fileWriter.close();
    }
}
