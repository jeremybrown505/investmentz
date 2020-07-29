package edu.cnm.deepdive.investmentz.controller;

import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.investmentz.R;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        // TODO button should check the Transaction_amount field and buy that amount of currency, then clear the transaction_amount field, and toast a message confirming the transaction.
      }
    });

    sell.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        // TODO button should check the transaction_amount field and sell that amount of currency, then clear the transaction amount field and toast a message confirming the transaction.
      }
    });

    restart.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        // TODO button should delete the users transactions and all data stored, and restart the app like it was just installed
      }
    });
    return view;
  }

  public class CurrentDateTime {

    @RequiresApi(api = VERSION_CODES.O)
    public void main(String[] args) {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      Date date = new Date();
      System.out.println(dtf.format(now));
    }
  }

}
