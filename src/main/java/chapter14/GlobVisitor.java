package chapter14;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.lang.System.out;
import static java.nio.file.FileVisitResult.CONTINUE;

public class GlobVisitor extends SimpleFileVisitor<Path> {

    private final PathMatcher matcher;

    public GlobVisitor(String glob) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + glob);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        visitPath(path);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException exc) {
        return CONTINUE;
    }

    private void visitPath(Path visitPath) {

        Path name = visitPath.getFileName();
        if (name != null && matcher.matches(name)) {
            out.println(visitPath);
        }
    }

}
