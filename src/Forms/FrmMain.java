package Forms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import classs.BidiBulider;
import classs.ClipBoardController;
import classs.OnButtonClick;

@SuppressWarnings("serial")
public class FrmMain extends JFrame implements Action
{
	/**
	 * 
	 */
	public FrmMain()
	{
		initComponents();
	}

	private void initComponents()
	{
		jTextField1 = new JTextField();
		jButton1 = new JButton();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setFont(new Font("UKIJ Tuz Tom", 0, 20)); // NOI18N
		setName("كىرگۈزگۈچ");
		jButton1.setAction(this);
		jTextField1.setFont(new java.awt.Font("UKIJ Tuz Tor", 0, 20)); // NOI18N
		jTextField1.setHorizontalAlignment(JTextField.TRAILING);
		jButton1.setFont(new java.awt.Font("UKIJ Tuz Tom", 0, 20)); // NOI18N
		jButton1.setText("كۈچۈرۈش");
		this.setResizable(false);
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(
		        layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
		                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1).addGap(15, 15, 15)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(
		        layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                .addComponent(jButton1)));
		pack();
	}

	private JButton    jButton1;
	private JTextField jTextField1;

	public void ClearText()
	{
		jTextField1.setText("");
	}

	public String getTextValue()
	{
		return jTextField1.getText();
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String string = getTextValue();
		BidiBulider bulider = new BidiBulider();
		String rev = bulider.Build(string);
		ClipBoardController controller = new ClipBoardController();
		System.out.println("rev=" + rev);
		controller.SetClipText(rev);
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		FrmMain frmMain = new FrmMain();
		frmMain.show();
	}

	@Override
	public Object getValue(String key)
	{
		return null;
	}

	@Override
	public void putValue(String key, Object value)
	{
	}
}
