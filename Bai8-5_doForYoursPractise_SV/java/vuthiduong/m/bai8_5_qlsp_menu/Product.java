package vuthiduong.m.bai8_5_qlsp_menu;
//luu thông tin sản phẩm.
public class Product extends Good{
	private int soLuong;
	public Product() {
		// TODO Auto-generated constructor stub
		super();
		soLuong=0;
	}
	public Product(String maSP, String tenSP, int soLuong) {
		super(maSP, tenSP);
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return  super.toString() + " \t số lượng="+soLuong;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}	
}
