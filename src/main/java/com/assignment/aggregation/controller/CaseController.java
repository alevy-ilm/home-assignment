package com.assignment.aggregation.controller;

import com.assignment.aggregation.entity.Case;
import com.assignment.aggregation.entity.CaseAggregation;
import com.assignment.aggregation.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cases")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @GetMapping("")
    public ResponseEntity<List<Case>> getAllCases() {
        List<Case> cases = caseService.getAllCases();
        return ResponseEntity.ok(cases);
    }

    @GetMapping(params = {"product_name"})
    public ResponseEntity<List<Case>> getCasesByProductName(@RequestParam("product_name") String productName) {
        List<Case> cases = caseService.getCasesByProductName(productName);
        return ResponseEntity.ok(cases);
    }

    @GetMapping(params = {"status"})
    public ResponseEntity<List<Case>> getCasesByStatus(@RequestParam("status") String status) {
        List<Case> cases = caseService.getCasesByStatus(status);
        return ResponseEntity.ok(cases);
    }

    @GetMapping(params = {"error_code"})
    public ResponseEntity<List<Case>> getCasesByErrorCode(@RequestParam("error_code") String errorCode) {
        List<Case> cases = caseService.getCasesByErrorCode(errorCode);
        return ResponseEntity.ok(cases);
    }

    @GetMapping(params = {"provider"})
    public ResponseEntity<List<Case>> getCasesByProvider(@RequestParam("provider") String provider) {
        List<Case> cases = caseService.getCasesByProvider(provider);
        return ResponseEntity.ok(cases);
    }

    @GetMapping(params = {"error_code", "provider"})
    public ResponseEntity<List<Case>> getCasesByErrorCodeAndProvider(
            @RequestParam("error_code") String errorCode,
            @RequestParam("provider") String provider,
            @RequestParam(name = "product_name", required = false) String productName) {

        List<Case> cases = caseService.getCasesByErrorCodeAndProvider(errorCode, provider, productName);
        return ResponseEntity.ok(cases);
    }


    @GetMapping(params = {"aggregated"})
    public ResponseEntity<List<CaseAggregation>> getAggregatedData() {
        List<CaseAggregation> caseAggregations = caseService.getAggregatedData();
        return ResponseEntity.ok(caseAggregations);
    }
}
