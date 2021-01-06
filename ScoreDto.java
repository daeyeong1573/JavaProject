package exam01;

import java.util.*;
import java.io.*;

public class ScoreDto implements Serializable, Comparable<ScoreDto> {
	private String sID;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int em;
	private int pro;
	private int ele;
	private int tot;
	private double avg;

	//정보 받아오기
	public ScoreDto(String sID, String name, int kor, int eng, int math, int ele, int pro, int em) {
		this.name = name;
		this.sID = sID;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.em = em;
		this.ele = ele;
		this.pro = pro;
		this.tot = kor + eng + math + ele + pro + em;
		this.avg = tot / 6;
	}

	public int getEm() {
		return em;
	}

	public void setEm(int em) {
		this.em = em;
	}

	public String getName() {
		return name;
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getPro() {
		return pro;
	}

	public int getEle() {
		return ele;
	}

	public int getMath() {
		return math;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}

	public int compareTo(ScoreDto o) { 
		if (getTot() < o.getTot())
			return 1;
		else if (getTot() == o.getTot())
			return 0;
		else
			return -1;
	}

	@Override
	public String toString() {
		return sID + "," + name + "," + kor + "," + eng + "," + math + "," + em + "," + ele + "," + pro + "," + ","
				+ tot + "," + avg;
	}
}