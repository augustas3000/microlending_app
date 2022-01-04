package com.microlending.microlendingapp.entities.item;


import com.microlending.microlendingapp.entities.Item;
import com.microlending.microlendingapp.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.transaction.TestTransaction;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemCollectionsTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void setOfStringsPersisted() {
        Item itemFoo = new Item("Foo");
        Item itemB = new Item("B");
//        Item itemC = new Item("C");

        itemFoo.getImages().add("foo.jpg");
        itemFoo.getImages().add("bar.jpg");
        itemFoo.getImages().add("baz.jpg");
        itemB.getImages().add("b.jpg");

        itemRepository.save(itemFoo);
        itemRepository.save(itemB);
    }




}
