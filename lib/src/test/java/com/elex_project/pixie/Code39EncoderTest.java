/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie;

import com.elex_project.abraxas.IOz;
import com.elex_project.pixie.images.SVGBuilder;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

@Slf4j
public class Code39EncoderTest {
	private static File dir;

	@BeforeAll
	static void prepare() {
		dir = new File("build/test");
		dir.mkdirs();
	}

	@Test
	public void encode() throws IOException, WriterException {
		Code39Encoder encoder = new Code39Encoder("A1234");
		BitMatrix code = encoder.encode();

		log.info(code.toString());
		String svg = SVGBuilder.build(code, "#000");
		IOz.writeStringTo(svg, new File(dir, encoder.getClass().getSimpleName()+"_"+encoder.getContent() + ".svg"));
	}
}
