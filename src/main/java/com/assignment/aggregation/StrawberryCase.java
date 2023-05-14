package com.assignment.aggregation;

public class StrawberryCase extends CRMCase{

    public StrawberryCase() {
        super();
        this.crmName = "Strawberry";
    }

    public StrawberryCase(String caseId, String customerId, String provider,
                      int errorCode, String status, String ticketCreationDate,
                      String lastModifiedDate, String productName) {

        this.crmName = "Strawberry";
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
