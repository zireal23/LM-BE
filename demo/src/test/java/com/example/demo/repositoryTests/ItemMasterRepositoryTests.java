package com.example.demo.repositoryTests;

import com.example.demo.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ItemMasterRepositoryTests {

    @Autowired
    ItemMasterRepository itemRepo;


    @Test
    public void itemRepositorySaveReturnsItem() {

        //Arrange
        Item item = new Item();
        item.setItemId(16316);
        item.setItemCategory("furniture");
        item.setItemMake("wooden");
        item.setItemDescription("chair");
        item.setItemValuation(200);
        item.setItemStatus('Y');


        //Act, save the item object and Assert
        Assertions.assertDoesNotThrow(() -> itemRepo.save(item));
    }


    @Test
    public void itemRepositoryFindAllReturnsListOfItems() {

        //Arrange
        Item item1 = new Item();
        item1.setItemId(16316);
        item1.setItemCategory("furniture");
        item1.setItemMake("wooden");
        item1.setItemDescription("chair");
        item1.setItemValuation(200);
        item1.setItemStatus('Y');

        Item item2 = new Item();
        item1.setItemId(16316);
        item1.setItemCategory("furniture");
        item1.setItemMake("wooden");
        item1.setItemDescription("chair");
        item1.setItemValuation(200);
        item1.setItemStatus('Y');

        //Act
        itemRepo.save(item1);
        itemRepo.save(item2);
        List<Item> allItems = itemRepo.findAll();


        //Assert
        Assertions.assertEquals(allItems.size(), 2);
    }

    @Test
    public void itemRepositoryFindByIDReturnsItem() {
        //Arrange
        Item item = new Item();
        item.setItemId(16316);
        item.setItemCategory("furniture");
        item.setItemMake("wooden");
        item.setItemDescription("chair");
        item.setItemValuation(200);
        item.setItemStatus('Y');

        //Act
        itemRepo.save(item);
        Optional<Item> savedItem = itemRepo.findById(item.getItemId());

        //Assert
        Assertions.assertTrue(savedItem.isPresent());
    }

    @Test
    public void itemRepositoryGetItemMakeFromCategoryReturnsListOfItemMakes() {
        //Arrange
        Item item1 = new Item();
        item1.setItemId(16316);
        item1.setItemCategory("furniture");
        item1.setItemMake("wooden");
        item1.setItemDescription("chair");
        item1.setItemValuation(200);
        item1.setItemStatus('Y');

        Item item2 = new Item();
        item1.setItemId(16316);
        item1.setItemCategory("furniture");
        item1.setItemMake("plastic");
        item1.setItemDescription("chair");
        item1.setItemValuation(100);
        item1.setItemStatus('Y');


        //Act
        itemRepo.save(item1);
        itemRepo.save(item2);
        List<String> itemMakes = itemRepo.getItemMakeFromCategory("furniture");

        //Assert
        Assertions.assertEquals(itemMakes.size(), 2);
    }

    @Test
    public void itemRepositoryGetItemsFromCategoryAndMakeReturnsListOfItems() {
        //Arrange
        Item item1 = new Item();
        item1.setItemId(16316);
        item1.setItemCategory("furniture");
        item1.setItemMake("wooden");
        item1.setItemDescription("chair");
        item1.setItemValuation(200);
        item1.setItemStatus('Y');

        Item item2 = new Item();
        item1.setItemId(16316);
        item1.setItemCategory("furniture");
        item1.setItemMake("plastic");
        item1.setItemDescription("chair");
        item1.setItemValuation(100);
        item1.setItemStatus('Y');


        //Act
        itemRepo.save(item1);
        itemRepo.save(item2);
        List<Item> items = itemRepo.getItemFromCategoryAndMake("furniture", "plastic");

        //Assert
        Assertions.assertEquals(items.size(), 1);
    }

}
