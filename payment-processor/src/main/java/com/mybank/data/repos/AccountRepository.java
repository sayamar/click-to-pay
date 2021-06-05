package com.mybank.data.repos;

import java.util.Optional;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mybank.data.entities.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	/**
	 * We can use a pessimistic lock to ensure that no other transactions can modify or delete reserved data.
	 * @param accnumber
	 * @return
	 */
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Transactional
	@Query("SELECT a FROM Account a WHERE a.accnumber =:accnumber")
	Optional<Account> getAccountForUpdate(Long accnumber);
}
