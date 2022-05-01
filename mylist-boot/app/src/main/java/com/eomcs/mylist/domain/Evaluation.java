package com.eomcs.mylist.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {

  private Integer mtchId;
  private String mtchDate;
  private String stTime;
  private String fieldName;
  private String courtName;
  private String mtchType;
  private String mtchNum;
  private String courtType;


}

