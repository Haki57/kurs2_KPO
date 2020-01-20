package nio.p2_buffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

// TODO: Endian differences and data storage.
//    Термины big-endian и little-endian первоначально не имели отношения к информатике.
//    В сатирическом произведении Джонатана Свифта «Путешествия Гулливера» описываются вымышленные
//    государства Лилипутия и Блефуску, в течение многих лет ведущие между собой войны из-за разногласия
//    по поводу того, с какого конца следует разбивать варёные яйца.
//    Тех, кто считает, что их нужно разбивать с тупого конца, в произведении называют Big-endians ("тупоконечники").
//    Споры между сторонниками big-endian и little-endian ("остроконечники") в информатике также часто носят характер
//    подобных религиозных войн...

public class Sample_1_Endians {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);

        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));


        ByteBuffer b = ByteBuffer.wrap(new byte[4]);
        b.asIntBuffer().put(1);
        System.out.println(Arrays.toString(b.array()));
        b.rewind();
        b.order(ByteOrder.BIG_ENDIAN);
        b.asIntBuffer().put(1);
        System.out.println(Arrays.toString(b.array()));
        b.rewind();
        b.order(ByteOrder.LITTLE_ENDIAN);
        b.asIntBuffer().put(1);
        System.out.println(Arrays.toString(b.array()));
        b.rewind();
    }
}