/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.contents;

import java.util.HashMap;
import java.util.Map;

public class ContactBuilder implements IBuilder {
	public static final byte TYPE_MECARD = 0;
	public static final byte TYPE_VCARD = 1;

	private byte type = TYPE_MECARD;
	private Map<String, String> map;

	public ContactBuilder() {
		map = new HashMap<>();
	}

	public ContactBuilder setType(byte type) {
		this.type = type;
		return this;
	}

	public ContactBuilder name(String name) {
		map.put("N", name);
		return this;
	}

	public ContactBuilder company(String company) {
		map.put("ORG", company);
		return this;
	}

	public ContactBuilder title(String title) {
		map.put("T", title);
		return this;
	}

	public ContactBuilder phone(String phone) {
		map.put("TEL", phone);
		return this;
	}

	public ContactBuilder email(String email) {
		map.put("EMAIL", email);
		return this;
	}

	public ContactBuilder address(String address) {
		map.put("ADR", address);
		return this;
	}

	public ContactBuilder note(String note) {
		map.put("NOTE", note);
		return this;
	}

	@Override
	public String build() {
		StringBuilder sb = new StringBuilder();
		if (this.type == TYPE_VCARD) {
			sb.append("BEGIN:VCARD\n").append("VERSION:3.0\n");
			for (String k : map.keySet()) {
				sb.append(k).append(":")
						.append(map.get(k)).append("\n");
			}
			sb.append("END:VCARD");
		} else {
			sb.append("MECARD:");
			for (String k : map.keySet()) {
				sb.append(k).append(":")
						.append(map.get(k)).append(";");
			}
			sb.append(";");
		}

		return sb.toString();
	}
}
