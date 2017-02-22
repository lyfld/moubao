package shop.bawei.com.moubao.view.interfaces;

import android.view.View;

/**
 * Created by 刘伊帆 on 2016/12/30.
 */

public interface RecyclerViewOnItemClickLitener {
    void onItemClick(View view, int position);
    void onItemLongClick(View view , int position);
}
