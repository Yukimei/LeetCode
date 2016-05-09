package Google;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return clone(map, node);
	}

	private UndirectedGraphNode clone(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
		if (map.containsKey(node)) {
			return map.get(node);
		}
		UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
		map.put(node, cloned);
		for (UndirectedGraphNode nei : node.neighbors) {
			cloned.neighbors.add(clone(map, nei));
		}
		return cloned;
	}
}