package org.Clumsy.controller;

import org.Clumsy.service.SimilarCaseService;
import org.Clumsy.vo.CaseNumberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(value = "/recommend", method = RequestMethod.GET)
    public ResponseEntity<CaseNumberVO> getSimilarCases(@RequestParam("id") String id) {
        CaseNumberVO causeVO = similarCaseService.recommendCases(id);
        // 推荐失败，状态码为404
        if (causeVO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // 推荐成功，状态码为200
        else
            return new ResponseEntity<>(causeVO, HttpStatus.OK);
    }


}
