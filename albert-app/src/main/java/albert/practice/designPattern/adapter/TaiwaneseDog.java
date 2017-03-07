package albert.practice.designPattern.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 台灣犬
 *
 */
@Slf4j
public class TaiwaneseDog implements Dog {

    @Override
    public void bark() {
       log.debug("台灣犬汪汪汪");
    }

    @Override
    public void eat() {
        log.debug("台灣犬吃東西");
    }

    @Override
    public void walk() {
        log.debug("台灣犬走路中");
    }

}
