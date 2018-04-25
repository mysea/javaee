package controller;

import bean.UploadImageFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/image")
public class UploadController {
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("uploadImage");
        return mav;
    }

    @RequestMapping("/upload")
    public ModelAndView upload(HttpServletRequest request, UploadImageFile file) throws IOException {
        String name = file.getImage().getName() + ".jpg";
        File f = new File(request.getServletContext().getRealPath("/image"),name);
        if (!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        file.getImage().transferTo(f);

        ModelAndView mav = new ModelAndView("showImage");
        mav.addObject("imageName", name);
        return mav;
    }
}
