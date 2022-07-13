package com.brandontarrant.soloproject.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.brandontarrant.soloproject.models.LoginUser;
import com.brandontarrant.soloproject.models.Movie;
import com.brandontarrant.soloproject.models.User;
import com.brandontarrant.soloproject.services.MovieService;
import com.brandontarrant.soloproject.services.UserService;


@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/home")
	public String movies(Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("allMovies", movieService.getAll());
		model.addAttribute("user", userService.findById((Long) session.getAttribute("userId")));
		return "index.jsp";
	}
	
	
	@GetMapping("/movies/new")
	public String newMovie(@Valid @ModelAttribute("newMovie") Movie newMovie, BindingResult result, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("newMovie", newMovie);
		model.addAttribute("allUsers", userService.getAll());
		model.addAttribute("user", userService.findById((Long) session.getAttribute("userId")));
		return "newMovie.jsp";
	}
	
	
	@PostMapping("/movies/create")
	public String createMovie(@Valid @ModelAttribute("newMovie") Movie newMovie, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userService.findById((Long) session.getAttribute("userId")));
		model.addAttribute("newMovie", newMovie);
		movieService.create(newMovie);
		return "redirect:/home";
	}
	
	
	@GetMapping("/movies/{id}")
	public String viewMovie(@PathVariable Long id, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("movie", movieService.getById(id));
		model.addAttribute("allUsers", userService.findById((Long) session.getAttribute("userId")));
		return "viewMovie.jsp";
	}
	
	
	@GetMapping("/movies/{id}/edit")
	public String editMovie(@PathVariable Long id, @ModelAttribute("editMovie") Movie editMovie, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("movie", movieService.getById(id));
		return "editMovie.jsp";
	}
	
	
	@PutMapping("/movies/{id}/update")
	public String updateMovie(@Valid @ModelAttribute("editMovie") Movie editMovie, BindingResult result, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			model.addAttribute(editMovie);
			return "editMovie.jsp";
		}
		movieService.update(editMovie);
		return "redirect:/home";
	}
	
	
	@DeleteMapping("/movies/{id}/destroy")
	public String destroyMovie(@PathVariable Long id, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		movieService.deleteById(id);
		return "redirect:/home";
	}
	
	
	@GetMapping("/")
    public String index(Model model) {
    
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	
    	User user = userService.register(newUser, result);
        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }
	
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	
    	User user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        session.setAttribute("userId", user.getId());
 
        return "redirect:/home";
    }
	
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	
    	return "redirect:/";
    }
}
