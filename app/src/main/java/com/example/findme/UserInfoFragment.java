package com.example.findme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserInfoFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextInputEditText nameTxt, passTxt, repassTxt;
    Button doneBtn, cancelBtn;
    MaterialCheckBox isProfCheck;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public UserInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserInfoFragment newInstance(String param1, String param2) {
        UserInfoFragment fragment = new UserInfoFragment();
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
        View view = inflater.inflate(R.layout.fragment_user_info, container, false);



        final Bundle bundle = this.getArguments();

        nameTxt = view.findViewById(R.id.userinfo_name_txt);
        passTxt = view.findViewById(R.id.userinfo_pass_txt);
        repassTxt = view.findViewById(R.id.userinfo_repass_txt);
        doneBtn = view.findViewById(R.id.userinfo_done_btn);
        cancelBtn = view.findViewById(R.id.userinfo_cancel_btn);
        isProfCheck = view.findViewById(R.id.userinfo_is_job_owner);



        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String  name,email, phone, pass, repass;
                email = bundle.getString("email");
                phone = bundle.getString("phone");
                name = nameTxt.getText().toString();
                pass = passTxt.getText().toString();
                repass = repassTxt.getText().toString();

                if(name.equals("")){
                    Utility.showToast(getActivity(),getResources().getString(R.string.signup_missing_name));
                } else if(name.length() < 5){
                    Utility.showToast(getActivity(),getResources().getString(R.string.signup_wrong_name));
                } else if (pass.equals("")){
                    Utility.showToast(getActivity(),getResources().getString(R.string.signup_missing_pass));
                } else if (pass.length() < 5){
                    Utility.showToast(getActivity(),getResources().getString(R.string.signup_wrong_pass));
                } else if (!repass.matches(pass)) {
                    Utility.showToast(getActivity(),getResources().getString(R.string.signup_wrong_repass));
                } else {
                    Utility.showToast(getActivity(),"OK");


                }
            }
        });



        return view;
    }
}
