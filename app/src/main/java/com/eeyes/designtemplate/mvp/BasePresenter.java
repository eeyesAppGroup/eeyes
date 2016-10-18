package com.eeyes.designtemplate.mvp;

import com.eeyes.designtemplate.retrofit.ApiStores;
import com.eeyes.designtemplate.retrofit.AppClient;

/**
 * Created by Lei Guo on 2016/10/10.
 */

public abstract class BasePresenter<V> {
    public V mvpView;
    protected ApiStores apiStores;

    public void attachView(V mvpView){
        this.mvpView = mvpView;
        apiStores = AppClient.retrofit().create(ApiStores.class);
    }

    public void detachView(){
        this.mvpView = null;
    }


}
