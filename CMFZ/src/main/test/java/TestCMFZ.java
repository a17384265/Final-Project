import com.baizhi.CMFZAPP;
import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
import com.baizhi.service.AlbumService;
import com.baizhi.service.BannerService;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by sea on 2018/8/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CMFZAPP.class)
public class TestCMFZ {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private MenuService menuService;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumDao albumDao;

    @Test
    public void test1() {
        List<Menu> list = menuService.showAll();
        for (Menu m : list) {
            System.out.println(m);
        }
    }

    @Test
    public void test2() {
        List<Banner> banners = bannerService.showAllBannersByPage(1, 2);
        for (Banner b : banners) {
            System.out.println(b);
        }
    }

    @Test
    public void test3() {
        Banner banner = new Banner();
        banner.setCreateDate(new Date());
        banner.setStatus("Y");
        banner.setTitle("李白");
        banner.setDescription("一张轮播图");
        banner.setImgPath("/pic/葫芦娃.jpg");
        bannerService.add(banner);
    }

    @Test
    public void test4() {
        Album album = new Album();
        albumService.add(album);
    }

}
