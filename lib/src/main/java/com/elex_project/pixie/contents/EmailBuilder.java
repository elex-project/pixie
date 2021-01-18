/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.contents;

public class EmailBuilder implements IBuilder {
	private String email;

	private EmailBuilder(){
		super();
	}

	public EmailBuilder email(String email){
		this.email = email;
		return this;
	}

	@Override
	public String build() {
		return "mailto:"+email;
	}
}
