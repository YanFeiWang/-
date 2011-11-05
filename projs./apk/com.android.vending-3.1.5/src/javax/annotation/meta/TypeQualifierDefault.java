package javax.annotation.meta;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@AnnotationDefault(   @TypeQualifierDefault({}))
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
public @interface TypeQualifierDefault {

   ElementType[] value();
}
