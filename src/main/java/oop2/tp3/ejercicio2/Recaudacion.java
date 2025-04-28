package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    //original:
    //    public static List<Map<String, String>> where(Map<String, String> options)
//            throws IOException {
//        List<String[]> csvData = new ArrayList<String[]>();
//        CSVReader reader = new CSVReader(new FileReader("src/main/resources/data.csv"));
//        String[] row = null;
//
//        while ((row = reader.readNext()) != null) {
//            csvData.add(row);
//        }
//
//        reader.close();
//        csvData.remove(0);
//
//        if (options.containsKey("company_name")) {
//            List<String[]> results = new ArrayList<String[]>();
//
//            for (int i = 0; i < csvData.size(); i++) {
//                if (csvData.get(i)[1].equals(options.get("company_name"))) {
//                    results.add(csvData.get(i));
//                }
//            }
//            csvData = results;
//        }
//
//        if (options.containsKey("city")) {
//            List<String[]> results = new ArrayList<String[]>();
//
//            for (int i = 0; i < csvData.size(); i++) {
//                if (csvData.get(i)[4].equals(options.get("city"))) {
//                    results.add(csvData.get(i));
//                }
//            }
//            csvData = results;
//        }
//
//        if (options.containsKey("state")) {
//            List<String[]> results = new ArrayList<String[]>();
//
//            for (int i = 0; i < csvData.size(); i++) {
//                if (csvData.get(i)[5].equals(options.get("state"))) {
//                    results.add(csvData.get(i));
//                }
//            }
//            csvData = results;
//        }
//
//        if (options.containsKey("round")) {
//            List<String[]> results = new ArrayList<String[]>();
//
//            for (int i = 0; i < csvData.size(); i++) {
//                if (csvData.get(i)[9].equals(options.get("round"))) {
//                    results.add(csvData.get(i));
//                }
//            }
//            csvData = results;
//        }
//
//        List<Map<String, String>> output = new ArrayList<Map<String, String>>();
//
//        for (int i = 0; i < csvData.size(); i++) {
//            Map<String, String> mapped = new HashMap<String, String>();
//            mapped.put("permalink", csvData.get(i)[0]);
//            mapped.put("company_name", csvData.get(i)[1]);
//            mapped.put("number_employees", csvData.get(i)[2]);
//            mapped.put("category", csvData.get(i)[3]);
//            mapped.put("city", csvData.get(i)[4]);
//            mapped.put("state", csvData.get(i)[5]);
//            mapped.put("funded_date", csvData.get(i)[6]);
//            mapped.put("raised_amount", csvData.get(i)[7]);
//            mapped.put("raised_currency", csvData.get(i)[8]);
//            mapped.put("round", csvData.get(i)[9]);
//            output.add(mapped);
//        }
//        return output;
//    }
    
    //refactorizado:
    public static List<Map<String, String>> where(Map<String, String> options, String filePath)
            throws IOException {
        List<String[]> csvData = new ArrayList<String[]>();
        CSVReader reader = null;
        try {
            reader = null;
            reader = new CSVReader(new FileReader(filePath));
            String[] row = null;
            while ((row = reader.readNext()) != null) {
                csvData.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            reader.close();
        }

        csvData.remove(0);

        if (options.containsKey("company_name")) { //1
            List<String[]> results = obtenerResultados(csvData, 1, options, "company_name");
            csvData = results;
        }

        if (options.containsKey("city")) { //4
            List<String[]> results = obtenerResultados(csvData, 4, options, "city");
            csvData = results;
        }

        if (options.containsKey("state")) { //5
            List<String[]> results = obtenerResultados(csvData, 5, options, "state");
            csvData = results;
        }

        if (options.containsKey("round")) { //9
            List<String[]> results = obtenerResultados(csvData, 9, options, "round");
            csvData = results;
        }

        List<Map<String, String>> output = new ArrayList<Map<String, String>>();
        for (String[] csvDatum : csvData) {
            Map<String, String> mapped = mapearDatos(csvDatum);
            output.add(mapped);
        }
        return output;
    }

    private static Map<String, String> mapearDatos(String[] csvDatum) {
        Map<String, String> mapped = new HashMap<String, String>();
        mapped.put("permalink", csvDatum[0]);
        mapped.put("company_name", csvDatum[1]);
        mapped.put("number_employees", csvDatum[2]);
        mapped.put("category", csvDatum[3]);
        mapped.put("city", csvDatum[4]);
        mapped.put("state", csvDatum[5]);
        mapped.put("funded_date", csvDatum[6]);
        mapped.put("raised_amount", csvDatum[7]);
        mapped.put("raised_currency", csvDatum[8]);
        mapped.put("round", csvDatum[9]);
        return mapped;
    }

    private static List<String[]> obtenerResultados(List<String[]> csvData, int x, Map<String, String> options, String key) {
        List<String[]> results = new ArrayList<String[]>();
        for (String[] csvDatum : csvData) {
            if (csvDatum[x].equals(options.get(key))) {
                results.add(csvDatum);
            }
        }
        return results;
    }
}
