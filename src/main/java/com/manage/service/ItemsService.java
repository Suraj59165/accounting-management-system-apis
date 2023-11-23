package com.manage.service;

import com.manage.dto.ItemsDto;
import com.manage.payloads.PageableResponse;

import java.util.List;

public interface ItemsService {

    List<ItemsDto> createItem(List<ItemsDto> itemsDto);


    ItemsDto getItemById(String itemId);

    void deleteItems(String itemId);

    PageableResponse<ItemsDto> getAllItems(int pageNumber, int pageSize, String sortBy, String sortDirection);

    ItemsDto updateItems(String oldItemId, ItemsDto newItemData);
}
