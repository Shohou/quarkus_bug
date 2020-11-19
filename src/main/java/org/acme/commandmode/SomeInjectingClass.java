package org.acme.commandmode;

import io.quarkus.runtime.Startup;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@ApplicationScoped
@Startup
public class SomeInjectingClass {

    @Inject
    Instance<SomeInterface> someClasses;

    @PostConstruct
    void init() {
        for (SomeInterface someClass : someClasses) {
            System.out.println(someClass.a());
        }
    }
}
