package com.github.interceptors;

import com.github.core.annotations.*;
import com.google.common.util.concurrent.FutureCallback;

@Receiver(name = "ReceiverCustomListenerId")
public class CaseCustomListenerSpec {

    public void customListener(String payload) {

    }

    @Transmitter(
            beanName = "TransmitterTemplateBeanCaseZero",
            receiverName = "ReceiverCustomListenerId"
    )
    public interface TransmitterTemplate extends FutureCallback<String> {
        @Override
        @NotifyTo(name = "customListener")
        void onSuccess(String result);

        @Override
        default void onFailure(Throwable t) {
        }
    }

}
