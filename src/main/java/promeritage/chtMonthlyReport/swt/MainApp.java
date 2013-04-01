package promeritage.chtMonthlyReport.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import promeritage.chtMonthlyReport.util.ConsoleUtil;

/**
 * @author Tim 主面板
 */
public class MainApp {
    private SashForm sashForm;
    private SashForm sashForm_1;
    protected Shell mainShell;
    // 左面板
    static LeftCom left;
    // 右面板
    static RightCom right;
    static Text console;

    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            MainApp window = new MainApp();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window
     */
    public void open() {
        final Display display = Display.getDefault();
        createContents();
//        mainShell.open();
//        mainShell.layout();
        Shell loginDialog = LoginFrame.createLoginDialog(display, mainShell);
        loginDialog.pack();
        loginDialog.open();
        while (!mainShell.isDisposed() || !loginDialog.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    /**
     * Create contents of the window
     */
    protected void createContents() {
        mainShell = new Shell();
        mainShell.setSize(800, 600);
        mainShell.setText("普瑞德in中華電信tool");
        // 布局
        FillLayout insLO = new FillLayout();
        this.mainShell.setLayout(insLO);

        sashForm = new SashForm(mainShell, SWT.VERTICAL);
        sashForm_1 = new SashForm(sashForm, SWT.NONE);

        left = new LeftCom(sashForm_1, SWT.BORDER);
        right = new RightCom(sashForm_1, SWT.BORDER);
        sashForm_1.setWeights(new int[] { 2, 8 });

        ConsoleUtil.createConsole(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.READ_ONLY);
        sashForm.setWeights(new int[] { 8, 2 });

    }
}
