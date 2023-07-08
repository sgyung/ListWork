package day0707;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class Work0706 {
	
	private List<WorkVO> studentList;
	
	public Work0706() {
		studentList = new ArrayList<WorkVO>();
	}
	
	public void selectMenu() {
		boolean exitFlag = false;
		String inputData = "";
		String[] tempData = null;
		
		do {
			inputData = JOptionPane.showInputDialog("이름,자바점수,오라클점수를 입력\n\"출력\"을 입력하시면 출력합니다.\n그만두실려면 Y|y를 입력해주세요.");
			
			
			if (inputData != null && !inputData.equals("")) {
				
				inputData = inputData.replace(" ", "");// White Space 처리
				
				tempData = inputData.split(",");
				if (tempData.length == 3) {
					dataInput(tempData);
				}
				if (inputData.equals("출력")) {
					printdataInput();
				}
				if (inputData.toUpperCase().equals("Y")) {
					exitFlag = exitProgram();
					JOptionPane.showMessageDialog(null,"사용해주셔서 감사합니다.!!");
				}
				
			}
			
		} while (!exitFlag);
	
	}
	
	public void dataInput(String[] data) {
		// 입력된 배열을 사용하여 VO를 생성하고
		// 리스트에 추가
		studentList.add(new WorkVO(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2])));
		
	}
	
	public void printdataInput() {
		System.out.println("번호\t이름\t자바\t오라클\t총점");
		WorkVO wVO = null;			
		
		if (studentList.isEmpty()) {
			System.out.println("데이터가 없습니다.");
		}
		
		for (int i = 0; i < studentList.size(); i++) {
			wVO = studentList.get(i);
			System.out.printf("%d\t%s\t%d\t%d\t%d\n",i+1,wVO.getName(),wVO.getJavaScore(),wVO.getOracleScore(),wVO.getJavaScore()+wVO.getOracleScore());
		}
	}
	
	public boolean exitProgram() {
		return true;
	}
	

	public static void main(String[] args) {
		Work0706 w = new Work0706();
		w.selectMenu();
		
		
	}

}
