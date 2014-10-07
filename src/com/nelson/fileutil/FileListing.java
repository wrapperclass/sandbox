package com.nelson.fileutil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Recursive file listing under a specified directory.
 */
public final class FileListing {

    /**
     * Demonstrate use.
     *
     * @param aArgs - <tt>aArgs[0]</tt> is the full name of an existing
     *              directory that can be read.
     */
    public static void main(String... aArgs) throws FileNotFoundException {
        //File startingDirectory = new File("M:\\assets");
        File startingDirectory = new File("C:\\data\\dept\\CHD\\assets\\MS 1307");
        //File startingDirectory = new File("C:\\\\data\\\\dept\\\\CHD\\\\assets\\\\MS 1307D");

        Long start = System.currentTimeMillis();
        List<File> files = FileListing.getFileListing(startingDirectory);

        Long end = System.currentTimeMillis();
        Long time = ((end - start) / 1000);
        //print out all file names, in the the order of File.compareTo()
//		for (File file : files) {
//			System.out.println(file);
//		}

        System.out.println("Num Files: " + files.size() + " in " + time + " seconds");
    }

    /**
     * Recursively walk a directory tree and return a List of all
     * Files found; the List is sorted using File.compareTo().
     *
     * @param aStartingDir is a valid directory, which can be read.
     */
    static public List<File> getFileListing(File aStartingDir) throws FileNotFoundException {
//			DirectoryIteratorException, IOException {
        validateDirectory(aStartingDir);
        List<File> result = getFileListingNoSort(aStartingDir);
//		List<Path> listSourceFiles(Path aStartingDir) throws IOException {
//			List<Path> result = new ArrayList<>();
//			try (DirectoryStream<Path> stream = Files.newDirectoryStream(aStartingDir, "*.{c,h,cpp,hpp,java}")) {
//				for (Path entry: stream) {
//					result.add(entry);
//				}
//			} catch (DirectoryIteratorException ex) {
//				// I/O error encounted during the iteration, the cause is an IOException
//				throw ex.getCause();
//			}
//			return result;
//		}
        Collections.sort(result);
        return result;
    }

    /**
     * Recursively walk a directory tree and return a List of all
     * Directories found; the List is sorted using File.compareTo().
     *
     * @param aStartingDir is a valid directory, which can be read.
     */
    static public List<File> getDirectoryListing(File aStartingDir) throws FileNotFoundException {
        validateDirectory(aStartingDir);
        List<File> result = getFileListingNoSort(aStartingDir);
        Collections.sort(result);
        return result;
    }

    // PRIVATE //
    static private List<File> getFileListingNoSort(File aStartingDir) throws FileNotFoundException {
        List<File> result = new ArrayList<>();
        File[] filesAndDirs = aStartingDir.listFiles();

        if (filesAndDirs != null) {

            List<File> filesDirs = Arrays.asList(filesAndDirs);

            for (File file : filesDirs) {
                result.add(file); //always add, even if directory
                if (!file.isFile()) {
                    //must be a directory
                    //recursive call!
                    List<File> deeperList = getFileListingNoSort(file);
                    result.addAll(deeperList);
                }
            }
        }

        return result;
    }

    // PRIVATE //
    static private List<File> getDirectoryListingNoSort(File aStartingDir) throws FileNotFoundException {
        List<File> result = new ArrayList<>();
        File[] filesAndDirs = aStartingDir.listFiles();

        if (filesAndDirs != null) {

            List<File> filesDirs = Arrays.asList(filesAndDirs);

            for (File file : filesDirs) {
                result.add(file); //always add, even if directory
                if (!file.isFile()) {
                    //must be a directory
                    //recursive call!
                    List<File> deeperList = getFileListingNoSort(file);
                    result.addAll(deeperList);
                }
            }
        }

        return result;
    }

    /**
     * Directory is valid if it exists, does not represent a file, and can be read.
     */
    static private void validateDirectory(File aDirectory) throws FileNotFoundException {
        if (aDirectory == null) {
            throw new IllegalArgumentException("Directory should not be null.");
        }
        if (!aDirectory.exists()) {
            throw new FileNotFoundException("Directory does not exist: " + aDirectory);
        }
        if (!aDirectory.isDirectory()) {
            throw new IllegalArgumentException("Is not a directory: " + aDirectory);
        }
        if (!aDirectory.canRead()) {
            throw new IllegalArgumentException("Directory cannot be read: " + aDirectory);
        }
    }
}
