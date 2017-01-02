package ua.shield.task;

import ua.shield.annotation.DefAnnotation;

/**
 * Created by sa on 29.12.16.
 */
@DefAnnotation(desc="Логические выражения")
public class BooleanExpresion {

    @DefAnnotation(desc="Вычислить значение логического выражениея при слудующих значениях" +
            "логических величин A,B и C A=истина,B=ложь, C=ложь")
    public void firtTask(){
         final boolean a=true;
         final boolean b=false;
         final boolean c=false;
        System.out.println("A или B:"+(a||b));
        System.out.println("A и B:"+(a&&b));
        System.out.println("B или C:"+(b||c));

    }

    @DefAnnotation(desc="Вычислить значение логического выражениея при слудующих значениях" +
            "логических величин X,Y и Z:X=Ложь, Y=истина,Z=ложь")
    public void secondTask(){
        final boolean x=false;
        final boolean y=true;
        final boolean z=false;
        System.out.println("X или Z"+(x||z));
        System.out.println("X и Y"+(x&&y));
        System.out.println("X и Z"+(x&&z));

    }
    @DefAnnotation(desc="Вычислить значение логического выражениея при слудующих значениях" +
            "логических величин A,B и C A=истина,B=ложь, C=ложь")
    public void thirdTask(){
        final boolean a=true;
        final boolean b=false;
        final boolean c=false;
        System.out.println("не A и B:"+(!a&&b));
        System.out.println("A или не B:"+(a||!b));
        System.out.println("A и B или С:"+((a&&b)||c));

    }
}
