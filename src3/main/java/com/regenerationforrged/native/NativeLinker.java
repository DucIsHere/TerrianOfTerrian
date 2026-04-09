package com.regenerationforrged.native;

public class NativeLinker {
    public static void init() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String libName = os.contains("win") ? "native_engine.dll" : "libnative_engine.so";
            String resourcePath = "/natives/" + (os.contains("win") ? "windows_x64/" : "linux_x64/") + libName;

            // 1. Tạo thư mục tạm trong .minecraft/reterra_cache
            Path tempDir = Paths.get("reterra_cache");
            Files.createDirectories(tempDir);
            Path tempLib = tempDir.resolve(libName);

            // 2. Stream file từ JAR ra ngoài
            try (InputStream is = NativeLinker.class.getResourceAsStream(resourcePath)) {
                if (is == null) throw new Exception("Không tìm thấy file native trong JAR!");
                Files.copy(is, tempLib, StandardCopyOption.REPLACE_EXISTING);
            }

            // 3. Nạp thư viện vào JVM
            System.load(tempLib.toAbsolutePath().toString());
            System.out.println("Native Engine (C++) đã sẵn sàng!");

        } catch (Exception e) {
            System.err.println("Lỗi nạp C++: " + e.getMessage());
            // Có thể fallback sang bản Java thuần ở đây nếu nạp C++ thất bại
        }
    }
}