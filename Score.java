package exam01;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
interface Score //필요한 인터페이스를 구현(추상 메소드 생성)
{
	public void insert();  //입력 메소드
	public DefaultTableModel outputModel(DefaultTableModel model);  //출력메소스
	public DefaultTableModel search(String sID, DefaultTableModel searchModel);  //겁색 메소드
	public DefaultTableModel to_desc(DefaultTableModel model); //순위메소드(총점으로 내림차순)
	public DefaultTableModel to_sID(DefaultTableModel model); //정렬메소드(학번순 내림차순)
	public DefaultTableModel to_name(DefaultTableModel model); //정렬메소드(이름순 내림차순)
	public DefaultTableModel delete(String sID, DefaultTableModel model);  //삭제 메소드
	public void save();  //저장 메소드
	public DefaultTableModel load(DefaultTableModel model);  //출력 메소스
}