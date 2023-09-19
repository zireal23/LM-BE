package com.example.demo.serviceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemMasterRepository;
import com.example.demo.service.ItemMasterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class ItemServiceTests {

    @Mock
    ItemMasterRepository itemRepository ;

    @InjectMocks
    ItemMasterService itemService;

    private Item item;


    @BeforeEach
    void setUp() {
        this.item=new Item(123,"chair",'Y',"wooden","furniture",50);
    }

    @Test
    void saveItem() {

        when(itemRepository.save(item)).thenReturn(item);

        String savedItem = itemService.saveItem(item);

        assertThat(savedItem).isEqualTo("Item saved");
        verify(itemRepository, times(1)).save(item);
    }

    @Test
    void getItemMakeFromCategory() {

        String category = "furniture";

        List<String> expectedMakes = Arrays.asList("chair", "table");

        when(itemRepository.getItemMakeFromCategory(category)).thenReturn(expectedMakes);

        List<String> makes = itemService.getItemMakeFromCategory(category);

        assertThat(makes).isNotNull();
        assertEquals(expectedMakes,makes);
        verify(itemRepository, times(1)).getItemMakeFromCategory(category);

    }

    @Test
    void getItemsForSpecficCategoryAndMake() {
        String category = "furniture";
        String make = "wooden";

        List<Item> expectedItems = Arrays.asList(
                new Item(1234,"chair",'Y',"wooden","furniture",50),
                new Item(1234,"table",'Y',"wooden","furniture",100)
        );
        when(itemRepository.getItemFromCategoryAndMake(category, make)).thenReturn(expectedItems);
        List<Item> items = itemService.getItemFromCategoryAndMake(category, make);

        assertThat(items).isNotNull();
        assertEquals(expectedItems,items);
        verify(itemRepository, times(1)).getItemFromCategoryAndMake(category, make);

    }

}