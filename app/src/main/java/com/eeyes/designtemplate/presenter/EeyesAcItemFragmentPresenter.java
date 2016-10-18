package com.eeyes.designtemplate.presenter;

import com.eeyes.designtemplate.bean.AcItem;
import com.eeyes.designtemplate.mvp.BasePresenter;
import com.eeyes.designtemplate.mvp.MainView;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lei Guo on 2016/10/10.
 */

public class EeyesAcItemFragmentPresenter extends BasePresenter<MainView> {

    public EeyesAcItemFragmentPresenter(MainView view){
        attachView(view);
    }

    public void loadData(int limit, String newsType, int page){
        mvpView.showLoading();
        Observable<List<AcItem>> mAcItemObservable;
        if (newsType.equals("1"))
            mAcItemObservable = apiStores.getLatestAllAcItemsByPage(limit, page);
        else
            mAcItemObservable = apiStores.getLatestAcItemsByTypeAndPage(limit, newsType, page);
        mAcItemObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<AcItem>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<AcItem> acItems) {
                        mvpView.getDataSuccess(acItems);

                    }
                });
    }

}
