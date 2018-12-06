package ru.itpark.servce;

import ru.itpark.comparator.AscPriceComparator;
import ru.itpark.domain.Product;
import ru.itpark.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public void add(Product product) {
        repository.add(product);
    }

    public List<Product> getAll() {
        return repository.getAll();
    }

    public List<Product> getSorted(Comparator<Product> comparator) {
        List<Product> result = repository.getAll();
        result.sort(comparator);
        return result;
    }

    public List<Product> findByName(List<String> names) {
        List<Product> result = new ArrayList<>();

        for (Product product : repository.getAll()) {
            String productName = product.getName();

            if (names.contains(productName)) {
                result.add(product);
            }
        }

        result.sort(new AscPriceComparator());
        return result;
    }


    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();

        for (Product product : repository.getAll()) {
            String houseCategory = product.getCategory();


            if (houseCategory.equals(category)) {
                result.add(product);
            }
        }

        result.sort(new AscPriceComparator());
        return result;
    }

}
