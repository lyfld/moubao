package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.UserBean;
import shop.bawei.com.moubao.percent.LoginPercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.utils.TextUtil;
import shop.bawei.com.moubao.utils.ToastUtil;
import shop.bawei.com.moubao.view.interfaces.LoginView;

/**
 * Created by 刘伊帆 on 2017/1/11.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener,LoginView{

    private Button backBtn;
    private EditText userNameEt;
    private EditText pawdEt;
    private EditText pwdTwoEt;
    private EditText emailEt;
    private Button okBtn;
    private LoginPercent lp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        backBtn = (Button) findViewById(R.id.register_login_btn_back);
        userNameEt = (EditText) findViewById(R.id.register_username_et);
        pawdEt = (EditText) findViewById(R.id.register_password_et);
        pwdTwoEt = (EditText) findViewById(R.id.register_twopwd_et);
        emailEt = (EditText) findViewById(R.id.register_email_et);
        okBtn = (Button) findViewById(R.id.register_ok_btn);
        okBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void initDatas() {
        lp = new LoginPercent(this);
        lp.attachView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_login_btn_back:
                finish();
                break;
            case R.id.register_ok_btn:
                register();
                break;
            default:
                break;
        }
    }

    private void register() {
        String username = userNameEt.getText().toString().trim();
        String password = pawdEt.getText().toString().trim();
        String passwordRepeat = pwdTwoEt.getText().toString().trim();
        String email = emailEt.getText().toString().trim();
        if (TextUtil.isEmpty(username)) {
            ToastUtil.show(this, "用户名不能为空");
            return;
        }

        if (TextUtil.isEmpty(password)) {
            ToastUtil.show(this, "密码不能为空");
            return;
        }

        if (TextUtil.isEmpty(passwordRepeat)) {
            ToastUtil.show(this, "请再次输入密码");
            return;
        }

        if (TextUtil.isEmpty(email)) {
            ToastUtil.show(this, "请输入邮箱地址");
            return;
        }

        if (!password.equals(passwordRepeat)) {
            ToastUtil.show(this, "密码不一样");
            return;
        }

        if (!password.equals(passwordRepeat)) {
            ToastUtil.show(this, "密码不一样");
            return;
        }

        if (!TextUtil.isEmailAddress(email)) {
            ToastUtil.show(this, "邮箱格式不正确");
            return;
        }
        lp.loadDataFromNet(Url.LINK_MOBILE_REG,new OkHttpUtils.Param("username",username),
                new OkHttpUtils.Param("password",password),new OkHttpUtils.Param("password_confirm",passwordRepeat),
                new OkHttpUtils.Param("email",email),new OkHttpUtils.Param("client",Url.SYSTEM_TYPE));
    }

    @Override
    public void success(UserBean baseBean) {
        if(baseBean.getCode() == 200){
            SpUtils.setParam(this, Url.SOAL_TOKEN,baseBean.getDatas().getKey());
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }else if(baseBean.getCode() == 400){
            Toast.makeText(this,baseBean.getDatas().getError(),Toast.LENGTH_SHORT).show();
        }
    }
}
