#include <iostream>
#include <filesystem> // Thư viện quét file
#include <chrono>     // Thư viện đo thời gian
#include <string>

using namespace std;
namespace fs = std::filesystem;

int main() {
    string path = "."; // Quét ở thư mục hiện tại
    int count = 0;

    auto start = chrono::high_resolution_clock::now(); // Bắt đầu đo

    // Duyệt qua tất cả file trong thư mục
    for (const auto& entry : fs::recursive_directory_iterator(path)) {
        if (entry.is_regular_file()) {
            string ext = entry.path().extension().string();
            // Kiểm tra đuôi file
            if (ext == ".java" || ext == ".kt" || ext == ".json") {
                cout << "Found: " << entry.path().filename() << "\n";
                count++;
            }
        }
    }

    auto end = chrono::high_resolution_clock::now(); // Kết thúc đo
    chrono::duration<double, millisecond> elapsed = end - start;

    cout << "--------------------------\n";
    cout << "Tong cong: " << count << " files.\n";
    cout << "Thoi gian chay: " << elapsed.count() << " ms.\n";

    return 0;
}