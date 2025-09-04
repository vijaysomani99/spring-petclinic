package org.springframework.samples.petclinic.service;

import java.util.Optional;

import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetTypeAttributes;
import org.springframework.samples.petclinic.repository.PetTypeAttributesRepository;
import org.springframework.samples.petclinic.owner.PetTypeRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PetTypeAttributesServiceImpl implements PetTypeAttributesService {

	private final PetTypeAttributesRepository petTypeAttributesRepository;

	private final PetTypeRepository petTypeRepository;

	public PetTypeAttributesServiceImpl(PetTypeAttributesRepository petTypeAttributesRepository,
			PetTypeRepository petTypeRepository) {
		this.petTypeAttributesRepository = petTypeAttributesRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override

	public Optional<PetTypeAttributes> findById(Long id) {
		return petTypeAttributesRepository.findById(id);
	}

	@Override
	public PetTypeAttributes save(PetTypeAttributes petTypeAttributes) {
		return petTypeAttributesRepository.save(petTypeAttributes);
	}

	@Override
	public boolean existsPetTypeById(Integer id) {
		return petTypeRepository.existsById(id);
	}

	@Override
	public Optional<Pet> getPetDetails(Integer id) {
		return petTypeRepository.findById(id).map(pt -> {
			Pet pet = new Pet();
			pet.setType(pt);
			return pet;
		});
	}

}
