import java.util.LinkedList;
import java.util.Queue;
///Moving Average class.


public class MovingAverage {

    public Queue<Double> window = new LinkedList<Double>();
    public int p;
    public double sum;
    public double varSum;


    public MovingAverage(int period) {
        assert period > 0 : "Period must be a positive integer";
        p = period;
    }

    public void newNum(double num) {
        double old = num;
        if(window.size()> 1) {
            old = window.element();
        }
        double oldavg = getAvg();

        sum += num;
        if (window.size() > p) {
            sum -= window.remove();
        }
        double newavg = getAvg();
        System.out.println(oldavg + " --" + newavg);
        varSum += (num - old) * (num - newavg + old - oldavg);
        window.add(num);

    }


    public double getAvg() {
        if (window.isEmpty()) return 0; // technically the average is undefined
        return sum / window.size();
    }

    public double getVar() {
        if (window.isEmpty()) return 0; // technically the average is undefined
        return varSum / window.size();
    }

}
