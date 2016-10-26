package com.habuma.spitter.mvc;

import com.habuma.spitter.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by wangyunjing on 2016/10/26.
 */
@Controller
public class HomeController {
    //<start id="spittlesPerPage"/>
    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
    private SpitterService spitterService;

    @Inject
    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String,Object> model){
        model.put("spittles",spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE));
        return "home";
    }
}
