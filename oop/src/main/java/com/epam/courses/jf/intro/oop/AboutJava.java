package com.epam.courses.jf.intro.oop;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Log4j2
@Getter
@Setter
@Builder
@EqualsAndHashCode()
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class AboutJava {

    @Wither
    int x;
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;

    double y;

    int[] xs;

    @Singular("string")
    List<String> stringList;

    @SneakyThrows
    public static void main(String... args) {
        AboutJava aboutJava = AboutJava.builder()
                .x(1)
                .y(5.5)
                .xs(new int[]{1, 2, 3, 4, 5})
                .a(1)
                .string("dg")
                .string("dg1")
                .string("dg2")
//                .stringList(Arrays.asList("dfg", "wet")) // JDK8
//                .stringList(List.of("dfg", "wet")) //JDK9
                .build();

        int a;
        int b;
        int c;

        //,....

        a = 8 + aboutJava.getX();

        Class.forName("java.lang.Byte");

        System.out.println(aboutJava);
        System.out.println(aboutJava.withX(2));
    }

    void printReleaseData() {
        log.info("Java уже здесь!!!");
    }

    public int[] getXs() {
        return this.xs.clone();
    }

    public String toString() {
        return String.format(
                "AboutJava(x=%d, a=%d, b=%d, c=%d, d=%d, e=%d, f=%d, y=%s, xs=%s, stringList=%s)",
                this.getX(),
                this.getA(),
                this.getB(),
                this.getC(),
                this.getD(),
                this.getE(),
                this.getF(),
                this.getY(),
                java.util.Arrays.toString(this.getXs()),
                this.getStringList());
    }
}
