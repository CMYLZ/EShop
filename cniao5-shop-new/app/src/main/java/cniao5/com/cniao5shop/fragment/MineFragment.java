package cniao5.com.cniao5shop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cniao5.com.cniao5shop.LoginActivity;
import cniao5.com.cniao5shop.R;
import cniao5.com.cniao5shop.bean.User;
import cniao5.com.cniao5shop.manager.UserManager;


/**
 * Created by Ivan on 15/9/22.
 */
public class MineFragment extends BaseFragment{

    private View mView;
    private TextView txt_username;


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_mine,container,false);

        findView();

        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();

        User user = UserManager.getInstance().getUser();
        if(user != null) {
            txt_username = (TextView) mView.findViewById(R.id.txt_username);
            txt_username.setText(user.getUsername());
        }

        findView();
    }

    private void findView() {
        txt_username = (TextView) mView.findViewById(R.id.txt_username);
        txt_username.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(!"点击登录".equals(txt_username.getText().toString().trim())) {
                    return;
                }

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        if(!"点击登录".equals(txt_username.getText().toString().trim())) {
            txt_username.setOnClickListener(null);
        }
    }

    @Override
    public void init() {

    }
}
