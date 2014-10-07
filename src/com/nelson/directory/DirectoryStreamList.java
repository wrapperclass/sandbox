package com.nelson.directory;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: tjnelson
 * Date: 7/27/12
 * Time: 2:38 PM
 */
public class DirectoryStreamList {

    public static void main(String... aArgs) {

        // FileSystem drives
//		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
//		for (Path name : dirs) {
//			System.out.println(name);
//		}

        Path startingDirectory = Paths.get("/opt/drps/pipeline/dept/CHD/assets");
        //Path startingDirectory = Paths.get("M:\\assets\\MS 24369");
        //Path startingDirectory = Paths.get("M:\\assets");
        Long start = System.currentTimeMillis();
        int counter = 0;
        List<String> collectionList = getCollectionList(startingDirectory);

        // for each collection get the items list.
//		for (String collection : collectionList) {
//			System.out.println(collection);
//		}

        // Test one collection from the list.
        Path path = Paths.get("/opt/drps/pipeline/dept/CHD/assets/MS 155");

        List<String> itemListIn = new ArrayList<>();
        List<String> itemsList = getItemsList(path, itemListIn);
        for (String item : itemsList) {
            System.out.println(item);
        }
    }

    /**
     * Will return a list of directories containing only files given the root path.
     *
     * @param itemPath Item Path
     * @return itemList List of items for given directory
     */
    private static List<String> getItemsList(Path itemPath, List<String> itemList) {

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(itemPath)) {

            for (Path path : stream) {
                if (path.toFile().isDirectory()) {
                    System.out.println(path.getFileName());
                    List<String> Items = getItemsList(path, itemList);
                    itemList.addAll(Items);
                }
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }

        Collections.sort(itemList);
        return itemList;
    }

    /**
     * Will return a list of the collections under the directory supplied.
     *
     * @param startingDirectory Collection Path
     * @return collectionList List of all Collection in the assets directory.
     */
    private static List<String> getCollectionList(Path startingDirectory) {

        List<String> collectionList = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(startingDirectory)) {
            for (Path path : stream) {
                collectionList.add(path.toString());
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
        return collectionList;
    }

}
