package promeritage.chtMonthlyReport.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class RightCom001 extends Composite {
    private Text email;
    private Text password;
    private Text pmName;
    private Text pmEmail;
    private Text name;

    /**
     * Create the composite
     * 
     * @param parent
     * @param style
     */
    public RightCom001(Composite parent, int style) {
        super(parent, style);
        setLayout(new FillLayout(SWT.VERTICAL));

//        Properties properties = PropertiesUtil.loadProperties(UserUtil.POPERTIES_NAME);
        
        Group personal = new Group(this, SWT.BORDER);
        personal.setText("Personal 設定");
        personal.setLayout(createGridLayout());

        Label nameLabel = new Label(personal, SWT.NONE);
        nameLabel.setText("姓名");
        nameLabel.setLayoutData(createLGridData());
        name = new Text(personal, SWT.BORDER);
        name.setLayoutData(createTextGridData());

        Label emailLabel = new Label(personal, SWT.NONE);
        emailLabel.setText("email");
        emailLabel.setLayoutData(createLGridData());
        email = new Text(personal, SWT.BORDER);
        email.setLayoutData(createTextGridData());

        Label passwordLabel = new Label(personal, SWT.NONE);
        passwordLabel.setText("password");
        passwordLabel.setLayoutData(createLGridData());
        password = new Text(personal, SWT.BORDER);
        password.setLayoutData(createTextGridData());

        
        Group projectManager = new Group(this, SWT.NONE);
        projectManager.setText("PM 設定");
        projectManager.setLayout(createGridLayout());

        Label pmNameLabel = new Label(projectManager, SWT.NONE);
        pmNameLabel.setText("姓名");
        pmNameLabel.setLayoutData(createLGridData());
        pmName = new Text(projectManager, SWT.BORDER);
        pmName.setLayoutData(createTextGridData());

        Label pmEmailLabel = new Label(projectManager, SWT.NONE);
        pmEmailLabel.setText("email");
        pmEmailLabel.setLayoutData(createLGridData());
        pmEmail = new Text(projectManager, SWT.BORDER);
        pmEmail.setLayoutData(createTextGridData());
        
        Button btngooglecalendar = new Button(this, SWT.NONE);
        btngooglecalendar.setText("設定");
        //
    }

    private GridLayout createGridLayout(){
        return new GridLayout(5, true);
    }
    
    private GridData createLGridData() {
        return new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1);
    }

    private GridData createTextGridData() {
        return new GridData(SWT.FILL, SWT.CENTER, true, true, 4, 1);
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }
}
