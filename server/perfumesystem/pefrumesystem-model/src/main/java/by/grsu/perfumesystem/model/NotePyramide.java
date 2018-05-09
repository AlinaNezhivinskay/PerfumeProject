package by.grsu.perfumesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import by.grsu.perfumesystem.model.util.PerfumePyramideType;

@Entity
@Table(name = "perfume_note")
public class NotePyramide {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "perfume_id", nullable = false)
	private Perfume perfume;
	@ManyToOne
	@JoinColumn(name = "note_id", nullable = false)
	private Note note;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PerfumePyramideType type;

	public NotePyramide() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Perfume getPerfume() {
		return perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public PerfumePyramideType getType() {
		return type;
	}

	public void setType(PerfumePyramideType type) {
		this.type = type;
	}

}
