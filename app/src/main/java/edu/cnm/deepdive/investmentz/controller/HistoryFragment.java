package edu.cnm.deepdive.investmentz.controller;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.investmentz.R;


/**
 * A simple {@link Fragment} subclass.
 */

public class HistoryFragment extends Fragment {

  Button homeButton;
  View view;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_history, container, false);
    Button button = view.findViewById(R.id.home_button);

    button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.history_to_home);
      }
    });
    return view;
  }

}
