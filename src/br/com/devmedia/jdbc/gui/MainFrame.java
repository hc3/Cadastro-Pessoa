package br.com.devmedia.jdbc.gui;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.devmedia.exception.NegocioException;
import br.com.devmedia.jdbc.bo.PessoaBO;
import br.com.devmedia.jdbc.bo.UfBO;
import br.com.devmedia.jdbc.dao.PessoaDAO;
import br.com.devmedia.jdbc.dto.EnderecoDTO;
import br.com.devmedia.jdbc.dto.PessoaDTO;
import br.com.devmedia.jdbc.dto.UfDTO;
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
public class MainFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5774393028011554129L;
	private JPanel panelCadastro;
	private JRadioButton rbtFemininoUpdate;
	private JLabel lblNomeUpdate;
	private JLabel lblCpfUpdate;
	private JLabel lblSexoUpdate;
	private JLabel lblDtNascUpdate;
	private JLabel lblUfUpdate;
	private JLabel lblLograUpdate;
	private JLabel lblBairroUpdate;
	private JLabel lblCidadeUpdate;
	private JLabel lblNumeroUpdate;
	private JLabel lblCepUpdate;
	private JTextField txtLograUpdate;
	private JTextField txtBairroUpdate;
	private JTextField txtCidadeUpdate;
	private JTextField txtNumeroUpdate;
	private JTextField txtCepUpdate;
	@SuppressWarnings("rawtypes")
	private JComboBox JComboUfUpdate;
	private JPanel panelEditarEndereco;
	private JTextField txtCep;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtLogradouro;
	private JLabel lblCep;
	private JLabel lblNumero;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JLabel lblLogradouro;
	private JPanel panelEnderecoCadastro;
	private JPanel panelPrincipalCadastro;
	@SuppressWarnings("rawtypes")
	private JComboBox comboUF;
	private JLabel lblIDUpdate;
	private JLabel lblIDCodigo;
	private ButtonGroup gprSexoUpdate;
	private JButton btnEditar;
	private JTextField txtNomeUpdate;
	private JTextField txtCpfUpdate;
	private JRadioButton rbtMasculinoUpdate;
	private JTextField txtDtNascUpdate;
	private JPanel panelUpdate;
	private JInternalFrame internalUpdate;
	private JButton btnDeleteAll;
	private ButtonGroup btgOrderBy;
	private JRadioButton rbtCpfOrder;
	private JRadioButton rbtNomeOrder;
	private JLabel lblOrderBy;
	private JScrollPane scrollListConsulta;
	private JTable tableListagemConsulta;
	private JPanel panelTabelaList;
	private JButton btnConsulta;
	private ButtonGroup grpSexoConsulta;
	private JRadioButton rbtFeminoConsulta;
	private JLabel lblSexoConsulta;
	private JRadioButton rbtMasculinoConsulta;
	private JTextField txtCpfConsulta;
	private JTextField txtNomeConsulta;
	private JLabel lblCpfConsulta;
	private JLabel lblNomeConsulta;
	private JPanel panelConsulta;
	private JScrollPane scrollListagem;
	private JTable tableListagem;
	private JButton btnLimpar;
	private JButton btnCadastrar;
	private JLabel lblDtNasciment;
	private JTextField txtDtNascimento;
	private ButtonGroup grpSexo;
	private JLabel lblSexo;
	private JRadioButton rbtFeminino;
	private JRadioButton rbtMasculino;
	private JLabel lblCpf;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JLabel lblNome;
	private JPanel panelListagem;
	private JTabbedPane mainTabbetPane;
	private List<Integer> idsPessoas = new ArrayList<>();
	
	//formater de datas
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private PessoaDTO pessoaDTO;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Cadastro de Pessoa");
			{
				mainTabbetPane = new JTabbedPane();
				{
					panelCadastro = new JPanel();
					GroupLayout panelCadastroLayout = new GroupLayout((JComponent)panelCadastro);
					panelCadastro.setLayout(panelCadastroLayout);
					mainTabbetPane.addTab("cadastro", null, panelCadastro, null);
					panelCadastroLayout.setVerticalGroup(panelCadastroLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelCadastroLayout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(getPanelPrincipalCadastro(), GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
						        .addGap(64, 64, GroupLayout.PREFERRED_SIZE))
						    .addComponent(getPanelEnderecoCadastro(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getBtnLimpar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getBtnCadastrar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap());
					panelCadastroLayout.setHorizontalGroup(panelCadastroLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getPanelPrincipalCadastro(), GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
						.addGap(23)
						.addGroup(panelCadastroLayout.createParallelGroup()
						    .addGroup(panelCadastroLayout.createSequentialGroup()
						        .addGap(0, 0, Short.MAX_VALUE)
						        .addComponent(getPanelEnderecoCadastro(), GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addGap(277)
						        .addComponent(getBtnLimpar(), GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 29, Short.MAX_VALUE)
						        .addComponent(getBtnCadastrar(), GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap());
					panelCadastroLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getBtnCadastrar(), getBtnLimpar()});
				}
				{
					panelListagem = new JPanel();
					GroupLayout panelListagemLayout = new GroupLayout((JComponent)panelListagem);
					panelListagem.setLayout(panelListagemLayout);
					mainTabbetPane.addTab("Listagem", null, panelListagem, null);
					panelListagem.setPreferredSize(new java.awt.Dimension(976, 356));
					mainTabbetPane.addTab("Consulta", null, getPanelConsulta(), null);
					panelListagemLayout.setHorizontalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelListagemLayout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, panelListagemLayout.createSequentialGroup()
						        .addComponent(getBtnDeleteAll(), GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 889, Short.MAX_VALUE))
						    .addComponent(getScrollListagem(), GroupLayout.Alignment.LEADING, 0, 1010, Short.MAX_VALUE)
						    .addComponent(getInternalUpdate(), GroupLayout.Alignment.LEADING, 0, 1010, Short.MAX_VALUE))
						.addContainerGap());
					panelListagemLayout.setVerticalGroup(panelListagemLayout.createSequentialGroup()
						.addGap(6)
						.addComponent(getBtnDeleteAll(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(getScrollListagem(), GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(getInternalUpdate(), 0, 269, Short.MAX_VALUE)
						.addContainerGap());
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbetPane, 0, 414, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbetPane, 0, 1039, Short.MAX_VALUE));
			pack();
			this.setSize(1067, 546);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getGrpSexo() {
		if(grpSexo == null) {
			grpSexo = new ButtonGroup();
		}
		return grpSexo;
	}
	
	private JTextField getJTextField1() {
		if(txtDtNascimento == null) {
			txtDtNascimento = new JTextField();
		}
		return txtDtNascimento;
	}
	
	private JLabel getLblDtNasciment() {
		if(lblDtNasciment == null) {
			lblDtNasciment = new JLabel();
			lblDtNasciment.setText("Dt. Nasc");
		}
		return lblDtNasciment;
	}
	
	private JButton getBtnCadastrar() {
		if(btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PessoaDTO pessoaDTO = new PessoaDTO();
					EnderecoDTO enderecoDTO = new EnderecoDTO();
					PessoaBO pessoaBO = new PessoaBO();
					try {
					
					String nome = txtNome.getText();	
					String cpf = txtCpf.getText();
					String nasc = txtDtNascimento.getText();
					
					pessoaBO.validaNome(nome);
					pessoaBO.validaCpf(cpf);
					pessoaBO.validaDtNascimento(nasc);
					pessoaDTO.setNome(nome);
					pessoaDTO.setCpf(Long.parseLong(cpf));
					pessoaDTO.setDtNascimento(dateFormat.parse(nasc));
					char sexo = rbtMasculino.isSelected() ? 'M' : 'F';
					pessoaDTO.setSexo(sexo);
					
					enderecoDTO.setLogradouro(txtLogradouro.getText());
					enderecoDTO.setBairro(txtBairro.getText());
					enderecoDTO.setCep(txtCep.getText().equals("") ? null : Integer.parseInt(txtCep.getText()));
					enderecoDTO.setCidade(txtCidade.getText());
					enderecoDTO.setNumero(txtNumero.getText().equals("") ? null : Long.parseLong(txtNumero.getText()));
					pessoaBO.validaEndereco(enderecoDTO);
					UfDTO ufDTO = new UfDTO();
					ufDTO.setIdUf(comboUF.getSelectedIndex() + 1);
					enderecoDTO.setUfDTO(ufDTO);
					
					pessoaDTO.setEnderecoDTO(enderecoDTO);
					pessoaBO.cadastrar(pessoaDTO);
					MensagensUtil.addMsg(MainFrame.this, "Cadastro realizado com sucesso!");
					MainFrame.this.dispose();
					main(null);
					} catch (Exception e) {
						e.printStackTrace();
						MensagensUtil.addMsg(MainFrame.this, e.getMessage());
					}
					

				}
			});
		}
		return btnCadastrar;
	}
	
	private JButton getBtnLimpar() {
		if(btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setText("Limpar");
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					
					txtNome.setText("");
					txtCpf.setText("");
					txtLogradouro.setText("");
					txtBairro.setText("");
					txtCidade.setText("");
					txtCep.setText("");
					txtNumero.setText("");
					//txtEndereco.setText("");
					txtDtNascimento.setText("");
					rbtMasculino.setSelected(true);
					
				}
			});
		}
		return btnLimpar;
	}
	
	private JTable getTableListagem() {
		final PessoaBO pessoaBO = new PessoaBO();
		try {
			String[][] lista = pessoaBO.listagem(idsPessoas);
			if(tableListagem == null) {
				tableListagem = new JTable();
			}
				TableModel tableListagemModel = 
						new DefaultTableModel(
								lista,
								new String[] {"Codigo","Nome", "CPF" , "Sexo" ,"DtNasc" , "Logradouro" , "CEP" , "UF" , "" , ""});
			
				tableListagem.setModel(tableListagemModel);	
			
			Action actionDelecao = new AbstractAction() {

				private static final long serialVersionUID = -7564502793807863092L;

				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					
					int resp = JOptionPane.showConfirmDialog(MainFrame.this, "Deseja realmente excluir essa pessoa?");
					if(resp == 0){
						JTable table = (JTable) actionEvent.getSource();
						
						int linha = Integer.parseInt(actionEvent.getActionCommand());
						((DefaultTableModel)table.getModel()).removeRow(linha);
						
						try {
							pessoaBO.removePessoa(idsPessoas.get(linha));
							idsPessoas.remove(linha);
							MensagensUtil.addMsg(MainFrame.this, "Pessoa removida com sucesso");
						} catch (NegocioException e) {
							MensagensUtil.addMsg(MainFrame.this, e.getMessage());	
						}
					}
					
				}
			};
			
			Action actionEdicao = new AbstractAction() {
			
				private static final long serialVersionUID = -2864899451899529939L;

				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					int linha = Integer.parseInt(actionEvent.getActionCommand());
					try {
						pessoaDTO = pessoaBO.buscaPorId(idsPessoas.get(linha));
						populaInternalUpdate(pessoaDTO);
						
					} catch (NegocioException e) {
						e.printStackTrace();
						MensagensUtil.addMsg(MainFrame.this, e.getMessage());
					}
				}
			};
			
			
			ButtonColumn buttonColumnEdicao = new ButtonColumn(tableListagem, actionEdicao, 8);
			ButtonColumn buttonColumnDelecao = new ButtonColumn(tableListagem, actionDelecao, 9);
			buttonColumnDelecao.setMnemonic(KeyEvent.VK_D);
			buttonColumnEdicao.setMnemonic(KeyEvent.VK_E);
			
		} catch (NegocioException e) {
			e.printStackTrace();
		}
		return tableListagem;
	}
	
	private void populaInternalUpdate(PessoaDTO pessoaDTO){
		this.lblIDUpdate.setText(pessoaDTO.getIdPessoa().toString());
		this.txtNomeUpdate.setText(pessoaDTO.getNome());
		this.txtCpfUpdate.setText(pessoaDTO.getCpf().toString());
		this.txtLograUpdate.setText(pessoaDTO.getEnderecoDTO().getLogradouro());
		this.txtBairroUpdate.setText(pessoaDTO.getEnderecoDTO().getBairro());
		this.txtCidadeUpdate.setText(pessoaDTO.getEnderecoDTO().getCidade());
		this.txtNumeroUpdate.setText(pessoaDTO.getEnderecoDTO().getNumero().toString());
		this.txtCepUpdate.setText(pessoaDTO.getEnderecoDTO().getCep().toString());
		this.txtDtNascUpdate.setText(dateFormat.format(pessoaDTO.getDtNascimento()));
		this.rbtMasculinoUpdate.setSelected(pessoaDTO.getSexo() == 'M');
		this.rbtFemininoUpdate.setSelected(pessoaDTO.getSexo() == 'F');
		this.internalUpdate.setVisible(true);
	}
	
	private JScrollPane getScrollListagem() {
		if(scrollListagem == null) {
			scrollListagem = new JScrollPane();
			scrollListagem.setViewportView(getTableListagem());
		}
		return scrollListagem;
	}
	
	private JPanel getPanelConsulta() {
		if(panelConsulta == null) {
			panelConsulta = new JPanel();
			GroupLayout panelConsultaLayout = new GroupLayout((JComponent)panelConsulta);
			panelConsulta.setLayout(panelConsultaLayout);
			panelConsultaLayout.setHorizontalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addComponent(getLblOrderBy(), GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				                .addGroup(panelConsultaLayout.createParallelGroup()
				                    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                        .addComponent(getRbtNomeOrder(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				                        .addComponent(getRbtCpfOrder(), GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
				                        .addGap(56))
				                    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                        .addPreferredGap(getRbtNomeOrder(), getTxtNomeConsulta(), LayoutStyle.ComponentPlacement.INDENT)
				                        .addComponent(getTxtNomeConsulta(), GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))))
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addGroup(panelConsultaLayout.createParallelGroup()
				                    .addComponent(getLblSexoConsulta(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(getLblNomeConsulta(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				                .addComponent(getRbtMasculinoConsulta(), GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addComponent(getRbtFemininoConsulta(), GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				                .addGap(7)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(getLblCpfConsulta(), GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
				        .addGroup(panelConsultaLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				                .addComponent(getBtnConsulta(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 24, Short.MAX_VALUE))
				            .addGroup(panelConsultaLayout.createSequentialGroup()
				                .addComponent(getTxtCpfConsulta(), GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE)))
				        .addGap(13))
				    .addComponent(getPanelTabelaList(), GroupLayout.Alignment.LEADING, 0, 437, Short.MAX_VALUE))
				.addContainerGap());
			panelConsultaLayout.setVerticalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getTxtCpfConsulta(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblNomeConsulta(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getTxtNomeConsulta(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblCpfConsulta(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getBtnConsulta(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblSexoConsulta(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRbtMasculinoConsulta(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRbtFemininoConsulta(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(panelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getRbtNomeOrder(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getRbtCpfOrder(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblOrderBy(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addComponent(getPanelTabelaList(), 0, 215, Short.MAX_VALUE)
				.addContainerGap());
		}
		return panelConsulta;
	}
	
	private JLabel getLblNomeConsulta() {
		if(lblNomeConsulta == null) {
			lblNomeConsulta = new JLabel();
			lblNomeConsulta.setText("Nome :");
		}
		return lblNomeConsulta;
	}
	
	private JLabel getLblCpfConsulta() {
		if(lblCpfConsulta == null) {
			lblCpfConsulta = new JLabel();
			lblCpfConsulta.setText("CPF :");
		}
		return lblCpfConsulta;
	}
	
	private JTextField getTxtNomeConsulta() {
		if(txtNomeConsulta == null) {
			txtNomeConsulta = new JTextField();
		}
		return txtNomeConsulta;
	}
	
	private JTextField getTxtCpfConsulta() {
		if(txtCpfConsulta == null) {
			txtCpfConsulta = new JTextField();
		}
		return txtCpfConsulta;
	}
	
	private JRadioButton getRbtFemininoConsulta() {
		if(rbtFeminoConsulta == null) {
			rbtFeminoConsulta = new JRadioButton();
			rbtFeminoConsulta.setText("Feminino");
			getGrpSexoConsulta().add(rbtFeminoConsulta);
		}
		return rbtFeminoConsulta;
	}
	
	private JRadioButton getRbtMasculinoConsulta() {
		if(rbtMasculinoConsulta == null) {
			rbtMasculinoConsulta = new JRadioButton();
			rbtMasculinoConsulta.setText("Masculino");
			rbtMasculinoConsulta.setSelected(true);
			getGrpSexoConsulta().add(rbtMasculinoConsulta);
		}
		return rbtMasculinoConsulta;
	}
	
	private JLabel getLblSexoConsulta() {
		if(lblSexoConsulta == null) {
			lblSexoConsulta = new JLabel();
			lblSexoConsulta.setText("Sexo :");
		}
		return lblSexoConsulta;
	}
	
	private ButtonGroup getGrpSexoConsulta() {
		if(grpSexoConsulta == null) {
			grpSexoConsulta = new ButtonGroup();
		}
		return grpSexoConsulta;
	}
	
	private JButton getBtnConsulta() {
		if(btnConsulta == null) {
			btnConsulta = new JButton();
			btnConsulta.setText("Consultar");
			btnConsulta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					getTableListagemConsulta();
				}
			});
		}
		return btnConsulta;
	}
	
	private JPanel getPanelTabelaList() {
		if(panelTabelaList == null) {
			panelTabelaList = new JPanel();
			GroupLayout panelTabelaListLayout = new GroupLayout((JComponent)panelTabelaList);
			panelTabelaList.setLayout(panelTabelaListLayout);
			panelTabelaList.setBorder(BorderFactory.createTitledBorder(null, "Listagem", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
			panelTabelaListLayout.setHorizontalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getScrollListConsulta(), 0, 668, Short.MAX_VALUE)
				.addContainerGap());
			panelTabelaListLayout.setVerticalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getScrollListConsulta(), 0, 168, Short.MAX_VALUE)
				.addContainerGap());
		}
		return panelTabelaList;
	}
	
	private JTable getTableListagemConsulta() {

		String nome = txtNomeConsulta.getText();
		Long cpf = txtCpfConsulta.getText() .equals("") ? null : Long.parseLong(txtCpfConsulta.getText());
		char sexo = rbtMasculinoConsulta.isSelected() ? 'M' : 'F';
		String orderBy = rbtNomeOrder.isSelected() ? "nome" : "cpf";
			
		if(tableListagemConsulta == null) {
				tableListagemConsulta = new JTable();
		}else {
		PessoaBO pessoaBO = new PessoaBO();
		
		
		try {
			String[][] lista = pessoaBO.listaConsulta(nome,cpf, sexo , orderBy);
			TableModel tableListagemConsultaModel = 
					new DefaultTableModel(
							lista,
							new String[] {"Codigo","Nome", "CPF" , "Logradouro" ,"Bairro","Cidade","Cep","Numero","UF" , "Sexo" ,"DtNasc"});
			
			tableListagemConsulta.setModel(tableListagemConsultaModel);
		} catch (Exception e) {
			e.printStackTrace();
			MensagensUtil.addMsg(MainFrame.this, e.getMessage());
		} 
		}
		return tableListagemConsulta;
	}
	
	private JScrollPane getScrollListConsulta() {
		if(scrollListConsulta == null) {
			scrollListConsulta = new JScrollPane();
			scrollListConsulta.setViewportView(getTableListagemConsulta());
		}
		return scrollListConsulta;
	}
	
	private JLabel getLblOrderBy() {
		if(lblOrderBy == null) {
			lblOrderBy = new JLabel();
			lblOrderBy.setText("Orderby");
		}
		return lblOrderBy;
	}
	
	private JRadioButton getRbtNomeOrder() {
		if(rbtNomeOrder == null) {
			rbtNomeOrder = new JRadioButton();
			rbtNomeOrder.setText("Nome ");
			getBtgOrderBy().add(rbtNomeOrder);
		}
		return rbtNomeOrder;
	}
	
	private JRadioButton getRbtCpfOrder() {
		if(rbtCpfOrder == null) {
			rbtCpfOrder = new JRadioButton();
			rbtCpfOrder.setText("Cpf");
			getBtgOrderBy().add(rbtCpfOrder);
		}
		return rbtCpfOrder;
	}
	
	private ButtonGroup getBtgOrderBy() {
		if(btgOrderBy == null) {
			btgOrderBy = new ButtonGroup();
		}
		return btgOrderBy;
	}
	
	private JButton getBtnDeleteAll() {
		if(btnDeleteAll == null) {
			btnDeleteAll = new JButton();
			btnDeleteAll.setText("Deletar tudo");
			btnDeleteAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PessoaBO pessoaBO = new PessoaBO();
					try {
						int resposta = JOptionPane.showConfirmDialog(MainFrame.this, "Deseja Realmente remover tudo?");
						if(resposta == 0){
							pessoaBO.removeTudo();
							MensagensUtil.addMsg(MainFrame.this, "Pessoas removidas com sucesso");
							getTableListagem();
						}
						
					} catch (NegocioException e) {
						e.printStackTrace();
					
					}
					
				}
			});
		}
		return btnDeleteAll;
	}
	
	private JInternalFrame getInternalUpdate() {
		if(internalUpdate == null) {
			internalUpdate = new JInternalFrame();
			GroupLayout internalUpdateLayout = new GroupLayout((JComponent)internalUpdate.getContentPane());
			internalUpdate.getContentPane().setLayout(internalUpdateLayout);
			internalUpdate.setVisible(true);
			internalUpdate.setBounds(12, 167, 1010, 269);
			internalUpdateLayout.setHorizontalGroup(internalUpdateLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getPanelUpdate(), 0, 971, Short.MAX_VALUE)
				.addContainerGap(25, 25));
			internalUpdateLayout.setVerticalGroup(internalUpdateLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getPanelUpdate(), 0, 206, Short.MAX_VALUE));
		}
		return internalUpdate;
	}
	
	private JPanel getPanelUpdate() {
		if(panelUpdate == null) {
			panelUpdate = new JPanel();
			GroupLayout panelUpdateLayout = new GroupLayout((JComponent)panelUpdate);
			panelUpdate.setLayout(panelUpdateLayout);
			panelUpdate.setBorder(BorderFactory.createTitledBorder("Edição de Pessoa"));
			panelUpdateLayout.setHorizontalGroup(panelUpdateLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelUpdateLayout.createParallelGroup()
				    .addComponent(getJLabel1(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel5(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel4(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblIDCodigo(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
				.addGroup(panelUpdateLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				        .addComponent(getJRadioButton2(), GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				        .addGap(112))
				    .addComponent(getJTextField1x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField3(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField4(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
				    .addGroup(panelUpdateLayout.createSequentialGroup()
				        .addGap(57)
				        .addGroup(panelUpdateLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				                .addComponent(getLblIDUpdate(), GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				                .addGap(51))
				            .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				                .addGap(23)
				                .addComponent(getJRadioButton1(), GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
				        .addGap(32)))
				.addGap(24)
				.addComponent(getPanelEditarEndereco(), GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
				.addGap(19)
				.addComponent(getBtnEditar(), 0, 112, Short.MAX_VALUE)
				.addContainerGap());
			panelUpdateLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJLabel5(), getJLabel4(), getJLabel2(), getJLabel1(), getLblIDCodigo()});
			panelUpdateLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getJTextField4(), getJTextField3(), getJTextField1x()});
			panelUpdateLayout.setVerticalGroup(panelUpdateLayout.createSequentialGroup()
				.addGroup(panelUpdateLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				        .addComponent(getLblIDUpdate(), GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getLblIDCodigo(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(getJTextField4(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel5(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(panelUpdateLayout.createParallelGroup()
				            .addComponent(getJTextField3(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				                .addGap(7)
				                .addComponent(getJLabel4(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(getJRadioButton1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJRadioButton2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(getJTextField1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addGap(30)
				        .addComponent(getBtnEditar(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 14, Short.MAX_VALUE))
				    .addComponent(getPanelEditarEndereco(), GroupLayout.Alignment.LEADING, 0, 216, Short.MAX_VALUE))
				.addContainerGap());
		}
		return panelUpdate;
	}
	
	private JTextField getJTextField1x() {
		if(txtDtNascUpdate == null) {
			txtDtNascUpdate = new JTextField();
		}
		return txtDtNascUpdate;
	}
	
	private JRadioButton getJRadioButton1() {
		if(rbtFemininoUpdate == null) {
			rbtFemininoUpdate = new JRadioButton();
			rbtFemininoUpdate.setText("Feminino");
			getGprSexoUpdate().add(rbtFemininoUpdate);
		}
		return rbtFemininoUpdate;
	}
	
	private JRadioButton getJRadioButton2() {
		if(rbtMasculinoUpdate == null) {
			rbtMasculinoUpdate = new JRadioButton();
			rbtMasculinoUpdate.setText("Masculino");
			getGprSexoUpdate().add(rbtMasculinoUpdate);
			rbtMasculinoUpdate.setSelected(true);
		}
		return rbtMasculinoUpdate;
	}

	private JTextField getJTextField3() {
		if(txtCpfUpdate == null) {
			txtCpfUpdate = new JTextField();
		}
		return txtCpfUpdate;
	}
	
	private JTextField getJTextField4() {
		if(txtNomeUpdate == null) {
			txtNomeUpdate = new JTextField();
		}
		return txtNomeUpdate;
	}
	
	private JLabel getJLabel1() {
		if(lblDtNascUpdate == null) {
			lblDtNascUpdate = new JLabel();
			lblDtNascUpdate.setText("Dt. Nasc :");
		}
		return lblDtNascUpdate;
	}
	
	private JLabel getJLabel2() {
		if(lblSexoUpdate == null) {
			lblSexoUpdate = new JLabel();
			lblSexoUpdate.setText("Sexo :");
		}
		return lblSexoUpdate;
	}

	private JLabel getJLabel4() {
		if(lblCpfUpdate == null) {
			lblCpfUpdate = new JLabel();
			lblCpfUpdate.setText("CPF :");
		}
		return lblCpfUpdate;
	}
	
	private JLabel getJLabel5() {
		if(lblNomeUpdate == null) {
			lblNomeUpdate = new JLabel();
			lblNomeUpdate.setText("Nome :");
		}
		return lblNomeUpdate;
	}
	
	private JButton getBtnEditar() {
		if(btnEditar == null) {
			btnEditar = new JButton();
			btnEditar.setText("Editar");
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PessoaDTO pessoaDTO = new PessoaDTO();
					PessoaDAO pessoaDAO = new PessoaDAO();
					EnderecoDTO enderecoDTO = new EnderecoDTO();
					PessoaBO pessoaBO = new PessoaBO();
					try {

						String nome = txtNomeUpdate.getText();	
						String cpf = txtCpfUpdate.getText();
						String nasc = txtDtNascUpdate.getText();

						pessoaBO.validaNome(nome);
						pessoaBO.validaCpf(cpf);
						pessoaBO.validaDtNascimento(nasc);
						pessoaDTO.setNome(nome);
						pessoaDTO.setCpf(Long.parseLong(cpf));
						pessoaDTO.setDtNascimento(dateFormat.parse(nasc));
						char sexo = rbtMasculinoUpdate.isSelected() ? 'M' : 'F';
						pessoaDTO.setSexo(sexo);
						
						enderecoDTO.setIdEndereco(getPessoaDTO().getEnderecoDTO().getIdEndereco());
						enderecoDTO.setLogradouro(txtLograUpdate.getText());
						enderecoDTO.setBairro(txtBairroUpdate.getText());
						enderecoDTO.setCep(txtCepUpdate.getText().equals("") ? null : Integer.parseInt(txtCepUpdate.getText()));
						enderecoDTO.setCidade(txtCidadeUpdate.getText());
						enderecoDTO.setNumero(txtNumeroUpdate.getText().equals("") ? null : Long.parseLong(txtNumeroUpdate.getText()));
						pessoaBO.validaEndereco(enderecoDTO);
						UfDTO ufDTO = new UfDTO();
						ufDTO.setIdUf(JComboUfUpdate.getSelectedIndex() + 1);
						enderecoDTO.setUfDTO(ufDTO);

						pessoaDTO.setEnderecoDTO(enderecoDTO);
						pessoaDTO.setIdPessoa(getPessoaDTO().getIdPessoa());
						pessoaDAO.atualizar(pessoaDTO);
						
						MensagensUtil.addMsg(MainFrame.this, "Pessoa Atualizada com sucesso!");
						getTableListagem();
					}catch(Exception e){
						e.printStackTrace();
						MensagensUtil.addMsg(MainFrame.this, e.getMessage());
					}
				}
			});
		}
		return btnEditar;
	}

	private ButtonGroup getGprSexoUpdate() {
		if(gprSexoUpdate == null) {
			gprSexoUpdate = new ButtonGroup();
		}
		return gprSexoUpdate;
	}
	
	private JLabel getLblIDCodigo() {
		if(lblIDCodigo == null) {
			lblIDCodigo = new JLabel();
			lblIDCodigo.setText("Codigo");
		}
		return lblIDCodigo;
	}
	
	private JLabel getLblIDUpdate() {
		if(lblIDUpdate == null) {
			lblIDUpdate = new JLabel();
		}
		return lblIDUpdate;
	}
	
	private String[] converteEstados(List<UfDTO> lista){
		String[] result = new String[lista.size()];
		for(int i = 0; i < lista.size(); i++){
			UfDTO ufDTO = lista.get(i);
			result[i] = ufDTO.getDescricao();
		}
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getComboUF() {
		if(comboUF == null) {
			try {
				UfBO ufBO = new UfBO();
				ComboBoxModel comboUFModel;
				comboUFModel = new DefaultComboBoxModel(converteEstados(ufBO.listaUf()));
				comboUF = new JComboBox();
				comboUF.setModel(comboUFModel);
			} catch (NegocioException e) {
				e.printStackTrace();
			}

		}
		return comboUF;
	}
	
	private JPanel getPanelPrincipalCadastro() {
		if(panelPrincipalCadastro == null) {
			panelPrincipalCadastro = new JPanel();
			GroupLayout panelPrincipalCadastroLayout = new GroupLayout((JComponent)panelPrincipalCadastro);
			panelPrincipalCadastro.setLayout(panelPrincipalCadastroLayout);
			panelPrincipalCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro Principal"));
			{
				lblNome = new JLabel();
				lblNome.setText("Nome :");
			}
			{
				txtNome = new JTextField();
			}
			{
				lblCpf = new JLabel();
				lblCpf.setText("CPF :");
			}
			{
				txtCpf = new JTextField();
			}
			{
				lblSexo = new JLabel();
				lblSexo.setText("Sexo :");
			}
			{
				rbtMasculino = new JRadioButton();
				rbtMasculino.setText("Masculino");
				rbtMasculino.setSelected(true);
				getGrpSexo().add(rbtMasculino);
			}
			{
				rbtFeminino = new JRadioButton();
				rbtFeminino.setText("Feminino");
				getGrpSexo().add(rbtFeminino);
			}
			panelPrincipalCadastroLayout.setHorizontalGroup(panelPrincipalCadastroLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup()
				    .addComponent(lblNome, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblCpf, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblSexo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblDtNasciment(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup()
				    .addGroup(panelPrincipalCadastroLayout.createSequentialGroup()
				        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(panelPrincipalCadastroLayout.createSequentialGroup()
				        .addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, panelPrincipalCadastroLayout.createSequentialGroup()
				        .addComponent(rbtMasculino, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(rbtFeminino, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 176, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, panelPrincipalCadastroLayout.createSequentialGroup()
				        .addComponent(getJTextField1(), GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap(75, 75));
			panelPrincipalCadastroLayout.setVerticalGroup(panelPrincipalCadastroLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(txtNome, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblNome, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(txtCpf, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblCpf, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(rbtMasculino, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblSexo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(rbtFeminino, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblDtNasciment(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(44, 44));
			panelPrincipalCadastroLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getJTextField1(), getLblDtNasciment(), lblSexo, rbtFeminino, rbtMasculino, txtCpf, txtNome, lblNome, lblCpf});
		}
		return panelPrincipalCadastro;
	}
	
	private JPanel getPanelEnderecoCadastro() {
		if(panelEnderecoCadastro == null) {
			panelEnderecoCadastro = new JPanel();
			GroupLayout panelEnderecoCadastroLayout = new GroupLayout((JComponent)panelEnderecoCadastro);
			panelEnderecoCadastro.setLayout(panelEnderecoCadastroLayout);
			panelEnderecoCadastro.setBorder(BorderFactory.createTitledBorder("Endereco"));
			panelEnderecoCadastroLayout.setHorizontalGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup()
				    .addComponent(getLblCep(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblNumero(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblCidade(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblBairro(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblLogradouro(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getTxtCep(), GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				        .addGap(29)
				        .addComponent(getComboUF(), GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getTxtNumero(), GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getTxtCidade(), GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getTxtBairro(), GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getTxtLogradouro(), GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(49, Short.MAX_VALUE));
			panelEnderecoCadastroLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getTxtCidade(), getTxtNumero()});
			panelEnderecoCadastroLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getLblLogradouro(), getLblBairro(), getLblCidade(), getLblNumero(), getLblCep()});
			panelEnderecoCadastroLayout.setVerticalGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getLblLogradouro(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getTxtLogradouro(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getLblBairro(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getTxtBairro(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getLblCidade(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getTxtCidade(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getLblNumero(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getTxtNumero(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getLblCep(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getTxtCep(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getComboUF(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(94, 94));
			panelEnderecoCadastroLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getLblLogradouro(), getTxtLogradouro(), getLblBairro(), getTxtBairro(), getLblCidade(), getTxtCidade(), getLblNumero(), getTxtNumero(), getLblCep(), getTxtCep()});
		}
		return panelEnderecoCadastro;
	}
	
	private JLabel getLblLogradouro() {
		if(lblLogradouro == null) {
			lblLogradouro = new JLabel();
			lblLogradouro.setText("Logradouro :");
		}
		return lblLogradouro;
	}
	
	private JLabel getLblBairro() {
		if(lblBairro == null) {
			lblBairro = new JLabel();
			lblBairro.setText("Bairro :");
		}
		return lblBairro;
	}
	
	private JLabel getLblCidade() {
		if(lblCidade == null) {
			lblCidade = new JLabel();
			lblCidade.setText("Cidade :");
		}
		return lblCidade;
	}
	
	private JLabel getLblNumero() {
		if(lblNumero == null) {
			lblNumero = new JLabel();
			lblNumero.setText("Numero :");
		}
		return lblNumero;
	}
	
	private JLabel getLblCep() {
		if(lblCep == null) {
			lblCep = new JLabel();
			lblCep.setText("Cep :");
		}
		return lblCep;
	}
	
	private JTextField getTxtLogradouro() {
		if(txtLogradouro == null) {
			txtLogradouro = new JTextField();
		}
		return txtLogradouro;
	}
	
	private JTextField getTxtBairro() {
		if(txtBairro == null) {
			txtBairro = new JTextField();
		}
		return txtBairro;
	}
	
	private JTextField getTxtCidade() {
		if(txtCidade == null) {
			txtCidade = new JTextField();
		}
		return txtCidade;
	}
	
	private JTextField getTxtNumero() {
		if(txtNumero == null) {
			txtNumero = new JTextField();
		}
		return txtNumero;
	}
	
	private JTextField getTxtCep() {
		if(txtCep == null) {
			txtCep = new JTextField();
		}
		return txtCep;
	}
	
	private JPanel getPanelEditarEndereco() {
		if(panelEditarEndereco == null) {
			panelEditarEndereco = new JPanel();
			GroupLayout panelEditarEnderecoLayout = new GroupLayout((JComponent)panelEditarEndereco);
			panelEditarEndereco.setLayout(panelEditarEnderecoLayout);
			panelEditarEndereco.setBorder(BorderFactory.createTitledBorder("Endereco"));
			panelEditarEnderecoLayout.setHorizontalGroup(panelEditarEnderecoLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelEditarEnderecoLayout.createParallelGroup()
				    .addComponent(getJLabel5x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel4x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel3(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(panelEditarEnderecoLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelEditarEnderecoLayout.createSequentialGroup()
				        .addComponent(getJTextField1xx(), GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(getLblUfUpdate(), GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getJComboUfUpdate(), GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, panelEditarEnderecoLayout.createSequentialGroup()
				        .addComponent(getJTextField2(), GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 20, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, panelEditarEnderecoLayout.createSequentialGroup()
				        .addComponent(getJTextField3x(), GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 20, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, panelEditarEnderecoLayout.createSequentialGroup()
				        .addComponent(getJTextField4x(), GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 20, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, panelEditarEnderecoLayout.createSequentialGroup()
				        .addComponent(getJTextField5(), GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 20, Short.MAX_VALUE)))
				.addContainerGap(54, 54));
			panelEditarEnderecoLayout.setVerticalGroup(panelEditarEnderecoLayout.createSequentialGroup()
				.addGroup(panelEditarEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField5(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel5x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelEditarEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField4x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel4x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelEditarEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField3x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel3(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelEditarEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelEditarEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJComboUfUpdate(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getLblUfUpdate(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(42, 42));
		}
		return panelEditarEndereco;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getJComboUfUpdate() {
		if(JComboUfUpdate == null) {
			try {
				UfBO ufBO = new UfBO();
				ComboBoxModel comboUFModel;
				comboUFModel = new DefaultComboBoxModel(converteEstados(ufBO.listaUf()));
				JComboUfUpdate = new JComboBox();
				JComboUfUpdate.setModel(comboUFModel);
			} catch (NegocioException e) {
				e.printStackTrace();
				MensagensUtil.addMsg(MainFrame.this, e.getMessage());
			}
		}
		return JComboUfUpdate;
	}
	
	private JTextField getJTextField1xx() {
		if(txtCepUpdate == null) {
			txtCepUpdate = new JTextField();
		}
		return txtCepUpdate;
	}
	
	private JTextField getJTextField2() {
		if(txtNumeroUpdate == null) {
			txtNumeroUpdate = new JTextField();
		}
		return txtNumeroUpdate;
	}
	
	private JTextField getJTextField3x() {
		if(txtCidadeUpdate == null) {
			txtCidadeUpdate = new JTextField();
		}
		return txtCidadeUpdate;
	}
	
	private JTextField getJTextField4x() {
		if(txtBairroUpdate == null) {
			txtBairroUpdate = new JTextField();
		}
		return txtBairroUpdate;
	}
	
	private JTextField getJTextField5() {
		if(txtLograUpdate == null) {
			txtLograUpdate = new JTextField();
		}
		return txtLograUpdate;
	}
	
	private JLabel getJLabel1x() {
		if(lblCepUpdate == null) {
			lblCepUpdate = new JLabel();
			lblCepUpdate.setText("Cep :");
		}
		return lblCepUpdate;
	}
	
	private JLabel getJLabel2x() {
		if(lblNumeroUpdate == null) {
			lblNumeroUpdate = new JLabel();
			lblNumeroUpdate.setText("Numero :");
		}
		return lblNumeroUpdate;
	}
	
	private JLabel getJLabel3() {
		if(lblCidadeUpdate == null) {
			lblCidadeUpdate = new JLabel();
			lblCidadeUpdate.setText("Cidade :");
		}
		return lblCidadeUpdate;
	}
	
	private JLabel getJLabel4x() {
		if(lblBairroUpdate == null) {
			lblBairroUpdate = new JLabel();
			lblBairroUpdate.setText("Bairro :");
		}
		return lblBairroUpdate;
	}
	
	private JLabel getJLabel5x() {
		if(lblLograUpdate == null) {
			lblLograUpdate = new JLabel();
			lblLograUpdate.setText("Logradouro :");
		}
		return lblLograUpdate;
	}
	
	private JLabel getLblUfUpdate() {
		if(lblUfUpdate == null) {
			lblUfUpdate = new JLabel();
			lblUfUpdate.setText("UF :");
		}
		return lblUfUpdate;
	}

	public PessoaDTO getPessoaDTO() {
		return pessoaDTO;
	}

}
