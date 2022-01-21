package com.eomcs;

import java.util.Arrays;
import java.util.Scanner;

public class Console {
  Scanner sc = new Scanner(System.in);

  Command prompt() {
    System.out.printf("> ");
    String[] values = sc.nextLine().split(" ");
    return new Command(values[0], Arrays.copyOfRange(values, 1, values.length));
  }

  void close() {
    sc.close();
  }

}
