package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String filename;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.filename = fileName;
    }


    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.writeObject(filename);
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(filename, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("c:/2022.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/2022-1.txt"));
        FileInputStream fileInputStream = new FileInputStream("c:/2022-1.txt");
        solution.writeObject("Test1");
        oos.writeObject(solution);
        oos.flush();


        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Solution loaded = (Solution) ois.readObject();
        loaded.writeObject("Ntcn2");
        System.out.println("end");
//        ObjectOutputStream oos = new ObjectOutputStream(solution.stream);
//        oos.writeObject(solution);
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/2022.txt"));
//        //Solution solution1 = (Solution) ois.readObject();
//        Solution solution1 = null;
//        solution1.readObject(ois);
//        solution1.writeObject("Тестовая строка2!!");
    }
}
