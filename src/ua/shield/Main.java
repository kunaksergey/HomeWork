package ua.shield;

import jdk.internal.util.xml.impl.Input;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sa on 29.12.16.
 */
public class Main {
    final private static String packageName="ua.shield.task";

    public static void main(String[] args) {
        Context context=new Context(packageName);
        for (ProxyAnnotationClass proxy:context.getClassList()) {
            System.out.println(proxy.getClassDesc());
        }
    }

    public static void createMenu(String [] arr){
        System.out.println("Выберите нужный пункт");
        System.out.println("Для выхода нажмите 0");
        for(int i=1;i<=arr.length;i++){
            System.out.println(i+ " "+arr[i]);
        }

        Scanner scanner=new Scanner(System.in);
        int selectedItem=scanner.nextInt();

    }

    List<Class<?>> getAnnotationClass(){
        List<Class<?>> listClasses=new ArrayList<>();

    return  listClasses;
    }
}
