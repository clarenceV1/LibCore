package com.example.clarence.corelibrary;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 预留扩展用
 * Created by clarence on 16/5/29.
 */
public class BaseActivity extends FragmentActivity {
    private View mRootView;
    private LinearLayout baseLayout;
    public TitleBarCommon titleBarCommon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBaseView();
        initTitleBar();
    }

    @Override
    public void setContentView(View view) {
        addChildView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = getLayoutInflater().inflate(layoutResID, null);
        addChildView(view);
    }
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        addChildView(view);
    }

    private void initBaseView() {
        mRootView = getLayoutInflater().inflate(R.layout.base_layout, null);
        super.setContentView(mRootView);
        baseLayout = (LinearLayout) findViewById(R.id.base_layout);
        titleBarCommon = (TitleBarCommon) findViewById(R.id.head_layout);
    }

    protected void initTitleBar() {
        setTitlebarAction();
    }

    protected void setTitlebarAction() {
        if (titleBarCommon != null) {
            if (titleBarCommon.getLeftButtonView() != null) {
                titleBarCommon.getLeftButtonView().setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                BaseActivity.this.finish();
                            }
                        });
            }
        }
    }

    private void addChildView(View view) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT);
        if(baseLayout!=null){
            baseLayout.addView(view, params);
        }
    }
}

