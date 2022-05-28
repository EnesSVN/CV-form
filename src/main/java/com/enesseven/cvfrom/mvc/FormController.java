package com.enesseven.cvfrom.mvc;


import com.enesseven.cvfrom.database.dto.CvDto;
import com.enesseven.cvfrom.database.dao.CvDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class FormController {

    @GetMapping("form")
    public String getAdminForm(Model model) {
        model.addAttribute("form_key",new CvDto());
        return "form";
    }

    @PostMapping("/form")
    public String postAdminForm(Model model, CvDto cvDto){
        CvDao cvDao = new CvDao();

        cvDao.create(cvDto);

        log.info(cvDto);
        model.addAttribute("form_key",cvDto);
        return "form";
    }


}
