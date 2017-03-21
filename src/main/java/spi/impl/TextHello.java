package spi.impl;

import spi.HelloInterface;

/**
 * Created by wushang on 16/12/8.
 */
public class TextHello implements HelloInterface {

	@Override
	public void sayHello() {
		System.out.println("Text Hello.");
	}

}
