import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ryan Benasutti on 4/1/2016.
 */

public class Main
{
    public static void main(String[] args)
    {
        //Drive motors
        List<String> leftDriveMotors = new ArrayList<>();
        leftDriveMotors.add("leftDriveBottomFront");
        leftDriveMotors.add("leftDriveBottomBack");
        leftDriveMotors.add("leftDrivePerma");
        leftDriveMotors.add("leftDriveTopBack");

        List<String> rightDriveMotors = new ArrayList<>();
        rightDriveMotors.add("rightDriveBottomFront");
        rightDriveMotors.add("rightDriveBottomBack");
        rightDriveMotors.add("rightDrivePerma");
        rightDriveMotors.add("rightDriveTopBack");

        //Intake motors
        List<String> intakeMotors = new ArrayList<>();
        intakeMotors.add("intakeFront");
        intakeMotors.add("intakeBack");

        //Launcher motors
        List<String> launcherMotors = new ArrayList<>();
        launcherMotors.add("leftDriveBottomFront");
        launcherMotors.add("leftDriveBottomBack");
        launcherMotors.add("leftDrivePerma");
        launcherMotors.add("leftDriveTopBack");

        //Output file
        Path outputFile = Paths.get("outputFile.txt");

        //Lines to write
        List<String> lines = new ArrayList<>();
        lines.add("//START AUTO GENERATED MACROS");

        //Add left drive motors
        String setAllLeftDriveMotors = "#define setAllLeftDriveMotors(power) ";
        String setAllLeftDriveMotorsRaw = "#define setAllLeftDriveMotorsRaw(power) ";
        Iterator<String> ldmi = leftDriveMotors.iterator();
        while (ldmi.hasNext())
        {
            String next = ldmi.next();

            //Put semicolon in if this is not the last element
            if (ldmi.hasNext())
            {
                setAllLeftDriveMotors += "setMotorSpeed(" + next + ", power); ";
                setAllLeftDriveMotorsRaw += "motor[" + next + "] = power; ";
            }
            else
            {
                setAllLeftDriveMotors += "setMotorSpeed(" + next + ", power)";
                setAllLeftDriveMotorsRaw += "motor[" + next + "] = power";
            }
        }
        lines.add(setAllLeftDriveMotors);
        lines.add(setAllLeftDriveMotorsRaw);

        //Add right drive motors
        String setAllRightDriveMotors = "#define setAllRightDriveMotors(power) ";
        String setAllRightDriveMotorsRaw = "#define setAllRightDriveMotorsRaw(power) ";
        Iterator<String> rdmi = rightDriveMotors.iterator();
        while (rdmi.hasNext())
        {
            String next = rdmi.next();

            //Put semicolon in if this is not the last element
            if (rdmi.hasNext())
            {
                setAllRightDriveMotors += "setMotorSpeed(" + next + ", power); ";
                setAllRightDriveMotorsRaw += "motor[" + next + "] = power; ";
            }
            else
            {
                setAllRightDriveMotors += "setMotorSpeed(" + next + ", power)";
                setAllRightDriveMotorsRaw += "motor[" + next + "] = power";
            }
        }
        lines.add(setAllRightDriveMotors);
        lines.add(setAllRightDriveMotorsRaw);

        //Add all drive motors
        String setAllDriveMotors = "#define setAllDriveMotors(power) ";
        String setAllDriveMotorsRaw = "#define setAllDriveMotorsRaw(power) ";
        Iterator<String> ldmri = leftDriveMotors.iterator();
        Iterator<String> rdmri = rightDriveMotors.iterator();
        while (ldmri.hasNext())
        {
            String next = ldmri.next();

            setAllDriveMotors += "setMotorSpeed(" + next + ", power); ";
        }
        while (rdmri.hasNext())
        {
            String next = rdmri.next();

            //Put semicolon in if this is not the last element
            if (rdmri.hasNext())
            {
                setAllDriveMotors += "setMotorSpeed(" + next + ", power); ";
                setAllDriveMotorsRaw += "motor[" + next + "] = power; ";
            }
            else
            {
                setAllDriveMotors += "setMotorSpeed(" + next + ", power)";
                setAllDriveMotorsRaw += "motor[" + next + "] = power";
            }
        }
        lines.add(setAllDriveMotors);
        lines.add(setAllDriveMotorsRaw);

        //Add right drive motors
        String setAllIntakeMotors = "#define setAllIntakeMotors(power) ";
        String setAllIntakeMotorsRaw = "#define setAllIntakeMotorsRaw(power) ";
        Iterator<String> imi = rightDriveMotors.iterator();
        while (imi.hasNext())
        {
            String next = imi.next();

            //Put semicolon in if this is not the last element
            if (imi.hasNext())
            {
                setAllIntakeMotors += "setMotorSpeed(" + next + ", power); ";
                setAllIntakeMotorsRaw += "motor[" + next + "] = power; ";
            }
            else
            {
                setAllIntakeMotors += "setMotorSpeed(" + next + ", power)";
                setAllIntakeMotorsRaw += "motor[" + next + "] = power";
            }
        }
        lines.add(setAllIntakeMotors);
        lines.add(setAllIntakeMotorsRaw);

        //Add launcher motors
        String setAllLauncherMotors = "#define setAllLauncherMotors(power) ";
        String setAllLauncherMotorsRaw = "#define setAllLauncherMotorsRaw(power) ";
        Iterator<String> lmi = launcherMotors.iterator();
        while (lmi.hasNext())
        {
            String next = lmi.next();

            //Put semicolon in if this is not the last element
            if (lmi.hasNext())
            {
                setAllLauncherMotors += "setMotorSpeed(" + next + ", power); ";
                setAllLauncherMotorsRaw += "motor[" + next + "] = power; ";
            }
            else
            {
                setAllLauncherMotors += "setMotorSpeed(" + next + ", power)";
                setAllLauncherMotorsRaw += "motor[" + next + "] = power";
            }
        }
        lines.add(setAllLauncherMotors);
        lines.add(setAllLauncherMotorsRaw);

        //Write lines to file
        lines.add("//END AUTO GENERATED MACROS");
        try
        {
            Files.write(outputFile, lines, Charset.forName("UTF-8"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
