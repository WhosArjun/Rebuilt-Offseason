package frc.robot.commands;
import java.util.Timer;
public class Trapezoidal {
    private double MAX_SPEED;
    private double MAX_ACCEL;
    private double distance;
    private double goalX;
    private double Ta;
    private double twoTriangleArea;
    private double Tmax;
    private double areaOfRectangle;
    private double t1;
    
    public Trapezoidal(double MAX_SPEED, double MAX_ACCEL, double distance, double goalX
                    , double Ta, double twoTriangleArea, double Tmax, double areaOfRectangle, double t1){
        this.MAX_SPEED = MAX_SPEED;
        this.MAX_ACCEL = MAX_ACCEL;
        this.distance = distance;
        this.goalX = goalX;
        this.Ta = (MAX_SPEED)/Math.tan(MAX_ACCEL);
        this.twoTriangleArea = (MAX_SPEED)*Ta;
        this.Tmax = (goalX)/MAX_SPEED-Ta;
        this.areaOfRectangle = Tmax * MAX_SPEED;
        this.t1 = Ta+Tmax;
    }
        double trapezoidArea = twoTriangleArea+areaOfRectangle; //Area of the trapezoid 
        
        //Piecewise function
        public void speedFunctions(double t, double t1){
            double accelerationFunction = MAX_ACCEL*t;  //Aceleration
            double decelerationFunction = -MAX_ACCEL*(t-t1)+MAX_SPEED; //Deceleration
            double pieceWiseFunctionThree = MAX_SPEED; //Constant speed
        }
      
    

    /*public double twoTriangleArea(){
        double Ta = (MAX_SPEED)/Math.tan(MAX_ACCEL); //Hypotenuse of triangle
        double base = (MAX_SPEED)*Ta;
        return base;
    }

    public double rectangleArea(){
        double Ta = (MAX_SPEED)/Math.tan(MAX_ACCEL);
        double Tmax = (goalX)/MAX_SPEED-Ta;
        return Tmax;
    }
        */

    
}
