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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;
	@Column
	private String site;
	@ManyToMany
	@JoinTable(name = "brand_shops", joinColumns = { @JoinColumn(name = "brand_id") }, inverseJoinColumns = {
			@JoinColumn(name = "shop_id") })
	private List<Shop> shops;

	public Brand() {

	}

	public Brand(String name, Country country, String site) {
		this.name = name;
		this.country = country;
		this.site = site;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
}
