/******************************************************************************
 * Project Pixie; about Barcode                                               *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 *                                                                            *
 ******************************************************************************/

package com.elex_project.pixie;

import com.elex_project.abraxas.Stringz;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;

import java.util.HashMap;
import java.util.Map;

public abstract class AbsEncoder {
	private String content;
	protected Map<EncodeHintType, Object> hints;

	protected AbsEncoder() {
		hints = new HashMap<>();
	}

	public String getContent() {
		if (null == content) return Stringz.EMPTY_STRING;
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public abstract BitMatrix encode() throws Exception;
}
