package SubFunctionalities;

import Interfaces.DataEntity;
import SubFunctionalities.FunctionalPrompts.ConsolePrompts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

public class CommonFunctionalities {

    public static void writeData(FileWriter writer, DataEntity object) {
        String[] data = object.getData();
        try {
            writer.write(String.join(" ", data) + "\n");
        } catch (IOException e) {
            System.out.println(ConsolePrompts.RECORD_SAVE_ERROR);
        }
    }

    public static <T extends DataEntity> void loadData(String fileName, ArrayList<T> entities, Class<T> entityType){
        System.out.println("Called the load data method in the sub functionality class");
        try {
            File fileObject = new File(fileName);
            Scanner fileReader = new Scanner(fileObject);

            while(fileReader.hasNextLine()) {
                String[] splitLine = fileReader.nextLine().split(" ");
                T entity = entityType.getDeclaredConstructor().newInstance();
                entity.parseData(splitLine);
                entities.add(entity);

            }
        } catch (FileNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            System.out.println(ConsolePrompts.LOAD_ERROR);
        }
    }
}
