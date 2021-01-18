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
import com.google.zxing.oned.UPCEWriter;

/**
 * UPC-E 바코드는 UPC로, 미국에서 가장 널리 사용되는 바코드입니다. UPC-E는 표준 규격의 UPC-A 숫자 바코드를 압축한 버전으로, 미국 전역의 식품점이나 그 밖의 소매점에서 사용됩니다. 이 압축 버전은 포장지에 전체 크기의 UPC-A 코드를 인쇄할 수 있는 공간이 부족한 소형 크기의 제품에 사용됩니다.
 * <p>
 * UPC-E 바코드는 UPC-A의 절반 크기로, 12자리가 아닌 6자리로 구성됩니다. 그 외에는 2개 코드가 동일한 방식으로 설정되며, 시작 부분에 스캔할 제품의 유형을 지정(일반 제품, 쿠폰, 무게를 잰 품목 등)하는 자릿수가 오고, 그 다음에 제조업체의 코드, 제품 코드가, 마지막으로 정확성 보장을 위한 검사 숫자가 뒤따릅니다. UPC-E에서 크기를 축소한 이유는 일반적으로 전체 크기 코드에서 나타나는 추가로 사용된 0을 모두 생략했기 때문입니다. 즉, 제품 코드 앞과 제조업체 코드 뒤에 오는 0이 삭제되었습니다.
 * <p>
 * 압축 크기 덕분에 더 작은 패키지에 사용할 수 있습니다. 또한 검사 숫자가 있어 수기로 코드 입력 시 정확성이 확보됩니다.
 * <p>
 * 숫자 코드만 가능하므로 글자를 인코딩할 수 없습니다. 또한 고정 길이 떄문에 인코딩할 정보의 양이 제한되어 슈퍼마켓에서는 적합하나 보다 세부 정보를 전달해야 하는 경우는 적합하지 않습니다.
 */
public final class UPCEEncoder extends AbsEncoder {

	public UPCEEncoder() {
		this(Stringz.EMPTY_STRING);
	}

	public UPCEEncoder(String content) {
		super();
		setContent(content);
	}

	@Override
	public BitMatrix encode() throws WriterException {
		return new UPCEWriter().encode(getContent(), BarcodeFormat.UPC_E, 0, 0, hints);
	}
}
