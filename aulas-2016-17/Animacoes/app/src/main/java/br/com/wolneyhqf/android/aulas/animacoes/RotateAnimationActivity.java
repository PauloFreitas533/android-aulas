package br.com.wolneyhqf.android.aulas.animacoes;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class RotateAnimationActivity extends AppCompatActivity {

    private ImageView imageView;
    private boolean down = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_animation);

        imageView = (ImageView) findViewById(R.id.imageViewRotate);

        Button btnRotateAnimation = (Button) findViewById(R.id.btnRotateAnimation);
        btnRotateAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resourseRotate = down ? R.anim.rotate_up : R.anim.rotate_down;
                down = !down;
                RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(RotateAnimationActivity.this, resourseRotate);
                imageView.startAnimation(rotateAnimation);
            }
        });

        Button btnObjectAnimatorRotate= (Button) findViewById(R.id.btnObjectAnimatorRotate);
        btnObjectAnimatorRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(RotateAnimationActivity.this, R.animator.rotate);
                objectAnimator.setTarget(imageView);
                if(!down){
                    objectAnimator.start();
                }else{
                    objectAnimator.reverse();
                }
                down = !down;
            }
        });
    }
}
