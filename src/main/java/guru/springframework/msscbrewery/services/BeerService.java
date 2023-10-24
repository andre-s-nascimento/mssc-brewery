package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import java.util.UUID;
import org.springframework.stereotype.Service;

public interface BeerService {
  BeerDTO getBeerById(UUID beerId);

  BeerDTO saveNewBeer(BeerDTO beerDTO);

  void updateBeer(UUID beerId, BeerDTO beerDTO);

  void deleteById(UUID beerId);
}
