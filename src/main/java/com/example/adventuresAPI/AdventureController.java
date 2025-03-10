package com.example.adventuresAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adventures")
public class AdventureController {

    @Autowired
    private AdventureRepository adventureRepository;

    // get all adventures
    @GetMapping
    public List<Adventure> getAdventures() {
        return adventureRepository.findAll();
    }

    // get adventure by id
    @GetMapping("/{id}")
    public Adventure getAdventure(@PathVariable Long id) {
        return adventureRepository.findById(id).orElseThrow(() -> new RuntimeException("Adventure not found"));
    }

    // create new adventure
    @PostMapping
    public Adventure createAdventure(@RequestBody Adventure adventure) {
        return adventureRepository.save(adventure);
    }

    // update adventure
    @PutMapping("/{id}")
    public Adventure updateAdventure(@PathVariable Long id, @RequestBody Adventure adventureDetails) {
        Adventure adventure = adventureRepository.findById(id).orElseThrow(() -> new RuntimeException("Adventure not found"));
        adventure.setDate(adventureDetails.getDate());
        adventure.setCountry(adventureDetails.getCountry());
        adventure.setCity(adventureDetails.getCity());
        adventure.setState(adventureDetails.getState());
        adventure.setNumPhotos(adventureDetails.getNumPhotos());
        adventure.setBlogCompleted(adventureDetails.getBlogCompleted());
        return adventureRepository.save(adventure);
    }

    // delete adventure
    @DeleteMapping("/{id}")
    public void deleteAdventure(@PathVariable Long id) {
        adventureRepository.deleteById(id);
    }
}