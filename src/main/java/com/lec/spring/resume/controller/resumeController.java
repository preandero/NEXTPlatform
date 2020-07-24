package com.lec.spring.resume.controller;


import com.lec.spring.resume.domain.photoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;

@Controller
@RequestMapping("/resume")
public class resumeController {


    @RequestMapping("/resumeWrite")
    public String Write(Model model){

        return "resume/resumeWrite";
    }


    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    public String upload(MultipartHttpServletRequest mtf) throws Exception {
        // 파일 태그
        String fileTag = "file";
        // 업로드 파일이 저장될 경로
        String filePath = "../profile/" + mtf.getContextPath();
        // 파일 이름
        MultipartFile file = mtf.getFile(fileTag);
        String fileName = ((MultipartFile) file).getOriginalFilename();
        // 파일 전송
        try {
            file.transferTo(new File(filePath + fileName));
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("업로드 오류");
        }

        return "";

    }


    }
