package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

  @Override
  public BeerDTO getBeerById(UUID beerId) {
    return BeerDTO.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale Ale")
        .build();
  }

  @Override
  public BeerDTO saveNewBeer(BeerDTO beerDTO) {
    return BeerDTO.builder().id(UUID.randomUUID()).build();
  }

  @Override
  public void updateBeer(UUID beerId, BeerDTO beerDTO) {
    //todo impl
  }

  @Override
  public void deleteById(UUID beerId) {
    log.debug("Deleting a beer...");
  }

}
