package com.microlending.microlendingapp.lifecyclesjpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpa, Long> {
    UserJpa findByUserName(String userName);
}
