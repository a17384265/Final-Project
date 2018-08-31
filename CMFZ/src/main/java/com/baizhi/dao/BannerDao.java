package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sea on 2018/8/29.
 */
@Component(value = "bannerDao")
public interface BannerDao {
    public List<Banner> showAllBannersByPage(@Param("start") int start, @Param("limit") int limit);

    public int count();

    public void add(Banner banner);

    public void delete(int id);

    public void update(Banner banner);
}
