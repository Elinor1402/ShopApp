package com.example.fragapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fragapp.R;
import com.example.fragapp.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TwoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TwoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TwoFragment newInstance(String param1, String param2) {
        TwoFragment fragment = new TwoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    //refers to activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    //refers to fragments
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //get access to elements of MainActivity in layout
//        MainActivity mainActivity = (MainActivity)getActivity();
//        mainActivity.findViewById(R.id.editTextMain);

        View view =  inflater.inflate(R.layout.fragment_two, container, false);

        String username = getArguments().getString("username");
        String password = getArguments().getString("password");

        TextView user_email = view.findViewById(R.id.user_email);
        TextView user_password = view.findViewById(R.id.user_pass);

        user_email.setText(username);
        user_password.setText(password);

        Button buton2To3 = view.findViewById(R.id.buttonTwoToThree);
        buton2To3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_twoFragment_to_threeFragment);
            }
        });

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setUsername("Elinor");
        return view;
    }
}