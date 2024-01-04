package com.example.BaybayiNatin.Drawing;

import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_NasulatA;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_NasulatEI;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_NasulatOU;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.BaybayiNatin.Activity.MainActivity;
import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.ml.Model;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.File;
import java.io.IOException;

public class Yunit2_Drawing extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public static String a = "a";
    public static String ei = "ei";
    public static String ou = "ou";
    private DrawView drawView;
    private ImageButton drawButton, eraseButton;

    ImageButton back, next;
    Button suriin, bumalik;
    TextView result;

    String currentImage;

    String A;
    String EI;
    String OU;

    private int currentImageIndex = 0;
    private int[] imageResources = {
            R.drawable.baybayin_letter_a,
            R.drawable.baybayin_letter_ei,
            R.drawable.baybayin_letter_ou,
           /* R.drawable.baybayin_letter_dara,
            R.drawable.baybayin_letter_ga,
            R.drawable.baybayin_letter_ha,
            R.drawable.baybayin_letter_ka,
            R.drawable.baybayin_letter_la,
            R.drawable.baybayin_letter_ma,
            R.drawable.baybayin_letter_na,
            R.drawable.baybayin_letter_nga,
            R.drawable.baybayin_letter_pa,
            R.drawable.baybayin_letter_sa,
            R.drawable.baybayin_letter_ta,
            R.drawable.baybayin_letter_wa,
            R.drawable.baybayin_letter_ya*/


    };

    private String[] groundTruthLabels = {
            "a",
            "ei",
            "ou"

            //Para sa yunit 3 to
//            "dara",
//            "ga",
//            "ha",
//            "ka",
//            "la",
//            "ma",
//            "na",
//            "nga",
//            "pa",
//            "sa",
//            "ta",
//            "wa",
//            "ya"


    };
    ImageView image;
    private Bitmap bitmap = null;

    private int score = 0;
    Boolean x = false;

    Boolean checkA = false;
    Boolean checkEI = false;
    Boolean checkOU = false;

    private static final String[] classNames = { "a", "ei", "ou",}; // Replace with your class names

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yunit2_drawing);

        TextView nameTxt = findViewById(R.id.nameTxt);

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        A = preferences.getString(a, null);
        EI = preferences.getString(ei, null);
        OU = preferences.getString(ou, null);



        back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        suriin = findViewById(R.id.saved);
        image = findViewById(R.id.image_container);
        bumalik = findViewById(R.id.bumalik);
        result = findViewById(R.id.text);

        drawView = findViewById(R.id.drawView);
        drawButton = findViewById(R.id.pencil);
        eraseButton = findViewById(R.id.eraser);
        final FrameLayout drawContainer = findViewById(R.id.drawContainer);

        TextView text = findViewById(R.id.text);

        Drawable imageDraw = image.getDrawable();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImageIndex > 0) {
                    currentImageIndex--;
                    image.setImageResource(imageResources[currentImageIndex]);
                    drawContainer.setBackgroundResource(R.drawable.container_question_black);
                    drawView.clearCanvas();
                    result.setText("");
                    if (currentImageIndex == 0){
                        currentImage = "a";
                        nameTxt.setText("a");
                    } else if (currentImageIndex == 1) {
                        currentImage = "ei";
                        nameTxt.setText("ei");
                    } else if (currentImageIndex == 2) {
                        currentImage = "ou";
                        nameTxt.setText("ou");
                    }
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImageIndex < imageResources.length - 1) {
                    currentImageIndex++;
                    image.setImageResource(imageResources[currentImageIndex]);
                    drawContainer.setBackgroundResource(R.drawable.container_question_black);
                    drawView.clearCanvas();
                    result.setText("");
                    if (currentImageIndex == 0){
                        currentImage = "a";
                        nameTxt.setText("a");
                    } else if (currentImageIndex == 1) {
                        currentImage = "ei";
                        nameTxt.setText("ei");
                    } else if (currentImageIndex == 2) {
                        currentImage = "ou";
                        nameTxt.setText("ou");
                    }
                }
            }
        });
        if (currentImageIndex == 0){
            currentImage = "a";
        } else if (currentImageIndex == 1) {
            currentImage = "ei";

        } else if (currentImageIndex == 2) {
            currentImage = "ou";
        }

        bumalik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Yunit2_Drawing.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawView.setErase(false);
                drawButton.setBackgroundResource(R.color.pale_blue);
                eraseButton.setBackgroundResource(R.color.white);
            }
        });
        eraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawView.clearCanvas();
                eraseButton.setBackgroundResource(R.color.pale_blue);
                drawButton.setBackgroundResource(R.color.white);
            }
        });

        suriin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                try {


                    drawView.saveDrawingWithWhiteBackground(); // Save the user's drawing with a white background

                    String savedImageFileName = "your_image.jpg"; // Replace with your actual filename
                    File savedImageFile = new File(getFilesDir(), savedImageFileName);


                    if (savedImageFile.exists()) {

                        Bitmap savedImageBitmap = BitmapFactory.decodeFile(savedImageFile.getAbsolutePath());
                        boolean isAllWhite = drawView.isImageAllWhite(savedImageBitmap);

                        // Notify the user about the saved image

                        if (isAllWhite) {
                            String message = "Draw first before clicking 'Suriin'.";
                            Toast.makeText(Yunit2_Drawing.this, message, Toast.LENGTH_SHORT).show();
                        } else {

                            // Perform model inference using the saved image
                            Model model = Model.newInstance(Yunit2_Drawing.this);
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(savedImageBitmap, 32, 32, true);

                            // Convert the image to grayscale
                            Bitmap grayscaleBitmap = convertToGrayscale(resizedBitmap);

                            // Create a float array to hold the pixel values
                            float[] floatArray = new float[32 * 32];
                            int index = 0;
                            for (int y = 0; y < 32; y++) {
                                for (int x = 0; x < 32; x++) {
                                    int pixel = grayscaleBitmap.getPixel(x, y);
                                    // Extract the single channel (grayscale) value
                                    floatArray[index++] = Color.red(pixel); // Assuming grayscale, so only red channel is relevant
                                }
                            }

                            // Create a TensorBuffer for the model input
                            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 1, 32, 32}, DataType.FLOAT32);
                            inputFeature0.loadArray(floatArray);

                            // Perform model inference
                            Model.Outputs outputs = model.process(inputFeature0);
                            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
                            String predictedClass = classNames[getMax(outputFeature0.getFloatArray())];


                            //Edit mo nalng to based don sa UI
                            if (predictedClass.equals(groundTruthLabels[currentImageIndex])) {
                                drawContainer.setBackgroundResource(R.drawable.container_drawing_green);
                                result.setText("Tagumpay! Letrang '" + currentImage + "' ang iyong nasulat,\n" +
                                        "Maaari ka nang magpatuloy sa susunod na patinig");

                                if (currentImage == "a") {
                                    editor.putInt(Letrang_NasulatA, 1);
                                    editor.commit();
                                }

                                if (currentImage == "ei") {
                                    editor.putInt(Letrang_NasulatEI, 1);
                                    editor.putString(ei, "ei");
                                    editor.commit();
                                }


                                if (currentImage == "ou") {
                                    editor.putInt(Letrang_NasulatOU, 1);
                                    editor.commit();
                                }

                            } else {
                                drawContainer.setBackgroundResource(R.drawable.container_drawing_red);
                                result.setText("Patawad, dahil ang iyong nasulat ay mali. Subalit maari kang sumubok muli.");
                            }



                            // Store the resized image for future use
                            bitmap = resizedBitmap;

                            model.close();
                        }
// Delete the image file
                        boolean deleted = savedImageFile.delete();

                        // Check if the file was successfully deleted
                        if (deleted) {
                            // Log or display a message indicating that the file was deleted
                            Log.d("FileDeletion", "Image file deleted.");
                        } else {
                            // Log or display a message indicating that the file couldn't be deleted
                            Log.d("FileDeletion", "Failed to delete image file.");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(Yunit2_Drawing.this, "An error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
        }
        });
    }
    int getMax(float[] arr){
        int max = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > arr[max]) max =i;
        }
        return max;
    }
    private Bitmap convertToGrayscale(Bitmap inputBitmap) {
        int width = inputBitmap.getWidth();
        int height = inputBitmap.getHeight();

        Bitmap grayscaleBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = inputBitmap.getPixel(x, y);
                int gray = Color.red(pixel); // Assuming grayscale, so only red channel is relevant
                grayscaleBitmap.setPixel(x, y, Color.rgb(gray, gray, gray));
            }
        }

        return grayscaleBitmap;
    }

}