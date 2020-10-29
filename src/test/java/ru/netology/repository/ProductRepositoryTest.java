package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book coreJava = new Book();

  @Test
  public void shouldSaveOneItem() {
    repository.save(coreJava);

    Product[] expected = new Product[]{coreJava};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  void shouldRemoveExistItemById() {
    Product product = new Product(1, "Test", 345);
    repository.save(product);

    repository.removeById(1);

    Product[] expected = new Product[]{};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  void shouldNotRemoveNotExistItemById() {
    assertThrows(NotFoundException.class, () -> repository.removeById(1));
  }
}
