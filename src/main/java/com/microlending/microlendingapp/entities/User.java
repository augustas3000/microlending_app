package com.microlending.microlendingapp.entities;

import org.apache.tomcat.jni.Address;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @OneToMany(mappedBy = "bidder")
    protected Set<Bid> bids = new HashSet<>();

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }


    protected String username;
    protected String firstname;
    protected String lastname;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal calcShippingCosts(Address fromLocation) {
        // Empty implementation of business method
        return null;
    }

}
