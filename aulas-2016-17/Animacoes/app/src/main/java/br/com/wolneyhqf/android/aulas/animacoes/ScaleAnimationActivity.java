package br.com.wolneyhqf.android.aulas.animacoes;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class ScaleAnimationActivity extends AppCompatActivity {

    private ImageView imageViewScale;
    private boolean show = false;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_animation);

        imageViewScale = (ImageView) findViewById(R.id.imageViewScale);

        Button buttonScaleAnimation = (Button) findViewById(R.id.btnScaleAnimation);
        buttonScaleAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resourceScale = show ? R.anim.scale_grow : R.anim.scale_shrink;
                show = !show;
                ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(context, resourceScale);
                imageViewScale.startAnimation(scaleAnimation);
            }
        });

        Button buttonObjectAnimatorScale = (Button) findViewById(R.id.btnObjectAnimatorScale);
        buttonObjectAnimatorScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PropertyValuesHolder xScale = null;
                PropertyValuesHolder yScale = null;
                if(show){
                    xScale = PropertyValuesHolder.ofFloat("scaleX", 0, 1);
                    yScale = PropertyValuesHolder.ofFloat("scaleY", 0, 1);
                }else{
                    xScale = PropertyValuesHolder.ofFloat("scaleX", 1, 0);
                    yScale = PropertyValuesHolder.ofFloat("scaleY", 1, 0);
                }
                show = !show;
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageViewScale, xScale, yScale);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
            }
        });

    }
}
