package com.example.findme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SignupFragmment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextInputEditText emailTxt, phoneTxt;
    Button nextBtn, cancelBtn;

    private String mParam1;
    private String mParam2;

    public SignupFragmment() {
        // Required empty public constructor
    }

    public static SignupFragmment newInstance(String param1, String param2) {
        SignupFragmment fragment = new SignupFragmment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        emailTxt = view.findViewById(R.id.signup_email_txt);
        phoneTxt = view.findViewById(R.id.signup_phone_txt);
        nextBtn = view.findViewById(R.id.signup_next_btn);
        cancelBtn = view.findViewById(R.id.signup_cancel_btn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailTxt.getText().toString();
                String phone = phoneTxt.getText().toString();

                if(email.equals("")){
                    Utility.showToast(getActivity(),getResources().getString(R.string.signup_missing_email));
                } else if(!Utility.isValidEmail(email)){
                    Utility.showToast(getActivity(),getResources().getString(R.string.signup_wrong_email));
                } else if (phone.equals("")){
                    Utility.showToast(getActivity(),getResources().getString(R.string.signup_missing_phone));
                } else if (phone.length()!=10){
                    Utility.showToast(getActivity(),getResources().getString(R.string.signup_wrong_phone));
                } else {
                    Utility.showToast(getActivity(),"OK");
                    Fragment fragment = new UserInfoFragment();
                    //Fragment fragment = new Fragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("email", email);
                    bundle.putString("phone", phone);
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    Utility.loadFragment(fragmentManager, fragment);
                }



            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MainFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Utility.loadFragment(fragmentManager, fragment);
            }
        });

        return view;
    }
}
