package com.sunil.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by User on 7/23/2015.
 */
public class NextActivity extends AppCompatActivity {

    EditText Jet1,Jet2;
    TextView Jtv1, Jtv2;
    Button Jbt, Jbt2;
    public static final String PREF = "mypref";
    public static final String NAME = "name";
    public static final String MAIL = "email";
    SharedPreferences mySharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);

        Jet1 = (EditText)findViewById(R.id.et);
        Jet2 = (EditText) findViewById(R.id.et2);
        Jbt = (Button) findViewById(R.id.bt);
        Jtv1 = (TextView) findViewById(R.id.tv);
        Jtv2 = (TextView)findViewById(R.id.tv2);
        Jbt2 = (Button) findViewById(R.id.bt2);

        mySharedPreferences = getSharedPreferences(PREF ,MODE_PRIVATE);

        Jbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = Jet1.getText().toString();
                String e = Jet2.getText().toString();

                SharedPreferences.Editor myeditor = mySharedPreferences.edit();
                myeditor.putString(NAME,n);
                myeditor.putString(MAIL,e);
                myeditor.commit();
            }
        });

        Jbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm = mySharedPreferences.getString(NAME,"");
                String em = mySharedPreferences.getString(MAIL,"");
                Jtv1.setText(nm);
                Bundle extra = getIntent().getExtras();
                String newM;
                newM = extra.getString("show");
                Jtv2.setText(newM);
            }
        });


    }
}
