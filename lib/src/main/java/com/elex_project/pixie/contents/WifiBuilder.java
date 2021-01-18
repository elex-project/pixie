/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.contents;


import com.elex_project.abraxas.Stringz;

public class WifiBuilder implements IBuilder {
	private String ssid, password;
	private boolean hidden;
	private NetworkType type = NetworkType.NO;

	public enum NetworkType{
		NO, WEP, WPA;
		public String toString(){
			switch (this){
				case WEP: return "WEP";
				case WPA: return "WPA/WPA2";
				default: return "No Encryption";
			}
		}
	}

	public WifiBuilder ssid(String ssid){
		this.ssid = ssid;
		return this;
	}
	public WifiBuilder password(String password){
		this.password = password;
		return this;
	}
	public WifiBuilder type(NetworkType type){
		this.type = type;
		return this;
	}
	public WifiBuilder hidden(boolean hidden){
		this.hidden = hidden;
		return this;
	}

	@Override
	public String build() {
		StringBuilder sb = new StringBuilder();
		sb.append("WIFI:");
		sb.append("S:\"").append(ssid).append("\";");
		if (type!=NetworkType.NO) {
			sb.append("T:").append(type.name()).append(";");
		}
		if (!Stringz.isEmpty(password)) {
			sb.append("P:").append(password).append(";");
		}
		if (hidden) {
			sb.append("H:").append(hidden).append(";");
		}
		sb.append(";");
		return sb.toString();
	}
}
