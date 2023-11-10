package com.manage.controllers;

import com.manage.dto.ItemsDto;
import com.manage.payloads.ApiResponse;
import com.manage.payloads.PageableResponse;
import com.manage.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @PostMapping
    public ResponseEntity<ItemsDto> AddItems(@RequestBody ItemsDto itemsDto) {
        return new ResponseEntity<>(itemsService.createItem(itemsDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PageableResponse<ItemsDto>> getAllItems(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
                                                                  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                                  @RequestParam(value = "sortBy", defaultValue = "itemName", required = false) String sortBy,
                                                                  @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection) {
        return new ResponseEntity<>(itemsService.getAllItems(pageNumber, pageSize, sortBy, sortDirection), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemsDto> getItemsById(@PathVariable String itemId) {
        return new ResponseEntity<>(itemsService.getItemById(itemId), HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<ApiResponse> deleteItem(@PathVariable String itemId) {
        itemsService.deleteItems(itemId);
        return new ResponseEntity<>(ApiResponse.builder().response("item deleted successfully").status(true).httpStatus(HttpStatus.OK).build(), HttpStatus.OK);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemsDto> updateItem(@PathVariable String itemId, @RequestBody ItemsDto itemsDto) {
        return new ResponseEntity<>(itemsService.updateItems(itemId, itemsDto), HttpStatus.OK);
    }
}
