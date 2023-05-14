package com.assignment.aggregation.repository;

import com.assignment.aggregation.entity.AggregationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AggregationRepository extends JpaRepository<AggregationEntity, String> {

        @Query("SELECT a FROM AggregationEntity a WHERE a.errorCode = :errorCode AND a.provider = :provider AND a.productName = :productName")
        List<AggregationEntity> findAllByErrorCodeAndProviderAndProductName(
                @Param("errorCode") String errorCode,
                @Param("provider") String provider,
                @Param("productName") String productName);

        @Query("SELECT a FROM AggregationEntity a WHERE a.errorCode = :errorCode AND a.provider = :provider")
        List<AggregationEntity> findAllByErrorCodeAndProvider(
                @Param("errorCode") String errorCode,
                @Param("provider") String provider);

        Optional<AggregationEntity> findByErrorCodeAndProviderAndProductName(String errorCode, String provider, String productName);

        List<AggregationEntity> findByProviderAndProductName(String provider, String productName);

        List<AggregationEntity> findByErrorCodeAndProductName(String errorCode, String productName);

        List<AggregationEntity> findByErrorCodeAndProvider(String errorCode, String provider);

        List<AggregationEntity> findByErrorCode(String errorCode);

        List<AggregationEntity> findByProvider(String provider);

        List<AggregationEntity> findByProductName(String productName);
}
