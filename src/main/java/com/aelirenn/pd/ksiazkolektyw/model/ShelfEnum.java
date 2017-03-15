package com.aelirenn.pd.ksiazkolektyw.model;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ShelfEnum {
	
	MY_SHELF("Moje", "m"),
	TO_READ_SHELF("Chc� przeczyta�", "tr"),
	TO_BUT_SHELF("Chc� kupi�", "tb"),
	BORROWED_SHELF("Chc� po�yczy�", "b");

	private final String name;
	private final String type;
	
	ShelfEnum(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public static String getNameFromType(String type) {
		String name = "";
		for (ShelfEnum s : ShelfEnum.values()) {
			if (type.equals(s.getType())) name =  s.getName();
		}
		return name;
	}
	
	public static Map<String, String> getShelfList() {
		Map<String, String> shelfList = new LinkedHashMap<String, String>();
		shelfList.put("m", "Moje");
		shelfList.put("tr", "Chc� przeczyta�");
		shelfList.put("tb", "Chc� kupi�");
		shelfList.put("b", "Po�yczone");
		return shelfList;
	}

}
