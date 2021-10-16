package com.lemon.webauto.pojo;

import lombok.Data;

import java.util.List;

/**
 * Created by mgg on 2021/9/28
 */
@Data
//根据UILibrary的层级关系，创建Page对象
//同类标签，创建为同一类实体类
public class Page {
    private String keyword;
    private List<UIElement> uiElements;

    public Page(String keyword, List<UIElement> uiElements) {
        this.keyword = keyword;
        this.uiElements = uiElements;
    }
}
