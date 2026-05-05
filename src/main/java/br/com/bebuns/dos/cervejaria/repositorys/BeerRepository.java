package br.com.bebuns.dos.cervejaria.repositorys;

import br.com.bebuns.dos.cervejaria.models.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    Beer findByBreweryId(Long id);
}
