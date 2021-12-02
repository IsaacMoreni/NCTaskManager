package mx.edu.j2se.moreno.evaluation;

/**
 * A class to manage the properties of a circle
 *
 * @author Isaac Moreno
 */

public class Circle {

    private float radius;

    /**
     * A construct of a circle whit radius equals to 1.
     */
    public Circle(){
        radius = 1.0f;
    }

    /**
     * A constructor with a settable radius of the circle
     * @param radius it has to be more than 0.
     * @exception IllegalArgumentException when radius is less than 0.
     */
    public Circle(float radius){
        if (radius < 0)
            throw new IllegalArgumentException();
        this.radius = radius;
    }

    /**
     * @param radius it has to be more than 0.
     * @exception IllegalArgumentException when radius is less than 0.
     */
    void setRadius(float radius){
        if (radius < 0)
            throw new IllegalArgumentException();
        this.radius = radius;
    }

    float getRadius(){
        return radius;
    }

    /**
     * Calculates the Area of the circle
     * @return The value of the area
     */
    float getArea(){
        return (float)(radius * radius * Math.PI);
    }

}
