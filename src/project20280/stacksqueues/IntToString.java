package project20280.stacksqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntToString {
    LinkedStack<Long> ls = new LinkedStack<>();

    String convertToBinary(long dec_num) {
        long remainder = 0;
        String returned = "";
        while (dec_num != 0) {
            remainder = dec_num % 2;
            ls.push(remainder);
            dec_num = dec_num / 2;
        }
        int size = ls.size();
        for (int j = 0; j < size; j++) {
            returned += ls.pop();
        }
        return returned;
    }
    //Divide by other number up through 9 for different base, anything above that can convert to other symbols

    @Test
    void testConvertToBinary() {
        assertEquals("10111", convertToBinary(23));
        assertEquals("111001000000101011000010011101010110110001100010000000000000",
                convertToBinary(1027010000000000000L));
    }
}
