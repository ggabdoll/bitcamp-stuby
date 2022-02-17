package com.eomcs.app2.table;

public class ScoreTablePorxy {

  public int insert(Score score) throws Exception {
    try {
      out.writeUTF("inset");
    }
  }


  public static Score[] selectList() {

    try {
      out.writeUTF("selectList");
      out.flush();

      String status = in.readUTF();
    }
  }
}
