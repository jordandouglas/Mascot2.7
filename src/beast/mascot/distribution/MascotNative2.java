package beast.mascot.distribution;



import java.util.List;
import java.util.Random;

import org.jblas.DoubleMatrix;

import beast.core.Description;
import beast.core.Distribution;
import beast.core.State;
import beast.evolution.tree.TreeInterface;
import beast.mascot.dynamics.Dynamics;
import beast.mascot.ode.Euler2ndOrderNative;


/**
 * @author Nicola Felix Mueller
 */

@Description("Native Mascot implementation using JNI")
public class MascotNative2 extends Distribution {
	
	private int states, nodeCount, intervalCount;
	
	private double [] coalescentRatesCache;
	private double [] migrationRatesCache;
	private int [][] indicatorsCache;
	private double [] nextRateShiftCache;
	private int rateShiftCount;
	
	private double [] currentCoalescentRates;

    public MascotNative2(StructuredTreeIntervals treeIntervals, 
    		int [] nodeType, int states, double epsilon, double max_step
    		) {
    	TreeInterface tree = treeIntervals.treeInput.get();
    	treeIntervals.calculateIntervals();  
    	int sampleCount = treeIntervals.getSampleCount();
    	nodeCount = tree.getNodeCount();
    	intervalCount = treeIntervals.getIntervalCount();
    	setup(nodeType, states, epsilon, max_step, sampleCount, nodeCount, nodeCount);
    }
    
    native void setup(int [] nodeType, int states, double epsilon, double max_step, int sampleCount, int nodeCount, int intervalCount);

    native public double calculateLogP(boolean dynamicsIsDirty, int firstDirtyInterval, int[] lineagesAdded, 
    		int[] lineagesRemoved, double[] intervals, int[] parents);

	void setUpDynamics(Dynamics dynamics) {
    	rateShiftCount = dynamics.getEpochCount();
    	if (coalescentRatesCache == null) {
        	coalescentRatesCache = new double[rateShiftCount * states];
        	currentCoalescentRates = new double[states];
        	migrationRatesCache = new double[rateShiftCount * states * states];
        	if (dynamics.hasIndicators) {
        		indicatorsCache = new int[rateShiftCount][];
        	} else {
        		indicatorsCache = new int[1][];
        	}
    	}
    	for (int i = 0; i < rateShiftCount; i++) {
    		System.arraycopy(dynamics.getCoalescentRate(i), 0, coalescentRatesCache, i*states, states);
    		System.arraycopy(dynamics.getBackwardsMigration(i), 0, migrationRatesCache, i*states*states, states*states);
    	}
    	if (dynamics.hasIndicators) {
        	for (int i = 0; i < rateShiftCount; i++) {
        		indicatorsCache = new int[rateShiftCount][];
        	}
    	}
    	nextRateShiftCache = dynamics.getIntervals();
    	dynamics.setDynamicsKnown();
		setUpDynamics(coalescentRatesCache, migrationRatesCache, indicatorsCache, nextRateShiftCache);
	}

    
	native void setUpDynamics(double[] coalescentRatesCache2, double[] migrationRatesCache2, int[][] indicatorsCache2,
			double[] nextRateShiftCache2);


    public DoubleMatrix getStateProb(int nr){
    	DoubleMatrix p = new DoubleMatrix(states);
    	double [] stateProbabilities = new double[states];
    	getStateProb(nr, stateProbabilities);
    	for (int i = 0; i < states; i++) {
    		p.put(i, stateProbabilities[i]);
    	}
    	return p;
    }    
    
    native void getStateProb(int nr, double[] stateProbabilities2);

	public DoubleMatrix getRootState(){
    	return getStateProb(nodeCount - 1);
    }
    
    
    @Override
	public void store() {
    	storeState();
    }

	native void storeState();

	@Override
	public void restore(){    	
		restoreState();
    }

    native void restoreState();

	@Override
    protected boolean requiresRecalculation() {
        return true;
    }

	@Override
	public List<String> getArguments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getConditions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sample(State state, Random random) {
		// TODO Auto-generated method stub
		
	}

    
}
