package com.eeyes.designtemplate.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.eeyes.designtemplate.R;
import com.eeyes.designtemplate.adapter.EeyesAcFragmentAdapter;
import com.eeyes.designtemplate.bean.AcItem;
import com.eeyes.designtemplate.mvp.BasePresenter;
import com.eeyes.designtemplate.mvp.MainView;
import com.eeyes.designtemplate.mvp.MvpFragment;
import com.eeyes.designtemplate.presenter.EeyesAcItemFragmentPresenter;
import com.eeyes.designtemplate.retrofit.ApiStores;
import com.eeyes.designtemplate.retrofit.AppClient;
import com.eeyes.designtemplate.util.NetworkState;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by guolei on 2016/7/24.
 */
public class EeyesAcFragment extends Fragment{


    //新闻类型
    private static final String ARG_NEWS_TYPE = "newsType";

    private int mNewsType = 0;

    private static final int ITEMS_PERPAGE = 10;

    private RecyclerView rvLatestNews;
    private SwipeRefreshLayout refresh;
    private FloatingActionButton fab;
    private List<AcItem> list = new ArrayList<>();

    private EeyesAcFragmentAdapter adapter;
    private LinearLayoutManager linearLayoutManager;


    private final String TAG = "EeyesAcFragment";

    //用于统一访问网络
    private ApiStores apiStores;

    private int currentPage = 1;


    public EeyesAcFragment(){

    }

    //通过新闻类型来初始化fragment
    public static EeyesAcFragment newInstance(int newsType){
        EeyesAcFragment fragment = new EeyesAcFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NEWS_TYPE, newsType);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(getActivity());

        Retrofit retrofit = AppClient.retrofit();
        apiStores = retrofit.create(ApiStores.class);

        mNewsType = getArguments().getInt(ARG_NEWS_TYPE);


    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inner_fragment, container, false);

        initViews(view);

        if (!NetworkState.networkConnected(getActivity())){
            showNoNetwork();
        }else {
            loadData(ITEMS_PERPAGE, mNewsType+"", currentPage);
        }

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                currentPage = 1;
                if (!list.isEmpty()){
                    list.clear();
                }
                if (!NetworkState.networkConnected(getActivity())){
                    showNoNetwork();
                }else {
                    loadData(ITEMS_PERPAGE, mNewsType+"", currentPage);

                }


            }
        });

        rvLatestNews.setOnScrollListener(new RecyclerView.OnScrollListener() {

            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // 获取最后一个完全显示的itemposition
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部并且是向下滑动
                    if (lastVisibleItem == (totalItemCount - 1) && isSlidingToLast) {
                        loadData(ITEMS_PERPAGE, mNewsType+"", ++currentPage);

                    }
                }

                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                isSlidingToLast = dy > 0;
            }
        });


        return view;
    }

    private void initViews(View view){
        rvLatestNews = (RecyclerView) view.findViewById(R.id.rv_main);
        rvLatestNews.setLayoutManager(linearLayoutManager);
        refresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        adapter = new EeyesAcFragmentAdapter(getActivity(), list);
        //设置下拉刷新的按钮的颜色
        refresh.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);

        refresh.setDistanceToTriggerSync(300);
        refresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
        refresh.setSize(SwipeRefreshLayout.DEFAULT);
        rvLatestNews.setAdapter(adapter);
    }

    private void showNoNetwork(){
        Snackbar.make(fab,R.string.no_network_connected,Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.go_to_set, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Settings.ACTION_SETTINGS));
                    }
                }).show();
    }

    private void loadData(int limit, String typeid, int page){
        Observable<List<AcItem>> mAcItemObservable;
        if (typeid.equals("1"))
            mAcItemObservable = apiStores.getLatestAllAcItemsByPage(ITEMS_PERPAGE, page);
        else
            mAcItemObservable = apiStores.getLatestAcItemsByTypeAndPage(ITEMS_PERPAGE, mNewsType+"", page);

        mAcItemObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<AcItem>>() {
                    @Override
                    public void onCompleted() {
                        refresh.post(new Runnable() {
                            @Override
                            public void run() {
                                refresh.setRefreshing(false);
                            }
                        });

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<AcItem> acItems) {
                        for (int i = 0; i < acItems.size(); i++){
                            list.add(acItems.get(i));
                        }

                        adapter.notifyDataSetChanged();

                    }
                });

    }

}
