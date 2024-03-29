package core.logic.fol;

import aima.core.logic.fol.parsing.FOLVisitor;
import aima.core.logic.fol.parsing.ast.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ravi Mohan
 * 
 */
public class PredicateCollector implements FOLVisitor {

	public PredicateCollector() {

	}

	@SuppressWarnings("unchecked")
	public List<Predicate> getPredicates(Sentence s) {
		return (List<Predicate>) s.accept(this, new ArrayList<Predicate>());
	}

	@SuppressWarnings("unchecked")
	public Object visitPredicate(Predicate p, Object arg) {
		List<Predicate> predicates = (List<Predicate>) arg;
		predicates.add(p);
		return predicates;
	}

	public Object visitTermEquality(TermEquality equality, Object arg) {
		return arg;
	}

	public Object visitVariable(Variable variable, Object arg) {
		return arg;
	}

	public Object visitConstant(Constant constant, Object arg) {
		return arg;
	}

	public Object visitFunction(Function function, Object arg) {
		return arg;
	}

	public Object visitNotSentence(NotSentence sentence, Object arg) {
		sentence.getNegated().accept(this, arg);
		return arg;
	}

	public Object visitConnectedSentence(ConnectedSentence sentence, Object arg) {
		sentence.getFirst().accept(this, arg);
		sentence.getSecond().accept(this, arg);
		return arg;
	}

	public Object visitQuantifiedSentence(QuantifiedSentence sentence,
			Object arg) {
		sentence.getQuantified().accept(this, arg);
		return arg;
	}
}