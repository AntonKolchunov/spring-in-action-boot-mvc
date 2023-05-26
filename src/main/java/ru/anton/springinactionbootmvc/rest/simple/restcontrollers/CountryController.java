package ru.anton.springinactionbootmvc.rest.simple.restcontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anton.springinactionbootmvc.rest.simple.modelDTO.Country;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/italy")
    public Country italy() {
        Country country = Country.of("Italy", 57);
        return country;
    }

    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        Country country = Country.of("France", 67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(country);
    }

    @GetMapping("/all")
    public List<Country> all() {
        Country country1 = Country.of("France", 67);
        Country country2 = Country.of("Spain",47);
        return List.of(country1, country2);
    }
}
