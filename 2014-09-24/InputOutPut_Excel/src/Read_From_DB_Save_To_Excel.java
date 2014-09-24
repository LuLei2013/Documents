import java.util.List;

/**
 * @author lulei lei.a.lu@ericsson.com
 * @version Sep 24, 2014 4:34:56 PM
 */
public class Read_From_DB_Save_To_Excel {
	public static void main(String[] args) throws Exception {
		DAO dao = new DAO();
		List<Table_Student> students =dao.queryFromDB();
		dao.close();
		SaveAndQuery.inserIntoExcel(students);
		System.out.println("Finished Output");
	}
}
