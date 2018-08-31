package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sea on 2018/8/30.
 */
@Component(value = "AlbumDao")
public interface AlbumDao {
    public List<Album> queryAll();

    public void add(Album album);
}
