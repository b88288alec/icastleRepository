package com.icastle.Orders.main;
import java.io.File;
import jxl.*;
import jxl.write.WritableWorkbook;
import jxl.write.WritableSheet;
import jxl.write.Label;
import jxl.write.Number;

/**
 * @author Roy Mercadian
 */
public class ExcelWrite{
	public static void main(String[] args) {
		try{
			//創建WritableWorkbook
			WritableWorkbook workbook = Workbook.createWorkbook(new File("D:\\output.xls"));
			//創建WritableSheet
			WritableSheet sheet = workbook.createSheet("工作表", 0);//產生一個名稱為"我的工作表1"的工作表，這是第0個工作表
			Label label = new Label(0, 0, "訂單編號");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label);
			Label label1 = new Label(1, 0, "下訂日期");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label1);
			Label label2 = new Label(2, 0, "飯店名稱");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label2);
			Label label3 = new Label(3, 0, "房型名稱");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label3);
			Label label4 = new Label(4, 0, "入住日期");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label4);
			Label label5 = new Label(5, 0, "退房日期");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label5);
			Label label6 = new Label(6, 0, "訂房數量");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label6);
			Label label7 = new Label(7, 0, "入住人數");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label7);
			Label label8 = new Label(8, 0, "早餐");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label8);
			Label label9 = new Label(9, 0, "晚餐");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label9);
			Label label10 = new Label(10, 0, "下午茶");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label10);
			Label label11 = new Label(11, 0, "加床");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label11);
			Label label12 = new Label(12, 0, "加床價格");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label12);
			Label label13 = new Label(13, 0, "入住人姓名");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label13);
			Label label14 = new Label(14, 0, "生日");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label14);
			Label label15 = new Label(15, 0, "電話");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label15);
			Label label16 = new Label(16, 0, "e-mail");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label16);
			Label label17 = new Label(17, 0, "地址");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label17);
			Label label18 = new Label(18, 0, "身分證字號");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label18);
			Label label19 = new Label(19, 0, "國籍");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label19);
			Label label20 = new Label(20, 0, "護照號碼");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label20);
			Label label21 = new Label(21, 0, "旅客備註");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label21);
			Label label22 = new Label(22, 0, "備忘錄");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label22);
			Label label23 = new Label(23, 0, "總金額");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label23);
			Label label24 = new Label(24, 0, "訂單狀態");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label24);
			Label label25 = new Label(25, 0, "取消日期");//建立Label物件的參數是(int column, int row, String value) A2 Name
			sheet.addCell(label25);
			Number number = new Number(0, 1, 1.414); //建立Number物件的參數是(int column, int row, int value) C1 1.414
			sheet.addCell(number);
			workbook.write();
			workbook.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}