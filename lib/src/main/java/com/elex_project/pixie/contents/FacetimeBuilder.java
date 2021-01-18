/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.contents;

public class FacetimeBuilder implements IBuilder {
	private String link;

	public FacetimeBuilder link(String link){
		this.link = link;
		return this;
	}
	@Override
	public String build() {
		return "facetime:" + link;
	}
}
