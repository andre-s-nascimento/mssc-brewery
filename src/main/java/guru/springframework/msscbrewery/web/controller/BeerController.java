package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import guru.springframework.msscbrewery.services.BeerService;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @deprecated (when, why, refactoring advice...)
 */
@Deprecated(since = "0.0.1")
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

  private final BeerService beerService;

  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }

  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity handlePost(@Valid @RequestBody BeerDTO beerDTO) {
    BeerDTO savedDTO = beerService.saveNewBeer(beerDTO);

    HttpHeaders headers = new HttpHeaders();
    //todo add hostname to url
    headers.add("Location", "/api/v1/beer/" + savedDTO.getId().toString());

    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,
      @Valid @RequestBody BeerDTO beerDTO) {
    beerService.updateBeer(beerId, beerDTO);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("beerId") UUID beerId) {
    beerService.deleteById(beerId);
  }

}
