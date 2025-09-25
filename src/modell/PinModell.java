
package modell;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PinModell {
    private StringBuilder pin = new StringBuilder();
    private final int PIN_LENGTH = 4;

    public boolean addDigit(char digit) {
        if (pin.length() < PIN_LENGTH) {
            pin.append(digit);
            return true;
        }
        return false;
    }

    public boolean isComplete() {
        return pin.length() == PIN_LENGTH;
    }

    public String getPin() {
        return pin.toString();
    }

    public void reset() {
        pin.setLength(0);
    }

    public void saveToFile() throws IOException {
        Path path = Paths.get("pin.txt");
        Files.writeString(path, pin.toString());
    }
}

