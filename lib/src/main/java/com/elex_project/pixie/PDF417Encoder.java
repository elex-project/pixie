/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie;

import com.elex_project.abraxas.Stringz;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;

public final class PDF417Encoder extends AbsEncoder {

	public PDF417Encoder() {
		this(Stringz.EMPTY_STRING);
	}

	public PDF417Encoder(String content) {
		super();
		setContent(content);
	}

	/**
	 * For PDF417 it is of type Integer, valid values being 0 to 8
	 *
	 * @param ecl
	 */
	public void setErrorCorrectionLevel(int ecl) {
		if (ecl < 0) ecl = 0;
		if (ecl > 8) ecl = 8;
		hints.put(EncodeHintType.ERROR_CORRECTION, ecl);
	}

	public void setCompact(boolean compact) {
		hints.put(EncodeHintType.PDF417_COMPACT, compact);
	}

	public void setCompaction(Compaction compaction) {
		hints.put(EncodeHintType.PDF417_COMPACTION, compaction);
	}

	public void setDimensions(Dimensions dimensions) {
		hints.put(EncodeHintType.PDF417_DIMENSIONS, dimensions);
	}

	public void setCharacterSet(String charset) {
		this.hints.put(EncodeHintType.CHARACTER_SET, charset);
	}


	@Override
	public BitMatrix encode() throws WriterException {
		return new PDF417Writer().encode(getContent(), BarcodeFormat.PDF_417, 0, 0, hints);
	}
}
