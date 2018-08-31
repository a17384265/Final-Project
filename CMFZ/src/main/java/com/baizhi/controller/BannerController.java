package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * Created by sea on 2018/8/29.
 */
@Controller
@RequestMapping("/Banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @ResponseBody
    @RequestMapping("/showAllBanners.do")
    public Map<String, Object> show(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        int total = bannerService.count();
        List<Banner> list = bannerService.showAllBannersByPage(page, rows);
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("addBanners")
    public void addBanner(String status, String description, String title, MultipartFile img, HttpServletRequest request) {
        String realPath = request.getServletContext().getRealPath("/");
        String uploadFilePath = realPath + "upload";
        File file = new File(uploadFilePath);
        if (!file.exists()) {
            file.mkdir();
        }
        String originalFilename = img.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName = uuid + "." + extension;
        try {
            img.transferTo(new File(uploadFilePath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Banner banner = new Banner();
        banner.setImgPath("/upload/" + newName);
        banner.setDescription(description);
        banner.setTitle(title);
        banner.setStatus(status);
        banner.setCreateDate(new Date());
        bannerService.add(banner);
        System.out.println(banner);
    }

    @RequestMapping("/delete.do")
    public void deleteRow(int id) {
        bannerService.delete(id);
    }

    @RequestMapping("/updateBanner.do")
    public void update(String description, String status, String title, int id) {
        Banner banner = new Banner();
        banner.setId(id);
        banner.setStatus(status);
        banner.setTitle(title);
        banner.setDescription(description);
        bannerService.update(banner);
    }
}
