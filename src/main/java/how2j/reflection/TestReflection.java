package how2j.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @program: mongomanager
 * @description: 通过反射创建对象
 * @author: WangPengfei
 * @create: 2019-03-25 16:29
 **/
public class TestReflection {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.name = "garren";
        try {
            Field field = h.getClass().getDeclaredField("name");
            field.set(h, "teemo");
            System.out.println(h.name);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}





