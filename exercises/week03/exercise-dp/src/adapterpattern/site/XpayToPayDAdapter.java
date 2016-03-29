package adapterpattern.site;

import adapterpattern.payd.PayD;
import adapterpattern.xpay.Xpay;

public class XpayToPayDAdapter implements PayD {

    private final Xpay xpay;
    private String custCardNo;
    private String cardOwnerName;
    private String cardExpMonthDate;
    private Integer cVVNo;
    private Double totalAmount;

    public XpayToPayDAdapter(Xpay xpay) {
        this.xpay = xpay;
        setProp();
    }


    private void setProp() {
        setCardOwnerName(this.getXpay().getCustomerName());
        setCustCardNo(this.getXpay().getCreditCardNo());
        setCardExpMonthDate(this.getXpay().getCardExpMonth()
                + "/" + this.getXpay().getCardExpYear());
        setCVVNo(this.getXpay().getCardCVVNo().intValue());
        setTotalAmount(this.getXpay().getAmount());
    }

    private Xpay getXpay() {
        return xpay;
    }

    @Override
    public String getCustCardNo() {
        return custCardNo;
    }

    @Override
    public void setCustCardNo(String custCardNo) {
        this.custCardNo = custCardNo;
    }

    @Override
    public String getCardOwnerName() {
        return cardOwnerName;
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    @Override
    public String getCardExpMonthDate() {
        return cardExpMonthDate;
    }

    @Override
    public void setCardExpMonthDate(String cardExpMonthDate) {
        this.cardExpMonthDate = cardExpMonthDate;
    }

    @Override
    public Integer getCVVNo() {
        return null;
    }

    @Override
    public void setCVVNo(Integer cVVNo) {

    }

    public Integer getcVVNo() {
        return cVVNo;
    }

    public void setcVVNo(Integer cVVNo) {
        this.cVVNo = cVVNo;
    }

    @Override
    public Double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
