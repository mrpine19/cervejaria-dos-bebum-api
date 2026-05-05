package br.com.bebuns.dos.cervejaria.services;

import br.com.bebuns.dos.cervejaria.models.Brewery;
import br.com.bebuns.dos.cervejaria.repositorys.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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


}
