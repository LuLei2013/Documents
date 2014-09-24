/**
 * @author lulei lei.a.lu@ericsson.com
 * @version Sep 24, 2014 4:37:35 PM
 */
public class Table_Student {
	private String id;
	private String name;
	private boolean sexy;
	private int age;

	public Table_Student(String id, String name, boolean sexy, int age) {
		super();
		this.id = id;
		this.name = name;
		this.sexy = sexy;
		this.age = age;
	}

	public Table_Student() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSexy() {
		return sexy;
	}

	public void setSexy(boolean sexy) {
		this.sexy = sexy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
