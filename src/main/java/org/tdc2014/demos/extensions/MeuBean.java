package org.tdc2014.demos.extensions;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class MeuBean {

    @Inject
    @Propriedade("key1")
    private String propriedade1;

    @Inject
    @Propriedade("key2")
    private String propriedade2;
    
    public String getPropriedade1() {
        return propriedade1;
    }
    
    public String getPropriedade2() {
        return propriedade2;
    }
  
}
