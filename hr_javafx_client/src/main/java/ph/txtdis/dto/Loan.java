package ph.txtdis.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ph.txtdis.type.LoanType;
import ph.txtdis.util.Numeric;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Loan extends AbstractAuditedNumbered {

    private LoanType type;

    private LocalDate startDate;

    private BigDecimal loanValue;

    private List<Payment> payments;

    private BigDecimal paymentValue;

    public Loan(LoanType type, LocalDate startDate, BigDecimal loanValue) {
        this.type = type;
        this.startDate = startDate;
        this.loanValue = loanValue;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
        if (payments != null)
            setPaymentValue(sumPayments());
    }

    public BigDecimal getPaymentValue() {
        if (payments != null)
            setPaymentValue(sumPayments());
        return paymentValue;
    }

    private BigDecimal sumPayments() {
        BigDecimal total = BigDecimal.ZERO;
        for (Payment pay : getPayments())
            total = total.add(pay.getPaymentValue());
        return total;
    }

    public BigDecimal getBalanceValue() {
        if (Numeric.isZero(getLoanValue()))
            return BigDecimal.ZERO;
        if (Numeric.isZero(getPaymentValue()))
            return getLoanValue();
        return getLoanValue().subtract(getPaymentValue());
    }
}
