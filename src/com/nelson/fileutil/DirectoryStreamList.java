package com.nelson.fileutil;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
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

        //Path startingDirectory = Paths.get("C:\\data\\dept\\CHD\\assets");
        //Path startingDirectory = Paths.get("M:\\assets\\MS 24369");
        //Path startingDirectory = Paths.get("U:\\assets");
        Path startingDirectory = Paths.get("K:\\CHD\\assets");

        Long start = System.currentTimeMillis();
        List<String> collectionList = getCollectionList(startingDirectory);

        long end = System.currentTimeMillis();
        long delta = end - start;
        System.out.println(delta + " milliseconds to process " + startingDirectory + " with " + collectionList.size
                () + " collections");

        // Print out list of collections from the asset path.
//		for (String collection : collectionList) {
//			System.out.println(collection.substring(10));
//		}

        // Test one collection from the list.
        //Path path = Paths.get("m:\\.");
        //Path path = Paths.get("M:\\assets\\MS 24369");
        Path path = Paths.get("K:\\CHD\\assets\\AV 2");
        //Path path = Paths.get("U:\\assets");

        Long startCollection = System.currentTimeMillis();
        List<ItemFileInfo> itemFileInfoList = new ArrayList<>();
        itemFileInfoList = getItemsList(path, itemFileInfoList);

        long endCollection = System.currentTimeMillis();
        long deltaCollection = endCollection - startCollection;
        System.out.println(deltaCollection + " milliseconds to process " + path.toString());
        System.out.println((deltaCollection / 1000) + " seconds to process " + path.toString());

        for (ItemFileInfo itemFileInfo : itemFileInfoList) {
            System.out.println(itemFileInfo.toString());
        }
    }

    /**
     * Will return a list of directories containing only files given the root path.
     *
     * @param itemPath Item Path
     * @return itemList List of items for given directory
     */
    private static List<ItemFileInfo> getItemsList(Path itemPath, List<ItemFileInfo> itemFileInfo) {

        int counter = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(itemPath)) {

            for (Path path : stream) {
                if (path.toFile().isDirectory()) {
                    getItemsList(path, itemFileInfo);
                } else {
                    counter++;
                }
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }

//		ItemFileInfo tempItemFileInfo = new ItemFileInfo();
//		tempItemFileInfo.setFileName(itemPath.getRoot().getFileName().toString());
//		tempItemFileInfo.setNumFiles(counter);
//		itemFileInfo.add(tempItemFileInfo);
//		if (counter > 0) {
//			System.out.println(counter + " files under: " + itemPath.toString());
//		}
        return itemFileInfo;
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

