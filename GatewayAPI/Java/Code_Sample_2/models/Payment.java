package models;

import net.sertifi.apps.services.PaymentOperationType;
import net.sertifi.apps.services.PaymentReccurence;

import java.math.BigDecimal;

public class Payment {
    public String apiCode;
    public String fileId;
    public BigDecimal amount;
    public String description;
    public PaymentReccurence recurrence;
    public String datePaymentDue;
    public PaymentOperationType operation;
}
