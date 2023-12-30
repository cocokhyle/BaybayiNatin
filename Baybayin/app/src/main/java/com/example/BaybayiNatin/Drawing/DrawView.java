package com.example.BaybayiNatin.Drawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class DrawView extends View {
    private Path drawPath;
    private Paint drawPaint, canvasPaint;
    private int paintColor = 0xFF000000; // Default paint color (black)
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    private boolean eraseMode = false;
    private float eraserWidth = 30; // Set your desired eraser width here

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    private void setupDrawing() {
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(40);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;
            default:
                return false;
        }


        invalidate();
        return true;
    }

    public void setColor(int color) {
        eraseMode = false;
        paintColor = color;
        drawPaint.setColor(paintColor);
    }

    public void setErase(boolean isErasing) {
        eraseMode = isErasing;
        if (isErasing) {
            drawPaint.setColor(0xFFFFFFFF); // Set color to white for erasing
            drawPaint.setStrokeWidth(eraserWidth);
        } else {
            drawPaint.setColor(paintColor);
        }
    }

    public void clearCanvas() {
        drawCanvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        invalidate();
    }
    public Bitmap cropImageBasedOnStrokes(Bitmap inputImage) {
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        // Initialize boundary coordinates with the maximum and minimum possible values
        int left = width;
        int right = 0;
        int top = height;
        int bottom = 0;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Check if the pixel is part of the drawing stroke (you may need to adjust this condition)
                if (isStrokePixel(inputImage.getPixel(x, y))) {
                    // Update boundary coordinates
                    if (x < left) {
                        left = x;
                    }
                    if (x > right) {
                        right = x;
                    }
                    if (y < top) {
                        top = y;
                    }
                    if (y > bottom) {
                        bottom = y;
                    }
                }
            }
        }

        if (left <= right && top <= bottom) {
            // Crop the image based on the boundaries
            return Bitmap.createBitmap(inputImage, left, top, right - left + 1, bottom - top + 1);
        } else {
            // No drawing strokes found, return the original image
            return inputImage;
        }
    }

    public boolean isStrokePixel(int pixelColor) {
        // You need to define the criteria for identifying stroke pixels here.
        // For example, you can consider non-white pixels as part of the stroke.
        return pixelColor != Color.WHITE;
    }

    public void saveDrawingWithWhiteBackground(Context context, String fileName) {
        // Create a new bitmap with a white background
        Bitmap drawingWithWhiteBackground = Bitmap.createBitmap(canvasBitmap.getWidth(), canvasBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(drawingWithWhiteBackground);
        canvas.drawColor(Color.WHITE); // Fill with white background

        // Draw the user's drawing on top of the white background
        canvas.drawBitmap(canvasBitmap, 0, 0, null);

        // Crop the image based on the user's drawing strokes
        Bitmap croppedImage = cropImageBasedOnStrokes(drawingWithWhiteBackground);


        // Save the cropped image to the gallery
        MediaStore.Images.Media.insertImage(context.getContentResolver(), croppedImage, "Your Image Title", "Your Image Description");

        // Save the cropped image to internal storage
        try {
            FileOutputStream outStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            croppedImage.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.flush();
            outStream.close();


        } catch (IOException e) {
            e.printStackTrace();
            // Handle any errors that occur during the save process
            String message = "Failed to save image to internal storage";
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isImageAllWhite(Bitmap image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (image.getPixel(x, y) != Color.WHITE) {
                    return false; // The image is not all white
                }
            }
        }
        return true; // The image is all white
    }

    public void saveDrawingWithWhiteBackground() {
        saveDrawingWithWhiteBackground(getContext(), "your_image.jpg");
    }

}
