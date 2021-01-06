package exam01;

import java.util.Vector;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.io.*;

public class ScoreImple implements Score {
	private ScoreDto dto;
	private ScoreForm sf;
	private ArrayList<ScoreDto> li; // �߰��� ������
	private ArrayList<ScoreDto> allList;


	public ScoreImple(ScoreForm sf) {
		this.sf = sf;
		li = new ArrayList<ScoreDto>();
		allList = new ArrayList<ScoreDto>();
	}

	// �Է� �޼ҵ�
	@Override
	public void insert() {
		dto = new ScoreDto(sf.getsID(), sf.getName(), sf.getKor(), sf.getEng(), sf.getMath(), sf.getEm(), sf.getPro(),
				sf.getEle());
		li.add(dto);
		allList.add(dto);
	}

	// ��� �޼ҵ�
	@Override
	public DefaultTableModel outputModel(DefaultTableModel model) {
		if (li.size() != 0) {
			for (ScoreDto data : li) {
				Vector<Object> v = new Vector<Object>();
				v.add(data.getsID());
				v.add(data.getName());
				v.add(data.getKor());
				v.add(data.getEng());
				v.add(data.getMath());
				v.add(data.getEm());
				v.add(data.getPro());
				v.add(data.getEle());
				v.add(data.getTot());
				v.add(data.getAvg());
				model.addRow(v);
			}
		} else {
			while (model.getRowCount() != 0) {
				model.removeRow(0);
			}
			for (ScoreDto data : allList) {
				Vector<Object> v = new Vector<Object>();
				v.add(data.getsID());
				v.add(data.getName());
				v.add(data.getKor());
				v.add(data.getEng());
				v.add(data.getMath());
				v.add(data.getEm());
				v.add(data.getPro());
				v.add(data.getEle());
				v.add(data.getTot());
				v.add(data.getAvg());
				model.addRow(v);
			}
		}

		// �� �ʱ�ȭ
		while (li.size() != 0) {
			li.remove(0);
		}

		return model;
	}

	// ã�� �޼ҵ�
	@Override
	public DefaultTableModel search(String sID, DefaultTableModel searchModel) {
		for (int i = 0; i < searchModel.getRowCount(); i++) {
			if (!sID.equals(searchModel.getValueAt(i, 0))) { // ���� �й��� ���� ���� ã�´ٸ�

				searchModel.removeRow(i);
				i = -1;
			}
		}
		return searchModel;
	}

	// ���� �޼ҵ�
	@Override
	public DefaultTableModel to_desc(DefaultTableModel model) {
		Collections.sort(allList);
		if (li.size() != 0) {
			for (ScoreDto data : li) {
				Vector<Object> v = new Vector<Object>();
				v.add(data.getsID());
				v.add(data.getName());
				v.add(data.getKor());
				v.add(data.getEng());
				v.add(data.getMath());
				v.add(data.getEm());
				v.add(data.getPro());
				v.add(data.getEle());
				v.add(data.getTot());
				v.add(data.getAvg());
				model.addRow(v);
			}
		} else {
			while (model.getRowCount() != 0) {
				model.removeRow(0);
			}
			System.out.println(model.getRowCount());
			for (ScoreDto data : allList) {
				Vector<Object> v = new Vector<Object>();
				v.add(data.getsID());
				v.add(data.getName());
				v.add(data.getKor());
				v.add(data.getEng());
				v.add(data.getMath());
				v.add(data.getEm());
				v.add(data.getPro());
				v.add(data.getEle());
				v.add(data.getTot());
				v.add(data.getAvg());
				model.addRow(v);
			}
		}
		// �� �ʱ�ȭ
		while (li.size() != 0) {
			li.remove(0);
		}
		return model;
	}

	//ã�� �޼ҵ�
	@Override
	public DefaultTableModel delete(String sID, DefaultTableModel model) {
		for (int i = 0; i < allList.size(); i++) {
			if (sID.equals(allList.get(i).getsID())) { // ���� �й��� ���� ���� ã�´ٸ�
				allList.remove(i);
				break;
			}
		}
		model = outputModel(model);
		return model;
	}

	//���� ���� �޼ҵ�
	@Override
	public void save() {
		Object o = allList;
		File file = null;
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(sf);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		if (file != null) {
			try {
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(o);
				oos.close();
				fos.close();
			} catch (IOException e) {
			}
		}

	}

	//���� ���� �޼ҵ�
	@Override
	public DefaultTableModel load(DefaultTableModel model) {
		try {
			File file = null;
			JFileChooser c = new JFileChooser();
			int result = c.showOpenDialog(sf);
			if (result == JFileChooser.APPROVE_OPTION) {
				file = c.getSelectedFile();
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object o = ois.readObject();
				allList = (ArrayList<ScoreDto>) o;
				fis.close();
				ois.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		model = outputModel(model);
		return model;
	}

	@Override
	public DefaultTableModel to_sID(DefaultTableModel model) {
		if (li.size() != 0) {
			for (ScoreDto data : li) {
				Vector<Object> v = new Vector<Object>();
				v.add(data.getsID());
				v.add(data.getName());
				v.add(data.getKor());
				v.add(data.getEng());
				v.add(data.getMath());
				v.add(data.getEm());
				v.add(data.getPro());
				v.add(data.getEle());
				v.add(data.getTot());
				v.add(data.getAvg());
				model.addRow(v);
			}
		} else {
			while (model.getRowCount() != 0) {
				model.removeRow(0);
			}
			System.out.println(model.getRowCount());
			for (ScoreDto data : allList) {
				Vector<Object> v = new Vector<Object>();
				v.add(data.getsID());
				v.add(data.getName());
				v.add(data.getKor());
				v.add(data.getEng());
				v.add(data.getMath());
				v.add(data.getEm());
				v.add(data.getPro());
				v.add(data.getEle());
				v.add(data.getTot());
				v.add(data.getAvg());
				model.addRow(v);
			}
		}
		return model;
	}

	@Override
	public DefaultTableModel to_name(DefaultTableModel model) {
		// TODO Auto-generated method stub
		return null;
	}
}