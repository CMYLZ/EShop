package cniao5.com.cniao5shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mao on 2016-05-18.
 */
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


    }
}
