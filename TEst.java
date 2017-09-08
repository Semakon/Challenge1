import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Frank on 07-09-17.
 */
public class TEst {

    public static void main(String args[]) throws FileNotFoundException {

        Scanner s = new Scanner(new File("C:/Users/Frank/IdeaProjects/Challenge1/src/Accelcopy.txt"));
        MovingAverage ma = new MovingAverage(100);
        float[] array = new float[38736];
        int i = 0;
        try{
            PrintWriter writer = new PrintWriter("movavgAccel.txt", "UTF-8");
            PrintWriter writer2 = new PrintWriter("movvarAccel.txt", "UTF-8");
            while(s.hasNextFloat()) {

                array[i] = s.nextFloat();
                ma.newNum(array[i]);
                float valueAfterMovingAverage = (float) ma.getAvg();
                System.out.println(valueAfterMovingAverage);
                writer.println(valueAfterMovingAverage);
                writer2.println((float)ma.getVar());
                i++;
                System.out.println(i);
            }
            writer.close();
        } catch (IOException e) {
            // do something
        }



    }
}







