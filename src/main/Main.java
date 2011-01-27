/**
 * 
 */
package main;

import operands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Raunak
 *
 */
public class Main {

	public static void generateRandomGraphs(int vertNum, int maxLenBy10, int capacity) {
		
		List<Integer> disconnectedVerts = new ArrayList<Integer>(vertNum);
		List<Integer> connectedVerts = new ArrayList<Integer>(vertNum);
		Random rnd = new Random();
		int n1, n2, len;
		writeToFile(vertNum+"");
		
		for (int i = 0; i < vertNum;i++) {
			 disconnectedVerts.add(i);
		}
		
		n1 = rnd.nextInt(disconnectedVerts.size());
		connectedVerts.add(disconnectedVerts.get(n1));
		n2 = rnd.nextInt(disconnectedVerts.size());
		connectedVerts.add(disconnectedVerts.get(n1));
		len = rnd.nextInt(maxLenBy10);
		
		writeToFile(n1 + " "+ n2+ " "+ len*10+" "+capacity);
		while (!disconnectedVerts.isEmpty()) {
			
		}
		
		for (int connProb = 1; connProb < 100; connProb++) {
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int popSize = 20; 	// no. of individuals 
		int indSize = 10;	// no. of IPIs
		int ipiSize = 4;	// no. of paths in an IPI
		double mutationProbability = 0.5;
		
		Generation initial = new Generation(popSize,indSize);
		for(int pc = 0; pc < popSize; pc++) {
				for (int ic = 0; ic < indSize; ic++) {
					initial.individualSet[pc].ipiSet[ic] = new IPI(ipiSize, ic);
				}
		}
	}

}
