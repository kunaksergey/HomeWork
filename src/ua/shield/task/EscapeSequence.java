package ua.shield.task;

import ua.shield.annotation.DefAnnotation;

/**
 * Created by sa on 29.12.16.
 */
@DefAnnotation(desc="Escape последовательности")
public class EscapeSequence {

    @DefAnnotation(desc="Вывести на экран текст лесенкой")
    public void textByLadder(){
        System.out.print("Фамилия\n\tОтчество\n\t\tИмя");
    }
}
