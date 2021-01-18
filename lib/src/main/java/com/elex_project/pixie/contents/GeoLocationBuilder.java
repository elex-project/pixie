/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.contents;

import com.elex_project.abraxas.Stringz;

public class GeoLocationBuilder implements IBuilder {
	private double latitude, longitude;
	private String query;

	public GeoLocationBuilder latitude(double latitude){
		this.latitude = latitude;
		return this;
	}
	public GeoLocationBuilder longitude(double longitude){
		this.longitude = longitude;
		return this;
	}
	public GeoLocationBuilder query(String q){
		this.query = q;
		return  this;
	}
	@Override
	public String build() {
		StringBuilder sb = new StringBuilder();
		sb.append("geo:").append(latitude).append(",").append(longitude);
		if (!Stringz.isEmpty(query)){
			sb.append("?q=").append(query);
		}
		return sb.toString();
	}
}
