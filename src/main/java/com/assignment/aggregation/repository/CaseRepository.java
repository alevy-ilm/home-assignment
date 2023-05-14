package com.assignment.aggregation.repository;


import com.assignment.aggregation.entity.CaseAggregation;
import com.assignment.aggregation.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Case, String>{

    List<Case> findByProductName(String productName);
    List<Case> findByStatus(String status);
    List<Case> findByErrorCode(String errorCode);
    @Query("SELECT c.provider AS provider, c.productName AS productName, c.errorCode AS errorCode, COUNT(c) AS count FROM Case c GROUP BY c.provider, c.productName, c.errorCode")
    List<CaseAggregation> aggregateByProviderAndProductNameAndErrorCode();
    List<Case> findByProvider(String provider);
    List<Case> findByErrorCodeAndProviderAndProductName(String errorCode, String provider, String productName);
}
