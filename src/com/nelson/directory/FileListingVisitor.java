package com.nelson.directory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public final class FileListingVisitor {

    public static void main(String... aArgs) throws IOException {
        String ROOT = "C:\\opt\\drps\\pipeline\\dept\\CHD\\assets";
        FileVisitor<Path> fileProcessor = new ProcessFile();
        Files.walkFileTree(Paths.get(ROOT), fileProcessor);
    }

    private static final class ProcessFile extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path aFile, BasicFileAttributes aAttrs) throws IOException {
            System.out.println("Processing file:" + aFile);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path aDir, BasicFileAttributes aAttrs) throws IOException {
            System.out.println("Processing directory:" + aDir);
            return FileVisitResult.CONTINUE;
        }
    }
}
