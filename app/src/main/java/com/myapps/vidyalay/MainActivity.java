package com.myapps.vidyalay;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private GridView gridView;
    private GridViewAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                //Create intent
                switch (item.getTitle()) {

                    case "Image#0":
                        Intent intent = new Intent(MainActivity.this, Class1.class);
                        startActivity(intent);
                        break;

                    case "Image#1":
                        Toast.makeText(getApplicationContext(), "Tutorials for Class 2 : Coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    case "Image#2":
                        Toast.makeText(getApplicationContext(), "Tutorials for Class 3 : Coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    case "Image#3":
                        Toast.makeText(getApplicationContext(), "Tutorials for Class 4 : Coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    case "Image#4":
                        Toast.makeText(getApplicationContext(), "Tutorials for Class 5 : Coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    case "Image#5":
                        Toast.makeText(getApplicationContext(), "Tutorials for Class 6 : Coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    case "Image#6":
                        Toast.makeText(getApplicationContext(), "Tutorials for Class 7 : Coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    case "Image#7":
                        Toast.makeText(getApplicationContext(), "Tutorials for Class 8 : Coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    case "Image#8":
                        Toast.makeText(getApplicationContext(), "Tutorials for Class 9 : Coming soon", Toast.LENGTH_SHORT).show();
                        break;


                }
            }
        });
    }

    /**
     * Prepare some dummy data for gridview
     */
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }
        return imageItems;
    }
}