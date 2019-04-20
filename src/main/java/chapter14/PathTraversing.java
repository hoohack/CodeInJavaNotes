package chapter14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 多层遍历.zip文件
 */
public class PathTraversing {

    public static void main(String[] args) throws IOException {
        String glob = "*.zip";

        String pathName = "/Users/hoohack/Downloads";

        Path visitPath = Paths.get(pathName);
        Files.walkFileTree(visitPath, new GlobVisitor(glob));

    }

}
