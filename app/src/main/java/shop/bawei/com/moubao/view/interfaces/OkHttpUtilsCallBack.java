package shop.bawei.com.moubao.view.interfaces;

/**
 * Created by 刘伊帆 on 2016/12/29.
 */

public interface OkHttpUtilsCallBack<T> {
    public void success(T t);
    public void failed();
}
