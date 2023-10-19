package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.CustomerDTO;
import java.util.UUID;

public interface CustomerService {

  CustomerDTO getCustomerById(UUID customerId);

  CustomerDTO saveNewCustomer(CustomerDTO customerDTO);

  void updateCustomer(UUID customerId, CustomerDTO customerDTO);

  void deleteById(UUID customerId);
}
