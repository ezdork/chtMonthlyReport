package promeritage.chtMonthlyReport.swt;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
/**
 * @author huangfox
 *  右面板，可以算是一个母版吧！
 *  主要是承载具体的功能面板，例如RightComA 、RightComB ....
 */
public class RightCom extends Composite {
    /**
     * Create the composite
     * @param parent
     * @param style
     */
    public RightCom(Composite parent, int style) {
        super(parent, style);
        this.setLayout(new FillLayout());
        //
    }
    
    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }
}

