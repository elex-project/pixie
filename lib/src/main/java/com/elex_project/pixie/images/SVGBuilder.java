/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.images;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.encoder.ByteMatrix;

public final class SVGBuilder {
	private static final int CELL_SIZE = 10;
	//private static final int CELL_HEIGHT_FOR_1D = 50;
	private SVGBuilder(){}

	public static String build(final BitMatrix matrix) {
		return build(matrix, "#000");
	}
	public static String build(final BitMatrix matrix, final String fillColor) {
		int canvasHeight = matrix.getHeight()*CELL_SIZE;
		int cellHeight = CELL_SIZE;
		if (matrix.getHeight()==1){
			canvasHeight = CELL_SIZE * 10;
			cellHeight = CELL_SIZE * 10;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" standalone=\"no\"?>");
		sb.append("<svg width=\"")
				.append(matrix.getWidth()*CELL_SIZE)
				.append("\" height=\"")
				.append(canvasHeight)
				.append("\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">");
		for (int x=0; x<matrix.getWidth(); x++) {
			for (int y=0; y<matrix.getHeight(); y++) {
				if (matrix.get(x, y)) {
					sb.append("<rect x=\"").append(x * CELL_SIZE)
							.append("\" y=\"").append(y * CELL_SIZE)
							.append("\" width=\"").append(CELL_SIZE)
							.append("\" height=\"").append(cellHeight)
							.append("\" stroke=\"").append(fillColor)
							.append("\" fill=\"").append(fillColor).append("\"/>");
				}
			}
		}
		sb.append("</svg>");
		return sb.toString();
	}
}
