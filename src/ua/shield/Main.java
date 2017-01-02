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
        context.run();
    }
}
