package mvp.com.zhou.mvp.utils.callback;

/**
 * Created by Silas on 2016/10/7.
 */
public interface CallBackListener<T> {
    void onSuccess(T t);

    void onError(String error);
}
