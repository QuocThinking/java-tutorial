package Lab_07_Vehicle;

public class Vehicle {
	private String tenChuXe, tenLoaiXe;
	private int dungtichXe;
	private double trigiaXe, thueTruocBa;

	public Vehicle() {
		super();
	}

	public Vehicle(String tenChuXe, String tenLoaiXe, int dungtichXe, double trigiaXe) {
		super();
		this.tenChuXe = tenChuXe;
		this.tenLoaiXe = tenLoaiXe;
		this.dungtichXe = dungtichXe;
		this.trigiaXe = trigiaXe;

	}

	public String getTenChuXe() {
		return tenChuXe;
	}

	public void setTenChuXe(String tenChuXe) {
		if (this.tenChuXe == null || this.tenChuXe.equals("")) {
			this.tenChuXe = "không biết";
		} else {
			this.tenChuXe = tenChuXe;
		}
	}

	public String getTenLoaiXe() {
		return tenLoaiXe;
	}

	public void setTenLoaiXe(String tenLoaiXe) {
		if (this.tenLoaiXe == null || this.tenLoaiXe.equals("")) {
			this.tenLoaiXe = "không biết";
		} else {
			this.tenLoaiXe = tenLoaiXe;
		}
	}

	public int getDungtichXe() {
		return dungtichXe;
	}

	public void setDungtichXe(int dungtichXe) {
		if (dungtichXe < 0) {
			this.dungtichXe = 0;
		} else {
			this.dungtichXe = dungtichXe;
		}
	}

	public double getTrigiaXe() {
		return trigiaXe;
	}

	public void setTrigiaXe(double trigiaXe) {
		if (trigiaXe < 0) {
			this.trigiaXe = 0;
		} else {
			this.trigiaXe = trigiaXe;
		}
	}

	public double getThueTruocBa() {
		double heSo;
		if (this.dungtichXe < 100) {
			heSo = 0.01;
		} else if ( this.dungtichXe <= 200) {
			heSo = 0.03;
		} else {
			heSo = 0.05;
		}
		return heSo * this.trigiaXe;

	}

	public String heSo() {
		if (this.dungtichXe < 100) {
			return ("Hệ số xe là 1%");
		} else if (this.dungtichXe >= 100 && this.dungtichXe <= 200) {
			return ("Hệ số xe là 3%");
		} else {
			return ("Hệ số xe là 5%");
		}
	}

	public void hienThiThongTin() {
		System.out.println("Tên chủ xe : " + this.tenChuXe + "\n" + "Tên loại xe : " + this.tenLoaiXe + "\n"
				+ "Dung tích xe : " + this.dungtichXe + "cc" + "\n" + "Trị giá xe : " + this.trigiaXe + "VNĐ" + "\n"
				+ heSo() + "\n" + "Thuế trước bạ : " + getThueTruocBa());
	}

}
