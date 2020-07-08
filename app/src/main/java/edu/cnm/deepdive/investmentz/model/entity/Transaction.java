package edu.cnm.deepdive.investmentz.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Currency.class,
            parentColumns = "currency_id",
            childColumns = "buy_currency_id",
            onDelete = ForeignKey.RESTRICT
        ),
        @ForeignKey(
            entity = Currency.class,
            parentColumns = "currency_id",
            childColumns = "sell_currency_id",
            onDelete = ForeignKey.RESTRICT
        )
    }
)
public class Transaction {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "transaction_id")
  private long transactionId;

  @ColumnInfo(name = "sell_currency_id", index = true)
  private Long sellCurrencyId;

  @ColumnInfo(name = "buy_currency_id", index = true)
  private long buyCurrencyId;

  @NonNull
  @ColumnInfo(index = true)
  private Date timestamp = new Date();

  @ColumnInfo(name = "buy_price")
  private long buyPrice;

  @ColumnInfo(name = "quantity_purchased")
  private long quantityPurchased;

  @ColumnInfo(name = "sold_price")
  private long soldPrice;

  @ColumnInfo(name = "quantity_sold")
  private long quantitySold;
  // TODO add pdf to erd- draw.io having error, wont let me export at this time.


  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }

  public Long getSellCurrencyId() {
    return sellCurrencyId;
  }

  public void setSellCurrencyId(Long sellCurrencyId) {
    this.sellCurrencyId = sellCurrencyId;
  }

  public long getBuyCurrencyId() {
    return buyCurrencyId;
  }

  public void setBuyCurrencyId(long buyCurrencyId) {
    this.buyCurrencyId = buyCurrencyId;
  }

  @NonNull
  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@NonNull Date timestamp) {
    this.timestamp = timestamp;
  }

  public long getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(long buyPrice) {
    this.buyPrice = buyPrice;
  }

  public long getQuantityPurchased() {
    return quantityPurchased;
  }

  public void setQuantityPurchased(long quantityPurchased) {
    this.quantityPurchased = quantityPurchased;
  }

  public long getSoldPrice() {
    return soldPrice;
  }

  public void setSoldPrice(long soldPrice) {
    this.soldPrice = soldPrice;
  }

  public long getQuantitySold() {
    return quantitySold;
  }

  public void setQuantitySold(long quantitySold) {
    this.quantitySold = quantitySold;
  }
}
