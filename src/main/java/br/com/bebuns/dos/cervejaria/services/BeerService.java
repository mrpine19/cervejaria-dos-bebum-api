package br.com.bebuns.dos.cervejaria.services;

import br.com.bebuns.dos.cervejaria.models.Beer;
import br.com.bebuns.dos.cervejaria.repositorys.BeerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<Beer> getAllBeers(){
        return beerRepository.findAll();
    }

    public Beer findById(Long id) {
        return beerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beer not found :(")
        );
    }
}
