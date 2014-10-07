package com.nelson.directory;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * User: tjnelson
 * Date: 4/16/12
 * Time: 1:37 PM
 */
public class DirectoryUtilsBak {

    static List<Path> directoriesWithFiles = new ArrayList<>();

    public static void main(String[] args) {

        String filePath = "C:\\opt\\drps\\pipeline\\dept\\CHD\\assets";
        List<Path> directories = scan(filePath, getDirectoriesWithFilesFilter());
        for (Path path : directories) {
            System.out.println("path: " + path.toString());
        }

//        List<String> leafNodes = new ArrayList<>();
//        leafNodes = getLeafNodesByPath(filePath, leafNodes);
//
//        for (String leafNode : leafNodes) {
//            System.out.println("Leaf Node(s): " + leafNode);
//        }
    }

//    public static boolean noSubDirectory(String absolutePath) {
//        File assetPath = new File(absolutePath);
//
//        File[] files = assetPath.listFiles();
//        for (File file : files) {
//            if (file.isDirectory()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static List<String> getLeafNodesByPath(String filePath, List<String> leafNodes) {
//
//        if (!filePath.isEmpty()) {
//            File assetPath = new File(filePath);
//            File[] files = assetPath.listFiles();
//
//            if (files != null) {
//                for (File file : files) {
//                    // If it is a directory then call again.
//                    if (file.isDirectory()) {
//                        String absolutePath = file.getAbsolutePath();
//                        //System.out.println("Looking in: " + absolutePath);
//                        List<String> leafAdd = getLeafNodesByPath(absolutePath, leafNodes);
//                        if (noSubDirectory(absolutePath)) {
//                            leafNodes.addAll(leafAdd);
//                        }
//                    }
//                }
//            }
//        }
//        return leafNodes;
//    }

    /**
     * Creates a filter for directories only
     *
     * @return Object which implements DirectoryStream.Filter
     * interface and that accepts directories only.
     */
    public static DirectoryStream.Filter<Path> getDirectoriesWithFilesFilter() {

        DirectoryStream.Filter<Path> filter;
        filter = new DirectoryStream.Filter<Path>() {

            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);

            }
        };

        return filter;
    }

    /**
     * Scans the directory using the filter passed as parameter.
     *
     * @param folder directory to scan
     * @param filter Object which decides whether a
     *               directory entry should be accepted
     */
    private static List<Path> scan(String folder, DirectoryStream.Filter<Path> filter) {
        Path dir = Paths.get(folder);
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir, filter)) {
            //iterate over the filtered content of the directory
            for (Path path : ds) {
                scan(path.toString(), filter);
                directoriesWithFiles.add(path);
                //System.out.println(path.toAbsolutePath());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return directoriesWithFiles;
    }

}
