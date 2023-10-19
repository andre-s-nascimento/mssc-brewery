package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import java.util.UUID;
import org.springframework.stereotype.Service;

public interface BeerService {
  BeerDTO getBeerById(UUID beerId);

}
