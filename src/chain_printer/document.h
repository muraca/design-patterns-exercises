#ifndef DOC_H
#define DOC_H

class Document
{
public:
    Document (unsigned int n = 1, bool b = true) :
    numOfPages (n), blackOnly (b) {};
    
    ~Document() {};
    
    
    unsigned int getNumOfPages()
    {
        return numOfPages;
    };
    
    bool isBlackOnly()
    {
        return blackOnly;
    };
    
private:
    unsigned int numOfPages;
    bool blackOnly;
};


#endif
