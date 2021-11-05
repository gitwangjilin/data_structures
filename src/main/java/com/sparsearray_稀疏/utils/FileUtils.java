package com.sparsearray_稀疏.utils;

import java.io.*;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: FileUtils
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/10/18   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class FileUtils {
    public static void WriteStringToFile(String filePath) {
        try {
            File file = new File(filePath);
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println("https://www.jb51.net");// 往文件里写入字符串
            ps.append("https://www.jb51.net");// 在已有的基础上添加字符串
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void WriteStringToFile2(String filePath, String data) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data + "\n");
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void WriteStringToFile3(String filePath) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filePath));
            pw.println("abc ");
            pw.println("def ");
            pw.println("hef ");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] readTxtFile(String filePath) {
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                RandomAccessFile fileIndex = new RandomAccessFile(new File(filePath), "r");
                int count = 0;

                while (null != fileIndex.readLine()) {
                    count++;
                }

                fileIndex.close();
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt;
                int chessArr[][] = new int[count][3];
                int arr1= 0;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] s = lineTxt.split(" ");
                    chessArr[arr1][0]=Integer.parseInt(s[0]);
                    chessArr[arr1][1]=Integer.parseInt(s[1]);
                    chessArr[arr1][2]=Integer.parseInt(s[2]);
                    arr1++;
                }
                read.close();
                return chessArr;
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return null;
    }

    public static void WriteStringToFile4(String filePath) {
        try {
            RandomAccessFile rf = new RandomAccessFile(filePath, "rw");
            rf.writeBytes("op\r\n");
            rf.writeBytes("app\r\n");
            rf.writeBytes("hijklllll");
            rf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteStringToFile5(String filePath) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            String s = "https://www.jb51.netl";
            fos.write(s.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Chinadaas\\test\\luban-cloud-public\\data_structures\\sparsearray.txt";
//        String filePath = "C:\\Users\\Chinadaas\\test\\luban-cloud-public\\data_structures\\sparsearray1.txt";
        // new WriteStringToTxt().WriteStringToFile(filePath);
        // new WriteStringToTxt().WriteStringToFile2(filePath);
        // new WriteStringToTxt().WriteStringToFile3(filePath);
        // new WriteStringToTxt().WriteStringToFile4(filePath);
        WriteStringToFile5("C:\\Users\\Chinadaas\\test\\luban-cloud-public\\data_structures\\sparsearray5.txt");
        WriteStringToFile4("C:\\Users\\Chinadaas\\test\\luban-cloud-public\\data_structures\\sparsearray4.txt");
        WriteStringToFile3("C:\\Users\\Chinadaas\\test\\luban-cloud-public\\data_structures\\sparsearray3.txt");
//        WriteStringToFile2("C:\\Users\\Chinadaas\\test\\luban-cloud-public\\data_structures\\sparsearray2.txt");
        WriteStringToFile("C:\\Users\\Chinadaas\\test\\luban-cloud-public\\data_structures\\sparsearray1.txt");
    }
}

