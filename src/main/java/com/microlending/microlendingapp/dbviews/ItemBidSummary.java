package com.microlending.microlendingapp.dbviews;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
@Subselect(value = "select i.ID as ITEMID, i.NAME as NAME, " +
        "count(b.ID) as NUMBEROFBIDS " +
        "from CE_ITEM i left outer join CE_BID b on i.ID = b.ITEM_ID " +
        "group by i.ID, i.NAME")
@Synchronize({"Item", "Bid"})
public class ItemBidSummary {

    @Id
    protected Long itemId;
    protected String name;
    protected long numberOfBids;

    public long getNumberOfBids() {
        return numberOfBids;
    }

    public void setNumberOfBids(long numberOfBids) {
        this.numberOfBids = numberOfBids;
    }

    public String getName() {
        return name;
    }

    public ItemBidSummary() {
    }
}

