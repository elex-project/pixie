/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.contents;

public class UrlBuilder implements IBuilder {
	private String url;

	private UrlBuilder(){
		super();
	}

	public UrlBuilder url(String url){
		this.url = url;
		return this;
	}

	@Override
	public String build() {
		return url;
	}
}
