package exam01;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JTable;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

class ScoreForm extends JFrame implements ActionListener {
	private JLabel sIDL, nameL, korL, engL, mathL, proL, eleL, emL;
	private JLabel[] allLabel;
	private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
	private JButton[] allBtn;
	private JTextField sIDT, nameT, korT, engT, mathT, proT, eleT, emT;
	private JTextField[] allText;
	private DefaultTableModel model;
	private Vector<String> head;
	private JTable table;
	private ScoreImple si;

	public ScoreForm() {
		si = new ScoreImple(this);
		// �ϴܿ� ��ư ����
		JPanel bottom = new JPanel(new GridLayout(1, 10, 0, 0));
		bt1 = new JButton("�Է�");
		bt2 = new JButton("���");
		bt3 = new JButton("�й��˻�");
		bt4 = new JButton("���� ����");
		bt5 = new JButton("�й� ��");
		bt6 = new JButton("�̸� ��");
		bt7 = new JButton("����");
		bt8 = new JButton("��������");
		bt9 = new JButton("���Ͽ���");
		allBtn = new JButton[] { bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9 };
		// ��ư �гο� ���̱�
		for (int i = 0; i < allBtn.length; i++) {
			bottom.add(allBtn[i]);
		}
		add("South", bottom);

		// ���̺� ����
		head = new Vector<String>();
		head.add("�й�");
		
		head.add("�̸�");
		head.add("����");
		head.add("����");
		head.add("����");
		head.add("���");
		head.add("�ù�");
		head.add("����");
		head.add("����");
		head.add("���");
		model = new DefaultTableModel(head, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		// �߾� ���̾ƿ�
		JPanel center = new JPanel(new GridLayout(1, 5, 0, 0));
		JPanel center1 = new JPanel(new GridLayout(8, 4, 0, 0)); // �󺧰� �ؽ�Ʈ �ʵ尡 ���
		JPanel[] leftP = new JPanel[8];
		for (int i = 0; i < leftP.length; i++) {
			leftP[i] = new JPanel();
			leftP[i].setBackground(new Color(100, 100, 180, 100));
		}
		// �� ����
		sIDL = new JLabel("�й�");
		nameL = new JLabel("�̸�");
		korL = new JLabel("����");
		engL = new JLabel("����");
		mathL = new JLabel("����");
		emL = new JLabel("���");
		proL = new JLabel("�ù�");
		eleL = new JLabel("����");
		allLabel = new JLabel[] { sIDL, nameL, korL, engL, mathL, emL, eleL, proL };
		// �ؽ�Ʈ �ʵ� ����
		sIDT = new JTextField("", 20);
		nameT = new JTextField("", 20);
		korT = new JTextField("", 20);
		engT = new JTextField("", 20);
		mathT = new JTextField("", 20);
		emT = new JTextField("", 20);
		proT = new JTextField("", 20);
		eleT = new JTextField("", 20);
		allText = new JTextField[] { sIDT, nameT, korT, engT, mathT, emT, proT, eleT };
		// �гο� �󺧰� �ؽ�Ʈ �ʵ� �ø���
		for (int i = 0; i < leftP.length; i++) {
			leftP[i].add("West", allLabel[i]);
			leftP[i].add("Center", allText[i]);
		}
		// ������ ���� �ø���
		for (int i = 0; i < 8; i++) {
			center1.add(leftP[i]);
		}
		center.add(center1);
		center.add(scroll);
		add(center);

		// ������ â ����
		setBounds(550, 300, 900, 400);
		setTitle("��������");
		scroll.getViewport().setBackground(Color.lightGray);
		setVisible(true);

		// ��ư�� �̺�Ʈ ����
		for (int i = 0; i < allBtn.length; i++) {
			allBtn[i].addActionListener(this);
		}

		// �̺�Ʈ
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt1) { // �Է�
			JOptionPane.showConfirmDialog(ScoreForm.this, "������ �Է��մϴ�", "����", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			si.insert();
			for (int i = 0; i < allText.length; i++) {
				allText[i].setText("");
			}
		} else if (e.getSource() == bt2) { // ���
			model = si.outputModel(model);
		} else if (e.getSource() == bt3) {// �˻�
			String answer = JOptionPane.showInputDialog(this, "�й��� �Է��ϼ���");
			if (answer != null) {
				model = si.search(answer, model);
			}
		} else if (e.getSource() == bt4) { // ���� ����
			model = si.to_desc(model);
		} else if (e.getSource() == bt5) {//�й� ��
			model = si.to_sID(model);
		} else if (e.getSource() == bt6) {//�̸� ��

		} else if (e.getSource() == bt7) { // ����
			String answer = JOptionPane.showInputDialog(this, "������ �й��� �Է��ϼ���");
			if (answer != null)
				model = si.delete(answer, model);
		} else if (e.getSource() == bt8) { // ���� ����
			si.save();
		} else if (e.getSource() == bt9) { // ���� ����
			model = si.load(model);
		}
	}

	public String getsID() {
		return sIDT.getText();
	}

	public String getName() {
		return nameT.getText();
	}

	public int getKor() {
		return Integer.parseInt(korT.getText());
	}

	public int getEng() {
		return Integer.parseInt(engT.getText());
	}

	public int getMath() {
		return Integer.parseInt(mathT.getText());
	}

	public int getPro() {
		return Integer.parseInt(proT.getText());
	}

	public int getEle() {
		return Integer.parseInt(eleT.getText());
	}

	public int getEm() {
		return Integer.parseInt(emT.getText());
	}
}