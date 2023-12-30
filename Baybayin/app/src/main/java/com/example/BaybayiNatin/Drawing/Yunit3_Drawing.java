package com.example.BaybayiNatin.Drawing;

import static com.example.BaybayiNatin.Fragment.Home.SHARED_PREF_NAME;
import static com.example.BaybayiNatin.Fragment.Home.Yunit4_pagkilala;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatdara;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatga;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatha;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatka;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatla;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatma;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatna;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatnga;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatpa;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatsa;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatta;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatwa;
import static com.example.BaybayiNatin.Fragment.Profile.Letrang_Nasulatya;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.BaybayiNatin.Activity.MainActivity;
import com.example.BaybayiNatin.Quiz.Yunit4_Identify_baybayin;
import com.example.BaybayiNatin.R;
import com.example.BaybayiNatin.databinding.Yunit3DrawingBinding;
import com.example.BaybayiNatin.ml.Model;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.File;
import java.io.IOException;

public class Yunit3_Drawing extends AppCompatActivity {

    Yunit3DrawingBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private DrawView drawView;
    private ImageButton drawButton, eraseButton;

    ImageButton back, next;
    Button suriin, bumalik;
    TextView result;

    String currentImage;

    private int currentImageIndex = 0;
    private int[] imageResources = {
            /*R.drawable.baybayin_letter_a,
            R.drawable.baybayin_letter_ei,
            R.drawable.baybayin_letter_ou*/

            R.drawable.baybayin_letter_dara,
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
            R.drawable.baybayin_letter_ya


    };

    private String[] groundTruthLabels = {
          /*  "a",
            "ei",
            "ou"*/

            "dara", "ga", "ha", "ka", "la", "ma", "na", "nga", "pa", "sa", "ta", "wa", "ya"


    };
    ImageView image;
    private Bitmap bitmap = null;

    private static final String[] classNames = {"a", "ba", "dara", "ei", "ga", "ha", "ka", "la", "ma", "na", "nga", "ou", "pa", "sa", "ta", "wa", "ya",}; // Replace with your class names


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Yunit3DrawingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        editor = preferences.edit();

