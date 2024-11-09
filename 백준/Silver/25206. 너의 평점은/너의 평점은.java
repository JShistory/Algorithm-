import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Double> gradePoint = new HashMap<>();
        gradePoint.put("A+",4.5);
        gradePoint.put("A0",4.0);
        gradePoint.put("B+",3.5);
        gradePoint.put("B0",3.0);
        gradePoint.put("C+",2.5);
        gradePoint.put("C0",2.0);
        gradePoint.put("D+",1.5);
        gradePoint.put("D0",1.0);
        gradePoint.put("F", 0.0);
        double answer = 0;
        double t = 0;
        for(int i=0; i<20; i++) {
            String[] input = br.readLine().split(" ");
            double grade = Double.parseDouble(input[1]);
            String point = input[2];
            if(point.equals("P")){
                continue;
            }
            t += grade;
            double gPoint = gradePoint.get(point);
            answer += (grade * gPoint);
        }
        System.out.println(String.format("%.6f", answer / t));
    }
}