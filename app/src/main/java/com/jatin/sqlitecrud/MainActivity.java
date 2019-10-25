package com.jatin.sqlitecrud;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnInsert,btnView,btnUpdate,btnDelete;
    TextView txtData;
    SQLiteOpenHelperMy dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDatabase();
        initViewsAndAddListener();
    }

    private void createDatabase()
    {
        dbHelper = new SQLiteOpenHelperMy(this,"myDb.db",null,1);
        Toast.makeText(this,"Database Created..",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        switch (id)
        {
            case R.id.btnInsert:
            {
                dbHelper.insertData();
                Toast.makeText(this,"Inserted..",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btnView:
            {
                String data = dbHelper.viewData();
                txtData.setText(data);
                break;
            }
            case R.id.btnUpdate:
            {
                dbHelper.updateData();
                Toast.makeText(this,"Updated..",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btnDelete:
            {
                dbHelper.deleteData();
                Toast.makeText(this,"Deleted..",Toast.LENGTH_SHORT).show();
                break;
            }
        }// Switch closed

    }


    private void initViewsAndAddListener()
    {
        txtData = findViewById(R.id.txtData);
        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        btnInsert.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

}
