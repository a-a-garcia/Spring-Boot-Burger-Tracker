package com.anthonygarcia.burgertracker.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.anthonygarcia.burgertracker.models.Burger;
import com.anthonygarcia.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	    // adding the book repository as a dependency
	    private final BurgerRepository burgerRepository;
	    
	    public BurgerService(BurgerRepository burgerRepository) {
	        this.burgerRepository = burgerRepository;
	    }
	    // returns all the books
	    public List<Burger> allBurgers() {
	        return burgerRepository.findAll();
	    }
	    // creates a book
	    public Burger createBurger(Burger b) {
	        return burgerRepository.save(b);
	    }
	    // update a book - it's the same as create, however if a primary key already exists, it will update instead of create.
	    public Burger updateBurger(Burger b) {
	        return burgerRepository.save(b);
	    }
	    // retrieves a book
	    public Burger findBurger(Long id) {
	        Optional<Burger> optionalBurger = burgerRepository.findById(id);
	        if(optionalBurger.isPresent()) {
	            return optionalBurger.get();
	        } else {
	            return null;
	        }
	    }
	    // delete a book
	    public void deleteBurger(Long id) {
	    	burgerRepository.deleteById(id);
	    }
	    //will return any books that contain the "search" string.
	    public List<Burger> booksContaining(String search) {
	    	return burgerRepository.findByBurgerNameContaining(search);
	}


}