        TextView nameTxt = findViewById(R.id.nameTxt);

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
                        currentImage = "dara";
                        nameTxt.setText("dara");
                    } else if (currentImageIndex == 1) {
                        currentImage = "ga";
                        nameTxt.setText("ga");
                    } else if (currentImageIndex == 2) {
                        currentImage = "ha";
                        nameTxt.setText("ha");
                    }
                    else if (currentImageIndex == 3) {
                        currentImage = "ka";
                        nameTxt.setText("ka");
                    }
                    else if (currentImageIndex == 4) {
                        currentImage = "la";
                        nameTxt.setText("la");
                    }
                    else if (currentImageIndex == 5) {
                        currentImage = "ma";
                        nameTxt.setText("ma");
                    }
                    else if (currentImageIndex == 6) {
                        currentImage = "na";
                        nameTxt.setText("na");
                    }
                    else if (currentImageIndex == 7) {
                        currentImage = "nga";
                        nameTxt.setText("nga");
                    }
                    else if (currentImageIndex == 8) {
                        currentImage = "pa";
                        nameTxt.setText("pa");
                    }
                    else if (currentImageIndex == 9) {
                        currentImage = "sa";
                        nameTxt.setText("sa");
                    }
                    else if (currentImageIndex == 10) {
                        currentImage = "ta";
                        nameTxt.setText("ta");
                    }
                    else if (currentImageIndex == 11) {
                        currentImage = "wa";
                        nameTxt.setText("wa");
                    }
                    else if (currentImageIndex == 12) {
                        currentImage = "ya";
                        nameTxt.setText("ya");
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
                        currentImage = "dara";
                        nameTxt.setText("dara");
                    } else if (currentImageIndex == 1) {
                        currentImage = "ga";
                        nameTxt.setText("ga");
                    } else if (currentImageIndex == 2) {
                        currentImage = "ha";
                        nameTxt.setText("ha");
                    }
                    else if (currentImageIndex == 3) {
                        currentImage = "ka";
                        nameTxt.setText("ka");
                    }
                    else if (currentImageIndex == 4) {
                        currentImage = "la";
                        nameTxt.setText("la");
                    }
                    else if (currentImageIndex == 5) {
                        currentImage = "ma";
                        nameTxt.setText("ma");
                    }
                    else if (currentImageIndex == 6) {
                        currentImage = "na";
                        nameTxt.setText("na");
                    }
                    else if (currentImageIndex == 7) {
                        currentImage = "nga";
                        nameTxt.setText("nga");
                    }
                    else if (currentImageIndex == 8) {
                        currentImage = "pa";
                        nameTxt.setText("pa");
                    }
                    else if (currentImageIndex == 9) {
                        currentImage = "sa";
                        nameTxt.setText("sa");
                    }
                    else if (currentImageIndex == 10) {
                        currentImage = "ta";
                        nameTxt.setText("ta");
                    }
                    else if (currentImageIndex == 11) {
                        currentImage = "wa";
                        nameTxt.setText("wa");
                    }
                    else if (currentImageIndex == 12) {
                        currentImage = "ya";
                        nameTxt.setText("ya");
                    }
                }
            }
        });
        if (currentImageIndex == 0){
            currentImage = "dara";
        } else if (currentImageIndex == 1) {
            currentImage = "ga";

        } else if (currentImageIndex == 2) {
            currentImage = "ha";
        }
        else if (currentImageIndex == 3) {
            currentImage = "ka";
        }
        else if (currentImageIndex == 4) {
            currentImage = "la";
        }
        else if (currentImageIndex == 5) {
            currentImage = "ma";
        }
        else if (currentImageIndex == 6) {
            currentImage = "na";
        }
        else if (currentImageIndex == 7) {
            currentImage = "nga";
        }
        else if (currentImageIndex == 8) {
            currentImage = "pa";
        }
        else if (currentImageIndex == 9) {
            currentImage = "sa";
        }
        else if (currentImageIndex == 10) {
            currentImage = "ta";
        }
        else if (currentImageIndex == 11) {
            currentImage = "wa";
        }
        else if (currentImageIndex == 12) {
            currentImage = "ya";
        }

        bumalik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Yunit4_pagkilala, "pagkilala");
                editor.commit();
                Intent intent = new Intent(Yunit3_Drawing.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
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
                drawView.setErase(true);
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
                            Toast.makeText(Yunit3_Drawing.this, message, Toast.LENGTH_SHORT).show();
                        } else {

                            // Perform model inference using the saved image
                            Model model = Model.newInstance(Yunit3_Drawing.this);
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
                            if(predictedClass.equals(groundTruthLabels[currentImageIndex])){
                                drawContainer.setBackgroundResource(R.drawable.container_drawing_green);
                                result.setText("Tagumpay! Letrang '" + currentImage + "' ang iyong nasulat,\n" +
                                        "Maaari ka nang magpatuloy sa susunod na patinig");

                                if (currentImage == "dara") {
                                    editor.putInt(Letrang_Nasulatdara, 1);
                                    editor.commit();
                                }

                                if (currentImage == "ga") {
                                    editor.putInt(Letrang_Nasulatga, 1);
                                    editor.commit();
                                }


                                if (currentImage == "ha") {
                                    editor.putInt(Letrang_Nasulatha, 1);
                                    editor.commit();
                                }
                                if (currentImage == "ka") {
                                    editor.putInt(Letrang_Nasulatka, 1);
                                    editor.commit();
                                }

                                if (currentImage == "la") {
                                    editor.putInt(Letrang_Nasulatla, 1);
                                    editor.commit();
                                }


                                if (currentImage == "ma") {
                                    editor.putInt(Letrang_Nasulatma, 1);
                                    editor.commit();
                                }
                                if (currentImage == "na") {
                                    editor.putInt(Letrang_Nasulatna, 1);
                                    editor.commit();
                                }
                                if (currentImage == "nga") {
                                    editor.putInt(Letrang_Nasulatnga, 1);
                                    editor.commit();
                                }
                                if (currentImage == "pa") {
                                    editor.putInt(Letrang_Nasulatpa, 1);
                                    editor.commit();
                                }
                                if (currentImage == "sa") {
                                    editor.putInt(Letrang_Nasulatsa, 1);
                                    editor.commit();
                                }
                                if (currentImage == "ta") {
                                    editor.putInt(Letrang_Nasulatta, 1);
                                    editor.commit();
                                }
                                if (currentImage == "wa") {
                                    editor.putInt(Letrang_Nasulatwa, 1);
                                    editor.commit();
                                }
                                if (currentImage == "ya") {
                                    editor.putInt(Letrang_Nasulatya, 1);
                                    editor.commit();
                                }


                            }else{
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
                            Toast.makeText(Yunit3_Drawing.this, "An error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
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