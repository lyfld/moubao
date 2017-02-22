package shop.bawei.com.moubao.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import shop.bawei.com.moubao.R;

/**
 * Created by 刘伊帆 on 2017/1/5.
 */

public class DetailsViewPageAdapter extends PagerAdapter {
    private Context context;
    private String[] imgs;

    public DetailsViewPageAdapter(Context context,String[] imgs) {
        this.imgs = imgs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.details_viewpage_item,null);
        SimpleDraweeView sdv = (SimpleDraweeView) view.findViewById(R.id.details_viewpage_ietm_sdview);
        sdv.setImageURI(imgs[position]);
        container.addView(view);
         return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
