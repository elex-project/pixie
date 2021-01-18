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
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.ITFWriter;


public final class ITFEncoder extends AbsEncoder {

	public ITFEncoder() {
		this(Stringz.EMPTY_STRING);
	}

	public ITFEncoder(String content) {
		super();
		setContent(content);
	}

	@Override
	public BitMatrix encode() throws WriterException {
		return new ITFWriter().encode(getContent(), BarcodeFormat.ITF, 0, 0, hints);
	}
}
