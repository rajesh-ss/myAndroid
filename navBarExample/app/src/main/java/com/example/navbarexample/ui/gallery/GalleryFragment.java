package com.example.navbarexample.ui.gallery;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navbarexample.R;
import com.example.navbarexample.databinding.FragmentGalleryBinding;
import com.google.android.material.snackbar.Snackbar;

import java.nio.InvalidMarkException;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    LinearLayout linearLayout;
    private static final String TAG = "main";
    HorizontalScrollView horscr;
    TextView nameDis;
    Button btn;
    LayoutInflater li;
    ScrollView layout;

    ImageButton moto1Arrow;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//        registerForContextMenu(root.findViewById(R.id.hedMobOne));  getListView()
        registerForContextMenu(root.findViewById(R.id.hedMobOne));

        // final TextView textView = binding.textGallery;
        //galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        nameDis = (TextView) getView().findViewById(R.id.nameDis);
        Bundle extras =  getActivity().getIntent().getExtras();
        String hh = "";
        //extras.getString("email");

        btn = (Button)  getView().findViewById(R.id.raters);
        nameDis.setText(hh);
        //Toast.makeText(this, "onCreate Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate Dashboard");
        horscr = (HorizontalScrollView) getView().findViewById(R.id.imgscroll);

        moto1Arrow = (ImageButton) getView().findViewById(R.id.moto1Arrow);

        moto1Arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), moto1Arrow);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.egg, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        Toast.makeText(getActivity(), "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });



    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       super.onCreateContextMenu(menu, v, menuInfo);

        // you can set menu header with title icon etc
//        menu.add(Menu.NONE, R.id.a_item, Menu.NONE, "Menu A");
//        menu.add(Menu.NONE, R.id.b_item, Menu.NONE, "Menu B");

        switch (v.getId()) {

            case R.id.hedMobOne:
                menu.setHeaderTitle("Explore more offers");
                // add menu items
                menu.add(0, v.getId(), 0, "get 10% on Axis bank");
                menu.add(0, v.getId(), 0, "get 15% on pay later");
                menu.add(0, v.getId(), 0, "get 20% offer on exchange");
                break;

            case R.id.pp:
                menu.setHeaderTitle("check specs");
                // add menu items
                menu.add(0, v.getId(), 0, "get advise from experts");
                menu.add(0, v.getId(), 0, "compare with other models");
                menu.add(0, v.getId(), 0, "explore review from original buyers");
                break;
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        CharSequence title = item.getTitle();
        if ("get 10% on Axis bank".equals(title)) {
            Toast.makeText(getActivity(), "Axis bank offer", Toast.LENGTH_SHORT).show();
        } else if ("get 15% on pay later".equals(title)) {
            Toast.makeText(getActivity(), "paylater offer", Toast.LENGTH_SHORT).show();
        } else if ("get 20% offer on exchange".equals(title)) {
            Toast.makeText(getActivity(), "exchange offer", Toast.LENGTH_SHORT).show();
        }
        return true;

//        switch (item.getItemId()) {
//            case R.id.a_item:
//                Log.i("ContextMenu", "Item 1a was chosen");
//                return true;
//            case R.id.b_item:
//                Log.i("ContextMenu", "Item 1b was chosen");
//                return true;
//        }
//        return super.onContextItemSelected(item);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}