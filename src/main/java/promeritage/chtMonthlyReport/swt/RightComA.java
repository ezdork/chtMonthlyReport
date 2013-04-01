package promeritage.chtMonthlyReport.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class RightComA extends Composite {
    /**
     * Create the composite
     * 
     * @param parent
     * @param style
     */
    public RightComA(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout());
        // setBackground(SWTResourceManager.getColor(255, 255, 230));
        final Label label = new Label(this, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        label.setText("功能A");
        // label.setBounds(10, 10, 480, 17);
        final TabFolder tabFolder = new TabFolder(this, SWT.NONE);
        tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        // tabFolder.setBounds(10, 36, 480, 329);
        final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
        tabItem.setText("子功能1");
        final TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
        tabItem_1.setText("子功能2");
        final TabItem tabItem_2 = new TabItem(tabFolder, SWT.NONE);
        tabItem_2.setText("子功能3");
        //
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }
}
