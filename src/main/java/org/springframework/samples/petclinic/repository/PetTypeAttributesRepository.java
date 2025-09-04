package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.owner.PetTypeAttributes;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for <code>PetTypeAttributes</code> domain objects.
 *
 * @author Pankaj Gosavi
 */
@Repository
public interface PetTypeAttributesRepository extends JpaRepository<PetTypeAttributes, Long> {

}
