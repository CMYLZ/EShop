package cniao5.com.cniao5shop;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by mao on 2016-05-18.
 */
public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findView();
    }

    private void findView() {
        ((TextView)findViewById(R.id.tvTopTitleCenter)).setText("注册");
    }
}
