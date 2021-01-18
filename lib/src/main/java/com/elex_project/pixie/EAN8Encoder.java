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
import com.google.zxing.oned.EAN8Writer;

/**
 * EAN-8 바코드는 EAN-13 바코드의 압축 버전으로, 유럽과 기타 해외 지역에서 표준 소매 제품 식별자로 사용됩니다. EAN이 European Article Number(유럽 상품 코드)를 나타내지만 International Article Number(국제 상품 번호)로 이름이 변경되었습니다. 그렇다고 해도 "EAN" 약어는 계속해서 사용됩니다. EAN-8(8자릿수)은 EAN-13 코드(13자릿수)가 맞지 않는 소형 크기의 패키지에 사용됩니다.
 * <p>
 * EAN-8 바코드의 8자릿수는 각각 4개씩 두 세트로 나뉩니다. 바코드가 발급된 국가를 나타내는 2개의 플래그 숫자가 포함됩니다. 그런 다음, 제품을 간략하게 식별하는 5개 자릿수의 데이터가 오고, 마지막으로 검사 숫자가 뒤따릅니다. EAN-13 및 UPC-A와 같이 숫자를 제외한 글자나 다른 문자는 사용할 수 없습니다.
 * <p>
 * EAN-8 바코드는 공간을 절약하여 캔디, 담배를 비롯해 그 밖의 소형 또는 개별 포장 품목과 같은 제품의 정확한 식별 코드를 제공합니다. 또한 검사 숫자는 수기로 코드를 입력할 때 정확도를 보장하는 데 일조합니다. 플래그 숫자 덕분에 미국에서만 사용이 국한된 UPC 코드와 달리 국제 용도로 코드 사용이 가능합니다.
 * <p>
 * 제품 ID가 5자리의 데이터로 제한되는 것은 한 세트의 자릿수로 제조업체를, 다른 세트로 제품을 식별하는 EAN-13과 같이 구체적으로 제품을 식별할 수 없음을 뜻합니다. 또한 플래그 숫자로 바코드가 발급된 국가를 식별할 수 있지만, 제품 자체가 제조된 장소와 동일하지 않을 수 있습니다.
 */
public final class EAN8Encoder extends AbsEncoder {

	public EAN8Encoder() {
		this(Stringz.EMPTY_STRING);
	}

	public EAN8Encoder(String content) {
		super();
		setContent(content);
	}

	@Override
	public BitMatrix encode() throws WriterException {
		return new EAN8Writer().encode(getContent(), BarcodeFormat.EAN_8, 0, 0, hints);
	}
}
