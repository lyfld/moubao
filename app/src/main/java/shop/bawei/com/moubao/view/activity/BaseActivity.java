package shop.bawei.com.moubao.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 刘伊帆 on 2016/12/27.
 * activity 基类
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected  final String FIRST_LAUNCH = "first_launch";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initViews();

    }
    public abstract  void initViews();
    public abstract void initDatas();
    private long mPressedTime = 0;





}
