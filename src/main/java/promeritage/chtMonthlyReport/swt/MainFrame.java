package promeritage.chtMonthlyReport.swt;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class MainFrame {

    public static void main(String[] args) throws IOException {
        Display display = Display.getDefault();
        Shell mainShell = new Shell(display);
        mainShell.setText("小予");
        mainShell.setLayout(new FillLayout());
        ScrolledComposite sp = new ScrolledComposite(mainShell, SWT.H_SCROLL | SWT.V_SCROLL);
        Label view = new Label(sp, SWT.CENTER);
        URL resURL = new URL("http://www.javaworld.com.tw/jute/upload/duncan/fish.jpg");
        InputStream in = null;
        try {
            in = resURL.openStream();
            view.setImage(new Image(display, in));
            view.pack();
            sp.setContent(view);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        mainShell.setSize(400, 500);
        mainShell.pack();

        Shell loginDialog = LoginFrame.createLoginDialog(display, mainShell);
        loginDialog.pack();
        loginDialog.open();
        while (!mainShell.isDisposed() || !loginDialog.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
