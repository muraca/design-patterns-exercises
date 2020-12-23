#ifndef CHAIN_H
#define CHAIN_H

#include "printer.h"
#include "document.h"

class ChainOfPrinters
{
public:
    ChainOfPrinters(bool cc = false) :
    first (nullptr), last (nullptr), isCircular (cc)
    {};
    ~ChainOfPrinters() {};
    
    void addPrinter (Printer* p)
    {
        if (first == nullptr)
        {
            first = p;
            last = p;
        }
        else
        {
            last -> setNext (p);
            last = p;
            if (isCircular)
                last -> setNext (first);
        }
    };
    
    void print (Document& doc)
    {
        first -> print (doc);
    };
private:
    Printer* first;
    Printer* last;
    
    bool isCircular;
};


#endif
