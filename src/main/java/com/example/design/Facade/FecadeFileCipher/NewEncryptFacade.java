//designpatterns.facade.NewEncryptFacade.java
package com.example.design.Facade.FecadeFileCipher;

public class NewEncryptFacade extends AbstractEncryptFacade {
	private designpatterns.facade.FileReader reader;
	private designpatterns.facade.NewCipherMachine cipher;
	private designpatterns.facade.FileWriter writer;
	
	public NewEncryptFacade() {
		reader = new designpatterns.facade.FileReader();
		cipher = new designpatterns.facade.NewCipherMachine();
		writer = new designpatterns.facade.FileWriter();
	}
	
	public void fileEncrypt(String fileNameSrc, String fileNameDes) {
		String plainStr = reader.read(fileNameSrc);
		String encryptStr = cipher.encrypt(plainStr);
		writer.write(encryptStr,fileNameDes);
	}
}