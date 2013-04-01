package promeritage.chtMonthlyReport.util;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class ConsoleUtil {

    private static Text text;

    public static void createConsole(Composite parent, int style) {
        text = new Text(parent, style);
    }
    
    public static synchronized void println(String s) {
        text.append(s);
        text.append("\n");
    }

    public void setFocus() {
        text.setFocus();
    }
}