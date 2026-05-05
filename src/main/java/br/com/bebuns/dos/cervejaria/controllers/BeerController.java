package br.com.bebuns.dos.cervejaria.controllers;

import br.com.bebuns.dos.cervejaria.models.Beer;
import br.com.bebuns.dos.cervejaria.services.BeerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beers")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Beer",
            summary = "Lista todas as cervejas",
            description = "Retorna uma lista com todas as cervejas cadastradas no sistema."
    )
    public List<Beer> getAllBeer(){
        return beerService.getAllBeers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Beer",
            summary = "Busca uma cerveja pelo ID",
            description = "Retorna os detalhes de uma cerveja específica com base no ID fornecido."
    )
    public Beer getBeerById(@PathVariable Long id){
        return beerService.findById(id);
    }

    @GetMapping("/brewery/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Beer",
            summary = "Lista cervejas por cervejaria",
            description = "Retorna uma lista de todas as cervejas que pertencem a uma cervejaria específica com base no ID da cervejaria."
    )
    public List<Beer> getBeersByBreweryId(@PathVariable Long id){
        return beerService.findByBreweryId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            tags = "Beer",
            summary = "Cadastra uma nova cerveja",
            description = "Cria um novo registro de cerveja no sistema com os dados fornecidos no corpo da requisição."
    )
    public Beer createBeer(@RequestBody Beer beer){
        return beerService.save(beer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            tags = "Beer",
            summary = "Atualiza uma cerveja existente",
            description = "Atualiza os dados de uma cerveja específica com base no ID fornecido. Os novos dados devem ser passados no corpo da requisição."
    )
    public Beer updateBeer(@PathVariable Long id, @RequestBody Beer beer){
        return beerService.update(id, beer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            tags = "Beer",
            summary = "Remove uma cerveja",
            description = "Exclui permanentemente o registro de uma cerveja específica do sistema com base no ID fornecido."
    )
    public void deleteBeer(@PathVariable Long id){
        beerService.delete(id);
    }

}
