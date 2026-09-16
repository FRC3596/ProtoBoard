// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;


import com.revrobotics.PersistMode;
// import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import edu.wpi.first.wpilibj.DigitalInput;

public class PrototypeSub extends SubsystemBase {

  public boolean limitswitchPressed = false;
  public boolean lastPress = false;
  private final SparkMax boardMotor = new SparkMax(1, MotorType.kBrushless);
  private SparkMaxConfig boardConfig = new SparkMaxConfig();

  // private final RelativeEncoder boardEncoder = boardMotor.getEncoder();
  public DigitalInput limSwitchInput = new DigitalInput(0);

  /** Creates a new PrototypeSub. */
  public PrototypeSub() {
    boardMotor.configure(boardConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }

  public void runBoard(double motorSpeed) {

  boardMotor.set(motorSpeed);

  }

  public boolean limSwitchPressed() {
    return !limSwitchInput.get();
  }

}
