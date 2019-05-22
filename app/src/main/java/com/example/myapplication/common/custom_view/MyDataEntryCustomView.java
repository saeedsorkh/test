package com.example.myapplication.common.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.common.IClickListener;
import com.example.myapplication.common.custom_view.MyEditText;

public class MyDataEntryCustomView extends FrameLayout {

    View view;
    TypedArray myAttrs;

    MyEditText myEditText;
    AppCompatTextView textView;
    LinearLayout linearLayout;
    AppCompatImageView imageView;

    private IClickListener iClickListener;


    public MyDataEntryCustomView(Context context) {
        super(context);
        init(context,null);
    }

    public MyDataEntryCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public MyDataEntryCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public MyDataEntryCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        view = inflate(context, R.layout.data_entry, null);

        myEditText = view.findViewById(R.id.editText);
        textView = view.findViewById(R.id.textView);
        linearLayout = view.findViewById(R.id.container);
        imageView = view.findViewById(R.id.imageView);


        if (attrs != null) {
            myAttrs = context.obtainStyledAttributes(attrs,R.styleable.MyDataEntryCustomView);

            textView.setText(myAttrs.getString(R.styleable.MyDataEntryCustomView_label));

            switch (myAttrs.getInt(R.styleable.MyDataEntryCustomView_format, 0)) {
                case 1:
                    myEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                    break;
                default:
                    myEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                    break;
            }


            if (!myAttrs.getBoolean(R.styleable.MyDataEntryCustomView_is_show_icon, true)) {
                imageView.setVisibility(GONE);
            } else {
                imageView.setImageDrawable(myAttrs.getDrawable(R.styleable.MyDataEntryCustomView_icon));
            }


            myEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (b) {
                        linearLayout.setBackgroundResource(R.drawable.border_selected);
                    } else if (myEditText.getText().length() == 0) {
                        linearLayout.setBackgroundResource(R.drawable.border_unselected);
                    }
                }
            });


            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    iClickListener.click();
                }
            });
        }




        addView(view);
    }

    public String getText() {
        return myEditText.getText().toString();
    }



    public void imageViewClickListener(IClickListener iClickListener)
    {
        this.iClickListener=iClickListener;
    }
}
