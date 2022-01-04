package com.microlending.microlendingapp.entities.borrower.converters;

import com.microlending.microlendingapp.entities.borrower.LoanTicket;
import com.microlending.microlendingapp.entities.borrower.MonetaryAmount;
import com.microlending.microlendingapp.repositories.LoanTicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class MonetaryAmountConverterTest {

    @Autowired
    private LoanTicketRepository loanTicketRepository;

    @Test
    void storeAndLoadMonetaryAmount() {

        MonetaryAmount amount =
                new MonetaryAmount(
                        new BigDecimal("11.23"), Currency.getInstance("USD")
                );

        LoanTicket loanTicket = new LoanTicket(
                amount,
                20,
                0.05,
                5,
                "I Need money",
                "Will pay back",
                "Nothing");

        LoanTicket loanTicketFromDB = loanTicketRepository.saveAndFlush(loanTicket);

        assertEquals(loanTicketRepository.findById(loanTicketFromDB.getId()).get().getLoanAmount(), amount);
        assertEquals(loanTicketRepository.findById(loanTicketFromDB.getId()).get().getLoanAmount().getValue(), new BigDecimal("11.23"));
        assertEquals(loanTicketRepository.findById(loanTicketFromDB.getId()).get().getLoanAmount().getCurrency(), Currency.getInstance("USD"));

    }


}
