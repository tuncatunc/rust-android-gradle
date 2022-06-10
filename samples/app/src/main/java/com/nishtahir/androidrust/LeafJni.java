package com.nishtahir.androidrust;

public class LeafJni {

  private static native int leafRunWithOptions(
    short rt_id,
    String config_path,
    boolean auto_reload,
    boolean multi_thread,
    boolean auto_threads,
    int threads,
    int stack_size
  );

  private static native int leafRun(
    short rt_id, 
    String config_path
  );

  private static native int hello();

  private static native int leafRunWithConfigString(
    short rt_id, 
    String config_path
  );

  private static native int leafReload(
    short rt_id
  );

  private static native int leafShutdown(
    short rt_id
  );

  private static native int leafTestConfig(
    String config_path
  );

  static {
    System.loadLibrary("leafffi");

    try {
      int status = hello();
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
              "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }
    try {
      int status;
      status = leafRun((short) 1, "config.toml");
      System.out.println("leaf_run successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
              "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

    try {
      int status;
      status =
      leafRunWithOptions(
          (short) 1,
          "config.toml",
          false,
          false,
          false,
          1,
          100000
        );
      System.out.println("Leaf started successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
        "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

    try {
      int status;
      status = leafRunWithConfigString((short) 1, "config.toml");
      System.out.println("leaf_run_with_config_string successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
        "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

    try {
      int status;
      status = leafReload((short) 1);
      System.out.println("leaf_reload successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
        "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

    try {
      int status;
      status = leafShutdown((short) 1);
      System.out.println("leaf_shutdown successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
        "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

    try {
      int status;
      status = leafTestConfig("config.toml");
      System.out.println("leaf_test_config successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
        "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

  }
}
