import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        String patternFor0 = " _ | ||_|";
        String patternFor1 = "     |  |";
        String patternFor2 = " _  _||_ ";
        String patternFor3 = " _  _| _|";
        String patternFor4 = "   |_|  |";
        String patternFor5 = " _ |_  _|";
        String patternFor6 = " _ |_ |_|";
        String patternFor7 = " _   |  |";
        String patternFor8 = " _ |_||_|";
        String patternFor9 = " _ |_| _|";
        String fileName = "C:\\Users\\gulak\\Desktop\\Bank1\\in.txt";

        PrintWriter out = new PrintWriter("C:\\Users\\gulak\\Desktop\\output.txt");


        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
            List<String> listOfLines = Files.lines(Paths.get(fileName)).collect(Collectors.toList());
            StringBuilder stringBuilder = new StringBuilder();



            for (int i = 0; i < listOfLines.size(); i=i+4) {
                int b = 0;
                List<String> first = asList(listOfLines.get(i).split(""));
                List<String> second = asList(listOfLines.get(i+1).split(""));
                List<String> third = asList(listOfLines.get(i+2).split(""));
                List<Long> listOfLongs = new ArrayList<>();


                int cc = 0;
                for (int z = 0; z <9; z++) {
                    for (int a = cc; a < cc + 3; a++) {
                        if (first.size() == 1){
                            stringBuilder.append(" ");
                        } else {
                            stringBuilder.append(first.get(a));
                        }
                    }
                    for (int a = cc; a < cc + 3; a++) {
                        if (second.size() == 1){
                            stringBuilder.append(" ");
                        } else {
                            stringBuilder.append(second.get(a));
                        }
                    }
                    for (int a = cc; a < cc + 3; a++) {
                        if (third.size() == 1){
                            stringBuilder.append(" ");
                        } else {
                            stringBuilder.append(third.get(a));
                        }
                    }

                    if (patternFor0.equals(stringBuilder.toString())){
                        listOfLongs.add(0L);
                        stringBuilder.setLength(0);
                    } else if (patternFor1.equals(stringBuilder.toString())){
                        listOfLongs.add(1L);
                        stringBuilder.setLength(0);
                    } else if (patternFor2.equals(stringBuilder.toString())){
                        listOfLongs.add(2L);
                        stringBuilder.setLength(0);
                    }else if (patternFor3.equals(stringBuilder.toString())){
                        listOfLongs.add(3L);
                        stringBuilder.setLength(0);
                    }else if (patternFor4.equals(stringBuilder.toString())){
                        listOfLongs.add(4L);
                        stringBuilder.setLength(0);
                    }else if (patternFor5.equals(stringBuilder.toString())){
                        listOfLongs.add(5L);
                        stringBuilder.setLength(0);
                    }else if (patternFor6.equals(stringBuilder.toString())){
                        listOfLongs.add(6L);
                        stringBuilder.setLength(0);
                    }else if (patternFor7.equals(stringBuilder.toString())){
                        listOfLongs.add(7L);
                        stringBuilder.setLength(0);
                    }else if (patternFor8.equals(stringBuilder.toString())){
                        listOfLongs.add(8L);
                        stringBuilder.setLength(0);
                    }else if (patternFor9.equals(stringBuilder.toString())){
                        listOfLongs.add(9L);
                        stringBuilder.setLength(0);
                    } else {
                        listOfLongs.add(404L);
                        stringBuilder.setLength(0);
                    }
                    cc = cc + 3;
                }

                StringBuilder lineTosave = new StringBuilder();

                Boolean hasInvalidSign = false;
                for (Long onNum : listOfLongs) {
                    String currentNum;
                    if (onNum == 404){
                        currentNum = "?";
                        hasInvalidSign = true;
                    } else {
                        currentNum = onNum.toString();
                    }
                    lineTosave.append(currentNum);
                    System.out.print(currentNum);
                }

                Long mod = null;
                if (!hasInvalidSign) {
                    mod = (listOfLongs.get(0) + 2 * listOfLongs.get(1) + 3 * listOfLongs.get(2) + 4 * listOfLongs.get(3) + 5 * listOfLongs.get(4) + 6 * listOfLongs.get(5) +
                            7 * listOfLongs.get(6) + 8 * listOfLongs.get(7) + 9 * listOfLongs.get(8)) % 11;
                }

                if (hasInvalidSign){
                    lineTosave.append(" ILL");
                    System.out.print(" ILL \n");
                } else if (mod != null && mod != 0){
                    System.out.print(" ERR \n");
                    lineTosave.append(" ERR");
                } else {
                    System.out.print("\n");
                }

                out.println(lineTosave);
            }

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}