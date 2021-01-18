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
import com.google.zxing.oned.Code93Writer;

/**
 * Code 93 바코드는 보안이 강화되어 업데이트된 Code 39 바코드의 컴팩트 버전으로, 글자와 숫자 모두를 판독할 수 있습니다. 군대, 자동차 분야를 비롯하여 캐나다 우체국에서 특수 배달 정보를 인코딩하기 위한 용도로 사용됩니다.
 * <p>
 * Code 39와 마찬가지로 Code 93 바코드는 일반 ASCII 문자로는 표현할 수 없는 시작 및 끝 기호로 구성되지만, 일반적으로 이러한 기호는 *로 지정됩니다. 시작 기호 다음에는 인코딩된 데이터가 옵니다. Code 39와 같이 각 글자는 특정 숫자 값으로 표현됩니다. 데이터 다음에 두 문자의 검사 수가 오는데, 이 수는 수기로 코드 입력 시 정확도를 보장하기 위해 계산됩니다. 이 두 문자를 "Modulo-47 검사 문자 C"와 "Modulo-47 검사 문자 K"라고 합니다. 코드 내 숫자의 특정 조합으로 나머지가 산출되며, 해당 글자 또는 숫자가 검사 문자 C 또는 K가 됩니다. 검사 수 다음에는 정지 문자가 오고, 그 다음에 종료 바가 뒤따라 바코드의 끝을 나타냅니다.
 * <p>
 * Code 93 바코드는 Code 39보다 더 작고 보다 효율적이며, 보다 나은 데이터 이중화로 한층 높은 보안을 제공합니다. 또한 Code 39에는 없는 5개의 특수 문자가 포함됩니다.
 * <p>
 * Code 39와 달리 Code 93은 자체 점검 코드가 아니므로 검사 숫자가 필요합니다.
 */
public final class Code93Encoder extends AbsEncoder {

	public Code93Encoder() {
		this(Stringz.EMPTY_STRING);
	}

	public Code93Encoder(String content) {
		super();
		setContent(content);
	}

	@Override
	public BitMatrix encode() throws WriterException {
		return new Code93Writer().encode(getContent(), BarcodeFormat.CODE_93, 0, 0, hints);
	}
}
