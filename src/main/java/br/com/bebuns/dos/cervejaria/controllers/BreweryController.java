package br.com.bebuns.dos.cervejaria.controllers;

import br.com.bebuns.dos.cervejaria.models.Brewery;
import br.com.bebuns.dos.cervejaria.repositorys.BreweryRepository;
import br.com.bebuns.dos.cervejaria.services.BreweryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/breweries")
@RequiredArgsConstructor
public class BreweryController {

    private final BreweryService breweryService;

    @GetMapping
    public Page<Brewery> listAllBreweries(Pageable pageable){
        return breweryService.listAllBreweries(pageable);
    }

    @GetMapping("{id}")
    public Optional<Brewery> findByIdBrewery(@PathVariable Long id){
        return breweryService.findByIdBrewery(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Brewery createBrewery(@RequestBody Brewery brewery){
        return breweryService.createBrewery(brewery);
    }



}
