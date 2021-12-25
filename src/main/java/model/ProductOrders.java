package model;

public class ProductOrders {

    private int orderID;
    private int productId;
    private int amountProduct;
    private String nameProduct;

    public ProductOrders(int orderID, int productId, int amountProduct, String nameProduct) {
        this.orderID = orderID;
        this.productId = productId;
        this.amountProduct = amountProduct;
        this.nameProduct = nameProduct;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
