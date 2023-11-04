package uz.coder.d2lesson59.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import uz.coder.d2lesson59.adapter.NewsAdapter;
import uz.coder.d2lesson59.model.NewsModel;
import uz.coder.d2lesson59.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private List<NewsModel> newsModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        NewsAdapter newsAdapter = new NewsAdapter(this,newsModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        binding.review.setAdapter(newsAdapter);
        binding.review.setLayoutManager(linearLayoutManager);
        binding.review.addItemDecoration(decoration);
    }

    private void loadData() {
        newsModelList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            newsModelList.add(new NewsModel("Yevrokomissiya rahbari G7 sammitida Xitoyning sarmoyaviy tashabbuslarini tanqid qildi","23:07 / 20.05.2023","https://storage.kun.uz/source/thumbnails/_medium/9/PtakfljEBiFR0oYXeoEkYnknD7K0gidI_medium.jpg"));
            newsModelList.add(new NewsModel("Haj jarayonlari nega bunchalik yopiq, qachon adolatli tender bo‘ladi? Diniy qo‘mitaga savollar","22:49 / 20.05.2023","https://storage.kun.uz/source/thumbnails/_medium/9/2HCJSZzPda15Bq-E6ku9PYcBKEzG6h1G_medium.jpg"));
            newsModelList.add(new NewsModel("Hindiston yo‘tal siropidan o‘limlar tufayli farmatsevtika siyosatini o‘zgartirmoqchi","22:00 / 20.05.2023","https://storage.kun.uz/source/thumbnails/_medium/9/G9HXotqNAb67ATkl6QiccCk0ArZ-qiyR_medium.jpg"));
            newsModelList.add(new NewsModel("10,8 ming dollardan sotuvga chiqqan Geely Coolray krossoveri va ekransiz noutbuk – hafta texnodayjesti","20:02 / 20.05.2023","https://storage.kun.uz/source/thumbnails/_medium/9/LBUpjUBAQx0lFgIb-szi4QR0NgRNjEfj_medium.jpg"));
            newsModelList.add(new NewsModel("INFINIX’dan mobil o‘yinlarning yangi darajasi","18:54 / 20.05.2023","https://storage.kun.uz/source/thumbnails/_medium/9/JUKcyPbV-kaQPTF5hexexihY6Ep5i90S_medium.jpg"));
        }
    }
}