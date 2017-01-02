package ua.shield.task;

import ua.shield.annotation.DefAnnotation;

import java.util.*;

/**
 * Created by sa on 02.01.17.
 */
@DefAnnotation(desc ="Ветвления")
public class BranchOperation {
   private  Scanner snanner=new Scanner(System.in);
    @DefAnnotation(desc = "Ввести с клавиатуры число в диапазоне от 100 до 100000000 (введенное\n" +
            "число проверяется). Подсчитать количество четных и нечетных цифр в\n" +
            "этом числе в процентном отношении.")

    public void taskOne() {
        System.out.println("Введите число от 100 до 100000000");
        int even=0;
        int uneven=0;
        long number=snanner.nextLong();
        if(number<100||number>100000000){
            System.out.println("Число не входит в требуемый диапазон");
        }else {
            try {
                int[] arr=numberToArrayFromDigit(number);
                for(int i=0;i<arr.length;i++){
                    if(arr[i]%2==0&& arr[i]!=0){
                        even++;
                    }else if(arr[i]%2!=0&& arr[i]!=0){
                        uneven++;
                    }
                }
                System.out.println("В числе: "+number+" кол-во четных цифр: "+even+",кол-во нечетных: "+uneven);

            } catch (NumberOverRangeExeption numberOverRangeExeption) {
                numberOverRangeExeption.printStackTrace();
            }
        }
    }

    @DefAnnotation(desc = "Ввести с клавиатуры номер трамвайного билета (6-значное число) и\n" +
            "проверить является ли данный билет счастливым.")
    public void taskTwo(){
        System.out.println("Введите номер трамвайного билета (6-значное число):");
        int number=snanner.nextInt();
        if(number/1000000==0&&number/100000>1){
            try {
                int[]arr=numberToArrayFromDigit(number);
                if(arr[0]+arr[1]+arr[2]==arr[3]+arr[4]+arr[5]){
                    System.out.println("Билет счастливый.:)");
                }else {
                    System.out.println("Билет НЕСЧАСТЛИВЫЙ!~(");
                }

            } catch (NumberOverRangeExeption numberOverRangeExeption) {
                numberOverRangeExeption.printStackTrace();
            }
        }else{
            System.out.println("Число не является 6-ти значным");
        }

    }

    @DefAnnotation(desc = "Ввести с клавиатуры дату своего рождения и текущую дату. Необходимо\n" +
            "вычислить разницу в днях между этими датами.")
    public void taskThree() {
        System.out.println("Введите дату свого рождения(dd.mm.yyyy)");
        String str=snanner.nextLine();
        String[] dateOfBirthday=str.split("\\.");
        Calendar calendar=Calendar.getInstance();
        long currentTimeInMillis=calendar.getTimeInMillis();
        calendar.set(Integer.parseInt(dateOfBirthday[2]),Integer.parseInt(dateOfBirthday[1]),Integer.parseInt(dateOfBirthday[0]));
        long birthdayTimeInMillis=calendar.getTimeInMillis();
        System.out.println("Разница в днях между вашим днем рождения и сегодняшней датой: ");
        System.out.println((currentTimeInMillis-birthdayTimeInMillis)/1000/60/60/24);
    }

    @DefAnnotation(desc = "")
    public void taskFour() {

    }

    @DefAnnotation(desc = "")
    public void taskFive() {

    }

    @DefAnnotation(desc = "")
    public void taskSix() {

    }

    @DefAnnotation(desc = "Проверить, принадлежит ли число, введенное с клавиатуры,\n" +
            "интервалу (–5, 3).")
    public void taskSeven() {
        System.out.println("Введите число:");
        double value = snanner.nextDouble();
        if(value>-5&&value<3){
            System.out.println("Число принадлежит интервалу:(–5, 3)");
        }else{
            System.out.println("Число не входит в интервал:(–5, 3)");
        }
    }

    @DefAnnotation(desc = "Даны два различных вещественных числа. Определить наибольшее и\n" +
            "наименьшее из них, не используя полный условный оператор, а применив:\n" +
            "а) два неполных условных оператора;\n" +
            "б) один неполный условный оператор.")
    public void taskEight() {
        double min;
        double max;
        System.out.println("Введите два различных вещественных числа. ");
        System.out.println("Введите 1-е число:");
        double numOne = snanner.nextDouble();
        System.out.println("Введите 2-е число:");
        double numTwo = snanner.nextDouble();
        System.out.println("Используем 2 неполных оператора");
        min=max=numOne;
        if(numOne>numTwo){
            min=numTwo;
            max=numOne;
        }
        if(numOne<numTwo){
            min=numOne;
            max=numTwo;
        }
        System.out.println("Min:"+min+" Max: "+max);

        System.out.println("Используем 1 неполный оператор");
        min=numOne;
        max=numTwo;
        if(numOne>numTwo){
           min=numTwo;
            max=numOne;
        }
        System.out.println("Min:"+min+" Max: "+max);
    }

    @DefAnnotation(desc = "Даны три различных вещественных числа. Не используя полный\n" +
            "условный оператор, определить:\n" +
            "а) наибольшее из них;\n" +
            "б) наименьшее из них.")
    public void taskNine() {
        double min;
        double max;
        System.out.println("Введите три различных вещественных числа. ");
        System.out.println("Введите 1-е число:");
        double numOne = snanner.nextDouble();
        System.out.println("Введите 2-е число:");
        double numTwo = snanner.nextDouble();
        System.out.println("Введите 3-е число:");
        double numThree = snanner.nextDouble();
        min=max=numOne;
        if(numTwo>numOne){
            max=numTwo;
        }
        if (numThree>numTwo){
            max=numThree;
        }
        if(numTwo<numOne){
            min=numTwo;
        }
        if(numThree<numTwo){
            min=numThree;
        }
        System.out.println("Min:"+min+" Max: "+max);
    }

    @DefAnnotation(desc = "")
    public void taskTen() {

    }

    private int[] numberToArrayFromDigit(final long number) throws NumberOverRangeExeption {
        long num=number;
        int i=0;

        int[] arrayFromDigit=new int[9];
        if(number>999999999){
            throw new NumberOverRangeExeption();
        }

        while(num>10){

            arrayFromDigit[i]= (int) (num%10);
            num=num/10;
            i++;
        }
        arrayFromDigit[i]=(int) num;
        return arrayFromDigit;
    }
}
