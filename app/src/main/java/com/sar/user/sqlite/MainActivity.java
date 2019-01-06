package com.sar.user.sqlite;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Sqlite sqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlite=new Sqlite(this);
        final EditText editText1=findViewById(R.id.editText2);
        final EditText editText2=findViewById(R.id.editText3);
        final EditText editText3=findViewById(R.id.editText);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean a=sqlite.insert(editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString());
                if(a)
                {
                    Toast.makeText(MainActivity.this,"data add",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"data add",Toast.LENGTH_SHORT).show();
            }
        });
        Button button1=findViewById(R.id.button3);
        final AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setCancelable(true);
        alertDialog.setTitle("Data");
        alertDialog.create();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cu=sqlite.showall();
                if(cu.getCount()==0)
                {
                    alertDialog.setMessage("Data is empty");
                    alertDialog.show();
                    return;

                }
                else
                {
                    StringBuffer stringBuffer=new StringBuffer();
                    while (cu.moveToNext())
                    {
                        stringBuffer.append("ID-"+cu.getString(0)+"\n");
                        stringBuffer.append("NAME-"+cu.getString(1)+"\n");
                        stringBuffer.append("SURNAME-"+cu.getString(2)+"\n");
                        stringBuffer.append("MARKS-"+cu.getString(3)+"\n");

                    }
                    alertDialog.setMessage(stringBuffer.toString());
                    alertDialog.show();

                }

            }
        });
    }
}
