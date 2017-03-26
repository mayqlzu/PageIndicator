package com.mayqlzu.android.pageindicator;

import android.graphics.pdf.PdfDocument;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private PageIndicator pageIndicator;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageIndicator = (PageIndicator) findViewById(R.id.page_indicator);
        btn = (Button) findViewById(R.id.btn);

        final int count = pageIndicator.getCount();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = pageIndicator.getCurrentIndex();
                index = (index + 1) % count;
                pageIndicator.setCurrentIndex(index);
            }
        });
    }
}
