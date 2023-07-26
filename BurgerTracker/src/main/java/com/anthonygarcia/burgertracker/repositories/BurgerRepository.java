package com.anthonygarcia.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anthonygarcia.burgertracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long>{
    // this method retrieves all the books from the database
    List<Burger> findAll();
    // this method finds books with descriptions containing the search string
    List<Burger> findByBurgerNameContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByBurgerNameContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByBurgerNameStartingWith(String search);
}
