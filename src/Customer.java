import java.util.Objects;

public class Customer {
    private String customerNo;
    private String customerName;

    public Customer(String customerNo, String customerName) {
        this.customerNo = customerNo;
        this.customerName = customerName;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerNo.equals(customer.customerNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNo);
    }
}
