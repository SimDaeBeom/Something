package com.simdaebeom.sample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceLandmark;

import java.util.List;

public class FaceActivity extends Activity {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_face);
        mContext = this;

        final RelativeLayout RelativeLayout_main = findViewById(R.id.RelativeLayout_main);

        FirebaseVisionFaceDetectorOptions options =
                new FirebaseVisionFaceDetectorOptions.Builder()
                        .setPerformanceMode(FirebaseVisionFaceDetectorOptions.ACCURATE)
                        .setLandmarkMode(FirebaseVisionFaceDetectorOptions.ALL_LANDMARKS)
                        .setClassificationMode(FirebaseVisionFaceDetectorOptions.ALL_CLASSIFICATIONS)
                        .build();

        final Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(),R.drawable.beom);


        final FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        FirebaseVisionFaceDetector detector = FirebaseVision.getInstance()
                .getVisionFaceDetector(options);

        Task<List<FirebaseVisionFace>> result =
                detector.detectInImage(image)
                        .addOnSuccessListener(
                                new OnSuccessListener<List<FirebaseVisionFace>>() {
                                    @Override
                                    public void onSuccess(List<FirebaseVisionFace> faces) {
                                        // Task completed successfully

                                        Log.d("FACES",faces.toString());
                                        Point point = new Point();
                                        Display display = getWindowManager().getDefaultDisplay();
                                        display.getSize(point);


                                        for (FirebaseVisionFace face : faces) {

                                            // If landmark detection was enabled (mouth, ears, eyes, cheeks, and
                                            // nose available):
                                            FirebaseVisionFaceLandmark leftEye = face.getLandmark(FirebaseVisionFaceLandmark.LEFT_EYE);
                                            float le_x =  leftEye.getPosition().getX();
                                            float le_y = leftEye.getPosition().getY();

                                            FirebaseVisionFaceLandmark rightEye = face.getLandmark(FirebaseVisionFaceLandmark.RIGHT_EYE);
                                            float re_x =  rightEye.getPosition().getX();
                                            float re_y = rightEye.getPosition().getY();

                                            FirebaseVisionFaceLandmark leftCheek = face.getLandmark(FirebaseVisionFaceLandmark.LEFT_CHEEK);
                                            float lc_x = leftCheek.getPosition().getX();
                                            float lc_y = leftCheek.getPosition().getY();

                                            FirebaseVisionFaceLandmark rightCheek = face.getLandmark(FirebaseVisionFaceLandmark.RIGHT_CHEEK);
                                            float rc_x = rightCheek.getPosition().getX();
                                            float rc_y =  rightCheek.getPosition().getY();

                                            ImageView imageLE = new ImageView(mContext);
                                            imageLE.setImageResource(R.drawable.eyes);
                                            imageLE.setX(point.x*le_x/bitmap.getWidth()-100);
                                            imageLE.setY(point.y*le_y/bitmap.getHeight()-100);
                                            RelativeLayout_main.addView(imageLE);
                                            imageLE.setLayoutParams(new RelativeLayout.LayoutParams(200,200));

                                            ImageView imageRE = new ImageView(mContext);
                                            imageRE.setImageResource(R.drawable.eyes);
                                            imageRE.setX(point.x*re_x/bitmap.getWidth()-100);
                                            imageRE.setY(point.y*re_y/bitmap.getHeight()-100);
                                            RelativeLayout_main.addView(imageRE);
                                            imageRE.setLayoutParams(new RelativeLayout.LayoutParams(200,200));

                                            ImageView imageLC = new ImageView(mContext);
                                            imageLC.setImageResource(R.drawable.left);
                                            imageLC.setX(point.x*lc_x/bitmap.getWidth()-100);
                                            imageLC.setY(point.y*lc_y/bitmap.getHeight()-100);
                                            RelativeLayout_main.addView(imageLC);
                                            imageLC.setLayoutParams(new RelativeLayout.LayoutParams(200,200));


                                            ImageView imageRC = new ImageView(mContext);
                                            imageRC.setImageResource(R.drawable.right);
                                            imageRC.setX(point.x*rc_x/bitmap.getWidth()-100);
                                            imageRC.setY(point.y*rc_y/bitmap.getHeight()-100);
                                            RelativeLayout_main.addView(imageRC);
                                            imageRC.setLayoutParams(new RelativeLayout.LayoutParams(200,200));




                                        }

                                    }
                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // Task failed with an exception
                                        // ...
                                    }
                                });


    }
}
