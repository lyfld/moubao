package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.percent.MainPercent;
import shop.bawei.com.moubao.view.fragment.CartFragment;
import shop.bawei.com.moubao.view.fragment.CategFragment;
import shop.bawei.com.moubao.view.fragment.HomeFragment;
import shop.bawei.com.moubao.view.fragment.MineFragment;
import shop.bawei.com.moubao.view.interfaces.MainView;

/**
 * Created by 刘伊帆 on 2016/12/27.
 * 主界面
 */
public class MainActivity extends BaseActivity implements MainView {

    private RadioGroup mRg;
    private List<Fragment> listFrag;
    private MainPercent mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        mp = new MainPercent(mRg,listFrag,this, R.id.main_framelayout);
        mp.setOnRgsExtraCheckedChangedListener(new MainPercent.OnRgsExtraCheckedChangedListener(){
            @Override
            public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {

            }
        });
    }

    private void initData() {
        listFrag = new ArrayList<Fragment>();
        listFrag.add(new HomeFragment());
        listFrag.add(new CategFragment());
        listFrag.add(new CartFragment());
        listFrag.add(new MineFragment());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if("detailsGoods".equals(intent.getStringExtra("from"))){
//            Log.e("TAG","789456ASDASDSADASDASD");
//            mp.showTab(3);
            RadioButton mRgChildAt = (RadioButton) mRg.getChildAt(2);
            mRgChildAt.setChecked(true);
        }
    }

    @Override
    public void initViews() {
        mRg = (RadioGroup) findViewById(R.id.main_radio_group);

    }

    @Override
    public void initDatas() {

    }
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // must store the new intent unless getIntent() will return the old one
        setIntent(intent);
    }

    /**
     * 菜单、返回键响应
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            exitBy2Click(); //调用双击退出函数
        }
        return false;
    }
    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }

}
