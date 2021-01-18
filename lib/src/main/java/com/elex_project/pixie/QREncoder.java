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
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * QR(Quick Response) 코드는 자동차 부품의 레이블 지정 및 식별에서 사용하기 위해 고안된 2D 매트릭스 코드입니다. 이 코드는 스마트폰으로 스캔하여 판독할 수 있는 기능 덕분에 상업적 용도로 엄청난 인기를 얻고 있습니다. 광고주들은 인쇄물이든 디지털이든 거의 모든 것에 코드를 포함시킬 수 있고, 스마트폰 사용자들은 코드를 스캔해 메시지를 디코딩하여 특별 혜택이나 할인을 받을 수 있습니다.
 * <p>
 * QR 코드는 매우 단순하거나 매우 복잡할 수 있고 크기 또한 다양합니다. 정사각형 모양에 검정색과 흰색 셀 모두가 포함되어 있습니다. 상단의 두 모서리와 하단 왼쪽 모서리에는 작은 파인더 패턴이 포함되며, 정사각형 안의 정사각형으로 표시됩니다.
 * <p>
 * 매우 빠르게 판독할 수 있고 엄청난 양의 저장 용량을 가지고 있어 거의 모든 방식에서 UPC 바코드보다 우수성을 자랑합니다. 숫자와 영숫자 문자 모두를 인코딩할 수 있을 뿐 아니라 이진 문자, 심지어 중국어의 표어문자도 가능합니다.
 * <p>
 * 높은 저장 용량과 손상된 코드에 대한 오류 보정 기능을 갖추고 있지만, 둘 사이에 트레이드오프가 생깁니다. 오류 보정이 높을수록 저장 용량이 줄어듭니다. 또한 실행 파일을 포함할 수 있으므로 주의하지 않을 경우 장치의 내용이 손실될 위험이 있습니다. 하지만 이 위험 수준은 낮은 편입니다.
 */
public final class QREncoder extends AbsEncoder {

	public QREncoder() {
		this(Stringz.EMPTY_STRING, ErrorCorrectionLevel.M);
	}

	public QREncoder(String content, ErrorCorrectionLevel errorCorrectionLevel) {
		super();
		setContent(content);
		setErrorCorrectionLevel(errorCorrectionLevel);
		setCharacterSet(Stringz.UTF_8);
	}

	public void setErrorCorrectionLevel(ErrorCorrectionLevel errorCorrectionLevel) {
		this.hints.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel);
	}

	public void setCharacterSet(String charset) {
		this.hints.put(EncodeHintType.CHARACTER_SET, charset);
	}

	public void setMargin(int margin) {
		this.hints.put(EncodeHintType.MARGIN, margin);
	}

	public void setVersion(int version) {
		this.hints.put(EncodeHintType.QR_VERSION, version);
	}

	@Override
	public BitMatrix encode() throws WriterException {
		return new QRCodeWriter().encode(getContent(), BarcodeFormat.QR_CODE, 0, 0, hints);
	}
}
