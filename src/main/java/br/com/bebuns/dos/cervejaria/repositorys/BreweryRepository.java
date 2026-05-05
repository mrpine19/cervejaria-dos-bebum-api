package br.com.bebuns.dos.cervejaria.repositorys;

import br.com.bebuns.dos.cervejaria.models.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {
}
