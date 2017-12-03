package com.algo;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by arumugv on 6/8/17.
 */
public class FileParser {


    class UserRate{
        int count;
        int sucess;
        int miss;
        String conn;


        UserRate(){
            count = 0;
            sucess = 0;
            miss = 0;

        }

        void setConn(String conn){
            conn = conn;
        }

        void addCount(){
            count = count + 1;
        }

        void addSucess(){
            sucess = sucess + 1;
        }

        void addFailure(){
            miss = miss + 1;
        }
    }

    public  void findHitRate(String path){

        List<String> list = null;

        Map<String, UserRate> rate = new HashMap<String, UserRate>();

        Map<String, String> connectionMap = new HashMap<String, String>();

        Map<String, Set<String>> connectionKQMap = new HashMap<String, Set<String>>();

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(path))) {


            list = stream
                    //.filter(line -> !line.startsWith("line3"))
                    // .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }


        for(String line : list){

            String[] words = line.split("\t");

            if(words[2].equals("get")){

                if(words[1].equals("req")){
                    String usrName = getName(words[4]);
                    if(!rate.containsKey(usrName)){
                        rate.put(usrName, new UserRate());

                    }
                    rate.get(usrName).addCount();
                    rate.get(usrName).setConn(words[0]);

                    connectionMap.put(words[0], usrName);


                }else if(words[1].equals("resp")){

                    if(words[3].equals("ok")){
                        rate.get(connectionMap.get(words[0])).addSucess();
                    }else {
                        rate.get(connectionMap.get(words[0])).addFailure();
                    }
                    connectionMap.remove(words[0]);
                }

            }else if(words[2].equals("getkq")){
                if(words[1].equals("req")){
                    String usrName = getName(words[4]);
                    if(!rate.containsKey(usrName)){
                        rate.put(usrName, new UserRate());

                    }
                    rate.get(usrName).addCount();
                    rate.get(usrName).setConn(words[0]);

                    if(!connectionKQMap.containsKey(words[0])){
                        connectionKQMap.put(words[0], new HashSet<String>());
                    }

                    connectionKQMap.get(words[0]).add(usrName);

                }else if(words[1].equals("resp")){
                    if(words[3].equals("ok")){
                        rate.get(getName(words[4])).addSucess();
                        connectionKQMap.get(words[0]).remove(getName(words[4]));
                    }


                }
            }

        }

        for(String conn : connectionKQMap.keySet()){
            Set<String> nameSET = connectionKQMap.get(conn);

            for(String name : nameSET){
                rate.get(name).addFailure();
            }
        }


        for (String usr : rate.keySet()) {
            System.out.println(usr + "->" + "count=" + rate.get(usr).count +
                    ", success=" + rate.get(usr).sucess +
                    "Rate=" + (rate.get(usr).sucess/rate.get(usr).count)*100);

        }


    }


    public static String getName(String input){
        if(StringUtils.isEmpty(input) || !input.contains("_")){
            return input;
        }

        String usrname[] = input.split("_");



    return usrname[0];
    }


    public static void main(String[] args){
        FileParser pr = new FileParser();
        pr.findHitRate("/Users/arumugv/Desktop/data/simple.dat");
    }
}