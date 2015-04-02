package com.rafabene.demos.extensions;

import javax.enterprise.util.AnnotationLiteral;

public class PropertyLiteral extends AnnotationLiteral<Property> implements Property{
    
    private static final long serialVersionUID = 1L;
    
    private final String value;
    
    public PropertyLiteral(String s) {
        this.value = s;
    }

    @Override
    public String value() {
        return value;
    }

}
