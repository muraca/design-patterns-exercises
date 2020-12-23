#ifndef PRINTER_H
#define PRINTER_H

#include <iostream>
#include <string>
#include <unistd.h>
#include "document.h"
class Printer
{
public:
    Printer (std::string n,
             bool bw,
             unsigned int b,
             unsigned int p,
             bool s = true,
             bool f = true,
             unsigned int m = 0,
             unsigned int c = 0,
             unsigned int y = 0) :
    name (n),
    blackWhite (bw),
    black (b),
    paper (p),
    isFree (s),
    functioning (f),
    magenta (m),
    cyan (c),
    yellow (y),
    next (nullptr)
    {};
    
    ~Printer() {};
    
    void print (Document& doc)
    {
        std::cout << "I am " << name;
        
        bool canPrint = true;
        
        unsigned int pages = doc.getNumOfPages();
        
        if (!isFree)
        {
            std::cout << " and I am busy." << std::endl;
            canPrint = false;
        }
        
        else if (!functioning)
        {
            std::cout << " and something is wrong with me." << std::endl;
            canPrint = false;
        }
        
        else if (blackWhite && !doc.isBlackOnly())
        {
            std::cout << ", the document has colours and I am black and white only." << std::endl;
            canPrint = false;
        }
        
        else if (paper < pages)
        {
            std::cout << " and I don't have enough paper." << std::endl;
            canPrint = false;
        }
        
        else if (black < pages)
        {
            std::cout << " and I don't have enough black ink." << std::endl;
            canPrint = false;
        }
        
        else if (magenta < pages)
        {
            std::cout << " and I don't have enough magenta ink." << std::endl;
            canPrint = false;
        }
        
        else if (cyan < pages)
        {
            std::cout << " and I don't have enough cyan ink." << std::endl;
            canPrint = false;
        }
        
        else if (yellow < pages)
        {
            std::cout << " and I don't have enough yellow ink." << std::endl;
            canPrint = false;
        }
        
        if (canPrint)
        {
            std::cout << " and I am printing." << std::endl;
            
            sleep (pages);
            
            if (magenta > 0) {
                magenta -= rand_r (&pages) % magenta;
            }
            
            if (cyan > 0) {
                cyan -= rand_r (&pages) % cyan;
            }
            
            if (yellow > 0) {
                yellow -= rand_r (&pages) % yellow;
            }
            
            black -= rand_r (&pages) % black;
            
            paper -= pages;
            
            if (functioning)
                functioning = rand_r (&pages) % 10 == 0 ? false : true;
            
            std::cout << "Your document has been printed successfully." << std::endl;
        }
        else
        {
            next -> print (doc);
        }
            
    };
    
    void setNext (Printer* p)
    {
        next = p;
    };
    
    
private:
    
    std::string name;
    bool blackWhite;
    unsigned int black;
    unsigned int paper;
    bool isFree;
    bool functioning;
    unsigned int magenta;
    unsigned int cyan;
    unsigned int yellow;
    
    Printer* next;
};



#endif
