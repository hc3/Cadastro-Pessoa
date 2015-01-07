package br.com.devmedia.jdbc.gui;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import br.com.devmedia.exception.NegocioException;
import br.com.devmedia.jdbc.bo.LoginBO;
import br.com.devmedia.jdbc.dto.LoginDTO;
import br.com.devmedia.jdbc.util.MensagensUtil;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class LoginFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -6268916686472381691L;
	private JButton btnSair;
	private JButton btnLogar;
	private JPanel panelLogin;
	private JTextField txtLogin;
	private JPasswordField passSenha;
	private JLabel lblSenha;
	private JLabel lblLogin;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginFrame inst = new LoginFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LoginFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				btnSair = new JButton();
				btnSair.setText("Sair");
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.exit(0);
					}
				});
			}
			{
				panelLogin = new JPanel();
				GroupLayout panelLoginLayout = new GroupLayout((JComponent)panelLogin);
				panelLogin.setLayout(panelLoginLayout);
				panelLogin.setBorder(BorderFactory.createTitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
				{
					lblLogin = new JLabel();
					lblLogin.setText("Login :");
					lblLogin.setFont(new java.awt.Font("Agency FB",0,20));
				}
				{
					lblSenha = new JLabel();
					lblSenha.setText("Senha :");
					lblSenha.setFont(new java.awt.Font("Agency FB",0,20));
				}
				{
					txtLogin = new JTextField();
				}
				{
					passSenha = new JPasswordField();
				}
				panelLoginLayout.setVerticalGroup(panelLoginLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(lblLogin, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(txtLogin, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(panelLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(lblSenha, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(passSenha, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(45, 45));
				panelLoginLayout.linkSize(SwingConstants.VERTICAL, new Component[] {lblLogin, lblSenha});
				panelLoginLayout.setHorizontalGroup(panelLoginLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLoginLayout.createParallelGroup()
					    .addComponent(lblSenha, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblLogin, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(panelLoginLayout.createParallelGroup()
					    .addComponent(txtLogin, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					    .addGroup(GroupLayout.Alignment.LEADING, panelLoginLayout.createSequentialGroup()
					        .addComponent(passSenha, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 116, Short.MAX_VALUE)))
					.addContainerGap(46, 46));
				panelLoginLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtLogin, passSenha});
				panelLoginLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblLogin, lblSenha});
			}
			{
				btnLogar = new JButton();
				btnLogar.setText("Login");
				btnLogar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						LoginDTO loginDTO = new LoginDTO();
						loginDTO.setNome(txtLogin.getText());
						loginDTO.setSenha(new String(passSenha.getPassword()));
						
						
						LoginBO loginBO = new LoginBO();
						try {
							if(loginBO.logar(loginDTO)){
								LoginFrame.this.dispose();
								MainFrame mainFrame = new MainFrame();
								mainFrame.setLocationRelativeTo(null);
								mainFrame.setVisible(true);
							}else {
								MensagensUtil.addMsg(LoginFrame.this, "Dados Invalidos");
							}
						} catch (NegocioException e) {
							e.printStackTrace();
							MensagensUtil.addMsg(LoginFrame.this, e.getMessage());
						}
					}
				});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 78, Short.MAX_VALUE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(btnLogar, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(btnSair, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(panelLogin, GroupLayout.Alignment.LEADING, 0, 355, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(202)
				        .addComponent(btnLogar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap(17, 17));
			thisLayout.linkSize(SwingConstants.VERTICAL, new Component[] {btnLogar, btnSair});
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnLogar, btnSair});
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
