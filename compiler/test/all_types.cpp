#include <cinttypes>
#include <iostream>
#include <string>

enum class color;

template <class T>
void print(T t);

int32_t add(int32_t a, int32_t b);

int32_t main();

bool b = true;

uint32_t c = 'a';

int8_t sbyte_v = 1;

int16_t short_v = 0;

int32_t int_v;

int64_t long_v;

int8_t int8_v;

int16_t int16_v;

int32_t int32_v;

int64_t int64_v;

uint8_t byte_v;

uint16_t ushort_v;

uint32_t uint_v;

uint64_t ulong_v;

uint8_t uint8_v;

uint16_t uint16_v;

uint32_t uint32_v;

uint64_t uint64_v;

float float_v;

double double_v;

float f32_v;

double f64_v;

std::string string_v = "hello world\n";

std::string string_v_raw = "hello \\n\n    world\\n";

enum class color
{
    red,
    green = 10,
    blue,
};

template <class T>
void print(T t)
{
    std::cout << t << std::endl;
}

int32_t add(int32_t a, int32_t b)
{
    return a + b;
}

int32_t main()
{
    print(add(1, 1));
    return 0;
}

