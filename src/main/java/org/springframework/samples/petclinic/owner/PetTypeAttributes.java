package org.springframework.samples.petclinic.owner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Simple business object representing a pet type attributes.
 *
 */
@Entity
@Table(name = "attributes")
public class PetTypeAttributes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "pet_type_id", referencedColumnName = "id", nullable = false)
	private PetType petType;

	private String temperament;

	private Double lengthCm;

	private Double weightKg;

	public PetTypeAttributes() {
		super();
	}

	public PetTypeAttributes(PetType petType, String temperament, Double lengthCm, Double weightKg) {
		super();
		this.petType = petType;
		this.temperament = temperament;
		this.lengthCm = lengthCm;
		this.weightKg = weightKg;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the petType
	 */
	public PetType getPetType() {
		return petType;
	}

	/**
	 * @param petType the petType to set
	 */
	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	/**
	 * @return the temperament
	 */
	public String getTemperament() {
		return temperament;
	}

	/**
	 * @param temperament the temperament to set
	 */
	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	/**
	 * @return the lengthCm
	 */
	public Double getLengthCm() {
		return lengthCm;
	}

	/**
	 * @param lengthCm the lengthCm to set
	 */
	public void setLengthCm(Double lengthCm) {
		this.lengthCm = lengthCm;
	}

	/**
	 * @return the weightKg
	 */
	public Double getWeightKg() {
		return weightKg;
	}

	/**
	 * @param weightKg the weightKg to set
	 */
	public void setWeightKg(Double weightKg) {
		this.weightKg = weightKg;
	}

}
