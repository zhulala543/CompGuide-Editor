package org.di.uminho.cguide.wizard.Edit.Formula;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.ui.AbstractOWLWizardPanel;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

public class EditFormulaPage2 extends AbstractOWLWizardPanel {

	public static final String ID = "EditFormulaPage2";

	public static final String title = "Insert Formula Data Required";

	private JLabel formula_description_label;

	public JTextArea formula_description_jtext;

	public String mathematicalexpression = new String();

	public EditFormulaPage2(OWLEditorKit owlEditorKit, String formula_individual) {
		super(ID, title, owlEditorKit);
		getFormula(formula_individual);
	}

	protected void createUI(JComponent parent) {
		setInstructions("Please insert data required for the edition of the associated Formula.");

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		parent.setLayout(gbl_contentPane);

		formula_description_label = new JLabel("Formula Mathematical Expression:");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescription.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		parent.add(formula_description_label, gbc_lblDescription);

		formula_description_jtext = new JTextArea(3, 30);
		GridBagConstraints gbc_textArea1 = new GridBagConstraints();
		gbc_textArea1.fill = GridBagConstraints.BOTH;
		gbc_textArea1.gridx = 1;
		gbc_textArea1.gridy = 1;
		parent.add(new JScrollPane(formula_description_jtext), gbc_textArea1);
	}

	public Object getNextPanelDescriptor() {
		return EditFormulaPage3.ID;
	}

	@Override
	public void aboutToDisplayPanel() {
		formula_description_jtext.setText(this.mathematicalexpression);
		// TODO Auto-generated method stub
		super.aboutToDisplayPanel();
	}

	public void getFormula(String formula_individual_name) {
		OWLNamedIndividual formula_individual = getOWLModelManager().getOWLDataFactory().getOWLNamedIndividual(
				IRI.create(getOWLModelManager().getActiveOntology().getOntologyID().getOntologyIRI() + "#"
						+ formula_individual_name));

		try {
			OWLDataPropertyExpression mathematicalexpression_dataproperty = getOWLModelManager().getOWLDataFactory()
					.getOWLDataProperty(
							IRI.create(getOWLModelManager().getActiveOntology().getOntologyID().getOntologyIRI()
									+ "#mathematicalExpression"));
			Set<OWLLiteral> mathematicalexpression_literal = formula_individual.getDataPropertyValues(
					mathematicalexpression_dataproperty, getOWLModelManager().getActiveOntology());

			this.mathematicalexpression = mathematicalexpression_literal.iterator().next().getLiteral();
		} catch (Exception e) {
		}

	}

}
