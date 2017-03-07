package albert.practice.designPattern.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PokeMonGo extends Game {

    @Override
    void initialize() {
        log.debug("PokeMonGo is initializing...");
    }

    @Override
    void startGame() {
        log.debug("Start to play PokeMonGo");
    }

    @Override
    void endGame() {
        log.debug("Leave PokeMonGo");
    }

}
