package ua.shield;

import ua.shield.annotation.DefAnnotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 30.12.16.
 */
public class PackageScanner {


    public static List<Class<?>> getAnnotationClassesForPackage(String packageName, String annotationName) {
        ArrayList<Class<?>> classes = new ArrayList<>();
        String relPath = packageName.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);
        File directory = new File(resource.getPath());
        String[] files = directory.list();
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i];
            String className = null;


            if (fileName.endsWith(".class")) {
                className = packageName + '.' + fileName.substring(0, fileName.length() - 6);
                try {
                    Class c = Class.forName(className);
                    if (checkClassForAnnotation(Class.forName(className), annotationName)) {
                        classes.add(Class.forName(className));
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        return classes;
    }

    public static List<Method> getAnnotationMethodForClass(Class<?> aClass, String annotaionName) {
        ArrayList<Method> methods = new ArrayList<>();
        for (Method method : aClass.getMethods()) {
            if (checkMethodForAnnotation(method, annotaionName)) {
                methods.add(method);
            }
        }
        return methods;
    }

    public static String getDescForClass(Class<?>aClass) throws AnnotationIsNotSupport{
        DefAnnotation defAnnotation = aClass.getDeclaredAnnotation(DefAnnotation.class);

        if(defAnnotation!=null){
            return defAnnotation.desc();
        }else{
            throw new AnnotationIsNotSupport("Аннотация не поддерживается");
        }

    }

    private static boolean checkClassForAnnotation(Class<?> aClass, String annotationName) {
        Annotation[] declaredAnnotations = aClass.getDeclaredAnnotations();
        for (Annotation a : declaredAnnotations) {
            if (a.annotationType().getSimpleName().equals(annotationName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkMethodForAnnotation(Method method, String annotationName) {
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        for (Annotation a : declaredAnnotations) {
            if (a.annotationType().getSimpleName().equals(annotationName)) {
                return true;
            }
        }
        return false;
    }


}