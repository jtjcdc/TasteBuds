package com.example.tastebudsv3;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

//import java.util.Currency;

//import android.context.Context;


public class CameraActivity extends AppCompatActivity {

    // private static DateIntervalFormat Calender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    private static final String [] PERMISSIONS = {
            Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private static final int REQUEST_PERMISSIONS = 34;

    private static final int PERMISSIONS_COUNT = 3;

    @SuppressLint("NewApi")
    private boolean arePermissionsDenied() {
        for(int i =0; i < PERMISSIONS_COUNT; i++)
        {
            if(checkSelfPermission(PERMISSIONS[i])!= PackageManager.PERMISSION_GRANTED)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    @SuppressLint("NewApi")
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int [] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_PERMISSIONS && grantResults.length > 0 )
        {
            if(arePermissionsDenied())
            {
                ((ActivityManager) (this.getSystemService(ACTIVITY_SERVICE))).clearApplicationUserData();
                recreate();
            }
            else
            {
                onResume();
            }
        }
    }

    private boolean isCameraInitialized;
    private Camera mCamera = null;
    private static SurfaceHolder myHolder;
    private static CameraPreview mPreview;
    private FrameLayout preview;
    private Button flashB;
    private static OrientationEventListener orientationEventListener = null;
    private static boolean fM;
    private int effectIndex = 0;

    //private CameraPreview

    @Override
    protected void onResume(){
        super.onResume();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && arePermissionsDenied())
        {
            requestPermissions(PERMISSIONS, REQUEST_PERMISSIONS);
            return;
        }

        if(!isCameraInitialized)
        {
            //isCameraInitialized = true;
            mCamera = Camera.open();
            mPreview = new CameraPreview(this, mCamera);
            preview = findViewById(R.id.camera_preview);
            preview.addView(mPreview);
            rotateCamera();

            flashB = findViewById(R.id.flash);

            if(hasFlash())
            {
                flashB.setVisibility(View.VISIBLE);
            }
            else
            {
                flashB.setVisibility(View.GONE);
            }

            final Button switchCameraButton = findViewById(R.id.switchCamera);
            switchCameraButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCamera.release();
                    switchCamera();
                    rotateCamera();

                    try
                    {
                        mCamera.setPreviewDisplay(myHolder);
                    }
                    catch(Exception e)
                    {

                    }

                    mCamera.startPreview();

                    if(hasFlash())
                    {
                        flashB.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        flashB.setVisibility(View.GONE);
                    }

                }
            });

            final Button effectsButton = findViewById(R.id.effects);



            effectsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    p.setColorEffect(camEffects.get(effectIndex));
                    mCamera.setParameters(p);
                    effectIndex++;
                    if(effectIndex == camEffects.size())
                    {
                        effectIndex = 0;
                    }
                }
            });

            if(camEffects.size() == 0)
            {
                effectsButton.setVisibility(View.GONE);
            }

            final Button takePhotoButton = findViewById(R.id.takePhoto);
            takePhotoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try
                    {
                        mCamera.takePicture(null, null, mPicture);
                        mCamera.startPreview();
                    }
                    catch (Exception e)
                    {

                    }
                }
            });
            orientationEventListener = new OrientationEventListener(this) {
                @Override
                public void onOrientationChanged(int orientation) {
                    rotateCamera();

                }
            };
            orientationEventListener.enable();
            preview.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(whichCamera)
                    {
                        if(fM)
                        {
                            p.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
                        }
                        else
                        {
                            p.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
                        }
                        try
                        {
                            mCamera.setParameters(p);
                        }
                        catch(Exception e)
                        {

                        }
                        fM = !fM;

                    }
                    return true;
                }
            });
        }
    }

    private Camera.PictureCallback mPicture = new Camera.PictureCallback(){
        @Override
        public void onPictureTaken(byte[] data, Camera camera){
            try{
                FileOutputStream fos = new FileOutputStream(saveFile(String.valueOf(
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)))+ ".jpeg");
                fos.write(data);
                fos.close();
            }
            catch (Exception e)
            {

            }


        }
    };

    private static String saveFile(String filePath){
        File f = new File(filePath);

        if(!f.exists())
        {
            f.mkdir();
        }
        //return f + "/" + new SimpleDateFormat("MMddHHmmss").format(Calender.getInstance().getTime());

        return f + "/" + new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime());
    }

    private void switchCamera()
    {
        if(whichCamera)
        {
            mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);
        }
        else
        {
            mCamera = Camera.open();
        }
        whichCamera = !whichCamera;
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        releaseCamera();
    }
    private void releaseCamera()
    {
        if(mCamera != null)
        {
            preview.removeView(mPreview);
            mCamera.release();
            orientationEventListener.disable();
            mCamera = null;
            whichCamera = !whichCamera;
        }
    }

    private static List<String> camEffects;


    private static boolean hasFlash()
    {
        camEffects = p.getSupportedColorEffects();
        final List<String> flashModes = p.getSupportedFlashModes();

        if(flashModes == null)
        {
            return false;
        }

        for(String flashMode:flashModes)
        {
            if(Camera.Parameters.FLASH_MODE_ON.equals(flashModes))
            {
                return true;
            }
        }

        return false;
    }


    private static int rotation;

    private static boolean whichCamera = true;

    private static Camera.Parameters p;

    private void rotateCamera()
    {
        if(mCamera != null)
        {
            rotation = this.getWindowManager().getDefaultDisplay().getRotation();
        }

        if(rotation == 0)
        {
            rotation = 90;
        }
        else if(rotation == 1)
        {
            rotation = 0;
        }
        else if(rotation == 2)
        {
            rotation = 270;
        }
        else
        {
            rotation = 180;
        }

        mCamera.setDisplayOrientation(rotation);
        if(!whichCamera)
        {
            if(rotation == 90)
            {
                rotation = 270;
            }
            else if(rotation == 270)
            {
                rotation = 90;
            }
        }
        p = mCamera.getParameters();
        p.setRotation(rotation);
        mCamera.setParameters(p);

    }

    private static class CameraPreview extends SurfaceView implements SurfaceHolder.Callback
    {
        private static SurfaceHolder mHolder;
        private static Camera mCamera;

        private CameraPreview(CameraActivity context, Camera camera)
        {
            super(context);
            mCamera = camera;
            mHolder = getHolder();
            mHolder.addCallback(this);
            mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

        public void surfaceCreated(SurfaceHolder holder)
        {
            myHolder = holder;

            try
            {
                mCamera.setPreviewDisplay(holder);
                mCamera.startPreview();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

        }

        public void surfaceDestroyed(SurfaceHolder holder)
        {

        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
        {

        }

    }

}
