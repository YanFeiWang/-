package org.codehaus.jackson.annotate;

import dalvik.annotation.AnnotationDefault;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.codehaus.jackson.annotate.JacksonAnnotation;

@AnnotationDefault(   @JsonValue(true))
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@JacksonAnnotation
public @interface JsonValue {

   boolean value();
}
