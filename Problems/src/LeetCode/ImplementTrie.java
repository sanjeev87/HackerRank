package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {
	
	
	class TrieNode {
		Map<Character,TrieNode> map;
		String value;
		// Initialize your data structure here.
		public TrieNode() {
			map = new HashMap<Character, TrieNode>();
			value = null;
		}
	}

	public class Trie {
		private TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}

		public TrieNode traverse(String word, boolean canModify){
			TrieNode cur = root; 
			for(char c : word.toCharArray()){
				if(canModify){
					if(!cur.map.containsKey(c)){
						cur.map.put(c, new TrieNode());
					}
				}else{
					if(!cur.map.containsKey(c)){
						return null;
					}
				}
				cur = cur.map.get(c);
			}
			
			return cur;
		}
		
		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode node =  traverse(word,true);
			node.value = word;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode node =  traverse(word,false);
			return node != null && node.value != null && node.value.equals(word);
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode node =  traverse(prefix,false);
			return node != null;
		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
