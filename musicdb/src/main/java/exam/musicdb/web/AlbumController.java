package exam.musicdb.web;

import exam.musicdb.model.binding.AlbumBindingModel;
import exam.musicdb.model.service.AlbumServiceModel;
import exam.musicdb.model.service.UserServiceModel;
import exam.musicdb.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addAlbum(HttpSession httpSession, Model model){
        if (httpSession.getAttribute("user") == null){
            return "redirect:/";
        } else {
            if (!model.containsAttribute("albumBindingModel")){
                model.addAttribute("albumBindingModel", new AlbumBindingModel());
            }
            return "add-album";
        }
    }

    @PostMapping("/add")
    public String addTaskConfirm(@Valid @ModelAttribute("albumBindingModel") AlbumBindingModel albumBindingModel,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                 HttpSession httpSession){
        if (httpSession.getAttribute("user") != null) {
            if (bindingResult.hasErrors()) {
                redirectAttributes.addFlashAttribute("albumBindingModel", albumBindingModel);
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumBindingModel", bindingResult);
                return "redirect:add";
            }

            AlbumServiceModel albumServiceModel = this.modelMapper.map(albumBindingModel, AlbumServiceModel.class);
            albumServiceModel.setAddedFrom((UserServiceModel) httpSession.getAttribute("user"));
            System.out.println();
            this.albumService.saveAlbum(albumServiceModel);
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String buyItem(@PathVariable("id") String id, HttpSession httpSession){
        if (httpSession.getAttribute("user") != null) {
            this.albumService.deleteAlbum(id);
        }
        return "redirect:/";
    }
}
