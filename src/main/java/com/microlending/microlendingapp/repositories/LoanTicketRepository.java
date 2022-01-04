package com.microlending.microlendingapp.repositories;

import com.microlending.microlendingapp.entities.borrower.LoanTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTicketRepository extends JpaRepository<LoanTicket, Long> {
}
