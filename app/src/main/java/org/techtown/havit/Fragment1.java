package org.techtown.havit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1,container,false);

        button = view.findViewById(R.id.T2button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DisposableActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }
}
