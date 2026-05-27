package frc.robot.commands;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class TrapezoidalTurn extends Command{
    private Drivetrain drivetrain;
    private double angle;
    private double maxAngularAccel;
    private double maxAngularSpeed;
    
    private double peakSpeed;
    private double Ta;
    private double Tmax;
    private double totalTime;
    private double direction;
    private double startTime;

    public TrapezoidalTurn(Drivetrain drivetrain, double maxAngularSpeed, double maxAngularAccel,
                            double angleDegrees){
        this.drivetrain = drivetrain;
        this.maxAngularSpeed = Math.abs(maxAngularSpeed);
        this.maxAngularAccel = Math.abs(maxAngularAccel);
        direction = Math.signum(angleDegrees);
        this.angle = Math.abs(Math.toRadians(angleDegrees));
        calculateProfile();
        addRequirements(drivetrain);
    }

    public void calculateProfile(){
        double accelTimeToMax = maxAngularSpeed/maxAngularAccel;
        double accelAngle = 0.5 * maxAngularAccel * Math.pow(accelTimeToMax,2);
        double minAngleForTrapezoid = accelAngle * 2;

        if(angle<minAngleForTrapezoid){
            peakSpeed = Math.sqrt(angle*maxAngularAccel);
            Ta = peakSpeed/maxAngularAccel;
            Tmax = 0;
        }

        else {
            peakSpeed = maxAngularSpeed;
            Ta = accelTimeToMax;
            double cruiseAngle = angle-minAngleForTrapezoid;
            Tmax = cruiseAngle/peakSpeed;
        }
        totalTime = (2*Ta)+Tmax;
    }

    public double getTime(){
        return Timer.getFPGATimestamp()-startTime;
    }

    public double angularSpeed(){
        double t = getTime();
        if(t<Ta){
            return maxAngularAccel*t;
        }
        else if(t<=Ta+Tmax){
            return peakSpeed;
        }
        else{
            double decelTime = t-(Ta+Tmax);
            return Math.max(0, peakSpeed-(maxAngularAccel*decelTime));
        }
    }

    @Override
    public void initialize(){
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public void execute(){
        double omega = angularSpeed()*direction;
        drivetrain.swerveDrive.drive(new ChassisSpeeds(0,0,omega));
    }

    @Override
    public boolean isFinished(){
        return getTime()>=totalTime;
    }

    @Override
    public void end(boolean interrupted){
        drivetrain.swerveDrive.drive(new ChassisSpeeds(0,0,0));
    }

}