package ru.itpark.comparator;

import ru.itpark.domain.Product;

import java.util.Comparator;

public class DescPriceComparator implements Comparator<Product> {
    public int compare(Product o1, Product o2) {
        return -(o1.getPrice() - o2.getPrice());
    }
    }


