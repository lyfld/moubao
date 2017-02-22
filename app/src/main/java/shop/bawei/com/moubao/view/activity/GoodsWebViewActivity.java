package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.system.Url;

/**
 * Created by 刘伊帆 on 2017/1/6.
 */

public class GoodsWebViewActivity extends BaseActivity implements View.OnClickListener{

    private WebView goodWv;
    private Button returnBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_webview_activity);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        goodWv = (WebView) findViewById(R.id.goods_webview_desc);
        returnBtn = (Button) findViewById(R.id.details_good_webview_btn_back);
        returnBtn.setOnClickListener(this);
        TextView titleTv = (TextView) findViewById(R.id.details_webview_good_title);
        titleTv.setTextColor(Color.WHITE);
    }

    @Override
    public void initDatas() {
        Intent intent = getIntent();
        String goods_id = intent.getStringExtra(Url.INTENT_GOODS_ID_DETAILS_DESC);
        goodWv.setWebViewClient(new WebViewClient());
        goodWv.getSettings().setJavaScriptEnabled(true);
        //设置加载进来的页面自适应手机屏幕
        goodWv.getSettings().setUseWideViewPort(true);
        goodWv.getSettings().setLoadWithOverviewMode(true);
        goodWv.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        goodWv.loadUrl(Url.LINK_MOBILE_GOODS_BODY+"&goods_id="+goods_id);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.details_good_webview_btn_back:
                finish();
                break;
            default:
                break;
        }
    }
}
