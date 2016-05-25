package cniao5.com.cniao5shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cniao5.com.cniao5shop.bean.User;
import cniao5.com.cniao5shop.manager.UserManager;

public class LoginActivity extends Activity{

    private EditText app_login_username_phone_et;
    private EditText app_login_password_et;
    private Button app_login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findView();
    }

    private void findView() {
        ((TextView)findViewById(R.id.tvTopTitleCenter)).setText("登录");
        TextView register = (TextView) findViewById(R.id.tvTopTitleRight);
        register.setVisibility(View.VISIBLE);
        register.setText("注册");
        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        app_login_username_phone_et = (EditText) findViewById(R.id.app_login_username_phone_et);
        app_login_password_et = (EditText) findViewById(R.id.app_login_password_et);
        app_login_btn = (Button) findViewById(R.id.app_login_btn);


        app_login_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String username = app_login_username_phone_et.getText().toString().trim();
                String password = app_login_password_et.getText().toString().trim();
                if(TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "请输入用户名", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
                } else {
                    login(username, password);
                }
            }
        });
    }

    private void login(String username, String password) {
        BmobQuery<User> bmobQuery = new BmobQuery<User>();
        bmobQuery.addWhereContains("username", username);
        bmobQuery.addWhereContains("password", password);
        bmobQuery.findObjects(getApplicationContext(), new FindListener<User>() {

            @Override
            public void onSuccess(List<User> list) {
                if (list != null && list.size() > 0) {
                    UserManager.getInstance().setUser(list.get(0));
                    Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(int i, String s) {
                Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
