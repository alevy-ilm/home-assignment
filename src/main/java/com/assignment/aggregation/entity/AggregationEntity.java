package com.assignment.aggregation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aggregation")
public class AggregationEntity {

    @Id
    private String id;

    @Column(name = "error_code")
    private int errorCode;

    private String provider;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "cases_number")
    private int casesNumber;

    // constructors, getters and setters
    public AggregationEntity() {}

    public AggregationEntity(int errorCode, String provider, String productName, int casesNumber) {
        this.errorCode = errorCode;
        this.provider = provider;
        this.productName = productName;
        this.casesNumber = casesNumber;
        this.id = generateId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCasesNumber() {
        return casesNumber;
    }

    public void setCasesNumber(int casesNumber) {
        this.casesNumber = casesNumber;
    }

    // helper method to generate unique identifier
    public String generateId() {
        return errorCode + "-" + provider + "-" + productName;
    }
}
