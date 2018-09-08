package br.com.wolneyhqf.aulas.appcbr.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;

import br.com.wolneyhqf.aulas.appcbr.R;
import br.com.wolneyhqf.aulas.appcbr.util.ImageResizeUtils;
import br.com.wolneyhqf.aulas.appcbr.util.PermissionUtil;
import br.com.wolneyhqf.aulas.appcbr.util.SDCardUtils;
import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileActivity extends BaseActivity {

    private CircleImageView circleImageViewProfile;
    private ImageButton imageButtonCamera;
    private File photoFile;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private final String TAG = "appcbr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        circleImageViewProfile = (CircleImageView) findViewById(R.id.imageview_profile);
        Picasso.with(getBaseContext()).load("https://firebasestorage.googleapis.com/v0/b/app-cbr-164616.appspot.com/o/usuarios%2Fprofile.jpg?alt=media&token=2a11b7f6-1edd-4bda-b42f-3360216b1f27")
                .placeholder(R.drawable.profile)
                .error(R.drawable.profile)
                .into(circleImageViewProfile);

        imageButtonCamera = (ImageButton) findViewById(R.id.image_button_camera);
        imageButtonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
                if(PermissionUtil.validate(ProfileActivity.this, 0, permissions)){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    photoFile = SDCardUtils.getPrivateFile(getBaseContext(), "profile.jpg", Environment.DIRECTORY_PICTURES);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(intent, 0);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode==RESULT_OK && photoFile!=null){
            int w = circleImageViewProfile.getWidth();
            int h = circleImageViewProfile.getHeight();
            Bitmap bitmap = ImageResizeUtils.getResizedImage(Uri.fromFile(photoFile), w, h, false);
            circleImageViewProfile.setImageBitmap(bitmap);
            uploadFirebaseStorage();
        }
    }

    public void uploadFirebaseStorage(){
        StorageReference storageReference = storage.getReferenceFromUrl("gs://app-cbr-164616.appspot.com");

        StorageReference fileReference = storageReference.child("usuarios/profile.jpg");

        UploadTask uploadTask = fileReference.putFile(Uri.fromFile(photoFile));

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Log.d(TAG, "upload realizado com sucesso!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.e(TAG, "ocorreu um erro no upload!");
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
