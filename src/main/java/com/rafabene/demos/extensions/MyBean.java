package com.rafabene.demos.extensions;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class MyBean
{

    @Inject
    @Property("key1")
    private String property1;

    @Inject
    @Property("key2")
    private String property2;

    public String getProperty1()
    {
        return property1;
    }

    public String getProperty2()
    {
        return property2;
    }

}
