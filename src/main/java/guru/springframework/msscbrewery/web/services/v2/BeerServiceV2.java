package guru.springframework.msscbrewery.web.services.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDTOV2;
import java.util.UUID;

public interface BeerServiceV2 {

  BeerDTOV2 getBeerById(UUID beerId);

  BeerDTOV2 saveNewBeer(BeerDTOV2 beerDTO);

  void updateBeer(UUID beerId, BeerDTOV2 beerDTO);

  void deleteById(UUID beerId);
}
