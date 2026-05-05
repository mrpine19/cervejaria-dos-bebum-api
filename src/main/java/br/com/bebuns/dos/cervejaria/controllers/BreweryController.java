package br.com.bebuns.dos.cervejaria.controllers;

import br.com.bebuns.dos.cervejaria.models.Brewery;
import br.com.bebuns.dos.cervejaria.repositorys.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/breweries")
@RequiredArgsConstructor
public class BreweryController {

    private BreweryRepository breweryRepository;

    @GetMapping
    public Page<Brewery> listAllBreweries(Pageable pageable){
        return breweryRepository.findAll(pageable);
    }


}
