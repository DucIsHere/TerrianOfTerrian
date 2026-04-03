#include <iostream>
#include <vector>
#include <string>
#include <ctime>
#include <cmath>
#include <iomanip>
#include <openssl/hmac.h>
#include <openssl/evp.h>

// 1. Hàm giải mã Base32 sang Binary (Rất quan trọng)
std::vector<uint8_t> decodeBase32(const std::string& base32) {
    const std::string alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
    std::vector<uint8_t> buffer;
    int bitsLeft = 0;
    uint32_t currentByte = 0;

    for (char c : base32) {
        if (c == ' ' || c == '=') continue;
        size_t val = alphabet.find(toupper(c));
        if (val == std::string::npos) continue;

        currentByte <<= 5;
        currentByte |= (val & 31);
        bitsLeft += 5;

        if (bitsLeft >= 8) {
            buffer.push_back((currentByte >> (bitsLeft - 8)) & 255);
            bitsLeft -= 8;
        }
    }
    return buffer;
}

// 2. Hàm tính mã TOTP 6 số
void getTOTP(const std::string& secret) {
    // Giải mã Secret Key
    std::vector<uint8_t> key = decodeBase32(secret);

    // Lấy bước thời gian (30 giây)
    uint64_t timer = std::time(nullptr) / 30;
    uint8_t msg[8];
    for (int i = 7; i >= 0; i--) {
        msg[i] = timer & 0xFF;
        timer >>= 8;
    }

    // Tính HMAC-SHA1 sử dụng OpenSSL
    unsigned int len;
    unsigned char hash[20];
    HMAC(EVP_sha1(), key.data(), key.size(), msg, 8, hash, &len);

    // Trích xuất 6 chữ số (Dynamic Truncation)
    int offset = hash[19] & 0xf;
    int truncatedHash = (hash[offset] & 0x7f) << 24
                      | (hash[offset + 1] & 0xff) << 16
                      | (hash[offset + 2] & 0xff) << 8
                      | (hash[offset + 3] & 0xff);

    int otp = truncatedHash % 1000000;

    std::cout << "---------------------------" << std::endl;
    std::cout << "Mã 2FA Tiktok: " << std::setfill('0') << std::setw(6) << otp << std::endl;
    std::cout << "---------------------------" << std::endl;
}

int main() {
    // Secret Key Tiktok của bạn
    std::string tiktokSecret = "3NEJAVB2EFUXF27WCKUDK5KOHWTBXFQG";
    
    getTOTP(tiktokSecret);
    
    return 0;
}
