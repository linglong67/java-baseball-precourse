package baseball.controller;

import baseball.dto.Game;
import baseball.service.PlayService;

public class PlayController {

    private PlayService playService = new PlayService();
    private Game game;

    public void play() {
        boolean continueGame = false;

        do {
            game = new Game();
            continueGame = playService.playGame(game.getAnswer());
        } while (continueGame);
    }

}
