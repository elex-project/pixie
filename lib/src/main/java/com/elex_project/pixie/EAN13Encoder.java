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
import com.google.zxing.oned.EAN13Writer;

/**
 * EAN-13은 유럽에서 가장 흔히 인식되고 있는 바코드로, 기본적인 제품 식별을 위해 슈퍼마켓과 그 밖의 소매점에서 사용됩니다. 미국의 UPC-A 바코드와 동일한 유럽형 코드입니다. EAN은 European Article Number(유럽 상품 코드)를 나타내는데, 이제 기술적으로 International Article Number(국제 상품 번호)로 칭하며 유럽 이외 지역에서도 사용되고 있습니다.
 * <p>
 * 명칭에서 알 수 있듯이 EAN-13 바코드에는 12자릿수가 저장되는 UPC-A 코드와 대조적으로 총 13개의 자릿수가 저장됩니다. 처음 2개 자릿수는 GS1 접두어로, 제품의 원산지를 나타냅니다. 그 다음 5개 자릿수는 브랜드 식별을 위한 회사 번호를, 다음에 오는 5개 자릿수는 제품 자체를 나타냅니다. 그 다음에는 코드 정확성을 확인하기 위한 검사 숫자가 옵니다. 마지막으로 > 기호가 있는데, 바코드 끝을 의미하는 "여백(quiet zone)"에 해당합니다.
 * <p>
 * EAN-13은 널리 이용되고 즉시 식별할 수 있는 코드이며, 모든 바코드 리더기로 판독할 수 있으므로 일상적인 소매 거래에서 유용하게 사용됩니다. 또한 검사 숫자는 수기로 코드를 입력할 때 정확도를 보장하는 데 일조합니다. 특정 방식에 따라 수학적으로 숫자가 함께 결합하여 특유의 1자릿수 결과가 산출됩니다. 검사 숫자가 이 결과와 일치하지 않으면 코드가 잘못 입력된 것입니다.
 * <p>
 * EAN-13 바코드의 문자 제한으로 인해 가능한 용도에서 제약이 따릅니다. 일반적인 슈퍼마켓에서 사용은 괜찮지만, 좀 더 복잡한 품목은 식별할 수 없습니다.
 */
public final class EAN13Encoder extends AbsEncoder {

	public EAN13Encoder() {
		this(Stringz.EMPTY_STRING);
	}

	public EAN13Encoder(String content) {
		super();
		setContent(content);
	}

	@Override
	public BitMatrix encode() throws WriterException {
		return new EAN13Writer().encode(getContent(), BarcodeFormat.EAN_13, 0, 0, hints);
	}
}
