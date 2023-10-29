import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

 class Trie{
    Map<Character, Trie> children;
    String key;
    boolean isLeaf;

    public Trie(){
        key = null;
        children = new TreeMap<>();
    }
}

public class Lab5{

    public static void insert(Trie root, String str){
        Trie temp = root;   //placeholder Trie

        for (char ch : str.toCharArray()){
            if (!temp.children.containsKey(ch)){
                temp.children.put(ch, new Trie());
            }
            temp  = temp.children.get(ch);
        }
        temp.key = str;
    }

    public static void trieToList(Trie root){
        Trie current = root;
        List<String> list = new ArrayList<>();

        if (current == null){
            return;
        }

        for (Map.Entry<Character, Trie> entry : current.children.entrySet()){
            Trie temp = entry.getValue();
            if (temp.key != null){
                list.add(temp.key);
            }

            trieToList(entry.getValue());
        }
    }

    public static void largest(Trie root){

    }
    public static void smallest(Trie root){

    }

    public static String search(Trie root, String st){
        
    }


    public int size(Trie root){
        int number = 0;
        if (root.isLeaf){
            number++;
        }
        for (int i = 0; i < 26; i++){
            if (root.children[i] != null ){
                number += size(root.children[i]);
            }
        }
        return number;
    }

    public int height(Trie node) {
        int h = 1;
        for (Trie child : node.childList) {
            h = Math.max(h, 1 + height(child));
        }
        return h;
    }
}
