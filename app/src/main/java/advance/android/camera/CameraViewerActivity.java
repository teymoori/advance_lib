package advance.android.camera;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.makeramen.roundedimageview.RoundedImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.util.List;

import advance.android.R;
import advance.android.utils.BaseActivity;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;


@EActivity(R.layout.activity_camera_viewer)
public class CameraViewerActivity extends BaseActivity {

    @ViewById
    RoundedImageView result;


    @ViewById
    TextView  qr ;


    @Click
    void openCamera() {
        EasyImage.openCamera(mActivity, 1);
    }

    @Click
    void qrCodeRead(){
        new IntentIntegrator(mActivity).initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult qrResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        qr.setText( qrResult.getContents()  );

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {

            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                super.onImagePickerError(e, source, type);
            }

            @Override
            public void onCanceled(EasyImage.ImageSource source, int type) {
                super.onCanceled(source, type);
            }

            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                Glide.with(mContext).load(imageFile)
                        .into(result);
                Log.d(TAG, "onImagePicked: " +  imageFile.getAbsolutePath());


//
//                File newFolder = new File("sdcard/images") ;
//                File newFile = new File("sdcard/images/my.jpg") ;
//                imageFile.renameTo(newFile);
            }
        });

    }

    @AfterViews
    void init() {
        getPermissions();
    }


//    @Override
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }

    void getPermissions() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();
    }


}
