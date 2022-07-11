package com.impanfilov.barsserver.service;

import com.impanfilov.barsserver.model.Contract;
import com.impanfilov.barsserver.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.ZonedDateTime;
import java.util.List;


@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> readAll(){
        return contractRepository.findAll();
    }

    @Override
    public Contract create(Contract contract){
        contract.setDate(ZonedDateTime.now());
        contract.setDateLastModified(ZonedDateTime.now());
        return contractRepository.save(contract);
    }

    @Override
    public boolean update(int id){
    if(contractRepository.existsById(id)){
        Contract contract = contractRepository.getReferenceById(id);
        contract.setDateLastModified(ZonedDateTime.now());
        contractRepository.save(contract);
        return true;
        }
    return false;
    }
}


