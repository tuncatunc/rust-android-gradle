package com.nishtahir.androidrust;

public class LeafJni {

  // public static native int Java_com_nishtahir_androidrust_LeafJni_leaf_1run_1with_1options(
  private static native int leaf_run_with_options(
    short rt_id,
    String config_path,
    boolean auto_reload,
    boolean multi_thread,
    boolean auto_threads,
    int threads,
    int stack_size
  );

  private static native int leaf_run(
    short rt_id, 
    String config_path
  );

  private static native int leaf_run_with_config_string(
    short rt_id, 
    String config_path
  );

  private static native int leaf_reload(
    short rt_id
  );

  private static native int leaf_shutdown(
    short rt_id
  );

  private static native int leaf_test_config(
    String config_path
  );

  static {
    System.loadLibrary("leafffi");

    try {
      int status;
      status = leaf_run((short) 1, "config.toml");
      System.out.println("leaf_run successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
              "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

    try {
      int status;
      status =
        leaf_run_with_options(
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
      status = leaf_run_with_config_string((short) 1, "config.toml");
      System.out.println("leaf_run_with_config_string successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
        "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

    try {
      int status;
      status = leaf_reload((short) 1);
      System.out.println("leaf_reload successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
        "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

    try {
      int status;
      status = leaf_shutdown((short) 1);
      System.out.println("leaf_shutdown successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
        "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

    try {
      int status;
      status = leaf_test_config("config.toml");
      System.out.println("leaf_test_config successfully" + status);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      System.out.println(
        "UnsatisfiedLinkError: " + unsatisfiedLinkError.getMessage()
      );
    }

  }
}
