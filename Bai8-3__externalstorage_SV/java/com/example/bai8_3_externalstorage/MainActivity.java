package com.example.bai8_3_externalstorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
		implements OnClickListener{

	Button btnRead,btnWrite;
	EditText editData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnRead= findViewById(R.id.btnreaddata);
		btnWrite=findViewById(R.id.btnwritedata);
		editData=findViewById(R.id.editdata);
		btnRead.setOnClickListener(this);
		btnWrite.setOnClickListener(this);
	}
	public void onClick(View v) {
		if(v.getId()==R.id.btnreaddata)
		{
			readData();
		}
		else if(v.getId()==R.id.btnwritedata)
		{
			writeData();
		}
	}
	/*
	 * đọc từ SD Card API<29
	 * Environment.getExternalStorageDirectory().getAbsolutePath()
	 * để lấy đường dẫn trên SD Card
	 */
	public void readData(){
		//API <29
//		String sdcard=Environment.getExternalStorageDirectory().getAbsolutePath();
		//API 29+
		String sdcard=this.getExternalFilesDir(null)
				.getAbsolutePath()+"/myFile.txt";
		try {
			Scanner scan=new Scanner(new File(sdcard));
			String data="";
			while(scan.hasNext()){
				data+=scan.nextLine()+"\n";
			}
			scan.close();
			editData.setText(data+"");
			Toast.makeText(this, "đọc file ok", Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			Toast.makeText(this, "lỗi đọc file:" +sdcard, Toast.LENGTH_SHORT).show();
			Log.e("DocFile",ex.toString());
		} catch (IOException e) {
			e.printStackTrace();
			Toast.makeText(this, "lỗi đọc file:" +sdcard, Toast.LENGTH_SHORT).show();
			Log.e("DocFile",e.toString());
		}
	}
	/**
	 * ghi tập tin trên SD Card
	 */
	public void writeData()	{
		//API<29
//		String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath()+"/myfile.txt";
		//API>=29+
		String sdcard=this.getExternalFilesDir(null)
				.getAbsolutePath()+"/myfile.txt";
		try {
			OutputStreamWriter writer=	new
					OutputStreamWriter(
					new FileOutputStream(sdcard));
			writer.write(editData.getText()+"");//dữ liệu cần ghi
			writer.close();
			Toast.makeText(this, "ghi file ok", Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Toast.makeText(this, "lỗi ghi file", Toast.LENGTH_SHORT).show();
			Log.e("GhiFile",e.toString());
		} catch (IOException e) {
			Toast.makeText(this, "lỗi ghi file", Toast.LENGTH_SHORT).show();
			Log.e("GhiFile",e.toString());
		}
	}
}
