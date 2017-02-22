package shop.bawei.com.moubao.view.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 刘伊帆 on 2016/12/28.
 */

public class HomeFragment extends BaseFragment {


    @Override
    public View initlayoutinflterView() {
        TextView tv = new TextView(context);
        tv.setText("首页");
        return tv;
    }

    @Override
    public void initViews(View v) {

    }

    @Override
    public void initDatas() {

    }
}
