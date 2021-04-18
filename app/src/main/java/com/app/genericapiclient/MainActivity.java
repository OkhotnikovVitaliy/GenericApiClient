package com.app.genericapiclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Button;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnAddComment;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddComment = (Button) findViewById(R.id.btn_add_comment);
        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        controller = new Controller(this);
        controller.initData();

    }

    public void showRecyclerList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        dividerItemDecoration.setDrawable(Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.divider_drawable, null)));
        recyclerView.addItemDecoration(dividerItemDecoration);
        PostsAdapter adapter = new PostsAdapter(controller.getMyJoke());
        recyclerView.setAdapter(adapter);
    }
}