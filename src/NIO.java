import java.io.*;
import java.nio.file.*;
import java.nio.channels.FileChannel;
//
//public class NIO {
//
//    private static final String INPUT_FILE = "inputi.txt";
//    private static final String OUTPUT_IO = "outputi.txt";
//    private static final String OUTPUT_NIO = "outputni.txt";
//
//    public static void main(String[] args) throws IOException {
//        // Тест I/O
//        long startIO = System.currentTimeMillis();
//        copyFileIO(INPUT_FILE, OUTPUT_IO);
//        long endIO = System.currentTimeMillis();
//        System.out.println("IO Время выполнения: " + (endIO - startIO) + " ms");
//
//        // Тест NIO
//        long startNIO = System.currentTimeMillis();
//        copyFileNIO(INPUT_FILE, OUTPUT_NIO);
//        long endNIO = System.currentTimeMillis();
//        System.out.println("NIO Время выполнения: " + (endNIO - startNIO) + " ms");
//    }
//
//    // Обычное копирование через I/O
//    public static void copyFileIO(String source, String dest) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new FileReader(source));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line);
//                writer.newLine();
//            }
//        }
//    }
//
//    // Копирование через NIO
//    public static void copyFileNIO(String source, String dest) throws IOException {
//        try (FileChannel sourceChannel = FileChannel.open(Paths.get(source), StandardOpenOption.READ);
//             FileChannel destChannel = FileChannel.open(Paths.get(dest), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
//
//            sourceChannel.transferTo(0, sourceChannel.size(), destChannel);
//        }
//    }
//}

import java.io.IOException;

public class NIO {
    public static void main(String[] args) {
        String sourcePath = "copy_input.txt";
        String destPath = "copy_output.txt";

        try {
            copyFile(sourcePath, destPath);
            System.out.println("Файл успешно скопирован.");
        } catch (IOException e) {
            System.err.println("Ошибка копирования файла: " + e.getMessage());
        }
    }

    public static void copyFile(String source, String dest) throws IOException {
        try (FileChannel srcChannel = FileChannel.open(Paths.get(source), StandardOpenOption.READ);
             FileChannel destChannel = FileChannel.open(Paths.get(dest), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            srcChannel.transferTo(0, srcChannel.size(), destChannel);
        }
    }
}