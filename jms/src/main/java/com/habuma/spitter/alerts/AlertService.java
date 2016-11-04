package com.habuma.spitter.alerts;

import com.habuma.spitter.domain.Spittle;

/**
 * Created by wangyunjing on 2016/11/4.
 */
public interface AlertService {
    void sendSpittleAlert(Spittle spittle);
}
