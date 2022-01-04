package com.microlending.microlendingapp.repositories;

import com.microlending.microlendingapp.entities.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class MessageRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private MessageRepository messageRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(messageRepository).isNotNull();
    }

    @Test
    void messagePersistedToDb() {
        Message message = new Message("Aloha");

        Message savedMessage = messageRepository.save(message);

        List<Message> messagesFromDb = messageRepository.findAll();
        assertEquals(1, messagesFromDb.size());
        assertEquals(message.getText(), messagesFromDb.get(0).getText());

    }


}
