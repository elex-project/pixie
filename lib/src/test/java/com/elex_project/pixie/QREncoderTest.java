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
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
public class QREncoderTest {
	private static File dir;

	@BeforeAll
	static void prepare() {
		dir = new File("build/test");
		dir.mkdirs();
	}

	@Test
	public void encode() throws WriterException, IOException {
		QREncoder encoder = new QREncoder();
		encoder.setContent("Hello, World");
		encoder.setErrorCorrectionLevel(ErrorCorrectionLevel.M);
		BitMatrix code = encoder.encode();
		log.info(code.toString());

		String svg = SVGBuilder.build(code, "#443326");
		BufferedImage image = ImageBuilder.build(code, 512, 512, Color.BLACK);
		ImageBuilder.saveAsPNG(image, new File(encoder.getContent() + ".png"));
		IOz.writeStringTo(svg, new File(dir, encoder.getClass().getSimpleName() + "_" +encoder.getContent() + ".svg"));
	}
}
