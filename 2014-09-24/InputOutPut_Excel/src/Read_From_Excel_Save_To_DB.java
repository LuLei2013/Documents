import java.util.List;

/**
 * @author lulei lei.a.lu@ericsson.com
 * @version Sep 24, 2014 4:35:59 PM
 */
public class Read_From_Excel_Save_To_DB {
	public static void main(String[] args) throws Exception {

		List<Table_Student> students = SaveAndQuery
				.queryFromExcel(Utils.ExcelName);
		DAO dao = new DAO();
		dao.saveIntoDB(students);
		dao.close();
		System.out.println("Finished Input");
	}
}
