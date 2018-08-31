package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by sea on 2018/8/30.
 */
public interface AlbumService {
    public List<Album> queryAll();

    public void add(Album album);
}
