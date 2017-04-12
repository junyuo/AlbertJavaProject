package albert.practice.designPattern.simpleFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GreenTea extends Order {

    @Override
    public void acceptOrder() {
        log.debug("接受綠茶訂單");
    }

    @Override
    public void processOrder() {
        log.debug("處理綠茶訂單");
    }

    @Override
    public void deliverOrder() {
        log.debug("遞交綠茶訂單");
    }

}
