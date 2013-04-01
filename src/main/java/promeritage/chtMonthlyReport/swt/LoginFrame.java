package promeritage.chtMonthlyReport.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import promeritage.chtMonthlyReport.bean.ProUser;
import promeritage.chtMonthlyReport.util.CalendarUtil;
import promeritage.chtMonthlyReport.util.PropertiesUtil;
import promeritage.chtMonthlyReport.util.UserUtil;

import com.google.gdata.util.AuthenticationException;

public class LoginFrame {

    public static Shell createLoginDialog(Display display, final Shell successor) {
        final Shell shell = new Shell(display);
        shell.addShellListener(new ShellAdapter() {
            @Override
            public void shellClosed(ShellEvent e) {
                successor.dispose();
            }
        });
        shell.setText("Login");
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        Composite namepart = new Composite(shell, SWT.NONE);
        namepart.setLayout(new RowLayout());
        Label nameLabel = new Label(namepart, SWT.RIGHT);
        nameLabel.setText("Email:");
        final Text nameField = new Text(namepart, SWT.SINGLE);

        Composite passwordPart = new Composite(shell, SWT.None);
        passwordPart.setLayout(new RowLayout());
        Label passwordLabel = new Label(passwordPart, SWT.RIGHT);
        passwordLabel.setText("Password:");
        final Text passwordField = new Text(passwordPart, SWT.SINGLE | SWT.PASSWORD);

        Button button = new Button(shell, SWT.PUSH | SWT.RIGHT);
        button.setText("Submit");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (login(nameField.getText(), passwordField.getText())) {
                    successor.open();
                    shell.dispose();
                } else {
                    MessageBox box = new MessageBox(shell, SWT.ICON_ERROR | SWT.YES);
                    box.setText("Error");
                    box.setMessage("Login failed!!!");
                    box.open();
                }
            }
        });
        return shell;
    }

    public static boolean login(String email, String password) {

        ProUser proUser = new ProUser();
        proUser.setEmail(email.trim().replace("@promeritage.com.tw", "") + "@promeritage.com.tw");
        proUser.setPassword(password.trim());

        try {
            CalendarUtil.getService(proUser);
            PropertiesUtil.createConfigFile(PropertiesUtil.POPERTIES_NAME, proUser);
            UserUtil.setUser(proUser);
            return true;
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return false;
    }
}
