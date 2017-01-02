package ua.shield;


import ua.shield.annotation.DefAnnotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sa on 30.12.16.
 */
public class Context {
    private String packageName;
    public final static Class ANNOTAION_CLASS = DefAnnotation.class;
    private List<SceletonAnnotationClass> sceletonList = new ArrayList<>();


    public Context(String packageName) {
        this.packageName = packageName;
        init();
    }

    private void init() {
        List<Class> listClasses = PackageScanner.getAnnotationClassesForPackage(packageName, ANNOTAION_CLASS);
        for (Class aClass : listClasses) {
            SceletonAnnotationClass sceleton = new SceletonAnnotationClass();

            sceleton.setaClass(aClass);
            List<Method> methodList = PackageScanner.getAnnotationMethodsForClass(aClass, ANNOTAION_CLASS);
            for (Method method : methodList) {
                sceleton.addMethod(method);
            }
            sceletonList.add(sceleton);
        }
    }


    public void run() {
        showMenu(sceletonList);

    }


    public static void showMenu(List<SceletonAnnotationClass> sceletonList) {

        int chooseNumber;
        while (true) {
            System.out.println("0-Выход");
            for (int i = 0; i < sceletonList.size(); i++) {
                System.out.println(i + 1 + "-" + ((DefAnnotation) sceletonList.get(i).getaClass()
                        .getDeclaredAnnotation(ANNOTAION_CLASS)).desc());
            }
            System.out.println("Введите номер:");
            Scanner scanner = new Scanner(System.in);
            try {
                chooseNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите ЧИСЛО!!");
                continue;
            }
            if (chooseNumber < 0 || chooseNumber > sceletonList.size()) {
                System.out.println("Повторите выбор");
                continue;
            }
            if (chooseNumber == 0) {
                break;
            }

            try {
                SceletonAnnotationClass chooseSceletonAnnotationClass = sceletonList.get(chooseNumber - 1);
                Object instanceObject = chooseSceletonAnnotationClass.getaClass().newInstance();
                showSlaveMenu(instanceObject, chooseSceletonAnnotationClass.getMethodList());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }


    public static void showSlaveMenu(Object instanceObject, List<Method> methodList) {
        int chooseNumber;
        while (true) {
            System.out.println("0-Вернуться к основному меню");
            for (int i = 0; i < methodList.size(); i++) {
                System.out.println(i + 1 + "-" + ((DefAnnotation) methodList.get(i).getDeclaredAnnotation(ANNOTAION_CLASS)).desc());
            }
            System.out.println("Введите номер:");
            Scanner scanner = new Scanner(System.in);
            try {
                chooseNumber = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Введите ЧИСЛО!!");
                continue;
            }
            if (chooseNumber < 0 || chooseNumber > methodList.size()) {
                System.out.println("Повторите выбор");
                continue;
            }
            if (chooseNumber == 0) {
                break;
            }
            Method method = methodList.get(chooseNumber - 1);
            try {
                method.invoke(instanceObject);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

