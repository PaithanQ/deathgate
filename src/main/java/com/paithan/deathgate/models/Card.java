package com.paithan.deathgate.models;

import java.util.ArrayList;
import java.util.Map;
import lombok.Data;

@Data
public class Card {

  private final String cardId;
  private final String name;
  private final String type;
  private final Integer strength;
  private final Integer defense;
  private final Map<String, Integer> cost;
  private final ArrayList<String> skills;

}
