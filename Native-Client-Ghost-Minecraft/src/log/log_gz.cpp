#include <windows.h>
#include <iostream>
#include <fstream>
#include <string>
#include <ctime>
#include <iomanip>
#include <sstream>
#include <atomic>

namespace Logger {
    std::atomic<int> totalChunks(0);
    std::string logFileName = "";

    // Lấy thời gian chuẩn Windows: Phút-Giờ-Ngày-Tháng-Năm
    std::string getWinTimestamp() {
        SYSTEMTIME st;
        GetLocalTime(&st); // Hàm API Windows lấy thời gian chính xác

        std::ostringstream oss;
        oss << std::setfill('0') << std::setw(2) << st.wMinute << "-"
            << std::setfill('0') << std::setw(2) << st.wHour << "-"
            << std::setfill('0') << std::setw(2) << st.wDay << "-"
            << std::setfill('0') << std::setw(2) << st.wMonth << "-"
            << st.wYear;
        return oss.str();
    }

    void write(const std::string& message) {
        if (logFileName.empty()) {
            logFileName = getWinTimestamp() + ".log";
        }

        std::ofstream f(logFileName, std::ios::app);
        if (f.is_open()) {
            f << "[" << getWinTimestamp() << "] " << message << std::endl;
            f.close();
        }
    }

    // Logic đếm chunk cấp số trăm
    void addChunk() {
        int current = ++totalChunks;
        if (current % 100 == 0) {
            write("PROGRESS: Terrain generated " + std::to_string(current) + " chunks.");
        }
    }
}