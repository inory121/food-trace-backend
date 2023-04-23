package com.inory.foodtrace.model.bo;

import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodTraceSetSaleInputBO {
  private String saleInfoId;

  private String hash;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(saleInfoId);
    args.add(hash);
    return args;
  }
}
