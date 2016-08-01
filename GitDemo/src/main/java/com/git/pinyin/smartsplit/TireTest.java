package com.git.pinyin.smartsplit;

public class TireTest {

    public static void main(String[] args) {  
        TrieTree tree = new TrieTree("meixin");  
        tree.insert("qin");
        tree.insert("shi");
        tree.insert("ming");
        tree.insert("yue");
        tree.insert("zhi");
        tree.insert("xia");
        tree.insert("jun");
        tree.insert("lin");
        tree.insert("ti");
        tree.insert("an");
        tree.insert("xian");
        
        //tree.insert("word");  
       // tree.insert("word");  
       // tree.insert("hello");  
      //  tree.insert("hi");  
       // System.out.println("word " + tree.searchFre("word"));  
      //  System.out.println("hello " + tree.searchFre("hello"));  
      //  System.out.println("hi " + tree.searchFre("hi"));  
       // System.out.println("hell " + tree.searchFre("hell"));  
      //  System.out.println("hellt " + tree.searchFre("hellt")); // qinshimingyuezhijunlintianxia 
        
        System.out.println(tree.splitSpell("qinshimingyuezhijunlintiantianxian"));
    }  
}
