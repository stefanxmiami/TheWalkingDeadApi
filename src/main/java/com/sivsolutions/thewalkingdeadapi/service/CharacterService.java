package com.sivsolutions.thewalkingdeadapi.service;

import com.sivsolutions.thewalkingdeadapi.model.Character;
import com.sivsolutions.thewalkingdeadapi.repository.CharacterRepository;
import com.sivsolutions.thewalkingdeadapi.specification.CharacterSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public Character getCharacterById(Long id) {
        Optional<Character> character = characterRepository.findById(id);
        return character.orElse(null);  // Returns the character if found, or null if not found
    }

    // Get all characters
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    // Find characters by status
    public List<Character> getCharactersByStatus(String status) {
        return characterRepository.findByStatus(status);
    }

    // Search characters by name
    public List<Character> searchCharactersByName(String name) {
        return characterRepository.findByNameContainingIgnoreCase(name);
    }

    // Find characters by occupation
    public List<Character> getCharactersByOccupation(String occupation) {
        return characterRepository.findByOccupation(occupation);
    }

    // Find characters by age range
    public List<Character> getCharactersByAgeRange(int minAge, int maxAge) {
        return characterRepository.findByAgeRange(minAge, maxAge);
    }

    // Find alive characters by gender
    public List<Character> getAliveCharactersByGender(String gender) {
        return characterRepository.findAliveByGender(gender);
    }

    // Find characters by group affiliation
    public List<Character> getCharactersByGroupAffiliation(String group) {
        return characterRepository.findByGroupAffiliationContainingIgnoreCase(group);
    }

    // Find characters by physical description
    public List<Character> getCharactersByPhysicalDescription(String description) {
        return characterRepository.findByPhysicalDescriptionContaining(description);
    }

    // Find characters by family member
    public List<Character> getCharactersByFamilyMember(String familyMember) {
        return characterRepository.findByFamilyMember(familyMember);
    }

    // Find top-rated characters
    public List<Character> getTopRatedCharacters(double rating) {
        return characterRepository.findTopRatedCharacters(rating);
    }

    // Find characters by ethnicity and occupation
    public List<Character> getCharactersByEthnicityAndOccupation(String ethnicity, String occupation) {
        return characterRepository.findByEthnicityAndOccupation(ethnicity, occupation);
    }

    // Add a new character
    public Character addCharacter(Character character) {
        return characterRepository.save(character);
    }

    // Update an existing character
    public Character updateCharacter(Character character) {
        // Ensure the character exists before updating
        if (character != null && character.getId() != null && characterRepository.existsById(character.getId())) {
            return characterRepository.save(character);
        }
        return null;
    }

    public List<Character> findCharacters(String name, String status) {
        if (name != null && status != null) {
            return characterRepository.findByNameAndStatus(name, status);
        } else if (name != null) {
            return characterRepository.findByName(name);
        } else if (status != null) {
            return characterRepository.findByStatus(status);
        } else {
            return characterRepository.findAll();
        }
    }

    public List<Character> findCharacters(String name, String status, String groupAffiliation, Integer age, String gender, String ethnicity, Double fanRating, String narrativeRole) {
        Specification<Character> spec = Specification.where(null);

        if (name != null) spec = spec.and(CharacterSpecifications.hasName(name));
        if (status != null) spec = spec.and(CharacterSpecifications.hasStatus(status));
        if (groupAffiliation != null) spec = spec.and(CharacterSpecifications.hasGroupAffiliation(groupAffiliation));
        if (age != null) spec = spec.and(CharacterSpecifications.hasAge(age));
        if (gender != null) spec = spec.and(CharacterSpecifications.hasGender(gender));
        if (ethnicity != null) spec = spec.and(CharacterSpecifications.hasEthnicity(ethnicity));
        if (fanRating != null) spec = spec.and(CharacterSpecifications.hasFanRating(fanRating));
        if (narrativeRole != null) spec = spec.and(CharacterSpecifications.hasNarrativeRole(narrativeRole));

        return characterRepository.findAll(spec);
    }

    // Delete a character
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
}
