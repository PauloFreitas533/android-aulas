package br.com.wolneyhqf.android.aulas.animacoes;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AlphaAnimationActivity extends AppCompatActivity {

    private ImageView imageView;
    private boolean show = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_animation);

        imageView = (ImageView) findViewById(R.id.imageViewFadeInOut);
        // Esse botão utiliza o Framework "View Animation" para gerar animações (Utilizado até o Android 2.X)
        Button buttonAlphaAnimation = (Button) findViewById(R.id.btnAlphaAnimation);
        buttonAlphaAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Animação pelo XML
                int resourceAnimation = show ? R.anim.alpha_fade_in : R.anim.alpha_fade_out;
                show = !show;//
                Animation animation = AnimationUtils.loadAnimation(AlphaAnimationActivity.this, resourceAnimation);
                imageView.startAnimation(animation);
            }
        });

        // Esse botão utiliza o Framework "Property Animations" para gerar animações (Criado e utilizado a partir do Android 3.0)
        Button buttonObjectAnimatorAlpha = (Button) findViewById(R.id.btnObjectAnimatorAlpha);
        buttonObjectAnimatorAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(AlphaAnimationActivity.this, R.animator.alpha);
                objectAnimator.setTarget(imageView);
                if(!show){
                    objectAnimator.start();
                }else{
                    objectAnimator.reverse();
                }
                show = !show;
            }
        });
    }
}
