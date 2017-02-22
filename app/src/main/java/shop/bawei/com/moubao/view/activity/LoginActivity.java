package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.UserBean;
import shop.bawei.com.moubao.percent.LoginPercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.view.interfaces.LoginView;

/**
 * Created by 刘伊帆 on 2017/1/10.
 */

public class LoginActivity extends BaseActivity implements LoginView,View.OnClickListener{
    private Button loginLoginBtnBack;
    private TextView loginLoginTitle;
    private EditText loginUsernameEt;
    private EditText loginPasswordEt;
    private Button loginOkBtn;
    private TextView loginRegisteruserTv;
    private TextView loginForgetpwdTv;
    private LoginPercent lp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        lp = new LoginPercent(this);
        lp.attachView(this);
        loginLoginBtnBack = (Button) findViewById(R.id.login_login_btn_back);
        loginLoginBtnBack.setOnClickListener(this);
        loginLoginTitle = (TextView) findViewById(R.id.login_login_title);
        loginUsernameEt = (EditText) findViewById(R.id.login_username_et);
        loginPasswordEt = (EditText) findViewById(R.id.login_password_et);
        loginOkBtn = (Button) findViewById(R.id.login_ok_btn);
        loginOkBtn.setOnClickListener(this);
        loginRegisteruserTv = (TextView) findViewById(R.id.login_registeruser_tv);
        loginRegisteruserTv.setOnClickListener(this);
        loginForgetpwdTv = (TextView) findViewById(R.id.login_forgetpwd_tv);
        loginForgetpwdTv.setOnClickListener(this);
        loginLoginTitle.setTextColor(Color.WHITE);
        loginRegisteruserTv.setTextColor(Color.RED);
        loginForgetpwdTv.setTextColor(Color.RED);
        loginOkBtn.setTextColor(Color.WHITE);

    }

    @Override
    public void initDatas() {

    }

    @Override
    public void success(UserBean baseBean) {

        if(baseBean.getCode() == 200){
            SpUtils.setParam(this,Url.SOAL_TOKEN,baseBean.getDatas().getKey());
            SpUtils.setParam(this,Url.USER_ID,baseBean.getDatas().getUserid());
//            startActivity(new Intent(this,MainActivity.class));
            Toast.makeText(this,"登录成功!",Toast.LENGTH_SHORT).show();
            Log.e("TAG111111",baseBean.getDatas().getKey());
            finish();

        }else if(baseBean.getCode() == 400){
            Toast.makeText(this,baseBean.getDatas().getError(),Toast.LENGTH_SHORT).show();
            loginOkBtn.setText("登  录");
        }

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_login_btn_back:
                finish();;
                break;
            case R.id.login_ok_btn:
                loginOkBtn.setText("登录中。。。");
                login();
                break;
            case R.id.login_registeruser_tv:
//                Toast.makeText(this,"注册",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,RegisterActivity.class));

                break;
            case R.id.login_forgetpwd_tv:
                Toast.makeText(this,"忘记密码",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void login() {
        String userName = loginUsernameEt.getText().toString().trim();
        String pwd = loginPasswordEt.getText().toString().trim();
        if(!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(pwd)){
            lp.loadDataFromNet(Url.LINK_MOBILE_LOGIN,new OkHttpUtils.Param("username",userName),new OkHttpUtils.Param("password",pwd),new OkHttpUtils.Param("client","android"));
        }else if(TextUtils.isEmpty(userName)){
            Toast.makeText(this,"用户名不能为空!",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(pwd)){
            Toast.makeText(this,"密码不能为空!",Toast.LENGTH_SHORT).show();
        }
    }
}
