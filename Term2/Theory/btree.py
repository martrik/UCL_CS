import random
from copy import deepcopy

class Key():
	def __init__(self, value):
		self.value = value

class Page():
	def __init__(self):
		self.keys = []
		self.children = []
		self.parent = None

	def print_keys(self):
		string = ""
		for key in self.keys:
			string += str(key.value) + " "
		
		print(string)

	def len(self):
		return len(self.keys)

	def index_in_parent(self):
		return self.parent.children.index(self)

	def is_leaf(self):
		return len(self.children) == 0

	def middle_key_index(self):
		return len(self.keys)//2

	def middle_key(self):
		return self.keys.pop(self.middle_key_index())

	def child_dest_index(self, key):
		for index, page_key in enumerate(self.keys):
			if key.value < page_key.value:
				return index
				
		return len(self.keys)

	def add_key(self, new_key, index=None):
		if index is not None:
			self.keys.insert(index, new_key)
		else:
			self.keys.append(new_key)

			# Sort keys in ascending order
			self.keys.sort(key=lambda x: x.value)

	def add_child(self, keys, index):
		new_child = Page()
		new_child.keys = keys
		new_child.parent = self

		self.children.insert(index, new_child)

		return new_child


class BTree():
	def __init__(self, order):
		self.order = order
		self.max_keys = order*2
		self.root = None

	def create_root(self, key):
		self.root = Page()
		self.root.add_key(key)
		return self.root

	def set_new_parent(self, parent, children):
		for child in children:
			child.parent = parent

	def tidy_page(self, page):
		if page.len() > self.max_keys:
			middle_index = page.middle_key_index()

			if page == self.root:
				new_root = self.create_root(page.middle_key())
				l_child, = new_root.add_child(page.keys[0:middle_index], 0)
				r_child = new_root.add_child(page.keys[middle_index:page.len()], 1)

				# Update children
				if page.is_leaf() == False:
					l_child.children = page.children[0:self.max_keys//2+1]
					self.set_new_parent(l_child, l_child.children)
					r_child.children = page.children[self.max_keys//2+1:len(page.children)]
					self.set_new_parent(r_child, r_child.children)
			else:
				index = page.index_in_parent()
				page.parent.add_key(page.middle_key(), index)

				# Split page
				page.parent.add_child(page.keys[middle_index:page.len()], index+1)
				del page.keys[middle_index:page.len()]
				self.tidy_page(page.parent)

	def insert_key(self, page, key):
		if not self.root:			
			self.create_root(key)
			return

		# In B-trees insertions only take place in leafs
		if page.is_leaf():
			page.add_key(key)
			self.tidy_page(page)
		else:
			self.insert_key(page.children[page.child_dest_index(key)], key)

	# Print tree in pre-order
	def print_tree(self, page):
		if len(page.children) == 0:
			page.print_keys()
			return

		page.print_keys()
		for child in page.children:
			self.print_tree(child)


tree = BTree(2)

for i in range(100):
	tree.insert_key(tree.root, Key(random.randint(1, 1000)))
tree.print_tree(tree.root)
print("___")
