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
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;

/**
 * 데이터 매트릭스는 2D 매트릭스 코드로, 작은 공간에 매우 많은 양의 데이터를 인코딩할 수 있습니다. 항공 우주, 구성품 레이블 지정, 군수, 우편, 인쇄 매체 등을 포함하여 여러 가지 기능으로 사용됩니다.
 * <p>
 * Data Matrix는 최대 2,335개의 영숫자 문자 또는 최대 3,116개의 숫자 문자를 인코딩할 수 있습니다. 이 코드는 정사각형 패턴 또는 직사각형 패턴으로 여러 개의 검정색 및 흰색 셀 블록으로 구성됩니다. 또한 각 데이터 매트릭스는 주변 파인더와 타이밍 패턴 모두를 포함합니다. 대형, 소형 등 다양한 크기의 기호를 인코딩할 수 있으며, 각 매트릭스 코드의 가장자리를 따라 여백(quiet zone)이 있습니다.
 * <p>
 * Data Matrix 코드는 오류 보정 시스템이 내장되어 있어 최대 40%까지 손상된 경우라도 판독할 수 있도록 고안되었습니다. 또한 글자, 숫자 데이터 또는 그 밖의 ASCII 문자를 인코딩할 수 있습니다.
 * <p>
 * 대부분 1D 바코드보다 훨씬 더 많은 문자를 판독할 수 있지만 전체 문자 제한이 존재하기 때문에 장문의 메시지 전송은 불가능합니다.
 */
public final class DataMatrixEncoder extends AbsEncoder {

	public DataMatrixEncoder(String content) {
		super();
		setContent(content);
		setCharacterSet("ISO-8859-1");
	}

	public DataMatrixEncoder() {
		this(Stringz.EMPTY_STRING);
	}

	public void setCharacterSet(String charset) {
		this.hints.put(EncodeHintType.CHARACTER_SET, charset);
	}

	public void setShape(SymbolShapeHint shape) {//SymbolShapeHint.
		this.hints.put(EncodeHintType.DATA_MATRIX_SHAPE, shape);
	}

	@Override
	public BitMatrix encode() {
		return new DataMatrixWriter().encode(getContent(), BarcodeFormat.DATA_MATRIX, 0, 0, hints);
	}
}
