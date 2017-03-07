package albert.practice.designPattern.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellTower extends Game {

    @Override
    void initialize() {
        log.debug("SpellTower is initializing...");
    }

    @Override
    void startGame() {
        log.debug("Start to play SpellTower");
    }

    @Override
    void endGame() {
        log.debug("Leave SpellTower");
    }

}
