package com.paithan.deathgate.game.objects;

import com.paithan.deathgate.models.Card;
import com.paithan.deathgate.models.CardPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

  private final Integer NUMBER_OF_STARTING_CARDS = 7;
  private  Deck deck;
  private String playerId;
  private ArrayList<CardPair> hand;
  private ArrayList<CardPair> graveyard;
  private Integer life;
  private Map<String, Integer> energy;
  private boolean hasPlayedEnergy;

  public Player(String deckName) {
    this.deck = new Deck(deckName);
    this.playerId = generatePlayerId();
    this.life = 20;
    this.hand = generateFirstHand();
    this.graveyard = new ArrayList<>();
    this.energy = new HashMap<>();
    this.hasPlayedEnergy = false;
  }

  private String generatePlayerId() {
    return UUID.randomUUID().toString();
  }

  private ArrayList<CardPair> generateFirstHand(){
    deck.shuffleDeck();
    return deck.getCardsFromDeck(NUMBER_OF_STARTING_CARDS);
  }


}
