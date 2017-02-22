package shop.bawei.com.moubao.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 刘伊帆 on 2016/12/27.
 */

public abstract class BaseFragment extends Fragment {
    public Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("TAG","执行了"+context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return initlayoutinflterView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initDatas();
    }

    public abstract  View initlayoutinflterView();
    public abstract  void initViews(View v);
    public abstract void initDatas();

}
