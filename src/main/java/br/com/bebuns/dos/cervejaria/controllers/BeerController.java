package br.com.bebuns.dos.cervejaria.controllers;

import br.com.bebuns.dos.cervejaria.models.Beer;
import br.com.bebuns.dos.cervejaria.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beers")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Beer> getAllBeer(){
        return beerService.getAllBeers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Beer getBeerById(@RequestParam Long id){
        return beerService.findById(id);
    }

}
