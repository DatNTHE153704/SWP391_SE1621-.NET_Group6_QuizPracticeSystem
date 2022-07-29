/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Time;

/**
 *
 * @author DELL
 */
public class TimeLogic {

    public Time subTwoTime(Time a, Time b) {

        int result = (int) (a.getTime() - b.getTime());
        int hour = (result / 1000) / 3600;
        int minutes = ((result / 1000) - hour * 3600) / 60;
        int seconds = (result / 1000) % 60;

        Time time = new Time(hour, minutes, seconds);
        return time;
    }
}
