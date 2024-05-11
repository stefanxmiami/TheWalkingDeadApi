package com.sivsolutions.thewalkingdeadapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String status; // e.g., Alive, Deceased, Unknown

    // Screen Time Details
    private String firstAppearance; // Format: "Season 1, Episode 3"
    private String lastAppearance; // Format: "Season 5, Episode 10"
    private Integer totalScreenTime; // Total screen time in minutes

    // Character Background
    private String occupation;
    private String groupAffiliation;

    // Personal Traits
    private Integer age;
    private String gender;
    private String ethnicity;

    // Relationships
    @Column(length = 1000) // Assuming lengthy descriptions might be needed
    private String familyMembers;
    private String significantRelationships;

    // Physical and Psychological Traits
    private String physicalDescription;
    private String personalityTraits;

    // Popularity and Impact
    private Double fanRating;
    private String awards;

    // Media Links
    private String imageUrl;

    // Narrative Importance
    private String narrativeRole;

    /*// Memorable Quotes
    @ElementCollection // This annotation is used for storing a list of basic or embeddable types.
    private List<String> memorableQuotes;*/
}
