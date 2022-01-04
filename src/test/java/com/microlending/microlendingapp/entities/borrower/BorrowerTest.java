package com.microlending.microlendingapp.entities.borrower;

import com.microlending.microlendingapp.repositories.BorrowerRepository;
import com.microlending.microlendingapp.repositories.LoanTicketRepository;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.StreamUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BorrowerTest {

//    @Autowired
//    private BorrowerRepository borrowerRepository;
//
//    @Autowired
//    private LoanTicketRepository loanTicketRepository;
//
//    @Autowired
//    private EntityManager entityManager;
//
//    private Borrower borrower;
//    private Address address;
//    private Address billingAddress;
//
//    @BeforeEach
//    void setUp() {
//        address = new Address("222 Sesame str", new GermanZipcode("55545"), new City("Berlin", "Germany"));
//        billingAddress = new Address("420 Hex Road", new SwissZipcode("5554"), new City("Zurich", "Switzerland"));
//        borrower = new Borrower(
//                "Augustas",
//                "Juskevicius",
//                address,
//                billingAddress,
//                "224",
//                Date.valueOf("1991-06-08"),
//                true,
//                "BSc For",
//                "2015",
//                "University of Aberdeen");
//
//    }
//
//    @Test
//    void saveBorrowerWithTwoLoanTickets_Persisted() {
//        createBorrowerWithTwoLoanTickets();
//        borrowerRepository.saveAndFlush(borrower);
//
//        Optional<Borrower> borrowerFromDb = borrowerRepository.findById(borrower.getId());
//        assertEquals(2, borrowerFromDb.get().getLoanTickets().size());
//    }
//
//    @Test
//    void deleteBorrowerWithTwoLoanTickets_AllDeleted() {
//        createBorrowerWithTwoLoanTickets();
//        borrowerRepository.saveAndFlush(borrower);
//        borrowerRepository.deleteById(borrower.getId());
//
//        Optional<Borrower> borrowerFromDb = borrowerRepository.findById(borrower.getId());
//        assertTrue(borrowerFromDb.isEmpty());
//
//        List<LoanTicket> loanTicketsFromDB = loanTicketRepository.findAll();
//        assertTrue(loanTicketsFromDB.isEmpty());
//
//    }
//
//
//    @Test
//    void saveBorrowerWithEmbeddableAddresses() {
//        borrowerRepository.saveAndFlush(borrower);
//
//        Optional<Borrower> borrowerFromDB = borrowerRepository.findById(borrower.getId());
//
//        assertEquals(billingAddress, borrowerFromDB.get().getBillingAddress());
//        assertEquals(address, borrowerFromDB.get().getCurrentAddress());
//
//    }
//
//    @Test
//    void saveBorrowerWithEmbeddableAddressesNull_ThrowsException() {
//
//        borrower.setBillingAddress(null);
//        borrower.setCurrentAddress(null);
//
//        ConstraintViolationException thrown = Assertions.assertThrows(ConstraintViolationException.class, () -> {
//            borrowerRepository.saveAndFlush(borrower);
//        });
//
//    }
//
//    @Test
//    void saveBorrowerWithImageDataInByteArray() {
//        byte[] bytes = new byte[131072];
//        new Random().nextBytes(bytes);
//        borrower.setImage(bytes);
//
//        borrowerRepository.saveAndFlush(borrower);
//
//        Optional<Borrower> borrowerFromDb = borrowerRepository.findById(borrower.getId());
//
//        assertEquals(borrowerFromDb.get().getImage().length, 131072); // 128 kilobytes
//
//    }
//
//    @Test
//    void saveBorrowerWithImageDataInBlob() throws SQLException, IOException {
//
//        byte[] bytes = new byte[131072];
//        new Random().nextBytes(bytes);
//        InputStream imageInputStream = new ByteArrayInputStream(bytes);
//        int byteLength = bytes.length;
//
//        Session session = entityManager.unwrap(Session.class);
//        Blob blob = session.getLobHelper().createBlob(imageInputStream, byteLength);
//
//        borrower.setImageBlob(blob);
//
//        borrowerRepository.saveAndFlush(borrower);
//
//        Optional<Borrower> borrowerFromDb = borrowerRepository.findById(borrower.getId());
//
//        InputStream imageDataStream = borrowerFromDb.get().getImageBlob().getBinaryStream();
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//        StreamUtils.copy(imageDataStream, outStream);
//        byte[] imageBytes = outStream.toByteArray();
//
//        assertEquals(imageBytes.length, 131072); // 128 kilobytes
//    }
//
//    private void createBorrowerWithTwoLoanTickets() {
//        LoanTicket loanTicket = new LoanTicket(
//                new MonetaryAmount(BigDecimal.valueOf(200.00), Currency.getInstance("USD")),
//                24,
//                0.03,
//                5,
//                "I need money",
//                "OK",
//                "Will pay");
//
//        LoanTicket loanTicket2 = new LoanTicket(
//                new MonetaryAmount(BigDecimal.valueOf(200.00), Currency.getInstance("USD")),
//                24,
//                0.03,
//                5,
//                "I need money",
//                "OK",
//                "Will pay");
//
//        borrower.addLoanTicket(loanTicket);
//        borrower.addLoanTicket(loanTicket2);
//    }
//}
}