package com.microlending.microlendingapp.entities;


import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    protected String name;

    @OneToMany(mappedBy = "item",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true) // Includes CascadeType.REMOVE
    protected Set<Bid> bids = new HashSet<Bid>();



//    @NotNull
//    @Size(
//            min = 1,
//            max = 255,
//            message = "Name is required, range 1 - 255 characters."
//    )
    protected String description;

    @Future
    protected Date auctionEnd;

    @ElementCollection
    @CollectionTable(
            name = "IMAGE", // Defaults to ITEM_IMAGES
            joinColumns = @JoinColumn(name = "ITEM_ID")) // Default, actually
    @Column(name = "FILENAME") // Defaults to IMAGES
    protected Set<String> images = new HashSet<String>(); // Initialize field here

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void addBid(Bid bid) {
        if (bid == null) {
            throw new NullPointerException("Can't add null Bid");
        }

        if (bid.getItem() != null) {
            throw new IllegalStateException("Bid is already assigned to an Item");
        }

        getBids().add(bid);
        bid.setItem(this);
    }

    public Long getId() {
        return id;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }
}
