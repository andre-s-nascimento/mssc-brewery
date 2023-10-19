package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDTOV2;
import guru.springframework.msscbrewery.web.services.v2.BeerServiceV2;
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

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

  private final BeerServiceV2 beerServiceV2;

  public BeerControllerV2(BeerServiceV2 beerServiceV2) {
    this.beerServiceV2 = beerServiceV2;
  }

  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDTOV2> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity handlePost(@RequestBody BeerDTOV2 beerDTO) {
    BeerDTOV2 savedDTO = beerServiceV2.saveNewBeer(beerDTO);

    HttpHeaders headers = new HttpHeaders();
    //todo add hostname to url
    headers.add("Location", "/api/v1/beer/" + savedDTO.getId().toString());

    return new ResponseEntity(headers, HttpStatus.CREATED);
  }

  @PutMapping("{/{beerId}")
  public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,
      @RequestBody BeerDTOV2 beerDTO) {
    beerServiceV2.updateBeer(beerId, beerDTO);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("{/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("beerId") UUID beerId) {
    beerServiceV2.deleteById(beerId);
  }
}
