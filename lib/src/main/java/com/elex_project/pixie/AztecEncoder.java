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
import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;

/**
 * Aztec 코드는 중앙의 파인더 코드가 아즈텍 피라미드의 조감도와 다소 흡사한 이유로 이름이 붙여졌습니다. Aztec은 2D 매트릭스 코드로, 일반적으로 항공사 티켓, 기타 여행 문서를 비롯한 자동차 등록 문서에 사용됩니다. 또한 병원에서 환자 식별이나 의약품, 검체 또는 특정 환자와 관련된 기타 항목을 식별하는 데 사용될 수도 있습니다.
 * <p>
 * 대부분의 2D 매트릭스 코드와 달리 Aztec 코드에는 가장자리 주변에 여백(quiet zone)이 필요하지 않습니다. 따라서 더 작은 공간에 보다 많은 데이터를 저장할 수 있습니다. 파인더 패턴은 Aztec 코드의 정중앙에 위치하고, 동심원의 4각 링으로 그 주변에 나머지 데이터가 인코딩됩니다.
 * <p>
 * Aztec 코드는 다른 매트릭스 코드에 비해 보다 효율적으로 공간을 활용합니다. 크기 또한 다양하므로 방대한 양의 데이터를 포함할 수 있습니다. 또한 Aztec 코드는 오류 보정 기능이 함께 제공되며, 백분율을 선택할 수 있습니다.
 * <p>
 * Aztec 코드는 QR 코드처럼 가나 또는 간지 문자를 지원하지 않습니다.
 */
public final class AztecEncoder extends AbsEncoder {

	public AztecEncoder() {
		this(Stringz.EMPTY_STRING);
	}

	public AztecEncoder(String content) {
		super();
		setContent(content);
		setMinECCPercent(Encoder.DEFAULT_EC_PERCENT);
		setLayers(Encoder.DEFAULT_AZTEC_LAYERS);
		setCharacterSet(Stringz.UTF_8);
	}

	/**
	 * minimal percentage of error check words (According to ISO/IEC 24778:2008, a minimum of 23% + 3 words is recommended)
	 *
	 * @param minECCPercent
	 */
	public void setMinECCPercent(int minECCPercent) {
		if (minECCPercent < 25) minECCPercent = 25;
		hints.put(EncodeHintType.ERROR_CORRECTION, minECCPercent);
	}

	public void setCharacterSet(String charset) {
		this.hints.put(EncodeHintType.CHARACTER_SET, charset);
	}

	/**
	 * Specifies the required number of layers for an Aztec code. A negative number (-1, -2, -3, -4) specifies a compact Aztec code. 0 indicates to use the minimum number of layers (the default). A positive number (1, 2, .. 32) specifies a normal (non-compact) Aztec code. (Type Integer, or String representation of the integer value).
	 *
	 * @param layers
	 */
	public void setLayers(int layers) {
		this.hints.put(EncodeHintType.AZTEC_LAYERS, layers);
	}

	@Override
	public BitMatrix encode() {
		return new AztecWriter().encode(getContent(), BarcodeFormat.AZTEC, 0, 0, hints);
	}
}
