package com.microlending.microlendingapp.entities.item;


import com.microlending.microlendingapp.entities.Bid;
import com.microlending.microlendingapp.entities.Item;
import com.microlending.microlendingapp.entities.User;
import com.microlending.microlendingapp.repositories.BidRepository;
import com.microlending.microlendingapp.repositories.ItemRepository;
import com.microlending.microlendingapp.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemTest {


    @Autowired
    UserRepo userRepo;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    BidRepository bidRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void storeAndLoadItemBids() {

    }

}
