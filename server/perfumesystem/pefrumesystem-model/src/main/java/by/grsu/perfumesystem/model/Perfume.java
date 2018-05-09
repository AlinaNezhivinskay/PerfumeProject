package by.grsu.perfumesystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import by.grsu.perfumesystem.model.util.PerfumeType;

@Entity
@Table(name = "perfume")
public class Perfume {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column
	private Byte[] image;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PerfumeType type;
	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;
	@Column(name = "release_year")
	private Integer releaseYear;
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "condition_id")
	private PerfumeCondition condition;

	@JsonManagedReference
	@OneToMany(mappedBy = "perfume")
	private List<NotePyramide> notes = new ArrayList<NotePyramide>();

	public Perfume() {

	}

	public Perfume(String name, PerfumeType type, Brand brand, Integer releaseYear, PerfumeCondition condition,
			List<NotePyramide> notes) {
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.releaseYear = releaseYear;
		this.condition = condition;
		this.notes = notes;
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

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
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

	public List<NotePyramide> getNotePyramide() {
		return notes;
	}

	public void setNotePyramide(List<NotePyramide> notes) {
		this.notes = notes;
	}

	public void addNotePyramid(NotePyramide note) {
		this.notes.add(note);
	}

}
