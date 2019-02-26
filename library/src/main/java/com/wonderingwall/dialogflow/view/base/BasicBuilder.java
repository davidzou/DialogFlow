package com.wonderingwall.dialogflow.view.base;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/2/25
 *
 *
 * @param <T> builder who parent of builder.
 */
public interface BasicBuilder<T extends BasicBuilder.Builder> {

    /**
     * To be created.
     * @return ?
     */
    T create();

    interface Builder{}
}
