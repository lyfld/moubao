package shop.bawei.com.moubao.percent;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioGroup;

import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.view.activity.LoginActivity;
import shop.bawei.com.moubao.view.interfaces.MainView;

/**
 * Created by 刘伊帆 on 2016/12/28.
 */

public class MainPercent extends BasePercent<MainView> implements RadioGroup.OnCheckedChangeListener{
    private MainView mv;
    private RadioGroup mRg;
    private List<Fragment> listFrag;
    private FragmentActivity fragmentActivity;
    private int fragmentContentId;
    private int currentTab;



    private OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener; // 用于让调用者在切换tab时候增加新的功能

    public MainPercent(RadioGroup mRg, List<Fragment> listFrag, FragmentActivity fragmentActivity, int fragmentContentId) {
        this.mRg = mRg;
        this.listFrag = listFrag;
        this.fragmentActivity = fragmentActivity;
        this.fragmentContentId = fragmentContentId;

        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
        ft.add(fragmentContentId,listFrag.get(0));
        ft.commit();

        mRg.setOnCheckedChangeListener(this);
    }
    private FragmentTransaction obtainFragmentTransaction(int index){
        FragmentTransaction fm = fragmentActivity.getSupportFragmentManager().beginTransaction();
        // 设置切换动画
        if(index > currentTab){
            fm.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
        }else{
            fm.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
        }


        return fm;
    }

    public int getCurrentTab() {
        return currentTab;
    }
    public void showTab(int index){
        for (int i = 0; i < listFrag.size(); i++) {
            Fragment ft = listFrag.get(i);
            FragmentTransaction fn= obtainFragmentTransaction(index);
            if(index == i){
                fn.show(ft);
//                Log.e("TAG","OOOOOOOOOOOOOOOOOOO");
            }else {
                fn.hide(ft);
            }
            fn.commit();

        }
        currentTab = index;
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        for(int j = 0;j< mRg.getChildCount();j++){

            if(mRg.getChildAt(j).getId() == i){
                if(j==2){
                    if(SpUtils.getParam(fragmentActivity, Url.SOAL_TOKEN,"1").equals("")){
                        fragmentActivity.startActivity(new Intent(fragmentActivity,LoginActivity.class));
                    }
                }
                Fragment ft = listFrag.get(j);
                FragmentTransaction fn = obtainFragmentTransaction(j);
                getCurrentFragment().onPause();

                if(ft.isAdded()){
                    ft.onResume();
                }else{
                    fn.add(fragmentContentId,ft);
                }

                showTab(j);
                fn.commit();

                // 如果设置了切换tab额外功能功能接口
                if(null != onRgsExtraCheckedChangedListener){
                    onRgsExtraCheckedChangedListener.OnRgsExtraCheckedChanged(radioGroup, i, j);
                }
            }
        }
    }

    public Fragment getCurrentFragment(){
        return listFrag.get(currentTab);
    }

    /**
     *  切换tab额外功能功能接口
     */
    public static class OnRgsExtraCheckedChangedListener{
        public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index){

        }
    }

    public OnRgsExtraCheckedChangedListener getOnRgsExtraCheckedChangedListener() {
        return onRgsExtraCheckedChangedListener;
    }

    public void setOnRgsExtraCheckedChangedListener(OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener) {
        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener;
    }
}
