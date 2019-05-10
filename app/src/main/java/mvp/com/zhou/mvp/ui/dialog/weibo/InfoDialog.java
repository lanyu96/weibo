package mvp.com.zhou.mvp.ui.dialog.weibo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;
import mvp.com.zhou.mvp.ui.dialog.SureDialog;

public class InfoDialog {
    private Dialog dialog;
    private Context context;
    private JVBean jvBean;
    private InfoDialog.OnClickListener listener;
    private WebView webView;


    public Dialog setListener(OnClickListener listener) {
        this.listener = listener;
        return dialog;
    }

    public InfoDialog showInfoDialog(Context content, JVBean jvBean) {
        this.jvBean = jvBean;
        this.context = content;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = getInfoView();
        builder.setView(view);

        webView.loadUrl(jvBean.getIndexSrc());
        dialog = builder.create();

        return this;
    }

    private View getInfoView() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_info_dialog
                , null);
        webView = view.findViewById(R.id.act_webview_wv);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        setWebInit();


        return view;
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
    
    public interface OnClickListener {

        void OnFinishClickListener();

    }

}
