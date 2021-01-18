/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie;

import com.elex_project.abraxas.IOz;
import com.elex_project.pixie.images.ImageBuilder;
import com.elex_project.pixie.images.SVGBuilder;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
public class EAN8EncoderTest {
	private static File dir;

	@BeforeAll
	static void prepare() {
		dir = new File("build/test");
		dir.mkdirs();
	}

	@Test
	public void encode() throws IOException, WriterException {
		EAN8Encoder encoder = new EAN8Encoder("1234567");
		BitMatrix code = encoder.encode();

		log.info(code.toString());
		String svg = SVGBuilder.build(code, "#000");
		IOz.writeStringTo(svg, new File(encoder.getContent() + ".svg"));

		BufferedImage image = ImageBuilder.build(code, 512, 128, Color.BLACK);
		ImageBuilder.saveAsPNG(image, new File(dir,encoder.getClass().getSimpleName()+"_"+ encoder.getContent() + ".png"));
	}
}
