package exam.musicdb.web;


import exam.musicdb.model.view.AlbumViewModel;
import exam.musicdb.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final AlbumService albumService;

    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView){
        if (httpSession.getAttribute("user") == null){
            modelAndView.setViewName("index");
        } else {
            List<AlbumViewModel> allAlbums = this.albumService.findAllAlbums();
            Long totalSoldCopies = this.albumService.totalSoldCopies();
            modelAndView.addObject("albums", allAlbums);
            modelAndView.addObject("total", totalSoldCopies != null ? totalSoldCopies : 0);
            modelAndView.setViewName("home");
        }
        return  modelAndView;
    }
}
