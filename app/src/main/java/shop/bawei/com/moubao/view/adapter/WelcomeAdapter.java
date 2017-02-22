package shop.bawei.com.moubao.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.view.activity.MainActivity;

/**
 * Created by 刘伊帆 on 2016/12/28.
 * 引导页adapter
 */

public class WelcomeAdapter extends PagerAdapter {
    private List<Integer> list;
    private Activity context;

    public WelcomeAdapter(List<Integer> list,Activity context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_page_item,null);
        ImageView imageView = (ImageView) v.findViewById(R.id.welcome_img);
        imageView.setBackgroundResource(list.get(position));
        if(position == 2){
            Button btn = (Button) v.findViewById(R.id.welcome_btn);
            btn.setVisibility(View.VISIBLE);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, MainActivity.class));
                    context.finish();
                }
            });
        }
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
