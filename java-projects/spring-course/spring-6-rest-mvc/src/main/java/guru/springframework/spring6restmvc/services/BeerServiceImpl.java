package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, BeerDTO> beerMap;
    public BeerServiceImpl() {

        this.beerMap = new HashMap<>();

        BeerDTO beerDTO1 = BeerDTO.builder()
                .beerId(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerDTO beerDTO2 = BeerDTO.builder()
                .beerId(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerDTO beerDTO3 = BeerDTO.builder()
                .beerId(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        this.beerMap.put(beerDTO1.getBeerId(), beerDTO1);
        this.beerMap.put(beerDTO2.getBeerId(), beerDTO2);
        this.beerMap.put(beerDTO3.getBeerId(), beerDTO3);
    }

    @Override
    public List<BeerDTO> listBeer(){

        return new ArrayList<>(this.beerMap.values());
    }
    @Override
    public Optional<BeerDTO> getBeerByID(UUID id) {

        log.debug("getBeerByID method was called.");
        return Optional.of(this.beerMap.get(id));
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beerDTO) {
        BeerDTO newBeerDTO = BeerDTO.builder()
                .beerId(beerDTO.getBeerId())
                .version(beerDTO.getVersion())
                .beerName(beerDTO.getBeerName())
                .beerStyle(beerDTO.getBeerStyle())
                .upc(beerDTO.getUpc())
                .quantityOnHand(beerDTO.getQuantityOnHand())
                .price(beerDTO.getPrice())
                .createdDate(beerDTO.getCreatedDate())
                .updateDate(beerDTO.getUpdateDate())
                .build();
        this.beerMap.put(newBeerDTO.getBeerId(), newBeerDTO);
        return newBeerDTO;
    }

    @Override
    public void updateBeerById(UUID beerId, BeerDTO beerDTO) {
        BeerDTO existing = this.beerMap.get(beerId);
        existing.setBeerName(beerDTO.getBeerName());
        existing.setPrice(beerDTO.getPrice());
        existing.setUpc(beerDTO.getUpc());
        existing.setQuantityOnHand(beerDTO.getQuantityOnHand());

        this.beerMap.put(existing.getBeerId(), existing);
    }

    @Override
    public String deleteBeerById(UUID beerId) {

        this.beerMap.remove(beerId);
        return "Beer with BeerID:" + beerId + " has been deleted Successfully";
    }
}
