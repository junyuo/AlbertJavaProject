package albert.practice.designPattern.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 柴犬
 *
 */
@Slf4j
public class Shiba implements Dog {

    @Override
    public void bark() {
       log.debug("柴犬汪汪汪");
    }

    @Override
    public void eat() {
        log.debug("柴犬吃東西");
    }

    @Override
    public void walk() {
        log.debug("柴犬走路中");
    }

}
