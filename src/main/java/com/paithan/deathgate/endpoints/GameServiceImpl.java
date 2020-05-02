package com.paithan.deathgate.endpoints;

import com.paithan.deathgate.game.objects.Game;
import com.paithan.deathgate.game.objects.Player;
import com.paithan.deathgate.models.CardPair;
import com.paithan.deathgate.proto.Card;
import com.paithan.deathgate.proto.GameStatusResponse;
import com.paithan.deathgate.proto.GameServiceGrpc;
import com.paithan.deathgate.proto.PlayCardRequest;
import com.paithan.deathgate.proto.StartGameRequest;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GameServiceImpl extends GameServiceGrpc.GameServiceImplBase {

  @Override
  public void startGame(
      final StartGameRequest request, StreamObserver<GameStatusResponse> responseObserver) {

    Game game = new Game();

    GameStatusResponse response =
        GameStatusResponse.newBuilder()
            .addPlayers(toPlayerGrpc(game.getPlayerOne()))
            .addPlayers(toPlayerGrpc(game.getPlayerTwo()))
            .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void playCard(final PlayCardRequest request,
                       StreamObserver<GameStatusResponse> responseObserver) {

  }


  private com.paithan.deathgate.proto.Player toPlayerGrpc(Player player) {

    return com.paithan.deathgate.proto.Player.newBuilder()
        .addAllHand(toCards(player.getHand()))
        .addAllGraveyard(toCards(player.getGraveyard()))
        .setLife(player.getLife())
        .setPlayerId(player.getPlayerId())
        .build();
  }

  private ArrayList<Card> toCards(ArrayList<CardPair> cards){
        ArrayList<Card> hand = new ArrayList<>();
    for (CardPair cardPair : cards) {
      hand.add(Card.newBuilder().setCardId(cardPair.getCardId()).setIdInDeck(cardPair.getIdInDeck()).build());
    }
    return hand;
  }


}
