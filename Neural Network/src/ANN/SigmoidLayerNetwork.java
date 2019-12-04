/**
 * 
 */
package ANN;

import java.util.ArrayList;

/**
 * 
 * This is a class for a layer of neurons with sigmoidal activation All such
 * neurons share the same inputs.
 */
public class SigmoidLayerNetwork extends LinearLayerNetwork {

	/**
	 * Constructor for neuron
	 * 
	 * @param numIns  how many inputs there are 
	 * @param numOuts how many outputs there are 
	 * @param data    the data set used to train the network
	 */
	public SigmoidLayerNetwork(int numIns, int numOuts, DataSet data) {
		super(numIns, numOuts, data);
	}

	/**
	 * calcOutputs of neuron
	 * 
	 * @param nInputs
	 */
	protected void calcOutputs(ArrayList<Double> nInputs) {
		// calcOutputs from LinearLayerNetwork function to get the weighted sum of
		// inputs
		super.calcOutputs(nInputs);

		// for each neuron within the layer, set output = sigmoid(output)
		for (int i = 0; i < outputs.size(); i++) {
			// Calculates the sigmoid for each neuron.
			outputs.set(i, 1 / (1 + Math.exp(-outputs.get(i))));

		}
	}

	/**
	 * find deltas
	 * 
	 * @param errors
	 */
	protected void findDeltas(ArrayList<Double> errors) {
		for (int i = 0; i < outputs.size(); i++) {// a for loop to go through all errors

			deltas.set(i, errors.get(i) * outputs.get(i) * (1 - outputs.get(i)));// setting each error as the same
																					// position as its delta
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test with and or xor
		DataSet AndOrXor = new DataSet("2 3 %.0f %.0f %.3f;x1 x2 AND OR XOR;0 0 0 0 0;0 1 0 1 1;1 0 0 1 1;1 1 1 1 0");
		SigmoidLayerNetwork SN = new SigmoidLayerNetwork(2, 3, AndOrXor);
		SN.setWeights("0.2 0.5 0.3 0.3 0.5 0.1 0.4 0.1 0.2");
		SN.doInitialise();
		System.out.println(SN.doPresent());
		System.out.println("Weights " + SN.getWeights());
		System.out.println(SN.doLearn(1000, 0.15, 0.4));
		System.out.println(SN.doPresent());
		System.out.println("Weights " + SN.getWeights());

	}

}
