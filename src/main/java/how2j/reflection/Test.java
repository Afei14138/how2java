package how2j.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @program: mongomanager
 * @description: 测试反射的用途
 * @author: WangPengfei
 * @create: 2019-03-28 11:19
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        File springConfigFile = new File("E:\\mongomanager\\src\\main\\java\\how2j\\reflection\\spring.txt");
        Properties springConfig = new Properties();
        springConfig.load(new FileInputStream(springConfigFile));
        String className = (String) springConfig.get("class");
        String methodName = (String) springConfig.get("method");

        Class clazz = Class.forName(className);

        Method m = clazz.getMethod(methodName);

        Constructor c = clazz.getConstructor();

        Object service = c.newInstance();

        m.invoke(service);

    }

}
