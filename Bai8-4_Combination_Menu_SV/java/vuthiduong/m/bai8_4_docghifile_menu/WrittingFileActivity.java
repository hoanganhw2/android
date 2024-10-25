package vuthiduong.m.bai8_4_docghifile_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class WrittingFileActivity extends
        AppCompatActivity implements View.OnClickListener {
    EditText etChuThich;
    RadioButton rbInternal, rbExternal;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writting_file);
        etChuThich = (EditText) findViewById(R.id.etChuThich);
        rbInternal = (RadioButton) findViewById(R.id.rbInternal);
        rbExternal = (RadioButton) findViewById(R.id.rbExternal);
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

    }

    public void writeInternal() {
        try {
            OutputStream os = openFileOutput("myFile.txt", MODE_PRIVATE);
            String string = etChuThich.getText().toString();
            os.write(string.getBytes());
            os.close();
        } catch (Exception e) {
            Toast.makeText(this, "Ghi internal thất bại", Toast.LENGTH_SHORT).show();
        }
    }
    public void writeExternal() {
        try {
            File sdcard= this.getExternalFilesDir(null);
//            File sdcard = Environment.getExternalStorageDirectory();
            File f = new File(sdcard.getAbsolutePath(),"myFile.txt");
            OutputStream os = new FileOutputStream(f);
            String string = etChuThich.getText().toString();
            os.write(string.getBytes());
            os.close();
//            String sdcard=Environment.getExternalStorageDirectory()
//                    .getAbsolutePath()+"/chuthich_ex.txt";
//            try {
//                OutputStreamWriter writer=	new OutputStreamWriter(
//                        new FileOutputStream(sdcard));
//                String string = etChuThich.getText().toString();
//                writer.write(string);
//                writer.close();

            } catch (Exception e) {
            Toast.makeText(this, "Ghi external thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        try {
            if (rbInternal.isChecked()) {
                writeInternal();
            } else if (rbExternal.isChecked()) {
                writeExternal();
            } else {
                writeInternal();
                writeExternal();
            }
            Toast.makeText(this, "Ghi dữ liệu thành công!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Ghi dữ liệu thất bại!", Toast.LENGTH_SHORT).show();
        }

    }
}