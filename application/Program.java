package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> count = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while(line != null) {
                String[] fields = line.split(",");
                String candidate = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                if(count.containsKey(candidate)) {
                    int quantityVotes = count.get(candidate);
                    count.put(candidate, votes + quantityVotes);
                }
                else {
                    count.put(candidate, votes);
                }
                line = br.readLine();
            }

            for(String candidate : count.keySet()) {
                System.out.println(candidate + ": " + count.get(candidate));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
