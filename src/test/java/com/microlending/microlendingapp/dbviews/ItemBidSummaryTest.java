package com.microlending.microlendingapp.dbviews;

import com.microlending.microlendingapp.entities.Bid;
import com.microlending.microlendingapp.entities.Item;
import com.microlending.microlendingapp.repositories.BidRepository;
import com.microlending.microlendingapp.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemBidSummaryTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private EntityManager entityManager;

    @Test

    public void loadSubselectEntity() throws Exception {
        long ITEM_ID = storeItemAndBids();

        ItemBidSummary itemBidSummary = testEntityManager.find(ItemBidSummary.class, ITEM_ID);

        assertEquals(itemBidSummary.getName(), "Some item");

        testEntityManager.clear();

        Item item = testEntityManager.find(Item.class, ITEM_ID);
        item.setName("New name");

        // No flush before retrieval by identifier!
        // ItemBidSummary itemBidSummary = em.find(ItemBidSummary.class, ITEM_ID);

        // Automatic flush before queries if synchronized tables are affected!
        Query query = testEntityManager.getEntityManager().createQuery(
                "select ibs from ItemBidSummary ibs where ibs.itemId = :id"
        );

        ItemBidSummary itemBidSummaryTwo =
                (ItemBidSummary) query.setParameter("id", ITEM_ID).getSingleResult();


        assertEquals(itemBidSummaryTwo.getName(), "New name");
    }


    public Long storeItemAndBids() throws Exception {
        Item item = new Item();
        item.setName("Some item");
        item.setDescription("This is some description.");
        itemRepository.save(item);

//        testEntityManager.persist(item);

        for (int i = 1; i <= 3; i++) {
            Bid bid = new Bid();
            bid.setAmount(new BigDecimal(10 + i));
            item.addBid(bid);
            bidRepository.save(bid);
        }
        testEntityManager.flush();

        return item.getId();
    }

}
