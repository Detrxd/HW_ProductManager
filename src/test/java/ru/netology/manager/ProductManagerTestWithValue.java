package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTestWithValue {

    ProductManager manager = new ProductManager();


    private Book firstBook = new Book(1, "Гарри Поттер и узник Азкабана", 500, "Джоан Роулинг");
    private Book secondBook = new Book(2, "Зеленая миля", 600, "Стивен Кинг");
    private Book thirdBook = new Book(3, "Унесенные ветром", 700, "Маргарет Митчелл");

    private Smartphone firstModel = new Smartphone(4, "Nokia", 1000, "Nokia.inc");
    private Smartphone secondModel = new Smartphone(5, "Sony", 1200, "Sony.inc");
    private Smartphone thirdModel = new Smartphone(6, "Iphone", 1400, "Apple.inc");

    @Test
    public void shouldSearchChosenAuthor() {
        manager.add(secondBook);
        manager.add(firstBook);
        manager.add(thirdBook);
        Product[] actual = manager.searchBy("Джоан Роулинг");
        Product[] expected = new Product[]{firstBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchChosenNameSmartphone() {
        manager.add(firstModel);
        manager.add(secondModel);
        manager.add(thirdModel);
        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = new Product[]{firstModel};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchChosenBookName(){
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        Product[] actual = manager.searchBy("Гарри Поттер и узник Азкабана");
        Product[] expected = new Product[]{firstBook};
        assertArrayEquals(actual,expected);
    }

    @Test
    public void shouldSearchChosenBookNameFromAnyOtherBooksName(){
        manager.add(firstBook);
        manager.add(secondBook);
        Product[] actual = manager.searchBy("Гарри Поттер и узник Азкабана");
        Product[] expected = new Product[]{firstBook , secondBook};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void Testing (){
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);

        assertArrayEquals(new Product[]{firstBook,firstModel}, manager.searchBy("Гарри Поттер"));
    }

    @Test
    public void shouldSearchChosenSmartphoneNameFromAnyOtherSmartphonesName(){
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        Product[] actual = manager.searchBy("Sony");
        Product[] expected = new Product[]{firstModel , secondModel , thirdModel};
        assertArrayEquals(actual,expected);
    }
}

