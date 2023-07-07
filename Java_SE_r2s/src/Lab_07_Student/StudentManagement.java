package Lab_07_Student;

public class StudentManagement {
	public static void main(String[] args) {
		Student st = new Student("100-A1", "Le Quoc", 3, 3, 4 );
		st.xemThongTin();
		st.xetHocBong(st.getXepLoai());
		st.xetLenLop(st.getdTB());
	}
}
