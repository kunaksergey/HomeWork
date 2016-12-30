package ua.shield;

import java.util.HashMap;

/**
 * Created by sa on 30.12.16.
 */
public class ProxyAnnotationClass {
    Object aClass;
    String classDesc;
    HashMap<String,Method> methodMap=new HashMap<>();

    public Object getaClass() {
        return aClass;
    }

    public void setaClass(Object aClass) {
        this.aClass = aClass;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public String getConditionMethod(String methodName){
        return methodMap.get(methodName);
    }

    public HashMap<String, String> getMethodMap() {
        return methodMap;
    }


}
