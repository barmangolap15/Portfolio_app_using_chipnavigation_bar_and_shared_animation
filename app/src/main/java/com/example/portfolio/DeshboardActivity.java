package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.portfolio.fragments.AboutFragment;
import com.example.portfolio.fragments.ExpFragment;
import com.example.portfolio.fragments.ProjectsFragment;
import com.example.portfolio.fragments.SkillsFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.Locale;

public class DeshboardActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_deshboard);

        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_about,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
        bottomMenu();

    }

    private void bottomMenu() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.bottom_nav_about:
                        fragment = new AboutFragment();
                        break;
                    case R.id.bottom_nav_skills:
                        fragment = new SkillsFragment();
                        break;
                    case R.id.bottom_nav_exp:
                        fragment = new ExpFragment();
                        break;
                    case R.id.bottom_nav_project:
                        fragment = new ProjectsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
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
