package com.brandontarrant.soloproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandontarrant.soloproject.models.Movie;
import com.brandontarrant.soloproject.repositories.MovieRepository;


@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepo;
	
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}
	
	public Movie create(Movie newMovie) {
		return movieRepo.save(newMovie);
	}
	
	public Movie getById(Long id) {
		return movieRepo.findById(id).orElse(null);
	}
	
	public Movie update(Movie editMovie) {
		return movieRepo.save(editMovie);
	}
	
	public void deleteById(Long id) {
		movieRepo.deleteById(id);
	}

}
