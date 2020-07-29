package edu.cnm.deepdive.investmentz.view;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import edu.cnm.deepdive.investmentz.model.pojo.CoinbaseResponse.Price;
import java.lang.reflect.Type;

public class PriceDeserializer implements JsonDeserializer<Price> {

  @Override
  public Price deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    Price price = new Price();
    JsonArray array = json.getAsJsonArray();
    JsonArray nested = array.get(0).getAsJsonArray();
    String rawValue = nested.get(0).getAsString();
    long value = Math.round(Double.parseDouble(rawValue) * 100);
    price.setValue(value);
    return price;
  }
}
