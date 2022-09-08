package dp;

/**
 * @author zhangjie
 */
public class Trie {
  class TreeNode{
    boolean end;
    char val;
    TreeNode[]children;
    TreeNode(char val){
      this.val = val;
      this.children  = new TreeNode[26];
    }

  }
  private TreeNode root;
  public Trie() {
    root = new TreeNode('/');
  }

  public void insert(String word) {
    TreeNode p = root;
    for(int i = 0; i < word.length(); i++){
      int index= word.charAt(i)-'a';
      if(p.children[index]==null){
        p.children[index] = new TreeNode(word.charAt(i));
      }
      p = p.children[index];
    }
    p.end = true;
  }

  public boolean search(String word) {
    TreeNode p = root;
    for(int i = 0; i < word.length();i++){
      int index= word.charAt(i)-'a';
      if(p.children[index]==null){
        return false;
      }
      p = p.children[index];
    }
    return p.end;
  }

  public boolean startsWith(String prefix) {
    TreeNode p = root;
    for(int i = 0; i < prefix.length();i++){
      int index= prefix.charAt(i)-'a';
      if(p.children[index]==null){
        return false;
      }
      p = p.children[index];
    }
    return true;
  }
}
