package br.com.bebuns.dos.cervejaria.services;

import br.com.bebuns.dos.cervejaria.models.Beer;
import br.com.bebuns.dos.cervejaria.models.Brewery;
import br.com.bebuns.dos.cervejaria.repositorys.BreweryRepository;
import lombok.RequiredArgsConstructor;
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

    public Page<Brewery> listAllBreweries(Pageable pageable){
        return breweryRepository.findAll(pageable);
    }

    public Optional<Brewery> findByIdBrewery(Long id){
        return breweryRepository.findById(id);
    }

    public Brewery createBrewery(Brewery brewery){
        return breweryRepository.save(brewery);
    }

    public Brewery update(Long id, Brewery updatedBrewery) {
        Brewery existingBrewery = breweryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brewery not found :(")
        );

        existingBrewery.setName(updatedBrewery.getName());
        existingBrewery.setCountry(updatedBrewery.getCountry());
        return breweryRepository.save(existingBrewery);
    }

}
