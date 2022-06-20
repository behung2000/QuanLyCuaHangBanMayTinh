/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_Run;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author thaiv
 */
public class CheckInput 
{
    HandlingString HS = new HandlingString();
    public boolean KTSDT(String SDT)
    {
        try
        {
            long a = Long.parseLong(SDT);
        }
        catch(NumberFormatException exception)
        {
            return false;
        }
        if(SDT.length()<10 || SDT.length()>15) return false;
        return true;
    }
    
    public boolean KTCMND(String cmnd)
    {
        try
        {
            long a = Long.parseLong(cmnd);
        }
        catch(NumberFormatException exception)
        {
            return false;
        }
        if(cmnd.length()<9 || cmnd.length()>12) return false;
        return true;
    }
    
    public boolean KTMa(String Ma)
    {
        String test = HS.DelAllmyTrim(Ma);
        if(test.equals(Ma) && Ma.length() <=10) return true;
        return false;
    }

    public boolean KT_Date(String t) 
    {
        if (HS.DelAllmyTrim(t).equals(t) == false) {
            return false;
        }
        if (t.length() != 10) {
            return false;
        }
        if (t.charAt(4) != '-' || t.charAt(7) != '-') {
            return false;
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = df.parse(t);
            String YYYY = "" + t.charAt(0) + t.charAt(1) + t.charAt(2) + t.charAt(3);
            String MM = "" + t.charAt(5) + t.charAt(6);
            String DD = "" + t.charAt(8) + t.charAt(9);
            int Year = Integer.parseInt(YYYY);
            int Month = Integer.parseInt(MM);
            int Day = Integer.parseInt(DD);
            if (Month < 1 && Month > 12) {
                return false;
            }
            if (Day < 1) {
                return false;
            }
            if (Month == 2) {
                if ((Year % 4) == 0) {
                    if (Day > 29) {
                        return false;
                    }
                } else if (Day > 28) {
                    return false;
                }
            } else {
                if (Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12) {
                    if (Day > 31) {
                        return false;
                    }
                } else if (Day > 30) {
                    return false;
                }
            }
        } catch (ParseException ex) {
            return false;
        }
        return true;
    }
    
    public boolean KT_so(String t)
    {
        try
        {
            int a = Integer.parseInt(t);
        }
        catch(NumberFormatException exception)
        {
            return false;
        }
        return true;
    }
}
