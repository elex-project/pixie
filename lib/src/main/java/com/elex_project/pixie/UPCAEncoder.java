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
import com.google.zxing.oned.UPCAWriter;


/**
 * UPC-A 바코드는 미국에서 가장 흔한 형태로, 가장 널리 인식되어 있습니다. 대부분 식품점과 같은 소매점에서 사용됩니다. UPC-A는 IBM과의 협력 하에 UGPCC(Uniform Grocery Product Code Council)에서 개발되었으며 1974년 이후부터 사용되어 왔습니다. 스캔된 최초의 UPC 바코드는 Wrigley의 Juicy Fruit 껌 상자였습니다. 이 상자는 나중에 Smithsonian에 진열되었습니다.
 * <p>
 * UPC-A 바코드는 12자릿수로 구성됩니다. 이 코드는 일반 제품, 무게를 잰 품목, 제약, 쿠폰 등 코드가 분류되는 방식을 지정하는 1자리 숫자 시스템 문자로 시작합니다. 그 다음에는 5자리의 제조업체 번호, 5자리의 제품 번호가 오고 마지막에는 검사 숫자가 뒤따릅니다. 각 자릿수는 여러 가지 폭의 2개 바와 2개 공백으로 이루어진 고유의 식별 패턴으로 표현됩니다. 숫자를 제외한 글자나 다른 특수 기호는 사용할 수 없습니다.
 * <p>
 * UPC-A 바코드는 단순하고 짧으며 널리 이용되고 있으며, 표준 바코드 판독 장비만으로 판독이 가능합니다. 또한 검사 숫자가 특히 수기로 코드를 입력할 때와 같이 실수로 발생하는 오류를 방지해줍니다. 수학 공식에 따라 특정 방식으로 처음 11개 자릿수가 함께 계산되어 최종 숫자가 산출됩니다. 따라서 검사 숫자가 나머지 숫자에 의해 생성된 숫자와 일치하지 않을 경우, 즉시 오류가 있음을 알 수 있습니다.
 * <p>
 * UPC-A 바코드의 12자리 시스템은 작고 제한된 인코딩을 제공하므로 슈퍼마켓이나 소매 용도로 적합하나, 다른 스캔 및 식별 용도로는 사용이 적합하지 않습니다.
 */
public final class UPCAEncoder extends AbsEncoder {

	public UPCAEncoder() {
		this(Stringz.EMPTY_STRING);
	}

	public UPCAEncoder(String content) {
		super();
		setContent(content);
	}

	@Override
	public BitMatrix encode() throws WriterException {
		return new UPCAWriter().encode(getContent(), BarcodeFormat.UPC_A, 0, 0, hints);
	}
}
