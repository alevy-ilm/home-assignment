package com.assignment.aggregation.controller;

import com.assignment.aggregation.entity.AggregationEntity;
import com.assignment.aggregation.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aggregation")
public class AggregationController {

    @Autowired
    private CaseService caseService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AggregationEntity>> getAggregationData(
            @RequestParam(name = "error_code", required = false) String errorCode,
            @RequestParam(name = "provider", required = false) String provider,
            @RequestParam(name = "product_name", required = false) String productName) {

        List<AggregationEntity> aggregationData;

        if (errorCode != null && provider != null && productName != null) {
            // if all three parameters are present, return the specific aggregation data
            aggregationData = caseService.getAggregatedData(errorCode, provider, productName);
        } else {
            // if any parameter is missing, return all the aggregation data
            aggregationData = caseService.getAllAggregatedData();
        }

        return ResponseEntity.ok(aggregationData);
    }
}

