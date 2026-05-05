package br.com.bebuns.dos.cervejaria.services;

import br.com.bebuns.dos.cervejaria.models.Beer;
import br.com.bebuns.dos.cervejaria.models.Brewery;
import br.com.bebuns.dos.cervejaria.repositorys.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BreweryService {

    private final BreweryRepository breweryRepository;

    @Cacheable(value = "breweries")
    public Page<Brewery> listAllBreweries(Pageable pageable){
        return breweryRepository.findAll(pageable);
    }

    @Cacheable(value = "brewery")
    public Optional<Brewery> findByIdBrewery(Long id){
        return breweryRepository.findById(id);
    }

    @CacheEvict(value = {"brewery", "breweryByBrewery", "brewery"})
    public Brewery createBrewery(Brewery brewery){
        return breweryRepository.save(brewery);
    }

    @CacheEvict(value = {"brewery", "breweryByBrewery", "brewery"})
    public Brewery update(Long id, Brewery updatedBrewery) {
        Brewery existingBrewery = breweryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brewery not found :(")
        );

        existingBrewery.setName(updatedBrewery.getName());
        existingBrewery.setCountry(updatedBrewery.getCountry());
        return breweryRepository.save(existingBrewery);
    }

    @CacheEvict(value = {"brewery", "breweryByBrewery", "brewery"}, allEntries = true)
    public void delete(Long id) {
        Brewery existingBrewery = breweryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beer not found :(")
        );
        breweryRepository.delete(existingBrewery);
    }
}
