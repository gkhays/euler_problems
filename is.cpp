#include <iostream>
#include <string>
#include <stdexcept>
#include <algorithm>

class Palindrome
{
public:
    static bool isPalindrome(std::string str)
    {
        std::transform(str.begin(), str.end(), str.begin(), ::tolower);

        str.erase(remove_if(str.begin(), str.end(), isspace), str.end());      

        str.erase(remove_if(str.begin(), str.end(), ispunct), str.end());      

        std::cout << str << std::endl;

        if (equal(str.begin(), str.begin() + str.size()/2, str.rbegin())) {
            return true;
        } else {
            return false;
        std::cout << str << std::endl; 
        }
    }
};

#ifndef RunTests
int main()
{
    std::cout << Palindrome::isPalindrome("Noel sees Leon.") << std::endl;
    std::cout << Palindrome::isPalindrome("ababa") << std::endl;
    std::cout << Palindrome::isPalindrome("Look at my horse, my horse is amazing.") << std::endl;

}
#endif