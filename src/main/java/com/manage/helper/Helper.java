package com.manage.helper;

import com.manage.payloads.PageableResponse;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    public static <E, D> PageableResponse<D> getPageableResponse(Page<E> page, Class<D> dtoClass) {
        List<E> entity = page.getContent();
        List<D> dto = entity.stream().map(object -> new ModelMapper().map(object, dtoClass)).collect(Collectors.toList());
        PageableResponse<D> pageableResponse = new PageableResponse<>();
        pageableResponse.setPageNumber(page.getNumber());
        pageableResponse.setPageSize(page.getSize());
        pageableResponse.setTotalPages(page.getTotalPages());
        pageableResponse.setIsLastPage(page.isLast());
        pageableResponse.setContent(dto);
        return pageableResponse;

    }
}
