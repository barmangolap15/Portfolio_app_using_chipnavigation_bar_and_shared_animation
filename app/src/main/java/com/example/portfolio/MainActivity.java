package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.portfolio.fragments.AboutFragment;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    TextView profileName, aboutText;
    ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);



        profileImage  = findViewById(R.id.profile_image);
        profileName = findViewById(R.id.profile_name);
        aboutText = findViewById(R.id.about_text);


    }

    public void gotoDashbard(View view){

        Intent intent = new Intent(getApplicationContext(), AboutFragment.class);

        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String>(profileImage,"imageTransition");
        pairs[1] = new Pair<View, String>(profileName,"nameTransition");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

        startActivity(intent,options.toBundle());
        finish();
    }

    public void showDashboard(View view){
        Intent intent = new Intent(getApplicationContext(), DeshboardActivity.class);

        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String>(profileImage,"imageTransition");
        pairs[1] = new Pair<View, String>(profileName,"nameTransition");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

        startActivity(intent,options.toBundle());
        finish();
    }

    public void showDialog(View view) {
        final AlertDialog.Builder mDialog = new AlertDialog.Builder(MainActivity.this);
        ImageView close, selectImg;
        TextView selectText;
        Button hindiBtn, engBtn, bangBtn;
        final View mView =  getLayoutInflater().inflate(R.layout.custom_dailog, null);
        close = (ImageView)mView.findViewById(R.id.close_from_dialog);
        hindiBtn = (Button) mView.findViewById(R.id.hindi_btn);
        engBtn = (Button)mView.findViewById(R.id.eng_btn);
        bangBtn = (Button)mView.findViewById(R.id.ban_btn);
        mDialog.setView(mView);
        final  AlertDialog dialog = mDialog.create();
        dialog.setCanceledOnTouchOutside(false);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        hindiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("hi");
                recreate();
                startActivity(new Intent(getApplicationContext(),DeshboardActivity.class));
                finish();
                dialog.dismiss();
            }
        });

        engBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("en");
                recreate();
                startActivity(new Intent(getApplicationContext(),DeshboardActivity.class));
                finish();
                dialog.dismiss();
            }
        });

        bangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("bn");
                recreate();
                startActivity(new Intent(getApplicationContext(),DeshboardActivity.class));
                finish();
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void setLocale(String lang) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        //save data to shared preferences
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    //load languages saved in shared preferences
    public void loadLocale(){
        SharedPreferences pref = getSharedPreferences("Settings",MODE_PRIVATE);
        String language = pref.getString("My_Lang", "");
        setLocale(language);
    }

}
