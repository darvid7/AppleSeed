package edu.monash.monplan.repository;

import com.threewks.gaetools.search.gae.SearchConfig;
import edu.monash.monplan.model.Transaction;
import org.monplan.abstraction_layer.MonPlanRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository extends MonPlanRepository<Transaction> {

    public TransactionRepository(SearchConfig searchConfig) {
        super(Transaction.class, searchConfig, null, null);
    }

}
