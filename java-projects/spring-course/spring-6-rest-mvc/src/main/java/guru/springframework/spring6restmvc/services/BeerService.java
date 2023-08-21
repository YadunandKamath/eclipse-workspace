package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    List<BeerDTO> listBeer();
    Optional<BeerDTO> getBeerByID(UUID id);
    BeerDTO saveBeer(BeerDTO beerDTO);
    void updateBeerById(UUID beerId, BeerDTO beerDTO);
    String deleteBeerById(UUID beerId);
}
