package com.example.design.CommandCustomizeFuction;

//���������ࣺ����������
public class HelpCommand extends Command {
	private HelpHandler hhObj; //ά�ֶ���������ߵ�����
	
	public HelpCommand() {
		hhObj = new HelpHandler();
	}
	
  //����ִ�з�������������������ߵ�ҵ�񷽷�
	public void execute() {
		hhObj.display();
	}
}