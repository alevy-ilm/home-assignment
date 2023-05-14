package com.assignment.aggregation.service;

import com.assignment.aggregation.repository.AggregationRepository;
import com.assignment.aggregation.CRMCase;
import com.assignment.aggregation.entity.CaseAggregation;
import com.assignment.aggregation.repository.CaseRepository;
import com.assignment.aggregation.entity.AggregationEntity;
import com.assignment.aggregation.entity.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CaseService {
    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private AggregationRepository aggregationRepository;
    public void addCases(List<CRMCase> crmCaseList) {
        List<Case> caseList = new ArrayList<Case>();
        HashMap<String, AggregationEntity> aggregationEntityMap = new HashMap<>();

        for (CRMCase crmCase: crmCaseList) {
            Case newCase = new Case();
            newCase.setCaseId(crmCase.getCrmName() + "_" + crmCase.getCaseId());
            newCase.setCustomerId(crmCase.getCustomerId());
            newCase.setErrorCode(crmCase.getErrorCode());
            newCase.setProvider(crmCase.getProvider());
            newCase.setStatus(crmCase.getStatus());
            newCase.setProductName(crmCase.getProductName());
            newCase.setTicketCreationDate(crmCase.getTicketCreationDate());
            newCase.setLastModifiedDate(crmCase.getLastModifiedDate());

            caseList.add(newCase);
        }
        caseRepository.saveAll(caseList);
    }

    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    public List<Case> getCasesByProductName(String productName) {
        return caseRepository.findByProductName(productName);
    }

    public List<Case> getCasesByStatus(String status) {
        return caseRepository.findByStatus(status);
    }

    public List<Case> getCasesByErrorCode(String errorCode) {
        return caseRepository.findByErrorCode(errorCode);
    }

    public List<CaseAggregation> getAggregatedData() {
        return caseRepository.aggregateByProviderAndProductNameAndErrorCode();
    }

    public List<AggregationEntity> getAggregatedData(String errorCode, String provider, String productName) {
        List<AggregationEntity> aggregationEntities = aggregationRepository.findAllByErrorCodeAndProviderAndProductName(errorCode, provider, productName);

        return aggregationEntities;
    }

    public List<AggregationEntity> getAllAggregatedData() {
        return aggregationRepository.findAll();
    }

    public List<Case> getCasesByProvider(String provider) {
        return caseRepository.findByProvider(provider);
    }

    public List<Case> getCasesByErrorCodeAndProvider(String errorCode, String provider, String productName) {
        return caseRepository.findByErrorCodeAndProviderAndProductName(errorCode, provider, productName);
    }
}