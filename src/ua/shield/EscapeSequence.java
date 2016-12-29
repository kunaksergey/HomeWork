package ua.shield;

/**
 * Created by sa on 29.12.16.
 */
@ChapterDef(desc="Escape последовательности")
public class EscapeSequence {

    @TaskDef(desc="Вывести на экран текст лесенкой")
    public void textByLadder(){
        System.out.print("Фамилия\n\tОтчество\n\t\tИмя");
    }
}
