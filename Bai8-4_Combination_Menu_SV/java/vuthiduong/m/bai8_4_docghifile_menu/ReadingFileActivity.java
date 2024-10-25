package vuthiduong.m.bai8_4_docghifile_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

public class ReadingFileActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvInternal, tvExternal;
    Button btnRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_file);
        tvInternal = (TextView)findViewById(R.id.tvInternal);
        tvExternal = (TextView)findViewById(R.id.tvExternal);
        btnRead=findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        readFromInternal();
        readFromExternal();
    }
    private void readFromInternal(){
        try {
            InputStream is = openFileInput("myFile.txt");
            int size = is.available();
            byte data[] = new byte[size];
            is.read(data);
            is.close();
            String s = new String(data); //s chứa dữ liệu đọc từ file
            tvInternal.setText(s);
        }catch (Exception ex){
        }
    }
    private void readFromExternal() {
        try {
//            File sdcard = Environment.getExternalStorageDirectory();//API<=29
            File sdcard=this.getExternalFilesDir(null);
            File f = new File(sdcard.getAbsolutePath(),"myFile.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            //Read text from file
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line);
                content.append('\n');
            }
            br.close();
            tvExternal.setText(content);
            //API<29
//            String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath() + "/chuthich_ex.txt";
//            try {
//                Scanner scan = new Scanner(new File(sdcard));
//                String data = "";
//                while (scan.hasNext()) {
//                    data += scan.nextLine() + "\n";
//                }
//                scan.close();
//                tvExternal.setText(data + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }}