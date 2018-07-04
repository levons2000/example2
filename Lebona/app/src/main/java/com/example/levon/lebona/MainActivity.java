package com.example.levon.lebona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<Model> arrayList = new ArrayList<>();
        Model model = new Model("https://vignette.wikia.nocookie.net/darksouls/images/2/24/Solar_from_astora.png/revision/latest?cb=20160606060110&path-prefix=ru");
        arrayList.add(model);
        arrayList.add(model);
        arrayList.add(model);
        final AdapterForPosts adapterForPosts = new AdapterForPosts(arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        adapterForPosts.setOnItemClickListener(new AdapterForPosts.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                arrayList.get(position).counters.plusLike();
                adapterForPosts.notifyItemChanged(position);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerid);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterForPosts);



    }

}
