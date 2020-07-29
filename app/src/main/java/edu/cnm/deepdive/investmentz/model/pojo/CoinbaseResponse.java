package edu.cnm.deepdive.investmentz.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoinbaseResponse {

  @Expose
  @SerializedName("bids")
  private Price bid;

  @Expose
  @SerializedName("asks")
  private Price ask;

  public Price getBid() {
    return bid;
  }

  public void setBid(Price bid) {
    this.bid = bid;
  }

  public Price getAsk() {
    return ask;
  }

  public void setAsk(Price ask) {
    this.ask = ask;
  }

  public static class Price {

    private long value;

    public long getValue() {
      return value;
    }

    public void setValue(long value) {
      this.value = value;
    }
  }

}
