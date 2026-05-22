package frc.robot.commands;

public class Trapezoidal {
    private double MAX_SPEED;
    private double MAX_ACCEL;
    private double distance;
    private double goalX;
    private double Ta;
    private double twoTriangleArea;
    private double Tmax;
    private double areaOfRectangle;
    private double t;
    private double t1;
    
    public Trapezoidal(double MAX_SPEED, double MAX_ACCEL, double distance, double goalX
                    , double Ta, double twoTriangleArea, double Tmax, double areaOfRectangle, double t1, double t){
        this.MAX_SPEED = MAX_SPEED;
        this.MAX_ACCEL = MAX_ACCEL;
        this.distance = distance;
        this.goalX = goalX;
        this.Ta = (MAX_SPEED)/Math.tan(MAX_ACCEL);
        this.twoTriangleArea = (MAX_SPEED)*Ta;
        this.Tmax = (goalX)/MAX_SPEED-Ta;
        this.areaOfRectangle = Tmax * MAX_SPEED;
        this.t1 = Ta+Tmax;
        this.t = t;
    }
    double trapezoidArea = twoTriangleArea+areaOfRectangle; //Area of the trapezoid 

    //MAX_SPEED
    public double getMaxSpeed(){
        return MAX_SPEED;
    }
    //MAX_ACCELERATION
    public double getMaxAccel(){
        return MAX_ACCEL;
    }
    //Base of the triangle
    public double getTa(){
        return Ta;
    }
    //Top width of the trapezoid
    public double getTmax(){
        return Tmax;
    }
    //Peak of the MAX_SPEED//ACCELERATION on the right side
    public double getT1(){
        return t1;
    }
    //t is time
    public double getTime(){
        return t;
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
