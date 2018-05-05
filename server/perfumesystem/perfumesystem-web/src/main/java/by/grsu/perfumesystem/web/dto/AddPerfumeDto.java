package by.grsu.perfumesystem.web.dto;

import by.grsu.perfumesystem.model.util.Daytime;
import by.grsu.perfumesystem.model.util.PerfumeType;
import by.grsu.perfumesystem.model.util.WeatherType;

public class AddPerfumeDto {
	private String name;
	private String image;
	private PerfumeType type;
	private Integer brand;
	private Integer releaseYear;

	private WeatherType weather;
	private Double temperature;
	private Daytime daytime;

	public AddPerfumeDto() {

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

	public Integer getBrand() {
		return brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public WeatherType getWeather() {
		return weather;
	}

	public void setWeather(WeatherType weather) {
		this.weather = weather;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Daytime getDaytime() {
		return daytime;
	}

	public void setDaytime(Daytime daytime) {
		this.daytime = daytime;
	}

}
