package org.acme.commandmode;

public class SomeClass implements SomeInterface{
    private final String value;

    public SomeClass(String value) {
        this.value = value;
    }

    @Override
    public String a() {
        return value;
    }
}
