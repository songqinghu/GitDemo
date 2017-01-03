package com.git.books.a_lucene_java.aho_corasick.demo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class StringSearch {

    class TreeNode {
        public TreeNode(TreeNode parent, char c) {
            _char = c;
            _parent = parent;
            _results = new ArrayList<String>();
            _resultsAr = new String[0];

            _transitionsAr = new TreeNode[] {};
            _transHash = new Hashtable<Character, TreeNode>();
        }

        public void addResult(String result) {
            if (_results.contains(result))
                return;
            _results.add(result);
            _resultsAr = _results.toArray(new String[_results.size()]);
        }

        public void addTransition(TreeNode node) {
            _transHash.put(node._char, node);
            TreeNode[] ar = new TreeNode[_transHash.size()];
            Iterator<TreeNode> it = _transHash.values().iterator();
            for (int i = 0; i < ar.length; i++) {
                if (it.hasNext()) {
                    ar[i] = it.next();
                }
            }
            _transitionsAr = ar;
            //System.out.println("_transitionsAr.length:"+_transitionsAr.length);
        }

        public TreeNode getTransition(char c) {
            return _transHash.get(c);
        }

        public boolean containsTransition(char c) {
            return getTransition(c) != null;
        }

        private char _char;
        private TreeNode _parent;
        private TreeNode _failure;
        private ArrayList<String> _results;
        private TreeNode[] _transitionsAr;
        private String[] _resultsAr;
        private Hashtable<Character, TreeNode> _transHash;

        public char getChar() {
            return _char;
        }

        public TreeNode parent() {
            return _parent;
        }

        public TreeNode failure(TreeNode value) {
            _failure = value;
            return _failure;

        }

        public TreeNode[] transitions() {
            return _transitionsAr;
        }

        public String[] results() {
            return _resultsAr;
        }

    }

    private TreeNode _root;

    private String[] _keywords;

    public StringSearch(String[] keywords) {
        _keywords = keywords;
    }

    void buildTree() {
        _root = new TreeNode(null, ' ');

        for (String p : _keywords) {
            System.out.println("p:"+p);
            TreeNode nd = _root;
            
            for(char c : p.toCharArray()){
                //System.out.println("p[j]:");
    
                TreeNode ndNew = null;
                for (TreeNode trans : nd.transitions())
                    if (trans.getChar() == c) {
                        ndNew = trans;
                        break;
                    }

                if (ndNew == null) {
                    ndNew = new TreeNode(nd, c);
                    nd.addTransition(ndNew);
                }
                nd = ndNew;
            }
            nd.addResult(p);
        }

        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();

        for (TreeNode nd : _root.transitions()) {
            nd.failure(_root);
            for (TreeNode trans : nd.transitions())
                nodes.add(trans);
        }

        while (nodes.size() != 0) {
            ArrayList<TreeNode> newNodes = new ArrayList<TreeNode>();
            for (TreeNode nd : nodes) {
                TreeNode r = nd.parent()._failure;
                char c = nd.getChar();

                while (r != null && !r.containsTransition(c))
                    r = r._failure;
                if (r == null)
                    nd._failure = _root;
                else {
                    nd._failure = r.getTransition(c);
                    for(String result : nd._failure.results())
                        nd.addResult(result);
                }

                for (TreeNode child : nd.transitions())
                    newNodes.add(child);
            }
            nodes = newNodes;
        }
        _root._failure = _root;
    }

    public String[] getKeywords() {
        return _keywords;
    }

    public void setKeywords(String[] value) {
        _keywords = value;
        buildTree();
    }

    public StringSearchResult[] findAll(String text) {
        ArrayList<StringSearchResult> ret = new ArrayList<StringSearchResult>();
        TreeNode ptr = _root;
        int index = 0;

        while (index < text.length()) {
            //System.out.println("index:" + index);
            TreeNode trans = null;
            while (trans == null) {
                trans = ptr.getTransition(text.charAt(index));

                if (ptr == _root)
                    break;
                if (trans == null)
                    ptr = ptr._failure;
                //else
                //    System.out.println("trans:" + trans._char);
            }
            if (trans != null)
                ptr = trans;

            for (String found : ptr.results())
                ret.add(new StringSearchResult(index - found.length() + 1,
                        found));
            index++;
        }
        
        return ret.toArray(new StringSearchResult[ret.size()]);
    }

    public StringSearchResult findFirst(String text) {
        TreeNode ptr = _root;
        int index = 0;

        while (index < text.length()) {
            TreeNode trans = null;
            while (trans == null) {
                trans = ptr.getTransition(text.charAt(1));

                if (ptr == _root)
                    break;
                if (trans == null)
                    ptr = ptr._failure;
            }
            if (trans != null)
                ptr = trans;

            for (String found : ptr.results())
                return new StringSearchResult(index - found.length() + 1, found);
            index++;
        }
        return null;
    }

    public boolean containsAny(String text) {
        TreeNode ptr = _root;
        int index = 0;

        while (index < text.length()) {
            TreeNode trans = null;
            while (trans == null) {
                trans = ptr.getTransition(text.charAt(index));
                if (ptr == _root)
                    break;
                if (trans == null)
                    ptr = ptr._failure;
            }
            if (trans != null)
                ptr = trans;

            if (ptr.results().length > 0)
                return true;
            index++;
        }
        return false;
    }
}