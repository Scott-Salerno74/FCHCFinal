package core.logic.fol.inference.proof;

import aima.core.logic.fol.kb.data.Literal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ciaran O'Reilly
 * 
 */
public class ProofStepFoChAlreadyAFact extends AbstractProofStep {
	//
	private static final List<ProofStep> _noPredecessors = new ArrayList<ProofStep>();
	//
	private Literal fact = null;

	public ProofStepFoChAlreadyAFact(Literal fact) {
		this.fact = fact;
	}

	//
	// START-ProofStep
	@Override
	public List<ProofStep> getPredecessorSteps() {
		return Collections.unmodifiableList(_noPredecessors);
	}

	@Override
	public String getProof() {
		return fact.toString();
	}

	@Override
	public String getJustification() {
		return "Already a known fact in the KB.";
	}
	// END-ProofStep
	//
}
