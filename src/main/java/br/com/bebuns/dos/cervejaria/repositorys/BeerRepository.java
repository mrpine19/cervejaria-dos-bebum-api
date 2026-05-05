package br.com.bebuns.dos.cervejaria.repositorys;

import br.com.bebuns.dos.cervejaria.models.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findAllByBreweriesId(Long id);
}
