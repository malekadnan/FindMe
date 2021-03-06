package com.example.findme;

import android.os.Bundle;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextInputEditText loginTxt, passTxt;
    Button loginBtn, cancelBtn;
    AppCompatTextView forgetTxt, signupTxt;

    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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

        View view =inflater.inflate(R.layout.fragment_login, container, false);

        loginTxt = view.findViewById(R.id.login_user_txt);
        passTxt = view.findViewById(R.id.login_pass_txt);
        loginBtn = view.findViewById(R.id.login_login_btn);
        cancelBtn = view.findViewById(R.id.login_cancel_btn);
        forgetTxt = view.findViewById(R.id.login_forget_txt);
        signupTxt = view.findViewById(R.id.login_signup_txt);
        //String emptyPass = getResources().getString(R.string.login_missing_password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "login";
                String userName = loginTxt.getText().toString();
                String password = passTxt.getText().toString();

                if (userName.equals("")){
                    Utility.showToast(getActivity(),getResources().getString(R.string.login_missing_user_name));
                } else if (password.equals("")){
                    Utility.showToast(getActivity(),getResources().getString(R.string.login_missing_password));
                }
                else {
                    BackgroundConnection bk = new BackgroundConnection(getActivity());
                    bk.execute(type, userName, password);
                    if(!Parameters.getIsLogin()){
                        Utility.showToast(getActivity(),getResources().getString(R.string.login_wrong_login));
                    }
                }



                /*if (!userName.isEmpty()){
                    if (!password.isEmpty()){
                        BackgroundConnection bk = new BackgroundConnection(getActivity());
                        bk.execute(type, userName, password);
                    } else {
                        Toast.makeText( getActivity(), "User name can not be empty", Toast.LENGTH_SHORT).show();
                         //Toast.makeText( getActivity(), getResources().getString(R.string.login_missing_password), Toast.LENGTH_SHORT).show();
                } }else {
                    Toast.makeText(getActivity(), "User name can not be empty", Toast.LENGTH_SHORT).show();
                }*/





                //Fragment fragment = new LoginFragment();
                //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                //Utility.loadFragment(fragmentManager, fragment);
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

        forgetTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ForgetFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Utility.loadFragment(fragmentManager, fragment);
            }
        });

        signupTxt.setOnClickListener(new View.OnClickListener() {
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
