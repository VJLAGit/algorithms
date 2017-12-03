package com.algo.tries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by arumugv on 6/8/17.
 */
public class TrieStroe {

    Node root = new Node();

   // Map<Node, Function<String, Integer>>

    class Node{
        int val;
        Map<String, Node> hshMap = new HashMap<String, Node>();

        Function<String, Integer> fn ;
        Node(int value){
            val = value;
        }

        Node(){
            val = 0;
        }

    }




    public boolean setToTree(String Path, int value){
        String[] pathArr = Path.split("/");
        Node curr = root;
        for(int i=0; i < pathArr.length; i++){
            if(!curr.hshMap.containsKey(pathArr[i])){
                return false;
            }
            curr = curr.hshMap.get(pathArr[i]);
            if(curr.fn != null){
               // curr.fn.apply(Path, new Integer(value));
            }
        }
        curr.val = value;
        return true;
    }


    public boolean addToTree(String Path, int value){
        String[] pathArr = Path.split("/");
        Node curr = root;
        for(int i=0; i < pathArr.length-1; i++){
            if(!curr.hshMap.containsKey(pathArr[i])){
                return false;
            }

            curr = curr.hshMap.get(pathArr[i]);

        }

        curr.hshMap.put(pathArr[pathArr.length-1], new Node(value));

        return true;
    }


    public int getFrmTree(String Path) throws Exception{
        String[] pathArr = Path.split("/");
        Node curr = root;
        for(int i=0; i < pathArr.length; i++){
            if(!curr.hshMap.containsKey(pathArr[i])){
                throw new Exception();
            }

            curr = curr.hshMap.get(pathArr[i]);

        }

        return curr.val;
    }


       public void watch(String path ,  Function<String, Integer> fn){

           String[] pathArr = path.split("/");
           Node curr = root;
           for(int i=0; i < pathArr.length; i++){
               if(!curr.hshMap.containsKey(pathArr[i])){
                   return;
               }
               curr = curr.hshMap.get(pathArr[i]);
           }
            curr.fn = fn;

       }



    public static void main(String[] args) throws Exception{

        TrieStroe store = new TrieStroe();

        store.addToTree("a", 1);

        store.addToTree("a/b", 2);



        store.setToTree("a/b", 4);
        store.setToTree("a", 3);


        System.out.println(store.addToTree("a/c/e", 11));

        System.out.println(store.getFrmTree("a/b"));

        System.out.println(store.getFrmTree("a"));

        System.out.println(store.getFrmTree("a/c/e"));

    }


}
