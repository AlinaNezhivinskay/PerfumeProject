package by.grsu.perfumesystem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@Column
	private String email;
	@ManyToMany
	@JoinTable(name = "user_perfumes", joinColumns = { @JoinColumn(name = "user_info_id") }, inverseJoinColumns = {
			@JoinColumn(name = "perfume_id") })
	private List<Perfume> pefumes;

	public UserInfo() {

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Perfume> getPefumes() {
		return pefumes;
	}

	public void setPefumes(List<Perfume> pefumes) {
		this.pefumes = pefumes;
	}

}
