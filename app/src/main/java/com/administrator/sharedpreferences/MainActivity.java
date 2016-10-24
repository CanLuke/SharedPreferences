package com.administrator.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText edtUserName;
    private EditText edtPwd;
    private CheckBox checkBox;
    private Button btnLogin;
    private Button btnCancle;
    private String user,pass;
    private boolean state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        edtUserName = (EditText) findViewById(R.id.edit_user);
        edtPwd = (EditText) findViewById(R.id.edit_pwd);

        checkBox = (CheckBox) findViewById(R.id.checkbox);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnCancle = (Button) findViewById(R.id.btn_cancle);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox)v).isChecked()){
                    state = true;
                }else {
                    state = false;
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(edtUserName.getText().toString(), edtPwd.getText().toString());
            }
        });
        /*String userName = edtUserName.getText().toString();
        String*/

    }

    private void login(String userName,String pwd) {
        user = userName;
        pass = pwd;
        if (state){
            SharedPreferences spf = getSharedPreferences("MyPre",MODE_PRIVATE);
            SharedPreferences.Editor editor = spf.edit();
            editor.putString("userName",user);
            editor.putString("pwd",pass);
            editor.commit();
            String name = spf.getString("userName", "");
            if (name==null) {
                checkBox.setChecked(false);
            }else {
                checkBox.setChecked(true);
                edtUserName.setText(name);
            }
            /*System.out.println(spf.getString("userName", ""));
            System.out.println(spf.getString("pwd", ""));*/
        }else {
            
        }
    }
}
