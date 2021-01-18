/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.contents;

public class PhoneNumberBuilder implements IBuilder {
	private String phone;

	private PhoneNumberBuilder(){
		super();
	}

	public PhoneNumberBuilder phone(String phone){
		this.phone = phone;
		return this;
	}

	@Override
	public String build() {
		return "tel:"+phone;
	}
}
