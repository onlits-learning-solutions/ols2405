#include <iostream>
#include <fstream>

using namespace std;

int main(int argc, char const *argv[])
{
    string quote;
    char delimiter = EOF;
    ofstream fout("quotes.txt");
    printf("Write a quote below:\n");
    getline(cin, quote, delimiter);
    fout << quote;
    fout.close();
    return 0;
}
