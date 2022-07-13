package com.brandontarrant.soloproject.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.brandontarrant.soloproject.models.LoginUser;
import com.brandontarrant.soloproject.models.User;
import com.brandontarrant.soloproject.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	public User register(User newUser, BindingResult result) {
		
		Optional<User> possibleUser = userRepo.findByEmail(newUser.getEmail());
		
		if(possibleUser.isPresent()) {
			result.rejectValue("email", "Matches", "That email is already taken.");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Your password's don't match.");
		}
		if(result.hasErrors()) {
			return null;
		}
		
		String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		
		newUser.setPassword(hashedPW);
		
		return userRepo.save(newUser);
	}

	
	public User login(LoginUser newLogin, BindingResult result) {
		
		Optional<User> possibleUser = userRepo.findByEmail(newLogin.getEmail());
		
		if(!possibleUser.isPresent()) {
			result.rejectValue("email", "Match", "Please enter valid email and password.");
		}
		
		User user = possibleUser.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("email", "Match", "Please enter valid email and password.");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		return user;
	}
	
	
	public User findById(Long id) {
		Optional<User> possibleUser = userRepo.findById(id);
		if(possibleUser.isPresent()) {
			return possibleUser.get();
		}
		return null;
	}
	
	
	public List<User> getAll() {
		return (List<User>) userRepo.findAll();
	}
}

