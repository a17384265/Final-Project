package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by sea on 2018/8/30.
 */
@Controller
@RequestMapping("/Album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/showAllAlbum.do")
    @ResponseBody
    public List<Album> show() {
        List<Album> list = albumService.queryAll();
        return list;
    }

    @RequestMapping("/addAlbums.do")
    public void add(String title, Integer count, MultipartFile corverImg, String score, String author, String broadCast, String brife, String publicDate,
                    String createDate, String status, HttpServletRequest request) throws ParseException {
        String realPath = request.getServletContext().getRealPath("/");
        String uploadFilePath = realPath + "upload";
        File file = new File(uploadFilePath);
        if (!file.exists()) {
            file.mkdir();
        }
        String originalFilename = corverImg.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName = uuid + "." + extension;
        try {
            corverImg.transferTo(new File(uploadFilePath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date publicDate1 = sdf.parse(publicDate);
        Date createDate1 = sdf.parse(createDate);
        Album album = new Album();
        album.setTitle(title);
        album.setCount(count);
        album.setCorverImg(newName);
        album.setScore(score);
        album.setAuthor(author);
        album.setBroadCast(broadCast);
        album.setBrife(brife);
        album.setPublicDate(publicDate1);
        album.setCreateDate(createDate1);
        album.setStatus(status);
        albumService.add(album);
        System.out.println(realPath);
    }
}
