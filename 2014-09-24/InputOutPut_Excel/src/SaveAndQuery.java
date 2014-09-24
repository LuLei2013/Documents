import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @author lulei lei.a.lu@ericsson.com
 * @version Sep 24, 2014 6:03:31 PM
 */
public class SaveAndQuery {
	static void inserIntoExcel(List<Table_Student> students) throws Exception {
		if (students == null)
			return;

		// 创建Excel文档
		HSSFWorkbook hwb = new HSSFWorkbook();
		// sheet 对应一个工作页
		HSSFSheet sheet = hwb.createSheet(Utils.ExcelName);
		HSSFRow title = sheet.createRow(0); // 第一行用于输出表名

		title.createCell(0).setCellValue("学生信息表");
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		HSSFCellStyle style = hwb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		title.getCell(0).setCellStyle(style);
		HSSFRow firstrow = sheet.createRow(1); // 从第2行开始
		firstrow.createCell(0).setCellValue("学号");
		firstrow.createCell(1).setCellValue("姓名");
		firstrow.createCell(2).setCellValue("性别");
		firstrow.createCell(3).setCellValue("年龄");
		// 标记输出内容时，的行列起始坐标
		int i = 2;

		// 循环遍历出每个student对象，并输出到excel中去
		for (Table_Student student : students) {
			HSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(student.getId());
			row.createCell(1).setCellValue(student.getName());
			row.createCell(2).setCellValue(student.isSexy());
			row.createCell(3).setCellValue(student.getAge());
			i++;
		}

		OutputStream out = new FileOutputStream(Utils.ExcelName);
		hwb.write(out);
		out.close();
		System.out.println("Finished output ");
	}

	static List<Table_Student> queryFromExcel(String fileName) throws Exception {
		List<Table_Student> students = new ArrayList<Table_Student>();
		InputStream is = new FileInputStream(System.getProperty("user.dir")
				+ File.separator + fileName);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			// 循环行Row
			for (int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				Table_Student student = new Table_Student(hssfRow.getCell(0)
						.getStringCellValue(), hssfRow.getCell(1)
						.getStringCellValue(), hssfRow.getCell(2)
						.getBooleanCellValue(), (int) hssfRow.getCell(3)
						.getNumericCellValue());
				students.add(student);
			}
		}
		is.close();
		return students;
	}

}
