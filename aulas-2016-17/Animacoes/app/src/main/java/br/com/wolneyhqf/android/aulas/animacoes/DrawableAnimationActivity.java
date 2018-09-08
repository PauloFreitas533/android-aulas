package br.com.wolneyhqf.android.aulas.animacoes;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DrawableAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);

        ImageView imgDrawableAnimation = (ImageView) findViewById(R.id.imgAnimationDrawable);

        AnimationDrawable animationDrawable = (AnimationDrawable) imgDrawableAnimation.getDrawable();
        animationDrawable.start();
    }
}
