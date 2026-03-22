package com.regenerationforrged.native;

public class HTFCore {
    public static void loadNative() {
        try {
            // Lấy đường dẫn tuyệt đối đến thư mục chứa game
            String libName = "htf_native_x64.dll"; 
            System.loadLibrary("htf_native_x64");
            System.out.println("[HTF] Da nap thanh cong engine C++!");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("[HTF] Khong tim thay DLL! Luu y bo file vao thu muc goc.");
            // Ban co the code them mot doan tu dong extract tu Jar ra neu can
        }
    }
}