package com.manage.service.impl;

import com.manage.dto.ItemsDto;
import com.manage.entities.Items;
import com.manage.exception.ResourceNotFoundException;
import com.manage.helper.Helper;
import com.manage.payloads.PageableResponse;
import com.manage.repositories.ItemsRepo;
import com.manage.service.ItemsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemsRepo itemsRepo;

    @Override
    public List<ItemsDto> createItem(List<ItemsDto> itemsDto) {
        List<ItemsDto> itemsDtos = new ArrayList<>();
        for(ItemsDto itemsDto1:itemsDto)
        {
            itemsDto1.setId(UUID.randomUUID().toString());
            itemsDtos.add(modelMapper.map(itemsRepo.save(modelMapper.map(itemsDto1,Items.class)),ItemsDto.class));

        }

        return itemsDtos;
    }

    @Override
    public ItemsDto getItemById(String itemId) {

        return modelMapper.map(itemsRepo.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("oops item not found with id " + itemId)), ItemsDto.class);
    }

    @Override
    public void deleteItems(String itemId) {
        itemsRepo.delete(itemsRepo.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("oops item not found with id " + itemId)));

    }

    @Override
    public PageableResponse<ItemsDto> getAllItems(int pageNumber, int pageSize, String sortBy, String sortDirection) {
        System.out.println("running");
        return Helper.getPageableResponse(itemsRepo.findAll(PageRequest.of(pageNumber, pageSize, sortDirection.equalsIgnoreCase(sortBy) ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending())), ItemsDto.class);
    }

    @Override
    public ItemsDto updateItems(String oldItemId, ItemsDto newItemData) {
        Items items = itemsRepo.findById(oldItemId).orElseThrow(() -> new ResourceNotFoundException("oops item not found with id " + oldItemId));
        items.setItemName(newItemData.getItemName());
        items.setItemSalesPrice(newItemData.getItemSalesPrice());
        items.setItemOffer(newItemData.getItemOffer());
        items.setItemTax(newItemData.getItemTax());
        items.setItemFinalPrice(newItemData.getItemFinalPrice());
        return modelMapper.map(itemsRepo.save(items), ItemsDto.class);


    }
}
