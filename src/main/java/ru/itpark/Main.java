package ru.itpark;

import ru.itpark.comparator.AscPriceComparator;
import ru.itpark.comparator.DescPriceComparator;
import ru.itpark.domain.Product;
import ru.itpark.repository.ProductRepository;
import ru.itpark.servce.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService(
                new ProductRepository()
        );

        service.add(new Product(15136, 50, "Iphone", "Смартфон"));
        service.add(new Product(77894, 15, "Samsung", "Смартфон"));
        service.add(new Product(15645, 45, "Пазлы", "Игрушки"));
        service.add(new Product(16487, 28, "Гвоздодер", "Инструменты"));
        service.add(new Product(02165, 10, "Фонарик", "Все для дома"));


        List<String> names = new ArrayList<>();
        names.add("Фонарик");
        names.add("Пазлы");
        System.out.println(service.findByName(names));

        System.out.println(service.findByCategory("Смартфон"));
    }
}
