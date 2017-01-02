package ua.shield.task;

/**
 * Created by sa on 02.01.17.
 */
public class NumberOverRangeExeption extends Exception {
    public NumberOverRangeExeption() {
        super("Число вышло за пределы возможного диапазона");
    }
}
