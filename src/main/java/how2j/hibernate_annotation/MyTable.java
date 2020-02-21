package how2j.hibernate_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: mongomanager
 * @description:
 * @author: WangPengfei
 * @create: 2019-04-01 14:01
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTable {
    String name();
}
