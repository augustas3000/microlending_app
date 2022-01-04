package com.microlending.microlendingapp.repositories;

import com.microlending.microlendingapp.entities.borrower.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
