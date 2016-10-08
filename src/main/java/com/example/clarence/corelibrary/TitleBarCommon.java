package com.example.clarence.corelibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by caishuxing on 2015/7/1.
 */
public class TitleBarCommon extends RelativeLayout {
    private TextView mTvTitle;
    private TextView mTvRight;
    private ImageView mIvLeft;
    private View mTitleContainer;
    private Context context;

    public TitleBarCommon(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.mTitleContainer = LayoutInflater.from(context).inflate(R.layout.base_header, this, true);
        init();
    }

    public void init() {
        mTvTitle = (TextView) mTitleContainer.findViewById(R.id.baselayout_tv_title);
        mIvLeft = (ImageView) mTitleContainer.findViewById(R.id.baselayout_iv_left);
        mTvRight = (TextView) mTitleContainer.findViewById(R.id.baselayout_tv_right);
    }


    /**
     * 自定义头部
     **/
    public void setCustomTitleBar(int customTitleLayoutId) {
        if (customTitleLayoutId <= 0) {
            this.setVisibility(View.GONE);
            return;
        }
        removeAllViews();
        View baseHead = View.inflate(context, customTitleLayoutId, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(baseHead, params);
    }

    /**
     * 设置标题文字 (若要隐藏设置参数为-1)
     *
     * @param resId
     */
    public TitleBarCommon setTitle(int resId) {
        if (resId != -1) {
            mTvTitle.setText(resId);
            mTvTitle.setVisibility(View.VISIBLE);
        } else {
            mTvTitle.setVisibility(View.GONE);
        }
        return this;
    }

    /**
     * 设置标题名称
     *
     * @param str
     * @return
     */
    public TitleBarCommon setTitle(String str) {
        try {
            mTvTitle.setText(str);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this;
    }

    /**
     * 获取左边按钮控件
     *
     * @return
     */
    public ImageView getLeftImageView() {
        return mIvLeft;
    }

    /**
     * 获取左边按钮控件
     *
     * @return
     */
    public TextView getRightTextView() {
        return mTvRight;
    }


    /**
     * 获取titleBar布局
     *
     * @return
     */
    public View getTitleBar() {
        return mTitleContainer;
    }


    /****
     * 隐藏返回键
     */
    public void hideBack() {
        mIvLeft.setVisibility(View.GONE);
    }
}
