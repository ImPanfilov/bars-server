package com.impanfilov.barsserver.service;

import com.impanfilov.barsserver.model.Contract;
import java.util.List;

public interface ContractService {

    List<Contract> readAll();

    Contract create(Contract contract);

    boolean update(int Id);

}
