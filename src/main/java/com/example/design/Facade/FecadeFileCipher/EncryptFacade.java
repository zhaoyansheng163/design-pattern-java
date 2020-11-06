//designpatterns.facade.EncryptFacade.java
package designpatterns.facade;

//加密外观类：外观类
public class EncryptFacade {
	//维持对其他对象的引用
	private designpatterns.facade.FileReader reader;
	private designpatterns.facade.CipherMachine cipher;
	private designpatterns.facade.FileWriter writer;

	public EncryptFacade() {
		reader = new designpatterns.facade.FileReader();
		cipher = new designpatterns.facade.CipherMachine();
		writer = new designpatterns.facade.FileWriter();
	}

	//调用其他对象的业务方法
	public void fileEncrypt(String fileNameSrc, String fileNameDes) {
		String plainStr = reader.read(fileNameSrc);
		String encryptStr = cipher.encrypt(plainStr);
		writer.write(encryptStr,fileNameDes);
	}
}