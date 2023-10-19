package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class BeerServiceImpl implements BeerService {

  @Override
  public BeerDTO getBeerById(UUID beerId) {
    return BeerDTO.builder()
        .id(UUID.randomUUID())
        .beerName("Galaxy Cat")
        .beerStyle("Pale Ale")
        .build();
  }
}
