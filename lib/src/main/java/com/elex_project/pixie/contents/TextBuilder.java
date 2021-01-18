/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.contents;

public class TextBuilder implements IBuilder {
	private String text;

	private TextBuilder(){
		super();
	}

	public TextBuilder text(String text){
		this.text = text;
		return this;
	}

	@Override
	public String build() {
		return text;
	}
}
