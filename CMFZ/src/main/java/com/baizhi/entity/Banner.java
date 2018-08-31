package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sea on 2018/8/29.
 */
public class Banner implements Serializable {
    private Integer id;
    private String imgPath;
    private String title;
    private String description;
    private String status;
    private Date createDate;

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", imgPath='" + imgPath + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Banner banner = (Banner) o;

        if (!id.equals(banner.id)) return false;
        if (!imgPath.equals(banner.imgPath)) return false;
        if (!title.equals(banner.title)) return false;
        if (!description.equals(banner.description)) return false;
        if (!status.equals(banner.status)) return false;
        return createDate.equals(banner.createDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + imgPath.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + createDate.hashCode();
        return result;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Banner() {

    }

    public Banner(Integer id, String imgPath, String title, String description, String status, Date createDate) {

        this.id = id;
        this.imgPath = imgPath;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
    }
}
