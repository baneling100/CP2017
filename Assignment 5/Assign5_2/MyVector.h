// student name  : Woohyeon Baek
// student number: 2017-15782

#ifndef MYVECTOR_H_INCLUDED
#define MYVECTOR_H_INCLUDED


//Keep in mind that you should also implement more for operator overloading
class MyVector{
    private:
    //You will have more member fields or member functions here
    int VectorSize;
    double *V;

    public:
    MyVector(const double numList[], int size);  //constructor, size>=1
    MyVector();  //empty Vector

    MyVector(const MyVector &vec); //copy constructor

    ~MyVector(); //destructor

    MyVector& operator=(const MyVector &vec);  //assignment operator

    void print() const;  //print its content e.g.  (1, 2, 3, 4)

    //vector-vector operators
    MyVector operator+(const MyVector &vec);
    double   operator*(const MyVector &vec);
    MyVector operator/(const MyVector &vec);
    MyVector operator-(const MyVector &vec);

    //You should add more operators described in the Assignment 5 pdf*

    //vector-scalar operators
    MyVector operator+(double num);
    MyVector operator*(double num);
    MyVector operator/(double num);
    MyVector operator-(double num);

    //You may add more member functions as well
    friend MyVector operator+(double num, const MyVector &vec);
    friend MyVector operator*(double num, const MyVector &vec);
    friend MyVector operator/(double num, const MyVector &vec);
    friend MyVector operator-(double num, const MyVector &vec);
};

//scalar-vector operators
MyVector operator+(double num, const MyVector &vec);
MyVector operator*(double num, const MyVector &vec);
MyVector operator/(double num, const MyVector &vec);
MyVector operator-(double num, const MyVector &vec);

#endif // MYVECTOR_H_INCLUDED
