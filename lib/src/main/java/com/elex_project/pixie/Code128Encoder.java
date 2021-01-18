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
import com.google.zxing.oned.Code128Writer;

/**
 * Code 128은 대부분의 코드에 비해 고밀도 바코드이지만, 잠재적인 정보 저장 측면에서 1-D 범주 중 가장 활용도가 높은 바코드입니다. 이 코드의 이름은 128개의 ASCII 문자 모드를 인코딩할 수 있다는 사실에서 지어졌습니다. 해당 문자에는 글자와 숫자뿐 아니라 구두점, 기호 등이 포함됩니다. 구매, 선적과 같은 물류 분야에서 가장 흔히 사용되지만, 그 밖의 여러 용도로도 사용될 수 있습니다.
 * <p>
 * Code 128 바코드는 6개 섹션으로 나뉩니다. 첫 번째와 마지막 섹션은 모두 "여백(quiet zone)"으로, 코드의 다른 요소를 기준으로 특정 크기의 공백으로 이루어집니다. 첫 부분의 여백(quiet zone) 다음에는 시작 문자가 나오며, 바코드가 속하는 코드 세트를 지정합니다.
 * <p>
 * Code 128에는 3개의 코드 세트가 있습니다. 세트 A는 모두 대문자로 된 코드를 지정합니다. 세트 B는 대문자와 소문자 모두를 포함한 코드용이고, 세트 C는 숫자 데이터만 있는 코드용이며 동일 공간에 두 배의 데이터를 압축할 수 있습니다.
 * <p>
 * 시작 문자 다음에는 데이터 자체가 옵니다. 인코딩된 각각의 문자는 정확히 3개의 바와 3개의 공백으로 구성됩니다. 그 다음 정확도를 보장하기 위한 검사 숫자가 오고, 코드 끝과 최종적으로 마지막 여백(quiet zone)을 나타내기 위한 끝 문자가 옵니다.
 * <p>
 * Code 128은 활용도가 높을 뿐 아니라 압축되어 있어 동일 공간에서 일반적인 바코드에 비해 훨씬 더 많은 데이터를 저장할 수 있습니다.
 */
public final class Code128Encoder extends AbsEncoder {

	public Code128Encoder() {
		this(Stringz.EMPTY_STRING);
	}

	public Code128Encoder(String content) {
		super();
		setContent(content);
	}

	@Override
	public BitMatrix encode() throws WriterException {
		return new Code128Writer().encode(getContent(), BarcodeFormat.CODE_128, 0, 0, hints);
	}
}
