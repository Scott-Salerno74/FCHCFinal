package core.learning.inductive;

import aima.core.learning.framework.DataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ravi Mohan
 * 
 */
public class DLTestFactory {

	public List<DLTest> createDLTestsWithAttributeCount(DataSet ds, int i) {
		if (i != 1) {
			throw new RuntimeException(
					"For now DLTests with only 1 attribute can be craeted , not"
							+ i);
		}
		List<String> nonTargetAttributes = ds.getNonTargetAttributes();
		List<DLTest> tests = new ArrayList<DLTest>();
		for (String ntAttribute : nonTargetAttributes) {
			List<String> ntaValues = ds.getPossibleAttributeValues(ntAttribute);
			for (String ntaValue : ntaValues) {

				DLTest test = new DLTest();
				test.add(ntAttribute, ntaValue);
				tests.add(test);

			}
		}
		return tests;
	}
}
