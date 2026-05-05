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
    public Beer getBeerById(@PathVariable Long id){
        return beerService.findById(id);
    }

    @GetMapping("/brewery/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Beer> getBeersByBreweryId(@PathVariable Long id){
        return beerService.findByBreweryId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Beer createBeer(@RequestBody Beer beer){
        return beerService.save(beer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Beer updateBeer(@PathVariable Long id, @RequestBody Beer beer){
        return beerService.update(id, beer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable Long id){
        beerService.delete(id);
    }

}
