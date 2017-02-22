package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.utils.SpUtils;

/**
 * Created by 刘伊帆 on 2016/12/28.
 * 启动界面
 */

public class LaunchActivity extends BaseActivity {
    private int count = 0;
    private Timer timer;
    private TimerTask tt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity);
        boolean bn = (boolean) SpUtils.getParam(this,FIRST_LAUNCH,false);
        timer = new Timer();
        tt = new TimerTask() {
            @Override
            public void run() {
                count++;
                if(count==3){
                    timer.cancel();
                    if ((boolean)SpUtils.getParam(LaunchActivity.this,FIRST_LAUNCH,false)){
                        startActivity(new Intent(LaunchActivity.this,MainActivity.class));
                        finish();
                    }else{
                        SpUtils.setParam(LaunchActivity.this,FIRST_LAUNCH,true);
                        startActivity(new Intent(LaunchActivity.this,WelcomeActivity.class));
                        finish();
                    }
                }
            }
        };
        timer.schedule(tt,0,1500);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initDatas() {

    }
}
