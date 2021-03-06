package org.protege.editor.owl.ui.view.ontology;

import org.coode.owlapi.rdf.rdfxml.RDFXMLRenderer;
import org.semanticweb.owlapi.model.OWLOntology;

import java.io.Writer;


/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 20-Mar-2007<br><br>
 */
public class RDFXMLRenderingViewComponent extends AbstractOntologyRenderingViewComponent {

    /**
     * 
     */
    private static final long serialVersionUID = 5902721119543731047L;

    protected void renderOntology(OWLOntology ontology, Writer writer) throws Exception {
        RDFXMLRenderer renderer = new RDFXMLRenderer(getOWLModelManager().getOWLOntologyManager(),
                                                     getOWLModelManager().getActiveOntology(),
                                                     writer);
        renderer.render();
    }
}
