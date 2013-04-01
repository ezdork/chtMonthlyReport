package promeritage.chtMonthlyReport.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import promeritage.chtMonthlyReport.bean.ProUser;
import promeritage.chtMonthlyReport.manager.CalendarManager;
import promeritage.chtMonthlyReport.util.CalendarUtil;
import promeritage.chtMonthlyReport.util.ConsoleUtil;
import promeritage.chtMonthlyReport.util.UserUtil;

import com.google.gdata.util.ServiceException;

public class CalendarController {
    public static void main(String[] args) throws IOException, ServiceException {
//        ProUser proUser = UserUtil.getUser();
//        Calendar c = Calendar.getInstance();
//        for (int i = 0; i < 31; i++) {
//            c.add(Calendar.DAY_OF_WEEK, 1);
//            switch (c.get(Calendar.DAY_OF_WEEK)) {
//            case Calendar.SUNDAY:
//            case Calendar.SATURDAY:
//                break;
//            default:
//                String startTime = CalendarUtil.getWorkStartDateTime(c);
//                String endTime = CalendarUtil.getWorkEndDateTime(c);
//                CalendarManager.createEvent(proUser.getWorkUrl(), "測試1", startTime, endTime);
//            }
//        }
//        CalendarManager.createEvent(proUser.getWorkUrl(), "測試1", "2012-11-02T09:00:00", "2012-11-02T18:00:00");
//        CalendarManager.createEvent(proUser.getWorkOverTimeUrl(), "測試1", "2012-11-02T18:00:00", "2012-11-02T22:00:00");
    }

    public static void createWorkEvents(String workContent, Calendar start, Calendar end) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String start_Str = sdf.format(start.getTime());
            String end_Str = sdf.format(end.getTime());
            ConsoleUtil.println("批次新增 "+start_Str+" ~ "+end_Str);
            Calendar cursor = Calendar.getInstance();
            cursor.setTime(start.getTime());
            int i = 0;
            while (cursor.compareTo(end) <= 0) {
                switch (cursor.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SUNDAY:
                case Calendar.SATURDAY:
                    break;
                default:
                    createWorkEvent(workContent, cursor);
                    i++;
                }
                cursor.add(Calendar.DAY_OF_MONTH, 1);
            }
            ConsoleUtil.println("批次新增成功 "+i +"筆");
        } catch (Exception e) {
            ConsoleUtil.println("新增 fail ");
            e.printStackTrace();
        }
    }

    public static void createWorkEvent(String workContent, Calendar calendar) {
        ProUser proUser = UserUtil.getUser();
        try {
            String startTime = CalendarUtil.getWorkStartDateTime(calendar);
            String endTime = CalendarUtil.getWorkEndDateTime(calendar);
            ConsoleUtil.println("新增 "+startTime+" ~ "+endTime);
            CalendarManager.createEvent(proUser.getWorkUrl(), workContent, startTime, endTime);
        } catch (Exception e) {
            ConsoleUtil.println("錯誤");
            e.printStackTrace();
        }
    }

    public static void createWorkOverTimeEvent(String workOverTimeContent, Calendar calendar) {
        ProUser proUser = UserUtil.getUser();
        try {
            String startTime = CalendarUtil.getWorkOverStartDateTime(calendar);
            String endTime = CalendarUtil.getWorkOverEndDateTime(calendar);
            CalendarManager.createEvent(proUser.getWorkOverTimeUrl(), workOverTimeContent, startTime, endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createLeaveWorkEvent(String leaveWorkContent, Calendar calendar) {
        if(leaveWorkContent == null){
            leaveWorkContent = "請假";
        }
        ProUser proUser = UserUtil.getUser();
        try {
            CalendarManager.createEvent(proUser.getLeaveWorkUrl(), leaveWorkContent, "2012-11-02T09:00:00", "2012-11-02T18:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
