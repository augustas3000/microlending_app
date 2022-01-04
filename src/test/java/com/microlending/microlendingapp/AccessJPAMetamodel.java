package com.microlending.microlendingapp;

import com.microlending.microlendingapp.repositories.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.Type;
import javax.sql.DataSource;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class AccessJPAMetamodel {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Test
    public void accessDynamicMetamodel() throws Exception {
//        EntityManagerFactory entityManagerFactory = JPA.getEntityManagerFactory();

//        Metamodel mm = entityManagerFactory.getMetamodel();
//
//        Set<ManagedType<?>> managedTypes = mm.getManagedTypes();
//        assertEquals(managedTypes.size(), 1);
//
//        ManagedType itemType = managedTypes.iterator().next();
//        assertEquals(
//                itemType.getPersistenceType(),
//                Type.PersistenceType.ENTITY
//        );
//
//        SingularAttribute nameAttribute =
//                itemType.getSingularAttribute("name");
//        assertEquals(
//                nameAttribute.getJavaType(),
//                String.class
//        );
//        assertEquals(
//                nameAttribute.getPersistentAttributeType(),
//                Attribute.PersistentAttributeType.BASIC
//        );
//        assertFalse(
//                nameAttribute.isOptional() // NOT NULL
//        );
//
//        SingularAttribute auctionEndAttribute =
//                itemType.getSingularAttribute("auctionEnd");
//        assertEquals(
//                auctionEndAttribute.getJavaType(),
//                Date.class
//        );
//        assertFalse(
//                auctionEndAttribute.isCollection()
//        );
//        assertFalse(
//                auctionEndAttribute.isAssociation()
//        );
    }

}
