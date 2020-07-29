package edu.cnm.deepdive.investmentz.controller;

import android.os.Build.VERSION_CODES;
import androidx.annotation.RequiresApi;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateTime {

  @RequiresApi(api = VERSION_CODES.O)
  public static void main(String[] args) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    System.out.println(dtf.format(now));
  }
}
