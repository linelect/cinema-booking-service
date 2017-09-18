package com.linelect.model;

public class NamedEntity extends BaseEntity{

    protected String name;

    public NamedEntity() {
    }

    protected NamedEntity(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
