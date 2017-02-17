package albert.practice.designPattern.simpleFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlackTea extends Order {

    @Override
    public void acceptOrder() {
        log.debug("�����q��A���ƦW��: ����");
    }

    @Override
    public void processOrder() {
        log.debug("�B�z�q��A���ƦW��: ����");
    }

    @Override
    public void deliverOrder() {
        log.debug("��I�q��A���ƦW��: ����");
    }

}
