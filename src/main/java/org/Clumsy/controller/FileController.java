package org.Clumsy.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by txin15 on 2017/7/16.
 */

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upLoadFile(HttpServletRequest request, Model model)
            throws IllegalStateException, IOException {
        File f = null;

        // create a common multipart resolver
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());

        // judge whether the file upload is requested
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // fetch the name of the file to upload
                    String myFileName = file.getOriginalFilename();
                    // judge whether the file exists
                    if (!myFileName.trim().equals("")) {
                        // define the path of the upload
                        try{
                            File localFile = new File(request.getServletContext().getRealPath("/file"), myFileName);
                            file.transferTo(localFile);
                            f = localFile;
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }

                model.addAttribute("file",f);
            }
            return "fileDetail";
        }
        return "upload";
    }
}
