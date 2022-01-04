package com.microlending.microlendingapp.entities.borrower;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
public class Address {

    @NotNull
    @Column(nullable = false)
    protected String street;

    @NotNull
    @Column(nullable = false, length = 5)
    protected Zipcode postalCode;

    @NotNull
    @AttributeOverrides(
            @AttributeOverride(
                    name = "name",
                    column = @Column(name = "CITY", nullable = false)
            )
    )
    protected City city;

    public Address() {
    }

    public Address(String street, @NotNull Zipcode postalCode, City city) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) && postalCode.equals(address.postalCode) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, postalCode, city);
    }
}
