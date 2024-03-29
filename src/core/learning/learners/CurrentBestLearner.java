package core.learning.learners;

import aima.core.learning.framework.DataSet;
import aima.core.learning.framework.Example;
import aima.core.learning.framework.Learner;

/**
 * @author Ciaran O'Reilly
 * 
 */
public class CurrentBestLearner implements Learner {
	@Override
	public void train(DataSet ds) {

	}

	@Override
	public String predict(Example e) {
		return null;
	}

	@Override
	public int[] test(DataSet ds) {
		return new int[0];
	}
	/*private String trueGoalValue = null;
	private FOLDataSetDomain folDSDomain = null;
	private FOLKnowledgeBase kb = null;
	private Hypothesis currentBestHypothesis = null;

	//
	// PUBLIC METHODS
	//
	public CurrentBestLearner(String trueGoalValue) {
		this.trueGoalValue = trueGoalValue;
	}

	//
	// START-Learner
	public void train(DataSet ds) {
		folDSDomain = new FOLDataSetDomain(ds.specification, trueGoalValue);
		List<FOLExample> folExamples = new ArrayList<FOLExample>();
		int egNo = 1;
		for (Example e : ds.examples) {
			folExamples.add(new FOLExample(folDSDomain, e, egNo));
			egNo++;
		}

		// Setup a KB to be used for learning
		kb = new FOLKnowledgeBase(folDSDomain, new FOLOTTERLikeTheoremProver(
				1000, false));

		CurrentBestLearning cbl = new CurrentBestLearning(folDSDomain, kb);

		currentBestHypothesis = cbl.currentBestLearning(folExamples);
	}

	public String predict(Example e) {
		String prediction = "~" + e.targetValue();
		if (null != currentBestHypothesis) {
			FOLExample etp = new FOLExample(folDSDomain, e, 0);
			kb.clear();
			kb.tell(etp.getDescription());
			kb.tell(currentBestHypothesis.getHypothesis());
			InferenceResult ir = kb.ask(etp.getClassification());
			if (ir.isTrue()) {
				if (trueGoalValue.equals(e.targetValue())) {
					prediction = e.targetValue();
				}
			} else if (ir.isPossiblyFalse() || ir.isUnknownDueToTimeout()) {
				if (!trueGoalValue.equals(e.targetValue())) {
					prediction = e.targetValue();
				}
			}
		}

		return prediction;
	}

	public int[] test(DataSet ds) {
		int[] results = new int[] { 0, 0 };

		for (Example e : ds.examples) {
			if (e.targetValue().equals(predict(e))) {
				results[0] = results[0] + 1;
			} else {
				results[1] = results[1] + 1;
			}
		}
		return results;
	}
	// END-Learner
	//*/
}
