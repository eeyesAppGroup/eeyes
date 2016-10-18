package com.eeyes.designtemplate.mvp;

/**
 * Created by Lei Guo on 2016/10/10.
 */

public interface MainView {

    <D> void getDataSuccess(D data);

    void getDataFail(String msg);

    void showLoading();

    void hideLoading();
}
