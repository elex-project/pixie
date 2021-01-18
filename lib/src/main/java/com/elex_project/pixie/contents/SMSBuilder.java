/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.contents;


import com.elex_project.abraxas.Stringz;

public class SMSBuilder implements IBuilder {
	private String text, phone;

	public SMSBuilder phone(String phone){
		this.phone = phone;
		return this;
	}

	public SMSBuilder text(String text){
		this.text = text;
		return this;
	}

	@Override
	public String build() {
		StringBuilder sb = new StringBuilder();
		sb.append("smsto:").append(phone);
		if (!Stringz.isEmpty(text)){
			sb.append(":").append(text);
		}
		return sb.toString();
	}
}
