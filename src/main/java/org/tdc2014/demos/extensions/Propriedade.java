package org.tdc2014.demos.extensions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.PARAMETER;;

@Retention(value = RetentionPolicy.RUNTIME)
@Target({ FIELD, METHOD, TYPE, PARAMETER })
@Qualifier
public @interface Propriedade {

     String value() default "";
}
