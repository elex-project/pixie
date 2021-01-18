/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.contents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class CalendarEventBuilder implements IBuilder {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddTHHmmssZ");
	private Map<String, String> map;

	public CalendarEventBuilder() {
		map = new HashMap<>();
	}

	public CalendarEventBuilder title(String summary){
		map.put("SUMMARY", summary);
		return this;
	}
	public CalendarEventBuilder desc(String desc){
		map.put("DESCRIPTION", desc);
		return this;
	}
	public CalendarEventBuilder dtStart(long dt){
		map.put("DTSTART", DATE_FORMAT.format(dt));
		return this;
	}
	public CalendarEventBuilder dtEnd(long dt){
		map.put("DTEND", DATE_FORMAT.format(dt));
		return this;
	}
	@Override
	public String build() {
		StringBuilder sb = new StringBuilder();
		sb.append("BEGIN:VEVENT\n");
		for (String k : map.keySet()) {
			sb.append(k).append(":")
					.append(map.get(k)).append("\n");
		}
		sb.append("END:VEVENT");

		return sb.toString();
	}
}
