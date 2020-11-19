package org.acme.commandmode;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;

@Dependent
public class SomeClassConfig {

    @ApplicationScoped
    public SomeClass someClass1() {
        return new SomeClass("someClass1");
    }

    @ApplicationScoped
    public SomeClass someClass2() {
        return new SomeClass("someClass2");
    }
}
