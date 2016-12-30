package ua.shield;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 30.12.16.
 */
public class Context {
    private String packageName;
    private Annotation descAnnotation;
    private List<ProxyAnnotationClass> classList=new ArrayList<>();;


    public Context(String packageName) {
        this.packageName=packageName;
        init();
    }

    private void init(){
        List<Class<?>> listClasses= PackageScanner.getAnnotationClassesForPackage(packageName,"DefAnnotation");
        for (Class<?>aClass:listClasses){
            ProxyAnnotationClass proxy=new ProxyAnnotationClass();
            try {
                proxy.setaClass(aClass.newInstance());
                proxy.setClassDesc(PackageScanner.getDescForClass(aClass));
                classList.add(proxy);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (AnnotationIsNotSupport annotationIsNotSupport) {
                annotationIsNotSupport.printStackTrace();
            }
        }
    }
    public void run(){
        showMainMenu(PackageScanner.getAnnotationClassesForPackage(packageName,"TaskDef"));

    }
    public static void showMainMenu(List<Class<?>> listClasses){
        System.out.println("0-Выход");
        int index=1;
        for (Class aClass:listClasses){
            //System.out.println(index+" "+aClass.);
        }
    }

    public List<ProxyAnnotationClass> getClassList() {
        return classList;
    }
}

