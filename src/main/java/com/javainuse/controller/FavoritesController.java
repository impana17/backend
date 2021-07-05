package com.javainuse.controller;
import com.javainuse.db.FavoritesRepository;
import com.javainuse.model.Book;
import com.javainuse.model.Favorites;
import com.javainuse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "favorites")
public class FavoritesController {

    @Autowired
    private FavoritesRepository favoritesRepository;

    @GetMapping("/get")
    public List<Favorites> getFavourites() {
        return favoritesRepository.findAll();
    }

    @GetMapping(path = { "/{userName}" })
    public List<Favorites> getFavouritesByUser() {

        return favoritesRepository.findAll();
    }

    @PostMapping("/add")
    public void addFavorites(@RequestBody Favorites favorites) throws IOException {
        LOGGER.info("worked0");
        favoritesRepository.save(favorites);
    }

    @DeleteMapping(path = { "delete/{bookId}/{userName}" })
    public void deleteFavorite(@PathVariable("bookId") long bookId,@PathVariable("userName") String userName) {
        favoritesRepository.deleteByBookId(bookId,userName);
    }

    @DeleteMapping("/delete" )
    public void deleteFavorites() {
        favoritesRepository.deleteAll();
    }


}
