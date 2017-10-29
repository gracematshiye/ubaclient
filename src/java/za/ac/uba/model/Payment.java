package za.ac.uba.model;

import java.text.DecimalFormat;

/**
 * Created by gracem on 2017/10/12.
 */
public class Payment {

    private Integer id;
    private Integer buyerId;
    private Integer sellerId;
    private Integer bookId;
    private double amount;
    private String paymentDate;
    private String paymentReference;

    public Payment(Integer buyerId, Integer sellerId, Integer bookId, double amount, String paymentDate, String paymentReference) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.bookId = bookId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentReference = paymentReference;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public double getAmount() throws Exception {
//        return getDoubleForm(amount);
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public double getDoubleForm(Double price) throws Exception  {
        String pattern = "0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(price);
        return Double.valueOf(format);
    }
}
