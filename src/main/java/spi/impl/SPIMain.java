package spi.impl;



import spi.HelloInterface;

import java.util.ServiceLoader;

/**
 * Created by wushang on 16/12/8.
 */
public class SPIMain {
	public static void main(String[] args) {

		ServiceLoader<HelloInterface> loaders =
				ServiceLoader.load(HelloInterface.class);

		for (HelloInterface in : loaders) {
			in.sayHello();
		}
	}
}