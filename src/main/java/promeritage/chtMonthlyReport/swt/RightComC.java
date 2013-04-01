package promeritage.chtMonthlyReport.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class RightComC extends Composite {
    /**
     * Create the composite
     * 
     * @param parent
     * @param style
     */
    public RightComC(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout());
        // setBackground(SWTResourceManager.getColor(225, 240, 255));
        final Label label = new Label(this, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        label.setText("功能C");
        final Browser browser = new Browser(this, SWT.NONE);
        browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        browser.setUrl("https://www.google.com/calendar/render?tab=mc");
        //
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }
}
