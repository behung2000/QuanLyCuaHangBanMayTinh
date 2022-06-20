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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thaiv
 */
public class HandlingString 
{
    public String myTrim(String s)
    {
        return (s.trim()).replaceAll("\\s+"," ");
    }
    
    public String DelAllmyTrim(String s)
    {
        return (s.trim()).replaceAll("\\s+","");
    }

    public boolean KT_Ten(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        String Sreplace = s1.replaceAll(s2, "1");
        boolean a = s1.equals(Sreplace);
        if (a == false) {
            return true;
        }
        return false;
    }
    
}
