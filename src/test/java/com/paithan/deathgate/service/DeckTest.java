package com.paithan.deathgate.service;

import com.paithan.deathgate.models.CardPair;
import com.paithan.deathgate.game.objects.Deck;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeckTest {

  @Test
  public void shouldGetCardsFromDeck() {
    // given
    Deck deck = new Deck("first");
    ArrayList<CardPair> cards = deck.getCards();
    int NUMBER_OF_TAKEN_CARDS = 5;

    // when
    ArrayList<CardPair> takenCards = deck.getCardsFromDeck(NUMBER_OF_TAKEN_CARDS);

    //then
    Assertions.assertEquals(NUMBER_OF_TAKEN_CARDS, takenCards.size());
    for (CardPair cardPair: takenCards) {
        Assertions.assertFalse(cards.contains(cardPair));
    }
  }
}
