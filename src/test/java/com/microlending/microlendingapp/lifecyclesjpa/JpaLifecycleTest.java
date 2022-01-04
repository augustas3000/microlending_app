package com.microlending.microlendingapp.lifecyclesjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class JpaLifecycleTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TestEntityManager testEntityManager;


    @Test
    @Rollback(value = false)
    void saveAndRetrieveUserThenDelete() {
        UserJpa userJpa = new UserJpa("hello", "Magoo", "Rudy");
        userRepository.save(userJpa);

        testEntityManager.flush();
        testEntityManager.clear();

        Optional<UserJpa> user = userRepository.findById(userJpa.getId());

        user.get().setUserName("Augustas3000");

        testEntityManager.flush();
        testEntityManager.clear();

//        userRepository.deleteById(userJpa.getId());
//
//        testEntityManager.flush();
//        testEntityManager.clear();
    }



}
