package com.management.ssm.repository;

import com.management.ssm.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface accountRepository extends JpaRepository<Account, Long> {

}
