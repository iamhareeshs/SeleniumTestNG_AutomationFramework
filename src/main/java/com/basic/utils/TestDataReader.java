package com.basic.utils;

import com.basic.constants.CommonPaths;
import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TestDataReader {
    private static final Logger LOGGER = LogManager.getLogger(TestDataReader.class);

    public static <T> Object[][] fetchTestData(String jsonData, Class<T> clazz) {
        List<T> dataObjects = getTestData(jsonData, clazz);
        Object[][] response = new Object[dataObjects.size()][1];
        populateTestData(response, dataObjects);
        return response;
    }

    public static <T> List<T> getTestData(String jsonData, Class<T> clazz) {
        JsonParser parser = new JsonParser();
        JsonArray array = null;
        try {
            array = (JsonArray) parser.parse(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<T> result = new ArrayList<>();
        T javaObject;
        assert array != null : "Couldn't fetch data from the json file, please check";
        Gson gson = new Gson();
        for (Object object : array) {
            JsonObject ob = (JsonObject) object;
            javaObject = gson.fromJson(ob, clazz);
            result.add(javaObject);
        }
        return result;
    }

    private static <T> void populateTestData(Object[][] response, List<T> dataObject) {
        int counter = 0;
        for (T data : dataObject) {
            response[counter++] = new Object[]{data};
        }
    }

    public static String fetchDataFromExcelSheet(String dataSheet) {
        String json = "";
        try {
            File file = new File(CommonPaths.TEST_DATA_PATH);
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(dataSheet);
            json = processTestDataSheet(sheet);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        json = "[  " + json + "    ]";
        return json;
    }

    public static String processTestDataSheet(Sheet sheet) {
        String testData = null;
        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = sheet.getRow(0);
        while (iterator.hasNext()) {
            Row row = iterator.next();
            if (row.getRowNum() > 0) {
                Iterator<Cell> cellIterator = row.cellIterator();
                HashMap<String, String> eachTestDataMap = new HashMap<>();
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    eachTestDataMap.put(firstRow.getCell(i).getStringCellValue(), cellIterator.next().getStringCellValue());
                }
                Gson gson = new GsonBuilder().create();
                String eachJsonData = gson.toJson(eachTestDataMap);
                testData = (testData == null) ? eachJsonData : (testData + "," + eachJsonData);
            }
        }
        return testData;
    }
}
