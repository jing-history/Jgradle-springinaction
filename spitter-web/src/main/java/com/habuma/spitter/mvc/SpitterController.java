package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * 执行gradle jettyRun或者jettyRunWar
 * Created by wangyunjing on 2016/10/26.
 */
@Controller
@RequestMapping("/spitters")
public class SpitterController {
    private final SpitterService spitterService;

    @Inject
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    //http://localhost:8080/spitter-web/spitters?new
    @RequestMapping(method = RequestMethod.GET,params = "new")
    public String createSpitterProfile(Model model){
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    //bug model 验证没有起效果 晕死,类型要form 表单类型
    @RequestMapping(method = RequestMethod.POST)
    public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult,
                                     @RequestParam(value = "image",required = false)MultipartFile image){
        if(bindingResult.hasErrors()){
            return "spitters/edit";
        }
        spitterService.saveSpitter(spitter);
        try{
            if(!image.isEmpty()){
                validateImage(image);

                saveImage(spitter.getId() + ".jpg",image);
            }
        }catch (Exception e){
            bindingResult.reject(e.getMessage());
            return "spitters/edit";
        }
        return "redirect:/spitters/" + spitter.getUsername();
    }

    private void saveImage(String filename, MultipartFile image) {

    }

    private void validateImage(MultipartFile image) throws Exception {
        if(!image.getContentType().equals("image/jpeg")){
            throw  new Exception("only jpg images accepted");
        }
    }

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username,Model model){
        model.addAttribute(spitterService.getSpitter(username));
        return "spitters/view";
    }

    @RequestMapping(value="/spittles", method=RequestMethod.GET)
    public String listSpittlesForSpitter(
            @RequestParam("spitterName") String username, Model model) {
        Spitter spitter = spitterService.getSpitter(username);
        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));
        return "spittles/list";
    }

}
