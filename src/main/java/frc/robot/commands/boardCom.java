// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PrototypeSub;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class boardCom extends Command {
  /** Creates a new boardCom. */
  private final PrototypeSub m_boardSub;
  private final double m_motorSpeed;
  public int scalar = 1;
  public int past = 1;

  public boardCom(PrototypeSub boardSub, double motorSpeed) {
    m_boardSub = boardSub; // Use addRequirements() here to declare subsystem dependencies.
    m_motorSpeed = motorSpeed;

    addRequirements(m_boardSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_boardSub.runBoard(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (m_boardSub.limSwitchPressed() == true) {

      if (past != 1) {
        scalar = -scalar;
        past = 1;
      } 
    } else if (m_boardSub.limSwitchPressed() == false) {
      past = 0;
    }

    m_boardSub.runBoard(scalar * m_motorSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}