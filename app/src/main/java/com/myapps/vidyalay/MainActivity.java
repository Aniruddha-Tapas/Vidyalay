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
                        Intent intent2 = new Intent(MainActivity.this, Class2.class);
                        startActivity(intent2);
                        break;
                    case "Image#2":
                        Intent intent3 = new Intent(MainActivity.this, Class3.class);
                        startActivity(intent3);
                        break;
                    case "Image#3":
                        Intent intent4 = new Intent(MainActivity.this, Class4.class);
                        startActivity(intent4);
                        break;
                    case "Image#4":
                        Intent intent5 = new Intent(MainActivity.this, Class5.class);
                        startActivity(intent5);
                        break;
                    case "Image#5":
                        Intent intent6 = new Intent(MainActivity.this, Class6.class);
                        startActivity(intent6);
                        break;
                    case "Image#6":
                        Intent intent7 = new Intent(MainActivity.this, Class7.class);
                        startActivity(intent7);
                        break;
                    case "Image#7":
                        Intent intent8 = new Intent(MainActivity.this, Class8.class);
                        startActivity(intent8);
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