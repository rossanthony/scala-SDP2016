package xpay;

public interface PayD {
    String getCustCardNo();

    void setCustCardNo(String custCardNo);

    String getCardOwnerName();

    void setCardOwnerName(String cardOwnerName);

    String getCardExpMonthDate();

    void setCardExpMonthDate(String cardExpMonthDate);

    Integer getCVVNo();

    void setCVVNo(Integer cVVNo);

    Double getTotalAmount();

    void setTotalAmount(Double totalAmount);
}