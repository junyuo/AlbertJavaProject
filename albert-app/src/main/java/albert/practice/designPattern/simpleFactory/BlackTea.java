package albert.practice.designPattern.simpleFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlackTea extends Order {

    @Override
    public void acceptOrder() {
        log.debug("接受紅茶訂單");
    }

    @Override
    public void processOrder() {
        log.debug("處理紅茶訂單");
    }

    @Override
    public void deliverOrder() {
        log.debug("遞交紅茶訂單");
    }

}
