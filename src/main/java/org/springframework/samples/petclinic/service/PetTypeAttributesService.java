package org.springframework.samples.petclinic.service;

import java.util.Optional;

import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetTypeAttributes;
import org.springframework.stereotype.Service;

@Service
public interface PetTypeAttributesService {

	public Optional<PetTypeAttributes> findById(Long id);

	public PetTypeAttributes save(PetTypeAttributes petTypeAttributes);

	public boolean existsPetTypeById(Integer id);

	public Optional<Pet> getPetDetails(Integer id);

}
