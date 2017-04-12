package albert.practice.designPattern.simpleFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OolongTea extends Order {

    @Override
    public void acceptOrder() {
        log.debug("接受烏龍茶訂單");
    }

    @Override
    public void processOrder() {
        log.debug("處理烏龍茶訂單");
    }

    @Override
    public void deliverOrder() {
        log.debug("遞交烏龍茶訂單");
    }

}
