from heapq import heappush, heappop

class Node():
	def __init__(self, character):
		self.left_child = None
		self.right_child = None
		self.character = character

def create_heap(dic):
	heap = []

	for key, value in dic.items():
		heappush(heap, (value, Node(key)))

	return heap

def huffman(char_freq):
	heap = create_heap(char_freq)

	for _ in range(len(heap)-1):
		parent = Node(None)
		parent.left_child = heappop(heap)
		parent.right_child = heappop(heap)
		heappush(heap, (parent.left_child[0] + parent.right_child[0], parent))

	return heappop(heap)

def create_coding_trie(string):
	dic = {}

	for letter in string:
		if letter in dic:
			dic[letter] += 1
		else:
			dic[letter] = 1

	return huffman(dic)

root = create_coding_trie("Why are when and what used?")
print(root[0])