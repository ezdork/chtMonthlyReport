package promeritage.chtMonthlyReport.swt;

import java.util.Calendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;

import promeritage.chtMonthlyReport.controller.CalendarController;
import promeritage.chtMonthlyReport.util.CalendarUtil;
import promeritage.chtMonthlyReport.util.ConsoleUtil;

public class RightCom002 extends Composite {

    private static Calendar c = Calendar.getInstance();

    /**
     * Create the composite
     * 
     * @param parent
     * @param style
     */
    public RightCom002(Composite parent, int style) {
        super(parent, style);
        setLayout(new FillLayout(SWT.VERTICAL));

        final DateTime startTime = new DateTime(this, SWT.CALENDAR | SWT.BORDER);
        startTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMinimum(Calendar.DAY_OF_MONTH));

        final DateTime endTime = new DateTime(this, SWT.CALENDAR | SWT.BORDER);
        endTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DAY_OF_MONTH));

        Composite composite = new Composite(this, SWT.NONE);
        composite.setLayout(new FillLayout(SWT.VERTICAL));

        Composite composite_1 = new Composite(composite, SWT.NONE);
        composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));

        Button btnNewButton = new Button(composite_1, SWT.NONE);
        btnNewButton.setText("<");

        Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
        btnNewButton_1.setText("當前月");

        Button btnNewButton_2 = new Button(composite_1, SWT.NONE);
        btnNewButton_2.setText(">");

        Button btngooglecalendar = new Button(composite, SWT.NONE);
        btngooglecalendar.setText("新增至Google Calendar");
        btngooglecalendar.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ConsoleUtil.println("新增至Google Calendar");
                Calendar start = CalendarUtil.toCalendar(startTime);
                Calendar end = CalendarUtil.toCalendar(endTime);
                CalendarController.createWorkEvents("sample", start, end);
            }
        });
        btnNewButton_2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                c.add(Calendar.MONTH, 1);
                startTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMinimum(Calendar.DAY_OF_MONTH));
                endTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DAY_OF_MONTH));
            }
        });
        btnNewButton_1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                c.setTime(Calendar.getInstance().getTime());
                startTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMinimum(Calendar.DAY_OF_MONTH));
                endTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DAY_OF_MONTH));
            }
        });
        btnNewButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                c.add(Calendar.MONTH, -1);
                startTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMinimum(Calendar.DAY_OF_MONTH));
                endTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DAY_OF_MONTH));
            }
        });

    }

    public static String getDateStr(DateTime d) {

        String year = String.valueOf(d.getYear());
        while (year.length() < 4) {
            year = "0" + year;
        }
        String month = String.valueOf(d.getMonth() + 1);
        while (month.length() < 2) {
            month = "0" + month;
        }
        String day = String.valueOf(d.getDay());
        while (day.length() < 2) {
            day = "0" + day;
        }
        return year + "-" + month + "-" + day;
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }
}
