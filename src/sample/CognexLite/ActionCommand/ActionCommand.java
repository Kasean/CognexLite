package sample.CognexLite.ActionCommand;

import sample.CognexLite.Connect.WorkWithConnection;

import java.io.IOException;

public class ActionCommand{

    public static void reboot() {
        System.out.println("REBOOT");

        String actionCommand = "||>REBOOT\r\n";

        byte[] reboot = actionCommand.getBytes();

        try{
            WorkWithConnection.getSocket().getOutputStream().write(reboot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void trigger() {

        String actionCommandTrigger = "||>trigger on\r\n";

        byte[] byteActionCommands = actionCommandTrigger.getBytes();

        try{
            WorkWithConnection.getSocket().getOutputStream().write(byteActionCommands);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void tune() {

        System.out.println("TUNE.START");
        String actionCommand = "||>TUNE.START\r\n";
        byte[] doTune = actionCommand.getBytes();

        try{
            WorkWithConnection.getSocket().getOutputStream().write(doTune);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
