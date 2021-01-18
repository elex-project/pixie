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
import com.google.zxing.oned.CodaBarWriter;

/**
 * Codabar는 인쇄 형태, 특히 도트 매트릭스 프린터에서 인쇄된 코드를 판독하기 위해 고안된 자체 점검 바코드입니다. 일반적인 용도에는 Fed-Ex 소포, 혈액 은행 양식 등이 있습니다. 많은 경우에서 Codabar 코드는 새로운 코드 형태로 훨씬 더 작은 공간에 보다 많은 양의 정보를 담을 수 있기 때문에 사용이 중단되었습니다. 그러나 Codabar가 완전히 사장된 것은 아니며 도서관(책의 등쪽)과 그 밖의 여러 조직에서 여전히 사용 중입니다.
 * <p>
 * Codabar 바코드는 최대 16개의 숫자 문자와 코드의 시작과 끝을 지정하는 데 사용되는 선택적인 4개의 추가 글자 문자(일반적으로 A, B, C, D)로 구성됩니다. 글자 순서는 도서관, 혈액 은행, 현상소 등 바코드가 사용되는 용도에 따라 지정됩니다. Codabar는 자체 점검 코드이기 때문에 일부 조직에서는 사용을 권장하긴 하지만 코드 끝에 검사 수가 필요하지 않습니다.
 * <p>
 * Codabar는 넓고 분명하게 간격이 떨어져 있어 표준 프린터로 인쇄된 경우라도 손쉽게 스캔할 수 있습니다. 또한 자체 점검 코드이므로 코드 입력 시 오류가 없습니다.
 * <p>
 * 이전에 언급한 바와 같이 Codabar는 빠르게 사용이 중단되고 있으며, 보다 효율적인 제품 식별자로 대체되고 있습니다.
 */
public final class CodaBarEncoder extends AbsEncoder {
	public CodaBarEncoder() {
		this(Stringz.EMPTY_STRING);
	}

	public CodaBarEncoder(String content) {
		super();
		setContent(content);
	}

	@Override
	public BitMatrix encode() throws WriterException {
		return new CodaBarWriter().encode(getContent(), BarcodeFormat.CODABAR, 0, 0, hints);
	}
}
