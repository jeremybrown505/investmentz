package edu.cnm.deepdive.investmentz.controller;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.investmentz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

  public HomeFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    Button history = view.findViewById(R.id.history_button);
    Button buy = view.findViewById(R.id.buy_button);
    Button sell = view.findViewById(R.id.sell_button);
    Button restart = view.findViewById(R.id.restart);

    history.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.home_to_history);
      }
    });

    buy.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        // TODO buy button should check the transaction_amount field and buy that amount of currency, then clear the transaction amount field and toast a message confirming the transaction.
      }
    });

    sell.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        // TODO button should check the transaction_amount field and sell that amount of currency, then clear the transaction amount field and toast a message confirming the transaction.
      }
    });

    restart.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        // TODO button should delete the users transactions and all data stored, and restart the app like it was just installed

      }
    });


    return view;
  }



//  public interface OnFragmentInteractionListenerMain {
//    // TODO update argument type & name
//    void onFragmentInteraction(Uri uri);
//  }

}
