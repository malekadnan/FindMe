package com.example.findme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;


import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageView mainImage;
    MainFragment mainFragment;
    LoginFragment loginFragment;
    ForgetFragment forgetFragment;
    SignupFragmment signupFragmment;
    UserInfoFragment userInfoFragment;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        mainFragment = new MainFragment();
        loginFragment = new LoginFragment();
        forgetFragment = new ForgetFragment();
        signupFragmment = new SignupFragmment();
        userInfoFragment = new UserInfoFragment();
        ft.replace(R.id.layout_fragment,userInfoFragment);
        ft.commit();

        mainImage = findViewById(R.id.main_title);

        if(Utility.isRTL(Locale.getDefault())){
            mainImage.setImageResource(R.drawable.ic_findme_ara);
        }
        else {
            mainImage.setImageResource(R.drawable.ic_findme);

        }
    }

}
