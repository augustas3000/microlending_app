package com.microlending.microlendingapp.repositories;

import com.microlending.microlendingapp.entities.Bid;
import com.microlending.microlendingapp.entities.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BidRepository bidRepository;

    @Value("${spring.datasource.url}")
    String datasourceUrl;

    @Test
    void persistsItemsWithoutBids() {
        Item item = new Item();
        item.setName("Some item");
        item.setDescription("This is some description.");

        itemRepository.save(item);

        List<Item> itemsFromDB = itemRepository.findAll();
        assertEquals(1, itemsFromDB.size());
        assertEquals(item.getId(), itemsFromDB.get(0).getId());
    }

    @Test
    void persistsItemsWithBids() {
        Item item = new Item();
        item.setName("Some item");
        item.setDescription("This is some description.");

        for (int i = 1; i <= 3; i++) {
            Bid bid = new Bid();
            bid.setAmount(new BigDecimal(10 + i));
            bidRepository.save(bid);
            item.addBid(bid);
        }

        itemRepository.save(item);
        List<Item> itemsFromDB = itemRepository.findAll();
        assertEquals(1, itemsFromDB.size());
        assertEquals(item.getId(), itemsFromDB.get(0).getId());
        assertEquals(item.getBids().size(), itemsFromDB.get(0).getBids().size());
    }

}
