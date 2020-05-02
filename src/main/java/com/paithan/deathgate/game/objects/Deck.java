package com.paithan.deathgate.game.objects;

import com.paithan.deathgate.models.Card;
import com.paithan.deathgate.models.CardPair;
import com.paithan.deathgate.game.services.ReaderService;
import java.util.ArrayList;
import java.util.Collections;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Deck {

  ReaderService readerService = new ReaderService();
  private final ArrayList<CardPair> cards;

  public Deck(String deckName) {
    this.cards = readerService.getDeckFromDB(deckName);
  }

  public void shuffleDeck() {
    Collections.shuffle(cards);
  }

  public ArrayList<CardPair> getCardsFromDeck(int numberOfCards) {
    ArrayList<CardPair> takenCards = new ArrayList<>();
    for (int i = 0; i < numberOfCards; i++) {
      takenCards.add(cards.get(0));
      cards.remove(0);
    }
    return takenCards;
  }

}
