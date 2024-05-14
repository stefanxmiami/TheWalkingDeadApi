package com.sivsolutions.thewalkingdeadapi.repository;

import com.sivsolutions.thewalkingdeadapi.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long>, JpaSpecificationExecutor<Character> {

    // Find characters by status
    List<Character> findByStatus(String status);

    // Find characters by name, ignoring case
    List<Character> findByNameContainingIgnoreCase(String name);

    // Find characters by occupation
    List<Character> findByOccupation(String occupation);

    // Find characters by exact name
    List<Character> findByName(String name);

    // Find characters by name and status
    List<Character> findByNameAndStatus(String name, String status);

    // Find characters within an age range
    @Query("SELECT c FROM Character c WHERE c.age >= :minAge AND c.age <= :maxAge")
    List<Character> findByAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

    // Find alive characters by gender
    @Query("SELECT c FROM Character c WHERE c.gender = :gender AND c.status = 'Alive'")
    List<Character> findAliveByGender(@Param("gender") String gender);

    // Find characters by group affiliation, ignoring case
    List<Character> findByGroupAffiliationContainingIgnoreCase(String group);

    // Find characters by physical description
    @Query("SELECT c FROM Character c WHERE c.physicalDescription LIKE %:desc%")
    List<Character> findByPhysicalDescriptionContaining(@Param("desc") String description);

    // Find characters by family member
    @Query("SELECT c FROM Character c WHERE c.familyMembers LIKE %:familyMember%")
    List<Character> findByFamilyMember(@Param("familyMember") String familyMember);

    // Find top-rated characters
    @Query("SELECT c FROM Character c WHERE c.fanRating >= :rating ORDER BY c.fanRating DESC")
    List<Character> findTopRatedCharacters(@Param("rating") double rating);

    // Find characters by ethnicity and occupation
    @Query("SELECT c FROM Character c WHERE c.ethnicity = :ethnicity AND c.occupation = :occupation")
    List<Character> findByEthnicityAndOccupation(@Param("ethnicity") String ethnicity, @Param("occupation") String occupation);

}
