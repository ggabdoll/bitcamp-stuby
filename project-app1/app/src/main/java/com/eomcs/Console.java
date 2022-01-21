package com.eomcs;

import java.util.Arrays;
import java.util.Scanner;

public class Console {
  static Scanner sc = new Scanner(System.in);

  static Command prompt() {
    System.out.printf("> ");
    String[] values = sc.nextLine().split(" ");
    return new Command(values[0], Arrays.copyOfRange(values, 1, values.length));
  }

  static void close() {
    sc.close();
  }

}
