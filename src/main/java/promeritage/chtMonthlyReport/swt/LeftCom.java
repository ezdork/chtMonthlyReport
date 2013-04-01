package promeritage.chtMonthlyReport.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * @author huangfox 左面板 一般可以作成功能节点树
 */
public class LeftCom extends Composite {

    private String[] treeItems = new String[] { "帳號設定",
        "紀錄工作", "產月報表" };

    private Tree tree;

    /**
     * Create the composite
     * 
     * @param parent
     * @param style
     */
    public LeftCom(Composite parent, int style) {
        super(parent, style);
        this.setLayout(new FillLayout());

        // 定义一颗功能树
        tree = new Tree(this, SWT.BORDER);
        // tree.setBackground(SWTResourceManager.getColor(255, 232, 232));

        TreeItem ti = null;
        // 简单构造
        for (String tre : treeItems) {
            ti = new TreeItem(tree, SWT.NONE);
            ti.setText(tre);
        }
        // 默认展开，要在添加完子节点后设置，否则失效。
//        ti.setExpanded(true);

        // 点击功能树，控制右面板的展示
        tree.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // 获得点击的功能节点（treeItem）
                TreeItem selectedTI = (TreeItem) e.item;
                // 获得右面板
                RightCom right = MainApp.right;
                // 销毁之前面板的内容
                Control[] rightCs = right.getChildren();
                for (int i = 0; i < rightCs.length; i++) {
                    rightCs[i].dispose();
                }
                // 根据点击的功能节点展示右面板
                String selStr = selectedTI.getText();

                if (selStr.equalsIgnoreCase(treeItems[0])) {
                    // 新建右面板上的内容，其实也是一个面板（RightComA）！
                    new RightCom001(right, SWT.NONE);
                    right.layout();
                } else if (selStr.equalsIgnoreCase(treeItems[1])) {
                    new RightCom002(right, SWT.NONE);
                    right.layout();
                } else if (selStr.equalsIgnoreCase(treeItems[2])) {
                    new RightCom003(right, SWT.NONE);
                    right.layout();
                }
            }
        });

    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }
}
