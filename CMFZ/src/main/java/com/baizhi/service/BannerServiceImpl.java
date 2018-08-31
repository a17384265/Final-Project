package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sea on 2018/8/29.
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;


    @Override
    public List<Banner> showAllBannersByPage(int currentPage, int rows) {
        int start = (currentPage - 1) * rows + 1;
        int limit = currentPage * rows;
        List<Banner> banners = bannerDao.showAllBannersByPage(start, limit);
        return banners;
    }

    @Override
    public int count() {
        int count = bannerDao.count();
        return count;

    }

    @Override
    public void add(Banner banner) {
        bannerDao.add(banner);
    }

    @Override
    public void delete(int id) {
        bannerDao.delete(id);
    }

    @Override
    public void update(Banner banner) {
        bannerDao.update(banner);
    }
}
