package com.amigoscode.fraud;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        Boolean isFraudCheckService = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check response for customer {}", customerId);
        return new FraudCheckResponse(isFraudCheckService);
    }
}
