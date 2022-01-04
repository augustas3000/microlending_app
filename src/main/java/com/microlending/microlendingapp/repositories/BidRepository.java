package com.microlending.microlendingapp.repositories;

import com.microlending.microlendingapp.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
}
