package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.MineBean;
import shop.bawei.com.moubao.percent.LogoutPercent;
import shop.bawei.com.moubao.percent.MinePercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.view.interfaces.LogoutView;

/**
 * Created by 刘伊帆 on 2017/1/13.
 */

public class LogoutActivity extends BaseActivity implements LogoutView,View.OnClickListener{

    private Button backBtn;
    private Button logoutBtn;
    private SimpleDraweeView headerImg;
    private TextView textView;
    private MinePercent minePercent;
    private LogoutPercent logoutPercent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout_activity);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        backBtn = (Button) findViewById(R.id.logout_login_btn_back);
        backBtn.setOnClickListener(this);
        logoutBtn = (Button) findViewById(R.id.logout_btn);
        logoutBtn.setOnClickListener(this);
        headerImg = (SimpleDraweeView) findViewById(R.id.logout_head_img);
        textView = (TextView) findViewById(R.id.logout_login_title);
        textView.setTextColor(Color.WHITE);
    }

    @Override
    public void initDatas() {
        logoutPercent = new LogoutPercent(this);
        logoutPercent.attachView(this);
        String key = (String) SpUtils.getParam(this,Url.SOAL_TOKEN,"");
        logoutPercent.loadDataFromNet(Url.LINK_MOBILE_USER,new OkHttpUtils.Param("key",key));
    }

    @Override
    public void success(MineBean mb) {
        headerImg.setImageURI(mb.getDatas().getMember_info().getAvatar());

    }

    @Override
    public void logout() {
        SpUtils.setParam(this, Url.SOAL_TOKEN,"");
        startActivity(new Intent(this,MainActivity.class));
        Toast.makeText(this,"退出成功!",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.logout_btn:
                String key1 = (String) SpUtils.getParam(this,Url.SOAL_TOKEN,"");
                logoutPercent.logoutUser(Url.LINK_MOBILE_LOGOUT,new OkHttpUtils.Param("key",key1));
                break;
            case R.id.logout_login_btn_back:
                finish();
                break;
            default:
                break;
        }
    }
}
