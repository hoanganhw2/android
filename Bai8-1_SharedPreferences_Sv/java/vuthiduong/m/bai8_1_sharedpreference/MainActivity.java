package vuthiduong.m.bai8_1_sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTen,editPass;
    Button btnDangNhap,btnThoat;
    CheckBox chkLuuThongTin;
    String tenThongTinDangNhap="login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bước 1: lấy các điều khiển qua findViewByID(..)
        editTen = (EditText) findViewById(R.id.editTen);
        editPass = (EditText) findViewById(R.id.editPass);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        chkLuuThongTin = (CheckBox) findViewById(R.id.chkLuuThongTin);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   saveLoginState();
               }
           }
        );
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveLoginState();
    }
    public void saveLoginState(){
        SharedPreferences preferences=
                getSharedPreferences(tenThongTinDangNhap,MODE_PRIVATE);
        SharedPreferences.Editor  editor=preferences.edit();
        editor.putString("UserName",editTen.getText().toString());
        editor.putString("PassWord",editPass.getText().toString());
        editor.putBoolean("Save",chkLuuThongTin.isChecked());
        editor.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences=
                getSharedPreferences(tenThongTinDangNhap,MODE_PRIVATE);
        String userName=preferences.getString("UserName","");
        String pass=preferences.getString("PassWord","");
        boolean save=preferences.getBoolean("Save",false);
        if (save) {
            editTen.setText(userName);
            editPass.setText(pass);
            chkLuuThongTin.setChecked(save);
        }

    }
}
