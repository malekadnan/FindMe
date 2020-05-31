package com.example.findme;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import java.util.Locale;


public class MainFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ImageView mainImage, mainLogin, mainRegister;

    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mainImage = container.findViewById(R.id.main_title);
        mainLogin = view.findViewById(R.id.main_login);
        mainRegister = view.findViewById(R.id.main_register);

       Animation aniR = AnimationUtils.loadAnimation(view.getContext(),R.anim.move_right);
       Animation aniL = AnimationUtils.loadAnimation(view.getContext(),R.anim.move_left);

       mainLogin.startAnimation(aniR);
       mainRegister.startAnimation(aniL);

       if(Utility.isRTL(Locale.getDefault())){
            mainLogin.setImageResource(R.drawable.ic_login_ara);
            mainRegister.setImageResource(R.drawable.ic_register_ara);
        }

       mainLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Fragment fragment = new LoginFragment();
               FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
               Utility.loadFragment(fragmentManager, fragment);
           }
       });

        mainRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SignupFragmment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Utility.loadFragment(fragmentManager, fragment);
            }
        });

        return view;
    }

}
