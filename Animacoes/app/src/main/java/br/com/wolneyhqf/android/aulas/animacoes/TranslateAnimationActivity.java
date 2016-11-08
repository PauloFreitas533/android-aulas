package br.com.wolneyhqf.android.aulas.animacoes;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class TranslateAnimationActivity extends AppCompatActivity {

    private ImageView imageViewTranslate;
    private boolean down = false;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_animation);

        imageViewTranslate = (ImageView) findViewById(R.id.imageViewTranslate);

        Button btnTranslateAnimation = (Button) findViewById(R.id.btnTranslateAnimation);
        btnTranslateAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resourceTranslate = down ? R.anim.translate_up : R.anim.translate_down;
                down = !down;
                TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(context, resourceTranslate);
                imageViewTranslate.startAnimation(translateAnimation);
            }

        });

        Button btnObjectAnimatorTranslate = (Button) findViewById(R.id.btnObjectAnimatorTranslate);
        btnObjectAnimatorTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.translate);
                objectAnimator.setTarget(imageViewTranslate);
                if(down){
                    objectAnimator.reverse();
                }else {
                    objectAnimator.start();
                }
                down = !down;
            }
        });
    }
}
