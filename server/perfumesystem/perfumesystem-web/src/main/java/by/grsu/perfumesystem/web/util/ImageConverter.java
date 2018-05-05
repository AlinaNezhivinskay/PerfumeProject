package by.grsu.perfumesystem.web.util;

import java.util.Base64;

public class ImageConverter {

	public static Byte[] convertToByte(String image) {
		if (image == null) {
			return null;
		}
		byte[] imageByte = Base64.getDecoder().decode(image);
		Byte[] bytes = new Byte[imageByte.length];
		int i = 0;
		for (byte b : imageByte)
			bytes[i++] = (Byte) b;
		return bytes;
	}

	public static String convertToString(Byte[] image) {
		if (image == null) {
			return null;
		}
		byte[] bytes = new byte[image.length];
		int i = 0;
		for (Byte b : image)
			bytes[i++] = b.byteValue();
		String imageStr = Base64.getEncoder().encodeToString(bytes);
		return imageStr;
	}
}
