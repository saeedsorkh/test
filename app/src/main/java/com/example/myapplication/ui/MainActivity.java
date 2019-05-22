package com.example.myapplication.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.business.IListUser;
import com.example.myapplication.common.IClickListener;
import com.example.myapplication.common.NetManager;
import com.example.myapplication.common.custom_view.MyDataEntryCustomView;
import com.example.myapplication.common.exception.MyException;
import com.example.myapplication.model.Container;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private static final String TAG ="MainActivity" ;

//    MyDataEntryCustomView myDataEntryCustomView;


    @Override
    protected int content() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUp() {
        super.setUp();

//        myDataEntryCustomView = findViewById(R.id.myController);
//
//
//        try {
//            showMessage("this is main activity");
//        } catch (Exception e) {
//
//
//            showException(new MyException("144", "exception in setup method"));
//        }
//
//        myDataEntryCustomView.imageViewClickListener(new IClickListener() {
//            @Override
//            public void click() {
//
//            }
//        });
        Log.d(TAG, "setUp() called");
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        new NetManager().getRetrofit().create(IListUser.class).getUsers(2).enqueue(new Callback<Container>() {
            @Override
            public void onResponse(Call<Container> call, Response<Container> response) {
                if (response.isSuccessful()) {
                    Container containers = response.body();
                    LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                    llm.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(llm);
                    assert containers != null;
                    recyclerView.setAdapter(new Adapter(getApplicationContext(),containers.getData()));
                }

            }

            @Override
            public void onFailure(Call<Container> call, Throwable t) {
                showException(t);
            }
        });


    }
}
