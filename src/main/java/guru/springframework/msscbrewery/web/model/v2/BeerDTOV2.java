package guru.springframework.msscbrewery.web.model.v2;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTOV2 {

  @Null
  private UUID id;

  @NotBlank
  private String beerName;

  @NotNull
  @Valid
  private BeerStyleEnum beerStyle;

  @Positive
  private Long upc;
}
