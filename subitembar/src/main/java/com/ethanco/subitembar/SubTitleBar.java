package com.ethanco.subitembar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EthanCo on 2016/4/7.
 */
public class SubTitleBar extends FrameLayout {
    public static final int DEF_LEFT_TEXT_SIZE = 14;
    public static final int DEF_RIGHT_TEXT_SIZE = 18;
    private TextView tvRight;
    private TextView tvLeft;

    public SubTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initVar(context, attrs, 0);
    }

    public SubTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initVar(context, attrs, defStyleAttr);
    }

    private void initVar(Context context, AttributeSet attrs, int defStyleArr) {
        if (attrs == null) {
            throw new IllegalArgumentException("AttributeSet is null");
        }
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SubTitleBar, defStyleArr, R.style.DefSubItemBarStyle);
        Drawable rightTextDrawableLeft = ta.getDrawable(R.styleable.SubTitleBar_right_text_drawableLeft);
        Drawable rightTextDrawableRight = ta.getDrawable(R.styleable.SubTitleBar_right_text_drawableRight);
        String rightText = ta.getString(R.styleable.SubTitleBar_right_text);
        @ColorInt int rightTextColor = ta.getColor(R.styleable.SubTitleBar_right_text_color,
                getResources().getColor(R.color.bar_primary_text));
        float rightTextSize = Utils.px2sp(context, ta.getDimension(
                R.styleable.SubTitleBar_right_text_size, Utils.sp2px(context, DEF_RIGHT_TEXT_SIZE)));
        int rightTextDrawableLeftSize = (int) ta.getDimension(R.styleable.SubTitleBar_right_text_drawableLeftSize, -1);
        int rightTextDrawableRightSize = (int) ta.getDimension(R.styleable.SubTitleBar_right_text_drawableRightSize, -1);
        int rightTextDrawablePadding = (int) ta.getDimension(R.styleable.SubTitleBar_right_text_drawablePadding, 0);

        Drawable leftTextDrawableLeft = ta.getDrawable(R.styleable.SubTitleBar_left_text_drawableLeft);
        Drawable leftTextDrawableRight = ta.getDrawable(R.styleable.SubTitleBar_left_text_drawableRight);
        String leftText = ta.getString(R.styleable.SubTitleBar_left_text);
        @ColorInt int leftTextColor = ta.getColor(R.styleable.SubTitleBar_left_text_color,
                getResources().getColor(R.color.bar_secondary_text));
        float leftTextSize = Utils.px2sp(context, ta.getDimension(
                R.styleable.SubTitleBar_left_text_size, Utils.sp2px(context, DEF_LEFT_TEXT_SIZE)));
        int leftTextDrawableLeftSize = (int) ta.getDimension(R.styleable.SubTitleBar_left_text_drawableLeftSize, -1);
        int leftTextDrawableRightSize = (int) ta.getDimension(R.styleable.SubTitleBar_left_text_drawableRightSize, -1);
        int leftTextDrawablePadding = (int) ta.getDimension(R.styleable.SubTitleBar_left_text_drawablePadding, 0);

        ta.recycle();

        View root = LayoutInflater.from(context).inflate(R.layout.layout_sub_title, this, true);
        tvRight = (TextView) root.findViewById(R.id.tv_sub_title_right);
        tvLeft = (TextView) root.findViewById(R.id.tv_sub_title_left);

        setBounds(rightTextDrawableLeft, rightTextDrawableLeftSize);
        setBounds(rightTextDrawableRight, rightTextDrawableRightSize);
        setBounds(leftTextDrawableLeft, leftTextDrawableLeftSize);
        setBounds(leftTextDrawableRight, leftTextDrawableRightSize);


        tvRight.setText(rightText);
        tvRight.setTextSize(rightTextSize); //setTextSize 以sp为单位
        tvRight.setTextColor(rightTextColor);
        tvRight.setCompoundDrawables(rightTextDrawableLeft, null, rightTextDrawableRight, null);
        tvRight.setCompoundDrawablePadding(rightTextDrawablePadding);

        tvLeft.setText(leftText);
        tvLeft.setTextSize(leftTextSize);
        tvLeft.setTextColor(leftTextColor);
        tvLeft.setCompoundDrawables(leftTextDrawableLeft, null, leftTextDrawableRight, null);
        tvLeft.setCompoundDrawablePadding(leftTextDrawablePadding);

        tvRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                OnRightTextClick();
            }
        });

        tvLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onLeftTextClick();
            }
        });
    }

    private void onLeftTextClick() {
        for (OnLeftTextClickListener leftTextClickListener : leftTextClickListeners) {
            leftTextClickListener.onClick(this);
        }
    }

    private void OnRightTextClick() {
        for (OnRightTextClickListener rightTextClickListener : rightTextClickListeners) {
            rightTextClickListener.onClick(this);
        }
    }

    public CharSequence getRightText() {
        return tvRight.getText();
    }

    public CharSequence getLeftText() {
        return tvLeft.getText();
    }

    private List<OnLeftTextClickListener> leftTextClickListeners = new ArrayList<>();
    private List<OnRightTextClickListener> rightTextClickListeners = new ArrayList<>();

    public void addOnLeftTextClickListener(OnLeftTextClickListener leftTextClickListener) {
        if (!leftTextClickListeners.contains(leftTextClickListener)) {
            leftTextClickListeners.add(leftTextClickListener);
        }
    }

    public void addOnRightTextClickListener(OnRightTextClickListener rightTextClickListener) {
        if (!rightTextClickListeners.contains(rightTextClickListener)) {
            rightTextClickListeners.add(rightTextClickListener);
        }
    }

    private void setBounds(Drawable rightTextDrawableLeft, int rightTextDrawableLeftSize) {
        if (rightTextDrawableLeft != null) {
            if (rightTextDrawableLeftSize > 0) {
                rightTextDrawableLeft.setBounds(0, 0, rightTextDrawableLeftSize, rightTextDrawableLeftSize);
            } else {
                rightTextDrawableLeft.setBounds(0, 0, rightTextDrawableLeft.getMinimumWidth(), rightTextDrawableLeft.getMinimumHeight());
            }
        }
    }
}
