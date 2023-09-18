package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.model.Item;
import com.example.demo.service.ItemMasterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(ItemMasterController.class)
@ExtendWith(SpringExtension.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemMasterService itemService;



    private Validator validator;



//    @BeforeEach
//    public void setUp() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }


    @Test
    public void testSaveValidItem() throws Exception {
        //Create valid Item instance
        Item item = new Item();
        item.setItemId(16316);
        item.setItemCategory("furniture");
        item.setItemDescription("chair");
        item.setItemMake("wooden");
        item.setItemValuation(200);
        item.setItemStatus('Y');

        when(itemService.saveItem(Mockito.any(Item.class))).thenReturn("Item Saved");
        mockMvc.perform(MockMvcRequestBuilders.post("/saveItem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"item_id\":\"16316\",\"item_category\":\"furniture\",\"item_description\":\"chair\",\"item_make\":\"plastic\",\"item_status\":\"Y\",\"item_valuation\":\"200\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Item Saved"));
    }

    @Test
    public void testFetchItems() throws Exception {
        // Create sample data to return when the repository is called
        Item item1 = new Item();
        item1.setItemId(1);
        item1.setItemCategory("Category1");
        item1.setItemDescription("Description1");

        Item item2 = new Item();
        item2.setItemId(2);
        item2.setItemCategory("Category2");
        item2.setItemDescription("Description2");

        List<Item> items = Arrays.asList(item1, item2);

        // Mock the repository's behavior to return the sample data
        when(itemService.getAllItems()).thenReturn(items);

        // Perform a GET request to the "/fetchItems" endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/fetchItems"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2)) // Assuming it returns an array
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].itemId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].itemCategory").value("Category1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].itemDescription").value("Description1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].itemId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].itemCategory").value("Category2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].itemDescription").value("Description2"));
    }


    @Test
    public void testFetchItemMake() throws Exception {
        // Sample data for item makes
        // Create sample data to return when the repository is called
        Item item1 = new Item();
        item1.setItemId(1);
        item1.setItemCategory("Category1");
        item1.setItemDescription("Description1");
        item1.setItemMake("Make1");

        Item item2 = new Item();
        item2.setItemId(2);
        item2.setItemCategory("Category1");
        item2.setItemDescription("Description2");
        item2.setItemMake("Make2");


        Item item3 = new Item();
        item3.setItemId(2);
        item3.setItemCategory("Category1");
        item3.setItemDescription("Description2");
        item3.setItemMake("Make3");

        List<String> itemMakes = Arrays.asList("Make1", "Make2", "Make3");

        // Mock the repository's behavior to return item makes when findByItemCategory is called
        when(itemService.getItemMakeFromCategory(anyString())).thenReturn(itemMakes);

        // Perform a GET request to the "/fetchItemMake" endpoint with a category parameter
        mockMvc.perform(MockMvcRequestBuilders.get("/fetchItemMake")
                        .param("category", "Category1")) // Replace with the desired category
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3)) // Assuming it returns an array
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("Make1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value("Make2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2]").value("Make3"));
    }

    @Test
    public void testFetchItemsFromCategoryAndMake() throws Exception {
        // Sample data for items
        Item item1 = new Item();
        item1.setItemId(1);
        item1.setItemCategory("Category1");
        item1.setItemMake("Make1");

        Item item2 = new Item();
        item2.setItemId(2);
        item2.setItemCategory("Category1");
        item2.setItemMake("Make1");

        Item item3 = new Item();
        item3.setItemId(3);
        item3.setItemCategory("Category1");
        item3.setItemMake("Make1");

        List<Item> items = Arrays.asList(item1, item2, item3);

        // Mock the repository's behavior to return items when findByItemCategoryAndItemMake is called
        when(itemService.getItemFromCategoryAndMake(anyString(), anyString())).thenReturn(items);

        // Perform a GET request to the "/fetchItemsFromCategoryAndMake" endpoint with category and make parameters
        mockMvc.perform(MockMvcRequestBuilders.get("/fetchItemsFromCategoryAndMake")
                        .param("category", "Category1")
                        .param("make", "Make1")) // Include the 'itemCategory' and 'itemMake' parameters
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3)) // Assuming it returns an array
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].itemId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].itemCategory").value("Category1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].itemMake").value("Make1"));
    }




}
