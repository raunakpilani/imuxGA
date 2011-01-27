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
		int n1Ind, n2Ind,n1,n2, len;
		writeToFile(vertNum+"");
		
		for (int i = 0; i < vertNum;i++) {
			 disconnectedVerts.add(i);
		}
		
		// initially read two random vertices from disconnVerts and add a link between them
		// first, get a random index of the node
		// next, add it to connVerts
		// finally, remove it from disconnVerts
		
		n1Ind = rnd.nextInt(disconnectedVerts.size());
		n1 = disconnectedVerts.get(n1Ind);
		connectedVerts.add(n1);
		disconnectedVerts.remove(n1Ind);
		
		n2Ind = rnd.nextInt(disconnectedVerts.size());
		n2 = disconnectedVerts.get(n2Ind);
		connectedVerts.add(n2);
		disconnectedVerts.remove(n2);
		
		// random length
		len = rnd.nextInt(maxLenBy10);
		
		writeToFile(n1 + " "+ n2+ " "+ len*10+" "+capacity);
		
		while (!disconnectedVerts.isEmpty()) {
			// make sure all nodes are connected
			// pick one node from the connVerts and other from disconnVerts
			// add edge
			
			n1Ind = rnd.nextInt(connectedVerts.size());
			n1 = connectedVerts.get(n1Ind);
			
			n2Ind = rnd.nextInt(disconnectedVerts.size());
			n2 = disconnectedVerts.get(n2Ind);
			connectedVerts.add(n2);
			disconnectedVerts.remove(n2);
			
			// random length
			len = rnd.nextInt(maxLenBy10);
			
			writeToFile(n1 + " "+ n2+ " "+ len*10+" "+capacity);
		}
		
		// add edges to the graph depending on a connection probability
		// connProb = 0 => graph already generated
		// connProb = 100 => complete graph
		// otherwise, a pair of nodes is considered only if they are not directly connected
		// random number in [0,1] is generated 
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

