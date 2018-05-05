package by.grsu.perfumesystem.web.dto;

import by.grsu.perfumesystem.model.Brand;
import by.grsu.perfumesystem.model.PerfumeCondition;
import by.grsu.perfumesystem.model.util.PerfumeType;

public class PerfumeDto {
	private Integer id;
	private String name;
	private String image;
	private PerfumeType type;
	private Brand brand;
	private Integer releaseYear;
	private PerfumeCondition condition;

	public PerfumeDto() {

	}

	public PerfumeDto(Integer id, String name, PerfumeType type, Brand brand, Integer releaseYear,
			PerfumeCondition condition) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.releaseYear = releaseYear;
		this.condition = condition;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public PerfumeType getType() {
		return type;
	}

	public void setType(PerfumeType type) {
		this.type = type;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public PerfumeCondition getCondition() {
		return condition;
	}

	public void setCondition(PerfumeCondition condition) {
		this.condition = condition;
	}

}
