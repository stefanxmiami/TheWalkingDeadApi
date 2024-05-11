package com.sivsolutions.thewalkingdeadapi.repository;

import com.sivsolutions.thewalkingdeadapi.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long>, JpaSpecificationExecutor<Character> {
    // Basic Find Methods
    List<Character> findByStatus(String status);
    List<Character> findByNameContainingIgnoreCase(String name);
    List<Character> findByOccupation(String occupation);

    List<Character> findByName(String name);
    List<Character> findByNameAndStatus(String name, String status);

    // Custom Queries for Complex Searches
    @Query("SELECT c FROM Character c WHERE c.age >= :minAge AND c.age <= :maxAge")
    List<Character> findByAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

    @Query("SELECT c FROM Character c WHERE c.gender = :gender AND c.status = 'Alive'")
    List<Character> findAliveByGender(@Param("gender") String gender);

    // Find Characters by Group Affiliation
    List<Character> findByGroupAffiliationContainingIgnoreCase(String group);

    // Fetch Characters with Specific Physical or Psychological Traits
    @Query("SELECT c FROM Character c WHERE c.physicalDescription LIKE %:desc%")
    List<Character> findByPhysicalDescriptionContaining(@Param("desc") String description);

    // Handling Relationships
    @Query("SELECT c FROM Character c WHERE c.familyMembers LIKE %:familyMember%")
    List<Character> findByFamilyMember(@Param("familyMember") String familyMember);

    // Fetch Characters Based on Fan Rating (e.g., top rated)
    @Query("SELECT c FROM Character c WHERE c.fanRating >= :rating ORDER BY c.fanRating DESC")
    List<Character> findTopRatedCharacters(@Param("rating") double rating);

    // Retrieve Characters by Multiple Attributes
    @Query("SELECT c FROM Character c WHERE c.ethnicity = :ethnicity AND c.occupation = :occupation")
    List<Character> findByEthnicityAndOccupation(@Param("ethnicity") String ethnicity, @Param("occupation") String occupation);

}
