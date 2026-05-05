package br.com.bebuns.dos.cervejaria.controllers;

import br.com.bebuns.dos.cervejaria.models.Beer;
import br.com.bebuns.dos.cervejaria.models.Brewery;
import br.com.bebuns.dos.cervejaria.repositorys.BreweryRepository;
import br.com.bebuns.dos.cervejaria.services.BreweryService;
import io.swagger.v3.oas.annotations.Operation;
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
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Brewery",
            summary = "Lista todas as cervejarias",
            description = "Retorna uma lista com todas as cervejarias cadastradas no sistema."
    )
    public Page<Brewery> listAllBreweries(Pageable pageable){
        return breweryService.listAllBreweries(pageable);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Brewery",
            summary = "Busca uma cervejaria pelo ID",
            description = "Retorna os uma cervejaria especifica."
    )
    public Optional<Brewery> findByIdBrewery(@PathVariable Long id){
        return breweryService.findByIdBrewery(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            tags = "Brewery",
            summary = "Cadastra uma nova cervejaria",
            description = "Cria um novo registro de cervejaria no sistema com os dados fornecidos no corpo da requisição."
    )
    public Brewery createBrewery(@RequestBody Brewery brewery){
        return breweryService.createBrewery(brewery);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Brewery",
            summary = "Atualiza uma cervejaria existente",
            description = "Atualiza os dados de uma cervejaria específica com base no ID fornecido. Os novos dados devem ser passados no corpo da requisição."
    )
    public Brewery updateBrewery(@PathVariable Long id, @RequestBody Brewery brewery){
        return breweryService.update(id, brewery);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            tags = "Brewery",
            summary = "Remove uma cervejaria",
            description = "Exclui permanentemente o registro de uma cervejaria específica do sistema com base no ID fornecido."
    )
    public void deleteBrewery(@PathVariable Long id){
        breweryService.delete(id);
    }

}
