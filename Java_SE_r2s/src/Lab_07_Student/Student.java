package Lab_07_Student;

public class Student {
	private String maSo, hoTen;
	private double dToan, dVan,dAnh,dTB;
	public Student() {
		super();
	}
	public Student(String maSo, String hoTen, double dToan, double dVan, double dAnh) {
		super();
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.dToan = dToan;
		this.dVan = dVan;
		this.dAnh = dAnh;
		
	}
	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public double getdToan() {
		return dToan;
	}
	public void setdToan(double dToan) {
		this.dToan = dToan;
	}
	public double getdVan() {
		return dVan;
	}
	public void setdVan(double dVan) {
		this.dVan = dVan;
	}
	public double getdAnh() {
		return dAnh;
	}
	public void setdAnh(double dAnh) {
		this.dAnh = dAnh;
	}
	public double getdTB() {
		dTB = (this.dAnh+this.dToan+this.dVan)/3;
		return dTB;
	}
	public void setdTB(double dTB) {
		this.dTB = dTB;
	}
	
//	public double diemTB() {
//		return (this.dAnh+this.dToan+this.dVan)/3;
//	}
	public String getXepLoai() {
		if(dTB >= 8.5) {
			return "Giỏi";
		}else if(dTB >= 6.5) {
			return "Khá";
		}else if(dTB  >= 5.0) {
			return "Trung Bình";
		}else if(dTB  >= 3.5) {
			return "Yếu";
		}else  {
			return"kém";
		}
	}
	
	public void xetHocBong(String xepLoai) {
		if(xepLoai.equals("Giỏi")) {
			System.out.println("Bạn được học bổng");
		}else {
			System.out.println("Bạn không được học bổng");
		}
	}
	public void xetLenLop(double diemTB) {
		if(diemTB >= 5) {
			System.out.println("Điểm tb của bạn : " + diemTB + " Bạn được lên lớp");
		}else if(diemTB >= 3.5) {
			System.out.println("Điểm tb của bạn : " + diemTB + " Bạn phải thi lại");
		}else {
			System.out.println("Điểm tb của bạn : " + diemTB + " Bạn ở lại lớp");
		}
	}
	
	public void xemThongTin() {
		System.out.println("Mã số học sinh : " + this.maSo + "\n" +
	                       "Tên học sinh : " + this.hoTen + "\n" +
				           "Điểm toán : " + this.dToan + "\n" +
	                       "Điểm anh : " + this.dAnh + "\n" +
				           "Điểm văn :" + this.dVan + "\n" +
	                       "Điểm trung bình : " + getdTB() + "\n" +
				           "Xếp loại : " + getXepLoai());
	}
	
}
