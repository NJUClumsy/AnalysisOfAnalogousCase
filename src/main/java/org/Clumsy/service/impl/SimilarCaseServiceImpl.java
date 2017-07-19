package org.Clumsy.service.impl;

import org.Clumsy.dao.CaseRepository;
import org.Clumsy.entity.Case;
import org.Clumsy.service.CaseService;
import org.Clumsy.service.SimilarCaseService;
import org.Clumsy.vo.CaseNumberVO;
import org.Clumsy.vo.CaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by slow_time on 2017/7/17.
 */

@Service("similarCaseService")
public class SimilarCaseServiceImpl implements SimilarCaseService {

    @Autowired
    CaseRepository caseRepository;
    @Autowired
    CaseService caseService;

    @Override
    public List<CaseNumberVO> recommendCases(String id) {
        List<CaseNumberVO> list = new ArrayList<CaseNumberVO>();


        CaseVO caseVO = caseService.getCaseInfoById(id);
        String cause = caseVO.cause;
        System.out.println(id);
        System.out.println(cause);

        try {
//            String cp = "/python/Recommend.py";
//            Process process = Runtime.getRuntime().exec("python3 " + SimilarCaseServiceImpl.class.getResource(cp).getFile() + " " + id + " " + cause);
            Process process = Runtime.getRuntime().exec("python3 /Users/slow_time/Desktop/AnalysisOfAnalogousCase/src/main/resources/python/Recommend.py  " + id);

            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String errLine;
            while ((errLine = err.readLine()) != null) {
                System.out.println(errLine);
            }
            String line= in.readLine();
            in.close();
            process.waitFor();
            String[] strList = line.split(",");
            for (String o : strList){
                Case instantCase = caseRepository.findById(o);
                CaseNumberVO ins = new CaseNumberVO(instantCase.getId(),instantCase.getCaseNumber());
                list.add(ins);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return list;

//        PythonInterpreter interpreter = new PythonInterpreter();
//        interpreter.execfile("src/main/resources/python/Recommend.py");//需要修改
//
//        PyFunction pyFunction = interpreter.get("getRecommendedCases", PyFunction.class); // 需要修改第一个参数为函数名字
//        PyObject pyObject = pyFunction.__call__(new PyString(id),new PyString(cause));
//
//        System.out.println(pyObject);
//
//        String instant = pyObject.toString();
//        instant = instant.substring(1,instant.length()-1);
//        System.out.println(instant);
//        String[] strList = instant.split(", ");
//        for (String o:strList){
//            o = o.substring(1,o.length()-1);
//            System.out.println(o);
//            Case instantCase = caseRepository.findById(o);
//            CaseNumberVO ins = new CaseNumberVO(instantCase.getId(),instantCase.getCaseNumber());
//            list.add(ins);
//        }

    }
}
