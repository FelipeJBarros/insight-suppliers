package com.flpbrrs.insight_suppliers.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> {
    private List<T> content;
    private long totalElements;
    private int totalPages;
    private int currentPage;

    public static <T> PageDTO<T> from(Page<T> page) {
        return new PageDTO<>(
                page.getContent(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getPageable().getPageNumber()
        );
    }
}
