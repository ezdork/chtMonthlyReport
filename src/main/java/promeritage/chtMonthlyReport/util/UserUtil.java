package promeritage.chtMonthlyReport.util;

import java.util.Properties;

import promeritage.chtMonthlyReport.bean.ProUser;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.util.AuthenticationException;

public class UserUtil {
    private static ProUser proUser = null;

    public static ProUser getUser() {
        if (proUser == null) {
            Properties properties = PropertiesUtil.loadOrCreateProperties(PropertiesUtil.POPERTIES_NAME);

            proUser = new ProUser();
            proUser.setEmail(PropertiesUtil.getConfig(properties, "email"));
            proUser.setPassword(PropertiesUtil.getConfig(properties, "password"));

            try {
                CalendarService service = CalendarUtil.getService(proUser);
                CalendarUtil.setCalendarUrls(service, proUser);
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
        }
        return proUser;
    }

    public static void setUser(ProUser proUser) {
        UserUtil.proUser = proUser;
    }
    
}
