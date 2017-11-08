package edu.monash.monplan.service;

import edu.monash.monplan.model.Transaction;
import org.monplan.abstraction_layer.MonPlanRepository;
import org.monplan.abstraction_layer.MonPlanService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends MonPlanService<Transaction> {

    public TransactionService(MonPlanRepository<Transaction> repository) {
        super(repository);
    }
}
