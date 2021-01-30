package com.avishekdas128.languagedrawbaleexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.avishekdas128.languageDrawable.LanguageDrawable;
import com.avishekdas128.languageDrawable.LanguageModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private View languageLayout;
    private List<LanguageModel> languageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        languageLayout = findViewById(R.id.language_layout);
        setupLanguageList();
        setupLanguageLayout();
    }

    private void setupLanguageList() {
        languageList = new ArrayList<>();
        languageList.add(new LanguageModel(.2f, Color.RED));
        languageList.add(new LanguageModel(.1f, Color.GREEN));
        languageList.add(new LanguageModel(.4f, Color.BLUE));
        languageList.add(new LanguageModel(.3f, Color.BLACK));
    }

    private void setupLanguageLayout() {
        languageLayout.setBackground(new LanguageDrawable(languageList));
    }
}