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
public class FoodTraceSetButcheryInputBO {
  private String pigId;

  private String hash;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(pigId);
    args.add(hash);
    return args;
  }
}
