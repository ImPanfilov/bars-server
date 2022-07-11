package com.impanfilov.barsserver.controller;

import com.impanfilov.barsserver.model.Contract;
import com.impanfilov.barsserver.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    ContractService contractService;


    @GetMapping(path = "/getall")
    public ResponseEntity<List<Contract>> getAllContract() {
        List<Contract> contracts = new ArrayList<Contract>(contractService.readAll());
        contractService.readAll();
        return contracts != null && !contracts.isEmpty()
                ? new ResponseEntity<>(contracts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Contract> createContract(
            @RequestBody Contract contract) {
        Contract contractNew = contractService.create(contract);
        return new ResponseEntity<>(contractNew,HttpStatus.CREATED);
    }

    @PutMapping(path = "/update", params = "id")
    public ResponseEntity<?> updateContract(
        @RequestParam("id") int id) {
        final boolean updated = contractService.update(id);

            return updated
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }





}
