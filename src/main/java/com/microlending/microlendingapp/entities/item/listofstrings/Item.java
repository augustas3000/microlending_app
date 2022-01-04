package com.microlending.microlendingapp.entities.item.listofstrings;

import com.microlending.microlendingapp.entities.Constants;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ITEM2")
public class Item {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @NotNull
    @Size(
            min = 1,
            max = 255,
            message = "Name is required, range 1 - 255 characters."
    )
    protected String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE", joinColumns = @JoinColumn(name = "ITEM2_ID"))
    @OrderColumn // Enables persistent order, Defaults to IMAGES_ORDER
    @Column(name = "FILENAME")
    protected List<String> images = new ArrayList<String>();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
