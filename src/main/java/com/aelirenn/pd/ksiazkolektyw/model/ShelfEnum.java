package com.aelirenn.pd.ksiazkolektyw.model;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ShelfEnum {
	
	MY_SHELF("Moje", "m"),
	TO_READ_SHELF("Chcê przeczytaæ", "tr"),
	TO_BUT_SHELF("Chcê kupiæ", "tb"),
	BORROWED_SHELF("Chcê po¿yczyæ", "b");

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
		shelfList.put("tr", "Chcê przeczytaæ");
		shelfList.put("tb", "Chcê kupiæ");
		shelfList.put("b", "Po¿yczone");
		return shelfList;
	}

}
