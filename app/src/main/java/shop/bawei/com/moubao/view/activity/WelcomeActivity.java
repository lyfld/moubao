package shop.bawei.com.moubao.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.view.adapter.WelcomeAdapter;

/**
 * Created by 刘伊帆 on 2016/12/27.
 * 引导页界面
 */

public class WelcomeActivity extends BaseActivity {
    private ViewPager mWelcomeVp;
    private List<Integer> list;
    private CirclePageIndicator cp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        initViews();
        initData();
        mWelcomeVp.setAdapter(new WelcomeAdapter(list,this));
        cp.setViewPager(mWelcomeVp);

    }

    private void initData() {
        list = new ArrayList<Integer>();
        list.add(R.drawable.welcome1);
        list.add(R.drawable.welcome2);
        list.add(R.drawable.welcome3);
    }

    @Override
    public void initViews() {
        mWelcomeVp = (ViewPager) findViewById(R.id.welcome_view_page);
        cp = (CirclePageIndicator) findViewById(R.id.indicator);
    }

    @Override
    public void initDatas() {

    }
}
