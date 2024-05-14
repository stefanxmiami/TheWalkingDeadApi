package com.sivsolutions.thewalkingdeadapi.controller;

import com.sivsolutions.thewalkingdeadapi.model.Character;
import com.sivsolutions.thewalkingdeadapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    // Get all characters
    @GetMapping("/")
    public ResponseEntity<List<Character>> getAllCharacters(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "groupAffiliation", required = false) String groupAffiliation,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "ethnicity", required = false) String ethnicity,
            @RequestParam(value = "fanRating", required = false) Double fanRating,
            @RequestParam(value = "narrativeRole", required = false) String narrativeRole) {
        System.out.println("Filtering by group: " + groupAffiliation);
        List<Character> characters = characterService.findCharacters(name, status, groupAffiliation, age, gender, ethnicity, fanRating, narrativeRole);

        return ResponseEntity.ok(characters);
    }

    // Get a single character by ID
    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        Character character = characterService.getCharacterById(id);
        return character != null ? ResponseEntity.ok(character) : ResponseEntity.notFound().build();
    }

    // Create a new character
    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        Character createdCharacter = characterService.addCharacter(character);
        return ResponseEntity.ok(createdCharacter);
    }

    // Update an existing character
    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character) {
        Character updatedCharacter = characterService.updateCharacter(character);
        return updatedCharacter != null ? ResponseEntity.ok(updatedCharacter) : ResponseEntity.notFound().build();
    }

    // Delete a character
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.ok().build();
    }
}
