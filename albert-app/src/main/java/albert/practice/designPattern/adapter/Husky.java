package albert.practice.designPattern.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 哈士奇
 *
 */
@Slf4j
public class Husky implements Dog {

    @Override
    public void bark() {
       log.debug("哈士奇汪汪汪");
    }

    @Override
    public void eat() {
        log.debug("哈士奇吃東西");
    }

    @Override
    public void walk() {
        log.debug("哈士奇走路中");
    }

}
