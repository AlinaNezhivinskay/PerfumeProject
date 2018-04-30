package by.grsu.perfumesystem.web.dto;

import java.util.Base64;

import by.grsu.perfumesystem.model.NoteGroup;

public class NoteDto {

	private Integer id;
	private String name;
	private String image;
	private NoteGroup group;

	public NoteDto() {
	}

	public NoteDto(Integer id, String name, NoteGroup group) {
		this.id = id;
		this.name = name;
		this.group = group;
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

	public void setImage(Byte[] image) {
		if (image == null) {
			this.image = null;
			return;
		}
		byte[] bytes = new byte[image.length];
		int i = 0;
		for (Byte b : image)
			bytes[i++] = b.byteValue();
		String imageStr = Base64.getEncoder().encodeToString(bytes);
		this.image = imageStr;
	}

	public NoteGroup getGroup() {
		return group;
	}

	public void setGroup(NoteGroup group) {
		this.group = group;
	}
}
