package com.gopal.TransactionOutboxDesign.repository;

import com.gopal.TransactionOutboxDesign.entity.OrderOutbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutboxRepository extends JpaRepository<OrderOutbox,String> {
    List<OrderOutbox> findByProcessedFalse();
}
