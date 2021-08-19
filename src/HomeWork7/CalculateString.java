package HomeWork7;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateString {

    public static void main(String[] args) {
        System.out.println("тест");
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Введите выражение в формате \"аргумент1 арифметическаяОперация аргумент2\"");
        String data ="";
        try {
           data  = scanner.nextLine();
           if (data.equals("")){
               System.out.println("Вы ничего не ввели");
           }
           else {
               ArrayList <String> arrayStrok = new ArrayList<>();
               //передаем  текст для создания массива
               arrayStrok = FindParts(data,arrayStrok);
               if (arrayStrok.size()!=3){
                   System.out.println("Вы ввели данные в неверном формате");
               }
               else {
                   double rezultat = computation(arrayStrok);
                   System.out.println(String.format("Значением выражения %s является %f.0",data,rezultat));
               }
           }
        }catch (Exception e){
            System.err.println("Получили недопустимое выражение: "+ e);
        }


    }

    public static ArrayList<String> FindParts(String text, ArrayList<String> arrayStrok){
        String regexProbel="[^\\s]+";
        Pattern datePatternProbel =Pattern.compile(regexProbel);
        Matcher findDateProbel = datePatternProbel.matcher(text);

        while (findDateProbel.find()){
            arrayStrok.add(findDateProbel.group(0));
        }
        return  arrayStrok;
    }

    public static double computation(ArrayList <String> arrayStrok){
        double ch1=0;
        double ch2=0;
        String operation = arrayStrok.get(1);
        double rezult;
        try {
            ch1 = Double.parseDouble(arrayStrok.get(0));
        }catch (Exception e){
            System.err.println(String.format
                    ("Первые символы( %s) -  не являются числом. Ошибка: %s",arrayStrok.get(0),e );
        }

        try {
            ch2 = Double.parseDouble(arrayStrok.get(0));
        }catch (Exception e){
            System.err.println(String.format
                    ("Последние символы( %s) -  не являются числом. Ошибка: %s",arrayStrok.get(2),e );
        }

        if (operation.equals("плюс")) {
            return (ch1+ch2);
        }
        else  if(operation.equals("минус")){
            return (ch1-ch2);
        }
        else  if(operation.equals("умножить")){
            return (ch1*ch2);
        }
        else  if(operation.equals("делить")){
            try {
                rezult = ch1/ch2;
                return rezult;
            }catch (Exception e){
                System.err.println("Делить на 0 нельзя"+ e );
            }
           // return (0);
        }
        else {
            System.out.println("Вы ввели недопустимую арифметическую операцию");
        }



    }
}
