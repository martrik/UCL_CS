from copy import deepcopy

class Node:
	def __init__(self, key):
		self.key = key
		self.parent = None
		self.left_child = None
		self.right_child = None

def insert(root, node):
	if root is None:
		root == node
	else:		
		if root.key <= node.key:
			if root.right_child == None:
				root.right_child = node
				node.parent = root		
			else:
				insert(root.right_child, node)
		else:
			if root.left_child == None:
				root.left_child = node
				node.parent = root	
			else:
				insert(root.left_child, node)

def create_tree_from_array(array):
	root = Node(array.pop(0))

	for key in array:
		node = Node(key)
		insert(root, node)
	
	return root

def pre_order_print(root):
    if not root:
        return        
    print(root.key)
    pre_order_print(root.left_child)
    pre_order_print(root.right_child)   

insertions = ["Paris", "Berlin", "Rome", "Oslo", "Athens", "Dublin", "Helsinki", "Luxembourg", "Vienna", "Warsaw"]
tree = create_tree_from_array(insertions)
pre_order_print(tree)
	 