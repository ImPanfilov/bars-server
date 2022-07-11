package com.impanfilov.barsserver.repository;

import com.impanfilov.barsserver.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository  extends JpaRepository<Contract,Integer> {
}
