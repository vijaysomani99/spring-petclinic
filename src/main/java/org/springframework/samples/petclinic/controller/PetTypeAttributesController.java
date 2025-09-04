package org.springframework.samples.petclinic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.dto.PetTypeAttributesResponseDTo;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetTypeAttributes;
import org.springframework.samples.petclinic.service.PetTypeAttributesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pettype-attributes")
public class PetTypeAttributesController {

	@Autowired
	private OwnerRepository ownerRepository;

	private final PetTypeAttributesService attributeService;

	Logger logger = LoggerFactory.getLogger(PetTypeAttributesController.class);

	public PetTypeAttributesController(PetTypeAttributesService petTypeAttributesService) {

		this.attributeService = petTypeAttributesService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<PetTypeAttributesResponseDTo> getAttributesById(@PathVariable @Valid Long id) {
		Optional<PetTypeAttributes> petTypeAttributes = attributeService.findById(id);
		Integer petId = petTypeAttributes.get().getPetType().getId();
		Optional<Pet> Pet = attributeService.getPetDetails(petId);

		PetTypeAttributesResponseDTo responseDto = new PetTypeAttributesResponseDTo();
		responseDto.setId(petTypeAttributes.get().getId());

		responseDto.setTemperament(petTypeAttributes.get().getTemperament());
		responseDto.setLengthCm(petTypeAttributes.get().getLengthCm());
		responseDto.setWeightKg(petTypeAttributes.get().getWeightKg());
		return responseDto != null ? ResponseEntity.ok(responseDto) : ResponseEntity.notFound().build();
	}

	@PostMapping("/save")
	public ResponseEntity saveAttributes(@RequestBody PetTypeAttributesResponseDTo dto) {

		Integer petTypeId = dto.getPetType().getId();
		boolean isExitPetType = attributeService.existsPetTypeById(petTypeId);

		if (!isExitPetType) {
			return ResponseEntity.badRequest().body("Invalid pet type ID: " + petTypeId);
		}
		PetTypeAttributes attributes = new PetTypeAttributes();
		attributes.setPetType(dto.getPetType());
		attributes.setTemperament(dto.getTemperament());
		attributes.setLengthCm(dto.getLengthCm());
		attributes.setWeightKg(dto.getWeightKg());

		PetTypeAttributes petTypeAttributes = attributeService.save(attributes);

		PetTypeAttributesResponseDTo responseDto = new PetTypeAttributesResponseDTo();
		responseDto.setId(petTypeAttributes.getId());

		responseDto.setTemperament(petTypeAttributes.getTemperament());
		responseDto.setLengthCm(petTypeAttributes.getLengthCm());
		responseDto.setWeightKg(petTypeAttributes.getWeightKg());
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
	}

}
