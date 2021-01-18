/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie.images;

import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class ImageBuilder {

	public static BufferedImage build(BitMatrix matrix, int preferredWidth, int preferredHeight, Color color){

		int cellWidth = preferredWidth / (matrix.getWidth());
		int cellHeight = preferredHeight / (matrix.getHeight());
		//int startX = marginX * cellWidth;
		//int startY = marginY * cellHeight;

		BufferedImage image = new BufferedImage(matrix.getWidth()*cellWidth, matrix.getHeight()*cellHeight,
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		g.setColor(color);

		for (int x=0; x<matrix.getWidth(); x++){
			for (int y=0; y<matrix.getHeight(); y++){
				if (matrix.get(x,y)) {
					g.fillRect(x*cellWidth, y*cellHeight,
							cellWidth, cellHeight);
				}
			}
		}

		g.dispose();
		return image;
	}

	public static void saveAsPNG(BufferedImage image, File file) throws IOException {
		ImageIO.write(image, "PNG", file);
	}
}
