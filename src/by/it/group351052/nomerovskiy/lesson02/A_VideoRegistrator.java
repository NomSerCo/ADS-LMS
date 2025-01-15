package by.it.group351052.nomerovskiy.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
даны события events
реализуйте метод calcStartTimes, так, чтобы число включений регистратора на
заданный период времени (1) было минимальным, а все события events
были зарегистрированы.
Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class A_VideoRegistrator {

    public static void main(String[] args)  {
        A_VideoRegistrator instance=new A_VideoRegistrator();
        double[] events=new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        List<Double> starts=instance.calcStartTimes(events,1); //рассчитаем моменты старта, с длинной сеанса 1
        System.out.println(starts);                            //покажем моменты старта
    }
    List<Double> calcStartTimes(double[] events, double workDuration)  {
        //events - события которые нужно зарегистрировать
        //timeWorkDuration время работы видеокамеры после старта
        List<Double> result;
        result = new ArrayList<>();

        int i=0;

        //сортировка
        Arrays.sort(events);

        while (i < events.length) {
            // выбираем текущее событие как момент старта видеорегистратора
            double start = events[i];
            result.add(start);

            // пропускаем все события, которые покрываются текущей работой регистратора
            while (i < events.length && events[i] <= start + workDuration) {
                i++;
            }
        }
        return result;
    }
}
