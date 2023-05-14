package com.assignment.aggregation.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "cases")
public class Case {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    */

    @Column(name = "case_id")
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String caseId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "provider")
    private String provider;

    @Column(name = "error_code")
    private int errorCode;

    @Column(name = "status")
    private String status;

    @Column(name = "ticket_creation_date")
    private String ticketCreationDate;

    @Column(name = "last_modified_date")
    private String lastModifiedDate;

    @Column(name = "product_name")
    private String productName;

    public Case() {
    }

    public Case(String caseId, String customerId, String provider, int errorCode, String status, String ticketCreationDate, String lastModifiedDate, String productName) {
        this.caseId = caseId;
        this.customerId = customerId;
        this.provider = provider;
        this.errorCode = errorCode;
        this.status = status;
        this.ticketCreationDate = ticketCreationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.productName = productName;
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
