import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> Vtces;

	public Graph() {
		Vtces = new HashMap<>();
	}

	public int numVertex() {
		return this.Vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.Vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		Vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {
		Vertex vtx = Vtces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			Vertex nbrvtx = Vtces.get(key);//taking address of linked vertexes(B/D/C)
			//nbrvtx = 3k now;
			nbrvtx.nbrs.remove(vname);//3k.naughber.remove(key'B/D/C')
		}
		Vtces.remove(vname);
	}
	public void Display() {
		System.out.println("-----------------------");
		ArrayList<String> keys= new ArrayList<>(Vtces.keySet());
		for(String key:keys) {
			Vertex vtx = Vtces.get(key);
			System.out.println(key + " : "+ vtx.nbrs);
		}
		System.out.println("-----------------------");
	}

	public int numEdges() {
		int cout = 0;
		ArrayList<String> keys = new ArrayList<>(Vtces.keySet());
		for (String key : keys) {
			Vertex vtx = Vtces.get(key);
			cout = cout + vtx.nbrs.size();
		}
		return cout / 2;
	}

	public boolean containsEdges(String vname1, String vname2) {
		Vertex vtx1 = Vtces.get(vname1);
		Vertex vtx2 = Vtces.get(vname2);

		if (vtx2 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {
		Vertex vtx1 = Vtces.get(vname1);
		Vertex vtx2 = Vtces.get(vname2);

		if (vtx2 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {
		Vertex vtx1 = Vtces.get(vname1);
		Vertex vtx2 = Vtces.get(vname2);

		if (vtx2 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}
	public boolean hasPath(String vname1,String vname2,HashMap<String, Boolean> processed) {
		
		processed.put(vname1, true);
		
		if(containsEdges(vname1, vname2)) {
			return true;
		}
		Vertex vtx = Vtces.get(vname1);
		ArrayList<String> naughbers = new ArrayList<>(vtx.nbrs.keySet());
		for(String nbr:naughbers) {
			if(!processed.containsKey(nbr) && hasPath(nbr, vname2,processed)) {
				return true;
			}
		}
		return false;
	}
}
