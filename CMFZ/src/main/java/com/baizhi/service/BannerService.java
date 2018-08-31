package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * Created by sea on 2018/8/29.
 */
public interface BannerService {
    public List<Banner> showAllBannersByPage(int currentPage, int rows);

    public int count();

    public void add(Banner banner);

    public void delete(int id);

    public void update(Banner banner);
}
