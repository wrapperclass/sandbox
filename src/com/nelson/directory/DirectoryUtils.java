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
public class DirectoryUtils {

    public static void main(String[] args) {

        String filePath = "/opt/drps/pipeline/dept/CHD/assets/MS 155";

        List<Path> directoriesUnderPath = scan(filePath, getDirectoryFilter());

        List<String> directoriesWithFiles = getDirectoriesWithFiles(directoriesUnderPath);

        for (String path : directoriesWithFiles) {
            System.out.println("Path: " + path);
        }

    }

    public static List<String> getDirectoriesWithFiles(List<Path> pathList) {

        List<String> directoriesWithFiles = new ArrayList<>();

        for (Path path : pathList) {
            directoriesWithFiles.add(path.toString());
        }

        return directoriesWithFiles;
    }

    /**
     * Creates a filter for directories only
     *
     * @return Object which implements DirectoryStream.Filter
     * interface and that accepts directories only.
     */
    public static DirectoryStream.Filter<Path> getDirectoryFilter() {

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
        List<Path> directoriesUnderPath = new ArrayList<>();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir, filter)) {
            //iterate over the filtered content of the directory
            for (Path path : directoryStream) {
                scan(path.toString(), filter);
                directoriesUnderPath.add(path);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return directoriesUnderPath;
    }

}
