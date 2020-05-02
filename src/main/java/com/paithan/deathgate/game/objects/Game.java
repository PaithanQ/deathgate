package com.paithan.deathgate.game.objects;


import com.paithan.deathgate.models.CardPair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

  Player playerOne;
  Player playerTwo;


  public Game() {
    playerOne = new Player("first");
    playerTwo = new Player("second");
  }

//  public Player playCard(CardPair cardToPlay) {
//
//  }

}
