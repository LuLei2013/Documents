import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lulei lei.a.lu@ericsson.com
 * @version Sep 24, 2014 4:36:11 PM
 */
public class DAO {

	public Connection con;
	public Statement statement;

	public DAO() {
		try {
			Class.forName(Utils.driverName);
			con = DriverManager.getConnection(Utils.url + Utils.DBName,
					Utils.userName, Utils.passWord);
			statement = con.createStatement();
		} catch (Exception e) {
			System.out.println("Error: there is no driver available");
		}
	}

	public List<Table_Student> queryFromDB() throws SQLException {

		ResultSet resultSet = statement.executeQuery("select * from student");
		List<Table_Student> students = new ArrayList<Table_Student>();
		while (resultSet.next()) {
			students.add(new Table_Student(resultSet.getString(1), resultSet
					.getString(2), resultSet.getBoolean(3), resultSet.getInt(4)));
		}
		return students;
	}

	public void saveIntoDB(List<Table_Student> students) throws SQLException {
		for (Table_Student table_Student : students) {
			String sql = "insert into student( id,name,sexy,age) values ( "
					+ "\"" + table_Student.getId() + "\" " + ",\""
					+ table_Student.getName() + "\","
					+ table_Student.isSexy() + ","
					+ table_Student.getAge() + ")";

			System.out.println(sql);
			statement.execute(sql);

		}
	}

	public void close() {
		try {
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
