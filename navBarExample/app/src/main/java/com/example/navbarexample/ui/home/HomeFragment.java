package com.example.navbarexample.ui.home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.ims.ImsException;
import android.util.Log;
import android.view.LayoutInflater;
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
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navbarexample.Login;
import com.example.navbarexample.NotificationView;
import com.example.navbarexample.R;
import com.example.navbarexample.databinding.FragmentHomeBinding;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    LinearLayout linearLayout;
    private static final String TAG = "main";
    HorizontalScrollView horscr;
    TextView nameDis;
    Button btn;
    LayoutInflater li;
    ScrollView layout;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        nameDis = (TextView) getView().findViewById(R.id.nameDis);
        Bundle extras =  getActivity().getIntent().getExtras();
        String hh = "";
        Button logout;
        //extras.getString("email");

        btn = (Button)  getView().findViewById(R.id.raters);
        nameDis.setText(hh);
        //Toast.makeText(this, "onCreate Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate Dashboard");
        horscr = (HorizontalScrollView) getView().findViewById(R.id.imgscroll);
        Button expph = (Button) getView().findViewById(R.id.expph);
        Button expMsg = (Button) getView().findViewById(R.id.expMsg);
        Button expmail = (Button) getView().findViewById(R.id.expmail);
        ImageButton moto1Whatsup = (ImageButton) getView().findViewById(R.id.moto1Whatsup);
        ImageButton apple1whatsup = (ImageButton) getView().findViewById(R.id.apple1whatsup);
        ImageButton moto1web = (ImageButton) getView().findViewById(R.id.moto1web);
        ImageButton apple1web = (ImageButton) getView().findViewById(R.id.apple1web);
        ImageButton arrowmoto1 = (ImageButton) getView().findViewById(R.id.arrowmoto1);
        ImageButton arrowapple1 = (ImageButton) getView().findViewById(R.id.arrowapple1);
        logout = (Button) getView().findViewById(R.id.logout);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Rating bar and it's associated functions
                RatingBar rrr = new RatingBar(getActivity());
                rrr.setNumStars(5);
                rrr.setStepSize((float) 0.5);
                rrr.setMax(5);
                rrr.setNumStars(5);

                layout = (ScrollView) getView().findViewById(R.id.blahh);
                final LinearLayout customLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.get_ratings, null);
                customLayout.addView(rrr);



                // create alert bar
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                builder1.setMessage("Rate us");
                //set view to the alertbox, the alert box shows the layout
                builder1.setView(customLayout);
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // dialog.cancel();
                                Snackbar snackbar
                                        = Snackbar
                                        .make(
                                                layout,
                                                "Ratings: "+String.valueOf(rrr.getRating()+"\nNumber of stars: "+rrr.getNumStars()),
                                                Snackbar.LENGTH_LONG);
                                snackbar.show();

                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Snackbar snackbar
                                        = Snackbar
                                        .make(
                                                layout,
                                                "You haven't rated :(",
                                                Snackbar.LENGTH_LONG);
                                snackbar.show();

                                dialog.cancel();
                            }


                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "notification", Toast.LENGTH_SHORT).show();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shop);
                Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                //Uri uri=Uri.parse("resource://"+getContext().getPackageName()+"/"+R.raw.notify);
                //Uri uri=Uri.parse("/home/rajesh/AndroidStudioProjects/navBarExample/app/src/main/res/raw/notify.mp3");

                int NOTIFICATION_ID = 234;
                NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                String CHANNEL_ID = "my_channel_01";
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    CHANNEL_ID = "my_channel_01";
                    CharSequence name = "my_channel";
                    String Description = "This is my channel";
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
                    mChannel.setDescription(Description);
                    mChannel.enableLights(true);
                    mChannel.setLightColor(Color.RED);
                    mChannel.enableVibration(true);
                    mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                    mChannel.setShowBadge(false);
                    notificationManager.createNotificationChannel(mChannel);
                }

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.shop)
                        .setContentTitle("Logout")
                        .setContentText("info logging out..")
                        .setLargeIcon(bitmap)
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(bitmap)
                                .bigLargeIcon(null)
                        .bigLargeIcon(bitmap))
                        .setContentTitle("logging out")
                        .setWhen(2000)
                        .setSound(uri)
                        .setUsesChronometer(true)
                        .setContentText(":-)");
                       // .setStyle(new NotificationCompat.BigPictureStyle()
                       //         .bigPicture(bitmap)


                Intent resultIntent = new Intent(getActivity(), NotificationView.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(getActivity());
                stackBuilder.addParentStack(NotificationView.class);
                stackBuilder.addNextIntent(resultIntent);

                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(resultPendingIntent);
                notificationManager.notify(NOTIFICATION_ID, builder.build());

//                NotificationCompat.Builder builder =
//                        new NotificationCompat.Builder(getActivity())
//                                .setSmallIcon(R.drawable.messageicon) //set icon for notification
//                                .setContentTitle("Notifications Example") //set title of notification
//                                .setContentText("This is a notification message")//this is notification message
//                                .setAutoCancel(true) // makes auto cancel of notification
//                                .setPriority(NotificationCompat.PRIORITY_DEFAULT); //set priority of notification
//
//
//                Intent notificationIntent = new Intent(getActivity(), NotificationView.class);
//                notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                //notification message will get at NotificationView
//                notificationIntent.putExtra("message", "This is a notification message");
//
//                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, notificationIntent,
//                        PendingIntent.FLAG_UPDATE_CURRENT);
//                builder.setContentIntent(pendingIntent);
//
//                // Add as notification
//                NotificationManager manager = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);
//                manager.notify(0, builder.build());


           Intent in = new Intent(getActivity(), Login.class);
           startActivity(in);


            }
        });

        expph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+"+91 8870078094"));
                startActivity(callIntent);
            }
        });


        expMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_SENDTO);
                callIntent.setData(Uri.parse("sms:"+"+8870078094"));
                startActivity(callIntent);
            }
        });



        expmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "rajesh.s@mca.christuniversity.in"});
                email.putExtra(Intent.EXTRA_SUBJECT, "product delivery");
                email.putExtra(Intent.EXTRA_TEXT, "i am sharing one of the delivery histories");

                //need this to prompts email client only
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });

        moto1Whatsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
                intent.setPackage("com.whatsapp");

                // Give your message here
                intent.putExtra(
                        Intent.EXTRA_TEXT,
                        "hi there ");

                // Checking whether Whatsapp
                // is installed or not
                if (intent
                        .resolveActivity(
                                getActivity().getPackageManager())
                        == null) {
                    Toast.makeText(
                                    getActivity(),
                                    "Please install whatsapp first.",
                                    Toast.LENGTH_SHORT)
                            .show();
                    return;
                }

                // Starting Whatsapp
                startActivity(intent);

            }
        });

        apple1whatsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent
                        = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
                intent.setPackage("com.whatsapp");

                // Give your message here
                intent.putExtra(
                        Intent.EXTRA_TEXT,
                        "hi there ");

                // Checking whether Whatsapp
                // is installed or not
                if (intent
                        .resolveActivity(
                                getActivity().getPackageManager())
                        == null) {
                    Toast.makeText(
                                    getActivity(),
                                    "Please install whatsapp first.",
                                    Toast.LENGTH_SHORT)
                            .show();
                    return;
                }

                // Starting Whatsapp
                startActivity(intent);

            }
        });


        moto1web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse("https://gadgets360.com/moto-e20-price-in-india-103971"));
                startActivity(in);
            }
        });


        apple1web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse("https://gadgets360.com/moto-e20-price-in-india-103971"));
                startActivity(in);
            }
        });


        arrowmoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        arrowapple1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}