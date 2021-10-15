import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomerList {
    private final List<Customer> list;

    public CustomerList() {
        list = new ArrayList<>();
        String file = Paths.get("").toAbsolutePath().toString();

        try (BufferedReader rf = new BufferedReader(new FileReader(file + "/Customers.txt"))) {
            String line;

            while ((line = rf.readLine()) != null) {
                String[] fields = line.split(",");
                list.add(new Customer(fields[0], fields[1]));
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(String id) {
        Customer customer = null;
        if (id != null && !id.equals("")) {
            customer = list.get(list.indexOf(new Customer(id, null)));
        }

        return customer;
    }
}

