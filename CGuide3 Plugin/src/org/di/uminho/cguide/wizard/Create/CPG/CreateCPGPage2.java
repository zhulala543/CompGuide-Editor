package org.di.uminho.cguide.wizard.Create.CPG;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.AbstractOWLWizardPanel;

public class CreateCPGPage2 extends AbstractOWLWizardPanel {

	public static final String ID = "CreateCPGPage2";

	public static final String title = "Insert Scope Data Required";

	private JLabel condition_label;
	private JLabel added_label;

	private JTextArea condition_jtext;

	private JList list;
	public DefaultListModel<String> model;

	private JButton btnAdd;
	private JButton btnRemove;

	public CreateCPGPage2(OWLEditorKit owlEditorKit) {
		super(ID, title, owlEditorKit);
	}

	protected void createUI(JComponent parent) {
		setInstructions(
				"Please write the set of diseases/conditions where should be applied this Clinical Practice Guideline and click in the Add button.\nYou can also select an added content from the list and remove it.");

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 171, 233, 0 };
		gridBagLayout.rowHeights = new int[] { 31, 14, 150, 23, 29, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		parent.setLayout(gridBagLayout);

		added_label = new JLabel("Added:");
		GridBagConstraints gbc_lblAdded = new GridBagConstraints();
		gbc_lblAdded.anchor = GridBagConstraints.CENTER;
		gbc_lblAdded.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdded.gridx = 0;
		gbc_lblAdded.gridy = 1;
		parent.add(added_label, gbc_lblAdded);

		condition_label = new JLabel("Disease or Condition:");
		GridBagConstraints gbc_lblDiseaseOrCondition = new GridBagConstraints();
		gbc_lblDiseaseOrCondition.anchor = GridBagConstraints.CENTER;
		gbc_lblDiseaseOrCondition.insets = new Insets(0, 0, 5, 0);
		gbc_lblDiseaseOrCondition.gridx = 1;
		gbc_lblDiseaseOrCondition.gridy = 1;
		parent.add(condition_label, gbc_lblDiseaseOrCondition);

		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(getOWLEditorKit().getWorkspace().createOWLCellRenderer());
		list.setFixedCellHeight(20);
		list.setFixedCellWidth(100);

		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		parent.add(new JScrollPane(list), gbc_list);

		condition_jtext = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridheight = 3;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 2;
		parent.add(new JScrollPane(condition_jtext), gbc_textArea);

		btnAdd = new JButton(new AbstractAction("Add") {
			public void actionPerformed(ActionEvent e) {
				if (!condition_jtext.getText().isEmpty()) {
					model.addElement(condition_jtext.getText());
					list.setModel(model);
					condition_jtext.setText(null);
				}
			}
		});

		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.CENTER;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 3;
		parent.add(btnAdd, gbc_btnAdd);

		btnRemove = new JButton(new AbstractAction("Remove") {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() > -1) {
					model.remove(list.getSelectedIndex());
					list.setModel(model);
				}
			}
		});

		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.anchor = GridBagConstraints.CENTER;
		gbc_btnRemove.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemove.gridx = 0;
		gbc_btnRemove.gridy = 4;
		parent.add(btnRemove, gbc_btnRemove);

	}

	public Object getBackPanelDescriptor() {
		return CreateCPGPage1.ID;
	}

	public Object getNextPanelDescriptor() {
		return CreateCPGPage3.ID;
	}

}
