package mvp.com.zhou.mvp.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.webkit.WebView;

public class MyWebView extends WebView{
    public interface DisplayFinish{
        void finish();
    }
    DisplayFinish df;
    public void setDf(DisplayFinish df) {
        this.df = df;
    }
    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyWebView(Context context) {
        super(context);
    }
    //onDraw表示显示完毕
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        df.finish();
    }
}