package promeritage.chtMonthlyReport.swt;

import java.util.Calendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import promeritage.chtMonthlyReport.controller.ReportController;
import promeritage.chtMonthlyReport.util.ConsoleUtil;
import promeritage.chtMonthlyReport.util.UserUtil;

public class RightCom003 extends Composite {

    private Text pmName;
    private Text name;

    private static Calendar c = Calendar.getInstance();

    /**
     * Create the composite
     * 
     * @param parent
     * @param style
     */
    public RightCom003(Composite parent, int style) {
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

	Composite composite_2 = new Composite(composite, SWT.NONE);
	composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));

	Button btngooglecalendar = new Button(composite_2, SWT.NONE);
	btngooglecalendar.setText("產出word檔");
	btngooglecalendar.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		try {
		    if (name.getText() != null) {
			UserUtil.getUser().setName(name.getText());
		    }

		    if (pmName.getText() != null) {
			UserUtil.getUser().setPmName(pmName.getText());
		    }

		    String startDateStr = getDateStr(startTime);
		    String endDateStr = getDateStr(endTime);
		    ConsoleUtil.println("產" + startDateStr + "至" + endDateStr + "報表");
		    ConsoleUtil.println("產報表1");
		    ReportController.genReport1(startDateStr, endDateStr);
		    ConsoleUtil.println("產報表2");
		    ReportController.genReport2(startDateStr, endDateStr);
		    ConsoleUtil.println("產表完成!!");
		} catch (Exception e1) {
		    e1.printStackTrace();
		    ConsoleUtil.println("產報表發生錯誤");
		}
	    }
	});
	btnNewButton_2.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		c.add(Calendar.MONTH, 1);
		startTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
		        c.getActualMinimum(Calendar.DAY_OF_MONTH));
		endTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DAY_OF_MONTH));
	    }
	});
	btnNewButton_1.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		c.setTime(Calendar.getInstance().getTime());
		startTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
		        c.getActualMinimum(Calendar.DAY_OF_MONTH));
		endTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DAY_OF_MONTH));
	    }
	});
	btnNewButton.addSelectionListener(new SelectionAdapter() {
	    @Override
	    public void widgetSelected(SelectionEvent e) {
		c.add(Calendar.MONTH, -1);
		startTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
		        c.getActualMinimum(Calendar.DAY_OF_MONTH));
		endTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DAY_OF_MONTH));
	    }
	});

	Composite composite_3 = new Composite(composite, SWT.NONE);
	composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));

	Label nameLabel = new Label(composite_3, SWT.NONE);
	nameLabel.setText("姓名");
	name = new Text(composite_3, SWT.BORDER);

	Label pmNameLabel = new Label(composite_3, SWT.NONE);
	pmNameLabel.setText("PM姓名");
	pmName = new Text(composite_3, SWT.BORDER);

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
