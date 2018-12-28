package com.dhamodharan.dbRecyler;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.dhamodharan.dbRecyler.databinding.MainActivityBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    binding.contactList.setLayoutManager(layoutManager);

    List<Article> articles = new ArrayList<>();

    for (int i = 0; i <= 10 ; i++) {
      articles.add(new Article("An outbreak of parasitic bees",
          "This summer, we are facing a very serious issue. And it is nothing else but an outbreak of parasitic bees.",
          true, "https://homepages.cae.wisc.edu/~ece533/images/airplane.png", 45));
    }

    ArticleAdapter adapter = new ArticleAdapter(articles);
    binding.contactList.setAdapter(adapter);
  }
}
