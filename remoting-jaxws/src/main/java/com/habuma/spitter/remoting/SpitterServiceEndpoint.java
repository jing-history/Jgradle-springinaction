package com.habuma.spitter.remoting;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by wangyunjing on 2016/11/2.
 */
@Component
@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint{
    @Autowired
    SpitterService spitterService;

    @WebMethod
    public void addSpittle(Spitter spitter){
        spitterService.saveSpitter(spitter);
    }

    public void deleteSpittle(long spittleId){
        spitterService.deleteSpittle(spittleId);
    }

    @WebMethod
    public List<Spittle> getRecentSpittles(int spittleCount) {
        return spitterService.getRecentSpittles(spittleCount);
    }

    @WebMethod
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return spitterService.getSpittlesForSpitter(spitter);
    }
}
