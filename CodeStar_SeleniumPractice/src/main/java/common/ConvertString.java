package common;

import static common.TestLogger.info;

public class ConvertString {
	/**
	 * tra ve so lan xuat hien cua 1 xau trong chuoi
	 * 
	 * @param value
	 * @param array
	 * @return
	 */
	public String checkValueInArray(String value, String[] array) {
		int soLan = 0;
		if (value != null && value != "" && array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				if (value.equalsIgnoreCase(array[i])) {
					soLan++;
					info("Chuoi \"" + value + "\" xuat hien trong mang lan thu: " + soLan);
				}
			}
			return String.valueOf(soLan);
		} else {
			info("Chuoi can kiem tra dang null hoac mang khong co phan tu");
			return "";
		}
	}

	/**
	 * 
	 * @param string
	 * @param split
	 * @return
	 */
	public String[] convertStringToArray(String string, String split) {
		String[] a = new String[100];
		if (string != null && string != "") {
			a = string.split(split);
		} else {
			info("Xau ky tu can chuyen sang mang ");
		}
		return a;
	}
}
