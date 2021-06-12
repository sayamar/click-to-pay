package com.mybank.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybank.data.entities.TransferHistory;
@Repository
public interface TransferHistoryRepo extends JpaRepository<TransferHistory, Long>{

}
