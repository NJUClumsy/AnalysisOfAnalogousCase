package org.Clumsy.controller;

import org.Clumsy.service.SimilarCaseService;
import org.Clumsy.vo.CaseNumberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by slow_time on 2017/7/17.
 */

@Controller
@RequestMapping("/similar")
public class SimilarCasesController {

    @Autowired
    SimilarCaseService similarCaseService;


    /**
     * 获得类案推荐
     * @param id 案件文书的id
     * @return
     */
    @RequestMapping(value = "/recommend/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<CaseNumberVO>> getSimilarCases(@PathVariable("id") String id) {
        List<CaseNumberVO> caseNumberVOS = similarCaseService.recommendCases(id);
        // 推荐失败，状态码为404
        if (caseNumberVOS == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            // 无相似案由，状态码为204
        else if (caseNumberVOS.size() == 0)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            // 推荐成功，状态码为200
        else {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
            httpHeaders.set("Access-Control-Allow-Origin", "*");
            return new ResponseEntity<>(caseNumberVOS, httpHeaders, HttpStatus.OK);
        }
    }

}
