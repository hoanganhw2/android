package vuthiduong.m.bai8_4_docghifile_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DataStorageDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage_demo);
    }
    public void runWriteActivity(View view){
        Intent intent = new Intent(this, WrittingFileActivity.class);
        startActivity(intent);
    }
    public void runReadActivity(View view){
        Intent intent = new Intent(this, ReadingFileActivity.class);
        startActivity(intent);
    }
}