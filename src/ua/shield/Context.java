package ua.shield;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 30.12.16.
 */
public class Context {
    private String packageName;
    List<ProxyAnnotationClass> classList;
    {
        classList=new ArrayList<>();

    }

    public Context(String packageName) {
        this.packageName=packageName;
    }
    public void run(){
        showMainMenu(PackageScanner.getAnnotationClassesForPackage(packageName,"TaskDef"));

    }
    public static void showMainMenu(List<Class<?>> listClasses){
        System.out.println("0-Выход");
        int index=1;
        for (Class aClass:listClasses){
            System.out.println(index+" "+aClass.);
        }
    }
}

