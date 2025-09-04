package org.springframework.samples.petclinic.dto;

import org.springframework.samples.petclinic.owner.PetType;

public class PetTypeAttributesResponseDTo {

	Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(Double weightKg) {
		this.weightKg = weightKg;
	}

	public Double getLengthCm() {
		return lengthCm;
	}

	public void setLengthCm(Double lengthCm) {
		this.lengthCm = lengthCm;
	}

	public String getTemperament() {
		return temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	PetType petType;

	String temperament;

	Double lengthCm;

	Double weightKg;

}
