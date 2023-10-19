package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import guru.springframework.msscbrewery.web.model.CustomerDTO;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

  @Override
  public CustomerDTO getCustomerById(UUID customerId) {
    return  CustomerDTO.builder()
        .id(UUID.randomUUID())
        .name("Andre S Nascimento")
        .build();
  }
}
