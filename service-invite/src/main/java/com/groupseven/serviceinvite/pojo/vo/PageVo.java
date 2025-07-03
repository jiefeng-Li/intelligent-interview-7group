package com.groupseven.serviceinvite.pojo.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageVo<T> {
    private List<T> records;
    private Long total;
    private Long pages;
    private Long size;
    private Long page;

    private PageVo(Page<T> page) {
        this.total = page.getTotal();
        this.size = page.getSize();
        this.page = page.getCurrent();
        this.records = page.getRecords();
        this.pages = page.getPages();
    }

    public static <R> PageVo<R> of(Page<R> page) {
        return new PageVo<>(page);
    }
}