package com.assignment.aggregation;

public class BananaCase extends CRMCase {
    public BananaCase() {
        super();
        crmName = "Banana";
    }

    public BananaCase(String caseId, String customerId, String provider,
                     int errorCode, String status, String ticketCreationDate,
                     String lastModifiedDate, String productName) {
        this.crmName = "Banana";
        this.caseId = caseId;
        this.customerId = customerId;
        this.provider = provider;
        this.errorCode = errorCode;
        this.status = status;
        this.ticketCreationDate = ticketCreationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.productName = productName;
    }
}
