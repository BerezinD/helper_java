package jdbc.example;

import java.math.BigDecimal;

public class OrderLine {
    private int quantity;
    private BigDecimal productPrice;
    private String productCode;
    private String productName;
    private int productSize;
    private String productVariety;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }

    public int getProductSize() {
        return productSize;
    }

    public void setProductVariety(String productVariety) {
        this.productVariety = productVariety;
    }

    public String getProductVariety() {
        return productVariety;
    }
}
