package albert.practice.designPattern.simpleFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlackTea extends Order {

    @Override
    public void acceptOrder() {
        log.debug("接受訂單，飲料名稱: 紅茶");
    }

    @Override
    public void processOrder() {
        log.debug("處理訂單，飲料名稱: 紅茶");
    }

    @Override
    public void deliverOrder() {
        log.debug("交付訂單，飲料名稱: 紅茶");
    }

}
