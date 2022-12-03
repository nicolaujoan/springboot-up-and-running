package com.example.setuprestdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController() {
        coffees.addAll(
                List.of(
                        new Coffee("Café Cereza"),
                        new Coffee("Café Ganador"),
                        new Coffee("Café Lareño"),
                        new Coffee("Café Três Pontas")
                )
        );
    }

    @GetMapping
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        return coffees.stream().filter(coffee -> Objects.equals(coffee.getId(), id)).findFirst();
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {

        // if it's found, update it, else create it
        int index = -1;

        for (int i = 0; i < coffees.size(); i++) {
            if (coffees.get(i).getId().equals(id)) {
                index = i;
            }
        }
        return (index == -1) ?
                new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(coffee -> coffee.getId().equals(id));
    }

}

