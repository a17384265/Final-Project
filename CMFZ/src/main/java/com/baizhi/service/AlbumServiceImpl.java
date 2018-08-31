package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sea on 2018/8/30.
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public List<Album> queryAll() {

        List<Album> albums = albumDao.queryAll();
        return albums;
    }

    @Override
    public void add(Album album) {
        albumDao.add(album);
    }

}
