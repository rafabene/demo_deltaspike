package com.rafabene.demos.extensions;

import javax.enterprise.util.AnnotationLiteral;

public class PropriedadeLiteral extends AnnotationLiteral<Propriedade> implements Propriedade{
    
    private static final long serialVersionUID = 1L;
    
    private final String value;
    
    public PropriedadeLiteral(String s) {
        this.value = s;
    }

    @Override
    public String value() {
        return value;
    }

}
