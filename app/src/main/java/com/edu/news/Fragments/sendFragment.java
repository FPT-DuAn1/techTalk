package com.edu.news.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.edu.news.R;

public class sendFragment extends Fragment {

    public EditText etUsername, etEmail, etGopY;
    public Button btnGuiGopY;
    public ProgressBar sendProgessBar;

    private OnFragmentInteractionListener mListener;

    public sendFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_send2, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etEmail = view.findViewById(R.id.etEmail);
        etGopY = view.findViewById(R.id.etGopY);
        btnGuiGopY = view.findViewById(R.id.btnGuiGopY);
        sendProgessBar = view.findViewById(R.id.progressBarGopY);
        sendProgessBar.setVisibility(View.INVISIBLE);

        btnGuiGopY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                       String username = etUsername.getText().toString();
                       String email = etEmail.getText().toString();
                       String gopY = etGopY.getText().toString();

                        if ( username.isEmpty() || email.isEmpty() || gopY.isEmpty()){
                            Toast.makeText(getContext(), "Xin vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                        }else {
                            btnGuiGopY.setVisibility(View.INVISIBLE);
                            sendProgessBar.setVisibility(View.VISIBLE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    btnGuiGopY.setVisibility(View.VISIBLE);
                                    sendProgessBar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getContext(), "Đã gửi góp ý thành công!", Toast.LENGTH_SHORT).show();

                                    etUsername.setText("");
                                    etEmail.setText("");
                                    etGopY.setText("");
                                }
                            }, 3000);
                        }
                }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
