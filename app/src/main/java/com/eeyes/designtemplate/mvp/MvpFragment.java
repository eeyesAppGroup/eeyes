package com.eeyes.designtemplate.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Lei Guo on 2016/10/10.
 */

public abstract class MvpFragment<P extends BasePresenter> extends Fragment{
    protected P mvpPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpPresenter = createPresenter();
    }

    protected abstract P createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null)
            mvpPresenter.detachView();
    }
}
