class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        size = len(edges)
        union = list(range(size+1))

        def find(parent: List[int], x: int):
            if parent[x] != x:
                parent[x] = find(parent, parent[x])
            return parent[x]

        def group(parent: List[int], x, y):
            root_x = find(parent, x)
            root_y = find(parent, y)
            if root_x != root_y:
                parent[y] = parent[x]

        result = []
        for edge in edges:
            parent_x = find(union, edge[0])
            parent_y = find(union, edge[1])
            if parent_x == parent_y:
                result = edge
            else:
                group(union, parent_x, parent_y)

        return result
