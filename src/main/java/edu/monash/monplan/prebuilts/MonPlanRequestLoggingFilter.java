package edu.monash.monplan.prebuilts;

import edu.monash.monplan.model.Transaction;
import edu.monash.monplan.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

/***
 * Implemented according to https://alvinalexander.com/java/jwarehouse/spring-framework-2.5.3/src/org/springframework/web/filter/CommonsRequestTransactiongingFilter.java.shtml
 *
 * @author Callistus
 */
@Component
public class MonPlanRequestLoggingFilter extends CommonsRequestLoggingFilter {

    private final TransactionService service;

    @Autowired
    public MonPlanRequestLoggingFilter(TransactionService a_service) {
        service = a_service;
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        if (logger.isDebugEnabled()) {
            // init variables
            String endpoint = request.getRequestURI();
            String queryString = null;
            String payload = null;

            // determine query string
            if (!request.getQueryString().equals("")) {
                queryString = request.getQueryString();
            }

            // determine payload
            int start = message.indexOf("payload");
            if (start != -1) {
                start += 8;
                int N = message.length();
                payload = message.substring(start, N-1);
            }

            // log
            logger.debug("Endpoint:");
            logger.debug(endpoint);
            logger.debug("Query String:");
            logger.debug(queryString);
            logger.debug("Payload:");
            logger.debug(payload);

            ArrayList<String> queryParams = new ArrayList<>();
            if (queryString != null) {
                queryParams = new ArrayList<>(Arrays.asList(queryString.split("\\s*&\\s*")));
            }

//            try {
//                // save log to datastore
//                service.create(new Transaction(new DateTime(), endpoint, queryParams, payload));
//            } catch (FailedOperationException e) {
//                e.printStackTrace();
//            }
        }
    }
}