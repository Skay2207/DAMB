package com.example.py_damb2026ii;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.py_damb2026ii.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*
        binding.btnSiguiente.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
        */
        binding.btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCount = Integer.parseInt(binding.txtConteo.getText().toString());
                com.example.py_damb2026ii.FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                        FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);
                NavHostFragment.findNavController(FirstFragment.this).navigate(action);
            }
        });

        binding.btnToast.setOnClickListener(v -> {
            Toast myToast = Toast.makeText(getActivity(), "Hola toast!", Toast.LENGTH_SHORT);
            myToast.show();
        });

        binding.btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countMe(v);
            }
        });
    }

    private void countMe(View v){
        String countString = binding.txtConteo.getText().toString();
        int count = Integer.parseInt(countString);
        count++;
        binding.txtConteo.setText(String.valueOf(count));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}