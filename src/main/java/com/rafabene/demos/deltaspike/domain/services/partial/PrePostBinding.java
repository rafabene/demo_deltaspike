package com.rafabene.demos.deltaspike.domain.services.partial;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.deltaspike.partialbean.api.PartialBeanBinding;

@PartialBeanBinding
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PrePostBinding {

}
