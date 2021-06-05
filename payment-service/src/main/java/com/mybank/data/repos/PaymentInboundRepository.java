package com.mybank.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybank.data.entities.InboundPayments;

@Repository
public interface PaymentInboundRepository extends JpaRepository<InboundPayments, String> {

}
