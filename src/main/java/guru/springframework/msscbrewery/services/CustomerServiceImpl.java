package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDTO;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

  @Override
  public CustomerDTO getCustomerById(UUID customerId) {
    return CustomerDTO.builder().id(UUID.randomUUID()).name("Andre S Nascimento").build();
  }

  @Override
  public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
    return CustomerDTO.builder().id(UUID.randomUUID()).build();
  }

  @Override
  public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
    //todo impl
  }

  @Override
  public void deleteById(UUID customerId) {
    log.debug("Deleting a customer...");
  }

}
