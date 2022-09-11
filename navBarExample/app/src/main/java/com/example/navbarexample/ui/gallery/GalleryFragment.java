package com.example.navbarexample.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
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

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       // final TextView textView = binding.textGallery;
        //galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        final ImageView hedMobOne = (ImageView) getView().findViewById(R.id.hedMobOne);
        LinearLayout pp = (LinearLayout) getView().findViewById(R.id.pp);
        LinearLayout ph2 = (LinearLayout) getView().findViewById(R.id.ph2);

        //registerForContextMenu(hedMobOne);
        hedMobOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerForContextMenu(hedMobOne);
            }
        });

        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerForContextMenu(pp);
            }
        });

        ph2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                // Initializing the popup menu and giving the reference as current context
                PopupMenu popupMenu = new PopupMenu(getActivity(), ph2);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
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
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}