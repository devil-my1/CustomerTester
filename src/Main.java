import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String file = Paths.get("").toAbsolutePath().toString();
        ProductList pl = new ProductList();
        CustomerList cl = new CustomerList();
        Map<Customer, List<Product>> detail = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        int index = 0;
        int sum = 0;

        try (BufferedReader rf = new BufferedReader(new FileReader(file + "/PurchDetails.txt"))) {
            String line;

            while ((line = rf.readLine()) != null) {
                String[] fields = line.split(",");
                List<Product> pds = new ArrayList<>();

                for (Customer c : detail.keySet())
                    if (c != null && c.equals(cl.getCustomerById(fields[0])))
                        pds = detail.get(cl.getCustomerById(fields[0]));

                pds.add(pl.getProductById(fields[1]));
                counts.put(index++, Integer.parseInt(fields[2]));
                detail.put(cl.getCustomerById(fields[0]), pds);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        index = 0;
        for (Map.Entry<Customer, List<Product>> m : detail.entrySet()) {
            System.out.printf("%s  %s :%n", (m.getKey()).getCustomerNo(), (m.getKey()).getCustomerName());
            for (Product p : (m.getValue())) {
                int res = p.getPrice() * counts.get(index);
                System.out.printf("\t%s\t\t\t%s * %s = %s%n", p.getProdName(), p.getPrice(), counts.get(index++), res);
                sum += res;
            }
            System.out.println("\t\t\t\t\t----------------");
            System.out.printf("\t\t\t\t\tTotal : %s%n", sum);
            System.out.println();
        }
    }
}
