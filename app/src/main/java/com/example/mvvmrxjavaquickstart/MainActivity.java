package com.example.mvvmrxjavaquickstart;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmrxjavaquickstart.data.Example;
import com.example.mvvmrxjavaquickstart.viewmodels.GeneralViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.wasteText)
    TextView wasteText;

    private GeneralViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel = new ViewModelProvider(this).get(GeneralViewModel.class);
        List<Example> list = viewModel.fetchPosts();

        for (Example example : viewModel.fetchPosts()) {
            String name = example.getTitle();
            String userId = example.getUserId().toString();
            wasteText.append("\n" + userId + " " + name + "\n" );
        }

    }
}
