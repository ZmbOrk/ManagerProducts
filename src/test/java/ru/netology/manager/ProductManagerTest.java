package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(1, "Сердце Пандоры", 596, "Мотидзуки Д");
    private Product second = new Book(2, "Пищеблок", 660, "Иванов А.");
    private Product third = new Book(3, "Берсерк. Том I", 730, "Миура К.");
    private Product fourth = new Book(4, "Проекты с использованием контроллера Arduino", 580, "Петин В.");
    private Product fifth = new Smartphone(5, "Apple iPhone 6", 22000, "Apple");
    private Product sixth = new Smartphone(6, "Samsung Galaxy S7", 35000, "SAMSUNG");
    private Product seventh = new Smartphone(7, "Honor 9C", 10000, "HONOR");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
    }

    @Test
    public void searchBookByAuthor() {
        Product[] actual = manager.searchBy("Мотидзуки Д");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBookByName() {
        Product[] actual = manager.searchBy("Пищеблок");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByManufacturer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByName() {
        Product[] actual = manager.searchBy("Samsung Galaxy S7");
        Product[] expected = new Product[]{sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProductByProducer() {
        Product[] actual = manager.searchBy("SAMSUNG");
        Product[] expected = new Product[]{sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProductNonList() {
        Product[] actual = manager.searchBy(null);
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}