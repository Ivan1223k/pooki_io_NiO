import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class assin {
    public static void main(String[] args) {
        String filePath = "input_as.txt";

        try {
            readFileAsync(filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void readFileAsync(String filePath) throws IOException {
        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Paths.get(filePath), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Future<Integer> operation = fileChannel.read(buffer, 0);

            while (!operation.isDone()) {
                System.out.println("Читаем файл асинхронно...");
            }

            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            System.out.println("\nЧтение завершено!");
        }
    }
}