package com.manage.service;

import com.manage.dto.ItemsDto;
import com.manage.payloads.PageableResponse;

public interface ItemsService {

    ItemsDto createItem(ItemsDto itemsDto);

    ItemsDto getItemById(String itemId);

    void deleteItems(String itemId);

    PageableResponse<ItemsDto> getAllItems(int pageNumber, int pageSize, String sortBy, String sortDirection);

    ItemsDto updateItems(String oldItemId, ItemsDto newItemData);
}
