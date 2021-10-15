import java.util.Objects;

public class Product {
    private String prodNo;
    private String prodName;
    private int price;

    public String getProdNo() {
        return prodNo;
    }

    public String getProdName() {
        return prodName;
    }

    public int getPrice() {
        return price;
    }

    public Product(String prodNo, String prodName, int price) {
        this.prodNo = prodNo;
        this.prodName = prodName;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return prodNo.equals(product.prodNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodNo);
    }
}
