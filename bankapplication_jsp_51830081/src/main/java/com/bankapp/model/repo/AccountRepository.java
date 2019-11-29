package com.bankapp.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
