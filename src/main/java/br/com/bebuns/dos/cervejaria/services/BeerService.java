package br.com.bebuns.dos.cervejaria.services;

import br.com.bebuns.dos.cervejaria.models.Beer;
import br.com.bebuns.dos.cervejaria.repositorys.BeerRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value = "beers")
    public List<Beer> getAllBeers(){
        return beerRepository.findAll();
    }

    @Cacheable(value = "beer")
    public Beer findById(Long id) {
        return beerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beer not found :(")
        );
    }

    @Cacheable(value = "beersByBrewery")
    public List<Beer> findByBreweryId(Long id) {
        return beerRepository.findAllByBreweriesId(id);
    }

    @CacheEvict(value = {"beers", "beersByBrewery", "beer"})
    public Beer save(Beer beer) {
        return beerRepository.save(beer);
    }

    @CacheEvict(value = {"beers", "beersByBrewery", "beer"})
    public Beer update(Long id, Beer updatedBeer) {
        Beer existingBeer = beerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beer not found :(")
        );

        existingBeer.setName(updatedBeer.getName());
        existingBeer.setDescription(updatedBeer.getDescription());
        existingBeer.setAlcoholContent(updatedBeer.getAlcoholContent());
        existingBeer.setHarmonization(updatedBeer.getHarmonization());
        existingBeer.setBreweries(updatedBeer.getBreweries());
        return beerRepository.save(existingBeer);
    }

    @CacheEvict(value = {"beers", "beersByBrewery", "beer"}, allEntries = true)
    public void delete(Long id) {
        Beer existingBeer = beerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beer not found :(")
        );
        beerRepository.delete(existingBeer);
    }
}
