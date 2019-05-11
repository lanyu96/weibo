package mvp.com.zhou.mvp.ui.view;

import android.content.Intent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.ui.presenter.indexPresenterImpl;
import mvp.com.zhou.mvp.ui.view.base.BaseActivity;

public class indexViewActivity extends BaseActivity<indexPresenterImpl> implements indexView {
    private WebView webView;

    @Override
    public indexPresenterImpl initPresent() {
        return new indexPresenterImpl();
    }

    @Override
    public void initView() {
        setContentView(R.layout.act_index_web);
        Intent intent = getIntent();
        String strUrl = intent.getStringExtra("index");
        webView = findViewById(R.id.act_webview_wv);
        webView.loadUrl(strUrl);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        setWebInit();
    }

    @Override
    public String setTitleText() {
        return "微博主页";
    }

    public void setWebInit() {
        /* 设置支持Js,必须设置的,不然网页基本上不能看 */
        webView.getSettings().setJavaScriptEnabled(true);
        /* 设置缓存模式,我这里使用的默认,不做多讲解 */
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        /* 设置为true表示支持使用js打开新的窗口 */
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        /* 大部分网页需要自己保存一些数据,这个时候就的设置下面这个属性 */
        webView.getSettings().setDomStorageEnabled(true);
        /* 设置为使用webview推荐的窗口 */
        webView.getSettings().setUseWideViewPort(true);
        /* 设置网页自适应屏幕大小 ---这个属性应该是跟上面一个属性一起用 */
        webView.getSettings().setLoadWithOverviewMode(true);
        /* HTML5的地理位置服务,设置为true,启用地理定位 */
        webView.getSettings().setGeolocationEnabled(true);
        /* 设置是否允许webview使用缩放的功能,我这里设为false,不允许 */
        webView.getSettings().setBuiltInZoomControls(false);
        /* 提高网页渲染的优先级 */
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        /* 设置显示水平滚动条,就是网页右边的滚动条.我这里设置的不显示 */
        webView.setHorizontalScrollBarEnabled(false);
        /* 指定垂直滚动条是否有叠加样式 */
        webView.setVerticalScrollbarOverlay(true);
        /* 设置滚动条的样式 */
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        /* 这个不用说了,重写WebChromeClient监听网页加载的进度,从而实现进度条 */
        webView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onMyClick(View v) {

    }
}
