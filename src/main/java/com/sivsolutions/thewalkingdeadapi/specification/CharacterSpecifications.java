package com.sivsolutions.thewalkingdeadapi.specification;

import org.springframework.data.jpa.domain.Specification;
import com.sivsolutions.thewalkingdeadapi.model.Character;

public class CharacterSpecifications {

    public static Specification<Character> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Character> hasStatus(String status) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<Character> hasGroupAffiliation(String groupAffiliation) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("groupAffiliation"), groupAffiliation);
    }

    public static Specification<Character> hasAge(int age) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("age"), age);
    }

    public static Specification<Character> hasGender(String gender) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("gender"), gender);
    }

    public static Specification<Character> hasEthnicity(String ethnicity) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("ethnicity"), ethnicity);
    }

    public static Specification<Character> hasFanRating(double rating) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("fanRating"), rating);
    }

    public static Specification<Character> hasNarrativeRole(String narrativeRole) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("narrativeRole"), narrativeRole);
    }

    // You can add more specifications as needed
}
