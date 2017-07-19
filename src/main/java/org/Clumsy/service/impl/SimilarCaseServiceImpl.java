package org.Clumsy.service.impl;

import org.Clumsy.dao.CaseRepository;
import org.Clumsy.entity.Case;
import org.Clumsy.service.CaseService;
import org.Clumsy.service.SimilarCaseService;
import org.Clumsy.vo.CaseNumberVO;
import org.Clumsy.vo.CaseVO;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by slow_time on 2017/7/17.
 */

@Service("similarCaseService")
public class SimilarCaseServiceImpl implements SimilarCaseService {

    @Autowired
    CaseRepository caseRepository;

    @Override
    public List<CaseNumberVO> recommendCases(String id) {
        List<CaseNumberVO> list = new ArrayList<CaseNumberVO>();


        CaseService caseService = new CaseServiceImpl();
        CaseVO caseVO = caseService.getCaseInfoById(id);
        String cause = caseVO.cause;

        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("src/main/resources/python/Recommended.py");//需要修改

        PyFunction pyFunction = interpreter.get("getRecommendedCases", PyFunction.class); // 需要修改第一个参数为函数名字
        PyObject pyObject = pyFunction.__call__(new PyString(id),new PyString(cause));

        System.out.println(pyObject);

        String instant = pyObject.toString();
        instant = instant.substring(1,instant.length()-1);
        System.out.println(instant);
        String[] strList = instant.split(", ");
        for (String o:strList){
            o = o.substring(1,o.length()-1);
            System.out.println(o);
            Case instantCase = caseRepository.findById(o);
            CaseNumberVO ins = new CaseNumberVO(instantCase.getId(),instantCase.getCaseNumber());
            list.add(ins);
        }

        return list;
    }
}
