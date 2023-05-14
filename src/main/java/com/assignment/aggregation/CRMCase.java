package com.assignment.aggregation;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public abstract class CRMCase {

    String crmName;

    @Column(name = "case_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String caseId;

    @Column(name = "customer_id")
    String customerId;

    @Column(name = "provider")
    String provider;

    @Column(name = "error_code")
    int errorCode;

    @Column(name = "status")
    String status;

    @Column(name = "ticket_creation_date")
    String ticketCreationDate;

    @Column(name = "last_modified_date")
    String lastModifiedDate;

    @Column(name = "product_name")
    String productName;

    void Case() {
    }

    public String getCrmName() {
        return crmName;
    }

    public String getCaseId() {
        return caseId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProvider() {
        return provider;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getStatus() {
        return status;
    }

    public String getTicketCreationDate() {
        return ticketCreationDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTicketCreationDate(String ticketCreationDate) {
        this.ticketCreationDate = ticketCreationDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
