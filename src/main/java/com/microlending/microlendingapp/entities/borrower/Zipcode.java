package com.microlending.microlendingapp.entities.borrower;

import javax.persistence.Embeddable;


abstract public class Zipcode {

    protected String value;

    public Zipcode(String value) {
        this.value = value;
    }

    public Zipcode() {

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zipcode zipcode = (Zipcode) o;
        return value.equals(zipcode.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
