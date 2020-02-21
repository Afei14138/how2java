package how2j.annotation;

import java.lang.annotation.*;

/**
 * @program: mongomanager
 * @description: 可重复使用的注解
 * @author: WangPengfei
 * @create: 2019-03-29 14:30
 **/
public class FindFiles {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FileTypes {
        FileType[] value();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(FileTypes.class)
    public @interface FileType {
        String value();
    }

    @FileType(".java")
    @FileType(".html")
    @FileType(".css")
    @FileType(".js")
    public void work() {
        try {
            FileType[] filesType = this.getClass().getMethod("work").getAnnotationsByType(FileType.class);
            System.out.println("将从如下后缀的文件中查找文件内容");
            for (FileType fileType : filesType) {
                System.out.println(fileType.value());
            }
            System.out.println("查找过程省略");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FindFiles().work();
    }


}
