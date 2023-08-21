package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.exceptions.NotFoundException;
import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @RequestMapping(method = RequestMethod.GET)
    public String beerHome(){
        log.debug("beerHome method in beerController");
        return "Welcome to the Brewery!\n\n" +
                "/beers - Get list of beers\n" +
                "/beers/{beerId} - Get beer by ID\n" +
                "/{beerId} - Update beer by ID";
    }
    @RequestMapping(value = "/beers",method = RequestMethod.GET)
    public List<BeerDTO> listBeers(){

        log.debug("listBeers method in beerController");
        return beerService.listBeer();
    }

    @RequestMapping(value = "/beers/{beerId}",method = RequestMethod.GET)
    public BeerDTO getBeerById(@PathVariable(name = "beerId") UUID beerId){

        log.debug("getBeerById method in beerController");
        return beerService.getBeerByID(beerId).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDTO beerDTO){

        log.debug("saveBeer method in beerController");

        //HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("Location","/api/v1/beer/beers/" + beer.getBeerId().toString());
        return ResponseEntity.created(URI.create("/api/v1/beer/beers/" + beerDTO.getBeerId().toString()))
                .body(beerService.saveBeer(beerDTO));
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable(name = "beerId") UUID beerId, @RequestBody BeerDTO beerDTO){
        log.debug("updateBeer method in beerController");
        beerService.updateBeerById(beerId, beerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable(name = "beerId") UUID beerId){
        log.debug("updateBeer method in beerController");
        return ResponseEntity.accepted().body(beerService.deleteBeerById(beerId));
    }

}
