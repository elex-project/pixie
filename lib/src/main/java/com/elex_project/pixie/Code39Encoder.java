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
import com.google.zxing.oned.Code39Writer;

/**
 * "Code 3 of 9" 또는 "Alpha39"라고도 하는 Code 39 바코드는 숫자와 글자 모두를 사용한 최초의 코드입니다. 한 번에 최대 43개의 영숫자 문자를 인코딩할 수 있는 가변 길이 바코드로, 군대와 자동차 산업에서 가장 흔히 사용됩니다.
 * <p>
 * Code 39 바코드는 스캐너에 대한 코드 시작과 끝을 정의하기 위한 시작 및 끝 기호로 구성되며, 보통 일반 글꼴의 *로 나타납니다. 시작/끝 문자 이외에 이 바코드는 기술적으로 1-10까지의 숫자만 인코딩할 수 있습니다. 그러나 특수 표시를 사용하면 글자 범주를 나누어 글자를 지정할 수도 있습니다. 예를 들어, 처음 10개 글자(A-J)에 숫자 값이 지정되고 그 앞에 "Letters" 표시가 옵니다. 다음 10개(K-T)는 "Letters +10"으로 지정됩니다. 따라서 K는 Letters +10이고 그 다음에 1이 오므로 알파벳에서 11번째 글자를 나타냅니다. 그러면 U-Z는 "Letters +20"이 됩니다. 물론 숫자 또한 자체적인 표시를 갖습니다.
 * <p>
 * 글자와 숫자 모두를 이용하므로 Code 39의 활용도가 더욱 높아집니다. 또한 자체 점검 코드이므로 검사 수가 필요하지 않습니다(그래도 검사 수의 사용 권장).
 * <p>
 * 최대 43자로 제한이 있습니다. 또한 코드를 판독하기 위한 숫자 값 할당 방법으로 활용도에 제한이 따르고 다른 문자의 사용이 불가능합니다.
 */
public final class Code39Encoder extends AbsEncoder {

	public Code39Encoder() {
		this(Stringz.EMPTY_STRING);
	}

	public Code39Encoder(String content) {
		super();
		setContent(content);
	}

	@Override
	public BitMatrix encode() throws WriterException {
		return new Code39Writer().encode(getContent(), BarcodeFormat.CODE_39, 0, 0, hints);
	}
}
