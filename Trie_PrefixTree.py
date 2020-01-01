class Node:
    def __init__(self):
        self.children=[None]*26
        self.isEnd=False
class Trie:
    def __init__(self):
        self.root=Node()
    def get_index(self,ch):
        return ord(ch)-ord('a')
    def insert(self,key):
        r=self.root
        for k in key:
            if r.children[self.get_index(k)]==None:
                r.children[self.get_index(k)]=Node()
            r = r.children[self.get_index(k)]
        r.isEnd=True
    def search(self,key):
        r=self.root
        for k in key:
            if r.children[self.get_index(k)] == None:
                return False
            else:
                r = r.children[self.get_index(k)]
        return r.isEnd


# Input keys (use only 'a' through 'z' and lower case)
keys = ["the", "a", "there", "anaswe", "any",
        "by", "their"]
output = ["Not present in trie",
          "Present in trie"]

# Trie object
t = Trie()

# Construct trie
for key in keys:
    t.insert(key)

    # Search for different keys
print("{} ---- {}".format("the", output[t.search("the")]))
print("{} ---- {}".format("these", output[t.search("these")]))
print("{} ---- {}".format("their", output[t.search("their")]))
print("{} ---- {}".format("thaw", output[t.search("thaw")]))


