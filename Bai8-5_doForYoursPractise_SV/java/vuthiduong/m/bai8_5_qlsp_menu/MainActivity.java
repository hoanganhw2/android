package com.example.bai8_5_prj_good_catalog;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinDanhMuc;
    EditText editMaSP,editTenSP,editSoLuong;
//    Button btnNhap;
    ListView lvSanPham;
    //khai báo cặp đối tượng dùng cho Spineer
    ArrayList<Catalog> arraySpinner=new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpinner =null;

    //khai báo cặp đối tượng dùng cho listView
    ArrayList<Product> arrayListView=new ArrayList<Product>();
    ArrayAdapter<Product> adapterListView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //lấy các control gắn với Activity
        getWidgetsControl();
//        //Giả dữ liệu mặc định
        fakeDataCatalog();
        addEventsFormWidGets();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //sv thực hiện với các menu tương ưứng
        return super.onOptionsItemSelected(item);
    }

    private void getWidgetsControl()
    {
        spinDanhMuc=(Spinner)findViewById(R.id.spSanPham);
        editMaSP=(EditText)findViewById(R.id.editMaSP);
        editTenSP=(EditText)findViewById(R.id.editTenSP);
        editSoLuong=(EditText)findViewById(R.id.editSoLuong);
        lvSanPham=(ListView)findViewById(R.id.lvSanPham);
        //cấu hình cho Spinner
        adapterSpinner=new ArrayAdapter<Catalog>
                (this,
                        android.R.layout.simple_spinner_item,
                        arraySpinner);
        adapterSpinner.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinDanhMuc.setAdapter(adapterSpinner);
        //cấu hình cho listView
        adapterListView=new ArrayAdapter<Product>
                (this,
                        android.R.layout.simple_list_item_1,
                        arrayListView);
        lvSanPham.setAdapter(adapterListView);
    }
    //hàm giả dữ liệu tạo 4 danh mục mặ định cho Spinner
    private void fakeDataCatalog()   {
        Catalog cat1=new Catalog("1","SamSung");
        Catalog cat2=new Catalog("2","Nokia");
        Catalog cat3=new Catalog("3","IPAD");
        Catalog cat4=new Catalog("4","HTC");
        //fake some product
        Product product1=new Product("1","SamSung",2);
        Product product2=new Product("2","Nokia",1);
        Product product3=new Product("3","IPAD",3);
        Product product4=new Product("4","HTC",4);
        //set product for catalog
        cat1.addSP(product1);
        cat2.addSP(product2);
        cat3.addSP(product3);
        cat4.addSP(product4);
        //set array for spinner and listview
        arraySpinner.add(cat1);
        arraySpinner.add(cat2);
        arraySpinner.add(cat3);
        arraySpinner.add(cat4);
        adapterSpinner.notifyDataSetChanged();
        //notify for listview if changed
        adapterListView.notifyDataSetChanged();
    }
    /*
     * Hàm gán sự kiện cho Button và spinner
     *
     */
    private void addEventsFormWidGets() {
        spinDanhMuc.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                //mỗi lần chọn danh mục trong Spinner thì cập nhật listView
                loadListProductByCalalog(arraySpinner.get(arg2));
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                editMaSP.setText(arrayListView.get(arg2).getMaSP()+"");
                editTenSP.setText(arrayListView.get(arg2).getTenSP()+"");
                editSoLuong.setText(arrayListView.get(arg2).getSoLuong()+"");
            }
        });
    }
    private void addProductForCatalog() {
        Product p=new Product();
        p.setMaSP(editMaSP.getText()+"");
        p.setTenSP(editTenSP.getText()+"");
        p.setSoLuong(Integer.parseInt(editSoLuong.getText()+""));
        Catalog c=(Catalog)spinDanhMuc.getSelectedItem();
        c.addSP(p);
        //cập nhật lại listview
        loadListProductByCalalog(c);
    }
    /*
     * lọc lại danh sách sản phẩm theo dang mục và update lại listview
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    private void loadListProductByCalalog(Catalog c){
        //xóa danh sách cũ
        arrayListView.clear();
        //lấy lại danh sách mới từ catalog chonh trong Spinner
        arrayListView.addAll(c.getDsSanPham());
        //cập nhật lại listView
        adapterListView.notifyDataSetChanged();
    }

}