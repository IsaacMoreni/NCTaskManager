package mx.edu.j2se.moreno.evaluation;

import java.rmi.ConnectIOException;

public class Evaluation1 {

    public static void main(String[] args){

        try{
            Circle exceptionCircle = new Circle(-15);
        } catch (Exception e){
            System.out.println("Error: " + e + ": expected value: more than 0.");
        }

        Circle c1 = new Circle(45.0f);
        Circle c2 = new Circle(60.0f);
        Circle c3 = new Circle(26.0f);

        Circle[] circles = {c3,c1,c2};

        int biggest = biggestCircle(circles);
        System.out.println("\nThe biggest circle has the radius: " + circles[biggest].getRadius());

    }

    static int biggestCircle(Circle[] circles){
        int bigger = 0;
        for(int i=1; i< circles.length; i++){
            if(circles[i].getRadius() > circles[bigger].getRadius())
                bigger = i;
        }
        return bigger;
    }

}
