package br.com.wolneyhqf.android.aulas.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button_activity_elevation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ElevationActivity.class);
                startActivity(intent);
            }
        });

        Button buttonRipple = (Button) findViewById(R.id.button_activity_ripple);
        buttonRipple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RippleActivity.class);
                startActivity(intent);
            }
        });

        Button buttonFab = (Button) findViewById(R.id.button_activity_fab);
        buttonFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FABActivity.class);
                startActivity(intent);
            }
        });

        Button buttonCardView = (Button) findViewById(R.id.button_activity_cardview);
        buttonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                startActivity(intent);
            }
        });

        Button buttonRecyclerView = (Button) findViewById(R.id.button_activity_recycler_view);
        buttonRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        Button buttonToolbar = (Button) findViewById(R.id.button_activity_toolbar);
        buttonToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ToolbarActivity.class);
                startActivity(intent);
            }
        });
    }
}
