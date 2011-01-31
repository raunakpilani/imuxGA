/**
 * 
 */
package main;

import operands.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import alg.control.YenTopKShortestPathsAlg;
import alg.model.Graph;
import alg.model.Pair;
import alg.model.Vertex;
import alg.model.abstracts.BaseGraph;
import alg.model.abstracts.BaseVertex;

/**
 * @author Raunak
 * 
 */
public class Main {

	public static void generateRandomGraphs(int vertNum, int maxLenBy10,
			int capacity) {

		List<Integer> disconnectedVerts = new ArrayList<Integer>(vertNum);
		List<Integer> connectedVerts = new ArrayList<Integer>(vertNum);
		String edge, revEdge;
		HashMap<String, Integer> existingEdges = new HashMap<String, Integer>();
		Random rnd = new Random();
		int n1Ind, n2Ind, n1, n2, len, connProb = 50;
		double randomDouble;
		String fileName;
		String rootPath = new File("").getAbsolutePath();
		String sep = File.separator;

		// add edges to the graph depending on a connection probability
		// connProb = 0 => graph already generated
		// connProb = 100 => complete graph
		// otherwise, a pair of nodes is considered only if they are not
		// directly connected
		// random number in [0,1] is generated

		for (connProb = 1; connProb < 100; connProb++) {
			fileName = rootPath + sep + "data" + sep + "graph_" + connProb;
			System.out.println(fileName);
			File graphFile = new File(fileName);
			try {
				graphFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			if (!graphFile.exists()) {
				System.out.println("Not file exists!!");
				return;
			}

			FileWrite graphFileWriter = new FileWrite(fileName);
			graphFileWriter.write(vertNum + "");
			graphFileWriter.write("");

			connectedVerts.clear();
			disconnectedVerts.clear();
			existingEdges.clear();

			for (int i = 0; i < vertNum; i++) {
				disconnectedVerts.add(i);
			}

			// initially read two random vertices from disconnVerts and add a
			// link
			// between them
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
			disconnectedVerts.remove(n2Ind);

			// random length
			len = rnd.nextInt(maxLenBy10);
			len++;
			edge = n1 + "," + n2;
			existingEdges.put(edge, len);
			graphFileWriter.write(n1 + " " + n2 + " " + len * 10 + " "
					+ capacity);

			while (!disconnectedVerts.isEmpty()) {
				// make sure all nodes are connected
				// pick one node from the connVerts and other from disconnVerts
				// add edge

				n1Ind = rnd.nextInt(connectedVerts.size());
				n1 = connectedVerts.get(n1Ind);

				n2Ind = rnd.nextInt(disconnectedVerts.size());
				n2 = disconnectedVerts.get(n2Ind);
				connectedVerts.add(n2);
				disconnectedVerts.remove(n2Ind);

				// random length
				len = rnd.nextInt(maxLenBy10);
				len++;

				edge = n1 + "," + n2;
				existingEdges.put(edge, len);
				graphFileWriter.write(n1 + " " + n2 + " " + len * 10 + " "
						+ capacity);
			}

			double probDouble = connProb / 100.0;
			for (int i = 0; i < vertNum; i++) {
				for (int j = 1; j < vertNum; j++) {
					randomDouble = rnd.nextDouble();
					edge = i + "," + j;
					revEdge = j + "," + i;
					if (!existingEdges.containsKey(edge)
							&& !existingEdges.containsKey(revEdge)
							&& randomDouble < probDouble) {
						len = rnd.nextInt(maxLenBy10);
						len++;
						graphFileWriter.write(i + " " + j + " " + len * 10
								+ " " + capacity);
					}
				}
			}
			
			generateViableSet(fileName);
			graphFileWriter.close();
		}
	}

	public static void generateViableSet(String fileName) {
		String[] splitString = fileName.split("_");
		String folderName = splitString[1];
		folderName = "viableSets_"+folderName;
		
		try {
			File vsFolder = new File(folderName);
			vsFolder.mkdir();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if (!(new File(folderName).exists())) {
			System.out.println("Not Directory exists: "+folderName);
			return;
		}
		BaseGraph graph = new Graph(fileName);
		YenTopKShortestPathsAlg graphAlg = new YenTopKShortestPathsAlg(graph);
		
		FileRead graphFile = new FileRead(fileName);
		
		graphFile.readLine();
		graphFile.readLine();
		
		while(graphFile.isReady()) {
			String[] line = graphFile.readLine().split(" ");
			BaseVertex n1 = new Vertex();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int popSize = 20; // no. of individuals
		// int indSize = 10; // no. of IPIs
		// int ipiSize = 4; // no. of paths in an IPI
		// double mutationProbability = 0.5;

		generateRandomGraphs(20, 20, 40);
		// Generation initial = new Generation(popSize, indSize);
		// for (int pc = 0; pc < popSize; pc++) {
		// for (int ic = 0; ic < indSize; ic++) {
		// initial.individualSet[pc].ipiSet[ic] = new IPI(ipiSize, ic);
		// }
		// }
	}

}
