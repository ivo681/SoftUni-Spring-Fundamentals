package exam.musicdb.web;

import exam.musicdb.model.binding.UserLoginBindingModel;
import exam.musicdb.model.binding.UserRegisterBindingModel;
import exam.musicdb.model.service.UserServiceModel;
import exam.musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(HttpSession httpSession, Model model){
        if (httpSession.getAttribute("user") == null) {
            if (!model.containsAttribute("userLoginBindingModel")) {
                model.addAttribute("notFound", false);
                model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            }
            return "login";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/register")
    public String register(HttpSession httpSession, Model model){
        if (httpSession.getAttribute("user") == null) {
            if (!model.containsAttribute("userRegisterBindingModel")) {
                model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
            }
            return "register";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
                bindingResult.rejectValue("confirmPassword", "error.userRegisterBindingModel" ,"Passwords do not match");
            }
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        UserServiceModel existingUser = this.userService.findByUsername(userRegisterBindingModel.getUsername());
        UserServiceModel takenEmail = this.userService.findByEmail(userRegisterBindingModel.getEmail());
        if (existingUser != null || takenEmail !=null){
            if (existingUser != null){
                bindingResult.rejectValue("username", "error.userRegisterBindingModel" ,"Username is already taken");
            }
            if (takenEmail != null){
                bindingResult.rejectValue("email", "error.userRegisterBindingModel" ,"Email is already taken");
            }
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        this.userService.registerUser(userServiceModel);
        return "redirect:login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute("userLoginBindingModel") UserLoginBindingModel
                               userLoginBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                               HttpSession httpSession){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        UserServiceModel existingUser = this.userService.findByUsername(userLoginBindingModel.getUsername());
        if (existingUser == null || !existingUser.getPassword().equals(userLoginBindingModel.getPassword())){
            redirectAttributes.addFlashAttribute("notFound", true);
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        httpSession.setAttribute("user", existingUser);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        if (httpSession.getAttribute("user") != null){
            httpSession.invalidate();
        }
        return "redirect:/";
    }

}


