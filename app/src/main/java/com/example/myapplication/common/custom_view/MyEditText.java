package com.example.myapplication.common.custom_view;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.example.myapplication.R;

public class MyEditText extends AppCompatEditText {


    public MyEditText(Context context) {
        super(context);
        init(context,null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.setBackgroundColor(getResources().getColor(R.color.color_transparent));
    }
}
