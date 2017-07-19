package org.Clumsy.controller;

import org.Clumsy.service.CaseService;
import org.Clumsy.vo.CaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by slow_time on 2017/7/16.
 */

@Controller
@RequestMapping("/case")
public class CaseInfoController {

    @Autowired
    private CaseService caseService;


    /**
     * 上传xml文件
     * @param caseFile
     * @param userId
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadCase(@RequestParam("caseFile") MultipartFile caseFile, @RequestParam("id") String userId) {
        if (!caseFile.isEmpty()) {
            // 文书未处理过，状态码是201
            if (!caseService.isCreated(caseFile)) {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.TEXT_PLAIN);
                httpHeaders.set("Access-Control-Allow-Origin", "*");
                return new ResponseEntity<>(caseService.createCase(caseFile, userId), httpHeaders, HttpStatus.CREATED);
            }
            // 文书已经处理过，状态码是200
            else {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.TEXT_PLAIN);
                httpHeaders.set("Access-Control-Allow-Origin", "*");
                return new ResponseEntity<>(caseService.constructCase(caseFile), httpHeaders, HttpStatus.OK);
            }
        }
        else {
            // 状态码是204
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    /**
     * 获得对应的ID的案件文书
     * @param id 文书的id
     * @return
     */
    @RequestMapping(value = "/obtainById/{id}", method = RequestMethod.GET)
    public ResponseEntity<CaseVO> getCaseByCaseId(@PathVariable("id") String id) {
        CaseVO caseVO = caseService.getCaseInfoById(id);
        if (caseVO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
            httpHeaders.set("Access-Control-Allow-Origin", "*");
            return new ResponseEntity<>(caseVO, httpHeaders, HttpStatus.OK);
        }
    }
}
