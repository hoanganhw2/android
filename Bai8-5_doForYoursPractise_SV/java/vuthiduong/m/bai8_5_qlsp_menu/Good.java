package vuthiduong.m.bai8_5_qlsp_menu;

public class Good {
	public String maSP;
	public String tenSP;
	//hàm tạo
	public Good(String maSP, String tenSP) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
	}
	public Good(){}
	//các hàm getter/setter
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	//ghi đề tostring
	@Override
	public String toString() {
		return "ma SP=" + maSP + "\t tenSP=" + tenSP ;
	}
	//chèn equal &hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSP == null) ? 0 : maSP.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Good other = (Good) obj;
		if (maSP == null) {
			if (other.maSP != null)
				return false;
		} else if (!maSP.equals(other.maSP))
			return false;
		return true;
	}
}
