/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package common.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

/**
 * @author Frank Purcell (TriMet)
 * @author David Leydier
 * @date October 20, 2009
 */

public class DateUtils {

    private static final List<String> DF_LIST = Collections.unmodifiableList(Arrays.asList(new String[] { 
            "yyyy.MM.dd.HH.mm.ss", "yyyy.MM.dd.HH.mm",
            "yyyy.MM.dd.HH.mm.ss.SS", "M.d.yy h.mm a", "M.d.yyyy h.mm a", "M.d.yyyy h.mma",
            "M.d.yyyy h.mm", "M.d.yyyy k.mm", "M.d.yyyy", "yyyy.M.d", "h.mm a"
    // NOTE: don't change the order of these strings...the simplest should be on the
    // bottom...you risk parsing the wrong thing (and ending up with year 0012)
    }));

    private static final List<String> SMALL_DF_LIST = Collections.unmodifiableList(
            Arrays.asList(new String[] { "M.d.yy", "yy.M.d", "h.mm a" }));
    private static final int SANITY_CHECK_CUTOFF_YEAR = 1000;

    /* Return a Date */
    static public Date parseDate(String input, TimeZone tz) {
        Date retVal = null;
        try {
            String newString = input.trim().replace('_', '.').replace('-', '.').replace(':', '.').replace(
                    '/', '.');
            if (newString != null) {
                List<String> dl = DF_LIST;

                if (newString.length() <= 8) {
                    if (newString.matches("\\d\\d\\d\\d\\d\\d\\d\\d")) {
                        // Accept dates without punctuation if they consist of exactly eight digits.
                        newString = newString.substring(0, 4)
                                + '.' + newString.substring(4, 6)
                                + '.' + newString.substring(6, 8);
                    } else if (!(newString.matches(".*20\\d\\d.*"))) {
                        // if it looks like we have a small date format, ala 11.4.09, then use
                        // another set of compares
                        dl = SMALL_DF_LIST;
                    }
                }
                
                for (String df : dl) {
                    SimpleDateFormat sdf = new SimpleDateFormat(df);
                    sdf.setTimeZone(tz);
                    retVal = DateUtils.parseDate(sdf, newString);
                    if (retVal != null) {
                        Calendar cal = new GregorianCalendar(tz);
                        cal.setTime(retVal);
                        int year = cal.get(Calendar.YEAR);
                        if (year >= SANITY_CHECK_CUTOFF_YEAR) {
                            break;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Could not parse " + input);
        }

        return retVal;
    }

    public synchronized static Date parseDate (SimpleDateFormat sdf, String string) {
        sdf.setLenient(false);
        try {
            return sdf.parse(string);
        } catch (Exception e) {
        }
        return null;
    }

    /* Return a number of seconds */
    public static long parseTime(String time) {
    	int[] aux = null;
        boolean amPm = false;
        int addHours = 0;
        int hour = 0, min = 0, sec = 0;
        try {
            String[] hms = time.toUpperCase().split(":");

            // if we don't have a colon sep string, assume string is int and represents seconds past midnight
            if (hms.length < 2) {
                int secondsPastMidnight = Integer.parseInt(time);
                aux = new int[] { secondsPastMidnight / 3600, (secondsPastMidnight % 3600) / 60, secondsPastMidnight % 60 };
            }

            if (hms[1].endsWith("PM") || hms[1].endsWith("AM")) {
                amPm = true;

                if (hms[1].contains("PM"))
                    addHours = 12;

                int suffex = hms[1].lastIndexOf(' ');
                if (suffex < 1) {
                    suffex = hms[1].lastIndexOf("AM");
                    if (suffex < 1) {
                        suffex = hms[1].lastIndexOf("PM");
                    }
                }
                hms[1] = hms[1].substring(0, suffex);
            }

            int h = Integer.parseInt(trim(hms[0]));
            if (amPm && h == 12)
                h = 0;
            hour = h + addHours;

            min = Integer.parseInt(trim(hms[1]));
            if (hms.length > 2) {
                sec = Integer.parseInt(trim(hms[2]));
            }

            aux = new int[] {hour, min, sec};
        } catch (Exception e) {
            aux = null;
        }
        return aux[0]*3600 + aux[1]*60 + aux[2];
    }

    public static String trim (String str) {
        String retVal = str;
        try {
            retVal = str.trim();
            retVal = retVal.replaceAll("%20;", "");
            retVal = retVal.replaceAll("%20", "");
        } catch (Exception ex) {
			ex.printStackTrace();
        }
        return retVal;
    }
    
    @SuppressWarnings("deprecation")
	public static String hour2String (Date d) {
    	int hours = d.getHours() ;
    	int minutes = d.getMinutes() ;
    	int seconds = d.getSeconds() ;
    	return  formatTime2String(hours) + ":" + formatTime2String(minutes) + ":" + formatTime2String(seconds);
    }
    
    private static String formatTime2String (int i) {
    	String res = "" ;
    	if (i < 10) {
    		res += "0" + i ;
    	} else {
    		res += i ;
    	}
    	return res ;
    }
 
}
