//package com.example.myapplication;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.graphics.Bitmap;
//import android.graphics.Color;
//import android.graphics.Rect;
//import android.graphics.drawable.AnimationDrawable;
//import android.graphics.drawable.BitmapDrawable;
//import android.media.AudioManager;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Build.VERSION;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.content.LocalBroadcastManager;
//import android.support.v4.view.ViewCompat;
//import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
//import android.text.Editable;
//import android.text.Html;
//import android.text.Spannable;
//import android.text.SpannableString;
//import android.text.Spanned;
//import android.text.TextPaint;
//import android.text.TextUtils;
//import android.text.style.ClickableSpan;
//import android.text.style.ForegroundColorSpan;
//import android.text.style.UnderlineSpan;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.view.ViewTreeObserver.OnGlobalLayoutListener;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.LinearInterpolator;
//import android.view.animation.RotateAnimation;
//import android.view.inputmethod.InputMethodManager;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.Button;
//import android.widget.FrameLayout;
//import android.widget.GridView;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.PopupWindow;
//import android.widget.RelativeLayout;
//import android.widget.ScrollView;
//import android.widget.SeekBar;
//import android.widget.SeekBar.OnSeekBarChangeListener;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.nineoldandroids.animation.Animator;
//import com.nineoldandroids.animation.AnimatorListenerAdapter;
//import com.nineoldandroids.animation.ValueAnimator;
//import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
//import com.nineoldandroids.view.ViewHelper;
//import com.ximalaya.ting.android.MainApplication;
//import com.ximalaya.ting.android.R;
//import com.ximalaya.ting.android.activity.MainActivity;
//import com.ximalaya.ting.android.activity.web.WebActivityNew;
//import com.ximalaya.ting.android.constants.AppConfigfConstants;
//import com.ximalaya.ting.android.constants.AppConstants;
//import com.ximalaya.ting.android.constants.BundleKeyConstants;
//import com.ximalaya.ting.android.constants.HttpParamsConstants;
//import com.ximalaya.ting.android.constants.PluginConstants;
//import com.ximalaya.ting.android.constants.UrlConstants;
//import com.ximalaya.ting.android.data.model.ad.AdCollectData;
//import com.ximalaya.ting.android.data.model.ad.AdShareData;
//import com.ximalaya.ting.android.data.model.album.AlbumM;
//import com.ximalaya.ting.android.data.model.category.CategoryM;
//import com.ximalaya.ting.android.data.model.comment.CommentModel;
//import com.ximalaya.ting.android.data.model.danmu.CommentBullet;
//import com.ximalaya.ting.android.data.model.device.DeviceItem;
//import com.ximalaya.ting.android.data.model.play.PlayingSoundInfo;
//import com.ximalaya.ting.android.data.model.play.PlayingSoundInfo.AlbumInfo;
//import com.ximalaya.ting.android.data.model.play.PlayingSoundInfo.CommentInfo;
//import com.ximalaya.ting.android.data.model.track.TrackM;
//import com.ximalaya.ting.android.data.model.user.LoginInfoModel;
//import com.ximalaya.ting.android.data.model.xdcs.BuriedPoints;
//import com.ximalaya.ting.android.data.model.xdcs.UserTracking;
//import com.ximalaya.ting.android.data.request.CommonRequestM;
//import com.ximalaya.ting.android.data.request.IDataCallBackM;
//import com.ximalaya.ting.android.fragment.BaseFragment2;
//import com.ximalaya.ting.android.fragment.custom.child.HistoryFragment;
//import com.ximalaya.ting.android.fragment.download.other.BatchActionFragment;
//import com.ximalaya.ting.android.fragment.find.other.category.CategoryContentFragment;
//import com.ximalaya.ting.android.fragment.find.other.recommend.ReportFragment;
//import com.ximalaya.ting.android.fragment.myspace.other.newscenter.TalkViewFragment;
//import com.ximalaya.ting.android.fragment.myspace.other.setting.AlarmSettingFragment;
//import com.ximalaya.ting.android.fragment.myspace.other.setting.PlanTerminateFragment;
//import com.ximalaya.ting.android.fragment.myspace.other.setting.PlanTerminateFragment.onTimerChangeListener;
//import com.ximalaya.ting.android.fragment.other.AdFragment;
//import com.ximalaya.ting.android.fragment.other.AdFragment.AdAction;
//import com.ximalaya.ting.android.fragment.other.ad.DanmuAdFragment;
//import com.ximalaya.ting.android.fragment.other.album.AlbumFragmentDetailIntro;
//import com.ximalaya.ting.android.fragment.other.album.AlbumFragmentNew;
//import com.ximalaya.ting.android.fragment.other.album.AlbumListFragment;
//import com.ximalaya.ting.android.fragment.other.album.MemberFragmentDetailIntro;
//import com.ximalaya.ting.android.fragment.other.comment.PostCommentFragment;
//import com.ximalaya.ting.android.fragment.other.share.ShareDanmuFragment;
//import com.ximalaya.ting.android.fragment.other.web.WebFragment;
//import com.ximalaya.ting.android.fragment.pay.BatchBuyResultDialogFragment;
//import com.ximalaya.ting.android.fragment.pay.BuyAlbumFragment;
//import com.ximalaya.ting.android.fragment.pay.PayDialogFragment;
//import com.ximalaya.ting.android.fragment.pay.PayMemberDialog;
//import com.ximalaya.ting.android.fragment.pay.PayResultSimpleDialogFragment;
//import com.ximalaya.ting.android.fragment.pay.RechargeFragment;
//import com.ximalaya.ting.android.fragment.play.other.CommentDialogFragment;
//import com.ximalaya.ting.android.fragment.play.other.CommentListFragment;
//import com.ximalaya.ting.android.framework.commoninterface.IHandleOk;
//import com.ximalaya.ting.android.framework.download.Downloader;
//import com.ximalaya.ting.android.framework.manager.ImageManager;
//import com.ximalaya.ting.android.framework.manager.XDCSCollectUtil;
//import com.ximalaya.ting.android.framework.util.BaseUtil;
//import com.ximalaya.ting.android.framework.util.CustomToast;
//import com.ximalaya.ting.android.framework.util.FragmentUtil;
//import com.ximalaya.ting.android.framework.util.FreeFlowUtil;
//import com.ximalaya.ting.android.framework.util.FreeFlowUtil.IProxyChange;
//import com.ximalaya.ting.android.framework.util.SerialInfo;
//import com.ximalaya.ting.android.framework.util.StringUtil;
//import com.ximalaya.ting.android.framework.view.SlideView;
//import com.ximalaya.ting.android.framework.view.dialog.DialogBuilder;
//import com.ximalaya.ting.android.framework.view.dialog.DialogBuilder.DialogCallback;
//import com.ximalaya.ting.android.framework.view.dialog.MenuDialog;
//import com.ximalaya.ting.android.framework.view.dialog.MyProgressDialog;
//import com.ximalaya.ting.android.listener.IDataChangeCallback;
//import com.ximalaya.ting.android.listener.IFragmentFinish;
//import com.ximalaya.ting.android.listener.ISimpleOnPlayerStatusUpdateListener;
//import com.ximalaya.ting.android.manager.account.UserInfoMannage;
//import com.ximalaya.ting.android.manager.ads.YaoyiYaoAdManage;
//import com.ximalaya.ting.android.manager.device.WiFiDeviceController;
//import com.ximalaya.ting.android.manager.pay.PayAction;
//import com.ximalaya.ting.android.manager.pay.PayManager;
//import com.ximalaya.ting.android.manager.pay.PayManager.PayCallback;
//import com.ximalaya.ting.android.manager.pay.PayManager.RechargeCallback;
//import com.ximalaya.ting.android.manager.pay.PayManager.TrackInfoCallBack;
//import com.ximalaya.ting.android.manager.plugin.PluginManageTool;
//import com.ximalaya.ting.android.manager.track.AlbumEventManage;
//import com.ximalaya.ting.android.manager.track.LikeTrackManage;
//import com.ximalaya.ting.android.manager.track.PlayFragmentManage;
//import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
//import com.ximalaya.ting.android.opensdk.model.PlayableModel;
//import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
//import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
//import com.ximalaya.ting.android.opensdk.model.album.Album;
//import com.ximalaya.ting.android.opensdk.model.album.SubordinatedAlbum;
//import com.ximalaya.ting.android.opensdk.model.track.Track;
//import com.ximalaya.ting.android.opensdk.player.XmPlayerManager;
//import com.ximalaya.ting.android.opensdk.player.advertis.IXmAdsStatusListener;
//import com.ximalaya.ting.android.opensdk.player.constants.PlayerConstants;
//import com.ximalaya.ting.android.opensdk.player.service.IXmPlayerStatusListener;
//import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode;
//import com.ximalaya.ting.android.opensdk.player.service.XmPlayerException;
//import com.ximalaya.ting.android.opensdk.util.Logger;
//import com.ximalaya.ting.android.opensdk.util.NetworkType;
//import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;
//import com.ximalaya.ting.android.util.ToolUtil;
//import com.ximalaya.ting.android.util.net.NetworkUtils;
//import com.ximalaya.ting.android.util.track.DownloadTools;
//import com.ximalaya.ting.android.util.track.PlayTools;
//import com.ximalaya.ting.android.util.track.RingtoneUtil;
//import com.ximalaya.ting.android.util.ui.EmotionUtil;
//import com.ximalaya.ting.android.util.ui.LocalImageUtil;
//import com.ximalaya.ting.android.util.ui.TimeHelper;
//import com.ximalaya.ting.android.util.ui.TipsUtil;
//import com.ximalaya.ting.android.util.ui.XmDanmakuController;
//import com.ximalaya.ting.android.util.xdcs.XDCSDataUtil;
//import com.ximalaya.ting.android.view.CallingRingtoneDownloadDialog;
//import com.ximalaya.ting.android.view.EmotionSelector;
//import com.ximalaya.ting.android.view.EmotionSelector.OnFocusChangeListener;
//import com.ximalaya.ting.android.view.EmotionSelector.OnSendButtonClickListener;
//import com.ximalaya.ting.android.view.EmotionSelector.OnTextChangeListener;
//import com.ximalaya.ting.android.view.ForbidableSeekBar;
//import com.ximalaya.ting.android.view.ImageViewer;
//import com.ximalaya.ting.android.view.NotifyingScrollView;
//import com.ximalaya.ting.android.view.NotifyingScrollView.OnScrollChangedListener;
//import com.ximalaya.ting.android.view.ShareDialog;
//import com.ximalaya.ting.android.view.adcontroller.AdManager;
//import com.ximalaya.ting.android.view.adcontroller.ThirdAdStatUtil;
//import com.ximalaya.ting.android.view.flowlayout.FlowLayout;
//import com.ximalaya.ting.android.view.richtext.OnImageClickListener;
//import com.ximalaya.ting.android.view.richtext.OnURLClickListener;
//import com.ximalaya.ting.android.view.richtext.RichText;
//
//import org.json.JSONObject;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Timer;
//import java.util.TimerTask;
//
//import master.flame.danmaku.controller.IDanmakuView;
//import okhttp3.Headers;
//
///**
// * 播放页面
// */
//public class PlayFragment extends BaseFragment2 implements OnClickListener,
//        IXmPlayerStatusListener, IXmAdsStatusListener, PayCallback,
//        RechargeCallback, IFragmentFinish, TrackInfoCallBack {
//
//    private Track mCurrTrack;
//    private TrackM mCurrTrackDetail;
//    private PlayingSoundInfo mPlayingInfo;
//
//    protected int mCoverHeight;
//    private int rangeOfTitleTransparent;//title透明的区域高度
//
//    protected static final String TAG = "PlayFragment";
//
//    private static final int MAX_NUM_OF_REWARDS = 6;
//    private static final int RECOMMEND_ALBUM_NUM = 3;
//    private static final int COMMENT_NUM = 5;
//
//    public static final int COMMENT_TYPE_SEND_COMMENT = 1; // 评论
//    public static final int COMMENT_TYPE_RELAY_COMMENT = 2; // 转采
//    public static final int COMMENT_TYPE_REPLY_COMMENT = 2; // 回复
//
//    private static final int MAX_COMMENT_CHAR_COUNT = 140;
//
//    private int mCommentType = COMMENT_TYPE_SEND_COMMENT;
//
//    private boolean mForbidProgressUpdate;
//    private Rect mScrollBounds;
//    private long mCommentStartTime = -1;
//
//    private PlaylistFragment mPlaylistFragment;
//    private PlanTerminateFragment mPlanTerminateFragment;
//
//    private long mParentId;
//
//    private PlayFragmentManage playFrgManage;
//
//    private boolean mIsSoundAdShowing;
//
//    // 弹幕
//    private IDanmakuView mDanmakuView;
//    private View mDanmakuMask;
//    private XmDanmakuController mDanmakuController;
//
//    Toast successToast;
//    Toast failToast;
//    private DanmuAdFragment danmuFragment;
//    private ShareDanmuFragment shareDanmuFragment;
//    public static boolean isPlayerFragManagerTiggerOnResume = false; // 是否是PlayerFragManagerment 触发的onResume方法
//    private Track tempTrack;
//    private ImageView moreButton;
//    private ImageView ivDownload;
//    private TextView tvLikeNum;
//    private ImageView ivLike;
//    private ImageView ivComment;
//    private TextView tvCommentNum;
//    private ImageView ivSmallAvatar;
//    private TextView tvAnchorName;
//    private View ivShowPopWindow;
//    private PopupWindow mPopupWindow;
//    private int popupViewHeight;
//    private int popupViewWidht;
//    private AudioManager audioManager;
//    private View adTag;
//    private View adLayout;
//    private String optionList;
//
//    @Override
//    protected void initUi(Bundle savedInstanceState) {
//        audioManager
//                = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
//        if (getArguments() != null) {
//            mBp = getArguments().getParcelable(BundleKeyConstants.KEY_BURIEDPOINT);
//        }
//        mContext = getActivity();
//        mCurrTrack = PlayTools.getCurTrack(mContext);
//        try {
//            mPlayingInfo = new Gson().fromJson(SharedPreferencesUtil.getInstance(mContext).getString("PlayingInfo"), PlayingSoundInfo.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            ;
//        }
//
//        successToast = Toast.makeText(mContext, R.string.add_download_success,
//                Toast.LENGTH_SHORT);
//        failToast = Toast.makeText(mContext, R.string.add_download_fail,
//                Toast.LENGTH_SHORT);
//
//
//        mAdYaoyiyaoBroadCast = new AdYaoyiYaoOverBroadcastReceiver();
//        LocalBroadcastManager.getInstance(mContext).registerReceiver(mAdYaoyiyaoBroadCast,
//                new IntentFilter(AdYaoyiYaoOverBroadcastReceiver.AD_YAOYIYAO_ACTION));
//        playFrgManage = new PlayFragmentManage(this);
//        findAllView();
//        calSoundCoverSize();
//        setListeners();
//
//        mCommentInputBar.hideEmotionPanel();
//        mCommentInputBar.shouldHandleFocusChangeEvent(false);
//
//        if (getActivity() != null
//                && getActivity().getApplicationContext() != null) {
//            mDanmakuController = new XmDanmakuController(getActivity(), mDanmakuView);
//        }
//
////        setDanmakuViewsHide();
//
//        if (mCurrTrack == null) {
//            showToastLong(getString(R.string.play_source_err));
//            finish();
//            return;
//        }
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        playFrgManage.myActivityResult(requestCode, resultCode, data, mCommentType);
//    }
//
//    private boolean headIsInited = false;    // 头部是否初始化完成
//
//    private boolean mIsLoading = false;
//
//    /**
//     * 加载歌曲的详细信息
//     */
//    private void loadSoundDetailData() {
//        headIsInited = false;
//        if (mCurrTrack != null && mCurrTrack.getAlbum() != null &&
//                !TextUtils.isEmpty(mCurrTrack.getAlbum().getAlbumTitle()) && canUpdateUi() && mAlbumEntranceLayout != null) {
//            headIsInited = true;
//            SubordinatedAlbum data = mCurrTrack.getAlbum();
//
//            mAlbumEntranceLayout.setVisibility(View.VISIBLE);
//
//            if (data.getCoverUrlSmall() != null && !data.getCoverUrlSmall().equals(mCurrTrack.getCoverUrlSmall()) || !NetworkType.isConnectTONetWork(mContext)) {
//                String url = !TextUtils.isEmpty(data.getCoverUrlSmall()) ? data.getCoverUrlSmall() : data.getCoverUrlMiddle();
//                ImageManager.from(mContext).displayImage(mAlbumPic, url, R.drawable.image_default_64);
//            }
//
//            mAlbumName.setText(data.getAlbumTitle());
//
//            mSubscribeInfo = AlbumInfo.toAlbumM(data);
//
//            mSubNumTx.setVisibility(View.VISIBLE);
//            mSubscribeImg.setVisibility(View.VISIBLE);
//            AlbumEventManage.setCollectImageClickAndStatus(this, mSubscribeImg, mSubscribeInfo,
//                    R.drawable.play_btn_collect, R.drawable.play_btn_collected, new AlbumEventManage.ICollect() {
//                        @Override
//                        public void success(boolean collect) {
//                            int favoritesCount = 0;
//                            if(mPlayingInfo != null && mPlayingInfo.countInfo != null && mPlayingInfo.albumInfo != null &&
//                                    mPlayingInfo.countInfo.albumSubscribes != null) {
//                                    favoritesCount = mPlayingInfo.countInfo.albumSubscribes.get(String.valueOf(mPlayingInfo.albumInfo.albumId));
//                                    if (collect)
//                                        favoritesCount += 1;
//                                    else
//                                        favoritesCount -= 1;
//                                        if(mPlayingInfo.trackInfo != null) {
//                                            new UserTracking().setSrcPage("track").setItem("track").
//                                                    setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                                    setItemId(mPlayingInfo.trackInfo.trackId).
//                                                    statIting(XDCSCollectUtil.APP_NAME_EVENT, collect ? XDCSCollectUtil.SERVICE_COLLECT : XDCSCollectUtil.SERVICE_UNCOLLECT);
//                                        }
//                                    mPlayingInfo.countInfo.albumSubscribes.put(String.valueOf(mPlayingInfo.albumInfo.albumId), favoritesCount);
//                                }
//                            if (favoritesCount > 0) {
//                                mSubNumTx.setText(StringUtil.getFriendlyNumStrAndCheckIsZero(favoritesCount, getString(R.string.num_people_sub)));
//                                mSubNumTx.setVisibility(View.VISIBLE);
//                            } else {
//                                mSubNumTx.setVisibility(View.GONE);
//                            }
//                        }
//
//                        @Override
//                        public void fail(String msg) {
//                            showToastShort(msg);
//                        }
//                    });
//
//            addImageViewInRecycleList(mCover, mCurrTrack.getCoverUrlLarge(), R.drawable.player_cover_default);
//            ImageManager.from(mContext).displayImage(mCover, mCurrTrack.getCoverUrlLarge(), R.drawable.player_cover_default);
//            mRichTextView.setText(null);
//
//            String avatar = mCurrTrack.getAnnouncer().getAvatarUrl();
//            String name = mCurrTrack.getAnnouncer().getNickname();
//            boolean isVerified = mCurrTrack.getAnnouncer().isVerified();
//            ImageManager.from(mContext).displayImage(ivSmallAvatar, avatar, R.drawable.default_avatar_60);
//            tvAnchorName.setText(name);
//            tvAnchorName.setCompoundDrawables(null, null, isVerified ? LocalImageUtil.getDrawable(mContext, R.drawable.ic_v_oranget) : null, null);
//            ivShowPopWindow.setVisibility(View.GONE);
//        }
//
//        if (mCurrTrack != null && NetworkType.isConnectTONetWork(getActivity())) {
//            if (mIsLoading) {
//                return;
//            }
//            mIsLoading = true;
//            setDefaultData(false);
//            statAd = false;
//            Map<String, String> params = new HashMap<String, String>();
//            params.put("device", "android");
//            params.put("trackId", mCurrTrack.getDataId() + "");
//            if (mCurrTrack.getAnnouncer() != null) {
//                params.put("trackUid", mCurrTrack.getAnnouncer().getAnnouncerId() + "");
//            }
//            if (mBp != null) {
//                ToolUtil.addBP2RP(mBp, params);
//            }
//
//            findViewById(R.id.float_bottom_bar).setVisibility(View.GONE);
//
//            CommonRequestM.getDataWithXDCS("getTrackInfoDetail", params,
//                    new IDataCallBackM<TrackM>() {
//                        @Override
//                        public void onSuccess(final TrackM object, Headers header) {
//                            mIsLoading = false;
//                            doAfterAnimation(new IHandleOk() {
//                                @Override
//                                public void onReady() {
//                                    setTrackMDetail(object);
//                                }
//                            });
//                        }
//
//                        @Override
//                        public void onError(int code, String message) {
//                            mIsLoading = false;
//                            doAfterAnimation(new IHandleOk() {
//                                @Override
//                                public void onReady() {
//                                    setTrackMDetail(null);
//                                }
//                            });
//                        }
//                    }, getContainerView(), new View[]{mCover,
//                            mAlbumPic, mRecommendAlbumSection,
//                            mCommentSection, mCommentContentView,
//                            mCommentInputBar, mPanelContainer, mMorePanel},
//                    new Object[]{});
//        } else {
//            setDefaultData(true);
//        }
//    }
//
//    /**
//     * 设置歌曲信息
//     *
//     * @param data
//     */
//    private void setTrackMDetail(TrackM data) {
//        if (!canUpdateUi()) {
//            return;
//        }
//        mCurrTrackDetail = data;
//        if (data == null) {
//            setDefaultData(true);
//            return;
//        }
//
//        // 加载页面的Info
//        loadPlayingInfoData(data.getDataId());
//
//        setPlayTitle();
//        String url = !TextUtils.isEmpty(data.getCoverUrlLarge()) ? data
//                .getCoverUrlLarge() : null;
//        addImageViewInRecycleList(mCover, url, R.drawable.player_cover_default);
//        ImageManager.from(mContext).displayImage(mCover, url, R.drawable.player_cover_default);
//
//        if (ivLike != null) {
//            ivLike.setSelected(data.isLike());
//            tvLikeNum.setText(data.getFavoriteCount() == 0 ? "" : StringUtil.getFriendlyNumStr(data.getFavoriteCount()));
//        }
//
//        if (mCurrTrackDetail != null && mPlayNumAndTime != null) {
//            if (mCurrTrackDetail.getPlayCount() == 0) {
//                mCurrTrackDetail.setPlayCount(1);
//            }
//            mPlayNumAndTime.setText(StringUtil.getFriendlyNumStrAndCheckIsZero(mCurrTrackDetail.getPlayCount(), getString(R.string.num_play)) + StringUtil.getFriendlyDataStr(mCurrTrackDetail.getCreatedAt()));
////			setAnchorNamMaxWidth();
//        }
//
//        ivDownload.setSelected(DownloadTools.isTrackDownloaded(data));
//    }
//
//
//    private void setAnchorNamMaxWidth() {
//        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mPlayAnchorName.getLayoutParams();
//        int width = mPlayAnchorName.getPaddingRight() + mPlayAnchorName.getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin;
//        int maxWidth = BaseUtil.getScreenWidth(mContext) - mPlayNumAndTime.getWidth() - 2 * BaseUtil.dp2px(mContext, 10) - BaseUtil.dp2px(mContext, 18) - width;
//        mPlayAnchorName.setMaxWidth(maxWidth);
//    }
//
//    private AdFragment bannerAdFragment;//底部banner广告
//    private AdFragment nativeAdFragment;//native广告
//    private AdFragment nativeAdRecommentAlbumFragment;// 推荐专辑插的广告 和native广告一样
//
//    private void initBottomAd(long trackId) {
//        if (getView() == null) {
//            return;
//        }
//
//        mAdContainer = (ViewGroup) getView().findViewById(
//                R.id.bottom_ad_container);
//        mAdContainer.removeAllViews();
//        mAdContainer.addView(LayoutInflater.from(mContext).inflate(
//                R.layout.view_ad_container, null));
//        bannerAdFragment = AdFragment.newInstance(
//                AdFragment.TYPE_PLAY_FRAGEMENT,
//                AppConstants.AD_POSITION_NAME_PLAY_COMMENT_TOP, trackId,
//                BaseUtil.getScreenWidth(mContext) * 190 / 640,
//                R.id.bottom_ad_container);
//        bannerAdFragment.setAction(new AdAction() {
//
//            @Override
//            public void setGone(int containerId) {
//                if (getView() != null) {
//                    getView().findViewById(containerId).setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void setVisible(int containerId) {
//                if (getView() != null) {
//                    getView().findViewById(containerId).setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        FragmentTransaction transaction = getChildFragmentManager()
//                .beginTransaction();
//        transaction.replace(R.id.layout_ad, bannerAdFragment);
//        transaction.commitAllowingStateLoss();
//    }
//
//    private void setPlayTitle() {
//        Track data = mCurrTrackDetail;
//        if (data == null) {
//            data = mCurrTrack;
//        }
//        if (data != null && !TextUtils.isEmpty(data.getTrackTitle())) {
//            mPlayTrackTitle.setText(data.getTrackTitle());
//            mPlayTrackTitle.setVisibility(View.VISIBLE);
//        } else {
//            mPlayTrackTitle.setVisibility(View.GONE);
//        }
//    }
//
//    private boolean statAd;
//
//    private void initNativeAd(long trackId) {
//        if (!canUpdateUi() || getView() == null) {
//            return;
//        }
//        mNativeAdContainer = (ViewGroup) getView().findViewById(R.id.native_ad_container);
//        mNativeAdContainer.removeAllViews();
//
//        mRecommendAdContainer = (ViewGroup) getView().findViewById(R.id.recommend_album_native_ad_container);
//        mRecommendAdContainer.removeAllViews();
//        nativeAdRecommentAlbumFragment = null;
//
//        mNativeAdContainer.addView(LayoutInflater.from(mContext).inflate(R.layout.view_nativead_container, null));
////		mNativeAdContainer.setVisibility(View.VISIBLE);
//        nativeAdFragment = AdFragment.newInstance(AdFragment.TYPE_PLAY_FRAGEMENT,
//                AppConstants.AD_POSITION_NAME_PLAY_NATIVE, trackId, LayoutParams.WRAP_CONTENT, R.id.native_ad_container);
//        nativeAdFragment.setAction(new AdAction() {
//
//            @Override
//            public void setGone(int containerId) {
//                if (getView() != null) {
//                    getView().findViewById(containerId).setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void setVisible(int containerId) {
//                if (getView() != null) {
//                    getView().findViewById(containerId).setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.replace(R.id.layout_native_ad, nativeAdFragment);
//        transaction.commitAllowingStateLoss();
//    }
//
//    private void initRecommedAlbumAd(long trackId) {
//        if (getView() == null) {
//            return;
//        }
//
//        mRecommendAdContainer = (ViewGroup) getView().findViewById(R.id.recommend_album_native_ad_container);
//        mRecommendAdContainer.removeAllViews();
//
//        mNativeAdContainer = (ViewGroup) getView().findViewById(R.id.native_ad_container);
//        mNativeAdContainer.removeAllViews();
//        nativeAdFragment = null;
//
//        mRecommendAdContainer.addView(LayoutInflater.from(mContext).inflate(R.layout.view_nativead_container, null));
////		mRecommendAdContainer.setVisibility(View.VISIBLE);
//        nativeAdRecommentAlbumFragment = AdFragment.newInstance(AdFragment.TYPE_PLAY_FRAGEMENT,
//                AppConstants.AD_POSITION_NAME_PLAY_NATIVE, trackId, LayoutParams.WRAP_CONTENT,
//                R.id.recommend_album_native_ad_container);
//        nativeAdRecommentAlbumFragment.setAction(new AdAction() {
//
//            @Override
//            public void setGone(int containerId) {
//                if (getView() != null) {
//                    getView().findViewById(containerId).setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void setVisible(int containerId) {
//                if (getView() != null) {
//                    getView().findViewById(containerId).setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.replace(R.id.layout_native_ad, nativeAdRecommentAlbumFragment);
//        transaction.commitAllowingStateLoss();
//    }
//
//    private void loadADData(long trackId) {
//        initBottomAd(trackId);
//    }
//
//    /**
//     * 加载当前页的信息
//     *
//     * @param trackId
//     */
//    private void loadPlayingInfoData(final long trackId) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("device", "android");
//        String addString = "";
//        if (trackId > 0) {
//            params.put("trackId", trackId + "");
//            addString = "/" + trackId;
//        } else {
//            params.put("trackId", mCurrTrack.getDataId() + "");
//            addString = "/" + mCurrTrack.getDataId();
//        }
//
//        CommonRequestM.getDataWithXDCS(
//                "getPlayPageInfo",
//                params,
//                new IDataCallBackM<PlayingSoundInfo>() {
//                    @Override
//                    public void onSuccess(PlayingSoundInfo data, Headers header) {
//                        setLoadingViewStatue(0);
//                        if (!canUpdateUi() || mHintUse3DBtn == null) {
//                            return;
//                        }
//                        if (data == null) {
//                            Log.e(TAG, "get playing sound info is null");
//                            mPlayingInfo = null;
//                            SharedPreferencesUtil.getInstance(mContext).saveString("PlayingInfo", new Gson().toJson(mPlayingInfo));
//                            requestPageInfoIsOk(false);
//                            return;
//                        }
//
//                        requestPageInfoIsOk(true);
//
//                        mPlayingInfo = data;
//                        SharedPreferencesUtil.getInstance(mContext).saveString("PlayingInfo", new Gson().toJson(mPlayingInfo));
//                        setupHeaderSection(data);
//                        setupTrackInfoSection(data);
//                        setupRichInfoSelect(data);
//                        setupAnchorSection(data);
//                        setupRecommendAlbumsSection(data);
//                        setupCommentSection(data);
//                        setupDanmaku(data);
//                        loadADData(trackId);
//
//                        if (data.albumInfo != null && !TextUtils.isEmpty(data.albumInfo.tags)) {
//                            boolean show3D = data.albumInfo.tags.contains(getString(R.string.third_dwonderful))
//                                    && !MainActivity.hasShow3DHintList.contains(data.trackInfo.trackId)
//                                    && !audioManager.isWiredHeadsetOn();
//                            mHintUse3DBtn.setVisibility(show3D ? View.VISIBLE : View.GONE);
//                            if (data.albumInfo.tags.contains(getString(R.string.third_dwonderful))) {
//                                MainActivity.hasShow3DHintList.add(data.trackInfo.trackId);
//                                mHintUse3DBtn.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        mActivity.runOnUiThread(new Runnable() {
//                                            @Override
//                                            public void run() {
//                                                mHintUse3DBtn.setVisibility(View.GONE);
//                                            }
//                                        });
//                                    }
//                                }, 3000);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onError(int code, String message) {
//                        if (!canUpdateUi()) {
//                            return;
//                        }
//                        requestPageInfoIsOk(false);
//                        setLoadingViewStatue(2);
//                    }
//                }, getContainerView(), new View[]{},
//                new Object[]{addString});
//
//    }
//
//    /**
//     * 设置弹幕的数据
//     */
//    private void setupDanmaku(PlayingSoundInfo data) {
//        if (mDanmakuController == null) {
////            setDanmakuViewsHide();
//            return;
//        }
//
//        if (data == null || data.trackInfo == null) {
//            mDanmakuBtn.setVisibility(View.VISIBLE);
//            setDanmakuViewsState(false);
//            return;
//        }
//
//        if (data.trackInfo.bulletSwitchType == 3) {
////            setDanmakuViewsHide();
//            return;
//        }
//
//        // mDanmakuSwitchBtn.setVisibility(View.VISIBLE);
//        mDanmakuBtn.setVisibility(View.VISIBLE);
//        if (NetworkType.isConnectToWifi(mContext)) {
//            if (SharedPreferencesUtil.getInstance(mContext).getBoolean(
//                    AppConfigfConstants.SHOW_DANMAKU_ALREADY_SET, false)) {
//                setDanmakuViewsState(SharedPreferencesUtil
//                        .getInstance(mContext).getBoolean(
//                                AppConfigfConstants.SHOW_DANMAKU_DEFAULT));
//            } else {
//                if (VERSION.SDK_INT < 14) {
//                    setDanmakuViewsState(false);
//                    return;
//                }
//                if (data.trackInfo.bulletSwitchType == 2) {
//                    setDanmakuViewsState(false);
//                } else if (data.trackInfo.bulletSwitchType == 1) {
//                    setDanmakuViewsState(true);
//                } else {
//                    setDanmakuViewsState(false);
//                }
//            }
//
//        } else {
//            setDanmakuViewsState(false);
//        }
//    }
//
//    /**
//     * 设置弹幕的状态
//     */
//    private void setDanmakuViewsState(boolean enable) {
//        if (mDanmakuController != null) {
//            mDanmakuController.setEnabled(enable);
//            // mDanmakuSwitchBtn.setCheckedNoFireEvent(enable);
//            mDanmakuBtn.setSelected(enable);
//            mDanmakuMask.setVisibility(enable ? View.VISIBLE : View.GONE);
//            mDanmakuView.setVisibility(enable ? View.VISIBLE : View.GONE);
//
//            if (XmPlayerManager.getInstance(mContext).isPlaying()) {
//                if (mCurrTrack != null) {
//                    mDanmakuController.reset(mCurrTrack.getDataId(),
//                            PlayTools.getPlayCurrentPosition(mContext), false);
//                }
//            }
//        } else {
//            mDanmakuMask.setVisibility(View.GONE);
//            mDanmakuView.setVisibility(View.GONE);
//            // mDanmakuSwitchBtn.setCheckedNoFireEvent(false);
//            mDanmakuBtn.setSelected(false);
//        }
//    }
//
////    /**
////     * 设置弹幕隐藏
////     */
////    private void setDanmakuViewsHide() {
////        if (mDanmakuController != null) {
////            mDanmakuController.setEnabled(false);
////        }
////
////        if (mDanmakuMask != null) {
////            mDanmakuMask.setVisibility(View.GONE);
////            mDanmakuBtn.setSelected(false);
////            mDanmakuBtn.setVisibility(View.INVISIBLE);
////            mSendDanumuBtn.setText(R.string.send_common);
////        }
////    }
//
//    public int getResId(String name, String defType) {
//        return mContext.getResources().getIdentifier(name, defType,
//                mContext.getPackageName());
//    }
//
//    /**
//     * 设置评论列表
//     */
//    private void setupCommentSection(PlayingSoundInfo data) {
//
//        if (data.commentInfo != null && data.commentInfo.list != null
//                && data.commentInfo.list.size() > 0) {
//
//            ((TextView) mCommentSection.findViewById(R.id.header_info))
//                    .setText(getString(R.string.listener_comment, StringUtil.getFriendlyNumStr(data.commentInfo.totalCount)));
//            tvCommentNum.setText(StringUtil.getFriendlyNumStr(data.commentInfo.totalCount));
//            ivComment.setSelected(true);
//            mCommentContentView.setVisibility(View.VISIBLE);
//            mCommentSection.setVisibility(View.VISIBLE);
//            mNoCommentLayout.setVisibility(View.GONE);
//
//            int commendCount = Math.min(data.commentInfo.list.size(), COMMENT_NUM);
//
//            for (int i = 0; i < commendCount; i++) {
//                final PlayingSoundInfo.CommentInfo info = data.commentInfo.list
//                        .get(i);
//                int item_id, cover_id, name_id, content_id, time_id, likeCount_id, likeBtn_id;
//
//                int index = i + 1;
//                item_id = getResId("comment_item_" + index, "id");
//                cover_id = getResId("user_icon_" + index, "id");
//                name_id = getResId("user_name_" + index, "id");
//                content_id = getResId("comment_content_" + index, "id");
//                time_id = getResId("comment_time_" + index, "id");
//                likeCount_id = getResId("like_count_" + index, "id");
//                likeBtn_id = getResId("like_btn_" + index, "id");
//
//                View item = mCommentSection.findViewById(item_id);
//                ImageView cover = (ImageView) mCommentSection
//                        .findViewById(cover_id);
//                TextView name = (TextView) mCommentSection
//                        .findViewById(name_id);
//                TextView content = (TextView) mCommentSection
//                        .findViewById(content_id);
//                TextView time = (TextView) mCommentSection
//                        .findViewById(time_id);
//                TextView likeCount = (TextView) mCommentSection
//                        .findViewById(likeCount_id);
//                ImageButton likeBtn = (ImageButton) mCommentSection
//                        .findViewById(likeBtn_id);
//
//                item.setVisibility(View.VISIBLE);
//
//                if (!TextUtils.isEmpty(info.smallHeader)) {
////					addImageViewInRecycleList(cover,info.smallHeader,LocalImageUtil.getRandomHeadPortrait(),R.drawable.head_bg_playing);
//                    ImageManager.from(mContext).displayImage(cover,
//                            info.smallHeader, LocalImageUtil
//                                    .getRandomHeadPortrait());
//                } else {
//                    cover.setImageResource(LocalImageUtil
//                            .getRandomHeadPortrait());
//                    // cover.setBackgroundResource(LocalImageUtil.getRandomHeadPortrait());
//                }
//                name.setText(info.nickname);
//                content.setText(EmotionUtil.getInstance().convertEmotion(
//                        info.content));
//                time.setText(StringUtil.getFriendlyTimeStr(info.createdAt));
//                likeCount.setText(StringUtil.getFriendlyNumStr(info.likes));
//                likeBtn.setSelected(info.liked);
//
//                final int position = i;
//                final ImageButton btn = likeBtn;
//                final TextView txt = likeCount;
//
//                likeCount.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        btn.performClick();
//                    }
//                });
//
//                likeBtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        playFrgManage.CommlikeClick(txt, btn, info);
//                    }
//                });
//
//                item.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        clickCommentItem(info, position, v);
//                    }
//                });
//
//                cover.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        clickCommentItem(info, position, v);
//                    }
//                });
//            }
//
//            if (data.commentInfo.list.size() < COMMENT_NUM) {
//                for (int i = COMMENT_NUM; i > data.commentInfo.list.size(); i--) {
//                    View item = mCommentSection.findViewById(getResId(
//                            "comment_item_" + i, "id"));
//                    item.setVisibility(View.GONE);
//                }
//            }
//
//            mMoreComment
//                    .setVisibility(data.commentInfo.totalCount > COMMENT_NUM ? View.VISIBLE
//                            : View.GONE);
//            mMoreComment.setOnClickListener(this);
//        } else {
//            ((TextView) mCommentSection.findViewById(R.id.header_info))
//                    .setText("听众点评");
//            tvCommentNum.setText("");
//            ivComment.setSelected(false);
//            mCommentContentView.setVisibility(View.GONE);
//            mNoCommentLayout.setVisibility(View.VISIBLE);
//        }
//    }
//
//    /**
//     * 设置推荐专辑列表
//     */
//    private void setupRecommendAlbumsSection(PlayingSoundInfo data) {
//
//        if (!canUpdateUi() || mRecommendAlbumSection == null || data == null || mCurrTrack == null)
//            return;
//
//        if (data.associationAlbumsInfo != null
//                && data.associationAlbumsInfo.length > 0) {
//            initRecommedAlbumAd(mCurrTrack.getDataId());
//            mRecommendAlbumSection.setVisibility(View.VISIBLE);
//
//            mRecommendAlbumTagContainer.removeAllViews();
//            mRecommendAlbumTagContainer.setVisibility(View.VISIBLE);
//            if (!TextUtils.isEmpty(data.albumInfo.tags)) {
//                String[] tags = data.albumInfo.tags.split(",");
//                for (int i = 0; i < tags.length; i++) {
//                    TextView tagText = playFrgManage.createTagText(tags[i], ""
//                            + data.trackInfo.trackId);
//
//                    FlowLayout.LayoutParams lp = new FlowLayout.LayoutParams(
//                            FlowLayout.LayoutParams.WRAP_CONTENT,
//                            FlowLayout.LayoutParams.WRAP_CONTENT);
//
//                    if (i != 0) {
//                        lp.leftMargin = BaseUtil.dp2px(mContext, 10);
//                    }
//                    mRecommendAlbumTagContainer.addView(tagText, lp);
//                }
//            } else {
//                mRecommendAlbumTagContainer.removeAllViews();
//                mRecommendAlbumTagContainer.setVisibility(View.GONE);
//            }
//            int recommendCount = Math.min(data.associationAlbumsInfo.length,
//                    RECOMMEND_ALBUM_NUM);
//            for (int i = 0; i < recommendCount; i++) {
//                int item_id, divider_id, cover_id, name_id, content_id, playCount_id, trackCount_id, albumTag_id, albumPrice_id, albumDiscountPrice_id, score_id;
//
//                final int index = i + 1;
//                item_id = getResId("album_item_" + index, "id");
//                divider_id = getResId("divider" + index, "id");
//                cover_id = getResId("album_cover_" + index, "id");
//                name_id = getResId("album_name_" + index, "id");
//                content_id = getResId("update_at_" + index, "id");
//                playCount_id = getResId("sound_play_count_" + index, "id");
//                trackCount_id = getResId("track_count_" + index, "id");
//                albumTag_id = getResId("album_tag_" + index, "id");
//                albumPrice_id = getResId("tv_album_price_" + index, "id");
//                albumDiscountPrice_id = getResId("tv_album_discountprice_" + index, "id");
//                score_id = getResId("score_" + index, "id");
//                View item = mRecommendAlbumSection.findViewById(item_id);
//                View divider = mRecommendAlbumSection.findViewById(divider_id);
//                ImageView cover = (ImageView) mRecommendAlbumSection
//                        .findViewById(cover_id);
//                TextView name = (TextView) mRecommendAlbumSection
//                        .findViewById(name_id);
//                TextView content = (TextView) mRecommendAlbumSection
//                        .findViewById(content_id);
//                TextView playCount = (TextView) mRecommendAlbumSection
//                        .findViewById(playCount_id);
//                TextView trackCount = (TextView) mRecommendAlbumSection
//                        .findViewById(trackCount_id);
//                TextView albumPrice = (TextView) mRecommendAlbumSection.findViewById(albumPrice_id);
//                TextView albumDiscountPrice = (TextView) mRecommendAlbumSection.findViewById(albumDiscountPrice_id);
//                TextView score = (TextView) mRecommendAlbumSection.findViewById(score_id);
//                ImageView albumTag = (ImageView) mRecommendAlbumSection.findViewById(albumTag_id);
//                item.setVisibility(View.VISIBLE);
//                final PlayingSoundInfo.AssociationAlbumsInfo info = data.associationAlbumsInfo[i];
//                if (info != null) {
//                    String url = TextUtils.isEmpty(info.coverMiddle) ? info.coverSmall
//                            : info.coverMiddle;
//                    addImageViewInRecycleList(cover, url, R.drawable.image_default_145, R.drawable.bg_album_cover);
//                    ImageManager
//                            .from(getActivity())
//                            .displayImage(cover, url,
//                                    R.drawable.image_default_145);
//                    albumTag.setVisibility(info.isPaid() ? View.VISIBLE : View.GONE);
//                    final String albumId = "" + info.albumId;
//                    name.setText(info.title);
//                    content.setText(info.intro);
//                    long playCounts = 0L;
//                    long trackCounts = 0L;
//                    if (data.countInfo != null && data.countInfo.albumPlays != null && data.countInfo.albumPlays.containsKey(String
//                            .valueOf(info.albumId))) {
//                        playCounts = data.countInfo.albumPlays.get(String
//                                .valueOf(info.albumId));
//                    }
//                    if (data.countInfo != null && data.countInfo.albumTracks != null && data.countInfo.albumTracks.containsKey(String
//                            .valueOf(info.albumId))) {
//                        trackCounts = data.countInfo.albumTracks.get(String
//                                .valueOf(info.albumId));
//                    }
//                    playCount.setText(StringUtil.getFriendlyNumStr(playCounts));
//
//                    trackCount.setText(getString(R.string.episode, StringUtil.getFriendlyNumStr(trackCounts)));
//                    item.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(final View v) {
//
//                            if (info == null)
//                                return;
//                            final BuriedPoints bp = new BuriedPoints();
//
//                            bp.setPage("track@" + mCurrTrack.getDataId());
//                            bp.setTitle("声音相关推荐");
//                            bp.setEvent("pageview/album@" + albumId);
//                            bp.setPosition("" + index);
//                            AlbumEventManage.judgeAlbumType(info.albumId, getActivity(), v, bp, AlbumEventManage.FROM_UNDEFINED,
//                                    ConstantsOpenSdk.PLAY_FROM_ALBUM_RECOMMEND, new IHandleOk() {
//                                        @Override
//                                        public void onReady() {
//                                            startFragment(AlbumFragmentNew.newInstance(
//                                                    info.title, info.recSrc, info.recTrack,
//                                                    info.albumId,
//                                                    AlbumEventManage.FROM_UNDEFINED,
//                                                    ConstantsOpenSdk.PLAY_FROM_ALBUM_RECOMMEND,
//                                                    bp, -1), v);
//                                        }
//                                    });
//                            //埋点开始
//                            if (mCurrTrack != null)
//                                new UserTracking().setSrcPage("track").setSrcPageId(mCurrTrack.getDataId()).
//                                        setSrcModule("相关推荐").
//                                        setItem("相关推荐").
//                                        statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW);
//                            //埋点结束
//
//                        }
//                    });
//                }
//
////				if (recommendCount - 1 != i) {
////					LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) divider
////							.getLayoutParams();
////					lp.leftMargin = BaseUtil.dp2px(mContext, 10);
////					divider.setLayoutParams(lp);
////				}
//                if (divider != null) {
//                    if (index != RECOMMEND_ALBUM_NUM) {
//                        divider.setVisibility(View.VISIBLE);
//                    } else {
//                        divider.setVisibility(data.associationAlbumsInfo.length < RECOMMEND_ALBUM_NUM ? View.GONE
//                                : View.VISIBLE);
//                    }
//                }
//            }
//
//            mMoreRecommendAlbum.setVisibility(data.associationAlbumsInfo.length < RECOMMEND_ALBUM_NUM ? View.GONE : View.VISIBLE);
//            mMoreRecommendAlbum.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mCurrTrack != null) {
//                        startFragment(AlbumListFragment
//                                .newInstanceCommentAlbumByTrackId(
//                                        mCurrTrack.getDataId(), null), v);
//                        new UserTracking().setSrcPage("track").setSrcPageId(mCurrTrack.getDataId()).
//                                setSrcModule("相关推荐").
//                                setItem("相关推荐").
//                                setSrcTitle("更多").
//                                statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW);
//                    }
//                }
//            });
//        } else {
//            initNativeAd(mCurrTrack.getDataId());
//            mRecommendAlbumSection.setVisibility(View.GONE);
//        }
//    }
//
//    /**
//     * 初始化 标题栏
//     */
//    private void setupHeaderSection(final PlayingSoundInfo data) {
//        if (!canUpdateUi() || data == null || mAlbumEntranceLayout == null)
//            return;
//
//        if (data.albumInfo != null) {
//            mAlbumEntranceLayout.setVisibility(View.VISIBLE);
//
//            String url = !TextUtils.isEmpty(data.albumInfo.coverMiddle) ? data.albumInfo.coverMiddle
//                    : data.albumInfo.coverLarge;
//            ImageManager.from(mContext).displayImage(mAlbumPic, url, R.drawable.image_default_64);
//            if (data.albumInfo != null && data.albumInfo.title != null && mAlbumName != null) {
//                mAlbumName.setText(data.albumInfo.title);
//            }
//
//            mSubscribeInfo = AlbumInfo.toAlbumM(data);
//
//            if (mSubscribeImg != null) {
//                mSubscribeImg.setVisibility(View.VISIBLE);
//                AlbumEventManage.setCollectImageClickAndStatus(this, mSubscribeImg, mSubscribeInfo,
//                        R.drawable.play_btn_collect, R.drawable.play_btn_collected, new AlbumEventManage.ICollect() {
//                            @Override
//                            public void success(boolean collect) {
//                                int favoritesCount = 0;
//                                if(mPlayingInfo != null && mPlayingInfo.albumInfo != null && mPlayingInfo.countInfo != null && mPlayingInfo.countInfo.albumSubscribes != null ) {
//                                     favoritesCount = mPlayingInfo.countInfo.albumSubscribes.get(String.valueOf(mPlayingInfo.albumInfo.albumId));
//                                    if (collect)
//                                        favoritesCount += 1;
//                                    else
//                                        favoritesCount -= 1;
//                                    if(mPlayingInfo.trackInfo != null) {
//                                        new UserTracking().setSrcPage("track").setItem("track").
//                                                setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                                setItemId(mPlayingInfo.trackInfo.trackId).
//                                                statIting(XDCSCollectUtil.APP_NAME_EVENT, collect ? XDCSCollectUtil.SERVICE_COLLECT : XDCSCollectUtil.SERVICE_UNCOLLECT);
//                                    }
//                                    mPlayingInfo.countInfo.albumSubscribes.put(String.valueOf(mPlayingInfo.albumInfo.albumId), favoritesCount);
//                                }
//                                if (favoritesCount > 0) {
//                                    mSubNumTx.setText(StringUtil.getFriendlyNumStrAndCheckIsZero(favoritesCount, getString(R.string.num_people_sub)));
//                                    mSubNumTx.setVisibility(View.VISIBLE);
//                                } else {
//                                    mSubNumTx.setVisibility(View.GONE);
//                                }
//                            }
//
//                            @Override
//                            public void fail(String msg) {
//                                showToastShort(msg);
//                            }
//                        });
//            }
//
//            if (mSubNumTx != null) {
//                if (data.countInfo != null && data.albumInfo != null && data.countInfo.albumSubscribes != null && data.countInfo.albumSubscribes.get(String.valueOf(data.albumInfo.albumId)) > 0) {
//                    int favoritesCount = data.countInfo.albumSubscribes.get(String.valueOf(data.albumInfo.albumId));
//                    mSubNumTx.setText(StringUtil.getFriendlyNumStrAndCheckIsZero(favoritesCount, getString(R.string.num_people_sub)));
//                    mSubNumTx.setVisibility(View.VISIBLE);
//                } else {
//                    mSubNumTx.setVisibility(View.GONE);
//                }
//            }
//
//        } else if (!headIsInited) {
//            mAlbumEntranceLayout.setVisibility(View.GONE);
//        }
//    }
//
//    @Override
//    protected void loadData() {
//        loadSoundDetailData();
//    }
//
//    @Override
//    public int getContainerLayoutId() {
//        return R.layout.fra_play;
//    }
//
//    @Override
//    public void onClick(final View v) {
//        switch (v.getId()) {
//            case R.id.no_comment_layout:
//                mCommentType = COMMENT_TYPE_SEND_COMMENT;
//                prepareComment();
//                showCommentInputBar();
//                break;
//
//            case R.id.back_btn:
//                finishFragment();
//                break;
//
//            case R.id.next:
//                PlayTools.playNext(mContext);
//                break;
//            case R.id.previous:
//                PlayTools.playPre(mContext);
//                break;
//
//            case R.id.iv_play_status:
//            case R.id.play_pause:
//            /*
//             * WiFi设备控制
//			 */
//                if (isPlayWithDevice()) {
//                    if (mPlayPauseBtn.getContentDescription().equals("暂停")) {
//                        WiFiDeviceController.pause(mContext);
//                        setPlayPauseBtnStatus(false);
//                    } else {
//                        WiFiDeviceController.play(mContext);
//                        setPlayPauseBtnStatus(true);
//                    }
//                }
//
//                if (!XmPlayerManager.getInstance(mContext).isPlaying()) {
//                    if (checkAndShowPay(true)) {
//                        showToastShortCoverLast(R.string.bug_tip_word);
//                        return;
//                    }
//                }
//
//                PlayTools.playOrPause(mContext);
//                if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                    new UserTracking().setSrcPage("track").setItem("track").
//                            setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                            setItemId(mPlayingInfo.trackInfo.trackId).
//                            statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAUSE);
//                }
//                break;
//
//            case R.id.header_owner_info_section:    // 跳转到所属专辑
//                if (mPlayingInfo != null && mPlayingInfo.albumInfo != null) {
//                    if (mPlayingInfo.albumInfo.isPaid && mPlayingInfo.albumInfo.priceTypeId == 2) {
//                        AlbumEventManage.judgeAlbumType(mPlayingInfo.albumInfo.albumId, getActivity(), v, null, AlbumEventManage.FROM_ALBUM_BELONG,
//                                ConstantsOpenSdk.PLAY_FROM_TAB_ALBUM, new IHandleOk() {
//                                    @Override
//                                    public void onReady() {
//                                        startFragment(
//                                                AlbumFragmentNew.newInstance(
//                                                        mPlayingInfo.albumInfo.title,
//                                                        mPlayingInfo.albumInfo.albumId,
//                                                        AlbumEventManage.FROM_ALBUM_BELONG,
//                                                        ConstantsOpenSdk.PLAY_FROM_TAB_ALBUM), v);
//                                    }
//                                });
//
//                    } else {
//                        startFragment(
//                                AlbumFragmentNew.newInstance(
//                                        mPlayingInfo.albumInfo.title,
//                                        mPlayingInfo.albumInfo.albumId,
//                                        AlbumEventManage.FROM_ALBUM_BELONG,
//                                        ConstantsOpenSdk.PLAY_FROM_TAB_ALBUM), v);
//                    }
//                    if (mPlayingInfo.trackInfo != null) {
//                        new UserTracking().setSrcPage("track").setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                setSrcModule("专辑条").setItem("album").setItemId(mPlayingInfo.albumInfo.albumId).
//                                statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW);
//                    }
//                }
//                break;
//
//            case R.id.playlist:// 播放列表
//                gotoPlaylistFragment(v);
//                if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                    new UserTracking().setSrcPage("track").
//                            setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                            statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_OPEN_PLAYLIST);
//                }
//                break;
//
//            case R.id.dismiss:// pannel 取消
//                hideMoreOperationPanel();
//                break;
//
//            case R.id.next_img: // title_更多
//                toggleMoreOperationPanel();
//                if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                    new UserTracking().setSrcPage("track").
//                            setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                            statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_SHOW_MORE);
//                }
//                break;
//
//            case R.id.time_off: // pannel 定时关闭
//                timingShutdown();
//                if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                    new UserTracking().setSrcPage("track").
//                            setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                            statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_TIME_CLOSE);
//                }
//                break;
//
//            case R.id.share_img:
//                showShareDialog(mCurrTrack, v);
//                if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                    new UserTracking().setSrcPage("track").setSrcPageId(mCurrTrack.getDataId()).
//                            setEventGroup("share").
//                            setType("share").
//                            statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_SHOW_SHARE_PLATFORM);
//                }
//                break;
//
//                case R.id.forward_btn: // 快进
//                    stepUp(false);
//                    if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                        new UserTracking().setSrcPage("track").setItem("track").
//                                setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                setItemId(mPlayingInfo.trackInfo.trackId).
//                                statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_FORWARD);
//                    }
//                    break;
//
//                case R.id.backward_btn:
//                    stepUp(true);
//                    if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                        new UserTracking().setSrcPage("track").setItem("track").
//                                setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                setItemId(mPlayingInfo.trackInfo.trackId).
//                                statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_BACKWARD);
//                    }
//                    break;
//
//                case R.id.send_danmu_btn:
//                    if (checkAndShowPay(false)) {
//                        showToastShortCoverLast(mDanmakuBtn.isSelected() ? R.string.pay_success_can_danmu : R.string.pay_success_can_common);
//                        return;
//                    }
//
//                    if (UserInfoMannage.hasLogined()) {
//                        prepareComment();
//                        mCommentType = COMMENT_TYPE_SEND_COMMENT;
//                        mCommentInputBar.setHint(getString(R.string.wirte_you_common));
//                        showCommentInputBar();
//                    } else {
//                        isGoToLogin = true;
//                        UserInfoMannage.gotoLogin(getActivity());
//                    }
//                    break;
//
//                case R.id.sound_cover: {
//                    if (mForwardRewindArea.getVisibility() == View.GONE) {
//                        showForBackwardWidget();
//                    } else {
//                        hideForBackwardWidget();
//                    }
//                    break;
//                }
//                case R.id.pop_to_reward: // 跳转到打赏
//                    if (mPopupWindow.isShowing())
//                        mPopupWindow.dismiss();
//                    if (mCurrTrackDetail != null) {
//                        HashMap<String, String> xdcsParams = new HashMap<String, String>();
//                        xdcsParams.put("anchorid", mCurrTrackDetail.getAnnouncer()
//                                .getAnnouncerId() + "");
//                        xdcsParams.put("trackid", mCurrTrackDetail.getDataId() + "");
//                        xdcsParams.put("albumid", mCurrTrackDetail.getAlbum()
//                                .getAlbumId() + "");
//                        XDCSCollectUtil.getInstanse(
//                                getActivity().getApplicationContext()).statIting(
//                                XDCSCollectUtil.APP_NAME_DASHANG,
//                                XDCSCollectUtil.SERVICE_DASHANG_CLICK, xdcsParams);
//                    }
//                    if (UserInfoMannage.hasLogined()) {
//                        if (mCurrTrackDetail != null) {
//                            ((MainApplication) mContext.getApplicationContext()).flagWXPay = PayAction.PAY_TYPE_DASHANG;
//                            long payerId = UserInfoMannage.getInstance().getUser()
//                                    .getUid();
//                            Intent intent2 = new Intent(this.getActivity(),
//                                    WebActivityNew.class);
//                            String url2 = UrlConstants.getInstanse().getHybridHost()
//                                    + "ting-shang-mobile-web/1/user/rewardSelect?payerId="
//                                    + payerId + "&" + "payeeId="
//                                    + mCurrTrackDetail.getUid() + "&trackId="
//                                    + mCurrTrack.getDataId();
//                            intent2.putExtra(BundleKeyConstants.KEY_EXTRA_URL, url2);
//                            this.startActivity(intent2);
//                            if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                                new UserTracking().setSrcPage("track").setItem("track").
//                                        setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                        setItemId(mPlayingInfo.trackInfo.trackId).
//                                        setEventGroup("reward").
//                                        statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_REWARD);
//                            }
//                        }
//                    } else {
//                        isGoToLogin = true;
//                        playFrgManage.goToLogin();
//                    }
//                    break;
//                case R.id.playpage_icon_comment:
//                case R.id.more_commend_album:
//                    if (mCurrTrack != null) {
//                        startFragment(
//                                CommentListFragment.newInstance(mCurrTrack.getDataId()), v);
//                        if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                            new UserTracking().setSrcPage("track").
//                                    setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                    setSrcModule("我要评论").
//                                    setItem("声音评论页").
//                                    statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW);
//                        }
//                    }
//                    break;
//                case R.id.tv_comment_entry:
//                    if (UserInfoMannage.hasLogined()) {
//                        startFragment(
//                                CommentListFragment.newInstance(mCurrTrack.getDataId(), true), v);
//                    } else {
//                        isGoToLogin = true;
//                        UserInfoMannage.gotoLogin(getActivity());
//                    }
//                    break;
//                case R.id.close_ad_cover:
//                    if (mSoundAd != null) {
//                        hideSoundAdCover(true);
//
//                        if (mSoundAd.getSoundType() == Advertis.TYPE_YAOYIYAO) {
//                            loadDanmuAdIcon(mSoundAd);
//                        }
//                    }
//                    break;
//                case R.id.reload_info:
//                    if (NetworkType.isConnectTONetWork(getActivity())) {
//                        loadSoundDetailData();
//                    } else {
//                        if (getActivity() != null) {
//                            showToastShort(R.string.networkexeption_toast);
//                        }
//                    }
//                    break;
//                case R.id.ad_cover:
//                    adCoverClick();
//                    break;
//                case R.id.freeflow:
//                    if (mActivity == null) {
//                        return;
//                    }
//                    if (FreeFlowUtil.getInstance().isOrderFlowPackage()) {
//                        new DialogBuilder(mActivity)
//                                .setMessage(R.string.yet_free_flow).setOkBtn(R.string.know)
//                                .showWarning();
//                    } else {
//                        FreeFlowUtil.getInstance().clickFreeFlowXDCS(2);
//                        ToolUtil.gotoOrderPage(mContext);
//                    }
//                    break;
//                case R.id.hint_erji:
//                    if (mActivity == null) {
//                        return;
//                    }
//
//                    new DialogBuilder(mActivity).setMessage(R.string.support_third_headset)
//                            .setOkBtn(R.string.know).showWarning();
//                    break;
//                case R.id.play_anchor_name:
//                case R.id.pop_to_anchorspace:
//                    if (mPopupWindow != null && mPopupWindow.isShowing())
//                        mPopupWindow.dismiss();
//                    gotoAnchorDetail(v);
//                    break;
//                case R.id.look_all:
//                    if (mCurrTrackDetail != null) {
//                        startFragment(
//                                PlayingSoundDetailFragment.newInstance(mCurrTrackDetail), v);
//                    } else {
//                        showToastShort(R.string.loading_data);
//                    }
//                    break;
//                case R.id.playpage_icon_download:
//                    if (checkAndShowPay(false)) {
//                        showToastShortCoverLast(R.string.pay_success_can_down);
//                        return;
//                    }
//                    if (DownloadTools.isTrackDownloaded(mCurrTrack)) {
//                        showToastShort(R.string.track_has_downloaded);
//                        return;
//                    }
//                    ivDownload.setSelected(true);
//                    if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                        new UserTracking().setEventGroup("download").setItem("track").setItemId(mPlayingInfo.trackInfo.trackId).setSrcPage("track").setSrcPageId(mPlayingInfo.trackInfo.trackId).statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_START_DOWNLOAD);
//                    }
//                    downloadSound(v);
//                    break;
//                case R.id.iv_small_avatar:
//                case R.id.float_bottom_bar:
//                case R.id.iv_show_pop_window:
//                    if (mPopupWindow != null && !mPopupWindow.isShowing()) {
//                        mPopupWindow.showAsDropDown(ivShowPopWindow, -1 * popupViewWidht + BaseUtil.dp2px(mContext, 50), -1 * (popupViewHeight + BaseUtil.dp2px(mContext, 58)));
//                        if(mPlayingInfo != null && mPlayingInfo.trackInfo != null && mPlayingInfo.userInfo != null) {
//                            new UserTracking().setItem("user").setItemId(mPlayingInfo.userInfo.uid).
//                                    setSrcPage("track").setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                    setOptionList(optionList).
//                                    statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_OPEN_ANCHOR_ACTION);
//                        }
//                    }
//                    break;
//                case R.id.pop_to_chat://聊天
//                    if (mPopupWindow.isShowing())
//                        mPopupWindow.dismiss();
//
//                    if (!UserInfoMannage.hasLogined()) {
//                        UserInfoMannage.gotoLogin(mActivity);
//                        return;
//                    }
//
//                    Bundle bundle = new Bundle();
//                    bundle.putString("title", mPlayingInfo.userInfo.nickname);
//                    bundle.putLong("toUid", mPlayingInfo.userInfo.uid);
//
//                    String mobileSmallLogo = UserInfoMannage.getInstance().getUser()
//                            .getMobileSmallLogo();
//                    String smallLogo = UserInfoMannage.getInstance().getUser()
//                            .getSmallLogo();
//
//                    bundle.putString("meHeadUrl",
//                            TextUtils.isEmpty(mobileSmallLogo) ? smallLogo
//                                    : mobileSmallLogo);
//                    TalkViewFragment.sendPrivateMessage(getActivity(), bundle);
//                    if(mPlayingInfo != null && mPlayingInfo.trackInfo != null && mPlayingInfo.userInfo != null) {
//                        new UserTracking().setSrcPage("track").setItem("user").
//                                setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                setItemId(mPlayingInfo.userInfo.uid).
//                                statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_CHAT);
//                    }
//                    break;
//                case R.id.pop_to_ask://热线问答
//                    if (mPopupWindow.isShowing())
//                        mPopupWindow.dismiss();
//                    if (UserInfoMannage.hasLogined()) {
//                        Intent intent = new Intent(this.getActivity(),
//                                WebActivityNew.class);
//                        intent.putExtra(BundleKeyConstants.KEY_EXTRA_URL, UrlConstants.getInstanse().getAnchorHotLine(mCurrTrackDetail.getUid()));
//                        this.startActivity(intent);
//                        if(mPlayingInfo != null && mPlayingInfo.trackInfo != null && mPlayingInfo.userInfo != null) {
//                            new UserTracking().setItem("user").setItemId(mPlayingInfo.userInfo.uid).setSrcPage("track").setSrcPageId(mPlayingInfo.trackInfo.trackId).setSrcModule("问答").statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_ASK_ANCHOR);
//                        }
//                    } else {
//                        UserInfoMannage.gotoLogin(mActivity);
//                    }
//                    break;
//
//                case R.id.playpage_icon_like:
//                    LikeTrackManage.toLikeOrUnLike(mCurrTrackDetail, null,
//                            getActivity(), likeDataCallBack);
//                    if(mPlayingInfo != null&& mPlayingInfo.trackInfo != null && mCurrTrackDetail != null) {
//                        new UserTracking().setItem("track").setItemId(mPlayingInfo.trackInfo.trackId).setSrcPage("track").setSrcPageId(mPlayingInfo.trackInfo.trackId).statIting(XDCSCollectUtil.APP_NAME_EVENT, mCurrTrackDetail.isLike() ? XDCSCollectUtil.SERVICE_UNLIKE : XDCSCollectUtil.SERVICE_LIKE);
//                    }
//                    break;
//                default:
//                    break;
//            }
//    }
//
//    private boolean checkAndShowPay(boolean isCheckAudition) {
//        Track track = getCurrTrackByPlayer();
//        if (track != null && (track.isPayTrack() && !track.isAuthorized() && (isCheckAudition ? !track.isAudition() : true))) {
//            return true;
//        }
//        return false;
//    }
//
//    private void gotoAnchorDetail(View v) {
//        // 跳转到主播页面
//        if (mCurrTrackDetail != null && mCurrTrackDetail.getUid() > 0) {
//            playFrgManage.gotoHomePage(mCurrTrackDetail.getUid(), v);
//        } else if (mCurrTrack != null && mCurrTrack.getAnnouncer() != null
//                && mCurrTrack.getAnnouncer().getAnnouncerId() > 0) {
//            playFrgManage.gotoHomePage(mCurrTrack.getAnnouncer().getAnnouncerId(), v);
//        }
//    }
//
//    private void gotoCategoryDetail(View view) {
//        if (mCurrTrackDetail != null && mCurrTrackDetail.getCategoryId() > 0) {
//            gotoCategoryById(mCurrTrackDetail.getCategoryId(), mCurrTrackDetail.getCategoryName(), view);
//        } else if (mPlayingInfo != null && mPlayingInfo.albumInfo != null && mPlayingInfo.albumInfo.categoryId > 0) {
//            gotoCategoryById((int) mPlayingInfo.albumInfo.categoryId, mPlayingInfo.albumInfo.categoryName, view);
//        }
//    }
//
//    private void gotoCategoryById(int id, String categoryName, View view) {
//        startFragment(CategoryContentFragment.newInstance(id, categoryName, CategoryM.TRACK, null, null), view);
//    }
//
//    private void showShareDialog(Track trackM, View view) {
//        if (trackM != null) {
//            new UserTracking().setSrcPage("track").setSrcPageId(trackM.getDataId()).
//                    setEventGroup("share").
//                    setType("share").
//                    statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_SHOW_SHARE_PLATFORM);
//            new ShareDialog(getActivity(), trackM, view).show();
//        }
//    }
//
//    private void doSetCallingRingtone() {
//        SharedPreferencesUtil settings = SharedPreferencesUtil
//                .getInstance(mContext);
//        long ringtoneTrackId = settings
//                .getLong(AppConfigfConstants.CALLING_RINGTONE_TRACKID);
//        settings.saveBoolean(AppConfigfConstants.NEW_FEATURE_RINGTONE_USED,
//                true);
//        if (mCurrTrackDetail == null)
//            return;
//
//        if (ringtoneTrackId == mCurrTrackDetail.getDataId()) {
//            File file = new File(AppConstants.INTERNAL_RINGTONE_DIR,
//                    String.valueOf(ringtoneTrackId) + ".mp3");
//
//            if (file.exists() == false)
//                doStartDownloadRingtone();
//
//            if (file.exists() == false) {
//                doStartDownloadRingtone();
//            } else {
//                String name = "";
//                if (mCurrTrackDetail.getAnnouncer() != null)
//                    name = mCurrTrackDetail.getAnnouncer().getNickname();
//                String path = Uri.fromFile(file).toString();
//                RingtoneUtil.setMyRingtone(getActivity(), path, RingtoneUtil
//                        .buildMediaInfo(mCurrTrackDetail.getTrackTitle(),
//                                getString(R.string.xm_ring), name));
//                Logger.log("MyRingtone file:" + file.getAbsolutePath()
//                        + " name:" + name);
//                Logger.log("MyRingtone file path:" + path);
//
//            }
//
//        } else {
//            doStartDownloadRingtone();
//        }
//    }
//
//    private void doStartDownloadRingtone() {
//        if (mCurrTrackDetail != null) {
//            CallingRingtoneDownloadDialog processDlg = new CallingRingtoneDownloadDialog(
//                    getActivity());
//            processDlg.setDownloadInfo(mCurrTrackDetail);
//            processDlg.show();
//        }
//    }
//
//    /**
//     * 步进
//     */
//    private void stepUp(boolean flag) {
//        int duration = XmPlayerManager.getInstance(mContext).getDuration();
//        int pos = XmPlayerManager.getInstance(mContext).getPlayCurrPositon()
//                + (flag ? (-15 * 1000) : (15 * 1000));
//
//        if (pos < 0) {
//            pos = 0;
//        }
//
//        pos = pos > duration ? duration : pos;
//        XmPlayerManager.getInstance(mContext).seekTo(pos);
//
//        if (mDanmakuController != null && mCurrTrack != null) {
//            mDanmakuController.seekTo((int) pos);
//            mDanmakuController.reset(mCurrTrack.getDataId(),
//                    PlayTools.getPlayCurrentPosition(mContext), false);
//        }
//
//        postHideFloatControlWidgetTask();
//    }
//
//    private IDataCallBackM<Boolean> likeDataCallBack = new IDataCallBackM<Boolean>() {
//        @Override
//        public void onSuccess(Boolean object, Headers header) {
//            if (!object) {
//                return;
//            }
//
//            boolean paramFavorite = mCurrTrackDetail == null ? false
//                    : !(mCurrTrackDetail.isLike());
//            showToastShort(paramFavorite ? R.string.like_success
//                    : R.string.unlike_success);
//
//            if (mCurrTrackDetail != null) {
//                Downloader.getInstance(getActivity()).updateFavorited(
//                        mCurrTrackDetail.getDataId(), paramFavorite, true);
//            }
//
//            if (canUpdateUi()) {
//                ivLike.setSelected(paramFavorite);
//
//                onSoundLiked(paramFavorite);
//
//                int count = 0;
//                if (mCurrTrackDetail != null) {
//                    count = mCurrTrackDetail.getFavoriteCount();
//                }
//
//                if (count == 0 && paramFavorite) {
//                    tvLikeNum.setText(1 + "");
//                } else if ((count == 0 || count == 1) && !paramFavorite) {
//                    tvLikeNum.setText("");
//                } else {
//                    tvLikeNum.setText(StringUtil.getFriendlyNumStr(count));
//                }
//
//                if (paramFavorite && playFrgManage != null && mCurrTrack != null) {
//                    playFrgManage.showMoreBtnTip(PlayFragment.this, mShareBtn, mCurrTrack);
//                }
//            }
//        }
//
//        @Override
//        public void onError(int code, String message) {
//            showToastShortCoverLast(message);
//        }
//    };
//
//    public void onSoundLiked(boolean isLiked) {
//        if (mContext == null || null == mCurrTrackDetail) {
//            return;
//        }
//
//        mCurrTrackDetail.setLike(isLiked);
//        mCurrTrackDetail.setFavoriteCount(isLiked ? (mCurrTrackDetail
//                .getFavoriteCount() + 1)
//                : (mCurrTrackDetail.getFavoriteCount() - 1));
//
//        XmPlayerManager.getInstance(mContext).updateTrackInPlayList(
//                mCurrTrackDetail);
//    }
//
//    private void postHideFloatControlWidgetTask() {
//        if (getView() != null) {
//            getView().removeCallbacks(mHideFloatControlWidgetRunnable);
//            getView().postDelayed(mHideFloatControlWidgetRunnable, 5000);
//        }
//    }
//
//    private boolean isSearching = false;// 标记是否在搜索过程中，如果是，可直接将搜索结果显示
//
//    private List<DeviceItem> devices;
//    private MenuDialog mDeviceMenuDialog;
//
//    private boolean mIsPlayWithDevice = false;
//    private String mPlayingUUID = "";
//
//    private IDataChangeCallback<Boolean> deviceStopListener;
//
//    private void wifiPlay() {
//
//        PluginManageTool.getInstanse().installPlugin(
//                PluginConstants.SMARTDEVICE_FILE_NAME, mActivity,
//                PluginConstants.SMARTDEVICE_PACKAGE_NAME,
//                PluginConstants.SMARTDEVICE_VERSION_NAME,
//                getString(R.string.initializing), new IHandleOk() {
//
//                    @Override
//                    public void onReady() {
//                        try {
//                            startActivity(new Intent()
//                                    .setClassName(
//                                            PluginConstants.SMARTDEVICE_PACKAGE_NAME,
//                                            PluginConstants.SMARTDEVICE_EMPTY_CLASS_NAME)
//                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        searchWifiDevices();
//                        if (deviceStopListener == null) {
//                            deviceStopListener = new IDataChangeCallback<Boolean>() {
//                                @Override
//                                public void change(Boolean obj) {
//                                    change2Bendi(true);
//                                }
//                            };
//                        }
//                        WiFiDeviceController.getInstance(mContext)
//                                .addDeviceStopListener(deviceStopListener);
//
//                    }
//                });
//    }
//
//    private void searchWifiDevices() {
//
//        if (!canUpdateUi())
//            return;
//
//        showToastShort(getString(R.string.search_wifi_devices));
//        devices = new ArrayList<DeviceItem>();
//        isSearching = true;
//        // 开始搜索
//        WiFiDeviceController.search(mContext);
//        WiFiDeviceController.getInstance(mContext).addDeviceChangeListener(
//                new IDataChangeCallback<Boolean>() {
//                    @Override
//                    public void change(Boolean obj) {
//                        Logger.d(TAG, "change IN");
//                        devices.clear();
//                        devices.addAll(WiFiDeviceController
//                                .getDevices(mContext));
//                        if (isPlayWithDevice()) {
//                            boolean validDevice = false;
//                            for (DeviceItem device : devices) {
//                                if (device.getUUID().equals(mPlayingUUID)) {
//                                    validDevice = true;
//                                    break;
//                                }
//                            }
//                            if (!validDevice) {
//                                CustomToast.showToast(WiFiDeviceController.WARNING_LOST_DEVICE);
//                                change2Bendi(false);
//                            }
//                        }
//                        if (devices.size() > 0 && isSearching) {
//                            openDeviceMenu();
//                        }
//                    }
//                });
//        Timer searchTimer = new Timer();
//        TimerTask searchTask = new TimerTask() {
//            @Override
//            public void run() {
//                WiFiDeviceController.stopSearch(mContext);
//                isSearching = false;
//            }
//        };
//        searchTimer.schedule(searchTask, 60000);
//        // 获取当前已经存在的设备
//        devices.addAll(WiFiDeviceController.getDevices(mContext));
//        if (devices.size() > 0 && isSearching) {
//            try {
//                searchTask.cancel();
//                searchTimer.cancel();
//                openDeviceMenu();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            if (isPlayWithDevice()) {
//                CustomToast.showToast(WiFiDeviceController.WARNING_LOST_DEVICE);
//                change2Bendi(false);
//            }
//        }
//    }
//
//    private void openDeviceMenu() {
//        if (devices == null || devices.size() == 0) {
//            showToastShort(R.string.no_device);
//        }
//
//        ArrayList<String> names = new ArrayList<String>();
//        int playingPosition = -1;
//
//        for (int i = 0; i < devices.size(); i++) {
//            // names.add(new String(devices.get(i).getDevice().getDetails()
//            // .getFriendlyName().getBytes("iso-8859-1")));
//            names.add(devices.get(i).getName());
//            if (isPlayWithDevice()) {
//                if (mPlayingUUID.equals(devices.get(i).getUUID())) {
//                    playingPosition = i;
//                }
//            }
//        }
//        names.add("本机");
//        if (mDeviceMenuDialog == null) {
//            mDeviceMenuDialog = new MenuDialog(mActivity, names,
//                    AppConstants.isPad, new OnItemClickListener() {// 每一条的名称
//                @Override
//                public void onItemClick(AdapterView<?> adapterView,
//                                        View view, final int position, long id) {
//                    // devices.size比names.size少一，所以此处不要-1
//                    if (mDeviceMenuDialog != null && position > (mDeviceMenuDialog.getSelections()
//                            .size() - 1) || position < 0) {
//                        return;
//                    }
//                    if (mDeviceMenuDialog != null) {
//                        mDeviceMenuDialog.showListNewIcon(position);
//                        mDeviceMenuDialog.dismiss();
//                    }
//                    // TingMediaPlayer.getTingMediaPlayer(mContext).mediaplayer
//                    // .setVolume(0.0f, 0.0f);
//                    if (mDeviceMenuDialog.getSelections().size() - 1 == position) {
//                        change2Bendi(false);
//                        return;
//                    } else {
//                        if (position < devices.size()) {
//                            // freshDeviceBtn();
//                        }
//                    }
//                    Timer timer = new Timer();
//                    timer.schedule(new TimerTask() {
//                        public void run() {
//                            mActivity.runOnUiThread(new Runnable() {
//
//                                @Override
//                                public void run() {
//                                    PlayTools.pause(mContext);
//                                    PlayTools.setDLNAState(mContext,
//                                            true);
//                                    new Thread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            try {
//                                                Thread.sleep(1000);
//                                            } catch (InterruptedException e) {
//                                                e.printStackTrace();
//                                            }
//                                            mActivity
//                                                    .runOnUiThread(new Runnable() {
//                                                        @Override
//                                                        public void run() {
//                                                            PlayTools
//                                                                    .play(mContext);
//                                                        }
//                                                    });
//                                        }
//                                    }).start();
//                                    if (position >= 0
//                                            && position < devices
//                                            .size()) {
//                                        mPlayingUUID = devices.get(
//                                                position).getUUID();
//                                        if (WiFiDeviceController
//                                                .pushVoice(mContext,
//                                                        mPlayingUUID)) {
//                                            mIsPlayWithDevice = true;
//                                        }
//                                    } else {
//                                        change2Bendi(false);
//                                    }
//
//                                }
//
//                            });
//
//                        }
//                    }, 500);// delay=2000毫秒 后执行该任务
//
//                }
//            }, MenuDialog.TYPE_WIFI) {
//                @Override
//                protected void onStop() {
//                    WiFiDeviceController.stopSearch(mContext);
//                    isSearching = false;
//                    super.onStop();
//                }
//            };
//        } else {
//            mDeviceMenuDialog.setSelections(names);
//            if (isPlayWithDevice()) {
//                if (playingPosition != -1) {
//                    mDeviceMenuDialog.showListNewIcon(playingPosition);
//                } else {
//                    CustomToast.showToast(R.string.disconnect_device);
//                    change2Bendi(false);
//                }
//            }
//        }
//        mDeviceMenuDialog.setHeaderTitle(getString(R.string.choose_device));
//        mDeviceMenuDialog.show();
//        if (!isPlayWithDevice()) {
//            List<String> namesTemp = mDeviceMenuDialog.getSelections();
//            if (namesTemp != null && namesTemp.size() > 0) {
//                mDeviceMenuDialog.showListNewIcon(namesTemp.size() - 1);
//            }
//        }
//    }
//
//    /**
//     * change2Bendi:(这里用一句话描述这个方法的作用)
//     *
//     * @param @param needPause 切换到本地后是否需要暂停
//     * @param @param isFromDevice 是否是来自设备的通知
//     */
//    public void change2Bendi(final boolean needPause) {
//        Logger.d("tuisong", "change2Bendi:" + needPause);
//        PlayTools.setRecordModel(mContext, null);
//        PlayTools.setDLNAState(mContext, false);
//        PlayTools.pause(mContext);
//        isSearching = false;
//        if (devices != null) {
//            devices.clear();
//        }
//        mIsPlayWithDevice = false;
//        mPlayingUUID = "";
//        WiFiDeviceController.stop(mContext);
//
//        if (mActivity == null) {
//            mActivity = getActivity();
//        }
//        if (mActivity == null)
//            return;
//        mActivity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//
//                if (mDeviceMenuDialog != null) {
//                    List<String> selectiongs = mDeviceMenuDialog
//                            .getSelections();
//                    if (selectiongs == null) {
//                        mDeviceMenuDialog.showListNewIcon(0);
//                    } else {
//                        mDeviceMenuDialog.showListNewIcon(selectiongs.size());
//                    }
//
//                }
//                if (needPause) {
//                } else {
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                Thread.sleep(1000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            if (mActivity == null) {
//                                mActivity = getActivity();
//                            }
//                            if (mActivity == null)
//                                return;
//                            mActivity.runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    PlayTools.play(mContext);
//                                }
//                            });
//                        }
//                    }).start();
//
//                }
//            }
//        });
//
//    }
//
//    private boolean isPlayWithDevice() {
//        return mIsPlayWithDevice;
//    }
//
//    private Timer mTimer;
//    private long leftTime;
//    private IXmPlayerStatusListener mPlayerStatusCallback;
//
//    private void timingShutdown() {
////		if (mPlanTerminateFragment == null)
////			mPlanTerminateFragment = new PlanTerminateFragment();
//        if (mPlanTerminateFragment == null && getChildFragmentManager() != null) {
//            mPlanTerminateFragment = (PlanTerminateFragment) getChildFragmentManager().findFragmentByTag("PlanTerminalFragment");
//        }
//        if (mPlanTerminateFragment == null) {
//            mPlanTerminateFragment = new PlanTerminateFragment();
//        }
//        if (mPlanTerminateFragment.isAdded())
//            return;
//        mPlanTerminateFragment.show(getChildFragmentManager(), "PlanTerminateFragment");
////		Bundle args = new Bundle();
////		mPlanTerminateFragment.setArguments(args);
//        mPlanTerminateFragment
//                .setOnTimerChangeListener(new onTimerChangeListener() {
//
//                    @Override
//                    public void timerStopListener(boolean isStop) {
//                        if (isStop) {
//                            if (mTimer != null) {
//                                mTimer.cancel();
//                                mTimer = null;
//                                updateTimer(-1);
//                            }
//
//                            if (mPlayerStatusCallback != null) {
//                                XmPlayerManager.getInstance(mContext)
//                                        .removePlayerStatusListener(
//                                                mPlayerStatusCallback);
//                                mPlayerStatusCallback = null;
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void timerStartListener(long time, boolean isLiving) {
//                        if (isLiving) {
//                            updateLivingTimer();
//                        } else {
//                            updateTimer(time);
//                        }
//                    }
//
//                });
////		ft.add(R.id.fra_container, mPlanTerminateFragment);
////		ft.addToBackStack(null);
////		ft.commitAllowingStateLoss();
//    }
//
//    private void updateLivingTimer() {
//        SharedPreferencesUtil settings = SharedPreferencesUtil
//                .getInstance(mContext);
//        final boolean isStopTiming = settings.getBoolean(
//                ConstantsOpenSdk.PLAN_PLAY_STOP_SWITCH, true);
//        if (!isStopTiming) {
//            mTimeOffBtn.setText("定时关闭");
//            if (mPlayerStatusCallback != null) {
//                XmPlayerManager.getInstance(mContext)
//                        .removePlayerStatusListener(mPlayerStatusCallback);
//                mPlayerStatusCallback = null;
//            }
//            if (mTimer != null) {
//                mTimer.cancel();
//                mTimer = null;
//            }
//            return;
//        }
//
//        if (mTimer != null) {
//            mTimer.cancel();
//            mTimer = null;
//        }
//        if (mPlayerStatusCallback == null) {
//            mPlayerStatusCallback = new ISimpleOnPlayerStatusUpdateListener() {
//                @Override
//                public void onSoundPlayComplete() {
//                    mTimeOffBtn.setText("定时关闭");
//                    if (mPlayerStatusCallback != null) {
//                        XmPlayerManager.getInstance(mContext)
//                                .removePlayerStatusListener(
//                                        mPlayerStatusCallback);
//                    }
//                }
//
//                @Override
//                public void onPlayProgress(int currPos, int duration) {
//                    mTimeOffBtn.setText(TimeHelper
//                            .toTime((duration * 1.0f - currPos) / 1000));
//                }
//            };
//
//            XmPlayerManager.getInstance(mContext).addPlayerStatusListener(
//                    mPlayerStatusCallback);
//        }
//    }
//
//    private void updateTimer(long time) {
//        SharedPreferencesUtil settings = SharedPreferencesUtil
//                .getInstance(mContext);
//        boolean isStopTiming = settings.getBoolean(
//                ConstantsOpenSdk.PLAN_PLAY_STOP_SWITCH, true);
//        if (!isStopTiming) {
//            mTimeOffBtn.setText(R.string.timing_shut_down);
//            if (null != mTimer) {
//                mTimer.cancel();
//                mTimer = null;
//            }
//            if (mPlayerStatusCallback != null) {
//                XmPlayerManager.getInstance(mContext)
//                        .removePlayerStatusListener(mPlayerStatusCallback);
//                mPlayerStatusCallback = null;
//            }
//            return;
//        }
//        if (mPlayerStatusCallback != null) {
//            XmPlayerManager.getInstance(mContext).removePlayerStatusListener(
//                    mPlayerStatusCallback);
//            mPlayerStatusCallback = null;
//        }
//        leftTime = time;
//        if (mTimer == null) {
//            mTimer = new Timer();
//        } else {
//            if (mTimer != null) {
//                mTimer.cancel();
//            }
//            if (mTimer != null) {
//                mTimer.purge();
//            }
//            mTimer = null;
//            mTimer = new Timer();
//        }
//        mTimer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                synchronized (new Object()) {
//                    final Activity mActivity = getActivity();
//                    if (mActivity != null) {
//                        mActivity.runOnUiThread(new Runnable() {
//
//                            @Override
//                            public void run() {
//                                if (mActivity.isFinishing()) {
//                                    if (null != mTimer) {
//                                        mTimer.cancel();
//                                        mTimer = null;
//                                    }
//                                    return;
//                                }
//                                if (leftTime <= 0) {
//                                    mTimeOffBtn.setText(R.string.timing_shut_down);
//                                    if (null != mTimer) {
//                                        mTimer.cancel();
//                                        mTimer = null;
//                                    }
//                                    return;
//                                } else {
//                                    mTimeOffBtn.setText(StringUtil
//                                            .toTime((int) leftTime--));
//                                }
//                            }
//                        });
//                    }
//                }
//            }
//
//        }, 0, 1000);
//    }
//
//    private Track getCurrTrackByPlayer() {
//        PlayableModel currSound = XmPlayerManager.getInstance(mContext).getCurrSound(false);
//        if (currSound instanceof Track) {
//            return (Track) currSound;
//        }
//        return null;
//    }
//
//    private void downloadSound(View view) {
//        final Track t = getCurrTrackByPlayer();
//        if (t == null) {
//            showToastShort(R.string.fetching_data);
//            return;
//        }
//        if (!UserInfoMannage.hasLogined() && t.isPaid() && !t.isFree()) {
//            UserInfoMannage.gotoLogin(mContext);
//            return;
//        }
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("uid", (t.getAnnouncer() != null ? t
//                .getAnnouncer().getAnnouncerId() : 0) + "");
//        params.put("device", "android");
//        params.put("trackId", t.getDataId() + "");
//        params.put("traceId", XDCSDataUtil.getTraceId());
//        params.put("startTime", "" + System.currentTimeMillis());
//        params.put("sequenceId", t.getSequenceId());
//        params.put("sendDataTime ", "" + System.currentTimeMillis());
//        params.put("clientTraffic ", "" + t.getDownloadedSize());
//        long downloadedSize = t.getDownloadedSize();
//        long downloadSize = t.getDownloadSize();
//        long percent = 0;
//        if (downloadSize != 0) {
//            percent = (downloadedSize * 100) / downloadSize;
//        }
//        params.put("downloadPercent", percent + "");
//        AlbumEventManage.getSoundDownloadInfo(params, new IDataCallBackM<Track>() {
//            @Override
//            public void onSuccess(final Track t1, Headers header) {
//                if (t1 != null) {
//                    t1.setPlayCount(t.getPlayCount());
//                    t1.setFavoriteCount(t.getFavoriteCount());
//                    t1.setCommentCount(t.getCommentCount());
//                    t1.setCoverUrlLarge(t.getCoverUrlLarge());
//                    t1.setCoverUrlMiddle(t.getCoverUrlMiddle());
//                    t1.setCoverUrlSmall(t.getCoverUrlSmall());
//                    t1.getAnnouncer().setAvatarUrl(t.getCoverUrlSmall());
//
//                    if (!t1.isPaid() && TextUtils.isEmpty(t1.getDownloadUrl())) {
//                        XDCSCollectUtil.statErrorToXDCS("download", "resource=" + ConstantsOpenSdk.PLAY_FROM_NONE + ";track={" + t1.toString() + "}");
//                    }
//                    if ((!t1.isPayTrack() || t1.isAuthorized()) && DownloadTools.addTask(t1)) {
//                        showToastShort(R.string.add_download_success);
//                    } else {
//                        showToastShort(R.string.add_download_fail);
//                    }
//                } else {
//                    showToastShort(R.string.add_download_fail);
//                }
//            }
//
//            @Override
//            public void onError(int code, String message) {
//                showToastShort(R.string.add_download_fail);
//            }
//        }, view, new View[]{view});
//    }
//
//    private void doTransmit() {
//        if (UserInfoMannage.hasLogined()) {
//            mCommentType = COMMENT_TYPE_RELAY_COMMENT;
//            playFrgManage.initLoginUserBindData();
//            playFrgManage.loadDefaultShareSetting(mCommentType);
//            playFrgManage.getShareSetting(mCommentType);
//
//            mCommentInputBar.setHint(getString(R.string.relay_say_comment));
//            showCommentInputBar();
//        } else {
//            isGoToLogin = true;
//            playFrgManage.goToLogin();
//        }
//    }
//
//    private void toggleMoreOperationPanel() {
//
//        if (mMoreOperationPanel.getVisibility() == View.VISIBLE
//                || mOverlay.getVisibility() == View.VISIBLE) {
//            hideMoreOperationPanel();
//        } else {
//            showMoreOperationPanel();
//        }
//    }
//
//    ValueAnimator mShowMoreOperationPanelAnimation;
//    private ValueAnimator mHideMoreOperationPanelAnimation;
//    private GridView mMorePanel;
//
//    // 显示更多的dialog
//    private void showMoreOperationPanel() {
//        if (mCurrTrack == null) {
//            return;
//        }
//        if (mPanelContainer == null) {
//            mPanelContainer = (ViewGroup) mMoreOperationPanel
//                    .findViewById(R.id.panel_container);
//        }
//        mMorePanel = playFrgManage.createOperationPanelGrid(mCurrTrack, new PlayFragmentManage.IPanelGridViewItemClick() {
//            @Override
//            public void onPanelGridItemClick(int index, View view) {
////					"分享" ,"下载" ,"闹铃" ,"设为铃声" ,"播放历史","投诉" ,"转采" ,"WiFi音箱播放"
//                hideMoreOperationPanel();
//                switch (index) {
//                    case 0:
//                        showShareDialog(mCurrTrack, view);
//                        break;
//                    case 1:
//                        if (checkAndShowPay(false)) {
//                            showToastShortCoverLast(R.string.pay_success_can_down);
//                            return;
//                        }
//                        if (DownloadTools.isTrackDownloaded(mCurrTrack)) {
//                            showToastShort(R.string.track_has_downloaded);
//                            return;
//                        }
//                        if (mPlayingInfo != null && mPlayingInfo.trackInfo != null){
//                            new UserTracking().setEventGroup("download").setItem("track").setItemId(mPlayingInfo.trackInfo.trackId).setSrcPage("track").setSrcPageId(mPlayingInfo.trackInfo.trackId).setSrcModule("开始下载").statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_START_DOWNLOAD);
//                        }
//                        downloadSound(view);
//                        break;
//                    case 2:
//                        Bundle bundle = new Bundle();
//                        bundle.putInt(BundleKeyConstants.KEY_FROM,
//                                AlarmSettingFragment.FROM_PLAYING_SOUND);
//                        bundle.putString(BundleKeyConstants.KEY_ALARM_TITLE,
//                                mCurrTrack != null ? mCurrTrack.getTrackTitle() : getString(R.string.default_str));
//                        startFragment(AlarmSettingFragment.newInstance(bundle), view);
//                        if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                            new UserTracking().setSrcPage("track").
//                                    setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                    statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_SET_CLOCK);
//                        }
//                        break;
//                    case 3:
//                        if(NetworkUtils.isNetworkAvaliable(getActivity())) {
//                            doSetCallingRingtone();
//                            if (mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                                new UserTracking().setSrcPage("track").setItem("track").
//                                        setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                        setItemId(mPlayingInfo.trackInfo.trackId).
//                                        statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_SET_RINGCALL);
//                            }
//                        }else{
//                            showToastShort(R.string.net_error);
//                        }
//                        break;
//                    case 4:
//                        startFragment(HistoryFragment.newInstance(true, true, true), view);
//                        if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                            new UserTracking().setSrcPage("track").
//                                    setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                    setSrcModule("播放历史").
//                                    setItem("播放历史").
//                                    statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW);
//                        }
//                        break;
//                    case 5:
//                        report(view);
//                        break;
//                    case 6:
//                        doTransmit();
//                        if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                            new UserTracking().setItem("track").setItemId(mPlayingInfo.trackInfo.trackId).setSrcPage("track").setSrcPageId(mPlayingInfo.trackInfo.trackId).statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_RELAY);
//                        }
//                        break;
//                    case 7:
//                        wifiPlay();
//                        break;
//                }
//            }
//        });
//        mPanelContainer.removeAllViews();
//        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
//                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        mPanelContainer.addView(mMorePanel, lp);
//
//        mOverlay.setClickable(true);
//        mOverlay.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                hideMoreOperationPanel();
//            }
//        });
//
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
//            mShowMoreOperationPanelAnimation = ValueAnimator.ofFloat(
//                    mMoreOperationPanel.getHeight(), 0);
//            mShowMoreOperationPanelAnimation
//                    .addUpdateListener(new AnimatorUpdateListener() {
//
//                        @Override
//                        public void onAnimationUpdate(ValueAnimator animator) {
//                            float progress = (Float) animator
//                                    .getAnimatedValue();
//                            ViewHelper.setTranslationY(mMoreOperationPanel,
//                                    progress);
//                            ViewHelper.setAlpha(
//                                    mOverlay,
//                                    (mMoreOperationPanel.getHeight() - progress)
//                                            / mMoreOperationPanel.getHeight());
//                        }
//                    });
//            mShowMoreOperationPanelAnimation
//                    .addListener(new AnimatorListenerAdapter() {
//                        @Override
//                        public void onAnimationStart(Animator animation) {
//                            super.onAnimationStart(animation);
//                            mMoreOperationPanel.setVisibility(View.VISIBLE);
//                            mOverlay.setVisibility(View.VISIBLE);
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animator animation) {
//                            super.onAnimationEnd(animation);
//                            mShowMoreOperationPanelAnimation = null;
//                            mMoreOperationPanel.setVisibility(View.VISIBLE);
//                            mOverlay.setVisibility(View.VISIBLE);
//                        }
//                    });
//            mShowMoreOperationPanelAnimation.setDuration(200).start();
//        } else {
//            mOverlay.setVisibility(View.VISIBLE);
//            mMoreOperationPanel.setVisibility(View.VISIBLE);
//        }
//    }
//
//    private void hideMoreOperationPanel() {
//        if (mMoreOperationPanel == null
//                || mMoreOperationPanel.getVisibility() == View.GONE
//                || mMoreOperationPanel.getVisibility() == View.INVISIBLE) {
//            return;
//        }
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
//            if (mShowMoreOperationPanelAnimation != null) {
//                mShowMoreOperationPanelAnimation.reverse();
//            } else {
//                mHideMoreOperationPanelAnimation = ValueAnimator.ofFloat(0,
//                        mMoreOperationPanel.getHeight());
//                mHideMoreOperationPanelAnimation
//                        .addUpdateListener(new AnimatorUpdateListener() {
//
//                            @Override
//                            public void onAnimationUpdate(ValueAnimator animator) {
//                                float progress = (Float) animator
//                                        .getAnimatedValue();
//                                ViewHelper.setTranslationY(mMoreOperationPanel,
//                                        progress);
//                                ViewHelper
//                                        .setAlpha(
//                                                mOverlay,
//                                                (mMoreOperationPanel
//                                                        .getHeight() - progress)
//                                                        / mMoreOperationPanel
//                                                        .getHeight());
//                            }
//                        });
//                mHideMoreOperationPanelAnimation
//                        .addListener(new AnimatorListenerAdapter() {
//                            @Override
//                            public void onAnimationStart(Animator animation) {
//                                super.onAnimationStart(animation);
//                                mMoreOperationPanel.setVisibility(View.VISIBLE);
//                            }
//
//                            @Override
//                            public void onAnimationEnd(Animator animation) {
//                                super.onAnimationEnd(animation);
//                                mHideMoreOperationPanelAnimation = null;
//                                mMoreOperationPanel
//                                        .setVisibility(View.INVISIBLE);
//                                mOverlay.setVisibility(View.INVISIBLE);
//                            }
//                        });
//                mHideMoreOperationPanelAnimation.setDuration(200).start();
//            }
//        } else {
//            mMoreOperationPanel.setVisibility(View.GONE);
//            mOverlay.setVisibility(View.GONE);
//        }
//    }
//
//    /**
//     * 显示出播放历史的Fragment
//     */
//    private void gotoPlaylistFragment(View v) {
//        if (mCurrTrack == null)
//            return;
//        android.support.v4.app.FragmentTransaction ft = getChildFragmentManager()
//                .beginTransaction();
//        mPlaylistFragment = PlaylistFragment.getInstance(XDCSCollectUtil
//                .getXDCSDataFromView(v));
//        mPlaylistFragment
//                .setOnFinishListener(new SlideView.IOnFinishListener() {
//
//                    @Override
//                    public boolean onFinish() {
//                        if (mPlaylistFragment != null) {
//                            mPlaylistFragment.setCallback(null);
//                            mPlaylistFragment = null;
//                        }
//                        return false;
//                    }
//                });
//
//        mPlaylistFragment.setCallback(new PlaylistFragment.Callback() {
//
//            @Override
//            public void onPlayModeChanged(int playMode) {
//                setNextAndPreBtnStatus();
//            }
//        });
//        ft.add(R.id.fra_container, mPlaylistFragment);
//        ft.commitAllowingStateLoss();
//    }
//
//    private void setNextAndPreBtnStatus() {
//        boolean hasNext = XmPlayerManager.getInstance(mContext).hasNextSound();
//        boolean hasPrevious = XmPlayerManager.getInstance(mContext)
//                .hasPreSound();
//
//        PlayMode playMode = XmPlayerManager.getInstance(mContext).getPlayMode();
//        if (playMode == PlayMode.PLAY_MODEL_LIST_LOOP
//                && !XmPlayerManager.getInstance(mContext).getPlayList()
//                .isEmpty()) {
//            hasNext = true;
//            hasPrevious = true;
//        }
//        if (mNextBtn != null && mPreviousBtn != null) {
//            mNextBtn.setEnabled(hasNext);
//            mPreviousBtn.setEnabled(hasPrevious);
//        }
//    }
//
//    private void report(View fromView) {
//        if (UserInfoMannage.hasLogined() && mCurrTrack != null) {
//            startFragment(ReportFragment.newInstance(
//                    ReportFragment.TYPE_REPORT_SOUND, 0,
//                    mCurrTrack.getDataId(), 0, null), fromView);
//        } else {
//            isGoToLogin = true;
//            playFrgManage.goToLogin();
//        }
//    }
//
//    private void clickCommentItem(final PlayingSoundInfo.CommentInfo info,
//                                  final int position, final View v) {
//        // 回复的点击事件
//        View.OnClickListener replyClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCommentType = COMMENT_TYPE_SEND_COMMENT;
//                mCommentInputBar.setText("@" + info.nickname + ":");
//                prepareComment();
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        showCommentInputBar();
//                    }
//                }, 500);
//            }
//        };
//
//        playFrgManage.clickCommentItem(info, position, v, mParentId,
//                replyClickListener);
//    }
//
//    private void prepareComment() {
//        playFrgManage.initLoginUserBindData();
//        playFrgManage.loadDefaultShareSetting(mCommentType);
//        playFrgManage.getShareSetting(mCommentType);
//    }
//
//    private Animation mLoadingAnimation;
//
//    private void startLoading() {
//        if (mLoadingView == null) {
//            return;
//        }
//
//        mPlayBtnBg.setVisibility(View.GONE);
//        mLoadingView.setVisibility(View.VISIBLE);
//        mLoadingView.setImageResource(R.drawable.player_loading);
//        mLoadingAnimation = new RotateAnimation(0, 360,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
//                0.5f);
//        mLoadingAnimation.setDuration(1000);
//        mLoadingAnimation.setRepeatCount(Animation.INFINITE);
//        mLoadingAnimation.setRepeatMode(Animation.RESTART);
//        mLoadingAnimation.setInterpolator(new LinearInterpolator());
//        mLoadingAnimation.setAnimationListener(new AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                mLoadingView.setVisibility(View.GONE);
//            }
//        });
//        mLoadingView.startAnimation(mLoadingAnimation);
//    }
//
//    private void stopLoading() {
//        if (mLoadingAnimation != null) {
//            mLoadingAnimation.cancel();
//            mLoadingAnimation = null;
//        }
//        if (mLoadingView != null) {
//            mLoadingView.clearAnimation();
//            mLoadingView.setVisibility(View.GONE);
//        }
//        if (mPlayBtnBg != null) {
//            mPlayBtnBg.setVisibility(View.VISIBLE);
//        }
//    }
//
//    private void unForbidSeek() {
//        stopLoading();
//        if (null != mSeekBar) {
//            mSeekBar.setCanSeek(true);
//        }
//    }
//
//    private void forbidSeek() {
//        startLoading();
//        if (null != mSeekBar) {
//            mSeekBar.setCanSeek(false);
//        }
//    }
//
//    private void setListeners() {
//        findViewById(R.id.iv_play_status).setOnClickListener(this);
//        mAlbumEntranceLayout.setOnClickListener(this);
////		mReloadPlayerPageButton.setOnClickListener(this);
//        mBackBtn.setOnClickListener(this);
//        mPlayPauseBtn.setOnClickListener(this);
//        mNextBtn.setOnClickListener(this);
//        mPreviousBtn.setOnClickListener(this);
//        mTimeOffBtn.setOnClickListener(this);
//        // mFollowSoundOwnerBtn.setOnClickListener(this);
//        mPlaylistBtn.setOnClickListener(this);
//        // mHistoryBtn.setOnClickListener(this);
//        mDismissMoreOperationPanelBtn.setOnClickListener(this);
//        mCover.setOnClickListener(this);
//        mCloseAdCoverBtn.setOnClickListener(this);
//        mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                Logger.i("hovi123456", "onStopTrackingTouch");
//                if (isPlayWithDevice()) {
//                    /*
//					 * WiFi设备控制
//					 */
//                    WiFiDeviceController.seekTo(mContext, seekBar.getProgress());
//                } else {
//                    XmPlayerManager.getInstance(mContext).seekToByPercent(
//                            (float) seekBar.getProgress() / seekBar.getMax());
//                }
//                mForbidProgressUpdate = false;
//                mSeekBar.postDelayed(mHideFloatControlWidgetRunnable, 5000);
//                if (mDanmakuController != null && mCurrTrack != null) {
//                    int position = PlayTools.getPlayCurrentPosition(mContext);
//                    mDanmakuController.seekTo(position);
//                    mDanmakuController.reset(mCurrTrack.getDataId(), position,
//                            false);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                Logger.i("hovi123456", "onStartTrackingTouch____" + mSeekBar.isCanSeek());
//                if (!mSeekBar.isCanSeek()) {
//                    return;
//                }
//                mForbidProgressUpdate = true;
//                mSeekBar.removeCallbacks(mHideFloatControlWidgetRunnable);
//                showForBackwardWidget();
//            }
//
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress,
//                                          boolean fromUser) {
//                int duration = XmPlayerManager.getInstance(mContext)
//                        .getDuration(); // ms
//                updateFloatTimeLabel(progress, duration);
//            }
//        });
//
//        // getView().findViewById(R.id.owner_info_section)
//        // .setOnClickListener(this);
//
//        mScrollView.setOnScrollChangedListener(new OnScrollChangedListener() {
//            @Override
//            public void onScrollChanged(ScrollView who, int l, int t, int oldl,
//                                        int oldt) {
//                if (mScrollBounds == null) {
//                    mScrollBounds = new Rect();
//                }
////                    statDashangShow();
//
//
//                if (t >= 0 && t <= rangeOfTitleTransparent) {//封面图片可见
//                    mTitleBar.getBackground().mutate().setAlpha(t * 255 / rangeOfTitleTransparent);//改变透明度
//                    mTitleBar.findViewById(R.id.title_bar_divide).getBackground().mutate().setAlpha(t * 255 / rangeOfTitleTransparent);
//                }
//
//                if (t >= rangeOfTitleTransparent && findViewById(R.id.bg_play_title_gradient).getVisibility() == View.VISIBLE) {
//                    findViewById(R.id.bg_play_title_gradient).setVisibility(View.GONE);
//                    findViewById(R.id.layout_play_status).setVisibility(View.VISIBLE);
//                    mBackBtn.setImageResource(R.drawable.playpage_icon_down_black);
//                    moreButton.setImageResource(R.drawable.playpage_icon_more_black);
//                    mShareBtn.setImageResource(R.drawable.playpage_icon_share_black);
//                }
//                if (t < rangeOfTitleTransparent && findViewById(R.id.bg_play_title_gradient).getVisibility() == View.GONE) {
//                    findViewById(R.id.bg_play_title_gradient).setVisibility(View.VISIBLE);
//                    findViewById(R.id.layout_play_status).setVisibility(View.GONE);
//                    mBackBtn.setImageResource(R.drawable.playpage_icon_down_white);
//                    moreButton.setImageResource(R.drawable.playpage_icon_more_white);
//                    mShareBtn.setImageResource(R.drawable.playpage_icon_share_white);
//                }
//            }
//        });
//
//        mCommentInputBar
//                .setOnSendButtonClickListener(new OnSendButtonClickListener() {
//                    @Override
//                    public void onClick(View v, CharSequence s) {
//                        if (mCurrTrack != null) {
//                            playFrgManage.sendComment(s.toString(), v,
//                                    mCommentType, mCurrTrack.getDataId(),
//                                    mCommentStartTime, mParentId);
//                        }
//                    }
//                });
//
//        mCommentInputBar.setOnEmotionTextChange(new OnTextChangeListener() {
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before,
//                                      int count) {
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count,
//                                          int after) {
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (TextUtils.isEmpty(mCommentInputBar.getText())) {
//                    mCommentStartTime = -1;
//                }
//
//            }
//        });
//
//        mCommentInputBar
//                .setOnInputBoxFocusChangeListener(new OnFocusChangeListener() {
//                    @Override
//                    public void onFocusChange(View v, boolean hasFocus) {
//                        if (hasFocus && mCommentStartTime < 0) {
//                            mCommentStartTime = PlayTools
//                                    .getPlayCurrentPosition(mContext);
//                        }
//                    }
//                });
//
//        if (mSoftkeyListener == null) {
//            mSoftkeyListener = new OnGlobalLayoutListener() {
//
//                @SuppressLint("NewApi")
//                @Override
//                public void onGlobalLayout() {
//                    final Rect r = new Rect();
//                    getView().getWindowVisibleDisplayFrame(r);
//                    int diff = getView().getRootView().getHeight() - (r.bottom - r.top);
//                    if (Math.abs(diff) > 100) {
//                        mCommentInputBar.setEmotionSelectorIcon(R.drawable.emotion_selector);
//                    } else {
//                        mCommentInputBar.setEmotionSelectorIcon(R.drawable.keyboard_selector);
//                    }
//                }
//            };
//        }
//
//        getView().getViewTreeObserver().addOnGlobalLayoutListener(mSoftkeyListener);
//
//        mForwardBtn.setOnClickListener(this);
//        mRewindBtn.setOnClickListener(this);
//
//        mMoreOperationPanel.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
//
//        moreButton = (ImageView) getView().findViewById(R.id.next_img);
//        moreButton.setImageResource(R.drawable.playpage_icon_more_white);
//        moreButton.setVisibility(View.VISIBLE);
//        moreButton.setOnClickListener(this);
//
//        mDanmakuBtn.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                boolean checked = mDanmakuBtn.isSelected();
//                if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                    new UserTracking().setItem("track").setItemId(mPlayingInfo.trackInfo.trackId).setSrcPage("track").setSrcPageId(mPlayingInfo.trackInfo.trackId).statIting(XDCSCollectUtil.APP_NAME_EVENT, checked ? XDCSCollectUtil.SERVICE_CLOSE_DANMU : XDCSCollectUtil.SERVICE_OPEN_DANMU);
//                }
//                mDanmakuBtn.setSelected(!checked);
//                if (mDanmakuController != null) {
//                    SharedPreferencesUtil
//                            .getInstance(mContext)
//                            .saveBoolean(
//                                    AppConfigfConstants.SHOW_DANMAKU_ALREADY_SET,
//                                    true);
//
//                    boolean danmakuEnabled = !mDanmakuController
//                            .isEnabled();
//                    mDanmakuMask
//                            .setVisibility(danmakuEnabled ? View.VISIBLE
//                                    : View.GONE);
//                    mDanmakuView
//                            .setVisibility(danmakuEnabled ? View.VISIBLE
//                                    : View.GONE);
//                    mDanmakuController.toggleHideOrShow();
//                    if (danmakuEnabled
//                            && NetworkType.isConnectMOBILE(mContext)) {
//                        // 当前移动网络开启弹幕,toast提示
//                        showToastShort(R.string.open_duan_notice);
//                    }
//
//                    mDanmakuController.saveDefaultShowState();
//
//                    XmPlayerManager xmPlayerManager = XmPlayerManager
//                            .getInstance(mContext);
//                    if (xmPlayerManager != null
//                            && xmPlayerManager.isPlaying()
//                            && danmakuEnabled && mCurrTrack != null) {
//                        int pos = PlayTools
//                                .getPlayCurrentPosition(mContext);
//                        mDanmakuController.reset(
//                                mCurrTrack.getDataId(), pos, true);
//                    }
//                }
//            }
//        });
//
//        mFreeflowBtn.setOnClickListener(this);
//        mHintUse3DBtn.setOnClickListener(this);
//    }
//
//    /**
//     * 发送评论成功
//     */
//    public void sendCommentSuccess(CommentModel result, String sendContent) {
//        mCommentStartTime = -1;
//        mCommentInputBar.setText("");
//        mCommentInputBar.setHint("");
//
//        if (mCommentType == COMMENT_TYPE_SEND_COMMENT) {
//            showToastShort(R.string.play_comment_success);
//
//            hideCommentInputBar();
//            mCommentInputBar.toggleSoftInput();
//            if (mPlayingInfo != null && mPlayingInfo.commentInfo != null) {
//                if (mPlayingInfo.commentInfo.list == null) {
//                    mPlayingInfo.commentInfo.list = new ArrayList<PlayingSoundInfo.CommentInfo>();
//                }
//
//                PlayingSoundInfo.CommentInfo info = new PlayingSoundInfo.CommentInfo();
//                info.content = result.content;
//                info.createdAt = result.createdAt;
//                info.id = result.id;
//                info.nickname = result.nickname;
//                info.parentId = result.parentId;
//                info.smallHeader = result.smallHeader;
//                info.track_id = result.track_id;
//                info.uid = result.uid;
//
//                mPlayingInfo.commentInfo.list.add(info);
//                mPlayingInfo.commentInfo.totalCount++;
//
//                Collections.sort(mPlayingInfo.commentInfo.list,
//                        mCommentComparator);
//                setupCommentSection(mPlayingInfo);
//                sendDanmaku(sendContent);
//
//                if (playFrgManage != null && mCurrTrack != null) {
//                    playFrgManage.showMoreBtnTip(PlayFragment.this, mShareBtn, mCurrTrack);
//                }
//                if(mPlayingInfo != null && mPlayingInfo.trackInfo != null) {
//                    new UserTracking().setSrcPage("track").setItem("track").
//                            setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                            setItemId(mPlayingInfo.trackInfo.trackId).
//                            setContent(info.content).
//                            statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_COMMENT);
//                }
//            }
//        } else if (mCommentType == COMMENT_TYPE_RELAY_COMMENT) {
//            showToastShort(R.string.zhuancai_success);
//            hideCommentInputBar();
//            mCommentInputBar.toggleSoftInput();
//        }
//    }
//
//    /**
//     * 删除评论成功
//     */
//    public void removeCommentSuccess(int position) {
//        if (mPlayingInfo.commentInfo != null
//                && mPlayingInfo.commentInfo.list != null
//                && mPlayingInfo.commentInfo.list.size() > position) {
//            mPlayingInfo.commentInfo.list.remove(position);
//            mPlayingInfo.commentInfo.totalCount--;
//            setupCommentSection(mPlayingInfo);
//        }
//    }
//
//    private static final Comparator<PlayingSoundInfo.CommentInfo> mCommentComparator = new Comparator<PlayingSoundInfo.CommentInfo>() {
//        @Override
//        public int compare(CommentInfo lhs, CommentInfo rhs) {
//            if (lhs.createdAt > rhs.createdAt) {
//                return -1;
//            } else if (lhs.createdAt < rhs.createdAt) {
//                return 1;
//            }
//            return 0;
//        }
//    };
//
//    private void sendDanmaku(final String content) {
//        final LoginInfoModel user = UserInfoMannage.getInstance().getUser();
//        if (user != null && mDanmakuController != null
//                && mDanmakuController.isEnabled()) {
//            CommentBullet bullet = new CommentBullet();
//            bullet.setContent(content);
//            bullet.setNickname(user.getNickname());
//            bullet.setSmallHeader(user.getMobileSmallLogo());
//            bullet.setUid(user.getUid());
//            bullet.setStartTime(PlayTools.getPlayCurrentPosition(mContext) + 1200);
//            mDanmakuController.submit(bullet);
//        }
//    }
//
//    private boolean isStatDashangShow;
//
//    private void statDashangShow() {
//        if (!isStatDashangShow) {
//            Logger.log("dashang test");
//            isStatDashangShow = true;
//
//            if (mCurrTrackDetail != null) {
//                if (mCurrTrackDetail.getAnnouncer() == null
//                        || mCurrTrackDetail.getAlbum() == null) {
//                    return;
//                }
//
//                HashMap<String, String> xdcsParams = new HashMap<String, String>();
//                xdcsParams.put("anchorid", mCurrTrackDetail.getAnnouncer()
//                        .getAnnouncerId() + "");
//                xdcsParams
//                        .put("trackid", mCurrTrackDetail.getDataId() + "");
//                xdcsParams.put("albumid", mCurrTrackDetail.getAlbum()
//                        .getAlbumId() + "");
//                XDCSCollectUtil.getInstanse(
//                        getActivity().getApplicationContext()).statIting(
//                        XDCSCollectUtil.APP_NAME_DASHANG,
//                        XDCSCollectUtil.SERVICE_DASHANG_SHOW, xdcsParams);
//            }
//        }
//    }
//
//    private OnGlobalLayoutListener mSoftkeyListener;
//
//    private View.OnTouchListener mHideCommentInputTouchListener = new View.OnTouchListener() {
//
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            final Rect r = new Rect();
//            getView().getWindowVisibleDisplayFrame(r);
//            int diff = getView().getRootView().getHeight() - (r.bottom - r.top);
//            if (Math.abs(diff) > 100 || mCommentInputBar != null
//                    && mCommentInputBar.getVisibility() == View.VISIBLE) {
//                InputMethodManager im = (InputMethodManager) mCommentInputBar
//                        .getContext().getSystemService(
//                                Context.INPUT_METHOD_SERVICE);
//                im.hideSoftInputFromWindow(mCommentInputBar.getWindowToken(),
//                        InputMethodManager.HIDE_NOT_ALWAYS);
//                hideCommentInputBar();
//                return true;
//            }
//            return false;
//        }
//    };
//
//    private void updateFloatTimeLabel(long position, long duration) {
//        if (position < 0 || duration < 0 || position > duration) {
//            return;
//        }
//
//        Spanned text = Html.fromHtml("<font color=\"#d03c02\">"
//                + TimeHelper.toTime(position / 1000f) + "</font>" + "/"
//                + TimeHelper.toTime(duration / 1000f));
//        mFloatTimeLabel.setText(text);
//    }
//
//    private Runnable mHideFloatControlWidgetRunnable = new Runnable() {
//        @Override
//        public void run() {
//            hideForBackwardWidget();
//        }
//    };
//
//    /**
//     * 当前为移动网络将不能显示弹幕
//     */
//    private void disableDanmaku() {
//        if (isDanmakuEnable()) {
//            showToastShort(R.string.close_danmu_because_net);
//            setDanmakuViewsState(false);
//        }
//    }
//
//    public boolean isDanmakuEnable() {
//        return mDanmakuController != null && mDanmakuController.isEnabled();
//    }
//
//    /*****
//     * UI部分
//     *****/
//    // 标题头部
//    private ImageView mBackBtn;
//    private ImageView mShareBtn;
//
//    // 声音图片区域
//    private NotifyingScrollView mScrollView;
//
//    // 头部
//    private View mTitleBar;
//
//    // 顶部主播页面入口
//    private RelativeLayout mAlbumEntranceLayout;
//    private ImageView mAlbumPic;
//    private TextView mAlbumName;
//    private TextView mSubNumTx;
//    private ImageView mSubscribeImg;
//
//    // 提示购买view
//    private View mHintGotoBuyLay;
//    private TextView mHintBuyNowBtn;
//
//    // 播放控制UI部分
//    private TextView mTimeOffBtn;
//
//    private ImageView mCover;
//
//    private TextView mElapsedTimeTxt;
//
//    private TextView mDurationTxt;
//
//    private ImageButton mPlayPauseBtn;
//
//    private String mDurationFormatText = null;
//
//    private ImageView mLoadingView;
//
//    private ImageButton mNextBtn;
//
//    private ImageButton mPreviousBtn;
//
//    private TextView mPlaylistBtn;
//
//    private ForbidableSeekBar mSeekBar;
//
//    private View mPlayerControlBar;
//
//    private ImageView mPlayBtnBg;
//
//    // 声音数据展示区
//    private LinearLayout mPlayInfoLay;
//    private TextView mPlayTrackTitle;
//    private TextView mPlayAnchorName;
//    private TextView mPlayNumAndTime;
//
//    private View loadingProgressView;
//    private View loadingProgress;
//    private TextView loadingContent;
//    private TextView reloadBtn;
//
//    // 富文本
//    private TextView mRichTextView;
//    private View mRichLay;
//    private TextView mRichLoadMore;
//
//    // 相关推荐
//    private FlowLayout mRecommendAlbumTagContainer;
//
//    private TextView mMoreRecommendAlbum;
//
//    private View mRecommendAlbumSection;
//
//    // 听众点评
//    private View mCommentSection;
//
//    private View mCommentContentView;
//
//    private TextView mMoreComment;
//
//    // 输入评论
//    private EmotionSelector mCommentInputBar;
//
//    // 这个是弹出的更多的页面
//
//    private View mMoreOperationPanel;
//
//    private Button mDismissMoreOperationPanelBtn;
//
//    // private ShareDialog baseShareDialog;
//
//
//    // 大图中间广告页面
//    private ImageView mAdCover;
//
//    private ImageButton mCloseAdCoverBtn;
//
//    private TextView mResidue;    // 剩余的份数
//
//    private TextView mAdTypeDes;// 广告的类型的描述
//
//    private View mCoverSection;
//
//
//    // 支付提醒相关的控件
//    private View payLayoutMask;
//    private View payLayout;
//    private TextView payTitle, paySubTitle, payLookPri, payGotoPay;
//
//    // 拖动声音时出现的弹框
//    private TextView mFloatTimeLabel;
//
//    private View mForwardRewindArea;//<!--快进快退面板-->
//
//    private ImageButton mForwardBtn;
//
//    private ImageButton mRewindBtn;
//
//    // 整个View的遮罩
//    private View mOverlay;
//
//    // 没有评论界面
//    private View mNoCommentLayout;
//
//    // 底部的操作
//
//    private ImageView mFreeflowBtn;
//    private ImageView mHintUse3DBtn;
//
//
//    private void findAllView() {
//        mTitleBar = mContainerView.findViewById(R.id.title_bar);
//        mTitleBar.getBackground().mutate().setAlpha(0);//将title背景设置透明
//        mTitleBar.findViewById(R.id.title_bar_divide).getBackground().mutate().setAlpha(0);
//        mBackBtn = (ImageView) mContainerView.findViewById(R.id.back_btn);
//        mBackBtn.setImageResource(R.drawable.playpage_icon_down_white);
//        mShareBtn = (ImageView) mContainerView.findViewById(R.id.share_img);
//        mShareBtn.setImageResource(R.drawable.playpage_icon_share_white);
//        mShareBtn.setVisibility(View.VISIBLE);
//        mShareBtn.setOnClickListener(this);
//
//        mAlbumEntranceLayout = (RelativeLayout) mContainerView.findViewById(R.id.header_owner_info_section);
//        mAlbumPic = (ImageView) mContainerView.findViewById(R.id.header_owner_icon);
//        mAlbumName = (TextView) mContainerView.findViewById(R.id.header_owner_name);
//        mSubNumTx = (TextView) mContainerView.findViewById(R.id.header_sub_num);
//        mSubscribeImg = (ImageView) mContainerView.findViewById(R.id.header_owner_subscribe);
//
//        mHintGotoBuyLay = findViewById(R.id.free_goto_buy_lay);
//        mHintBuyNowBtn = (TextView) findViewById(R.id.free_buy_hint);
//
//        mCover = (ImageView) mContainerView.findViewById(R.id.sound_cover);
//
//        mDanmakuView = (IDanmakuView) mContainerView
//                .findViewById(R.id.view_danmaku);
//        mDanmakuMask = mContainerView.findViewById(R.id.view_danmaku_mask);
//
//        mPlayerControlBar = mContainerView
//                .findViewById(R.id.player_control_bar);
//        mElapsedTimeTxt = (TextView) mContainerView
//                .findViewById(R.id.elapsed_time);
//        mDurationTxt = (TextView) mContainerView.findViewById(R.id.duration);
//        mPlayPauseBtn = (ImageButton) mContainerView
//                .findViewById(R.id.play_pause);
//        mNextBtn = (ImageButton) mContainerView.findViewById(R.id.next);
//        mPreviousBtn = (ImageButton) mContainerView.findViewById(R.id.previous);
//        mPlaylistBtn = (TextView) mContainerView.findViewById(R.id.playlist);
//        mTimeOffBtn = (TextView) mContainerView.findViewById(R.id.time_off);
//
//        mSeekBar = (ForbidableSeekBar) mContainerView.findViewById(R.id.seek_bar);
//        mLoadingView = (ImageView) mContainerView.findViewById(R.id.loading);
//
//        mPlayInfoLay = (LinearLayout) findViewById(R.id.track_info_lay);
//        mPlayTrackTitle = (TextView) findViewById(R.id.play_track_title);
//        mPlayAnchorName = (TextView) findViewById(R.id.play_anchor_name);
//        mPlayAnchorName.setOnClickListener(this);
//        mPlayNumAndTime = (TextView) findViewById(R.id.play_num_and_time);
//
//        loadingProgressView = findViewById(R.id.loading_progress_layout);
//        loadingProgress = findViewById(R.id.loading_progress);
//        loadingContent = (TextView) findViewById(R.id.loading_content);
//        reloadBtn = (TextView) findViewById(R.id.reload_info);
//        reloadBtn.setOnClickListener(this);
//
//        mRichTextView = (TextView) findViewById(R.id.rich_context);
//
//        mRichLay = findViewById(R.id.rich_lay);
//        mRichLoadMore = (TextView) findViewById(R.id.look_all);
//        mRichLoadMore.setOnClickListener(this);
//
//        mRecommendAlbumTagContainer = (FlowLayout) mContainerView
//                .findViewById(R.id.tag_container);
//        mRecommendAlbumTagContainer.setLine(1);
//
//        mRecommendAlbumSection = mContainerView
//                .findViewById(R.id.player_recommend_albums);
//        mMoreRecommendAlbum = (TextView) mContainerView
//                .findViewById(R.id.more_recommend_album);
//
//        mCommentSection = mContainerView.findViewById(R.id.player_comments);
//        mCommentContentView = mCommentSection
//                .findViewById(R.id.player_comment_content);
//
//        mMoreComment = (TextView) mContainerView
//                .findViewById(R.id.more_commend_album);
//        mNoCommentLayout = mContainerView.findViewById(R.id.no_comment_layout);
//        mNoCommentLayout.findViewById(R.id.empty_view_title).setVisibility(
//                View.GONE);
//
//        TextView message = (TextView) mNoCommentLayout.findViewById(R.id.empty_view_message);
//        message.setText(R.string.no_wait_chat_shafa);
//        message.setTextColor(Color.parseColor("#999999"));
//        message.setGravity(Gravity.CENTER);
//
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.MATCH_PARENT);
//        layoutParams.setMargins(0, BaseUtil.dp2px(mContext, 30), 0,
//                BaseUtil.dp2px(mContext, 30));
//        message.setLayoutParams(layoutParams);
//
//        mNoCommentLayout.setBackgroundColor(Color.parseColor("#ffffff"));
//        mNoCommentLayout.setOnClickListener(this);
//
//        mScrollView = (NotifyingScrollView) mContainerView
//                .findViewById(R.id.scroll_view);
//
//        mCommentInputBar = (EmotionSelector) mContainerView
//                .findViewById(R.id.emotion_view);
//        mCommentInputBar.findViewById(R.id.like).setVisibility(View.GONE);
//
//        mMoreOperationPanel = mContainerView.findViewById(R.id.more_panel);
//
//        mDismissMoreOperationPanelBtn = (Button) mContainerView
//                .findViewById(R.id.dismiss);
//
//        mAdCover = (ImageView) mContainerView.findViewById(R.id.ad_cover);
//        mAdCover.setOnClickListener(this);
//        mResidue = (TextView) mContainerView.findViewById(R.id.residue);
//        mAdTypeDes = (TextView) mContainerView.findViewById(R.id.ad_cover_bottom);
//
//        mCoverSection = mContainerView.findViewById(R.id.cover_section);
//        mCloseAdCoverBtn = (ImageButton) mContainerView
//                .findViewById(R.id.close_ad_cover);
//
//        payLayoutMask = findViewById(R.id.pay_lay_mask);
//        payLayout = findViewById(R.id.pay_lay);
//        payTitle = (TextView) findViewById(R.id.pay_title);
//        paySubTitle = (TextView) findViewById(R.id.pay_sub_title);
//        payLookPri = (TextView) findViewById(R.id.pay_look_privilege);
//        payGotoPay = (TextView) findViewById(R.id.pay_goto_pay);
//
//        mFloatTimeLabel = (TextView) mContainerView
//                .findViewById(R.id.player_float_time_label);
//        mForwardRewindArea = mContainerView
//                .findViewById(R.id.forward_backward_area);
//        mForwardBtn = (ImageButton) mContainerView
//                .findViewById(R.id.forward_btn);
//        mRewindBtn = (ImageButton) mContainerView.findViewById(R.id.backward_btn);
//        mOverlay = mContainerView.findViewById(R.id.overlay);
//
//        mPlayBtnBg = (ImageView) mContainerView.findViewById(R.id.play_btn_bg);
//        mDanmakuBtn = (ImageView) mContainerView
//                .findViewById(R.id.danmuku_btn);
//
//        mFreeflowBtn = (ImageView) mContainerView.findViewById(R.id.freeflow);
//        mHintUse3DBtn = (ImageView) mContainerView.findViewById(R.id.hint_erji);
//
//        mContainerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                // 拦截触摸事件，防止操作播放页面后面内容
//                return true;
//            }
//        });
//
//        ivDownload = (ImageView) findViewById(R.id.playpage_icon_download);
//        ivDownload.setOnClickListener(this);
//        tvLikeNum = (TextView) findViewById(R.id.tv_like_num);
//        ivLike = (ImageView) findViewById(R.id.playpage_icon_like);
//        ivLike.setOnClickListener(this);
//
//        ivComment = (ImageView) findViewById(R.id.playpage_icon_comment);
//        ivComment.setOnClickListener(this);
//        tvCommentNum = (TextView) findViewById(R.id.tv_comment_num);
//        findViewById(R.id.tv_comment_entry).setOnClickListener(this);
//
//        ivSmallAvatar = (ImageView) findViewById(R.id.iv_small_avatar);
//        tvAnchorName = (TextView) findViewById(R.id.tv_anchor_name);
//        ivShowPopWindow = findViewById(R.id.iv_show_pop_window);
//        findViewById(R.id.float_bottom_bar).setOnClickListener(this);
//        ivSmallAvatar.setOnClickListener(this);
//
//        ivShowPopWindow.setOnClickListener(this);
//        adTag = findViewById(R.id.tv_ad_tag);
//        adLayout = findViewById(R.id.layout_pic_ad);
//    }
//
//    private void setDefaultData(boolean isLoadFailed) {
//        if (!canUpdateUi()) {
//            return;
//        }
//
////        setDanmakuViewsHide();
//        if (mCurrTrack != null) {
//            setPlayTitle();
//            if (isLoadFailed
//                    && !TextUtils.isEmpty(mCurrTrack.getCoverUrlLarge())
//                    && NetworkType.isConnectTONetWork(getActivity())) {
//                String url = mCurrTrack.getCoverUrlLarge();
//                addImageViewInRecycleList(mCover, url, R.drawable.player_cover_default);
//                ImageManager.from(getActivity()).displayImage(mCover,
//                        url, R.drawable.player_cover_default);
//            }
//
//        }
//        requestPageInfoIsOk(false);
//        if (mNativeAdContainer != null) {
//            mNativeAdContainer.setVisibility(View.GONE);
//        }
//
//        if (mRecommendAdContainer != null) {
//            mRecommendAdContainer.setVisibility(View.GONE);
//        }
//        if (mAdContainer != null) {
//            mAdContainer.setVisibility(View.GONE);
//        }
//
//        if (mCurrTrack != null && mPlayNumAndTime != null) {
//            if (mCurrTrack.getPlayCount() == 0) {
//                mCurrTrack.setPlayCount(1);
//            }
//            mPlayNumAndTime.setText(StringUtil.getFriendlyNumStrAndCheckIsZero(mCurrTrack.getPlayCount(), getString(R.string.num_play)) + StringUtil.getFriendlyDataStr(mCurrTrack.getCreatedAt()));
//
////			setAnchorNamMaxWidth();
//        }
//
//        if (mPlayAnchorName != null && mPlayAnchorName.getVisibility() == View.VISIBLE && mCurrTrack != null && mCurrTrack.getAnnouncer() != null && !TextUtils.isEmpty(mCurrTrack.getAnnouncer().getNickname())) {
//            String nickname = mCurrTrack.getAnnouncer().getNickname();
//            mPlayAnchorName.setText(nickname);
////            ImageManager.from(mContext).displayImage(mSmailAnchorImg, mCurrTrack.getAnnouncer().getAvatarUrl(), LocalImageUtil.getRandomHeadPortrait());
//        }
//
//        if (mRichLay != null) {
//            mRichLay.setVisibility(View.GONE);
//        }
//
//        if (mAlbumEntranceLayout != null) {
//            if (isLoadFailed && !headIsInited) {
//                mAlbumEntranceLayout.setVisibility(View.GONE);
//                if (mCover != null) {
//                    if (mCurrTrack != null) {
//                        addImageViewInRecycleList(mCover, mCurrTrack.getCoverUrlLarge(), R.drawable.player_cover_default);
//                        ImageManager.from(mContext).displayImage(mCover, mCurrTrack.getCoverUrlLarge(), R.drawable.player_cover_default);
//                    } else {
//                        mCover.setImageResource(R.drawable.player_cover_default);
//                        mCover.setClickable(false);
//                    }
//                }
//                if (mSubscribeImg != null) {
//                    mSubscribeImg.setVisibility(View.GONE);
//                }
//            } else {
//                if (!headIsInited) {
//                    mAlbumEntranceLayout.setVisibility(View.GONE);
//                    if (mSubscribeImg != null)
//                        mSubscribeImg.setVisibility(View.GONE);
//                }
//            }
//        }
//        setLoadingViewStatue(!isLoadFailed ? 1 : 2);
//    }
//
//    /**
//     * 页面信息网络
//     */
//    private void requestPageInfoIsOk(boolean isOk) {
//        int isVis = isOk ? View.VISIBLE : View.GONE;
//        // 相关推荐
//        if (mRecommendAlbumSection != null)
//            mRecommendAlbumSection.setVisibility(isVis);
//        // 听众点评
//        if (mCommentSection != null)
//            mCommentSection.setVisibility(isVis);
//    }
//
//    private OnGlobalLayoutListener mCalSoundCoverGlobalListener = null;
//
//    /**
//     * 让屏幕只显示出title 封面图 播放状态栏 主播信息 做的重新计算高度
//     */
//    private void calSoundCoverSize() {
//        if (null != getView()) {
//            if (mCalSoundCoverGlobalListener == null) {
//
//                mCalSoundCoverGlobalListener = new OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//                        if (null != getView()
//                                && getView().getViewTreeObserver() != null) {
//                            ToolUtil.removeGlobalOnLayoutListener(getView()
//                                    .getViewTreeObserver(), this);
//                            int mRootViewWidth = getView().getWidth();
//                            LayoutParams lp = mCoverSection.getLayoutParams();
//                            if (lp != null) {
//                                lp.height = mRootViewWidth;
//                                mCoverHeight = lp.height;
//                                rangeOfTitleTransparent = (int) (mCoverHeight - getResources().getDimension(R.dimen.title_bar_height));
//                                mCoverSection.setLayoutParams(lp);
//
//                                lp = mCover.getLayoutParams();
//                                if (lp != null) {
//                                    lp.height = mCoverHeight;
//                                    mCover.setLayoutParams(lp);
//                                }
//
//                                //广告栏位置和尺寸
//                                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) adLayout.getLayoutParams();
//                                params.setMargins(0, (int) (mCoverHeight * 0.15), 0, (int) (mCoverHeight * 0.19));
//                                params.height = (int) (mCoverHeight - mCoverHeight * 0.34);
//                                params.width = params.height + BaseUtil.dp2px(mContext, 20);
//                                adLayout.setLayoutParams(params);
//
//                                //广告的尺寸设置
//                                lp = mAdCover.getLayoutParams();
//                                if (lp != null) {
//                                    lp.width = params.height;
//                                    lp.height = params.height;
//                                    mAdCover.setLayoutParams(lp);
//                                }
//
//                                lp = mDanmakuView.getView().getLayoutParams();
//                                if (lp != null) {
//                                    RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) lp;
//                                    rlp.height = mCoverHeight
//                                            - BaseUtil.dp2px(getActivity(), 45);
//                                    rlp.bottomMargin = mDanmakuBtn.getHeight();
//                                    rlp.topMargin = BaseUtil.dp2px(
//                                            getActivity(), 40);
//                                    mDanmakuView.getView().setLayoutParams(rlp);
//                                }
//
//                                lp = mDanmakuMask.getLayoutParams();
//                                if (lp != null) {
//                                    RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) lp;
//                                    rlp.height = mCoverHeight;
//                                    mDanmakuMask.setLayoutParams(rlp);
//                                    payLayoutMask.setLayoutParams(rlp);
//                                }
//                            }
//                        }
//                    }
//                };
//            }
//            getView().getViewTreeObserver().addOnGlobalLayoutListener(
//                    mCalSoundCoverGlobalListener);
//        }
//    }
//
//    private PayFinishReceiver mPayFinishReceiver;
//
//    private void unregisterPayFinishReceiver() {
//        if (mPayFinishReceiver != null) {
//            getActivity().unregisterReceiver(mPayFinishReceiver);
//            mPayFinishReceiver = null;
//        }
//    }
//
//    private void registerPayFinishReceiver() {
//        if (mPayFinishReceiver == null) {
//            mPayFinishReceiver = new PayFinishReceiver();
//            IntentFilter filter = new IntentFilter(PayAction.ACTION_PAY_SUCCESS);
//            filter.addAction(PayAction.ACTION_REWARD_PAY_SHARE);
//            getActivity().registerReceiver(mPayFinishReceiver, filter);
//        }
//    }
//
//    // 设置主播信息
//    public void setupAnchorSection(PlayingSoundInfo upAnchorSection) {
//        if (!canUpdateUi()) {
//            return;
//        }
//        findViewById(R.id.float_bottom_bar).setVisibility(View.VISIBLE);
//
//        PlayingSoundInfo.UserInfo userInfo = upAnchorSection.userInfo;
//
////        if (mSmailAnchorImg.getVisibility() == View.VISIBLE) {
////            ImageManager.from(mContext).displayImage(mSmailAnchorImg, userInfo.smallLogo, LocalImageUtil.getRandomHeadPortrait());
////        }
//
//        String nickname = userInfo.nickname;
//        mPlayAnchorName.setText(nickname);
//
//        initPopwindow(upAnchorSection);
//
//        ImageManager.from(mContext).displayImage(ivSmallAvatar, userInfo.smallLogo, R.drawable.default_avatar_60);
//        tvAnchorName.setText(userInfo.nickname);
//        tvAnchorName.setCompoundDrawables(null, null, userInfo.isVerified ? LocalImageUtil.getDrawable(mContext, R.drawable.ic_v_oranget) : null, null);
//        if (userInfo.uid > 0)
//            ivShowPopWindow.setVisibility(View.VISIBLE);
//    }
//
//    // 设置播放详情
//    public void setupTrackInfoSection(PlayingSoundInfo upTrackInfoSection) {
//        if (!canUpdateUi()) {
//            return;
//        }
//
//        if (upTrackInfoSection == null || upTrackInfoSection.userInfo == null || upTrackInfoSection.albumInfo == null) {
//            mPlayAnchorName.setVisibility(View.GONE);
//            return;
//        }
//
////		String str1 = "主播: " ,str2 = TextUtils.isEmpty(upTrackInfoSection.userInfo.nickname) ? "" : upTrackInfoSection.userInfo.nickname;
////		String str3 = "     " ,str4 =  TextUtils.isEmpty(upTrackInfoSection.albumInfo.categoryName) ? "" : "分类: " , str5 = TextUtils.isEmpty(upTrackInfoSection.albumInfo.categoryName) ? "" : upTrackInfoSection.albumInfo.categoryName;
////
////		SpannableString spanString = new SpannableString(str1 + str2 + str3 + str4 + str5);
////		setHighColorSpannable(spanString , str1.length() , str1.length() + str2.length() ,0);
////		setHighColorSpannable(spanString , str1.length() + str2.length() + str3.length() + str4.length() , spanString.length() ,1);
////
////		mPlayAnchorName.setMovementMethod(LinkMovementMethod.getInstance());
////		mPlayAnchorName.setText(spanString);
//
//    }
//
//    private void setHighColorSpannable(SpannableString spanString, int begin, int end, final int type) {
//        spanString.setSpan(new ForegroundColorSpan(Color.parseColor("#0f93bf")), begin, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spanString.setSpan(new ClickableSpan() {
//            @Override
//            public void onClick(View arg0) {
//                if (type == 0) {    // 跳转到主播页
//                    gotoAnchorDetail(arg0);
//                } else if (type == 1) {    // 跳转到相应的分类页
//                    gotoCategoryDetail(arg0);
//                }
//            }
//        }, begin, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spanString.setSpan(new MyUnderlineSpan(), begin, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//    }
//
//    class MyUnderlineSpan extends UnderlineSpan {
//        @Override
//        public void updateDrawState(TextPaint ds) {
//            ds.setUnderlineText(false);
//        }
//    }
//
//    // 设置富文本
//    public void setupRichInfoSelect(PlayingSoundInfo upTrackInfoSection) {
//        if (!canUpdateUi()) {
//            return;
//        }
//
//        if (upTrackInfoSection == null || upTrackInfoSection.trackInfo == null) {
//            mRichLoadMore.setVisibility(View.GONE);
//            mRichLay.setVisibility(View.GONE);
//            return;
//        }
//        String richStr = upTrackInfoSection.trackInfo.shortRichIntro;
//
//        if (!TextUtils.isEmpty(richStr)) {
//            if (richStr.endsWith("<span style=\"display:none\" data-preview=\"true\"></span>") || richStr.endsWith("...")) {
//                mRichLoadMore.setVisibility(View.VISIBLE);
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mRichTextView.getLayoutParams();
//                layoutParams.bottomMargin = 0;
//                mRichTextView.setLayoutParams(layoutParams);
//            } else {
//                mRichLoadMore.setVisibility(View.GONE);
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mRichTextView.getLayoutParams();
//                layoutParams.bottomMargin = BaseUtil.dp2px(mContext, 15);
//                mRichTextView.setLayoutParams(layoutParams);
//            }
//
//            mRichLay.setVisibility(View.VISIBLE);
//
//            RichText.from(mContext, richStr)
//                    .async(true)
//                    .imageClick(new OnImageClickListener() {
//                        @Override
//                        public void imageClicked(List<String> imageUrls, int position) {
//                            ImageViewer mImageViewer = new ImageViewer(getActivity());
//                            mImageViewer.setData(imageUrls);
//                            mImageViewer.show(position, getView());
//                        }
//                    }).urlClick(new OnURLClickListener() {
//                @Override
//                public boolean urlClicked(String url) {
//                    if (url == null) {
//                        return true;
//                    }
//                    ToolUtil.clickUrlAction(PlayFragment.this, url, mRichTextView);
//
//                    return true;
//                }
//            })
//                    .setIsloadSmail(NetworkType.isConnectMOBILE(mContext))
//                    .into(mRichTextView);
//
//        } else {
//            mRichLay.setVisibility(View.GONE);
//            mRichLoadMore.setVisibility(View.GONE);
//        }
//
//    }
//
//    private void clickUrlAction(String url) {
//        if (url.startsWith("iting://")) {
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse(url));
//            startActivity(intent);
//        } else {
//            Bundle bundle = new Bundle();
//            bundle.putString(BundleKeyConstants.KEY_EXTRA_URL, url);
//            startFragment(WebFragment.class, bundle, mRichTextView);
//        }
//    }
//
//    public class PayFinishReceiver extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (PayAction.ACTION_REWARD_PAY_SHARE.equals(intent
//                    .getAction())) {
//                showShareDialog(mCurrTrack, null);
//            }
//        }
//    }
//
//    @Override
//    public void onMyResume() {
//        Logger.log("PlayFragment onMyResume");
//        super.onMyResume();
//
//        Activity activity = getActivity();
//
//        if (activity == null || activity.isFinishing()
//                || !(activity instanceof MainActivity)) {
//            return;
//        }
//
//        if (!((MainActivity) activity).playFragmentIsVis()) {
//            return;
//        }
//
//        TipsUtil.show(null);
//
//        XmPlayerManager.getInstance(mContext).addPlayerStatusListener(this);
//        XmPlayerManager.getInstance(mContext).addAdsStatusListener(this);
//        if (!canUpdateUi()) {
//            return;
//        }
//
//        if (getView() != null) {
//            getView().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if (!canUpdateUi()) return;
//                    List<AlbumM> list = new ArrayList<AlbumM>();
//                    if (mSubscribeInfo != null && mSubscribeInfo instanceof AlbumM) {
//                        list.add((AlbumM) mSubscribeInfo);
//                    }
//                    AlbumEventManage.getCollectAlbums(PlayFragment.this, list,
//                            new AlbumEventManage.ILoadHandler() {
//                                @Override
//                                public void onReady(List<AlbumM> result) {
//                                    if (canUpdateUi()) {
//                                        if (mSubscribeInfo != null && mSubscribeImg != null && mSubscribeImg.getVisibility() == View.VISIBLE)
//                                            AlbumEventManage.setCollectImageClickAndStatus(PlayFragment.this,
//                                                    mSubscribeImg, mSubscribeInfo,
//                                                    R.drawable.play_btn_collect, R.drawable.play_btn_collected, new AlbumEventManage.ICollect() {
//                                                        @Override
//                                                        public void success(boolean collect) {
//                                                            int favoritesCount = 0;
//                                                            if (mPlayingInfo != null && mPlayingInfo.albumInfo != null &&mPlayingInfo.countInfo != null &&
//                                                                    mPlayingInfo.countInfo.albumSubscribes != null) {
//                                                                favoritesCount = mPlayingInfo.countInfo.albumSubscribes.get(String.valueOf(mPlayingInfo.albumInfo.albumId));
//                                                                if (collect)
//                                                                    favoritesCount += 1;
//                                                                else
//                                                                    favoritesCount -= 1;
//                                                                if (mPlayingInfo.trackInfo != null){
//                                                                    new UserTracking().setSrcPage("track").setItem("track").
//                                                                            setSrcPageId(mPlayingInfo.trackInfo.trackId).
//                                                                            setItemId(mPlayingInfo.trackInfo.trackId).
//                                                                            statIting(XDCSCollectUtil.APP_NAME_EVENT, collect ? XDCSCollectUtil.SERVICE_COLLECT : XDCSCollectUtil.SERVICE_UNCOLLECT);
//                                                            }
//                                                                mPlayingInfo.countInfo.albumSubscribes.put(String.valueOf(mPlayingInfo.albumInfo.albumId), favoritesCount);
//                                                            }
//                                                            if (favoritesCount > 0) {
//                                                                mSubNumTx.setText(StringUtil.getFriendlyNumStrAndCheckIsZero(favoritesCount, getString(R.string.num_people_sub)));
//                                                                mSubNumTx.setVisibility(View.VISIBLE);
//                                                            } else {
//                                                                mSubNumTx.setVisibility(View.GONE);
//                                                            }
//                                                        }
//
//                                                        @Override
//                                                        public void fail(String msg) {
//                                                            showToastShort(msg);
//                                                        }
//                                                    });
//                                    }
//                                }
//                            });
//                }
//            }, 500);
//        }
//
//        final PlayableModel playableModel = XmPlayerManager.getInstance(mContext).getCurrSound();
//        if (mCurrTrack != null && playableModel != null && !mCurrTrack.equals(playableModel)) {
//            onSoundSwitch(mCurrTrack, playableModel);
//            if (mScrollView != null) {
//                mScrollView.scrollTo(0, 0);
//            }
//        } else {
//            if (playableModel instanceof Track) {
//                mCurrTrack = (Track) playableModel;
//            }
//
//            if (mCurrTrackDetail == null || mCurrTrackDetail.getDataId() != mCurrTrack.getDataId()) {
//                loadSoundDetailData();
//            }
//
//            if (!isGoToLogin && !isGotoBatchBuy) {
//                isGoToLogin = false;
//                isGotoBatchBuy = false;
//                changeSound(mCurrTrack, playableModel);
//            } else {
//                isGoToLogin = false;
//                isGotoBatchBuy = false;
//            }
//        }
//
//        setHintGotoByContent();
//        setNextAndPreBtnStatus();//重置上一首下一首状态
//
//        if (XmPlayerManager.getInstance(mContext).getPlayerStatus() == PlayerConstants.STATE_IDLE) {
//            onPlayProgress(0, XmPlayerManager.getInstance(mContext).getDuration());
//        } else {
//            onPlayProgress(XmPlayerManager.getInstance(mContext).getPlayCurrPositon(), XmPlayerManager.getInstance(mContext).getDuration());
//        }
//
//        if (mDanmakuController != null) {
//            if (mCurrTrack != null) {
//                mDanmakuController.reset(mCurrTrack.getDataId(),
//                        PlayTools.getPlayCurrentPosition(mContext), true);
//            }
//        }
//        setPlayPauseBtnStatus(XmPlayerManager.getInstance(mContext).isPlaying());
////		}
//
//        FreeFlowImageChange();
//
//        FreeFlowUtil.getInstance().setProxyChange(mProxyChange);
//
//        setPlayPauseBtnStatus(XmPlayerManager.getInstance(mContext).isPlaying());
//
//        PayManager.getInstance().addRechargeCallback(this);
//        PayManager.getInstance().addPayCallback(this);
//        registerPayFinishReceiver();
//
//        PayManager.getInstance().addTrackInfoCallBack(this);
//
//        mSoundAd = YaoyiYaoAdManage.getInstance(mContext).mCurrAdvertis;
//        if (YaoyiYaoAdManage.getInstance(mContext).mCurrAdvertis != null) {
//            currYanshiTime = YaoyiYaoAdManage.cutDownTime;
//            if (YaoyiYaoAdManage.cutDownTime > 0 || (mSoundAd != null && mSoundAd.getCountDown() == 0)) {
//                isYanshiOver = false;
//            } else {
//                isYanshiOver = true;
//            }
//        } else {
//            adRemove();
//        }
//
//        //重载广告
//        if (mSoundAd != null) {
//            if (mSoundAd.getSoundType() == Advertis.TYPE_DANMU) {// 弹幕广告
//                loadDanmuAdIcon(mSoundAd);
//            } else  {
//                if (mSoundAd.getSoundType() == Advertis.TYPE_YAOYIYAO) {
//                    // 手动启动
//                    startAdCountDownHandler();
//                }
//                if (!XmPlayerManager.getInstance(mContext).isAdsActive() &&
//                        XmPlayerManager.getInstance(mContext).isPlaying()) {
//                    hideSoundAdCover(true);
//                }
//            }
//        }
//        if (statAd) {
//            if (bannerAdFragment != null) {
//                bannerAdFragment.statAd();
//            }
//            if (nativeAdFragment != null) {
//                nativeAdFragment.statAd();
//            }
//            if (nativeAdRecommentAlbumFragment != null) {
//                nativeAdRecommentAlbumFragment.statAd();
//            }
//        }
//        statAd = true;
//        if (tempTrack != null && tempTrack.equals(playableModel) &&
//                !tempTrack.isAuthorized() && ((Track) playableModel).isAuthorized() &&
//                !XmPlayerManager.getInstance(mContext).isPlaying()) {
//            if (XmPlayerManager.getInstance(mContext).getPlayerStatus() == PlayerConstants.STATE_IDLE) {
//                XmPlayerManager.getInstance(mContext).play();
//            } else {
//                PlayTools.updateTrackAuthorizedByTracksAndPlay(mContext, new ArrayList<Track>() {
//                    {
//                        add((Track) playableModel);
//                    }
//                });
//            }
//        }
//        ivDownload.setSelected(DownloadTools.isTrackDownloaded(mCurrTrack));
//        unForbidSeek();
//    }
//
//    private void setHintGotoByContent() {
//        if (!canUpdateUi() || mHintGotoBuyLay == null) {
//            return;
//        }
//
//        final Track currTrack = getCurrTrackByPlayer();
//        if (currTrack == null) {
//            return;
//        }
//
//        int playerStatue = XmPlayerManager.getInstance(mContext).getPlayerStatus();
//
//        // 正在试听
//        if (currTrack.isAudition()) {
//            if (playerStatue != PlayerConstants.STATE_IDLE || TextUtils.isEmpty(XmPlayerManager.getInstance(mContext).getCurPlayUrl())) {
//                mHintBuyNowBtn.setText(Html.fromHtml("你可免费试听" + currTrack.getSampleDuration() + "秒,收听完整版请"));
//                mHintGotoBuyLay.setVisibility(View.VISIBLE);
//                findViewById(R.id.layout_action_one).setVisibility(View.GONE);
//                if (currTrack.getPriceTypeEnum() == AlbumFragmentNew.PAY_ALBUM_WHOLE) {
//                    findViewById(R.id.tv_buy).setOnClickListener(getClickListenerByType(currTrack, AlbumFragmentNew.PAY_ALBUM_WHOLE, true));
//                } else if (currTrack.getPriceTypeEnum() == AlbumFragmentNew.PAY_ALBUM_MEMBER_PART) {
//                    findViewById(R.id.tv_buy).setOnClickListener(new OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            if (mCurrTrack == null) {
//                                return;
//                            }
//                            double price = mCurrTrack.getDiscountedPrice();
//                            if (price <= 0) {
//                                price = mCurrTrack.getPrice();
//                            }
//
//                            if (currTrack.getAnnouncer() != null && currTrack.getAlbum() != null) {
//                                if (checkLogin()) return;
//
//                                PayMemberDialog dialog = PayMemberDialog.newInstance(currTrack.getAnnouncer().getAnnouncerId(), currTrack.getAlbum().getAlbumId(), price, AlbumFragmentNew.PAY_ALBUM_MEMBER_PART, true);
//                                dialog.setOnItemClickCallback(new PayMemberDialog.onItemClickCallback() {
//                                    @Override
//                                    public void clickPosition(int position) {
//                                        if (position == PayMemberDialog.MEMBER_PART_FROM_TRACK) {
//                                            showPayDialog(currTrack, getString(R.string.bug_tip_word));
//                                            //数据埋点开始
//                                            new UserTracking().statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_SELECTSINGLEPAYCATEGORY,
//                                                    "pay", "album", currTrack.getAlbum().getAlbumId() + "", "选择member专辑购买类型页", "直接购买", null, AlbumFragmentNew.getCurAlbumType(currTrack.getPriceTypeEnum()),
//                                                    AlbumFragmentNew.getMemeberType(currTrack.getPriceTypeEnum())
//                                                    , currTrack.getDataId() + "");
//                                            //数据埋点结束
//                                        }
//                                    }
//                                });
//                                dialog.show(getChildFragmentManager(), PayMemberDialog.TAG);
//                                checkAndStatPayInfo(currTrack, "立即购买Top", true);
//                            }
//                        }
//                    });
//                } else if (currTrack.getPriceTypeEnum() == AlbumFragmentNew.PAY_ALBUM_MEMBER_WHOLE) {
//                    findViewById(R.id.tv_buy).setOnClickListener(new OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            final MyProgressDialog myProgressDialog = new MyProgressDialog(getActivity());
//                            myProgressDialog.delayShow();
//                            getAlbumInfo(currTrack, new IDataCallBackM<AlbumM>() {
//                                @Override
//                                public void onSuccess(AlbumM object, Headers header) {
//                                    myProgressDialog.dismiss();
//                                    if (object == null) {
//                                        return;
//                                    }
//
//                                    double price = object.getDiscountedPrice();
//                                    if (price <= 0) {
//                                        price = object.getPrice();
//                                    }
//
//                                    if (currTrack.getAlbum() != null && currTrack.getAnnouncer() != null) {
//                                        if (checkLogin()) return;
//
//                                        PayMemberDialog dialog = PayMemberDialog.newInstance(currTrack.getAnnouncer().getAnnouncerId(),
//                                                currTrack.getAlbum().getAlbumId(), price, AlbumFragmentNew.PAY_ALBUM_MEMBER_WHOLE, true);
//                                        dialog.setOnItemClickCallback(new PayMemberDialog.onItemClickCallback() {
//                                            @Override
//                                            public void clickPosition(int position) {
//                                                if (position == PayMemberDialog.MEMBER_WHOLE) {
//                                                    if (checkLogin()) return;
//                                                    if (currTrack != null && currTrack.getAlbum() != null) {
//                                                        BuyAlbumFragment fra = BuyAlbumFragment.newInstance(currTrack.getAlbum().getAlbumId(), currTrack.getPriceTypeEnum());
//                                                        fra.setCallbackFinish(PlayFragment.this);
//                                                        startFragment(fra);
//                                                        new UserTracking().statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_STARTPURCHASE
//                                                                , "pay", "album", currTrack.getAlbum().getAlbumId() + "", "选择member专辑购买类型页", "直接购买", null,
//                                                                AlbumFragmentNew.getCurAlbumType(currTrack.getPriceTypeEnum()), AlbumFragmentNew.getMemeberType(currTrack.getPriceTypeEnum()), null);
//                                                    }
//                                                }
//                                            }
//                                        });
//                                        dialog.show(getChildFragmentManager(), PayMemberDialog.TAG);
//                                        checkAndStatPayInfo(currTrack, "立即购买Top", true);
//                                    }
//                                }
//
//                                @Override
//                                public void onError(int code, String message) {
//                                    myProgressDialog.dismiss();
//                                }
//                            });
//                        }
//                    });
//                } else if (currTrack.getPriceTypeEnum() == AlbumFragmentNew.PAY_ALBUM_FREE) {
//                    mHintGotoBuyLay.setVisibility(View.GONE);
//                    findViewById(R.id.layout_action_one).setVisibility(View.VISIBLE);
//                } else {
//                    findViewById(R.id.tv_buy).setOnClickListener(getClickListenerByType(currTrack, currTrack.getPriceTypeEnum(), true));
//                }
//                payLayout.setVisibility(View.GONE);
//                payLayoutMask.setVisibility(View.GONE);
//            } else {
//                setPayGuideLayoutData(currTrack);
//            }
//        } else {
//            mHintGotoBuyLay.setVisibility(View.GONE);
//            findViewById(R.id.layout_action_one).setVisibility(View.VISIBLE);
//            setPayGuideLayoutData(currTrack);
//        }
//    }
//
//    private void setPayGuideLayoutData(final Track mCurrTrack) {
//        if (!canUpdateUi() || mCurrTrack == null || payLayout == null) {
//            return;
//        }
//
//        if (!mCurrTrack.isPayTrack() || mCurrTrack.isAuthorized()) {
//            payLayout.setVisibility(View.GONE);
//            payLayoutMask.setVisibility(View.GONE);
//            return;
//        }
//
//        int payType = mCurrTrack.getPriceTypeEnum();
//        boolean isAudition = mCurrTrack.isAudition();
//        double price = mCurrTrack.getDiscountedPrice();
//        if (price <= 0) {
//            price = mCurrTrack.getPrice();
//        }
//        String priceStr = ToolUtil.convert2SpecificDecimal(price, 2);
//
//        payLayout.setVisibility(View.VISIBLE);
//        payLayoutMask.setVisibility(View.VISIBLE);
//        boolean isSetVisbility = false;
//        if (mHintGotoBuyLay.getVisibility() == View.VISIBLE) {
//            isSetVisbility = true;
//            mHintGotoBuyLay.setVisibility(View.GONE);
//            findViewById(R.id.layout_action_one).setVisibility(View.VISIBLE);
//        }
//
//        payTitle.setText(isAudition ? R.string.free_over : R.string.pay_program);
//        final String payName = getString(R.string.pay);
//        switch (payType) {
//            case AlbumFragmentNew.PAY_ALBUM_PART:
//                paySubTitle.setText(setPayNumTextColor(payName + priceStr + getString(R.string.over_program), payName.length(), (payName + priceStr + getString(R.string.gold)).length()));
//                payLookPri.setText(R.string.buy_now);
//                payLookPri.setOnClickListener(getPayActionClickListener(mCurrTrack));
//                payGotoPay.setVisibility(View.GONE);
//                break;
//            case AlbumFragmentNew.PAY_ALBUM_WHOLE:
//                final MyProgressDialog myProgressDialog = new MyProgressDialog(getActivity());
//                myProgressDialog.delayShow();
//                getAlbumInfo(mCurrTrack, new IDataCallBackM<AlbumM>() {
//                    @Override
//                    public void onSuccess(AlbumM object, Headers header) {
//                        myProgressDialog.dismiss();
//                        if (object == null) {
//                            return;
//                        }
//                        double price = object.getDiscountedPrice();
//                        if (price <= 0) {
//                            price = object.getPrice();
//                        }
//                        String priceStr = ToolUtil.convert2SpecificDecimal(price, 2);
//                        paySubTitle.setText(setPayNumTextColor(payName + priceStr + getString(R.string.gold) + getString(R.string.album_listen), payName.length(), (payName + priceStr + "喜点").length()));
//                    }
//
//                    @Override
//                    public void onError(int code, String message) {
//                        myProgressDialog.dismiss();
//                    }
//                });
//
//                // 这里因为要获取金额之后才能显示 这里先不显示
//                paySubTitle.setText(setPayNumTextColor(payName + getString(R.string.album_listen), payName.length(), (payName + getString(R.string.gold)).length()));
//                payLookPri.setText(R.string.buy_now);
//                payLookPri.setOnClickListener(getPayActionClickListener(mCurrTrack));
//
//                payGotoPay.setText(R.string.look_album_info);
//                payGotoPay.setVisibility(View.GONE);
//                payGotoPay.setOnClickListener(getClickListenerByType(mCurrTrack, Integer.MAX_VALUE, false));
//                break;
//            case AlbumFragmentNew.PAY_ALBUM_MEMBER:
//                paySubTitle.setText(R.string.play_have_more_privilege);
//                payLookPri.setText(R.string.play_look_vip_config);
//                payLookPri.setOnClickListener(getPayActionClickListener(mCurrTrack));
//                payGotoPay.setVisibility(View.GONE);
//                break;
//            case AlbumFragmentNew.PAY_ALBUM_MEMBER_PART:
//                paySubTitle.setText(R.string.play_have_more_privilege);
//                payLookPri.setText(R.string.play_look_vip_config);
//                payLookPri.setOnClickListener(getPayActionClickListener(mCurrTrack));
//                payGotoPay.setText(getString(R.string.direct_pay, priceStr));
//                payGotoPay.setVisibility(View.VISIBLE);
//                payGotoPay.setOnClickListener(getClickListenerByType(mCurrTrack, AlbumFragmentNew.PAY_ALBUM_PART, false));
//                break;
//            case AlbumFragmentNew.PAY_ALBUM_MEMBER_WHOLE:
//                paySubTitle.setText(R.string.play_have_more_privilege);
//                payLookPri.setText(R.string.play_look_vip_config);
//                payLookPri.setOnClickListener(getPayActionClickListener(mCurrTrack));
//                payGotoPay.setText(getString(R.string.direct_pay_album, priceStr));
//                payGotoPay.setVisibility(View.VISIBLE);
//                payGotoPay.setOnClickListener(getClickListenerByType(mCurrTrack, AlbumFragmentNew.PAY_ALBUM_WHOLE, false));
//                break;
//            default:
//                payLayout.setVisibility(View.GONE);
//                payLayoutMask.setVisibility(View.GONE);
//                if (isSetVisbility) {
//                    mHintGotoBuyLay.setVisibility(View.VISIBLE);
//                    findViewById(R.id.layout_action_one).setVisibility(View.GONE);
//                }
//                break;
//        }
//    }
//
//    private View.OnClickListener getPayActionClickListener(final Track track) {
//        if (track == null) {
//            return null;
//        }
//        int payType = track.getPriceTypeEnum();
//        return getClickListenerByType(track, payType, false);
//    }
//
//    private View.OnClickListener getClickListenerByType(final Track track, int payType, final boolean isTopBtnClicked) {
//        if (track == null) {
//            return null;
//        }
//        switch (payType) {
//            case AlbumFragmentNew.PAY_ALBUM_PART:
//                return new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        showPayDialog(track, getString(R.string.bug_tip_word));
//                        //数据埋点开始
//                        checkAndStatPayInfo(track, isTopBtnClicked ? "立即购买Top" : "立即购买", false);
//                        //数据埋点结束
//                    }
//                };
//            case AlbumFragmentNew.PAY_ALBUM_WHOLE:
//                return new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (checkLogin()) return;
//
//                        if (track.getAlbum() != null) {
//                            BuyAlbumFragment fra = BuyAlbumFragment.newInstance(track.getAlbum().getAlbumId(), track.getPriceTypeEnum());
//                            fra.setCallbackFinish(PlayFragment.this);
//                            startFragment(fra, v);
//                            //数据埋点开始
//                            new UserTracking().setEventGroup("pay").setItem("album").setItemId(track.getAlbum().getAlbumId()).setSrcPage("track").setSrcModule(isTopBtnClicked ? "立即购买Top" : "立即购买").setAlbumType(AlbumFragmentNew.getCurAlbumType(track.getPriceTypeEnum())).
//                                    setMemberType(AlbumFragmentNew.getMemeberType(track.getPriceTypeEnum())).statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_STARTPURCHASE);
//                            //数据埋点结束
//                        }
//
//                    }
//                };
//            case AlbumFragmentNew.PAY_ALBUM_MEMBER_PART:
//            case AlbumFragmentNew.PAY_ALBUM_MEMBER:
//            case AlbumFragmentNew.PAY_ALBUM_MEMBER_WHOLE:
//                return new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (checkLogin()) return;
//
//                        if (track.getAlbum() != null && track.getAnnouncer() != null) {
//                            MemberFragmentDetailIntro memberFragmentDetailIntro = MemberFragmentDetailIntro.newInstances(track.getAnnouncer().getAnnouncerId(), null, 0, 0);
//                            startFragment(memberFragmentDetailIntro, v);
//                            //数据埋点开始
//                            new UserTracking().setSrcPage("track").setSrcPageId(track.getDataId()).setSrcModule(isTopBtnClicked ? "立即购买Top" : "查看会员详情").setItem("member").setItemId(track.getAnnouncer().getAnnouncerId()).
//                                    statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW);
//                            //数据埋点结束
//                        }
//                    }
//                };
//            case Integer.MAX_VALUE:    // 跳转到专辑整本详情页
//                return new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (track.getAlbum() != null) {
//                            AlbumFragmentDetailIntro albumFragmentDetailIntro = AlbumFragmentDetailIntro.newInstances(track.getAlbum().getAlbumId(), null, 0, 0);
//                            startFragment(albumFragmentDetailIntro, v);
//                            //数据埋点开始
//                            new UserTracking().setSrcPage("track").setSrcPageId(track.getDataId()).setSrcModule("查看专辑详情").setItem("album").setItemId(track.getAlbum().getAlbumId()).
//                                    statIting(XDCSCollectUtil.APP_NAME_EVENT, XDCSCollectUtil.SERVICE_PAGE_VIEW);
//                            //数据埋点结束
//                        }
//                    }
//                };
//            default:
//                return null;
//        }
//
//    }
//
//    private boolean checkLogin() {
//        if (!UserInfoMannage.hasLogined()) {
//            isGoToLogin = true;
//            UserInfoMannage.gotoLogin(getActivity());
//            return true;
//        }
//        return false;
//    }
//
//
//    private SpannableString setPayNumTextColor(String string, int start, int end) {
//        SpannableString spannableString = new SpannableString(string);
//        ForegroundColorSpan span = new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.orange));
//        spannableString.setSpan(span, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return spannableString;
//    }
//
//    private IProxyChange mProxyChange = new IProxyChange() {
//        @Override
//        public void setProxyChange(boolean isRemove) {
//            if (!canUpdateUi()) {
//                return;
//            }
//
//            if (mFreeflowBtn == null) {
//                return;
//            }
//            if (isRemove && !NetworkType.isConnectMOBILE(mContext)) {
//                mFreeflowBtn.setVisibility(View.GONE);
//            } else {
//                mFreeflowBtn
//                        .setImageResource(isRemove ? R.drawable.freeflow_normal
//                                : R.drawable.freeflow_light);
//            }
//        }
//
//        @Override
//        public void networkChange() {
//            FreeFlowImageChange();
//            if (NetworkType.isConnectMOBILE(mContext)) {
//                disableDanmaku();
//            }
//        }
//    };
//
//    private void FreeFlowImageChange() {
//        if (mFreeflowBtn != null) {
//            if (!FreeFlowUtil.getInstance().hasFlowNecessity()
//                    || !NetworkType.isConnectMOBILE(mContext)
//                    || !XmPlayerManager.getInstance(mContext).isOnlineSource()) {
//                mFreeflowBtn.setVisibility(View.GONE);
//            } else {
//                mFreeflowBtn.setVisibility(View.VISIBLE);
//                mFreeflowBtn.setImageResource(!FreeFlowUtil.getInstance()
//                        .isOrderFlowPackage() ? R.drawable.freeflow_normal
//                        : R.drawable.freeflow_light);
//            }
//        }
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        Logger.d(getLoggerTag(), "PlayFragment onPause");
//
//        FreeFlowUtil.getInstance().removeProxyChange();
//
//        XmPlayerManager.getInstance(mContext).removePlayerStatusListener(this);
//        XmPlayerManager.getInstance(mContext).removeAdsStatusListener(this);
//
//        if (playFrgManage != null) {
//            playFrgManage.dissPopMoreBtnTip();
//        }
//
//        if (mDanmakuController != null) {
//            mDanmakuController.stopDraw();
//        }
//
//        PayManager.getInstance().removeRechargeCallback(this);
//        PayManager.getInstance().removePayCallback(this);
//
//        PayManager.getInstance().removeTrackInfoCallBack(this);
//
////		removeCloseAdHandler();
//        removeAdCountDownHandler();
//
//    }
//
//    @Override
//    public boolean onBackPressed() {
//        if (canBackPressed()) {
//            return true;
//        }
//        return super.onBackPressed();
//    }
//
//    private boolean canBackPressed() {
//        if (mPlaylistFragment != null && mPlaylistFragment.isVisible()) {
//            mPlaylistFragment.closeWithAnimation();
//            mPlaylistFragment = null;
//            return true;
//        } else if (mMoreOperationPanel != null
//                && mMoreOperationPanel.getVisibility() == View.VISIBLE) {
//            hideMoreOperationPanel();
//            return true;
//        } else if (mCommentInputBar != null
//                && mCommentInputBar.getVisibility() == View.VISIBLE) {
//            hideCommentInputBar();
//            return true;
//        } else if (mPlanTerminateFragment != null
//                && mPlanTerminateFragment.isVisible()) {
//            mPlanTerminateFragment.dismiss();
//            mPlanTerminateFragment = null;
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        unregisterPayFinishReceiver();//不能再onPause里面反注册，否则打赏成功分享框没法弹出来
//        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(mAdYaoyiyaoBroadCast);
//    }
//
//    @Override
//    public void onDestroyView() {
//        if (mSoftkeyListener != null && getView() != null) {
//            ToolUtil.removeGlobalOnLayoutListener(getView()
//                    .getViewTreeObserver(), mSoftkeyListener);
//            mSoftkeyListener = null;
//        }
//        if (mCalSoundCoverGlobalListener != null && getView() != null) {
//            ToolUtil.removeGlobalOnLayoutListener(getView()
//                    .getViewTreeObserver(), mCalSoundCoverGlobalListener);
//            mCalSoundCoverGlobalListener = null;
//        }
//
//        super.onDestroyView();
//        if (mDanmakuController != null) {
//            mDanmakuController.destory();
//        }
//
//    }
//
//    private void initDurationFormatText(int duration) {
//        if (duration > 0) {
//            mDurationFormatText = TimeHelper.toTime(duration / 1000f);
//        }
//    }
//
//    private void setPlayPauseBtnStatus(final boolean playing) {
//        if (mPlayBtnBg == null || mPlayPauseBtn == null) {
//            return;
//        }
//
//        if (playing) {
//            mPlayPauseBtn.setImageResource(R.drawable.player_toolbar_pause_bg);
//            mPlayPauseBtn.setContentDescription("暂停");
//        } else {
//            mPlayPauseBtn.setImageResource(R.drawable.player_toolbar_play_bg);
//            mPlayPauseBtn.setContentDescription("开始播放");
//            if (mDanmakuController != null) {
//                mDanmakuController.pause();
//            }
//        }
//        ImageView flag = ((ImageView) findViewById(R.id.iv_play_status_rhythm));
//        findViewById(R.id.iv_play_status).setSelected(playing);
//        ((TextView) findViewById(R.id.tv_play_status)).setText(playing ? "播放中" : "已暂停");
//        flag.setImageResource(R.drawable.anim_play_flag_black);
//        if (playing && flag.getDrawable() instanceof AnimationDrawable) {
//            final AnimationDrawable animationDrawable = (AnimationDrawable) flag.getDrawable();
//            flag.post(new Runnable() {
//                @Override
//                public void run() {
//                    if (animationDrawable != null
//                            && !animationDrawable.isRunning()) {
//                        animationDrawable.start();
//                    }
//                }
//            });
//        } else {
//            flag.setImageResource(R.drawable.playpage_icon_dynamic_rhythm_p1);
//        }
//    }
//
//    private synchronized void updateBufferingProgress(int percent) {
//
//        if (!XmPlayerManager.getInstance(mContext).isOnlineSource()) {
//            percent = 100;
//        }
//
//        if (null != mSeekBar && mCurrTrack != null) {
//            if (mSeekBar.getMax() != XmPlayerManager.getInstance(mContext)
//                    .getDuration()) {
//                mSeekBar.setMax(XmPlayerManager.getInstance(mContext)
//                        .getDuration());
//            }
//
//            int progress = percent * mSeekBar.getMax() / 100;
//
//            mSeekBar.setSecondaryProgress(progress);
//        }
//    }
//
//    /****************************************************
//     * 播放状态的改变
//     */
//    @Override
//    public void onPlayStart() {
//        Logger.log("PlayFragment :  onPlayStart");
//        if (canUpdateUi()) {
//            setPlayTitle();
//            FreeFlowImageChange();
//            setPlayPauseBtnStatus(true);
//            if (mIsSoundAdShowing) {
//                if (!XmPlayerManager.getInstance(mContext).isAdsActive()) {
//                    if (mSoundAd != null) {
//                        picClose(mAdvertisList, mSoundAd);
//                    }
//
//                    if (mSoundAd != null) {
//                        mIsSoundAdShowing = false;
//                        hideSoundAdCover(
//                                mSoundAd.getSoundType() != Advertis.TYPE_YAOYIYAO ||
//                                        (mSoundAd.getSoundType() == Advertis.TYPE_YAOYIYAO && currYanshiTime <= 0 && mSoundAd.getCountDown() != 0));
//                    }
//
//                    unForbidSeek();
//                }
//            } else {
//                unForbidSeek();
//            }
//
//            if (isDanmakuEnable()) {
//                int pos = PlayTools.getPlayCurrentPosition(mContext);
//                if (mDanmakuView != null
//                        && (mDanmakuController.getTrackId() == -1 || !mDanmakuView
//                        .isPaused())) {
//                    mDanmakuController.seekTo(pos);
//                }
//                if (mCurrTrack != null) {
//                    mDanmakuController
//                            .reset(mCurrTrack.getDataId(), pos, false);
//                }
//            }
//
//            setNextAndPreBtnStatus();
//            setHintGotoByContent();
//        }
//    }
//
//    @Override
//    public void onPlayPause() {
//        if (canUpdateUi()) {
//            setPlayPauseBtnStatus(false);
//
//            Logger.log("PlayFragment : onPlayPause " + (mSoundAd == null));
//            if (mSoundAd != null) {
//                removeCloseAdHandler();
//                showSoundAdPic(mSoundAd, false);
//            }
//
//            stopLoading();
//        }
//    }
//
//    @Override
//    public void onPlayStop() {
//        if (canUpdateUi()) {
//            setPlayPauseBtnStatus(false);
//            stopLoading();
//        }
//    }
//
//    @Override
//    public void onSoundPlayComplete() {
//        if (canUpdateUi()) {
//            setPlayPauseBtnStatus(false);
//        }
//    }
//
//    @Override
//    public void onSoundPrepared() {
//        Logger.d("playStatus", "onSoundPrepared IN");
//
//        if (canUpdateUi()) {
//            initDurationFormatText(XmPlayerManager.getInstance(mContext)
//                    .getDuration());
//            stopLoading();
//        }
//    }
//
//    @Override
//    public void onSoundSwitch(PlayableModel lastModel, PlayableModel curModel) {
//        Logger.log("PlayFragment :  onSoundSwitch");
//
//        if (curModel == null || curModel instanceof Track) {
//            tempTrack = (Track) curModel;
//        }
//
//        // 广告相关参数去除
//        adRemove();
//
//        setPlayPauseBtnStatus(XmPlayerManager.getInstance(mContext).isPlaying());
//
//        hideForBackwardWidget();
//        hideMoreOperationPanel();
//        if (mDanmakuController != null) {
//            mDanmakuController.onTrackChange();
//        }
//
//        PlayableModel playableModel = curModel;
//
//        if (playableModel == null && lastModel instanceof Track) {
//            if (((Track) lastModel).isAudition() && XmPlayerManager.getInstance(mContext).getPlayerStatus() == PlayerConstants.STATE_IDLE) {
//                setHintGotoByContent();
//                if (mSeekBar != null) {
//                    mSeekBar.setCanSeek(false);
//                }
//                return;
//            }
//            if (isAutoNext && XmPlayerManager.getInstance(mContext).getCurrentIndex() == (XmPlayerManager.getInstance(mContext).getPlayListSize() - 1)) {
//                // 播放到最后一曲了
//                lastSoundOver();
//            }
//            return;
//        }
//
//        if (playableModel == null || !PlayableModel.KIND_TRACK.equals(playableModel.getKind())) {
//            return;
//        }
//
//        Track track = (Track) playableModel;
//
//        if (canUpdateUi()
//                && (mCurrTrack == null || mCurrTrack.getDataId() != track
//                .getDataId())) {
//            mCurrTrack = track;
//            mCurrTrackDetail = null;
//            loadSoundDetailData();
//            mCommentStartTime = -1;
//        }
//		/*
//		 * WiFi设备控制
//		 */
//        if (!TextUtils.isEmpty(mPlayingUUID)) {
//            WiFiDeviceController.pushVoice(mContext, mPlayingUUID);
//        }
//
//        changeSound(lastModel, curModel);
//        setHintGotoByContent();
//    }
//
//    private CommentDialogFragment freeOverDialogFragment;
//
//    private void changeSound(final PlayableModel lastModel,
//                             PlayableModel curModel) {
//        Logger.log("PlayFragment onResume    changeSound  " + isPlayerFragManagerTiggerOnResume);
//        if (isPlayerFragManagerTiggerOnResume) {
//            isPlayerFragManagerTiggerOnResume = false;
//            return;
//        }
//
//        if (curModel instanceof Track) {
//            trackChange((Track) curModel, false);
//        }
//    }
//
//    private void lastSoundOver() {
//        PlayableModel playableModel = XmPlayerManager.getInstance(mContext)
//                .getCurrSound();
//        if (playableModel == null || !(playableModel instanceof Track)) {
//            return;
//        }
//        final Track lastModel = (Track) playableModel;
//
//        if (!lastModel.isPaid()) {
//            return;
//        }
//
//        if (lastModel.getPlaySource() != ConstantsOpenSdk.PLAY_FROM_SEARCH) {
//
//            final Track finalLastModel = lastModel;
//            getAlbumInfo((Track) lastModel, new IDataCallBackM<AlbumM>() {
//                @Override
//                public void onSuccess(final AlbumM object, Headers header) {
//                    if (!canUpdateUi()) {
//                        return;
//                    }
//
//                    if (object != null && object.getSerialState() == 2 && ((UserInfoMannage.hasLogined() && object.getSerialState() == 2 && !object.isCommented()) || !UserInfoMannage.hasLogined())) {
//                        CommonRequestM.postItingNew(mContext, XDCSCollectUtil.APP_NAME_PAY_PLAY, XDCSCollectUtil.SERVICE_PAY_COMMENT_ALBUM_POPUP, "专辑听完引导评论弹窗", "track@" + finalLastModel.getDataId(), "pageview/popup@专辑听完引导评论弹窗", new Object[]{});
//                        String content = object.getCommentsCounts() > 0 ? getString(R.string.num_common, object.getCommentsCounts()) : getString(R.string.no_common);
//                        freeOverDialogDismiss();
//                        freeOverDialogFragment = new CommentDialogFragment(getString(R.string.listen_over), getString(R.string.good_content, content), getString(R.string.go_evaluate), new OnClickListener() {
//                            @Override
//                            public void onClick(View arg0) {
//                                if (UserInfoMannage.hasLogined()) {
//                                    freeOverDialogDismiss();
//                                    PostCommentFragment postCommentFragment = PostCommentFragment.newInstance(object);
//                                    startFragment(postCommentFragment, getContainerView());
//                                } else {
//                                    playFramgentGotoLogin();
//                                }
//                            }
//                        });
//                        freeOverDialogFragment.show(getFragmentManager(), "ListenerOverAlbum");
//                        return;
//                    }
//                }
//
//                @Override
//                public void onError(int code, String message) {
//
//                }
//            });
//            return;
//        }
//    }
//
//    private void getAlbumInfo(Track track, IDataCallBackM<AlbumM> callBackM) {
//        if (track.getAlbum() == null) {
//            if (callBackM != null) {
//                callBackM.onSuccess(null, null);
//            }
//            return;
//        }
//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put(HttpParamsConstants.PARAM_URL_FROM,
//                AlbumEventManage.URL_FROM_ALBUM_HOMEPAGE);
//        params.put(HttpParamsConstants.PARAM_ALBUM_ID, track.getAlbum()
//                .getAlbumId() + "");
//        params.put(HttpParamsConstants.PARAM_DEVICE, "android");
//
//        CommonRequestM.getDataWithXDCS("getAlbumInfo", params, callBackM,
//                getContainerView(), null, new Object[]{});
//    }
//
//    private void freeOverDialogDismiss() {
//        if (freeOverDialogFragment != null) {
//            freeOverDialogFragment.dismissAllowingStateLoss();
//            freeOverDialogFragment = null;
//        }
//    }
//
//    private boolean isGoToLogin = false;
//    public static boolean isGotoBatchBuy = false;
//
//    private boolean isAutoNext = false;
//
//    private PayDialogFragment payDialogFragment;
//
//    private void trackChange(final Track track, boolean isNowPlay) {
//
//        if (track == null) {
//            return;
//        }
//
//        if (track.isAudition()) {
//            return;
//        }
//
//        if (track.isAuthorized()) {
//            if (isNowPlay) {
//                if (XmPlayerManager.getInstance(mContext).getPlayerStatus() == PlayerConstants.STATE_IDLE) {
//                    XmPlayerManager.getInstance(mContext).play();
//                } else {
//                    PlayTools.updateTrackAuthorizedByTracksAndPlay(mContext, new ArrayList<Track>() {
//                        {
//                            add(track);
//                        }
//                    });
//                }
//            }
//            return;
//        }
//
////		showPayDialog(track ,content);
//    }
//
//    private void showPayDialog(Track track) {
//        showPayDialog(track, getString(R.string.confirm));
//    }
//
//    private void showPayDialog(Track track, String content) {
//        if (track == null) {
//            return;
//        }
//
//        if (!track.isPaid() || track.isFree() || track.isAuthorized()) {
//            return;
//        }
////		if (track.getPriceTypeId() == 2) {
//        if (track.getPriceTypeEnum() == AlbumFragmentNew.PAY_ALBUM_WHOLE ||
//                track.getPriceTypeEnum() == AlbumFragmentNew.PAY_ALBUM_MEMBER_WHOLE || track.getPriceTypeEnum() == AlbumFragmentNew.PAY_ALBUM_MEMBER) {
//            updateTrackInfo(track);
//        } else {
//
//            payDialogDismiss();
//
//            payDialogFragment = PayDialogFragment.newInstanceForTrackWithTitle(track, content, PayDialogFragment.POP_FROM_PLAYFRAGMENT, track.getPriceTypeEnum());
//            payDialogFragment.setBottonCheckVis(false);
//            payDialogFragment.setCloseClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View arg0) {
//                    payDialogDismiss();
////					fullBackPress();
//                }
//            });
//            payDialogFragment.show(getFragmentManager(), "PayDialogFragment");
//            payDialogFragment.setOnCancleListener(new PayDialogFragment.IPayDialogCancleListener() {
//                @Override
//                public void onCancle(DialogInterface dialogInterface) {
//                    payDialogDismiss();
////					fullBackPress();
//                }
//            });
//        }
//    }
//
////	private void fullBackPress() {
////		while (canBackPressed()) {
////
////		}
////		mCurrTrack = null;
////		finishFragment();
////	}
//
//    @Override
//    public void onBufferingStart() {
//        Logger.log("PlayFragment : onBufferingStart ");
//        if (canUpdateUi()) {
//            forbidSeek();
//        }
//    }
//
//    @Override
//    public void onBufferingStop() {
//        Logger.log("PlayFragment : onBufferingStop ");
//        if (canUpdateUi()) {
//            if (XmPlayerManager.getInstance(mContext).getPlayerStatus() == PlayerConstants.STATE_IDLE) {
//                stopLoading();
//            } else {
//                unForbidSeek();
//            }
//        }
//    }
//
//    @Override
//    public void onBufferProgress(int percent) {
//        if (canUpdateUi()) {
//            updateBufferingProgress(percent);
//        }
//    }
//
//    @Override
//    public void onPlayProgress(int currPos, int duration) {
//        if (mCurrTrack != null && null != mSeekBar && duration > 0) {
//            if (mSeekBar.getMax() != XmPlayerManager.getInstance(mContext)
//                    .getDuration()) {
//                mSeekBar.setMax(XmPlayerManager.getInstance(mContext)
//                        .getDuration());
//            }
//            if (mSeekBar.getMax() == 0) {
//                mSeekBar.setMax(100);
//            }
//            mSeekBar.setProgress(currPos);
//            mElapsedTimeTxt.setText(TimeHelper.toTime(currPos / 1000f));
//            mDurationTxt.setText(TimeHelper.toTime(duration / 1000f));
//        }
//
//        if (duration <= 0) {
//            isAutoNext = false;
//        } else if (currPos >= duration - 1000) {
//            isAutoNext = true;
//        } else {
//            isAutoNext = false;
//        }
//    }
//
//    @Override
//    public boolean onError(XmPlayerException exception) {
//        if (canUpdateUi()) {
//            setPlayPauseBtnStatus(false);
//            stopLoading();
//        }
//        return false;
//    }
//
//    public int getCommentType() {
//        return mCommentType;
//    }
//
//    /**
//     * 下面的是声音广告的东西
//     */
//    private Advertis mSoundAd;
//
//    private AdvertisList mAdvertisList;
//
//    private ViewGroup mAdContainer;
//    private ViewGroup mNativeAdContainer;
//    private ViewGroup mRecommendAdContainer;
//    private ImageView mDanmakuBtn;
//    private ViewGroup mPanelContainer;
//
//    private Handler mCloseAdHandler;
//    private Runnable mRunnable;
//
//    // 倒计时计时器
//    private Handler mAdCountDownHandler;
//    private Runnable mAdCountDownRunnable;
//
//    private void hideSoundAdCover(boolean isNowClose) {
//        if (!canUpdateUi()) {
//            return;
//        }
//
//        removeCloseAdHandler();
//
//        if (isNowClose) {
//            hideAdPic();
//            return;
//        }
//
//        if (mSoundAd != null) {
//            // 这里不再区分摇一摇和普通广告
////			if(mSoundAd.getSoundType() == Advertis.TYPE_YAOYIYAO) {
//            mRunnable = new Runnable() {
//                @Override
//                public void run() {
//                    if (null != mSoundAd) {
//                        hideAdPic();
//
//                        if (mSoundAd.getSoundType() == Advertis.TYPE_YAOYIYAO) {
//                            loadDanmuAdIcon(mSoundAd);
//                        }
//                    }
//                }
//            };
//
//            mCloseAdHandler = new Handler();
//            mCloseAdHandler.postDelayed(mRunnable, 3000);
////			}
//        }
//    }
//
//    private void hideAdPic() {
//        if (!canUpdateUi()) {
//            return;
//        }
//        if (mAdCover != null && mCloseAdCoverBtn != null) {
//            adLayout.setVisibility(View.GONE);
//            adTag.setVisibility(View.GONE);
//            Logger.log("广告log    mAdTypeDes.setVisibility  GONE");
//        }
//    }
//
//    private void removeCloseAdHandler() {
//        if (mCloseAdHandler != null && mRunnable != null) {
//            mCloseAdHandler.removeCallbacks(mRunnable);
//            mCloseAdHandler = null;
//            mRunnable = null;
//        }
//    }
//
//    // 延时的时间 (在onSoundSwitch设置为0)
//    public static int currYanshiTime = 0;
//    // 是否是延时结束了
//    public static boolean isYanshiOver = false;
//
//    /**
//     * 倒计时
//     */
//    private void startCountDown() {
//
//        if (mSoundAd != null) {
//            if (isYanshiOver) {
//                if (mAdTypeDes != null) {
//                    mAdTypeDes.setText(R.string.over_chance);
//                    mAdTypeDes.setVisibility(View.VISIBLE);
//                }
//                return;
//            }
//
//            if (mSoundAd.getCountDown() == 0) {
//                setAdContentByYanshiTime(0);
//                return;
//            }
//
//            if (currYanshiTime > 0) {
//                setAdContentByYanshiTime(currYanshiTime);
//                return;
//            }
//
//            currYanshiTime = mSoundAd.getCountDown();
//            if (currYanshiTime < 0) {
//                return;
//            }
//
//            startAdCountDownHandler();
//        }
//    }
//
//    private void startAdCountDownHandler() {
//        removeAdCountDownHandler();
//
//        Logger.log("广告log  " + currYanshiTime);
//        mAdCountDownRunnable = new Runnable() {
//            @Override
//            public void run() {
//                if (null == mSoundAd) {
//                    return;
//                }
//
//                if (mSoundAd.getCountDown() == 0) {
//                    setAdContentByYanshiTime(0);
//                    return;
//                }
//
//                int lastCurrYanShiTime = currYanshiTime;
//
//                currYanshiTime--;
//                if (currYanshiTime <= 0) {
//                    // 这里是倒计时结束了
//                    isYanshiOver = true;
//
//                    adRemove();
//                    return;
//                }
//
//                if (mAdCountDownHandler != null && this != null) {
//                    mAdCountDownHandler.postDelayed(this, 1000);
//                }
//
//                setAdContentByYanshiTime(lastCurrYanShiTime);
//            }
//        };
//
//        mAdCountDownHandler = new Handler();
//        mAdCountDownHandler.post(mAdCountDownRunnable);
//    }
//
//    private void setAdContentByYanshiTime(int lastCurrYanShiTime) {
//        if (canUpdateUi()) {
//            if (danmuFragment != null && danmuFragment.contentIsVis()) {
//                danmuFragment.updateContent(mSoundAd.getName());
//                return;
//            }
//
//            if (mAdTypeDes != null) {
//                CharSequence charSequence = getAdTypeContent(lastCurrYanShiTime, mSoundAd);
//                if (charSequence == null) {
//                    mAdTypeDes.setVisibility(View.GONE);
//                } else {
//                    mAdTypeDes.setText(charSequence);
//                    if (danmuFragment == null || (danmuFragment != null && danmuFragment.isHidden())) {
//                        if (adImgIsLoaded) {
//                            mAdTypeDes.setVisibility(View.VISIBLE);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    // 获得摇一摇的文字
//    private CharSequence getAdTypeContent(int countDownTime, Advertis mSoundAd) {
//        if (mSoundAd == null || mCurrTrack == null) {
//            return null;
//        }
//
//        if (mSoundAd.getTrackId() == mCurrTrack.getDataId()) {
//            String countDownTimeStr = "";
//            if (countDownTime > 0) {
//                countDownTimeStr = countDownTime + "秒 ";
//            }
//            String imgStr = "  ";
//            SpannableString spanString = new SpannableString(imgStr + countDownTimeStr + mSoundAd.getName());
//
//            if (countDownTime > 0) {
//                spanString = PlayFragmentManage.setTextSpan(mContext, imgStr.length(),
//                        imgStr.length() + countDownTimeStr.length(), 20, spanString);
//            }
//
//            if (mSoundAd.getInteractiveType() == Advertis.TYPE_INTERACTIVE_CLICK) {
//                spanString = PlayFragmentManage.setImageSpan(mContext, R.drawable.icon_dianyidian, spanString);
//            } else if (mSoundAd.getInteractiveType() == Advertis.TYPE_INTERACTIVE_YAOYIYAO || mSoundAd.getInteractiveType() == Advertis.TYPE_INTERACTIVE_ALL) {
//                spanString = PlayFragmentManage.setImageSpan(mContext, R.drawable.icon_yaoyiyao, spanString);
//            }
//
//            return spanString;
//        }
//
//        return null;
//    }
//
//    private void removeAdCountDownHandler() {
//        if (mAdCountDownHandler != null && mAdCountDownRunnable != null) {
//            mAdCountDownHandler.removeCallbacks(mAdCountDownRunnable);
//            mAdCountDownHandler = null;
//            mAdCountDownRunnable = null;
//        }
//    }
//
//    private void showSoundAdPic(final Advertis ad, boolean byUser) {
//        if (ad == null) {
//            return;
//        }
//        if (ad != null && ad.getSoundType() == Advertis.TYPE_DANMU) {
//            return;
//        }
//
//        if (ad != null && ad.getSoundType() == Advertis.TYPE_YAOYIYAO) {
//            if (danmuFragment != null && !danmuFragment.contentIsVis() && !byUser) {
//                return;
//            }
//
//            if (danmuFragment != null) {
//                removeDanmuAd();
//            }
//        }
//
//        Logger.log("PlayFragment : showSoundAd " + "显示出来了");
//
//        AdCollectData data = new AdCollectData();
//        data.setAdItemId("" + ad.getAdid());
//
//        data.setAndroidId(SerialInfo.getAndroidId(mContext));
//        if (byUser)
//            data.setLogType(AppConstants.AD_LOG_TYPE_SOUND_LOGO_CLICK);
//        else
//            data.setLogType(AppConstants.AD_LOG_TYPE_SOUND_SHOW);
//
//        data.setPositionName(AppConstants.AD_POSITION_NAME_SOUND_PATCH);
//
//        if (mAdvertisList != null) {
//            data.setAdSource(mAdvertisList.getSource() + "");
//            data.setResponseId(mAdvertisList.getResponseId() + "");
//        }
//        data.setTime("" + System.currentTimeMillis());
//        PlayableModel info = XmPlayerManager.getInstance(mContext)
//                .getCurrSound();
//        if (info != null)
//            data.setTrackId("" + info.getDataId());
//        else
//            data.setTrackId("" + -1);
//
//        statOnlineAd(data);
//
//        mIsSoundAdShowing = true;
//
//        adImgIsLoaded = false;
//
//        if (!TextUtils.isEmpty(ad.getImageUrl())) {
//            if (!ad.getImageUrl().equals(mAdCover.getTag(R.string.app_name))) {
//                mAdCover.setImageDrawable(null);
//                addImageViewInRecycleList(mAdCover, ad.getImageUrl(), -1);
//                ImageManager.from(getActivity()).displayImage(mAdCover,
//                        ad.getImageUrl(), -1, new ImageManager.DisplayCallback() {
//                            @Override
//                            public void onCompleteDisplay(String lastUrl, Bitmap bitmap) {
//                                if (lastUrl != null && mSoundAd != null && lastUrl.equals(mSoundAd.getImageUrl())) {
//                                    adImageLoadSuccess();
//                                }
//
//                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mAdCover.getLayoutParams();
//                                if (ad.getSoundType() == Advertis.TYPE_YAOYIYAO) {
//                                    layoutParams.height = layoutParams.width - BaseUtil.dp2px(mContext, 20);//摇一摇的图片小一点
//                                } else {
//                                    layoutParams.height = layoutParams.width;
//                                }
//                                mAdCover.setLayoutParams(layoutParams);
//                            }
//                        });
//                mAdCover.setTag(R.string.app_name, ad.getImageUrl());
//            } else {
//                adImageLoadSuccess();
//            }
//            adLayout.setVisibility(View.VISIBLE);
//            adTag.setVisibility(View.VISIBLE);
//        } else {
//            adLayout.setVisibility(View.GONE);
//            adTag.setVisibility(View.GONE);
//        }
//
//        mResidue.setText("");
//        // 如果有份数则展示份数
//        if (ad.getQuantity() > 0) {
//            mResidue.setVisibility(View.VISIBLE);
//            mResidue.setText(ad.getQuantity() + "份");
//        } else {
//            mResidue.setVisibility(View.GONE);
//        }
//
//        if (ad.getSoundType() == Advertis.TYPE_YAOYIYAO) {
//            startCountDown();
//        } else {
//            mAdTypeDes.setVisibility(View.GONE);
//        }
//    }
//
//    private void adImageLoadSuccess() {
//        adLayout.setVisibility(View.VISIBLE);
//        adTag.setVisibility(View.VISIBLE);
//        if (mSoundAd != null && mSoundAd.getQuantity() > 0) {
//            mResidue.setVisibility(View.VISIBLE);
//        } else {
//            mResidue.setVisibility(View.GONE);
//        }
//
//        adImgIsLoaded = true;
//        if (mSoundAd != null && mSoundAd.getSoundType() == Advertis.TYPE_YAOYIYAO) {
//            setAdContentByYanshiTime(currYanshiTime);
//        }
//    }
//
//    private boolean adImgIsLoaded = false;
//
//    /**
//     * 点击了广告
//     */
//    private void adCoverClick() {
//        if (mSoundAd == null) {
//            return;
//        }
//
//        if (mSoundAd.getSoundType() == Advertis.TYPE_YAOYIYAO) {
//            if (mSoundAd.getInteractiveType() == Advertis.TYPE_INTERACTIVE_YAOYIYAO) {
//                return;
//            }
//        }
//
//        AdCollectData data = new AdCollectData();
//        data.setAdItemId("" + mSoundAd.getAdid());
//        data.setAdSource("" + AppConstants.AD_SOURCE_XIMALAYA);
//        data.setAndroidId(SerialInfo.getAndroidId(mContext));
//        data.setLogType(AppConstants.AD_LOG_TYPE_SOUND_CLICK);
//        data.setPositionName(AppConstants.AD_POSITION_NAME_SOUND_PATCH);
//        if (mAdvertisList != null) {
//            data.setResponseId(mAdvertisList.getResponseId() + "");
//        }
//        data.setTime("" + System.currentTimeMillis());
//        PlayableModel info = XmPlayerManager.getInstance(mContext)
//                .getCurrSound();
//        if (info != null)
//            data.setTrackId("" + info.getDataId());
//        else
//            data.setTrackId("" + -1);
//
//        if (mSoundAd.getClickType() == LINK_TYPE_ACTIVITY || mSoundAd.getClickType() == LINK_TYPE_ALBUM_INFO
//                || mSoundAd.getClickType() == LINK_TYPE_TRACK_INFO || mSoundAd.getClickType() == LINK_TYPE_ANCHOR_INFO) {
//            try {
//                Intent intent1 = new Intent();
//                intent1.setData(Uri.parse(mSoundAd.getLinkUrl()));
//                startActivity(intent1);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return;
//        }
//
//        final String realUrl = AdManager.getInstance().getAdRealJTUrl(
//                mSoundAd.getLinkUrl(), data);
//
//        ThirdAdStatUtil.getInstance(mContext).execAfterDecorateUrl(realUrl,
//                new ThirdAdStatUtil.Callback() {
//
//                    @Override
//                    public void execute(String url) {
//                        if (mSoundAd == null) {
//                            return;
//                        }
//
//                        switch (mSoundAd.getClickType()) {
//                            case LINK_TYPE_WEB:
//                                Intent intent = new Intent(mActivity,
//                                        WebActivityNew.class);
//                                intent.putExtra(BundleKeyConstants.KEY_EXTRA_URL,
//                                        url);
//
//                                if (mSoundAd.isShareFlag()) {
//                                    AdShareData.setIntentShare(intent, new AdShareData(mSoundAd.getShareData()));
//                                }
//
//                                startActivity(intent);
//                                break;
//                            case LINK_TYPE_OPEN_THIRD_BROWSER:
//                                openInThirdBrowser(mContext, url);
//                                break;
//                            case LINK_TYPE_GOTO_AD:
//                                LocalBroadcastManager.getInstance(mContext).sendBroadcast(
//                                        new Intent(YaoyiYaoAdManage.PlayFragmentAdClickBroadcastReceiver.GOTO_AD_ACTION));
//                                break;
//                        }
//                    }
//                });
//    }
//
//    public void openInThirdBrowser(Context context, String url) {
//        try {
//            if (mSoundAd != null && !TextUtils.isEmpty(mSoundAd.getLinkUrl())) {
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                context.startActivity(i);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //	点击动作，0:无动作，1:应用内打开link，2喜马拉雅活动3:第三方浏览器打开link，4：专辑详情，5：声音详情，6：播主详情7：直达广告
//    public static final int LINK_TYPE_NONE = 0;
//    public static final int LINK_TYPE_WEB = 1;
//    public static final int LINK_TYPE_ACTIVITY = 2;
//    public static final int LINK_TYPE_OPEN_THIRD_BROWSER = 3;
//    public static final int LINK_TYPE_ALBUM_INFO = 4;
//    public static final int LINK_TYPE_TRACK_INFO = 5;
//    public static final int LINK_TYPE_ANCHOR_INFO = 6;
//    public static final int LINK_TYPE_GOTO_AD = 7;
//
//
//    /**
//     * 广告关闭的时候
//     */
//    private void picClose(AdvertisList mAdvertisList, Advertis advertis) {
//
//    }
//
//    /**
//     * 将广告信息上传上去
//     */
//    private void statOnlineAd(AdCollectData data) {
//        CommonRequestM.statOnlineAd(data);
//
//        if (mAdvertisList == null) {
//            return;
//        }
//
//        int type = mAdvertisList.getSource();
//        if (type == AppConstants.AD_SOURCE_XIMALAYA) {//三方统计
//            if (mSoundAd == null) {
//                return;
//            }
//
//            ThirdAdStatUtil.getInstance(mContext).thirdAdStatRequest(
//                    mSoundAd.getThirdStatUrl());
//        }
//    }
//
//    /**
//     * 广告的状态回调
//     */
//    @Override
//    public void onStartGetAdsInfo() {
//        Logger.log("PlayFragment : 当开始获取广告 onStartGetAdsInfo");
//        forbidSeek();
//        startLoading();
//        mSoundAd = null;
//        setNextAndPreBtnStatus();
//    }
//
//    @Override
//    public void onGetAdsInfo(AdvertisList ads) {
//        mAdvertisList = ads;
//        if (ads != null && ads.getAdvertisList().size() > 0) {
//            mSoundAd = ads.getAdvertisList().get(0);
//            Logger.d(TAG, "PlayFragment 开始获取广告信息 onGetAdsInfo" + "___soundType" + mSoundAd.getSoundType() + "___" + mSoundAd.getName());
//            if (mSoundAd.getSoundType() == 1) {//1是弹幕广告；0是大图广告
//                loadDanmuAdIcon(mSoundAd);
//            } else {
////				 //如果没有弹幕广告的话就显示分享弹框
////				 loadShareDanmuIcon(mCurrTrack);
//            }
//        } else {
////			loadShareDanmuIcon(mCurrTrack);
//            mSoundAd = null;
//            hideSoundAdCover(true);
//        }
//        forbidSeek();
//    }
//
//    @Override
//    public void onAdsStartBuffering() {
//        Logger.d(TAG, "广告开始缓存 onStartPlayAds");
//    }
//
//    @Override
//    public void onAdsStopBuffering() {
//    }
//
//    @Override
//    public void onStartPlayAds(Advertis ad, int position) {
//        Logger.d(TAG, "广告开始播放 onStartPlayAds");
//        Log.e("AdsDataHandler", "广告开始播放" + ad);
//
//        if (canUpdateUi()) {
//            mSoundAd = ad;
//            showSoundAdPic(ad, false);
//            stopLoading();
//            if (null != mSeekBar) {
//                mSeekBar.setMax(100);
//                mSeekBar.setProgress(0);
//                mSeekBar.setCanSeek(false);
//                Logger.logToSd(TAG + "forbid seek, onStartPlayAd");
//                mDurationTxt.setText("00:00");
//            }
//            setPlayPauseBtnStatus(true);
//        }
//    }
//
//    @Override
//    public void onCompletePlayAds() {
//        Logger.log("onCompletePlayAd unForbidSeek");
//        stopLoading();
//        if (null != mSeekBar) {
//            mElapsedTimeTxt.setText("00:00");
//            mSeekBar.setProgress(0);
//            mSeekBar.setCanSeek(true);
//        }
//    }
//
//    @Override
//    public void onError(int what, int extra) {
//
//        Log.d(TAG, "unforbid seek, onErroredPlayAd");
//        // updateSoundCoverImage(mSoundInfo.coverLarge);
//        hideSoundAdCover(true);
//        Logger.log("onErroredPlayAd unForbidSeek");
//        stopLoading();
//        if (null != mSeekBar) {
//            // mSeekBar.setText("00:00");
//            mElapsedTimeTxt.setText("00:00");
//            mSeekBar.setProgress(0);
//            mSeekBar.setCanSeek(true);
//        }
//    }
//
//    @Override
//    protected boolean setNetworkErrorButtonVisiblity() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    protected boolean setNoContentButtonVisiblity() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    protected void clickNoContentButton(View view) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    protected View getNoContentView() {
//        return null;
//    }
//
//    @Override
//    protected View getLoadingView() {
//        return null;
//    }
//
//    @Override
//    protected View getNetworkErrorView() {
//        return null;
//    }
//
//    private void updateDataForPlayList(Track track) {
//        if (mPlaylistFragment != null && mPlaylistFragment.isVisible()) {
//            mPlaylistFragment.updateTrackToList(track);
//        }
//    }
//
//    private void playListAdapterNotify() {
//        if (mPlaylistFragment != null && mPlaylistFragment.isVisible()) {
//            mPlaylistFragment.adapterNotify();
//        }
//    }
//
//    @Override
//    public void rechargeSuccess(double money) {
//        if (payDialogFragment != null) {
//            payDialogFragment.show(getFragmentManager(), "PayDialogFragment");
//        }
//    }
//
//    @Override
//    public void rechargeFail(String msg) {
//        showToastShort(msg);
//    }
//
//    @Override
//    public void toRecharge(double balance) {
//        startFragment(
//                RechargeFragment.newInstance(RechargeFragment.TO_PAY, balance),
//                null);
//    }
//
//    @Override
//    public void paySuccess(final Track track) {
//        payDialogDismiss();
//        showPaySuccessDialog();
//
//        if (track == null) {
//            return;
//        }
//        track.setAuthorized(true);
//        if (track != null && track.equals(mCurrTrack)) {
//            mCurrTrack.setAuthorized(true);
//        }
//        XmPlayerManager.getInstance(mContext).updateTrackInPlayList(track);
//        updateDataForPlayList(track);
//        playListAdapterNotify();
//
//        setHintGotoByContent();
//        if (XmPlayerManager.getInstance(mContext).getPlayerStatus() == PlayerConstants.STATE_IDLE) {
//            XmPlayerManager.getInstance(mContext).play();
//        } else {
//            PlayTools.updateTrackAuthorizedByTracksAndPlay(mContext, new ArrayList<Track>() {
//                {
//                    add(track);
//                }
//            });
//        }
//    }
//
//    @Override
//    public void payFail(String msg) {
//        payDialogDismiss();
//        showPayFailedDialog();
//    }
//
//    private PayResultSimpleDialogFragment mSingleTrackPaySuccess;
//    private PayResultSimpleDialogFragment mSingleTrackPayFailed;
//
//    private void showPaySuccessDialog() {
//        if (mSingleTrackPaySuccess == null) {
//            mSingleTrackPaySuccess = PayResultSimpleDialogFragment.newInstance(true);
//        }
//        if (mSingleTrackPaySuccess.isAdded() || mSingleTrackPaySuccess.isVisible()) return;
//        mSingleTrackPaySuccess.show(getChildFragmentManager(), PayResultSimpleDialogFragment.TAG);
//        mSingleTrackPaySuccess.handleResult(getView(), null);
//    }
//
//    private void showPayFailedDialog() {
//        if (null == mSingleTrackPayFailed) {
//            mSingleTrackPayFailed = PayResultSimpleDialogFragment.newInstance(false);
//        }
//        if (mSingleTrackPayFailed.isAdded() || mSingleTrackPayFailed.isVisible()) return;
//        mSingleTrackPayFailed.show(getChildFragmentManager(), PayResultSimpleDialogFragment.TAG);
//        mSingleTrackPayFailed.handleResult(getView(), null);
//    }
//
//
//    @Override
//    public void toBatchBuy(long albumId, long uid) {
//        // 播放页批量购买埋点
//        BatchActionFragment batchActionFragment = BatchActionFragment
//                .newInstance(albumId, uid, BatchActionFragment.ACTION_BUY);
//        batchActionFragment.setCallbackFinish(this);
//        startFragment(batchActionFragment, null);
//        isGotoBatchBuy = true;
//    }
//
//    private BatchBuyResultDialogFragment payResultDialogFragment;
//    private Album mSubscribeInfo;
//    private BuriedPoints mBp;
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public void onFinishCallback(final Class<?> cls, final Object... params) {
//        if (getView() != null) {
//            getView().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if (!canUpdateUi()) {
//                        return;
//                    }
//                    if (params == null || params.length == 0) {
//                        if (payResultDialogFragment != null) {
//                            payResultDialogFragment.dismissAllowingStateLoss();
//                            payResultDialogFragment = null;
//                        }
//
//                        payDialogDismiss();
//
////						fullBackPress();
//                        return;
//                    }
//                    if (cls == BatchActionFragment.class) {
//                        if (params[0] instanceof List<?>) {
//                            List<Track> list = (List<Track>) params[0];
//                            if (list == null || list.size() == 0) {
//                                return;
//                            }
//
//                            boolean isHavePay = false;
//
//                            PlayableModel playableModel = XmPlayerManager.getInstance(mContext).getCurrSound();
//                            if (playableModel == null || !(playableModel instanceof Track)) {
//                                payDialogDismiss();
//                            } else {
//                                if (list.contains(playableModel)) {
//                                    isHavePay = true;
//                                    payDialogDismiss();
//                                }
//                            }
//
//                            if (isHavePay && list.size() == 1) {
//                                changeSound(mCurrTrack, playableModel);
//                            }
//
//                            PlayTools.updateTrackAuthorizedByTracksAndPlay(mContext, list);
//
//                            playListAdapterNotify();
//                        } else if (params[0] instanceof Long) {
//
//                            if (mCurrTrack != null) {
//                                payDialogDismiss();
//                                isGotoBatchBuy = true;
//                                startFragment(BatchActionFragment.newInstance((Long) params[0], BatchActionFragment.ACTION_DOWNLOAD_BUY));
//                                final long buyAlbumId = (long) params[0];
//                                PlayTools.updateTrackAuthorizedByAlbumIdsAndPlay(mContext, new ArrayList<Long>() {
//                                    {
//                                        add(buyAlbumId);
//                                    }
//                                });
//                                playListAdapterNotify();
//                            }
//                        }
//                    } else if (cls == BuyAlbumFragment.class) {
//                        if (params.length == 2) {
//                            if (params[0] instanceof Long && params[1] instanceof Boolean) {
//                                final long buyAlbumId = (long) params[0];
//                                boolean result = (boolean) params[1];
//                                if (result) {
//                                    PlayTools.updateTrackAuthorizedByAlbumIdsAndPlay(mContext, new ArrayList<Long>() {
//                                        {
//                                            add(buyAlbumId);
//                                        }
//                                    });
//                                    playListAdapterNotify();
//                                } else {
//                                    //整张专辑购买失败
//                                    showToastShort(R.string.pay_err);
//                                }
//                            }
//                        }
//                    }
//                }
//            }, 600);
//        }
//    }
//
//    private void payDialogDismiss() {
//        if (payDialogFragment != null) {
//            payDialogFragment.dismissAllowingStateLoss();
//            payDialogFragment = null;
//        }
//    }
//
//    /**
//     * 载入弹幕广告icon
//     *
//     * @param ad
//     */
//    private void loadDanmuAdIcon(final Advertis ad) {
//
//        if (ad == null || !canUpdateUi())
//            return;
//
//        if (ad.getSoundType() != Advertis.TYPE_YAOYIYAO) {
//            AdCollectData data = new AdCollectData();
//            data.setAdItemId("" + ad.getAdid());
//
//            data.setAndroidId(SerialInfo.getAndroidId(mContext));
//            data.setLogType(AppConstants.AD_LOG_TYPE_SOUND_SHOW);
//
//            data.setPositionName(AppConstants.AD_POSITION_NAME_SOUND_PATCH);
//
//            if (mAdvertisList != null) {
//                data.setAdSource(mAdvertisList.getSource() + "");
//                data.setResponseId(mAdvertisList.getResponseId() + "");
//            }
//            data.setTime("" + System.currentTimeMillis());
//            PlayableModel info = XmPlayerManager.getInstance(mContext)
//                    .getCurrSound();
//            if (info != null)
//                data.setTrackId("" + info.getDataId());
//            else
//                data.setTrackId("" + -1);
//
//            statOnlineAd(data);
//        }
//
//        danmuFragment = DanmuAdFragment.newInstance(ad);
//        danmuFragment.setiAdSmallIconCallBack(new DanmuAdFragment.IAdSmallIconCallBack() {
//            @Override
//            public void adSmallClick() {
//                showSoundAdPic(ad, true);
//                removeDanmuAd();
//            }
//        });
//        adTag.setVisibility(View.VISIBLE);
//        FragmentTransaction transaction = getChildFragmentManager()
//                .beginTransaction();
//        transaction
//                .replace(R.id.container_danmu_ad_icon, danmuFragment);
//        transaction.commitAllowingStateLoss();
//    }
//
//    private void loadShareDanmuIcon(final Track track) {
//        if (track != null) {
//            shareDanmuFragment = ShareDanmuFragment.newInstance(track);
//            shareDanmuFragment.setmShareCallback(new ShareDanmuFragment.IShareCallback() {
//                @Override
//                public void shareClick() {
//                    new ShareDialog(getActivity(), track, null).show();
//                    removeShareDanmu();
//                }
//            });
//            FragmentTransaction transaction = getChildFragmentManager()
//                    .beginTransaction();
//            transaction
//                    .replace(R.id.container_danmu_ad_icon, shareDanmuFragment);
//            transaction.commitAllowingStateLoss();
//        }
//    }
//
//    private void removeDanmuAd() {
//        if (danmuFragment != null) {
//            FragmentTransaction transaction = getChildFragmentManager()
//                    .beginTransaction();
//            transaction.remove(danmuFragment).commitAllowingStateLoss();
//            adTag.setVisibility(View.GONE);
//            danmuFragment = null;
//        }
//    }
//
//    private void removeShareDanmu() {
//        if (shareDanmuFragment != null) {
//            FragmentTransaction transaction = getChildFragmentManager()
//                    .beginTransaction();
//            transaction.remove(shareDanmuFragment).commitAllowingStateLoss();
//            shareDanmuFragment = null;
//        }
//    }
//
//    public void onHiddenChanged(boolean hidden) {
//        if (hidden) {
//            FragmentUtil.pauseOrResumeFragment(this, true);
//        } else {
//            FragmentUtil.pauseOrResumeFragment(this, false);
//        }
//    }
//
//    @Override
//    public void getCurTrackInfo(final TrackM trackM) {
//        if (trackM != null) {
//            PlayableModel playableModel = XmPlayerManager.getInstance(mContext).getCurrSound();
//            if (playableModel == null || !(playableModel instanceof Track)) {
//                return;
//            }
//            Track curTrack = (Track) playableModel;
//            if (curTrack.getDataId() == trackM.getDataId()) {
//                curTrack.setAuthorized(trackM.isAuthorized());
//            }
//            Logger.i("mark", "getCurTrackInfo::" + curTrack.isAuthorized());
//            if (curTrack.isAuthorized()) {
//                if (trackM.equals(mCurrTrack)) {
//                    mCurrTrack.setAuthorized(true);
//                }
//                XmPlayerManager.getInstance(mContext).updateTrackInPlayList(curTrack);
//                trackChange(curTrack, true);
//            }
//
//            setHintGotoByContent();
//        }
//    }
//
//    private void updateTrackInfo(final Track t) {
//        Map<String, String> params = new HashMap<String, String>();
//        if (t != null) {
//            params.put(HttpParamsConstants.PARAM_TRACK, t.getDataId() + "");
//        }
//        CommonRequestM.getDataWithXDCS("getXiOrderPrice", params, new IDataCallBackM<JSONObject>() {
//
//            @Override
//            public void onSuccess(JSONObject object, Headers header) {
//                if (!canUpdateUi()) return;
//                if (object != null) {
//                    t.setAuthorized(object.optBoolean("isAuthorized"));
//                    if (t.isAuthorized()) {
//                        XmPlayerManager.getInstance(mContext).updateTrackInPlayList(t);
//                        trackChange(t, true);
//                    } else {
//                        if (t != null && t.getAlbum() != null && t.getAlbum().getAlbumId() > 0) {
//                            BuyAlbumFragment fra = BuyAlbumFragment.newInstance(t.getAlbum().getAlbumId(), t.getPriceTypeEnum());
//                            fra.setCallbackFinish(PlayFragment.this);
//                            startFragment(fra);
//                            isGotoBatchBuy = true;
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onError(int code, String message) {
//            }
//        }, null, new View[]{}, new Object[]{});
//
//    }
//
//    private AdYaoyiYaoOverBroadcastReceiver mAdYaoyiyaoBroadCast;
//
//    public class AdYaoyiYaoOverBroadcastReceiver extends BroadcastReceiver {
//        public static final String AD_YAOYIYAO_ACTION = "ad_yaoyiyao_action";
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (intent == null) {
//                return;
//            }
//
//            Logger.log("AdYaoyiYaoOverBroadcastReceiver   onReceiver AD_YAOYIYAO_ACTION ");
//            if (AD_YAOYIYAO_ACTION.equals(intent.getAction())) {
//                adRemove();
//            }
//        }
//    }
//
//    private void adRemove() {
//        removeAdCountDownHandler();
//        removeCloseAdHandler();
//        currYanshiTime = 0;
//        isYanshiOver = false;
//        mSoundAd = null;
//        if (canUpdateUi()) {
//            removeDanmuAd();
//            hideSoundAdCover(true);
//        }
//    }
//
//    private void playFramgentGotoLogin() {
//        new DialogBuilder(getActivity())
//                .setMessage(R.string.no_login)
//                .setCancelBtn(R.string.later_do, new DialogCallback() {
//                    @Override
//                    public void onExecute() {
////						fullBackPress();
//                    }
//                })
//                .setOkBtn(
//                        R.string.go_login,
//                        new DialogCallback() {
//                            @Override
//                            public void onExecute() {
//                                isGoToLogin = true;
//                                UserInfoMannage
//                                        .gotoLogin(getActivity());
//                            }
//                        }).showConfirm();
//    }
//
//    /**
//     * 播放页第一级埋点
//     *
//     * @param track
//     * @param module
//     * @param isMemeber
//     */
//    private void checkAndStatPayInfo(Track track, String module, boolean isMemeber) {
//        if (track == null) return;
//        String serviceId = "";
//        String itemId = "";
//        if (isMemeber) {
//            serviceId = XDCSCollectUtil.SERVICE_SELECTMEMBERPAYCATEGORY;
//        } else {
//            serviceId = XDCSCollectUtil.SERVICE_SELECTSINGLEPAYCATEGORY;
//        }
//        if (track.getAlbum() != null) {
//            itemId = track.getAlbum().getAlbumId() + "";
//        } else if (mPlayingInfo != null && mPlayingInfo.albumInfo != null) {
//            itemId = mPlayingInfo.albumInfo.albumId + "";
//        }
//        new UserTracking().statIting(XDCSCollectUtil.APP_NAME_EVENT, serviceId,
//                "pay", "album", itemId, "track", module, null, AlbumFragmentNew.getCurAlbumType(track.getPriceTypeEnum()),
//                AlbumFragmentNew.getMemeberType(track.getPriceTypeEnum())
//                , track.getDataId() + "");
//    }
//
//    /**
//     * 0 加载完成
//     * 1 正在加载
//     * 2 加载失败
//     */
//    private void setLoadingViewStatue(int statue) {
//        if (canUpdateUi() && loadingProgressView != null) {
//            if (!XmPlayerManager.getInstance(mContext).isOnlineSource() && !NetworkType.isConnectTONetWork(mContext)) {
//                loadingProgressView.setVisibility(View.GONE);
//                return;
//            }
//
//            if (statue == 0) {
//                loadingProgressView.setVisibility(View.GONE);
//            } else if (statue == 1) {
//                loadingProgressView.setVisibility(View.VISIBLE);
//                loadingProgress.setVisibility(View.VISIBLE);
//                loadingContent.setVisibility(View.GONE);
//                reloadBtn.setVisibility(View.GONE);
//            } else if (statue == 2) {
//                loadingProgressView.setVisibility(View.VISIBLE);
//                loadingProgress.setVisibility(View.GONE);
//                loadingContent.setText(R.string.net_lazy);
//                loadingContent.setVisibility(View.VISIBLE);
//                reloadBtn.setVisibility(View.VISIBLE);
//            }
//        }
//    }
//
//    private void initPopwindow(PlayingSoundInfo soundInfo) {
//        optionList = "";
//        final View popupView = mActivity.getLayoutInflater().inflate(R.layout.layout_playfragment_popwindow, null);
//        popupViewHeight = (int) getResources().getDimension(R.dimen.play_fragment_popwindow_height);
//        popupViewWidht = (int) getResources().getDimension(R.dimen.play_fragment_popwindow_width);
//        mPopupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
//        mPopupWindow.setWidth(popupViewWidht);
//        mPopupWindow.setHeight(LayoutParams.WRAP_CONTENT);
//        mPopupWindow.setTouchable(true);
//        mPopupWindow.setOutsideTouchable(true);
//        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
//        popupView.findViewById(R.id.pop_to_anchorspace).setOnClickListener(this);
//        popupView.findViewById(R.id.pop_to_reward).setOnClickListener(this);
//        popupView.findViewById(R.id.pop_to_chat).setOnClickListener(this);
//        popupView.findViewById(R.id.pop_to_ask).setOnClickListener(this);
//        optionList += "[主播主页";
//
//        popupView.findViewById(R.id.pop_to_reward).setVisibility(soundInfo.trackRewardInfo.isOpen ? View.VISIBLE : View.GONE);
//        if (popupView.findViewById(R.id.pop_to_reward).getVisibility() == View.GONE) {
//            popupViewHeight -= (BaseUtil.dp2px(mContext, 14) * 2 + BaseUtil.sp2px(mContext, 13));//字高加上下margin
//        } else {
//            optionList += ",打赏";
//        }
//
//        popupView.findViewById(R.id.pop_to_ask).setVisibility(soundInfo.userInfo.isOpenAskAndAnswer ? View.VISIBLE : View.GONE);
//        if (popupView.findViewById(R.id.pop_to_ask).getVisibility() == View.GONE) {
//            popupViewHeight -= (BaseUtil.dp2px(mContext, 14) * 2 + BaseUtil.sp2px(mContext, 13));//字高加上下margin
//        } else {
//            optionList += ",问答";
//        }
//
//        popupView.findViewById(R.id.pop_to_chat).setVisibility(soundInfo.userInfo.uid == UserInfoMannage.getUid() ? View.GONE : View.VISIBLE);
//        if (popupView.findViewById(R.id.pop_to_chat).getVisibility() == View.GONE) {
//            popupViewHeight -= (BaseUtil.dp2px(mContext, 14) * 2 + BaseUtil.sp2px(mContext, 13));//字高加上下margin
//        } else {
//            optionList += ",私信";
//        }
//        optionList += "]";
//    }
//
//
//    /******************************************************
//     * 控制UI控件显示隐藏的代码
//     *******************************************************/
//
//    /**
//     * 隐藏快进快退区域
//     */
//    private void hideForBackwardWidget() {
//        ViewCompat.animate(mFloatTimeLabel).alpha(0)
//                .setListener(new ViewPropertyAnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(View view) {
//                        mFloatTimeLabel.setVisibility(View.GONE);
//                    }
//                }).setDuration(200).start();
//
//        ViewCompat.animate(mForwardRewindArea).alpha(0)
//                .setListener(new ViewPropertyAnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(View view) {
//                        mForwardRewindArea.setVisibility(View.GONE);
//                    }
//                }).setDuration(200).start();
//    }
//
//    /**
//     * 显示快进快退区域
//     */
//    private void showForBackwardWidget() {
//        ViewCompat.animate(mFloatTimeLabel).alpha(1)
//                .setListener(new ViewPropertyAnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationStart(View view) {
//                        ViewCompat.setAlpha(mFloatTimeLabel, 0);
//                    }
//
//                    @Override
//                    public void onAnimationEnd(View view) {
//                        mFloatTimeLabel.setVisibility(View.VISIBLE);
//                    }
//                }).setDuration(200).start();
//
//        ViewCompat.animate(mForwardRewindArea).alpha(1)
//                .setListener(new ViewPropertyAnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationStart(View view) {
//                        ViewCompat.setAlpha(mForwardRewindArea, 0);
//                    }
//
//                    @Override
//                    public void onAnimationEnd(View view) {
//                        mForwardRewindArea.setVisibility(View.VISIBLE);
//                    }
//                }).setDuration(200).start();
//    }
//
//
//    /**
//     * 评论框一开始不会显示,当需要评论的时候,和输入框一起显示。
//     */
//    private void showCommentInputBar() {
//        mCommentInputBar.setVisibility(View.VISIBLE);
//        mCommentInputBar.toggleSoftInput();
//        getView().findViewById(R.id.touch_handle_layer).setVisibility(
//                View.VISIBLE);
//        getView().findViewById(R.id.touch_handle_layer).setOnTouchListener(
//                mHideCommentInputTouchListener);
//        getView().findViewById(R.id.float_bottom_bar).setVisibility(View.GONE);
//    }
//
//    private void hideCommentInputBar() {
//
//        mCommentInputBar.hideEmotionPanel();
//        mCommentInputBar.setVisibility(View.GONE);
//        getView().findViewById(R.id.touch_handle_layer)
//                .setVisibility(View.GONE);
//        getView().findViewById(R.id.touch_handle_layer)
//                .setOnTouchListener(null);
//        getView().findViewById(R.id.float_bottom_bar).setVisibility(View.VISIBLE);
//    }
//    /******************************************************
//     * 控制UI控件显示隐藏的代码
//     *******************************************************/
//}
