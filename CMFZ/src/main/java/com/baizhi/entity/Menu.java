package com.baizhi.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sea on 2018/8/28.
 */
@Component
public class Menu implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private String href;
    private String iconCls;
    private Integer parentId;
    private List<Menu> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parentId=" + parentId +
                ", list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (!id.equals(menu.id)) return false;
        if (!title.equals(menu.title)) return false;
        if (!content.equals(menu.content)) return false;
        if (!href.equals(menu.href)) return false;
        if (!iconCls.equals(menu.iconCls)) return false;
        if (!parentId.equals(menu.parentId)) return false;
        return list.equals(menu.list);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + href.hashCode();
        result = 31 * result + iconCls.hashCode();
        result = 31 * result + parentId.hashCode();
        result = 31 * result + list.hashCode();
        return result;
    }

    public Menu(Integer id, String title, String content, String href, String iconCls, Integer parentId, List<Menu> list) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.href = href;
        this.iconCls = iconCls;
        this.parentId = parentId;
        this.list = list;
    }

    public Menu() {

    }
}
