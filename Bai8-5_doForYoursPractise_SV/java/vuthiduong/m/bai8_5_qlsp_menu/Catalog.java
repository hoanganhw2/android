package vuthiduong.m.bai8_5_qlsp_menu;

import java.util.ArrayList;

//lớp chứa danh sách sản phẩm
public class Catalog {
	private String maDM,tenDM;
	private ArrayList<Product> dsSanPham =null;
	public Catalog(String ma, String ten) {
		// TODO Auto-generated constructor stub
		maDM=ma;tenDM=ten;
		dsSanPham = new ArrayList<Product>();
	}
	/*
	 * Kiểm tra sản phẩm đã tồn tại trong danh mục chưa
	 * @para p - Product
	 * @return true nếu tồn tại
	 */
	public boolean kiemTraSanPham(Product p){
		for(Product p1:dsSanPham){
			if (p1.getMaSP().trim().equalsIgnoreCase(p.getMaSP().trim()))
				return true;
		}
		return false;
	}
	/*
	 * Thêm 1 sản phẩm vào danh mục
	 * thêm thành công true
	 */
	public boolean addSP(Product p)	{
		boolean kiemTra=kiemTraSanPham(p);
		if (!kiemTra)
		{
			dsSanPham.add(p);
			return true;
		}
		else return false;
	}
	public ArrayList<Product> getDsSanPham() {
			return dsSanPham;
	}
	@Override
	public String toString() {
		return maDM + "-" + tenDM ;
	}



}
