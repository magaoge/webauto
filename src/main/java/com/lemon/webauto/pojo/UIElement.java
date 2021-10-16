package com.lemon.webauto.pojo;

import lombok.Data;

/**
 * Created by mgg on 2021/9/28
 */
@Data
//配置文件二级标签的实体类
public class UIElement {
    private String keyword;
    private String by;
    private String value;

    public UIElement(String keyword, String by, String value) {
        this.keyword = keyword;
        this.by = by;
        this.value = value;
    }
}
