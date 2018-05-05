package by.grsu.perfumesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import by.grsu.perfumesystem.model.util.Daytime;
import by.grsu.perfumesystem.model.util.WeatherType;

@Entity
@Table(name = "disclosure_condition")
public class PerfumeCondition {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private WeatherType weather;
	@Column
	private Double temperature;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Daytime daytime;

	public PerfumeCondition() {

	}

	public PerfumeCondition(WeatherType weather, Double temperature, Daytime daytime) {
		this.weather = weather;
		this.temperature = temperature;
		this.daytime = daytime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
