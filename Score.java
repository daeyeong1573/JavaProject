package exam01;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
interface Score //�ʿ��� �������̽��� ����(�߻� �޼ҵ� ����)
{
	public void insert();  //�Է� �޼ҵ�
	public DefaultTableModel outputModel(DefaultTableModel model);  //��¸޼ҽ�
	public DefaultTableModel search(String sID, DefaultTableModel searchModel);  //�̻� �޼ҵ�
	public DefaultTableModel to_desc(DefaultTableModel model); //�����޼ҵ�(�������� ��������)
	public DefaultTableModel to_sID(DefaultTableModel model); //���ĸ޼ҵ�(�й��� ��������)
	public DefaultTableModel to_name(DefaultTableModel model); //���ĸ޼ҵ�(�̸��� ��������)
	public DefaultTableModel delete(String sID, DefaultTableModel model);  //���� �޼ҵ�
	public void save();  //���� �޼ҵ�
	public DefaultTableModel load(DefaultTableModel model);  //��� �޼ҽ�
}