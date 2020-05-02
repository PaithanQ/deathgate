package com.paithan.deathgate.game.services;

import com.paithan.deathgate.models.Card;
import com.paithan.deathgate.models.CardPair;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class ReaderService {

  private final Map<String, Map<String, Integer>> decks;
  private final Map<String, Card> cards;


  public ReaderService() {
    InputStream decksInputStream = this.getClass().getClassLoader().getResourceAsStream("decks.yaml");
    InputStream cardsInputStream = this.getClass().getClassLoader().getResourceAsStream("cards.yaml");
    Yaml yaml = new Yaml();
    this.decks = yaml.load(decksInputStream);
    this.cards = yaml.load(cardsInputStream);
  }

  public ArrayList<CardPair> getDeckFromDB(String deckName) {
    Map<String, Integer> deck = decks.get(deckName);

    ArrayList<CardPair> cards = new ArrayList<>();

    for (Map.Entry<String, Integer> cardAndAmount : deck.entrySet()) {
      int cardIdInDeck = 0;
      Integer amount = cardAndAmount.getValue();
      for (int i = 0; i < amount; i++) {
        CardPair cardPair = new CardPair();
        cardPair.setIdInDeck(cardIdInDeck);
        cardPair.setCardId(cardAndAmount.getKey());
        cards.add(cardPair);
        cardIdInDeck++;
      }
    }
    return cards;
  }

  public Card getCardFromDB (String cardId) {
    return cards.get(cardId);
  }



}
