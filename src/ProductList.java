import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private final List<Product> list;

    public ProductList() {
        list = new ArrayList<>();
        String file = Paths.get("").toAbsolutePath().toString();


        try (BufferedReader rf = new BufferedReader(new FileReader(file + "/Products.txt"))) {
            String line;

            while ((line = rf.readLine()) != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], fields[1], Integer.parseInt(fields[2])));
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(String id) {
        Product product = null;
        if (id != null && !id.equals("")) {
            product = list.get(list.indexOf(new Product(id, null, 0)));
        }

        return product;
    }
}
