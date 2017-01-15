//package com.example.myapplication;
//
//import android.app.Activity;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager.OnPageChangeListener;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnTouchListener;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.view.animation.DecelerateInterpolator;
//import android.widget.AbsListView;
//import android.widget.BaseAdapter;
//import android.widget.HorizontalScrollView;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.google.gson.Gson;
//import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
//import com.ximalaya.ting.android.MainApplication;
//import com.ximalaya.ting.android.R;
//import com.ximalaya.ting.android.activity.MainActivity;
//import com.ximalaya.ting.android.adapter.find.CalabashLineAdapter;
//import com.ximalaya.ting.android.adapter.find.FocusImageAdapter;
//import com.ximalaya.ting.android.constants.AppConfigfConstants;
//import com.ximalaya.ting.android.constants.AppConstants;
//import com.ximalaya.ting.android.constants.HttpParamsConstants;
//import com.ximalaya.ting.android.constants.UrlConstants;
//import com.ximalaya.ting.android.data.model.ad.ThirdAd;
//import com.ximalaya.ting.android.data.model.album.AlbumM;
//import com.ximalaya.ting.android.data.model.album.AlbumMList;
//import com.ximalaya.ting.android.data.model.city.CityColumn;
//import com.ximalaya.ting.android.data.model.rank.BannerM;
//import com.ximalaya.ting.android.data.model.recommend.EditorRecommendAlbumList;
//import com.ximalaya.ting.android.data.model.recommend.HotRecommendM;
//import com.ximalaya.ting.android.data.model.recommend.RecommendDiscoveryList;
//import com.ximalaya.ting.android.data.model.recommend.RecommendDiscoveryM;
//import com.ximalaya.ting.android.data.model.recommend.RecommendGridItemM;
//import com.ximalaya.ting.android.data.model.recommend.RecommendM;
//import com.ximalaya.ting.android.data.model.recommend.SpecialColumnM;
//import com.ximalaya.ting.android.data.model.recommend.SpecialColumnMList;
//import com.ximalaya.ting.android.data.model.scenelive.RecommendSceneLiveList;
//import com.ximalaya.ting.android.data.model.scenelive.SceneLiveBannerM;
//import com.ximalaya.ting.android.data.model.scenelive.SceneLiveM;
//import com.ximalaya.ting.android.data.model.user.LoginInfoModel;
//import com.ximalaya.ting.android.data.model.xdcs.UserTrackCookie;
//import com.ximalaya.ting.android.data.model.xdcs.UserTracking;
//import com.ximalaya.ting.android.data.request.CommonRequestM;
//import com.ximalaya.ting.android.data.request.IDataCallBackM;
//import com.ximalaya.ting.android.fragment.BaseFragment2;
//import com.ximalaya.ting.android.fragment.find.FindingFragment;
//import com.ximalaya.ting.android.fragment.find.other.category.CategoryContentFragment;
//import com.ximalaya.ting.android.fragment.find.other.rank.RankContentListFragment;
//import com.ximalaya.ting.android.fragment.find.other.recommend.SceneLivesListFragment;
//import com.ximalaya.ting.android.fragment.find.other.recommend.SubjectFragment;
//import com.ximalaya.ting.android.fragment.find.other.recommend.SubjectListFragment;
//import com.ximalaya.ting.android.fragment.other.AdFragment;
//import com.ximalaya.ting.android.fragment.other.album.AlbumFragmentNew;
//import com.ximalaya.ting.android.fragment.other.album.AlbumListFragment;
//import com.ximalaya.ting.android.fragment.other.vip.MemberListFragment;
//import com.ximalaya.ting.android.framework.BaseApplication;
//import com.ximalaya.ting.android.framework.commoninterface.IHandleOk;
//import com.ximalaya.ting.android.framework.manager.ImageManager;
//import com.ximalaya.ting.android.framework.manager.XDCSCollectUtil;
//import com.ximalaya.ting.android.framework.util.BaseUtil;
//import com.ximalaya.ting.android.framework.util.FileUtil;
//import com.ximalaya.ting.android.framework.util.OneClickHelper;
//import com.ximalaya.ting.android.framework.util.ViewUtil;
//import com.ximalaya.ting.android.framework.view.FixedSpeedScroller;
//import com.ximalaya.ting.android.framework.view.ViewPagerInScroll;
//import com.ximalaya.ting.android.framework.view.pageindicator.CirclePageIndicator;
//import com.ximalaya.ting.android.framework.view.refreshload.IRefreshLoadMoreListener;
//import com.ximalaya.ting.android.framework.view.refreshload.RefreshLoadMoreListView;
//import com.ximalaya.ting.android.listener.IFragmentFinish;
//import com.ximalaya.ting.android.listener.ILoginStatusChangeListener;
//import com.ximalaya.ting.android.manager.account.UserInfoMannage;
//import com.ximalaya.ting.android.manager.ads.AdManager;
//import com.ximalaya.ting.android.manager.track.AlbumEventManage;
//import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
//import com.ximalaya.ting.android.opensdk.util.Logger;
//import com.ximalaya.ting.android.opensdk.util.MyAsyncTask;
//import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;
//import com.ximalaya.ting.android.player.MD5;
//import com.ximalaya.ting.android.util.ToolUtil;
//import com.ximalaya.ting.android.util.device.DeviceUtil;
//import com.ximalaya.ting.android.util.net.NetworkUtils;
//import com.ximalaya.ting.android.util.track.PlayTools;
//import com.ximalaya.ting.android.util.ui.LocalImageUtil;
//import com.ximalaya.ting.android.util.ui.StringUtil;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import cn.feng.skin.manager.entity.DynamicAttr;
//import cn.feng.skin.manager.listener.IDynamicNewView;
//import cn.feng.skin.manager.listener.ISkinUpdate;
//import cn.feng.skin.manager.loader.SkinManager;
//import okhttp3.Headers;
//
///**
// * 发现板块-推荐页
// * 这个页面被撕成三个接口，所以不管是从缓存还是从服务端取数据，都要按照规定的顺序，猜你喜欢接口——普通推荐接口——现场直播接口
// *
// * @author hovi.yan
// */
//
//public class RecommendFragment extends BaseFragment2 implements OnClickListener, AdFragment.AdAction, IDynamicNewView, ISkinUpdate {
//    private static final long SWAP_AD_INTERNAL = 5000;
//    public static final String H5 = "html5";
//    private static final String DISCOVERY_H5_PREFIX = "html5.";
//    private static final String MORE_GUESSLIKE = "more_guesslike";
//    private static final String MORE_RECOMMEND = "recommend";
//    private static final String MORE_SPECIAL = "special";
//    private static final String MORE_MEMBER = "member";
//    private static final String MORE_CITY = "city";
//    private static final String TYPE_TRACK_STR = "track";
//    private static final String TYPE_ALBUM_STR = "album";
//    private static final String TYPE_ANCHOR_STR = "anchor";
//    private static final String TYPE_ACTIVITY = "activity";
//    public static final String TYPE_XZONE = "xzone";
//    private static final String TAG = "RecommendFragment";
//
//    private RefreshLoadMoreListView mListView;
//    private LinearLayout mHeaderView;
//    private LinearLayout mFooterView;
//    private LinearLayout mSpecialContainer;
//    private View mFocusImageRoot;
//    private View mGuessLikeLayout;
//    private View mPaidAreaLayout;
//    private View mPaidMemberLayout;
//    private View mRecommendLayout;
//    private View mSpecialLayout;
//    private View mDiscoveryLayout;
//    private View mMoreCategoryLayout;
//    private View mLiveEntryLayout;
//    private TextView mGuessLikeTitle;
//    private TextView mPaidAreaTitle;
//    private TextView mRecommendTitle;
//    private TextView mSpecialTitle;
//    private View mRecommendMoreBtn;
//    private TextView mLiveEntryTxt;
//    private ImageView mLiveEntryImg;
//    private View mBottomAdContainer;
//
//    private ViewPagerInScroll mFocusPager;// 轮播图控件
//    private CirclePageIndicator mFocusIndicator;// 轮播图可动圆点
//    private ImageView mFocusLoading;
//    private final List<BannerM> mFocusImages = new ArrayList<BannerM>();// 轮播图片的信息
//    private int mFocusIndex = 0;
//    private boolean mIsLoadedData = false;
//    private boolean mIsLoadedGuessLike = false;
//    private boolean isFakeData = false;
//    private final List<Object> mRecommendsData = new ArrayList<>();
//    private List<ThirdAd> mFeedAds = new ArrayList<ThirdAd>();
//    private AlbumMList mGuessLikeData;
//    private RecommendM mHotGuessData;
//    private RecommendM mRecomendData;
//    private String cityTitle;
//
//    private RecommendSectionAdapter mAdapter;
//    private PagerAdapter mFocusAdapter;
//    private boolean isFocusTouch = false;
//
//    private ILoginStatusChangeListener mLoginListener;
//    private View mCityLayout;
//    private TextView mCityTitle;
//    private View mCityMoreBtn;
//
//    public boolean statAdData = true;
//    //现场直播
//    private ViewPagerInScroll mLivePager;
//    private CirclePageIndicator mLiveIndicator;
//    private FocusImageAdapter mLiveImageAdapter;
//    private final ArrayList<BannerM> mLiveImages = new ArrayList<>();
//    private TextView mLiveEntryName;
//    private TextView mLiveEntryDescription;
//    private ImageView mLiveEntryStatusImg;
//    private TextView mLiveEntryStatusTime;
//    private TextView mLiveEntryPlayCount;
//    private boolean isLivesDataLoading = false;
//    private boolean isLiveFocusTouch = false;
//    private int mLiveFocusIndex = 0;
//    private boolean isLiveFakeData = false;
//    private LinearLayout panelCalabash;
//    private int mVisibleItemCount;
//    private int mFirstVisibleItem;
//    private int scrollState = -1;//非listview情况下
//    private IDynamicNewView mIDynamicNewView;
//    private RecommendM mLastRecommendM;
//
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try{
//            mIDynamicNewView = (IDynamicNewView)context;
//        }catch(ClassCastException e){
//            mIDynamicNewView = null;
//        }
//    }
//
//    @Override
//    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
//        LayoutInflater result = getActivity().getLayoutInflater();
//        return result;
//    }
//
//    @Override
//    protected void initUi(Bundle savedInstanceState) {
//        isFirstLoad = true;
////        LayoutInflater inflater = LayoutInflater.from(mContext);
//        LayoutInflater inflater = getLayoutInflater(savedInstanceState);
//        initHeaderView(mContext);
//        initFocusImages(inflater);
//        initDiscoveryLayout();
//        initGuessLikeLayout(inflater);
//        initPaidAreaLayout(inflater);
//        initPaidMember(inflater);
//        initEditorRecommendLayout(inflater);
//        initSceneLiveEntry(inflater);
//        initCityColumn(inflater);
//        initSpecialLayout(inflater);
//        initMoreCategoryLayout(inflater);
//        // initLiveEntry(inflater);
//        initAds();
//        initFooterView(mContext);
//        initListView(mContext);
//
//        mAdapter = new RecommendSectionAdapter(getActivity(),
//                RecommendFragment.this, mRecommendsData);
//        mListView.setAdapter(mAdapter);
//        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                RecommendFragment.this.scrollState = scrollState;
//                if (scrollState == SCROLL_STATE_IDLE) {
//                    showImage(mFirstVisibleItem, mVisibleItemCount);
//                }
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                mFirstVisibleItem = firstVisibleItem;
//                mVisibleItemCount = visibleItemCount;
//            }
//        });
//        //Log.i("zaleTag","recod:onCreate");
//    }
//
//    @Override
//    protected void loadData() {
//        if (!canUpdateUi()) {
//            return;
//        }
//        onPageLoadingCompleted(LoadCompleteType.LOADING);
//        if (!mIsLoadedData) {
//            loadDataFromLocal();
//        }
//
//    }
//
//    @Override
//    public int getContainerLayoutId() {
//        return R.layout.fra_list_no_title_with_bg;
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (!OneClickHelper.getInstance().onClick(v)) {
//            return;
//        }
//        int id = v.getId();
//        switch (id) {
//            case R.id.more_category:
//                if (getParentFragment() instanceof FindingFragment) {
//                    ((FindingFragment) getParentFragment())
//                            .switchToCategoryFragment();
//                }
//                break;
//            case R.id.live_entry_layout:
//                if (getParentFragment() instanceof FindingFragment) {
//                    ((FindingFragment) getParentFragment()).switchToLiveFragment();
//                }
//                break;
//            case R.id.layout_section_header:
//                UserTracking userTracking = new UserTracking();
//                userTracking.setSrcPage("发现_推荐");
//                userTracking.setSrcTitle("更多");
//                if (v.getTag() != null && v.getTag() instanceof HotRecommendM) {
//                    HotRecommendM data = (HotRecommendM) v.getTag();
//                    userTracking.setSrcModule("分类听");
//                    userTracking.setItem("category");
//                    userTracking.setItemId(data.getCategoryId());
//                    userTracking.setSrcSubModule(data.getCategoryId() + "");
//                    userTracking.setSrcSubModuleTitle(data.getTitle() + "");
//                    CategoryContentFragment fra;
//                    fra = CategoryContentFragment
//                            .newInstance((int) data.getCategoryId(), data.getTitle(), data.getContentType(), null);
//                    startFragment(fra, v);
//                } else if (v.getTag() != null && v.getTag() instanceof AlbumMList) {
//                    AlbumMList data = (AlbumMList) v.getTag();
//                    boolean isPaied = data != null && data.getCategoryId() == 33;
//                    if (isPaied) {
//                        if (v.findViewById(R.id.iv_tags_new) != null) {
//                            v.findViewById(R.id.iv_tags_new).setVisibility(View.GONE);
//                        }
//                        SharedPreferencesUtil.getInstance(mContext).saveBoolean(AppConstants.ISFIRSTCLICKED, true);
//                    }
//                    userTracking.setSrcModule("付费精品");
//                    userTracking.setItem("category");
//                    userTracking.setItemId( data.getCategoryId());
//                    if (data != null)
//                        startFragment(CategoryContentFragment
//                            .newInstance(data.getCategoryId(), data.getTitle(), data.getContentType(),  null), v);
//                } else if (MORE_MEMBER.equals(v.getTag())) {
//                    if (v.findViewById(R.id.iv_tags_new) != null) {
//                        v.findViewById(R.id.iv_tags_new).setVisibility(View.GONE);
//                    }
//                    SharedPreferencesUtil.getInstance(mContext).saveBoolean(AppConstants.MEMBER_FIRST_CLICK, true);
//                    userTracking.setSrcModule("付费会员");
//                    userTracking.setItem("付费会员");
//                    startFragment(new MemberListFragment());
//                } else if (MORE_SPECIAL.equals(v.getTag())) {
//                    userTracking.setSrcModule("精品听单");
//                    userTracking.setItem("精品听单");
//                    startFragment(SubjectListFragment.newInstance(
//                            ConstantsOpenSdk.PLAY_FROM_LISTEN_LIST), v);
//                } else if (MORE_GUESSLIKE.equals(v.getTag())) {
//                    userTracking.setSrcModule("猜你喜欢");
//                    userTracking.setItem("猜你喜欢");
//                    startFragment(AlbumListFragment.newInstanceGuessLike(), v);
//                } else if (MORE_RECOMMEND.equals(v.getTag())) {
//                    userTracking.setSrcModule("小编推荐");
//                    userTracking.setItem("小编推荐");
//                    startFragment(AlbumListFragment.newInstanceEditorRecommend(),
//                            v);
//                } else if (MORE_CITY.equals(v.getTag())) {
//                    userTracking.setSrcModule("本地听");
//                    userTracking.setItem("localTing");
//                    userTracking.setItemId(SharedPreferencesUtil.getInstance(MainApplication.getTopActivity()).getString(AppConstants.LOCAL_CITY_CODE));
//                    userTracking.setSrcSubModule(SharedPreferencesUtil.getInstance(MainApplication.getTopActivity()).getString(AppConstants.LOCAL_CITY_CODE));
//                    userTracking.setSrcSubModuleTitle(cityTitle + "");
//                    CategoryContentFragment fragment = CategoryContentFragment.newInstanceForCity( cityTitle);
//                    fragment.setCallbackFinish(new IFragmentFinish() {
//                        @Override
//                        public void onFinishCallback(Class<?> cls, Object... params) {
//                            if (cls == CategoryContentFragment.class && params != null && params[0] instanceof Integer) {
//                                int flag = (int) params[0];
//                                if (flag == CategoryContentFragment.FLAG_CITY_DATA)
//                                    loadHotAndGuess();
//                            }
//                        }
//                    });
//                    startFragment(fragment, v);
//                }
//                userTracking.statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW);
//                break;
//            default:
//                break;
//        }
//    }
//
//    private boolean isFirstLoad;//判断是否第一次加载推荐页
//
//    @Override
//    public void onMyResume() {
//        super.onMyResume();
//        startAutoSwapFocusImage();
//        startAutoSwapSceneLiveImage();
////        initLoginStatusListener();
//        checkToRefreshData();
//        if (isVisible() && getUserVisibleHint() && getActivity() != null && getActivity() instanceof MainActivity && ((MainActivity) getActivity()).isFindingFragmentOrCustomFragmentOnResume() && !((MainActivity) getActivity()).playFragmentIsVis() && isResumingFragment()) {
//            UserTrackCookie.getInstance().clearXMLYResource();
//            boolean isChangeCity = SharedPreferencesUtil.getInstance(mContext).getBoolean("ChangeCity", false);
//            if (isChangeCity && getView() != null) {//切换城市后才刷新
//                getView().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        SharedPreferencesUtil.getInstance(mContext).saveBoolean("ChangeCity", false);
//                        loadHotAndGuess();
//                    }
//                }, 600);
//            } else {
//                AdManager.batchAdRecord(mContext, mFeedAds, AppConstants.AD_LOG_TYPE_SITE_SHOW, AppConstants.AD_POSITION_NAME_FIND_NATIVE);
//            }
//            AdManager.batchAdRecordByBannerM(mContext, mFocusImages, AppConstants.AD_LOG_TYPE_SITE_SHOW, AppConstants.AD_POSITION_NAME_CATEGORY_FOCUS);
//
//            if (mAdFragment != null && mAdFragment.isAdded()) {
//                mAdFragment.statAd();
//            }
//        }
//
//        SkinManager.getInstance().attach(this);
////        if(!isFirstLoad &&getView() != null){
////            getView().postDelayed(new Runnable() {
////                @Override
////                public void run() {
////                    loadHotAndGuess();
////                }
////            },800);
////        }
////
////        startAutoSwapFocusImage();
////        startAutoSwapSceneLiveImage();
////        initLoginStatusListener();
////        if( isResumingFragment()){
//////            showToastShort("推荐页onMyResumed");
////            if (mFocusImages != null && !mFocusImages.isEmpty()) {
////
////                ThirdAdStatUtil.getInstance(
////                        getActivity().getApplicationContext()).statFocusAd(
////                        mFocusImages, false);
////            }
////            if (mFeedAds != null && !mFeedAds.isEmpty() && getActivity() != null) {
////                ThirdAdStatUtil.getInstance(getActivity()).statFeedAd(
////                        AppConstants.AD_POSITION_NAME_FIND_NATIVE, mFeedAds);
////                showPing(mFeedAds);
////            }
////            if (mAdFragment != null && mAdFragment.isAdded()) {
////                mAdFragment.statAd();
////            }
////        }
//    }
//
//    private boolean isResumingFragment() {
//        return getParentFragment() != null && getParentFragment() instanceof FindingFragment &&
//                ((FindingFragment) getParentFragment()).isCurrTabClass(getClass());
//    }
//
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        //Log.i("zaleTag","recod:setUserVisibleHint:"+isVisibleToUser);
//        if (isVisibleToUser && isResumingFragment()) {
////            showToastShort("推荐页setUserVisibleHint");
//            UserTrackCookie.getInstance().clearXMLYResource();
//            if (mAdFragment != null && mAdFragment.isAdded()) {
//                mAdFragment.statAd();
//            }
//
//            AdManager.batchAdRecordByBannerM(mContext, mFocusImages, AppConstants.AD_LOG_TYPE_SITE_SHOW, AppConstants.AD_POSITION_NAME_FIND_FOCUS);
//
//            AdManager.batchAdRecord(mContext, mFeedAds, AppConstants.AD_LOG_TYPE_SITE_SHOW, AppConstants.AD_POSITION_NAME_FIND_NATIVE);
//
//        }
//    }
//
//    private boolean isLoadAd = false;
//
//    private void requestMadAd(final ThirdAd feed) {
//        AdManager.getWelcomeMadAd("5134A6A29800BB13", 710, 256, new IDataCallBackM<List<ThirdAd>>() {
//            @Override
//            public void onSuccess(List<ThirdAd> adList, Headers header) {
//                List<ThirdAd> feedAds = new ArrayList<ThirdAd>();
//                if (adList != null && adList.size() > 0) {
//                    for (ThirdAd thirdAd : adList) {
//                        ThirdAd feedAd = thirdAd;
//                        feedAd.setPosition(feed.getPosition());
//                        feedAd.setLinkXDCS(feed.getLink());
//                        feedAd.setShareFlag(feed.isShareFlag());
//                        feedAd.setShareData(feed.getShareData());
//                        feedAd.setLinkType(ThirdAd.LINK_TYPE_WEB);
//                        feedAds.add(feedAd);
//                    }
//                    if (mFeedAds != null && !mFeedAds.isEmpty()) {
//                        mFeedAds.addAll(feedAds);
//                    } else {
//                        mFeedAds = feedAds;
//                    }
//                }
//                insertOrReplaceAd(mRecommendsData, feedAds);
//                isLoadAd = false;
//            }
//
//            @Override
//            public void onError(int code, String message) {
//
//            }
//        });
//    }
//
//    private void loadRecommendAd() {
//        if (isLoadAd) {
//            return;
//        }
//        isLoadAd = true;
//        final Map<String, String> params = new HashMap<String, String>();
//        params.put("version", DeviceUtil.getVersion(mContext));
//        params.put("network", NetworkUtils.getNetworkClass(mContext));
//        params.put("operator", NetworkUtils.getOperator(mContext) + "");
//        params.put(HttpParamsConstants.PARAM_DEVICE, "android");
//        params.put("name", AppConstants.AD_POSITION_NAME_FIND_NATIVE);
//        CommonRequestM.getDataWithXDCS("feedAds", params, new IDataCallBackM<List<ThirdAd>>() {
//
//            @Override
//            public void onSuccess(List<ThirdAd> object, Headers header) {
//                List<ThirdAd> feedAds = new ArrayList<ThirdAd>();
//                List<ThirdAd> madAds = new ArrayList<ThirdAd>();
//                if (object != null && object.size() > 0) {
//                    for (ThirdAd feedAd : object) {
//                        if (feedAd.getAdtype() == 6)    //有adtype为6的情况下
//                        {
//                            madAds.add(feedAd);
//                        } else {
//                            feedAds.add(feedAd);
//                        }
//                    }
//                    if (feedAds.size() > 0)      //如果不是madhouse
//                    {
//                        if (mFeedAds != null && !mFeedAds.isEmpty()) {
//                            mFeedAds.clear();
//                            mFeedAds.addAll(feedAds);
//                        } else {
//                            mFeedAds = feedAds;
//                        }
//                        insertOrReplaceAd(mRecommendsData, feedAds);
//                        isLoadAd = false;
//                    } else {
//                        if (mFeedAds != null && !mFeedAds.isEmpty()) mFeedAds.clear();
//                    }
//                    if (madAds.size() > 0)       //如果是madhouse广告
//                    {
//                        for (ThirdAd feedAd : madAds)
//                            requestMadAd(feedAd);
//                    }
//                }
//
//            }
//
//            @Override
//            public void onError(int code, String message) {
//                isLoadAd = false;
//            }
//        }, getContainerView(), new View[]{}, new Object[]{});
//    }
//
//
//    private void initLoginStatusListener() {
//        if (mLoginListener == null) {
//            mLoginListener = new ILoginStatusChangeListener() {
//
//                @Override
//                public void onUserChange(LoginInfoModel oldModel, LoginInfoModel newModel) {
////                    loadGuessLike(true);
//                    loadHotAndGuess();
//                }
//
//                @Override
//                public void onLogout(LoginInfoModel olderUser) {
////                    loadGuessLike(true);
//                    loadHotAndGuess();
//                }
//
//                @Override
//                public void onLogin(LoginInfoModel model) {
////                    loadGuessLike(true);
//                    loadHotAndGuess();
//                }
//            };
//            UserInfoMannage.getInstance().addLoginStatusChangeListener(mLoginListener);
//        }
//    }
//    private boolean loadDataWhileResume = UserInfoMannage.hasLogined();
//    private void checkToRefreshData(){
//        if (loadDataWhileResume == !UserInfoMannage.hasLogined()) {
//            loadDataWhileResume = UserInfoMannage.hasLogined();
//            if(getView() != null){
//                getView().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        loadHotAndGuess();
//                    }
//                },400);
//            }
//
//        }
//    }
//    @Override
//    public void onPause() {
//        stopAutoSwapFocusImage();
//        stopAutoSwapSceneLiveImage();
//        super.onPause();
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        mIsLoadedData = false;
//        if (mFocusAdapter != null) ((FocusImageAdapter) mFocusAdapter).destory();
//        if (mLiveImageAdapter != null) mLiveImageAdapter.destory();
////        if (mLoginListener != null) {
////            UserInfoMannage.getInstance().removeLoginStatusChangeListener(mLoginListener);
////            mLoginListener = null;
////        }
//        if (mListView != null) {
//            mListView.setOnRefreshListener((OnRefreshListener<ListView>) null);
//            mListView.setOnRefreshLoadMoreListener(null);
//            mListView.setAdapter(null);
//            mListView.getRefreshableView().removeHeaderView(mHeaderView);
//            mListView.getRefreshableView().removeFooterView(mFooterView);
//            // mListView.getRefreshableView().setOnScrollChangeListener(null);
//            mListView.getRefreshableView().setOnScrollListener(null);
//            mListView.setOnScrollListener(null);
//            mListView.removeAllViews();
//        }
//        if (mAdFragment != null) {
//            mAdFragment.setAction(null);
//        }
//
//        SkinManager.getInstance().detach(this);
//    }
//
//    /**
//     * 初始化第三方广告页面
//     */
//    private void initAds() {
//
//        if (AppConstants.sEnableAppAds) {// 添加底部广告栏
//            mBottomAdContainer = LayoutInflater.from(mContext).inflate(R.layout.view_ad_container, null);
//            mBottomAdContainer.setVisibility(View.GONE);
//            if (mAdFragment == null && getChildFragmentManager() != null) {
//                mAdFragment = (AdFragment) getChildFragmentManager().findFragmentByTag(AppConstants.AD_POSITION_NAME_FIND_BANNER);
//                if (mAdFragment != null) {
//                    mAdFragment.setAutoStatAd(isResumingFragment());
//                }
//            }
//            if (mAdFragment == null) {
//                mAdFragment = AdFragment.newInstance(AdFragment.TYPE_ADS, AppConstants.AD_POSITION_NAME_FIND_BANNER, R.id.layout_ad, null, isResumingFragment());
//            }
//            FragmentTransaction transaction = getChildFragmentManager()
//                    .beginTransaction();
//            mAdFragment.setAction(this);
//            transaction.replace(R.id.layout_ad, mAdFragment,
//                    AppConstants.AD_POSITION_NAME_FIND_BANNER);
//            transaction.commitAllowingStateLoss();
//        }
//    }
//
//    /**
//     * 初始化轮播图片界面
//     */
//    private void initFocusImages(LayoutInflater inflate) {
//        mFocusImageRoot = inflate.inflate(R.layout.layout_focus_image, null);
//        mHeaderView.addView(mFocusImageRoot);
//        mFocusImageRoot.setVisibility(View.GONE);
//        mFocusPager = (ViewPagerInScroll) mFocusImageRoot
//                .findViewById(R.id.pager);
//        mFocusPager.setDisallowInterceptTouchEventView(
//                (ViewGroup) mFocusPager.getParent(), true);
//        mFocusIndicator = (CirclePageIndicator) mFocusImageRoot
//                .findViewById(R.id.indicator_dot);
//        mFocusLoading = (ImageView) mFocusImageRoot
//                .findViewById(R.id.viewpager_bg);
//
//        ViewGroup.LayoutParams lp = mFocusImageRoot.getLayoutParams();
//        int width = BaseUtil.getScreenWidth(mContext);
//        int height = (int) (width * (300 / 640f));
//        lp.width = width;
//        lp.height = height;
//        mFocusImageRoot.setLayoutParams(lp);
//
//        // 设置加速度
//        // ，通过改变FixedSpeedScroller这个类中的mDuration
//        // 来改变动画时间（如mScroller.setmDuration(mMyDuration);）
//        FixedSpeedScroller mScroller = new FixedSpeedScroller(
//                mFocusPager.getContext(), new DecelerateInterpolator());
//        ViewUtil.setViewPagerScroller(mFocusPager, mScroller);
//
//        mFocusAdapter = new FocusImageAdapter(this, mFocusImages,
//                FocusImageAdapter.TYPE_DISCOVER, false);
//        ((FocusImageAdapter) mFocusAdapter).setCycleScrollFlag(true);
//        mFocusPager.setAdapter(mFocusAdapter);
//        mFocusIndicator.setViewPager(mFocusPager);
//        mFocusIndicator.setOnPageChangeListener(new OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int arg0) {
//                mFocusIndex = arg0;
////                if (mFocusImages != null) {
////                    int postion = arg0 % mFocusImages.size();
////                    if (mFocusImages.size() > postion) {
////                        if (isResumingFragment() && getActivity() instanceof MainActivity && ((MainActivity) getActivity()).getCurrentFragmentInManage() == null) {
////                            BannerM bannerM = mFocusImages.get(postion);
////                            new UserTracking().setSrcPage("发现_推荐").setSrcModule("焦点图").setSrcTitle(bannerM.getBannerTitle()).setSrcPosition(postion + 1).setItem("focusId").setItemId(bannerM.getBannerId()).
////                                    statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_IMPRESS);
////                        }
////                    }
////                }
//                if (mFocusImages != null && mFocusImageRoot != null) {
//                    int postion = arg0 % mFocusImages.size();
//                    if (mFocusImages.size() > postion) {
//                        BannerM bannerM = mFocusImages.get(postion);
//
//                        View adTag = mFocusImageRoot.findViewById(R.id.ad_tag_img);
//                        if (adTag != null) {
//                            adTag.setVisibility(bannerM.getBannerContentType() == BannerM.TYPE_AD ? View.VISIBLE : View.GONE);
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onPageScrolled(int arg0, float arg1, int arg2) {
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int arg0) {
//            }
//        });
//
//        BannerM banner = new BannerM();
//        mFocusImages.add(banner);
//        updateFocusImageBar();
//        mFocusLoading.setImageResource(R.drawable.focus_img_nonet);
//        mFocusLoading.setVisibility(View.VISIBLE);
//        mFocusPager.setOnTouchListener(new OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_MOVE:
//                        isFocusTouch = true;
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        isFocusTouch = false;
//                        break;
//                    default:
//                        break;
//                }
//                return false;
//            }
//        });
//    }
//
//    /**
//     * 初始化猜你喜欢布局
//     *
//     * @param
//     */
//    private void initGuessLikeLayout(LayoutInflater inflate) {
//        mGuessLikeLayout = inflate.inflate(
//                R.layout.item_recommend_selection_horizontal, null);
//        if (mIsLoadedData && mHotGuessData != null && needShowGuessLike(mGuessLikeData)) {
//            mGuessLikeLayout.setVisibility(View.VISIBLE);
//        } else {
//            mGuessLikeLayout.setVisibility(View.GONE);
//        }
//        mGuessLikeTitle = (TextView) mGuessLikeLayout
//                .findViewById(R.id.tv_title);
//        View mGuessLikeMoreBtn = mGuessLikeLayout
//                .findViewById(R.id.layout_section_header);
//        mGuessLikeLayout
//                .findViewById(R.id.tv_more).setClickable(false);
//        mGuessLikeMoreBtn.setOnClickListener(this);
//        mGuessLikeMoreBtn.setTag(MORE_GUESSLIKE);
//        mHeaderView.addView(mGuessLikeLayout);
//
//    }
//
//    /**
//     * 初始化猜你喜欢布局
//     *
//     * @param
//     */
//    private void initPaidAreaLayout(LayoutInflater inflate) {
//        mPaidAreaLayout = inflate.inflate(
//                R.layout.item_recommend_selection_horizontal, null);
//        mPaidAreaLayout.setVisibility(View.GONE);
//        mPaidAreaTitle = (TextView) mPaidAreaLayout
//                .findViewById(R.id.tv_title);
//        View mGuessLikeMoreBtn = mPaidAreaLayout
//                .findViewById(R.id.layout_section_header);
//        mPaidAreaLayout
//                .findViewById(R.id.tv_more).setClickable(false);
//        mGuessLikeMoreBtn.setOnClickListener(this);
//        mHeaderView.addView(mPaidAreaLayout);
//    }
//
//    /**
//     * 初始化会员布局
//     *
//     * @param inflater
//     */
//    private void initPaidMember(LayoutInflater inflater) {
//        mPaidMemberLayout = inflater.inflate(R.layout.item_recommend_selection_horizontal, null);
//        mHeaderView.addView(mPaidMemberLayout);
//        mPaidMemberLayout.setVisibility(View.GONE);
//
//    }
//
//    /**
//     * 初始化小编推荐布局
//     *
//     * @param
//     */
//    private void initEditorRecommendLayout(LayoutInflater inflate) {
//        mRecommendLayout = inflate.inflate(
//                R.layout.item_recommend_selection_horizontal, null);
//        if (mIsLoadedData && mRecomendData != null
//                && needShowEditorRecommend(mRecomendData.getEditorRecommendAlbums())) {
//            mRecommendLayout.setVisibility(View.VISIBLE);
//        } else {
//            mRecommendLayout.setVisibility(View.GONE);
//        }
//        mRecommendTitle = (TextView) mRecommendLayout
//                .findViewById(R.id.tv_title);
//        mRecommendMoreBtn = mRecommendLayout
//                .findViewById(R.id.layout_section_header);
//        mRecommendLayout
//                .findViewById(R.id.tv_more).setClickable(false);
//        mRecommendMoreBtn.setTag(MORE_RECOMMEND);
//        mRecommendMoreBtn.setOnClickListener(this);
//        mHeaderView.addView(mRecommendLayout);
//    }
//
//    /**
//     * 初始化本地听布局
//     *
//     * @param
//     */
//    private void initCityColumn(LayoutInflater inflate) {
//        mCityLayout = inflate.inflate(
//                R.layout.item_recommend_selection_horizontal, null);
//        if (mIsLoadedData && mHotGuessData != null && mHotGuessData.getCityColumn().getAlbums() != null
//                && mHotGuessData.getCityColumn().getAlbums().size() >= 3) {
//            mCityLayout.setVisibility(View.VISIBLE);
//        } else {
//            mCityLayout.setVisibility(View.GONE);
//        }
//        mCityTitle = (TextView) mCityLayout
//                .findViewById(R.id.tv_title);
//        mCityMoreBtn = mCityLayout
//                .findViewById(R.id.layout_section_header);
//        mCityLayout
//                .findViewById(R.id.tv_more).setClickable(false);
//        mCityMoreBtn.setTag(MORE_CITY);
//        mCityMoreBtn.setOnClickListener(this);
//        mHeaderView.addView(mCityLayout);
//    }
//
//    /**
//     * 初始化精品听单
//     *
//     * @param
//     */
//    private void initSpecialLayout(LayoutInflater inflate) {
//        mSpecialLayout = inflate.inflate(
//                R.layout.item_recommend_section_vertical, null);
//        mSpecialTitle = (TextView) mSpecialLayout.findViewById(R.id.tv_title);
//        mSpecialLayout.setVisibility(View.GONE);
//        mSpecialLayout.findViewById(R.id.layout_section_header).setTag(MORE_SPECIAL);
//        mSpecialLayout.findViewById(R.id.layout_section_header).setOnClickListener(this);
//        mSpecialContainer = (LinearLayout) mSpecialLayout
//                .findViewById(R.id.layout_container);
//        mSpecialLayout.findViewById(R.id.tv_more).setClickable(false);
//        mSpecialLayout.findViewById(R.id.border_bottom).setVisibility(View.VISIBLE);
//        mHeaderView.addView(mSpecialLayout);
//
//        // Add change skin support
////        ArrayList<DynamicAttr> attrs = new ArrayList<DynamicAttr>(1);
////        attrs.add(new DynamicAttr(AttrFactory.DRAWABLE_LEFT, R.drawable.ic_section_header));
////        dynamicAddView(mSpecialTitle, attrs);
//    }
//
//    private void parseSceneLiveFocusImage(List<SceneLiveBannerM> banners) {
//        if (banners == null || banners.isEmpty()) {
//            mLiveEntryLayout.setVisibility(View.GONE);
//            return;
//        }
//        mLiveImages.clear();
//        mLiveImages.addAll(banners);
//        if (banners.size() == 1) {
//            mLiveImageAdapter.setOnlyOnePageFlag(true);
//        }
//
//        // size 2||3 重复添加一遍，保证viewpager页数>=3
//        if (banners.size() == 2 || banners.size() == 3) {
//            isLiveFakeData = true;
//            mLiveImages.addAll(banners);
//        }
//        mLiveEntryLayout.setVisibility(View.VISIBLE);
//        updateSceneLiveViews((SceneLiveBannerM) mLiveImages.get(0));
//        updateSceneLiveFocusImageBar();
//    }
//
//    /**
//     * 更新轮播图控件
//     */
//    private void updateSceneLiveFocusImageBar() {
//
//        if (isLiveFakeData) {
//            mLiveIndicator.setPagerRealCount(mLiveImages.size() / 2);
//        } else {
//            mLiveIndicator.setPagerRealCount(mLiveImages.size());
//        }
//
//        if (mLiveFocusIndex == 0 && mLiveImages.size() > 1)
//            mLivePager.setCurrentItem(Integer.MAX_VALUE / 2
//                    - (Integer.MAX_VALUE / 2) % mLiveImages.size()); // 初始时ViewPager设置在中间位置
//        else
//            mLivePager.setCurrentItem(mLiveFocusIndex);
//        mLiveImageAdapter.notifyDataSetChanged();
//    }
//
//    private void updateSceneLiveViews(SceneLiveBannerM model) {
//        mLiveEntryName.setText(model.getBannerTitle());
//        mLiveEntryDescription.setText(model.getBannerShortTitle());
//        switch (model.getStatus()) {
//            case SceneLiveM.SCENE_LIVE_REST:
//            case SceneLiveM.SCENE_LIVE_NOTICE:
//                mLiveEntryStatusImg.setVisibility(View.GONE);
//                mLiveEntryStatusTime.setVisibility(View.VISIBLE);
//                mLiveEntryStatusTime.setText(StringUtil.getTimeWithFormatMMDD_HHMM(model.getStartTime(), true));
//                mLiveEntryPlayCount.setVisibility(View.GONE);
//                break;
//            case SceneLiveM.SCENE_LIVE_ING:
//                mLiveEntryStatusImg.setVisibility(View.VISIBLE);
//                mLiveEntryStatusTime.setVisibility(View.GONE);
//                mLiveEntryPlayCount.setVisibility(View.VISIBLE);
//                mLiveEntryPlayCount.setText(StringUtil.getFriendlyNumStr(model.getOnlineCount()) + "人在线");
//                mLiveEntryStatusImg.setBackgroundResource(R.drawable.icon_live_live);
//                break;
//            case SceneLiveM.SCENE_LIVE_END:
//                mLiveEntryPlayCount.setVisibility(View.VISIBLE);
//                mLiveEntryPlayCount.setText(StringUtil.getFriendlyNumStr(model.getPlayCount()) + "人次参与");
//                mLiveEntryStatusImg.setVisibility(View.VISIBLE);
//                mLiveEntryStatusImg.setBackgroundResource(R.drawable.icon_live_playback);
//                mLiveEntryStatusTime.setVisibility(View.GONE);
//                break;
//        }
//    }
//
//    /**
//     * 发现新奇内容布局
//     *
//     * @param
//     */
//    private void initDiscoveryLayout() {
//
//        mDiscoveryLayout = LayoutInflater.from(getActivity())
//                .inflate(R.layout.view_recommend_discovery, mHeaderView,true);
////        mHeaderView.addView(mDiscoveryLayout);
//        if (mIsLoadedData && mHotGuessData != null
//                && mHotGuessData.getRecommendDiscoverys() != null
//                && mHotGuessData.getRecommendDiscoverys().getList() != null
//                && !mHotGuessData.getRecommendDiscoverys().getList().isEmpty()) {
//            mDiscoveryLayout.setVisibility(View.VISIBLE);
//        } else {
//            mDiscoveryLayout.setVisibility(View.GONE);
//        }
//
//        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) mDiscoveryLayout.findViewById(R.id.hsl_calabash);
//        panelCalabash = (LinearLayout) horizontalScrollView.findViewById(R.id.layout_calabash);
//    }
//
//    /**
//     * 初始化查看更多分类
//     *
//     * @param
//     */
//    private void initMoreCategoryLayout(LayoutInflater inflate) {
//        mMoreCategoryLayout = inflate.inflate(R.layout.category_more_layout,
//                null);
//        mMoreCategoryLayout.setOnClickListener(this);
//    }
//
//    /*
//     * 初始化现场直播界面
//     */
//    private void initSceneLiveEntry(LayoutInflater inflate) {
//        mLiveEntryLayout = inflate.inflate(
//                R.layout.recommend_live_entry_layout, null);
//        mLiveEntryLayout.setVisibility(View.GONE);
//        TextView mSceneLiveEntryText = (TextView) mLiveEntryLayout.findViewById(R.id.tv_title);
//        mSceneLiveEntryText.setText("现场直播");
//        mLiveEntryName = (TextView) mLiveEntryLayout.findViewById(R.id.live_entry_title);
//        mLiveEntryDescription = (TextView) mLiveEntryLayout.findViewById(R.id.live_entry_description);
//        mLiveEntryStatusImg = (ImageView) mLiveEntryLayout.findViewById(R.id.live_entry_status_img);
//        mLiveEntryStatusTime = (TextView) mLiveEntryLayout.findViewById(R.id.live_entry_status_time);
//        mLiveEntryPlayCount = (TextView) mLiveEntryLayout.findViewById(R.id.live_entry_playCount);
//        mHeaderView.addView(mLiveEntryLayout);
//        mLivePager = (ViewPagerInScroll) mLiveEntryLayout
//                .findViewById(R.id.live_pager);
//        mLivePager.setDisallowInterceptTouchEventView(
//                (ViewGroup) mLivePager.getParent(), true);
//        mLiveIndicator = (CirclePageIndicator) mLiveEntryLayout
//                .findViewById(R.id.live_indicator_dot);
//        ViewGroup.LayoutParams lp = mLivePager.getLayoutParams();
//        // int width = BaseUtil.getScreenWidth(mContext);
//        //  int height = (int) (width * (300 / 640f));
//        int width = BaseUtil.getScreenWidth(mContext)
//                - BaseUtil.dp2px(mContext, 20);
//        lp.height = width * 256 / 710;
//        lp.width = width;
//        // lp.height = height;
//        mLivePager.setLayoutParams(lp);
//        // 设置加速度
//        // ，通过改变FixedSpeedScroller这个类中的mDuration
//        // 来改变动画时间（如mScroller.setmDuration(mMyDuration);）
//        FixedSpeedScroller mScroller = new FixedSpeedScroller(
//                mLivePager.getContext(), new DecelerateInterpolator());
//        ViewUtil.setViewPagerScroller(mLivePager, mScroller);
//        mLiveImageAdapter = new FocusImageAdapter(this, mLiveImages,
//                FocusImageAdapter.TYPE_DISCOVER, "live");
//        mLiveImageAdapter.setCycleScrollFlag(true);
//        mLivePager.setAdapter(mLiveImageAdapter);
//        mLiveIndicator.setViewPager(mLivePager);
//        mLiveIndicator.setOnPageChangeListener(new OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int arg0) {
//                mLiveFocusIndex = arg0;
//                int realDataIndex = arg0 % mLiveImages.size();
//                if (mLiveImages != null && mLiveImages.size() > realDataIndex) {
//                    updateSceneLiveViews((SceneLiveBannerM) mLiveImages.get(realDataIndex));
//                }
//            }
//
//            @Override
//            public void onPageScrolled(int arg0, float arg1, int arg2) {
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int arg0) {
//            }
//        });
//        mLivePager.setOnTouchListener(new OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_MOVE:
//                        isLiveFocusTouch = true;
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        isLiveFocusTouch = false;
//                        break;
//                    default:
//                        break;
//                }
//                return false;
//            }
//        });
//        mLiveImages.add(new SceneLiveBannerM());
//        updateSceneLiveFocusImageBar();
//        mLiveEntryLayout.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UserTracking userTracking = new UserTracking();
//                userTracking.setSrcPage("发现_推荐");
//                userTracking.setSrcModule("现场直播");
//                userTracking.setSrcTitle("更多");
//                userTracking.setItem("现场直播");
//                CommonRequestM.statItingNew(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW, userTracking.getParams());
//                SceneLivesListFragment fragment = SceneLivesListFragment.newInstance();
//                startFragment(fragment, v);
//            }
//        });
//    }
//
//    private void initFooterView(Context context) {
//        mFooterView = new LinearLayout(context);
//        mFooterView.setOrientation(LinearLayout.VERTICAL);
//        mFooterView.addView(mMoreCategoryLayout);
//
//        View border1 = new View(context);
//        border1.setBackgroundResource(R.color.bg_color);
//
//        View border2 = new View(context);
//        border2.setBackgroundResource(R.color.bg_color);
//
//        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
//                BaseUtil.dp2px(context, 10));
//
//        mFooterView.addView(border1, lp);
//        // mFooterView.addView(mLiveEntryLayout);
//        // mFooterView.addView(border2, lp);
//        mFooterView.addView(mBottomAdContainer);
//    }
//
//    /**
//     * 初始化推荐推荐列表的头部布局（焦点图、猜你喜欢、推荐、精品听单、其他）
//     *
//     * @param context
//     */
//    private void initHeaderView(Context context) {
//        mHeaderView = new LinearLayout(context);
//        mHeaderView.setOrientation(LinearLayout.VERTICAL);
//    }
//
//    /**
//     * 初始化列表
//     *
//     * @param context
//     */
//    private void initListView(Context context) {
//        mListView = (RefreshLoadMoreListView) findViewById(R.id.listview);
//        mListView.setHasMoreNoFooterView(false);
//        mListView.getRefreshableView().setDividerHeight(
//                BaseUtil.dp2px(context, 0));
//        mListView.getRefreshableView().setPadding(0, 0, 0, BaseUtil.dp2px(mContext, 30));
//        mListView.setOnRefreshLoadMoreListener(new IRefreshLoadMoreListener() {
//            @Override
//            public void onRefresh() {
//                loadRecommendsFromNet();
//                loadHotAndGuess();
//                loadSceneLivesFromNet();
//                if (!isFirstLoad && mAdFragment != null && mAdFragment.isAdded()) {
//                    mAdFragment.statAd();
//                }
//            }
//
//            @Override
//            public void onMore() {
//
//            }
//        });
//        mListView.getRefreshableView().addHeaderView(mHeaderView);
//        mListView.getRefreshableView().addFooterView(mFooterView);
//    }
//
//    /**
//     * 启动自动轮播Banner
//     */
//    private void startAutoSwapSceneLiveImage() {
//        if (mListView != null)
//            mListView.postDelayed(mAutoSwapSceneLiveRunnable, SWAP_AD_INTERNAL);
//    }
//
//    /**
//     * 停止自动轮播Banner
//     */
//    private void stopAutoSwapSceneLiveImage() {
//        if (mListView != null)
//            mListView.removeCallbacks(mAutoSwapSceneLiveRunnable);
//    }
//
//    /**
//     * 自动轮播Banner的线程
//     */
//    private final Runnable mAutoSwapSceneLiveRunnable = new Runnable() {
//
//        @Override
//        public void run() {
//            stopAutoSwapSceneLiveImage();
//            if (mLivePager.getVisibility() == View.VISIBLE
//                    && mLiveImageAdapter.getCount() > 0 && !isLiveFocusTouch) {
//                mLivePager.setCurrentItem(mLiveFocusIndex++);
//                if (mLiveFocusIndex >= mLiveImageAdapter.getCount()) {
//                    mLiveFocusIndex = 0;
//                }
//            }
//            mListView.postDelayed(this, SWAP_AD_INTERNAL);
//        }
//    };
//
//    /**
//     * 启动自动轮播Banner
//     */
//    private void startAutoSwapFocusImage() {
//        if (mListView != null)
//            mListView.postDelayed(mAutoSwapRunnable, SWAP_AD_INTERNAL);
//    }
//
//    /**
//     * 停止自动轮播Banner
//     */
//    private void stopAutoSwapFocusImage() {
//        if (mListView != null)
//            mListView.removeCallbacks(mAutoSwapRunnable);
//    }
//
//    /**
//     * 自动轮播Banner的线程
//     */
//    private final Runnable mAutoSwapRunnable = new Runnable() {
//
//        @Override
//        public void run() {
//            stopAutoSwapFocusImage();
//            if (mFocusPager.getVisibility() == View.VISIBLE
//                    && mFocusAdapter.getCount() > 0 && !isFocusTouch) {
//                mFocusPager.setCurrentItem(mFocusIndex++);
//                if (mFocusIndex >= mFocusAdapter.getCount()) {
//                    mFocusIndex = 0;
//                }
//            }
//            mListView.postDelayed(this, SWAP_AD_INTERNAL);
//        }
//    };
//
//    /**
//     * 是否需要展示猜你喜欢
//     *
//     * @param data
//     * @return
//     */
//    private boolean needShowGuessLike(AlbumMList data) {
//        return NetworkUtils.isNetworkAvaliable(mActivity) && data != null && data.getList() != null
//                && data.getList().size() >= 6;
//    }
//
//    /**
//     * 判断是否需要显示小编推荐
//     *
//     * @param data
//     * @return
//     */
//    private boolean needShowEditorRecommend(EditorRecommendAlbumList data) {
//        return data != null && data.getList() != null
//                && data.getList().size() >= 3;
//    }
//
//    /**
//     * 更新轮播图控件
//     */
//    private void updateFocusImageBar() {
//
//        mFocusLoading.setImageBitmap(null);
//        mFocusLoading.setVisibility(View.GONE);
//
//        if (isFakeData) {
//            mFocusIndicator.setPagerRealCount(mFocusImages.size() / 2);
//        } else {
//            mFocusIndicator.setPagerRealCount(mFocusImages.size());
//        }
//        mFocusAdapter.notifyDataSetChanged();
//        if (mFocusIndex == 0 && mFocusImages.size() > 1)
//            mFocusPager.setCurrentItem(Integer.MAX_VALUE / 2
//                    - (Integer.MAX_VALUE / 2) % mFocusImages.size()); // 初始时ViewPager设置在中间位置
//        else
//            mFocusPager.setCurrentItem(mFocusIndex);
//
//        if(isRealVisable()) {
//            AdManager.batchAdRecordByBannerM(mContext, mFocusImages, AppConstants.AD_LOG_TYPE_SITE_SHOW, AppConstants.AD_POSITION_NAME_CATEGORY_FOCUS);
//        }
//    }
//
//    /**
//     * 解析轮播广告数据
//     *
//     * @param model
//     */
//    private void parseFocusImage(RecommendM model) {
//        if (model == null || model.getBanners() == null) {
//            return;
//        }
//        List<BannerM> banners = model.getBanners().getList();
//
//        if (banners == null || banners.isEmpty()) {
//            return;
//        }
//        mFocusImages.clear();
//        mFocusImages.addAll(banners);
//        if (banners.size() == 1) {
//            ((FocusImageAdapter) mFocusAdapter).setOnlyOnePageFlag(true);
//        }
//
//        // size 2||3 重复添加一遍，保证viewpager页数>=3
//        if (banners.size() == 2 || banners.size() == 3) {
//            isFakeData = true;
//            mFocusImages.addAll(banners);
//        }
//        if(!ToolUtil.isEmptyCollects(banners)) {
//            for (BannerM bannerM : banners) {
//                if(bannerM != null && bannerM.getBannerContentType() == BannerM.TYPE_AD) {
//                    bannerM.setAdName(AppConstants.AD_POSITION_NAME_FIND_FOCUS);
//                }
//            }
//        }
//        mFocusImageRoot.setVisibility(View.VISIBLE);
//        updateFocusImageBar();
//    }
//
//    /**
//     * 解析编辑推荐
//     *
//     * @param
//     */
//    private void parseEditorRecommend(RecommendM data) {
//        if (data == null || data.getEditorRecommendAlbums() == null) {
//            return;
//        }
//
//        if (needShowEditorRecommend(data.getEditorRecommendAlbums())) {
//            EditorRecommendAlbumList model = data.getEditorRecommendAlbums();
//            List<RecommendGridItemM> list = model.getList();
//            RecommendItemHolder h1 = RecommendItemHolder
//                    .findView(mRecommendLayout.findViewById(R.id.sect_1));
//            RecommendItemHolder h2 = RecommendItemHolder
//                    .findView(mRecommendLayout.findViewById(R.id.sect_2));
//            RecommendItemHolder h3 = RecommendItemHolder
//                    .findView(mRecommendLayout.findViewById(R.id.sect_3));
//            bindData(AlbumEventManage.FROM_DISCVERY_EDITOR_REC, h1,
//                    list.get(0), model.getTitle(), "1", "", false);
//            bindData(AlbumEventManage.FROM_DISCVERY_EDITOR_REC, h2,
//                    list.get(1), model.getTitle(), "2", "", false);
//            bindData(AlbumEventManage.FROM_DISCVERY_EDITOR_REC, h3,
//                    list.get(2), model.getTitle(), "3", "", false);
//            resetLayoutWidthAndHeight(h1, h2, h3, mContext);
//            mRecommendTitle
//                    .setText(TextUtils.isEmpty(model.getTitle()) ? getString(R.string.editor_recommend)
//                            : model.getTitle());
//            mRecommendMoreBtn.setVisibility(View.VISIBLE);
//            mRecommendLayout.findViewById(R.id.border_bottom).setVisibility(
//                    View.VISIBLE);
//            if (mRecommendLayout.getVisibility() != View.VISIBLE) {
//                mRecommendLayout.setVisibility(View.VISIBLE);
//            }
//        } else {
//            mRecommendLayout.setVisibility(View.GONE);
//        }
//    }
//
//    /**
//     * 解析本地听
//     *
//     * @param
//     */
//    private void parseCityColumn(RecommendM data) {
//        if (data == null || data.getCityColumn() == null || data.getCityColumn().getAlbums() == null || data.getCityColumn().getAlbums().size() <= 2) {
//            mCityLayout.setVisibility(View.GONE);
//            return;
//        }
//
//        CityColumn model = data.getCityColumn();
//        String code = model.getCode();
//        if (!TextUtils.isEmpty(code)) {
//            if (TextUtils.isEmpty(SharedPreferencesUtil.getInstance(mContext).getString(AppConstants.LOCAL_CITY_CODE))) {
//                SharedPreferencesUtil.getInstance(mContext).saveString(AppConstants.LOCAL_CITY_CODE, code);
//            }
//        }
//
//        RecommendItemHolder h1 = RecommendItemHolder
//                .findView(mCityLayout.findViewById(R.id.sect_1));
//        RecommendItemHolder h2 = RecommendItemHolder
//                .findView(mCityLayout.findViewById(R.id.sect_2));
//        RecommendItemHolder h3 = RecommendItemHolder
//                .findView(mCityLayout.findViewById(R.id.sect_3));
//        bindData(AlbumEventManage.FROM_LOCAL_TING, h1,
//                data.getCityColumn().getAlbums().get(0), model.getTitle(), "1", "", false);
//        bindData(AlbumEventManage.FROM_LOCAL_TING, h2,
//                data.getCityColumn().getAlbums().get(1), model.getTitle(), "2", "", false);
//        bindData(AlbumEventManage.FROM_LOCAL_TING, h3,
//                data.getCityColumn().getAlbums().get(2), model.getTitle(), "3", "", false);
//        resetLayoutWidthAndHeight(h1, h2, h3, mContext);
//        cityTitle = TextUtils.isEmpty(model.getTitle()) ? getString(R.string.city_column)
//                : model.getTitle();
//        mCityTitle.setText(cityTitle);
//        mCityMoreBtn.setVisibility(View.VISIBLE);
//        mCityLayout.findViewById(R.id.border_bottom).setVisibility(
//                View.VISIBLE);
//        if (mCityLayout.getVisibility() != View.VISIBLE) {
//            mCityLayout.setVisibility(View.VISIBLE);
//        }
//    }
//
//    private void parseHotRecommend(RecommendM model) {
//        if (model.getHotRecommends() != null && model.getHotRecommends().getList() != null) {
//            mRecommendsData.clear();
//            mRecommendsData.addAll(model.getHotRecommends().getList());
//
//            filterInvalidHotRecommends(mRecommendsData);
//            if (!isFirstLoad && mFeedAds != null && !mFeedAds.isEmpty()) {
//                insertOrReplaceAd(mRecommendsData, mFeedAds, false);
//            }
//            if (mAdapter == null) {
//                mAdapter = new RecommendSectionAdapter(getActivity(),
//                        RecommendFragment.this, mRecommendsData);
//                mListView.setAdapter(mAdapter);
//            } else {
//                mAdapter.notifyDataSetChanged();
//            }
//        }
//    }
//
//    /**
//     * 解析猜我喜欢数据
//     */
//    private void parseGuessLike(RecommendM recommendM) {
//        if (recommendM == null || recommendM.getGuessLikeList() == null || recommendM.getGuessLikeList().getList() == null || recommendM.getGuessLikeList().getList().isEmpty()) {
//            mGuessLikeLayout.setVisibility(View.GONE);
//            return;
//        }
//        AlbumMList data = recommendM.getGuessLikeList();
//        if (needShowGuessLike(data)) {
//            if (mGuessLikeLayout.getVisibility() != View.VISIBLE) {
//                mGuessLikeLayout.setVisibility(View.VISIBLE);
//            }
//
//            if (mGuessLikeTitle != null) {
//                mGuessLikeLayout.findViewById(R.id.section_content_2).setVisibility(View.VISIBLE);
//                mGuessLikeLayout.findViewById(R.id.border_bottom).setVisibility(View.VISIBLE);
//                mGuessLikeTitle
//                        .setText(TextUtils.isEmpty(data.getTitle()) ? getString(R.string.guess_your_favorite)
//                                : data.getTitle());
//            }
//
//            RecommendItemHolder h1 = RecommendItemHolder
//                    .findView(mGuessLikeLayout.findViewById(R.id.sect_1));
//            RecommendItemHolder h2 = RecommendItemHolder
//                    .findView(mGuessLikeLayout.findViewById(R.id.sect_2));
//            RecommendItemHolder h3 = RecommendItemHolder
//                    .findView(mGuessLikeLayout.findViewById(R.id.sect_3));
//            RecommendItemHolder h4 = RecommendItemHolder
//                    .findView(mGuessLikeLayout.findViewById(R.id.sect_4));
//            RecommendItemHolder h5 = RecommendItemHolder
//                    .findView(mGuessLikeLayout.findViewById(R.id.sect_5));
//            RecommendItemHolder h6 = RecommendItemHolder
//                    .findView(mGuessLikeLayout.findViewById(R.id.sect_6));
//
//            bindData(AlbumEventManage.FROM_GUESS_LIKE, h1,
//                    convert(data.getList().get(0)), data.getTitle(), "1", "", false);
//            bindData(AlbumEventManage.FROM_GUESS_LIKE,  h2,
//                    convert(data.getList().get(1)), data.getTitle(), "2", "", false);
//            bindData(AlbumEventManage.FROM_GUESS_LIKE,  h3,
//                    convert(data.getList().get(2)), data.getTitle(), "3", "", false);
//            bindData(AlbumEventManage.FROM_GUESS_LIKE,  h4,
//                    convert(data.getList().get(3)), data.getTitle(), "4", "", false);
//            bindData(AlbumEventManage.FROM_GUESS_LIKE, h5,
//                    convert(data.getList().get(4)), data.getTitle(), "5", "", false);
//            bindData(AlbumEventManage.FROM_GUESS_LIKE,  h6,
//                    convert(data.getList().get(5)), data.getTitle(), "6", "", false);
//            resetLayoutWidthAndHeight(h1, h2, h3, mContext);
//            resetLayoutWidthAndHeight(h4, h5, h6, mContext);
//        }
//    }
//
//    /**
//     * 解析付费精品数据
//     */
//    private void parsePaidAlbum(RecommendM recommendM) {
//        if (recommendM == null || recommendM.getPaidAlbumList() == null || recommendM.getPaidAlbumList().getList() == null || recommendM.getPaidAlbumList().getList().isEmpty()) {
//            mPaidAreaLayout.setVisibility(View.GONE);
//            return;
//        }
//        AlbumMList data = recommendM.getPaidAlbumList();
//        mPaidAreaLayout
//                .findViewById(R.id.layout_section_header).setTag(data);
//        if (data != null && data.getList() != null
//                && data.getList().size() >= 3) {
//            if (mPaidAreaLayout.getVisibility() != View.VISIBLE) {
//                mPaidAreaLayout.setVisibility(View.VISIBLE);
//            }
//
//            mPaidAreaLayout.findViewById(R.id.border_bottom).setVisibility(View.VISIBLE);
//            mPaidAreaTitle
//                    .setText(TextUtils.isEmpty(data.getTitle()) ? "付费精品"
//                            : data.getTitle());
////            if (!SharedPreferencesUtil.getInstance(mContext).getBoolean(AppConstants.ISFIRSTCLICKED, false)) {
////                mPaidAreaLayout.findViewById(R.id.iv_tags_new).setVisibility(View.VISIBLE);
////            } else {
////                mPaidAreaLayout.findViewById(R.id.iv_tags_new).setVisibility(View.GONE);
////            }
//
//            RecommendItemHolder h1 = RecommendItemHolder
//                    .findView(mPaidAreaLayout.findViewById(R.id.sect_1));
//            RecommendItemHolder h2 = RecommendItemHolder
//                    .findView(mPaidAreaLayout.findViewById(R.id.sect_2));
//            RecommendItemHolder h3 = RecommendItemHolder
//                    .findView(mPaidAreaLayout.findViewById(R.id.sect_3));
//
//            h1.ivPlay.setVisibility(View.GONE);
//            h2.ivPlay.setVisibility(View.GONE);
//            h3.ivPlay.setVisibility(View.GONE);
//
//            bindData(AlbumEventManage.FROM_PAY2LISTEN, h1,
//                    convert(data.getList().get(0)), data.getTitle(), "1", "", false);
//            bindData(AlbumEventManage.FROM_PAY2LISTEN, h2,
//                    convert(data.getList().get(1)), data.getTitle(), "2", "", false);
//            bindData(AlbumEventManage.FROM_PAY2LISTEN, h3,
//                    convert(data.getList().get(2)), data.getTitle(), "3", "", false);
//            resetLayoutWidthAndHeight(h1, h2, h3, mContext);
//        }
//    }
//
//
//    /**
//     * 解析付费会员
//     *
//     * @param model
//     */
//    private void parsePaidMember(RecommendM model) {
//        List<HotRecommendM> list = new ArrayList<>();
//        list.add(model.getMemberColumnMList());
//        HotRecommendM recommendM = model.getMemberColumnMList();
//        if (recommendM != null && recommendM.getList() != null && recommendM.getList().size() >= 3) {
//            mPaidMemberLayout.setVisibility(View.VISIBLE);
//            RecommendItemHolder h1 = RecommendItemHolder
//                    .findView(mPaidMemberLayout.findViewById(R.id.sect_1));
//            RecommendItemHolder h2 = RecommendItemHolder
//                    .findView(mPaidMemberLayout.findViewById(R.id.sect_2));
//            RecommendItemHolder h3 = RecommendItemHolder
//                    .findView(mPaidMemberLayout.findViewById(R.id.sect_3));
//
//            TextView title = (TextView) mPaidMemberLayout.findViewById(R.id.tv_title);
//            ImageView tags = (ImageView) mPaidMemberLayout.findViewById(R.id.iv_tags_new);
//            View moreBtn = mPaidMemberLayout.findViewById(R.id.layout_section_header);
//            mPaidMemberLayout.findViewById(R.id.border_bottom).setVisibility(View.VISIBLE);
//
//            title.setText(recommendM.getTitle() == null ? "" : recommendM.getTitle());
//            if (!TextUtils.isEmpty(recommendM.getTitle()) && !SharedPreferencesUtil.getInstance(mContext).getBoolean(AppConstants.MEMBER_FIRST_CLICK, false)) {
//                tags.setVisibility(View.VISIBLE);
//            } else {
//                tags.setVisibility(View.GONE);
//            }
//
//            h1.ivPlay.setVisibility(View.GONE);
//            h2.ivPlay.setVisibility(View.GONE);
//            h3.ivPlay.setVisibility(View.GONE);
//
//            moreBtn.setVisibility(View.VISIBLE);
//            moreBtn.setOnClickListener(this);
//            moreBtn.setTag(MORE_MEMBER);
//
//            recommendM.getList().get(0).setTrack(false);
//            recommendM.getList().get(1).setTrack(false);
//            recommendM.getList().get(2).setTrack(false);
//            bindData(AlbumEventManage.FROM_MEMBER_VIP,
//                    h1,
//                    recommendM.getList().get(0), recommendM.getTitle(), "1", "" + recommendM.getCategoryId(), false);
//            bindData(AlbumEventManage.FROM_MEMBER_VIP,
//                    h2,
//                    recommendM.getList().get(1), recommendM.getTitle(), "2", "" + recommendM.getCategoryId(), false);
//            bindData(AlbumEventManage.FROM_MEMBER_VIP,
//                    h3,
//                    recommendM.getList().get(2), recommendM.getTitle(), "3", "" + recommendM.getCategoryId(), false);
//
//            resetLayoutWidthAndHeight(h1, h2, h3, mContext);
//        }
//
//
//    }
//
//    private void deleteGame(RecommendDiscoveryList data) {
//        String channel;
//        channel = ToolUtil.getMetaData(mActivity, "TING_UMENG_CHANNEL");
//        if (!TextUtils.isEmpty(channel) && AppConfigfConstants.channelHasNoGameCenterList.contains(channel)) {
//            if (data != null) {
//                if (data.getList() != null) {
//                    Iterator<RecommendDiscoveryM> iterator = data.getList().iterator();
//                    while (iterator.hasNext()) {
//                        RecommendDiscoveryM temp = iterator.next();
//                        if (temp != null && !TextUtils.isEmpty(temp.getTitle())) {
//                            if (temp.getTitle().contains("游戏中心") || temp.getId() == 10) {
//                                iterator.remove();
//                            }
//                        }
//                    }
////                    for (int i = 0; i < data.getList().size(); i++) {
////                        RecommendDiscoveryM discovery = data.getList().get(i);
////                        if (discovery.getTitle().contains("游戏中心") || discovery.getId() == 10) {
////                            data.getList().remove(discovery);
////                        }
////                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * 解析精品听单
//     *
//     * @param model
//     */
//    private void parseSpecialColumn(RecommendM model) {
//        if (model == null || model.getSpecialColumns() == null) {
//            return;
//        }
//
//        SpecialColumnMList specialColumns = model.getSpecialColumns();
//        List<SpecialColumnM> list = specialColumns.getList();
//        if (list != null && !list.isEmpty()) {
//            if (mSpecialLayout.getVisibility() != View.VISIBLE) {
//                mSpecialLayout.setVisibility(View.VISIBLE);
//            }
//            mSpecialTitle
//                    .setText(TextUtils.isEmpty(specialColumns.getTitle()) ? getString(R.string.special_listen_list)
//                            : specialColumns.getTitle());
//            updateSpecialList(list);
//        } else {
//            mSpecialLayout.setVisibility(View.GONE);
//        }
//    }
//
//    /**
//     * 解析发现新奇
//     *
//     * @param model
//     */
//    private void parseDiscoveryColumn(RecommendM model) {
//        if (model == null || getActivity() == null) {
//            return;
//        }
//        mLastRecommendM = model;
//        panelCalabash.removeAllViews();
//        final RecommendDiscoveryList data = model.getRecommendDiscoverys();
//        if (data != null && data.getList() != null && !data.getList().isEmpty()) {
//            final CalabashLineAdapter adapter = new CalabashLineAdapter(getActivity(), this, data.getList(), 1);
//            int screenWidth = BaseUtil.getScreenWidth(mContext);
//            int divider = (int) (screenWidth / 4.5 - BaseUtil.dp2px(mContext, 70));
//            panelCalabash.setPadding(divider / 2, 0, 0, 0);
//            deleteGame(data);
//            for (int i = 0; i < data.getList().size(); i++) {
//                View child = adapter.getView(i, null, null);
//                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(BaseUtil.dp2px(mContext, 70), -1);
//                params.rightMargin = divider;
//                panelCalabash.addView(child, params);
//                final int postion = i;
//                child.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        adapter.onClick(v, data.getList().get(postion), postion);
//                    }
//                });
//            }
//            mDiscoveryLayout.setVisibility(View.VISIBLE);
//        } else {
//            mDiscoveryLayout.setVisibility(View.GONE);
//        }
//    }
//
//    // /**
//    // * 更新热门主播数据
//    // *
//    // * @param model
//    // */
//    // private void parseLiveEntrance(RecommendM model) {
//    // if (model == null || model.getEntranceList() == null
//    // || model.getEntranceList().getRet() != 0)
//    // return;
//    //
//    // if (model.getEntranceList().getEntrances() != null
//    // && model.getEntranceList().getEntrances().size() > 0) {
//    // for (Entrance item : model.getEntranceList().getEntrances()) {
//    // if ("live".equals(item.getEntranceType())) {
//    // mLiveEntryTxt.setText(item.getTitle());
//    // ImageManager.from(mContext).displayImage(mLiveEntryImg,
//    // item.getCoverPath(), -1);
//    // break;
//    // }
//    // }
//    // }
//    // }
//
//    /**
//     * 将AlbumM转换成RecommendGridItemM，显示在推荐列表上
//     *
//     * @param data
//     * @return
//     */
//    private RecommendGridItemM convert(AlbumM data) {
//        RecommendGridItemM item = new RecommendGridItemM();
//        item.setCoverMiddle(data.getCoverUrlMiddle());
//        item.setCoverLarge(data.getCoverUrlLarge());
//        item.setTitle(data.getAlbumTitle());
//        item.setTrackTitle(data.getSubTitle());
//        item.setTags(data.getAlbumTags());
//        item.setIsFinished(data.getIsFinished());
//        item.setAlbumId(data.getId());
//        item.setRecSrc(data.getRecommentSrc());
//        item.setRecTrack(data.getRecTrack());
//        item.setPaid(data.isPaid());
//        item.setPriceTypeEnum(data.getPriceTypeEnum());
//        item.setPriceTypeId(data.getPriceTypeId());
//        return item;
//    }
//
//    /**
//     * 更新精品听单
//     *
//     * @param list
//     */
//    private void updateSpecialList(List<SpecialColumnM> list) {
//        Context context = BaseApplication.getMyApplicationContext();
//        int size = list.size();
//        if (size == 0) {
//            mSpecialLayout.setVisibility(View.GONE);
//            return;
//        }
//
//        mSpecialContainer.removeAllViews();
//
//        for (int i = 0; i < size; i++) {
//            SpecialColumnM model = list.get(i);
//            ViewGroup item = (ViewGroup) LayoutInflater.from(context).inflate(
//                    R.layout.item_special_list, mSpecialContainer, false);
//
//            ImageView iv = (ImageView) item.findViewById(R.id.cover);
//            ImageManager.from(context).displayImage(iv, model.getCoverPath(),
//                    R.drawable.image_default_145);
//            ((TextView) item.findViewById(R.id.name))
//                    .setText(model.getTitle() == null ? "" : model.getTitle());
//            ImageView tag = (ImageView) item.findViewById(R.id.tag_img);
//            tag.setVisibility(View.GONE);
//            TextView subtitle = (TextView) item.findViewById(R.id.subtitle);
//            subtitle.setText(model.getSubtitle() == null ? "" : model
//                    .getSubtitle().replace("\r\n", " "));
//            subtitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
//            TextView desc = (TextView) item.findViewById(R.id.desc);
//            if (TextUtils.isEmpty(model.getFootnote())) {
//                desc.setVisibility(View.GONE);
//            } else {
//                desc.setVisibility(View.VISIBLE);
//                desc.setText(model.getFootnote());
//            }
//            if (i == size - 1) {
////				ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) item
////						.getLayoutParams();
////				lp.height = BaseUtil.dp2px(context, 83);
////				item.setLayoutParams(lp);
//                item.findViewById(R.id.border).setVisibility(View.GONE);
//            }
//            final int pos = i + 1;
//            item.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    if (!OneClickHelper.getInstance().onClick(v)) {
//                        return;
//                    }
//                    SpecialColumnM model = (SpecialColumnM) v.getTag();
//                    if (model != null) {
//                        if (model.getColumnType() == SpecialColumnM.TYPE_COLUMN_SUBJECT) {
//                            toSubjectDetail(model, v, pos);
//                        } else if (model.getColumnType() == SpecialColumnM.TYPE_COLUMN_RANK) {
//                            toRankDetail(model, v);
//                        }
//                    }
//                }
//            });
//            item.setTag(model);
//            mSpecialContainer.addView(item);
//        }
//    }
//
//    /**
//     * 配置数据到界面
//     *
//     * @param model
//     */
//    private void setRecommendDataForView(RecommendM model) {
//        onPageLoadingCompleted(LoadCompleteType.OK);
//        mListView.onRefreshComplete(false);
//        mListView.setHasMoreNoFooterView(false);
//        parseFocusImage(model);// 适配焦点图数据
//        parseSpecialColumn(model);
//        parseEditorRecommend(model);
////        parseDiscoveryColumn(model);
//        // parseLiveEntrance(model);
//
//        if (mMoreCategoryLayout.getVisibility() != View.VISIBLE) {
//            mMoreCategoryLayout.setVisibility(View.VISIBLE);
//        }
//        if (mBottomAdContainer.getVisibility() != View.VISIBLE) {
//            mBottomAdContainer.setVisibility(View.VISIBLE);
//        }
//        // if (mLiveEntryLayout.getVisibility() != View.VISIBLE) {
//        // mLiveEntryLayout.setVisibility(View.VISIBLE);
//        // }
//    }
//
//    /**
//     * 配置数据到界面
//     *
//     * @param model
//     */
//    private void setHotDataForView(RecommendM model) {
//        isFirstLoad = false;
//        onPageLoadingCompleted(LoadCompleteType.OK);
//        parseCityColumn(model);
//        parseDiscoveryColumn(model);
//        parseGuessLike(model);
//        parsePaidMember(model);
//        parsePaidAlbum(model);
//        // parseLiveEntrance(model);
//        parseHotRecommend(model);
//    }
//
//
//    /**
//     * 如果水平的数据项少于3个，设置不可见
//     *
//     * @param data
//     */
//    private void filterInvalidHotRecommends(List<Object> data) {
//        if (data == null)
//            return;
//        Iterator<Object> iter = data.iterator();
//        while (iter.hasNext()) {
//            Object model = iter.next();
//            if (model instanceof HotRecommendM) {
//                if (((HotRecommendM) model).getList() == null
//                        || ((HotRecommendM) model).getList().size() < 3) {
//                    iter.remove();
//                }
//            }
//        }
//    }
//
//    /**
//     * 跳转到精品听单
//     *
//     * @param item
//     * @param view
//     * @param pos
//     */
//    private void toSubjectDetail(SpecialColumnM item, View view, int pos) {
//        int contentType = 1;
//        if (!TextUtils.isEmpty(item.getContentType())) {
//            contentType = Integer.valueOf(item.getContentType());
//        }
//        UserTracking userTracking = new UserTracking();
//        userTracking.setSrcPage("发现_推荐");
//        userTracking.setSrcModule("精品听单");
//        userTracking.setSrcPosition(pos);
//        userTracking.setItem("subject");
//        userTracking.setItemId(item.getSpecialId());
//        CommonRequestM.statItingNew(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW, userTracking.getParams());
//        startFragment(
//                SubjectFragment.newInstance(item.getSpecialId(), contentType,
//                         "听单详情"),
//                view);
//    }
//
//    /**
//     * 跳转到排行榜
//     *
//     * @param item
//     * @param view
//     */
//    private void toRankDetail(SpecialColumnM item, View view) {
//        String type = item.getContentType();
//        String title = item.getTitle();
//        int rankingListId = item.getRankingListId();
//        if (type.equals(TYPE_ALBUM_STR)) {
//            startFragment(RankContentListFragment.newInstanceV3(rankingListId, "main", title, RankContentListFragment.TYPE_ALBUM,  ConstantsOpenSdk.PLAY_FROM_RANK), view);
//        } else if (type.equals(TYPE_ANCHOR_STR)) {
//            startFragment(RankContentListFragment.newInstanceV3(rankingListId, "main", title, RankContentListFragment.TYPE_ANCHOR,  ConstantsOpenSdk.PLAY_FROM_RANK), view);
//        } else if (type.equals(TYPE_TRACK_STR)) {
//            startFragment(RankContentListFragment.newInstanceV3(rankingListId, "main", title, RankContentListFragment.TYPE_TRACK,  ConstantsOpenSdk.PLAY_FROM_RANK), view);
//        }
//    }
//
//    /**
//     * 推荐项布局重绘
//     *
//     * @param h1
//     * @param h2
//     * @param h3
//     */
//    private static void resetLayoutWidthAndHeight(RecommendItemHolder h1,
//                                                  RecommendItemHolder h2, RecommendItemHolder h3, Context context) {
//        int width = (BaseUtil.getScreenWidth(context) - BaseUtil.dp2px(context,
//                40)) / 3;
//        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) h1.tivCover
//                .getLayoutParams();
//        lp.height = width;
//        h1.tivCover.setLayoutParams(lp);
//        lp = (RelativeLayout.LayoutParams) h2.tivCover.getLayoutParams();
//        lp.height = width;
//        h2.tivCover.setLayoutParams(lp);
//        lp = (RelativeLayout.LayoutParams) h3.tivCover.getLayoutParams();
//        lp.height = width;
//        h3.tivCover.setLayoutParams(lp);
//    }
//
//    private int mItemWidth = 0;
//    private AdFragment mAdFragment;
//
//    private void showImage(int mFirstVisibleItem, int mVisibleItemCount) {
//
//        if (mAdapter == null || mRecommendsData == null)
//            return;
//
//        if (mItemWidth == 0) {
//            mItemWidth = ((BaseUtil.getScreenWidth(mContext) - BaseUtil.dp2px(
//                    mContext, 40)) / 3);
//        }
//
//        int headerCount = mListView.getRefreshableView().getHeaderViewsCount();
//        for (int i = 0; i < mVisibleItemCount; i++) {
//            int indexOfData = i + mFirstVisibleItem - headerCount;
//            if (indexOfData >= 0 && indexOfData < mRecommendsData.size() && mRecommendsData.get(indexOfData) != null && mRecommendsData.get(indexOfData) instanceof HotRecommendM) {
//                HotRecommendM data = (HotRecommendM) mRecommendsData.get(indexOfData);
//                boolean isMemberData = data.isMemberData();
//                int from;
//                if (isMemberData) {
//                    from = AlbumEventManage.FROM_MEMBER_VIP;
//                } else if (isPayItem(data)) {
//                    from = AlbumEventManage.FROM_PAY2LISTEN;
//                } else {
//                    from = AlbumEventManage.FROM_RECOMMEND_ALBUM;
//                }
//                boolean isTrack = data.isTrack();
//                String imgUrl0 = getImageUrl(data.getList().get(0), isTrack, from);
//                String imgUrl1 = getImageUrl(data.getList().get(1), isTrack, from);
//                String imgUrl2 = getImageUrl(data.getList().get(2), isTrack, from);
//                View itemView = mListView.getRefreshableView().getChildAt(i);
//                Log.e("RecommendView", "position_" + i + "_is null" + (itemView == null));
//                if (itemView.getTag() instanceof ViewHolder) {
//                    ViewHolder holder = (ViewHolder) itemView.getTag();
//
//                    ImageManager.from(mContext).displayImage(holder.h1.tivCover,
//                            imgUrl0, R.drawable.image_default_145,
//                            (int) mItemWidth, (int) mItemWidth);
//                    ImageManager.from(mContext).displayImage(holder.h2.tivCover,
//                            imgUrl1, R.drawable.image_default_145,
//                            (int) mItemWidth, (int) mItemWidth);
//                    ImageManager.from(mContext).displayImage(holder.h3.tivCover,
//                            imgUrl2, R.drawable.image_default_145,
//                            (int) mItemWidth, (int) mItemWidth);
//                }
//            }
//        }
//    }
//
//    private void hideImage(int mVisibleItemCount) {
//
//        if (mAdapter == null || mRecommendsData == null)
//            return;
//
//        for (int i = 0; i < mVisibleItemCount; i++) {
//            View itemView = mListView.getRefreshableView().getChildAt(i);
//            if (itemView.getTag() instanceof ViewHolder) {
//                ViewHolder holder = (ViewHolder) itemView.getTag();
//                holder.h1.tivCover.setImageDrawable(LocalImageUtil.getDrawable(mContext, R.drawable.image_default_145));
//                holder.h2.tivCover.setImageDrawable(LocalImageUtil.getDrawable(mContext, R.drawable.image_default_145));
//                holder.h3.tivCover.setImageDrawable(LocalImageUtil.getDrawable(mContext, R.drawable.image_default_145));
//            }
//        }
//    }
//
//    private String getImageUrl(RecommendGridItemM data, boolean isTrack, int from) {
//        if (from == AlbumEventManage.FROM_MEMBER_VIP) {
//            return data.getBannerUrl();
//        } else {
//            return getCoverPath(isTrack, data);
//        }
//    }
//
//
//
//
//    /**
//     * 绑定数据
//     *
//     * @param
//     * @param ih
//     * @param data
//     */
//    private void bindData(final int from, RecommendItemHolder ih,
//                          RecommendGridItemM data, final String xdcsTitle,
//                          final String xdcsPosition, final String moduleId, boolean needCache) {
//
//        final boolean isTrack = data.isTrack();
//        if (mItemWidth == 0) {
//            mItemWidth = ((BaseUtil.getScreenWidth(mContext) - BaseUtil.dp2px(
//                    mContext, 40)) / 3);
//        }
//        String imgUrl;
//        if (from == AlbumEventManage.FROM_MEMBER_VIP) {
//            imgUrl = data.getBannerUrl();
//        } else {
//            imgUrl = getCoverPath(isTrack, data);
//        }
//
//        addImageViewInRecycleList(ih.tivCover,imgUrl,R.drawable.image_default_145);
//        if (needCache && scrollState != AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
//            Bitmap bitmap = ImageManager.from(mContext).getFromCacheAndDisk(ih.tivCover, imgUrl, mItemWidth, mItemWidth);
//            if (bitmap != null) {
//                ih.tivCover.setImageBitmap(bitmap);
//            } else {
//                ih.tivCover.setImageDrawable(LocalImageUtil.getDrawable(mContext, R.drawable.image_default_145));
//            }
//        }
//
//        if (!needCache) {//不需要从cache中取bitmap
//            if (mItemWidth != 0) {
//                ImageManager.from(mContext).displayImage(ih.tivCover,
//                        imgUrl, R.drawable.image_default_145,
//                        (int) mItemWidth, (int) mItemWidth);
//            } else {
//                ImageManager.from(mContext).displayImage(ih.tivCover,
//                        imgUrl, R.drawable.image_default_145);
//            }
//        }
//
//        String subTitle;
//        final boolean isGuessLike = AlbumEventManage.FROM_GUESS_LIKE == from;
//        if (isGuessLike) {
//            subTitle = StringUtil.trimNull(data.getTitle());
//            //TODO 猜你喜欢模块不需要副标题
////            if (!TextUtils.isEmpty(data.getTags())) {
////                ih.tvDesc.setVisibility(View.VISIBLE);
////                ih.tvDesc.setText(StringUtil.getFirstTag(data.getTags()));
////                ih.tvDesc.setCompoundDrawables(LocalImageUtil.getDrawable(mContext, R.drawable.ic_find_tag), null, null, null);
////            } else {
//                ih.tvDesc.setVisibility(View.GONE);
////            }
//        } else {
//            subTitle = StringUtil.trimNull(data.getTrackTitle());
//            ih.tvDesc.setVisibility(View.VISIBLE);
//            ih.tvDesc.setText(StringUtil.trimNull(data.getTitle()));
//            ih.tvDesc.setCompoundDrawablesWithIntrinsicBounds(R.drawable.finding_album_img, 0, 0, 0);
//        }
//
//        if (from == AlbumEventManage.FROM_MEMBER_VIP) {
//            subTitle = StringUtil.trimNull(data.getTitle());
//            if (!TextUtils.isEmpty(data.getNickname())) {
//                ih.tvDesc.setVisibility(View.VISIBLE);
//                ih.tvDesc.setText(StringUtil.trimNull(data.getNickname()));
//                ih.tvDesc.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_by_user, 0, 0, 0);
//                ih.tvDesc.setCompoundDrawablePadding(5);
//            } else {
//                ih.tvDesc.setVisibility(View.GONE);
//            }
//        }
//        ih.tvName.setText(subTitle);
//
//        if (isTrack) {
//            ih.ivPlay.setVisibility(View.VISIBLE);
//        } else {
//            ih.ivPlay.setVisibility(View.GONE);
//            if (data.isPaid()) {
//                if (AlbumFragmentNew.isShowMemberIcon(data.getPriceTypeEnum())) {
//                    ih.ivComplete.setVisibility(View.VISIBLE);
//                    ih.ivComplete.setImageResource(R.drawable.vip_icon);
//                } else {
//                    ih.ivComplete.setVisibility(View.VISIBLE);
//                    ih.ivComplete.setImageResource(R.drawable.image_pay);
//                }
//            } else {
//                ih.ivComplete.setVisibility(View.GONE);
//            }
//        }
//        ih.tivCover.setTag(data);
//        ih.tivCover.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(final View v) {
//                if (!OneClickHelper.getInstance().onClick(v)) {
//                    return;
//                }
//                final RecommendGridItemM item = (RecommendGridItemM) v.getTag();
//                if (item == null) {
//                    return;
//                }
//                UserTracking userTracking = new UserTracking();
//                userTracking.setSrcPage("发现_推荐");
//                userTracking.setSrcPosition(xdcsPosition);
//                int playSource = ConstantsOpenSdk.PLAY_FROM_FIND_CLASSIFICATION;
//                if (isTrack) {
//                    userTracking.setItem("track");
//                    userTracking.setItemId(item.getTrackId());
//                    if (isGuessLike) {
//                        //猜你喜欢
//                        playSource = ConstantsOpenSdk.PLAY_FROM_FIND_GUESS_YOU_LIKE;
//                        userTracking.setSrcModule("猜你喜欢");
//                        UserTrackCookie.getInstance().setXmContent(System.currentTimeMillis(),"recommend","guessYouLike",null);
//                    } else if (from == AlbumEventManage.FROM_DISCVERY_EDITOR_REC) {
//                        //小编推荐
//                        playSource = ConstantsOpenSdk.PLAY_FROM_FIND_RECOMMEND;
//                        userTracking.setSrcModule("小编推荐");
//                        UserTrackCookie.getInstance().setXmContent(System.currentTimeMillis(),"edit",null,null);
//                    } else if (from == AlbumEventManage.FROM_LOCAL_TING) {
//                        userTracking.setSrcModule("本地听");
//                        userTracking.setSrcSubModuleTitle(xdcsTitle);
//                        playSource = ConstantsOpenSdk.PLAY_FROM_OTHER;
//                        String localTingId = SharedPreferencesUtil.getInstance(MainApplication.getTopActivity()).getString(AppConstants.LOCAL_CITY_CODE);
//                        userTracking.setSrcSubModule(localTingId);
//                        UserTrackCookie.getInstance().setXmContent(System.currentTimeMillis(),"localTing",null,localTingId);
//                    } else {
//                        userTracking.setSrcSubModule(moduleId);
//                        userTracking.setSrcSubModuleTitle(xdcsTitle);
//                        userTracking.setSrcModule("分类听");
//                        UserTrackCookie.getInstance().setXmContent(System.currentTimeMillis(),"category",null,item.getCategoryId()+"");
//                        if (from == AlbumEventManage.FROM_PAY2LISTEN) {
//                            //独家精品
//                            playSource = ConstantsOpenSdk.PLAY_FROM_PAY2LISTEN;
//                        }
//                    }
//
//                    PlayTools.goPlayByTrackId(mContext, item.getTrackId(), v,
//                             playSource);
//                } else {
//                    userTracking.setItem("album");
//                    userTracking.setItemId(item.getAlbumId());
//                    if (isGuessLike) {
//                        userTracking.setSrcModule("猜你喜欢");
//                        playSource = ConstantsOpenSdk.PLAY_FROM_FIND_GUESS_YOU_LIKE;
//                        UserTrackCookie.getInstance().setXmContent(System.currentTimeMillis(),"recommend","guessYouLike",null);
//                    } /*else if (from == AlbumEventManage.FROM_RECOMMEND_ALBUM) {
//                        playSource = ConstantsOpenSdk.PLAY_FROM_FIND_CLASSIFICATION;
//                    }*/ else if (from == AlbumEventManage.FROM_DISCVERY_EDITOR_REC) {
//                        userTracking.setSrcModule("小编推荐");
//                        playSource = ConstantsOpenSdk.PLAY_FROM_FIND_RECOMMEND;
//                        UserTrackCookie.getInstance().setXmContent(System.currentTimeMillis(),"edit",null,null);
//                    } else if (from == AlbumEventManage.FROM_LOCAL_TING) {
//                        userTracking.setSrcModule("本地听");
//                        userTracking.setSrcSubModuleTitle(xdcsTitle);
//                        String localTingId = SharedPreferencesUtil.getInstance(MainApplication.getTopActivity()).getString(AppConstants.LOCAL_CITY_CODE);
//                        userTracking.setSrcSubModule(localTingId);
//                        UserTrackCookie.getInstance().setXmContent(System.currentTimeMillis(),"localTing",null,localTingId);
//                    } else if (from == AlbumEventManage.FROM_MEMBER_VIP) {
//                        userTracking.setItem("member");
//                        userTracking.setItemId(item.getUid());
//                        userTracking.setSrcModule("付费会员");
//                    } else {
//                        userTracking.setSrcSubModule(moduleId);
//                        userTracking.setSrcSubModuleTitle(xdcsTitle);
//                        userTracking.setSrcModule("分类听");
//                        UserTrackCookie.getInstance().setXmContent(System.currentTimeMillis(),"category",null,item.getCategoryId()+"");
//                        if (from == AlbumEventManage.FROM_PAY2LISTEN) {
//                            //独家精品
//                            playSource = ConstantsOpenSdk.PLAY_FROM_PAY2LISTEN;
//                        }
//                    }
//                    final int copyPlaySource = playSource;
//                    //主播会员单独处理,无论是否已买
//                    if (from == AlbumEventManage.FROM_MEMBER_VIP) {
//                        UserTrackCookie.getInstance().setXmContent(System.currentTimeMillis(),"member",null,null);
//                        AlbumEventManage.checkMemberType(mActivity, item, item.getUid());
//                    } else if (item.isPaid()) {
//                        AlbumEventManage.judgeAlbumType(item.getAlbumId(), getActivity(), v,  from, playSource, new IHandleOk() {
//                            @Override
//                            public void onReady() {
//                                startFragment(AlbumFragmentNew.newInstance(
//                                        xdcsTitle,
//                                        item.getRecSrc(), item.getRecTrack(),
//                                        item.getAlbumId(), from, copyPlaySource, -1), v);
//                            }
//                        });
////                        }
//                    } else {
//                        startFragment(AlbumFragmentNew.newInstance(
//                                xdcsTitle,
//                                item.getRecSrc(), item.getRecTrack(),
//                                item.getAlbumId(), from, playSource,  -1), v);
//                    }
//                }
//                CommonRequestM.statItingNew(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW, userTracking.getParams());
//            }
//        });
//    }
//
//    /**
//     * 从缓存取数据，都要按照规定的顺序，猜你喜欢接口——普通推荐接口
//     */
//    private void loadDataFromLocal() {
//
////        Observable
////                .create(new Observable.OnSubscribe<RecommendM>() {
////                    @Override
////                    public void call(Subscriber<? super RecommendM> subscriber) {
////                        RecommendM result;
////
////                        String contentOfHotGuess = FileUtil.readStrFromFile(new File(mContext
////                                .getCacheDir(), MD5.md5(UrlConstants.getInstanse()
////                                .getHotAndGuess())).getAbsolutePath());
////                        if (TextUtils.isEmpty(contentOfHotGuess)) {
////                            contentOfHotGuess = FileUtil.readAssetFileData(mContext,
////                                    "recommend2.json");
////                        }
////                        result = new RecommendM(contentOfHotGuess);
////                        subscriber.onNext(result);
////
////                        String contentOfRecommend = FileUtil.readStrFromFile(new File(mContext
////                                .getCacheDir(), MD5.md5(UrlConstants.getInstanse()
////                                .getRecomments())).getAbsolutePath());
////                        if (TextUtils.isEmpty(contentOfRecommend)) {
////                            contentOfRecommend = FileUtil.readAssetFileData(mContext,
////                                    "recommend1.json");
////                        }
////                        result = new RecommendM(contentOfRecommend);
////                        subscriber.onNext(result);
////
////                        subscriber.onCompleted();
////                    }
////                })
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(new Observer<RecommendM>() {
////                    @Override
////                    public void onCompleted() {
////                        onPageLoadingCompleted(LoadCompleteType.OK);
////                        mListView.onRefreshComplete(false);
////                        mListView.setHasMoreNoFooterView(false);
////
////                        if (mMoreCategoryLayout.getVisibility() != View.VISIBLE) {
////                            mMoreCategoryLayout.setVisibility(View.VISIBLE);
////                        }
////                        if (mBottomAdContainer.getVisibility() != View.VISIBLE) {
////                            mBottomAdContainer.setVisibility(View.VISIBLE);
////                        }
////
////                        //从本地取数据
////                        loadHotAndGuess();
////                        loadRecommendsFromNet();
////                        loadSceneLivesFromNet();
////                    }
////
////                    @Override
////                    public void onError(Throwable e) {
////
////                    }
////
////                    @Override
////                    public void onNext(RecommendM recommendM) {
////                        setDataViewTestRxJava(recommendM);
////                    }
////                });
//
//        new MyAsyncTask<Void, Void, RecommendM>() {
//
//            @Override
//            protected RecommendM doInBackground(Void... params) {
//                if (mContext == null || getActivity() == null || getActivity().isFinishing()) {
//                    return null;
//                }
//
//                RecommendM result = new RecommendM();
//
//                String contentOfHotGuess = FileUtil.readStrFromFile(new File(mContext
//                        .getCacheDir(), MD5.md5(UrlConstants.getInstanse()
//                        .getHotAndGuess())).getAbsolutePath());
//                if (TextUtils.isEmpty(contentOfHotGuess)) {
//                    contentOfHotGuess = FileUtil.readAssetFileData(mContext,
//                            "recommend2.json");
//                }
//
//                if (!TextUtils.isEmpty(contentOfHotGuess)) {
//                    try {
//                        result = new RecommendM(contentOfHotGuess);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                return result;
//            }
//
//            protected void onPostExecute(RecommendM result) {
//                if (result != null) {
//                    setHotDataForView(result);
//                }
//                loadOtherDataFromLocal();
//            }
//        }.myexec();
//    }
//
//    /**
//     * 从asset中加载普通的推荐数据
//     */
//    private void loadOtherDataFromLocal() {
//        new MyAsyncTask<Void, Void, RecommendM>() {
//
//            @Override
//            protected RecommendM doInBackground(Void... params) {
//                if (mContext == null || getActivity() == null || getActivity().isFinishing()) {
//                    return null;
//                }
//
//                RecommendM result = new RecommendM();
//
//                String contentOfRecommend = FileUtil.readStrFromFile(new File(mContext
//                        .getCacheDir(), MD5.md5(UrlConstants.getInstanse()
//                        .getRecomments())).getAbsolutePath());
//                if (TextUtils.isEmpty(contentOfRecommend)) {
//                    contentOfRecommend = FileUtil.readAssetFileData(mContext,
//                            "recommend1.json");
//                }
//
//                if (!TextUtils.isEmpty(contentOfRecommend)) {
//                    try {
//                        result = new RecommendM(contentOfRecommend);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                return result;
//            }
//
//            protected void onPostExecute(RecommendM result) {
//                onPageLoadingCompleted(LoadCompleteType.OK);
//                mIsLoadedData = true;
//                if (result != null) {
//                    setRecommendDataForView(result);
//                }
//                loadHotAndGuess();
//                loadRecommendsFromNet();
//                loadSceneLivesFromNet();
//            }
//        }.myexec();
//    }
//
//    /**
//     * 本地听、发现新奇、猜你喜欢、热门推荐数据
//     */
//    private void loadHotAndGuess() {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put(HttpParamsConstants.PARAM_DEVICE, "android");
//        params.put(HttpParamsConstants.PARAM_VERSION, DeviceUtil.getVersion(mContext));
//        if (!TextUtils.isEmpty(SharedPreferencesUtil.getInstance(mContext).getString(AppConstants.LOCAL_CITY_CODE))) {
//            params.put(HttpParamsConstants.PARAM_CODE, SharedPreferencesUtil.getInstance(mContext).getString(AppConstants.LOCAL_CITY_CODE));
//        }
//        CommonRequestM.getDataWithXDCS("getHotAndGuess", params,
//                new IDataCallBackM<RecommendM>() {
//
//                    @Override
//                    public void onSuccess(RecommendM data, Headers header) {
//                        mHotGuessData = data;
//                        try {
//                            saveHotGuessDataToTemp(mHotGuessData);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        if (canUpdateUi()) {
//                            onPageLoadingCompleted(LoadCompleteType.OK);
//                            if (data != null) {
//                                loadRecommendAd();
//                                setHotDataForView(mHotGuessData);
////                                loadRecommendAd();
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onError(int code, String message) {
//                        onPageLoadingCompleted(LoadCompleteType.OK);
//                        Logger.e(TAG, "errorCode:" + code + "," + message);
//                    }
//                }, getView(), new View[]{
//                        mListView, mFocusPager, mFocusImageRoot, mSpecialContainer,
//                        mRecommendLayout, mDiscoveryLayout/*, mLiveEntryLayout */},
//                new Object[]{});
//    }
//
//    /**
//     * 小编推荐、焦点图、精品听单数据
//     */
//    private void loadRecommendsFromNet() {
//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put(HttpParamsConstants.PARAM_CHANNEL,
//                DeviceUtil.getUmengChannel(mContext));
//        params.put(HttpParamsConstants.PARAM_DEVICE, "android");
//        params.put(HttpParamsConstants.PARAM_VERSION,
//                DeviceUtil.getVersion(mContext));
//        params.put(HttpParamsConstants.PARAM_INCLUDE_ACTIVITY, "true");
//        params.put(HttpParamsConstants.PARAM_INCLUDE_SPECIAL, "true");
//        params.put(HttpParamsConstants.PARAM_SCALE, "2");
////        BuriedPoints bp = new BuriedPoints();
////        bp.setEvent("pageview/tab@发现_推荐");
////        ToolUtil.addBP2RP(bp, params);
//        CommonRequestM.getDataWithXDCS("getRecommends", params,
//                new IDataCallBackM<RecommendM>() {
//
//                    @Override
//                    public void onSuccess(RecommendM data, Headers header) {
////                        isFirstLoad = false;
//                        mRecomendData = data;
//                        if (canUpdateUi()) {
//                            onPageLoadingCompleted(LoadCompleteType.OK);
//                            if (data != null) {
//                                setRecommendDataForView(data);
//                                saveRecommentDataToTemp(data);
//                            }
////                            loadRecommendAd();
//                        }
//                    }
//
//                    @Override
//                    public void onError(int code, String message) {
//                        onPageLoadingCompleted(LoadCompleteType.OK);
//                        mListView.onRefreshComplete();
//                        Logger.e(TAG, "errorCode:" + code + "," + message);
//                    }
//                }, getView(), new View[]{
//                        mListView, mFocusPager, mFocusImageRoot, mSpecialContainer,
//                        mRecommendLayout, mDiscoveryLayout/*, mLiveEntryLayout */},
//                new Object[]{});
//    }
//
//    // 获取现场直播数据
//    private void loadSceneLivesFromNet() {
//        if (isLivesDataLoading) {
//            return;
//        }
//        isLivesDataLoading = true;
//        CommonRequestM.getRecommendSceneLiveList(null, new IDataCallBackM<RecommendSceneLiveList>() {
//            @Override
//            public void onSuccess(RecommendSceneLiveList object, Headers header) {
//                if (!canUpdateUi()) {
//                    return;
//                }
//                if (object == null || object.getList() == null || object.getList().isEmpty()) {
//                    return;
//                }
//                parseSceneLiveFocusImage(object.getList());
//                isLivesDataLoading = false;
//            }
//
//            @Override
//            public void onError(int code, String message) {
//                parseSceneLiveFocusImage(null);
//                isLivesDataLoading = false;
//            }
//        });
//    }
//
//
//    /**
//     * 推荐数据
//     *
//     * @param data
//     */
//    private void saveRecommentDataToTemp(final RecommendM data) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String content = new Gson().toJson(data);
//                if (!TextUtils.isEmpty(content)) {
//                    FileUtil.writeStr2File(content, new File(mContext.getCacheDir(),
//                            MD5.md5(UrlConstants.getInstanse().getRecomments()))
//                            .getAbsolutePath());
//                }
//            }
//        }).start();
//    }
//
//    /**
//     * 猜你喜欢等数据
//     *
//     * @param data
//     */
//    private void saveHotGuessDataToTemp(final RecommendM data) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String content = new Gson().toJson(data);
//                if (!TextUtils.isEmpty(content)) {
//                    FileUtil.writeStr2File(content, new File(mContext.getCacheDir(),
//                            MD5.md5(UrlConstants.getInstanse().getHotAndGuess()))
//                            .getAbsolutePath());
//                }
//            }
//        }).start();
//    }
//
//    private String getCoverPath(boolean isTrack, RecommendGridItemM item) {
//        return isTrack ? item.getCoverMiddle() : item.getCoverLarge();
//    }
//
//    @Override
//    public void setVisible(int containerId) {
//        View view = findViewById(containerId);
//        if (view != null) {
//            view.setVisibility(View.VISIBLE);
//        }
//    }
//
//    @Override
//    public void setGone(int containerId) {
//        if (mFooterView.indexOfChild(mBottomAdContainer) >= 0) {
//            mFooterView.removeView(mBottomAdContainer);
//        }
//    }
//
//
//    private boolean isPayItem(HotRecommendM data) {
//        return data.getCategoryId() == 33;
//    }
//
//    @Override
//    public void dynamicAddView(View view, List<DynamicAttr> pDAttrs) {
//        if(mIDynamicNewView == null){
//            throw new RuntimeException("IDynamicNewView should be implements !");
//        }else{
//            mIDynamicNewView.dynamicAddView(view, pDAttrs);
//        }
//    }
//
//    @Override
//    public void onThemeUpdate() {
//        if (mLastRecommendM != null) {
//            parseDiscoveryColumn(mLastRecommendM);
//        }
//    }
//
//    /**
//     * 推荐内容每一项的适配器
//     *
//     * @author hovi.yan
//     */
//    private class RecommendSectionAdapter extends BaseAdapter implements
//            OnClickListener {
//        private static final int TYPE_RECOMMEND = 0;
//        private static final int TYPE_RECOMMEND_AD = 1;
//        private List<Object> mList = new ArrayList<Object>();
//        private final Activity mCtx;
//        private final RecommendFragment mFragment;
//
//        public RecommendSectionAdapter(Activity ctx,
//                                       RecommendFragment fragment, List<Object> data) {
//            this.mList = data;
//            mCtx = ctx;
//            mFragment = fragment;
//        }
//
//        @Override
//        public int getCount() {
//            return mList == null ? 0 : mList.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return mList == null ? null : mList.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public int getItemViewType(int position) {
//            if (mList == null) {
//                return TYPE_RECOMMEND;
//            }
//            if (mList.get(position) instanceof ThirdAd) {
//                return TYPE_RECOMMEND_AD;
//            } else {
//                return TYPE_RECOMMEND;
//            }
//        }
//
//        @Override
//        public int getViewTypeCount() {
//            return 2;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (getItemViewType(position) == TYPE_RECOMMEND_AD) {
//                return getRecommendAdView(position, convertView);
//            } else {
//                return getRecommendView(position, convertView);
//            }
//        }
//
//        public View getRecommendAdView(int position, View convertView) {
//            AdViewHolder holder;
//            ThirdAd ad = (ThirdAd) mList.get(position);
//            if (convertView == null || !(convertView.getTag() instanceof AdViewHolder)) {
//                convertView = View.inflate(mCtx, R.layout.view_recommend_ad_section, null);
//                holder = new AdViewHolder();
//                holder.cover = (ImageView) convertView.findViewById(R.id.cover);
//                holder.border = convertView.findViewById(R.id.border_bottom);
//                LayoutParams lp = holder.cover.getLayoutParams();
//                int width = BaseUtil.getScreenWidth(mCtx)
//                        - BaseUtil.dp2px(mCtx, 20);
//                lp.height = width * 256 / 710;
//                lp.width = width;
//                holder.cover.setLayoutParams(lp);
//                holder.more = (TextView) convertView.findViewById(R.id.tv_more);
//                holder.more.setText("查看");
//                ((TextView) convertView.findViewById(R.id.tv_title)).setText(R.string.generalize);
//                holder.name = (TextView) convertView.findViewById(R.id.name);
//                holder.desc = (TextView) convertView.findViewById(R.id.desc);
//                View adtagImg = convertView.findViewById(R.id.ad_tag_img);
//                if (adtagImg != null) {
//                    adtagImg.setVisibility(View.VISIBLE);
//                }
//
//                holder.more.setOnClickListener(this);
//                holder.name.setOnClickListener(this);
//                holder.desc.setOnClickListener(this);
//                holder.cover.setOnClickListener(this);
//                convertView.setTag(holder);
//            } else {
//                holder = (AdViewHolder) convertView.getTag();
//            }
//            holder.more.setTag(ad);
//            holder.desc.setTag(ad);
//            holder.cover.setTag(ad);
//            holder.name.setTag(ad);
//            holder.border.setVisibility(View.VISIBLE);
//            mFragment.addImageViewInRecycleList(holder.cover,ad.getCover(),R.drawable.bg_ad_discover);
//            ImageManager.from(mCtx).displayImage(holder.cover, ad.getCover(), R.drawable.bg_ad_discover);
//            if (!TextUtils.isEmpty(ad.getName())) {
//                holder.name.setVisibility(View.VISIBLE);
//                holder.name.setText(ad.getName());
//            } else {
//                holder.name.setVisibility(View.GONE);
//            }
//            if (!TextUtils.isEmpty(ad.getDescription())) {
//                holder.desc.setVisibility(View.VISIBLE);
//                holder.desc.setText(ad.getDescription());
//            } else {
//                holder.desc.setVisibility(View.GONE);
//            }
//            return convertView;
//        }
//
//        public View getRecommendView(int position, View convertView) {
//            ViewHolder holder;
//            if (convertView == null) {
//                convertView = View.inflate(mCtx,
//                        R.layout.item_recommend_selection_horizontal, null);
//                holder = new ViewHolder();
//                holder.h1 = RecommendItemHolder.findView(convertView
//                        .findViewById(R.id.sect_1));
//                holder.h2 = RecommendItemHolder.findView(convertView
//                        .findViewById(R.id.sect_2));
//                holder.h3 = RecommendItemHolder.findView(convertView
//                        .findViewById(R.id.sect_3));
//                holder.title = (TextView) convertView
//                        .findViewById(R.id.tv_title);
//                holder.tags = (ImageView) convertView.findViewById(R.id.iv_tags_new);
//                holder.moreBtn = convertView.findViewById(R.id.layout_section_header);
//                holder.border = convertView.findViewById(R.id.border_bottom);
//                holder.moreBtn.setOnClickListener(mFragment);
//                resetLayoutWidthAndHeight(holder.h1, holder.h2, holder.h3, mCtx);
//                convertView.setTag(holder);
//            } else {
//                holder = (ViewHolder) convertView.getTag();
//            }
//
//            if (mList.get(position) != null && mList.get(position) instanceof HotRecommendM) {
//                HotRecommendM data = (HotRecommendM) mList.get(position);
//                if (null != data) {
//                    boolean isMemberData = data.isMemberData();
//                    int from = AlbumEventManage.FROM_RECOMMEND_ALBUM;
//                    holder.title.setText(data.getTitle() == null ? "" : data
//                            .getTitle());
//                    if (mFragment != null) {
//                        data.getList().get(0).setTrack(data.isTrack());
//                        data.getList().get(1).setTrack(data.isTrack());
//                        data.getList().get(2).setTrack(data.isTrack());
//                        mFragment.bindData(from, holder.h1,
//                                data.getList().get(0), data.getTitle(), "1", "" + data.getCategoryId(), true);
//                        mFragment.bindData(from, holder.h2,
//                                data.getList().get(1), data.getTitle(), "2", "" + data.getCategoryId(), true);
//                        mFragment.bindData(from, holder.h3,
//                                data.getList().get(2), data.getTitle(), "3", "" + data.getCategoryId(), true);
//                    }
//                    holder.moreBtn.setVisibility(View.VISIBLE);
//                    if (isMemberData) {
//                        holder.moreBtn.setTag(MORE_MEMBER);
//                    } else {
//                        holder.moreBtn.setTag(data);
//                    }
//                    holder.border.setVisibility(View.VISIBLE);
//                }
//            }
//
//
//            return convertView;
//        }
//
//        @Override
//        public void onClick(View v) {
//            if (OneClickHelper.getInstance().onClick(v)) {
//                if (v.getTag() instanceof ThirdAd && mCtx != null && mFragment != null && mFragment.canUpdateUi()) {
//                    AdManager.handlerAdClick(mContext, (ThirdAd) v.getTag(), AppConstants.AD_LOG_TYPE_SITE_CLICK, AppConstants.AD_POSITION_NAME_FIND_NATIVE);
//                }
//            }
//
//        }
//    }
//
//    private static class ViewHolder {
//        RecommendItemHolder h1;
//        RecommendItemHolder h2;
//        RecommendItemHolder h3;
//        TextView title;
//        View moreBtn, border;
//        ImageView tags;
//    }
//
//    private static class AdViewHolder {
//        ImageView cover;
//        TextView name, desc, more;
//        View border;
//    }
//
//    public static class RecommendItemHolder {
//        public ImageView tivCover, ivPlay, ivComplete;
//        public TextView tvDesc;
//        public TextView tvName;
//        public View content;
//
//        public View getView(Context context) {
//            View convertView = View.inflate(context, R.layout.item_recommend,
//                    null);
//            RecommendItemHolder holder = findView(convertView);
//            convertView.setTag(holder);
//            return convertView;
//        }
//
//        public static RecommendItemHolder findView(View view) {
//            RecommendItemHolder holder = new RecommendItemHolder();
//            holder.ivComplete = (ImageView) view
//                    .findViewById(R.id.iv_album_complete);
//            holder.tivCover = (ImageView) view.findViewById(R.id.tiv_cover);
//            holder.tvName = (TextView) view.findViewById(R.id.tv_name);
//            holder.tvDesc = (TextView) view.findViewById(R.id.tv_description);
//            holder.ivPlay = (ImageView) view.findViewById(R.id.iv_play);
//            holder.content = view;
//            return holder;
//        }
//    }
//
//    private void insertOrReplaceAd(List<Object> data, List<ThirdAd> feedAds) {
//        insertOrReplaceAd(data, feedAds, isRealVisable());
//    }
//
//    private void insertOrReplaceAd(List<Object> data, List<ThirdAd> feedAds, boolean statAd) {
//        if (data == null || data.size() <= 0) {
//            return;
//        }
//        if (feedAds != null && feedAds.size() > 0) {
////            ArrayList<FeedAd> ads = new ArrayList<FeedAd>();
//            for (ThirdAd ad : feedAds) {
//                if (ad.getPosition() >= 0) {
//                    if (ad.getPosition() == 0 && !data.isEmpty()) {
//                        if (data.get(ad.getPosition()) instanceof ThirdAd) {
//                            data.set(ad.getPosition(), ad);
//                        } else {
//                            data.add(ad.getPosition(), ad);
//                        }
//                    } else if (ad.getPosition() >= data.size()) {
//                        data.add(ad);
//                    } else {
//                        if (data.get(ad.getPosition() - 1) instanceof ThirdAd) {
//                            data.set(ad.getPosition() - 1, ad);
//                        } else {
//                            data.add(ad.getPosition() - 1, ad);
//                        }
//                    }
//                }
//            }
//
//            if (statAd) {
//                AdManager.batchAdRecord(mContext, feedAds, AppConstants.AD_LOG_TYPE_SITE_SHOW, AppConstants.AD_POSITION_NAME_FIND_NATIVE);
//            }
//            mAdapter.notifyDataSetChanged();
//        }
//    }
//
//    @Override
//    protected boolean setNoContentButtonVisiblity() {
//        return false;
//    }
//
//    @Override
//    protected void clickNoContentButton(View view) {
//
//    }
//
//    public void onRefresh() {
//        if (mListView != null) {
//            mListView.setRefreshing(true);
//        }
//    }
//}
