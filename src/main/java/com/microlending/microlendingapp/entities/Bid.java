package com.microlending.microlendingapp.entities;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Immutable
public class Bid {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    protected Item item;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    protected User bidder;

    @NotNull
    private BigDecimal amount;

    public Bid() {
    }

    public Bid(Item item, User bidder, @NotNull BigDecimal amount) {
        this.item = item;
        this.bidder = bidder;
        this.amount = amount;
    }

    public Bid(BigDecimal amount, Item item) {
        this.amount = amount;
        this.item = item;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}