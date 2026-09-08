package frc.robot.subsystems.Shooter;
import java.util.function.Supplier;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer.RobotState;




public class Shooter extends SubsystemBase{
    public TalonFX shooterMotor;
    public TalonFX indexMotor;

    public Shooter(int shooterMotorID, int indexMotorID){
        this.shooterMotor = new TalonFX(shooterMotorID);
        this.indexMotor = new TalonFX(indexMotorID);
        this.shooterMotor.setNeutralMode(NeutralModeValue.Coast);
        this.indexMotor.setNeutralMode(NeutralModeValue.Brake);
    }
}
