package org.Clumsy.util;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 * Created by Lucifer on 17/7/19.
 */
public class UserPthonHelper {

    public static void main(String[]args){
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("print('hello')");

        interpreter.execfile("src/main/python/getSimilarID.py");

        PyFunction pyFunction = interpreter.get("getID", PyFunction.class); // 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
        PyObject pyObject = pyFunction.__call__(new PyInteger(1)); // 调用函数

        System.out.println(pyObject);
    }
}
